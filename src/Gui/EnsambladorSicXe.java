package Gui;

import App.CargadorLigador;
import App.Intermedio;
import App.ProgramaObjeto;
import sintaxis.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class EnsambladorSicXe {
    private Gui ventana;
    private File archivoFuente;
    private final ArrayList<String> listaErrores;
    private ArrayList<String> tipoErrores;
    private ArrayList<Integer> lineasErrores;
    private ArrayList<String> lineasArchivo;
    private boolean hayErrores;
    private ArrayList<Instruccion> instrucciones;
    private ArrayList<Object[]> filasTabla;
    private File archivoIntermedio;
    private DefaultTableModel modeloTabla;
    private boolean paso1;
    private Intermedio archInt;
    private File archivoSalida;
    private Analizador analizador;
    private boolean alertaSobreescritura;
    private ArrayList<ProgramaObjeto> listaProgs;

    public EnsambladorSicXe(){
        listaErrores = new ArrayList<>();
        tipoErrores = new ArrayList<>();
        lineasErrores = new ArrayList<>();
        instrucciones = new ArrayList<>();
        filasTabla = new ArrayList<>();
        hayErrores = false;
        paso1 = false;
        alertaSobreescritura = false;
        ventana = new Gui();
        eventosBotonesMenu();
        eventosBotones();
        ventana.setVisible(true);
    }

    private void eventosBotones(){
        ventana.analisisSintBtn.addActionListener(actionEvent ->{
            analisisSintactico();
            ventana.paso1Btn.setEnabled(true);
        });
        ventana.paso1Btn.addActionListener(actionEvent -> {
            paso1();
            ventana.paso2Btn.setEnabled(true);
        });
        ventana.paso2Btn.addActionListener(actionEvent -> {
            paso2();
        });
        ventana.ensamblarBtn.addActionListener(actionEvent -> {
            analisisSintactico();
            paso1();
            paso2();
        });
        ventana.cargarBtn.addActionListener(actionEvent -> {
            cargarProgramas();
        });
        ventana.simularBtn.addActionListener(actionEvent -> {
            ligarProgramas();
        });
    }

    private void eventosBotonesMenu(){
        ventana.btnNvoArchivo.addActionListener(actionEvent ->{
            JFileChooser explorador = exploradorGuardar();
            archivoFuente = explorador.getSelectedFile();
        });
        ventana.btnAbrirArchivo.addActionListener(actionEvent ->{
            JFileChooser explorador = abrirExplorador();
            archivoFuente = explorador.getSelectedFile();
            if(archivoFuente == null || archivoFuente.getName().equals("")){
                throw new Error("Hubo un error al abrir el archivo");
            }
            llenaEditor();
        });
        ventana.btnGuardarArch.addActionListener(actionEvent ->{
            guardaArchivo();
        });
        ventana.btnGuardarComo.addActionListener(actionEvent ->{
            JFileChooser explorador = exploradorGuardarComo();
            archivoFuente = explorador.getSelectedFile();
            guardaArchivo();
        });
    }

    private void guardaArchivo(){
        if(!ventana.areaTexto.getText().equals("")){
            try {
                PrintWriter wr = new PrintWriter(archivoFuente);
                wr.write(ventana.areaTexto.getText());
                wr.close();
                archivoFuente.createNewFile();
                JOptionPane.showMessageDialog(ventana,"??Archivo guardado con ??xito!");
            } catch (FileNotFoundException e) {
                System.out.println("Error al escribir el archivo");
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            JOptionPane.showMessageDialog(ventana,"El archivo est?? vac??o","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenaEditor(){
        try {
            Scanner sc = new Scanner(archivoFuente);
            StringBuilder texto = new StringBuilder();
            while (sc.hasNext()){
                String linea = ventana.areaTexto.getText() + sc.nextLine() + "\n";
                texto.append(linea);
            }
            ventana.areaTexto.setText(texto.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
            throw new RuntimeException(e);
        }
    }

    private void analisisSintactico(){
        ventana.lblLineasErrores.setText("");
        analizador = new Analizador(ventana.areaTexto.getText(),this.archivoFuente.getName());
        lineasErrores = analizador.lineasErrores;
        ventana.noErrores.setText(String.valueOf(lineasErrores.size()));
        instrucciones = analizador.listaInstrucciones();
        this.archivoSalida = analizador.obtenArchivoSalida();
        this.tipoErrores = analizador.getTipoErrores();
        if(lineasErrores.size() > 0){
            StringBuilder lineasE = new StringBuilder("<html><body>");
            lineasE.append("Lineas: ");
            for (int noLinea : lineasErrores) {
                String linea = noLinea + ", ";
                lineasE.append(linea);
            }
            lineasE.append("</body></html>");
            ventana.lblLineasErrores.setText(lineasE.toString());
        }
        ventana.panelDividido.setDividerLocation(120);
        this.paso1 = true;
    }

    private void escribeArchivo(){
        try {
            PrintWriter writer = new PrintWriter(this.archivoFuente);
            writer.write(ventana.areaTexto.getText());
            writer.close();
            this.archivoFuente.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void paso1(){
        if (paso1){
            if(!archivoFuente.exists()) escribeArchivo();

            archInt = new Intermedio(instrucciones, archivoFuente, lineasErrores, tipoErrores);
            archivoIntermedio = archInt.archivoIntermedio();
            lineasArchivo = archInt.lineasArchivo;
            JTable tablaPaso1 = ventana.jTable2;
            ArrayList<Simbolo> tabsimbs = archInt.tablaSimbolos;
            modeloTabla = (DefaultTableModel) tablaPaso1.getModel();
            Object[] fila;
            for (String linea : lineasArchivo) {
                String[] elementos = linea.split("\t+");
                if(elementos.length < 5){
                    fila = new Object[]{elementos[0],"",elementos[1],elementos[2],"-----"};
                    modeloTabla.addRow(fila);
                    filasTabla.add(fila);
                }else{
                    if(elementos[elementos.length -1].contains("Error"))
                        fila = new Object[]{elementos[0],elementos[1],elementos[2],elementos[3],elementos[elementos.length -1]};
                    else
                        fila = new Object[]{elementos[0],elementos[1],elementos[2],elementos[3],"-----"};
                    modeloTabla.addRow(fila);
                    filasTabla.add(fila);
                }
            }
            LinkedHashMap<String, String> tabsim =  archInt.tabsim;
            Iterator<String> iterador = tabsim.keySet().iterator();
            DefaultTableModel tablaTabsim = (DefaultTableModel) ventana.tabsim.getModel();

            for (Simbolo simb : tabsimbs) {
                fila = new Object[]{simb.nombre,simb.dirOSimbolo,simb.relativo ? "R" : "A"};
                tablaTabsim.addRow(fila);
            }
            ventana.jTabbedPane1.setSelectedIndex(1);
            //ventana.panelResultados.setVisible(true);
            //ventana.pack();
        }
    }
    private void paso2(){
        ventana.areaCodobj.setText("");
        ProgramaObjeto pO = new ProgramaObjeto(archInt.getCodigoObjeto(),archivoSalida.getName(), archInt.tablaSimbolos);

        while (modeloTabla.getRowCount() > 0) { modeloTabla.removeRow(0); }

        int cont = 0;
        for (String linea : lineasArchivo) {
            String[] elementos = linea.split("\t+");
            Object[] fila = filasTabla.get(cont++);
            fila[fila.length - 1] = elementos[elementos.length -1];
            modeloTabla.addRow(fila);
        }
        StringBuilder codobj = new StringBuilder();
        for (String cadena : pO.registroH.values()){
            codobj.append(cadena);
        }
        codobj.append("\n");
        for (HashMap<String,String> registro : pO.registrosT){
            for (String cadena : registro.values()){
                codobj.append(cadena);
            }
            codobj.append("\n");
        }
        for (HashMap<String,String> registro : pO.registrosM){
            for (String cadena : registro.values()){
                codobj.append(cadena);
            }
            codobj.append("\n");
        }
        for (String cadena : pO.registroE.values()){
            codobj.append(cadena);
        }
        ventana.areaCodobj.setText(codobj.toString());
        ventana.areaPObjs.setText(codobj.toString());
        ventana.areaPObjs.setEnabled(false);
    }
    private void cargarProgramas(){
        String texto = ventana.areaPObjs.getText();
        String[] lineas = texto.split("\n");
        listaProgs = new ArrayList<>();
        ProgramaObjeto pO = null;
        ArrayList<String> programas = new ArrayList<>();
        for(String linea : lineas){
            String[] elementos = linea.split("");
            String primero = elementos[0];
            switch (primero){
                case "": continue;
                case "R":
                    pO.creaRR(linea);
                    break;
                case "D":
                    pO.creaRD(linea);
                    break;
                case "H":
                    pO = new ProgramaObjeto();
                    pO.creaRH(linea);
                    programas.add(pO.registroH.get("Nombre"));
                    break;
                case "T":
                    assert pO != null;
                    pO.creaRT(linea);
                    break;
                case "M":
                    assert pO != null;
                    pO.creaRM(linea);
                    break;
                case "E":
                    assert pO != null;
                    pO.creaRE(linea);
                    listaProgs.add(pO);
                    break;
            }
        }


        ventana.opcionesProgs.setModel(new javax.swing.DefaultComboBoxModel<>(programas.toArray(String[]::new)));

    }
    private void ligarProgramas(){
        String dirInicio = ventana.inputTamProg.getText();
        if(dirInicio.isEmpty() || dirInicio.isBlank()){
            JOptionPane.showMessageDialog(ventana,"Debe colocar la direcci??n de inicio", "Error",JOptionPane.ERROR_MESSAGE);
        }else{
            CargadorLigador cargador = new CargadorLigador(this.listaProgs,dirInicio);
            LinkedHashMap<String, ArrayList<String>> tabse = cargador.getTabse();
            LinkedHashMap<String, ArrayList<String>> mapMem = cargador.getMapaMem();
            int tamanos = tabse.get("SC").size();
            DefaultTableModel modeloTabse = (DefaultTableModel) ventana.tabse.getModel();
            DefaultTableModel modeloMapaMem = (DefaultTableModel) ventana.mapaMem.getModel();
            ArrayList<String> fila;
            for(int i = 0; i < tamanos; i++){
                fila = new ArrayList<>();
                for (ArrayList<String> columna : tabse.values()){
                    fila.add(columna.get(i));
                }
                modeloTabse.addRow(fila.toArray());
            }
            for(String direccion : mapMem.keySet()){
                ArrayList<String> lista = mapMem.get(direccion);
                fila = new ArrayList<>();
                fila.add(direccion);
                fila.addAll(lista);
                modeloMapaMem.addRow(fila.toArray());
            }
        }
    }
    private JFileChooser exploradorGuardar(){
        JFileChooser selection = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de programa SIC-XE","xe");
        selection.setFileFilter(filtro);
        selection.setDialogTitle("Nuevo archivo");
        selection.setDialogType(JFileChooser.SAVE_DIALOG);
        int respuesta = selection.showSaveDialog(ventana);
        switch(respuesta){
            case JFileChooser.APPROVE_OPTION:
                ventana.areaTexto.setEnabled(true);
                ventana.areaTexto.setText("");
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Cancelado");
                break;
            default :
                System.out.println("Error");
                break;
        }
        return selection;
    }
    private JFileChooser exploradorGuardarComo(){
        JFileChooser selection = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de programa SIC-XE","xe");
        selection.setFileFilter(filtro);
        selection.setDialogTitle("Guardar como...");
        selection.setDialogType(JFileChooser.SAVE_DIALOG);
        int respuesta = selection.showSaveDialog(ventana);
        switch(respuesta){
            case JFileChooser.APPROVE_OPTION:
                System.out.println("Todo bien");
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Cancelado");
                break;
            default :
                System.out.println("Error");
                break;
        }
        return selection;
    }
    private JFileChooser abrirExplorador(){
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de programa SIC-XE","xe");
        selector.setFileFilter(filtro);
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selector.showOpenDialog(ventana);
        ventana.areaTexto.setEnabled(true);
        return selector;
    }
}

package Gui;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import sintaxis.Instruccion;
import sintaxis.sicstdLexer;
import sintaxis.sicstdParser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.View;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class EnsambladorSicXe {
    private Gui ventana;
    private File archivoFuente;
    private final ArrayList<String> listaErrores;
    private final ArrayList<String> tipoErrores;
    private final ArrayList<Integer> lineasErrores;
    private boolean hayErrores;
    private ArrayList<Instruccion> instrucciones;

    public EnsambladorSicXe(){
        listaErrores = new ArrayList<>();
        tipoErrores = new ArrayList<>();
        lineasErrores = new ArrayList<>();
        instrucciones = new ArrayList<>();
        hayErrores = false;
        ventana = new Gui();
        eventosBotonesMenu();
        eventosBotones();
        //ventana.panelResultados.setVisible(true);
        //ventana.pack();
        ventana.setVisible(true);
    }

    private void eventosBotones(){
        ventana.analisisSintBtn.addActionListener(actionEvent ->{
            analisisSintactico();
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
                JOptionPane.showMessageDialog(ventana,"¡Archivo guardado con éxito!");
            } catch (FileNotFoundException e) {
                System.out.println("Error al escribir el archivo");
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("Algo pasa xd");
                throw new RuntimeException(e);
            }
        }else{
            JOptionPane.showMessageDialog(ventana,"El archivo está vacío","Error",JOptionPane.ERROR_MESSAGE);
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
        ANTLRInputStream entrada = new ANTLRInputStream(ventana.areaTexto.getText());
        sicstdLexer lexer = new sicstdLexer(entrada);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        sicstdParser parser = new sicstdParser(tokens);
        ANTLRErrorListener errorListener = errores();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        parser.programa();
        instrucciones = parser.listaInstrucciones;
        ventana.noErrores.setText(String.valueOf(lineasErrores.size()));
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
    }
    private ANTLRErrorListener errores() {
        return new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                if(s.contains("no viable alternative at input")){
                    tipoErrores.add("Error: Símbolo no encontrado");
                }else tipoErrores.add("Error: sintaxis");
                String error = "Error en línea: " + i + " " + s;
                if(!listaErrores.contains(error)){
                    listaErrores.add(error);
                    lineasErrores.add(i);
                }
                hayErrores = true;
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                //System.out.println("Hay ambigüedad");
            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                //System.out.println("Algo del full context");
            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                //System.out.println("Algo del context sensitivity");
            }
        };
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

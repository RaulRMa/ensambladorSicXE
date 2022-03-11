package Gui;

import App.Intermedio;
import sintaxis.Analizador;
import sintaxis.Instruccion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Principal extends JFrame{
    private JPanel panelPrincipal;
    private JButton abrirArchivoButton;
    private JLabel lbl_resultado;
    private JButton btnAbrirArchvoErr;
    private JButton btnArbrirUbArch;
    private JButton btnArchivoInt;
    private JButton btnAbrirUbInt;
    private JButton btnAbrirAInt;
    private File archivoFuente;
    private File archivoSalida;
    private File archivoIntermedio;
    private Analizador analizador;
    private boolean errores;

    public Principal() {
        errores = false;
        setContentPane(panelPrincipal);
        setTitle("Analizador léxico sintáctico");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        accionesBoton();
        setLocation(200,300);
        setMaximumSize(new Dimension(500,300));
        setMinimumSize(new Dimension(500,300));
    }

    private void accionesBoton(){
        abrirArchivoButton.addActionListener(actionEvent -> {
            btnArchivoInt.setVisible(false);
            lbl_resultado.setVisible(false);
            btnArbrirUbArch.setVisible(false);
            btnAbrirArchvoErr.setVisible(false);
            btnAbrirAInt.setVisible(false);
            btnAbrirUbInt.setVisible(false);
            JFileChooser explorador = abrirExplorador();
            archivoFuente = explorador.getSelectedFile();
            if(archivoFuente == null || archivoFuente.getName().equals("")){
                throw new Error("Hubo un error al abrir el archivo");
            }
            analiza();
            btnArchivoInt.setVisible(true);
        });
        btnAbrirArchvoErr.addActionListener( actionEvent -> {
            try {
                abreArchivo(archivoSalida);
            }catch (Exception e){
                muestraError("Falló al intentar abrir el archivo","Error");
                e.printStackTrace();
            }
        });
        btnArbrirUbArch.addActionListener(actionEvent -> {
            try{
               expArchivos(archivoSalida);
            }catch (Exception e){
                muestraError("Falló al intentar abrir la ubicación del archivo","Error");
                e.printStackTrace();
            }
        });
        btnArchivoInt.addActionListener(actionEvent -> {
            generaIntermedio();
        });
        btnAbrirUbInt.addActionListener(actionEvent -> {
            try {
                expArchivos(archivoIntermedio);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        btnAbrirAInt.addActionListener(actionEvent -> {
            try {
                abreArchivo(archivoIntermedio);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    private void analiza(){
        analizador = new Analizador(this.archivoFuente);
        errores = analizador.hayErrores();
        archivoSalida = analizador.obtenArchivoSalida();
        elementosErrores();
    }

    private void expArchivos(File archivo) throws IOException, InterruptedException {
        String os = System.getProperty("os.name");
        String[] parametros = new String[2];
        parametros[0]
                = Objects.equals(os, "Linux") ? "nautilus" : "notepad.exe";
        parametros[1] = archivo.getCanonicalPath();

        Process proceso = Runtime.getRuntime().exec(parametros, null);
        proceso.waitFor();
    }

    private void abreArchivo(File archivo) throws IOException, InterruptedException {
        String os = System.getProperty("os.name");
        String[] parametros = new String[2];
        parametros[0] = Objects.equals(os, "Linux") ? "gedit" : "notepad.exe";
        parametros[1] = archivo.getAbsolutePath();

        Process proceso = Runtime.getRuntime().exec(parametros,null);
        proceso.waitFor();
    }

    private void generaIntermedio() {
        ArrayList<Integer> lineas = analizador.lineasErr();
        ArrayList<Instruccion> instrucciones = analizador.listaInstrucciones();
        Intermedio archInt = new Intermedio(instrucciones, archivoFuente, lineas);
        archivoIntermedio = archInt.archivoIntermedio();
        if(archivoIntermedio != null){
            btnAbrirAInt.setVisible(true);
            btnAbrirUbInt.setVisible(true);
        }
    }

    private void elementosErrores(){
        lbl_resultado.setVisible(true);
        if(errores){
            lbl_resultado.setText("Se encontraron algunos errores en el archivo");
            btnAbrirArchvoErr.setVisible(true);
            btnArbrirUbArch.setVisible(true);
        }else{
            lbl_resultado.setText("No se encontraron errores en el archivo");
        }
    }

    private JFileChooser abrirExplorador(){
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de programa SIC-XE","xe");
        selector.setFileFilter(filtro);
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selector.showOpenDialog(this);
        return selector;
    }

    private void muestraError(String mensaje, String nombreError){
        JOptionPane.showMessageDialog(this,mensaje, nombreError, JOptionPane.ERROR_MESSAGE);
    }

}
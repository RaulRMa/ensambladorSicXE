package Gui;

import sintaxis.Analizador;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Principal extends JFrame{
    private JPanel panelPrincipal;
    private JButton abrirArchivoButton;
    private JLabel lbl_resultado;
    private JButton btnAbrirArchvoErr;
    private JButton btnArbrirUbArch;
    private File archivoFuente;
    private File archivoSalida;
    private Analizador analizador;
    private boolean errores;

    public Principal() {
        errores = false;
        setContentPane(panelPrincipal);
        setTitle("Analizador léxico sintáctico");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        accionesBoton();
    }

    private void accionesBoton(){
        abrirArchivoButton.addActionListener(actionEvent -> {
            lbl_resultado.setVisible(false);
            JFileChooser explorador = abrirExplorador();
            archivoFuente = explorador.getSelectedFile();
            if(archivoFuente == null || archivoFuente.getName().equals("")){
                throw new Error("Hubo un error al abrir el archivo");
            }
            analiza();
        });
        btnAbrirArchvoErr.addActionListener( actionEvent -> {
            try {
                String os = System.getProperty("os.name");
                String[] parametros = new String[2];
                parametros[0] = Objects.equals(os, "Linux") ? "gedit" : "notepad.exe";
                parametros[1] = analizador.obtenArchivoSalida().getAbsolutePath();

                Process proceso = Runtime.getRuntime().exec(parametros,null);
                proceso.waitFor();
            }catch (Exception e){
                muestraError("Falló al intentar abrir el archivo","Error");
                e.printStackTrace();
            }
        });
        btnArbrirUbArch.addActionListener(actionEvent -> {
            try{
                String os = System.getProperty("os.name");
                String[] parametros = new String[2];
                parametros[0]
                        = Objects.equals(os, "Linux") ? "nautilus" : "notepad.exe";
                parametros[1] = archivoSalida.getCanonicalPath();

                Process proceso = Runtime.getRuntime().exec(parametros, null);
                proceso.waitFor();
            }catch (Exception e){
                muestraError("Falló al intentar abrir la ubicación del archivo","Error");
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
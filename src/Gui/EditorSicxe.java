package Gui;

import javax.swing.*;
import java.awt.*;

public class EditorSicxe extends JFrame{
    private JPanel panelP;

    public EditorSicxe(){
        //createUIComponents();
        setTitle("Analizador léxico sintáctico");
        this.setLayout(null);
        setBounds(10,10,1000,800);
        setSize(800,600);
        this.setLocationRelativeTo(null);
        setLocation(200,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

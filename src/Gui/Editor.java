package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Editor extends JFrame {
    private JPanel panelP;
    private JPanel menu;
    public Editor(){
        setBounds(100,100,1280,720);
        setMaximumSize(new Dimension(1280,720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciaComponentes();
        setVisible(true);
    }

    private void iniciaComponentes(){
        panelPrincipal();
        iniciaMenu();
    }

    private void panelPrincipal(){
        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBounds(0,0,this.getWidth(), this.getHeight());
        panelP.setBackground(Color.black);
        this.setContentPane(panelP);
    }

    private void iniciaMenu(){
        menu = new JPanel();
        menu.setBounds(0,0,100, panelP.getHeight());
        menu.setBackground(new Color(39,39,49));
        menu.setLayout(null);
        btnsMenu();
        panelP.add(menu);
    }

    private void btnsMenu(){
        int posY = 30; int posX = 20;
        int ancho = 60; int alto = 70;
        JButton btnAbrirArch, btnGuardarArch, btnNvoArch;
        btnAbrirArch = new JButton("Abrir archivo");
        btnGuardarArch = new JButton("Guardar archivo");
        btnNvoArch = new JButton("Nuevo archivo");
        btnAbrirArch.setBounds(posX,posY,ancho,alto);
        btnGuardarArch.setBounds(posX, posY+ alto + 10,ancho,alto);
        btnNvoArch.setBounds(posX,posY *2 + (alto *2) + 10, ancho,alto);
        menu.add(btnAbrirArch);
        menu.add(btnGuardarArch);
        menu.add(btnNvoArch);
    }
}

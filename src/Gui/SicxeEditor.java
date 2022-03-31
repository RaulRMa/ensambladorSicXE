package Gui;

import javax.swing.*;
import java.awt.*;

public class SicxeEditor  extends JFrame{
    private JPanel LeftBar;
    private JToolBar Menu;

    public SicxeEditor(){
        createUIComponents();
        setContentPane(LeftBar);
        setTitle("Analizador léxico sintáctico");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(200,300);
        setMaximumSize(new Dimension(500,300));
        setMinimumSize(new Dimension(500,300));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        creaBarra();
        LeftBar = new JPanel();
        LeftBar.setBounds(40,80,200,200);
        LeftBar.setBackground(Color.GRAY);
        LeftBar.add(Menu,BorderLayout.NORTH);
    }

    private void creaBarra(){
        Menu = new JToolBar();
        Menu.setRollover(true);
        Menu.add(new JButton("File"));
    }
}

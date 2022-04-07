/*
 * Created by JFormDesigner on Tue Apr 05 12:13:36 CDT 2022
 */

package Gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

/**
 * @author unknown
 */
public class SICXeEditor extends JFrame {
    public SICXeEditor() {
        initComponents();
        accionesBotones();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Raul
        panel1 = new JPanel();
        nvoArch = new JButton();
        abrirArch = new JButton();
        nvoArch2 = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        opAnalizar = new JMenuItem();
        opPaso1 = new JMenuItem();
        opPaso2 = new JMenuItem();
        opEnsamblar = new JMenuItem();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(39, 39, 49));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder (
            new javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e"
            , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 )
            ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            panel1.setLayout(null);

            //---- nvoArch ----
            nvoArch.setText("+");
            nvoArch.setFont(new Font("Fira Sans Book", Font.PLAIN, 30));
            nvoArch.setBackground(new Color(53, 208, 151));
            nvoArch.setForeground(Color.white);
            nvoArch.setToolTipText("Nuevo archivo");
            nvoArch.setBorder(null);
            nvoArch.setBorderPainted(false);
            panel1.add(nvoArch);
            nvoArch.setBounds(0, 0, 100, 65);

            //---- abrirArch ----
            abrirArch.setFont(new Font("Fira Sans Book", Font.PLAIN, 30));
            abrirArch.setBackground(new Color(39, 39, 49));
            abrirArch.setForeground(Color.white);
            abrirArch.setToolTipText("Abrir archivo");
            abrirArch.setIcon(UIManager.getIcon("FileView.directoryIcon"));
            abrirArch.addActionListener(actionEvent -> {
                System.out.println("Botón presionado");
            });
            panel1.add(abrirArch);
            abrirArch.setBounds(0, 65, 100, 65);

            //---- nvoArch2 ----
            nvoArch2.setFont(new Font("Fira Sans Book", Font.PLAIN, 30));
            nvoArch2.setBackground(new Color(39, 39, 49));
            nvoArch2.setForeground(Color.white);
            nvoArch2.setToolTipText("Guardar archivo");
            nvoArch2.setIcon(UIManager.getIcon("FileView.floppyDriveIcon"));
            panel1.add(nvoArch2);
            nvoArch2.setBounds(0, 130, 100, 65);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 100, 640);

        //======== panel2 ========
        {
            panel2.setBackground(new Color(252, 252, 250));
            panel2.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setBackground(Color.white);
                textArea1.setFont(new Font("Cascadia Code", Font.BOLD, 16));
                textArea1.setForeground(Color.black);
                scrollPane1.setViewportView(textArea1);
            }
            panel2.add(scrollPane1);
            scrollPane1.setBounds(15, 65, 850, 555);

            //======== menuBar1 ========
            {
                menuBar1.setBackground(new Color(39, 39, 49));

                //======== menu1 ========
                {
                    menu1.setText("Ensamblar");
                    menu1.setForeground(Color.white);

                    //---- opAnalizar ----
                    opAnalizar.setText("Analizar");
                    opAnalizar.setBackground(new Color(39, 39, 49));
                    opAnalizar.setForeground(Color.white);
                    menu1.add(opAnalizar);

                    //---- opPaso1 ----
                    opPaso1.setText("Paso 1");
                    opPaso1.setBackground(new Color(39, 39, 49));
                    opPaso1.setForeground(Color.white);
                    menu1.add(opPaso1);

                    //---- opPaso2 ----
                    opPaso2.setText("Paso 2");
                    opPaso2.setBackground(new Color(39, 39, 49));
                    opPaso2.setForeground(Color.white);
                    menu1.add(opPaso2);

                    //---- opEnsamblar ----
                    opEnsamblar.setText("Ensamblar");
                    opEnsamblar.setBackground(new Color(39, 39, 49));
                    opEnsamblar.setForeground(Color.white);
                    menu1.add(opEnsamblar);
                }
                menuBar1.add(menu1);
            }
            panel2.add(menuBar1);
            menuBar1.setBounds(15, 0, 850, menuBar1.getPreferredSize().height);
        }
        contentPane.add(panel2);
        panel2.setBounds(100, 0, 885, 635);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Raul
    private JPanel panel1;
    private JButton nvoArch;
    private JButton abrirArch;
    private JButton nvoArch2;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem opAnalizar;
    private JMenuItem opPaso1;
    private JMenuItem opPaso2;
    private JMenuItem opEnsamblar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    
    private void accionesBotones(){
        //Principal programa = new Principal(abrirArch,this);
        abrirArch.addActionListener(actionEvent -> {
            System.out.println("Botón presionado abajo");
        });
    }
}

package Gui;

import java.awt.*;

public class Gui extends javax.swing.JFrame {

    public Gui() {
        initComponents();
        iniciaPaneles();
        //setVisible(true);
    }

    private void iniciaPaneles(){
        areaTexto.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        // <editor-fold defaultstate="collapsed" desc="Inicialización de componentes">
        jPanel1 = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        btnNvoArchivo = new javax.swing.JButton();
        btnGuardarArch = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnAbrirArchivo = new javax.swing.JButton();
        panelAcciones = new javax.swing.JPanel();
        analisisSintBtn = new javax.swing.JButton();
        paso1Btn = new javax.swing.JButton();
        ensamblarBtn = new javax.swing.JButton();
        paso2Btn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        panelDividido = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        panelErrores = new javax.swing.JPanel();
        lblNoErrores = new javax.swing.JLabel();
        noErrores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelResultados = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        lblLineasErrores = new javax.swing.JLabel();
        // </editor-fold>
        panelResultados.setVisible(false);
        setBackground(new Color(33,31,32));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 31, 32));

        panelMenu.setBackground(new java.awt.Color(39, 39, 49));

        btnNvoArchivo.setBackground(new java.awt.Color(28, 215, 119));
        btnNvoArchivo.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        btnNvoArchivo.setForeground(java.awt.Color.white);
        btnNvoArchivo.setText("+");
        btnNvoArchivo.setToolTipText("Nuevo archivo");
        btnNvoArchivo.setBorder(null);

        btnGuardarArch.setBackground(new java.awt.Color(39, 39, 49));
        btnGuardarArch.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        btnGuardarArch.setForeground(java.awt.Color.white);
        btnGuardarArch.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/save/2x/outline_save_white_24dp.png")); // NOI18N
        btnGuardarArch.setToolTipText("Guardar");
        btnGuardarArch.setBorder(null);

        btnGuardarComo.setBackground(new java.awt.Color(39, 39, 49));
        btnGuardarComo.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        btnGuardarComo.setForeground(java.awt.Color.white);
        btnGuardarComo.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/saveas/2x/outline_save_as_white_24dp.png")); // NOI18N
        btnGuardarComo.setToolTipText("Guardar como...");
        btnGuardarComo.setBorder(null);

        btnAbrirArchivo.setBackground(new java.awt.Color(39, 39, 49));
        btnAbrirArchivo.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        btnAbrirArchivo.setForeground(java.awt.Color.white);
        btnAbrirArchivo.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/open/2x/outline_file_open_white_24dp.png")); // NOI18N
        btnAbrirArchivo.setToolTipText("Abrir archivo");
        btnAbrirArchivo.setBorder(null);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
                panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNvoArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarArch, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addComponent(btnGuardarComo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
                panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(btnNvoArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarArch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarComo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelAcciones.setBackground(new java.awt.Color(33, 31, 32));

        analisisSintBtn.setBackground(new java.awt.Color(144, 156, 167));
        analisisSintBtn.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        analisisSintBtn.setForeground(java.awt.Color.white);
        analisisSintBtn.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/search.png")); // NOI18N
        analisisSintBtn.setToolTipText("Analizar sintaxis");
        analisisSintBtn.setBorder(null);

        paso1Btn.setBackground(new java.awt.Color(144, 156, 167));
        paso1Btn.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        paso1Btn.setForeground(java.awt.Color.white);
        paso1Btn.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/paso1/2x/outline_bug_report_white_24dp.png")); // NOI18N
        paso1Btn.setToolTipText("Paso 1");
        paso1Btn.setBorder(null);

        ensamblarBtn.setBackground(new java.awt.Color(144, 156, 167));
        ensamblarBtn.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/ensamblar/1x/outline_grid_view_white_24dp.png")); // NOI18N
        ensamblarBtn.setToolTipText("Ensamblar");
        ensamblarBtn.setBorder(null);

        paso2Btn.setBackground(new java.awt.Color(144, 156, 167));
        paso2Btn.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/paso2/1x/outline_reorder_white_24dp.png")); // NOI18N
        paso2Btn.setToolTipText("Paso 2");
        paso2Btn.setBorder(null);

        javax.swing.GroupLayout panelAccionesLayout = new javax.swing.GroupLayout(panelAcciones);
        panelAcciones.setLayout(panelAccionesLayout);
        panelAccionesLayout.setHorizontalGroup(
                panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAccionesLayout.createSequentialGroup()
                                .addComponent(analisisSintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(paso1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(paso2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(ensamblarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAccionesLayout.setVerticalGroup(
                panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAccionesLayout.createSequentialGroup()
                                .addGap(0, 37, Short.MAX_VALUE)
                                .addGroup(panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(analisisSintBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paso1Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ensamblarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paso2Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.setBackground(new java.awt.Color(44, 55, 64));
        jTabbedPane1.setForeground(java.awt.Color.white);
        jTabbedPane1.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        jPanel4.setBackground(new java.awt.Color(33, 31, 32));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 500));

        panelDividido.setDividerLocation(0);
        panelDividido.setDividerSize(20);
        panelDividido.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        panelDividido.setToolTipText("");
        panelDividido.setOneTouchExpandable(true);

        areaTexto.setBackground(new java.awt.Color(44, 55, 64));
        areaTexto.setColumns(20);
        areaTexto.setForeground(java.awt.Color.white);
        areaTexto.setRows(5);
        areaTexto.setCaretColor(java.awt.Color.white);
        areaTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        areaTexto.setFont(new java.awt.Font("Cascadia Code", 0, 18));
        jScrollPane1.setViewportView(areaTexto);

        panelDividido.setRightComponent(jScrollPane1);

        panelErrores.setBackground(new java.awt.Color(35, 36, 38));
        panelErrores.setName("panelErrores"); // NOI18N

        lblNoErrores.setFont(new java.awt.Font("Cascadia Code SemiBold", 0, 18)); // NOI18N
        lblNoErrores.setForeground(java.awt.Color.white);
        lblNoErrores.setText("Errores encontrados");

        noErrores.setBackground(new java.awt.Color(255, 165, 0));
        noErrores.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        noErrores.setForeground(java.awt.Color.white);
        noErrores.setText("");
        noErrores.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("/home/raul/Documentos/UASLP/icons/warning/2x/outline_warning_white_24dp.png")); // NOI18N

        lblLineasErrores.setForeground(new java.awt.Color(239, 50, 53));
        lblLineasErrores.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelErroresLayout = new javax.swing.GroupLayout(panelErrores);
        panelErrores.setLayout(panelErroresLayout);
        panelErroresLayout.setHorizontalGroup(
                panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelErroresLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNoErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelErroresLayout.createSequentialGroup()
                                                .addComponent(noErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLineasErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelErroresLayout.setVerticalGroup(
                panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelErroresLayout.createSequentialGroup()
                                .addGroup(panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblLineasErrores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelErroresLayout.createSequentialGroup()
                                                .addComponent(lblNoErrores)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(noErrores, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelDividido.setTopComponent(panelErrores);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelDividido, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelDividido, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Archivo fuente", jPanel4);

        jTable2.setBackground(new java.awt.Color(33, 31, 32));
        jTable2.setForeground(java.awt.Color.white);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {"0000", "SIMBOLO", null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Cp", "Símbolo", "Instruccion", "Operando", "Codigo objeto"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        jTabbedPane1.addTab("Archivo intermedio", jScrollPane5);

        panelResultados.setBackground(new java.awt.Color(44, 55, 64));
        panelResultados.setForeground(java.awt.Color.white);
        panelResultados.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N

        jTable1.setBackground(new java.awt.Color(33, 31, 32));
        jTable1.setForeground(java.awt.Color.white);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Símbolo", "Direccion"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        panelResultados.addTab("Tabsim", jScrollPane3);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(33, 31, 32));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(java.awt.Color.white);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        panelResultados.addTab("Programa objeto", jScrollPane4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelResultados)
                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    public javax.swing.JTextArea areaTexto;
    public javax.swing.JButton btnNvoArchivo;
    public javax.swing.JButton paso2Btn;
    public javax.swing.JButton btnGuardarArch;
    public javax.swing.JButton btnGuardarComo;
    public javax.swing.JButton btnAbrirArchivo;
    public javax.swing.JButton noErrores;
    public javax.swing.JButton analisisSintBtn;
    public javax.swing.JButton paso1Btn;
    public javax.swing.JButton ensamblarBtn;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JSplitPane panelDividido;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTabbedPane panelResultados;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTextArea jTextArea2;
    public javax.swing.JLabel lblNoErrores;
    public javax.swing.JPanel panelAcciones;
    public javax.swing.JPanel panelErrores;
    public javax.swing.JPanel panelMenu;
    public javax.swing.JLabel lblLineasErrores;
    // End of variables declaration
}

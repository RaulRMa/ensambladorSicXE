package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends javax.swing.JFrame {

    public Gui() {
        initComponents();
        iniciaPaneles();
        iniciaComponentes();
        //setVisible(true);
    }

    private void iniciaPaneles(){
        areaTexto.setEnabled(false);
    }
    private void iniciaComponentes(){
        paso1Btn.setEnabled(false);
        paso2Btn.setEnabled(false);
        cargarBtn.setEnabled(true);
        simularBtn.setEnabled(true);
    }

    private JPanel areaPObjetos(){
        JLabel labelProgs;
        JPanel panelInputs;
        JPanel panelTexto;
        JScrollPane scrollTexto;
        JPanel panelObjs; // Panel que soporta todos los componentes

        panelObjs = new javax.swing.JPanel(); // Panle que soporta los componentes
        panelInputs = new javax.swing.JPanel();
        inputTamProg = new javax.swing.JTextField();
        opcionesProgs = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelProgs = new javax.swing.JLabel();
        panelTexto = new javax.swing.JPanel();
        scrollTexto = new javax.swing.JScrollPane();
        areaPObjs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelInputs.setBackground(new java.awt.Color(33, 31, 32));
        panelObjs.setBackground(new java.awt.Color(33, 31, 32));
        areaPObjs.setBackground(new java.awt.Color(44, 55, 64));
        areaPObjs.setColumns(20);
        areaPObjs.setForeground(java.awt.Color.white);
        areaPObjs.setRows(5);
        areaPObjs.setCaretColor(java.awt.Color.white);
        areaPObjs.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        areaPObjs.setFont(new java.awt.Font("Cascadia Code", 0, 18));


        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio del programa");

        labelProgs.setForeground(java.awt.Color.white);
        labelProgs.setText("Programa de inicio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelInputs);
        panelInputs.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputTamProg, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(opcionesProgs, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelProgs))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(labelProgs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inputTamProg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(opcionesProgs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
        );

        panelTexto.setBackground(new java.awt.Color(33, 31, 32));

        areaPObjs.setColumns(20);
        areaPObjs.setRows(5);
        scrollTexto.setViewportView(areaPObjs);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panelTexto);
        panelTexto.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollTexto)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panelObjs);
        panelObjs.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(panelInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(panelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();

        return panelObjs;
    }

    private JScrollPane creaTabse(){
        JScrollPane panel = new JScrollPane();
        JTable jTabse = new JTable();
        jTabse.setBackground(new java.awt.Color(33, 31, 32));
        jTabse.setForeground(java.awt.Color.white);
        jTabse.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Sección de control", "Símbolo", "Dirección", "Longitud"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class,java.lang.String.class,java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        if (jTabse.getColumnModel().getColumnCount() > 0) {
            jTabse.getColumnModel().getColumn(0).setResizable(false);
            jTabse.getColumnModel().getColumn(1).setResizable(false);
            jTabse.getColumnModel().getColumn(2).setResizable(false);
            jTabse.getColumnModel().getColumn(3).setResizable(false);
        }
        tabse = jTabse;
        panel.setViewportView(jTabse);
        return panel;
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
        cargarBtn = new javax.swing.JButton();
        simularBtn = new javax.swing.JButton();

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
        jScrollPaneR = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        mapaMem = new JTable();
        panelResultados = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabsim = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaCodobj = new javax.swing.JTextArea();
        lblLineasErrores = new javax.swing.JLabel();
        // </editor-fold>
        panelResultados.setVisible(true);
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
        btnGuardarArch.setIcon(new javax.swing.ImageIcon("assets/icons/guardar.png")); // NOI18N
        btnGuardarArch.setToolTipText("Guardar");
        btnGuardarArch.setBorder(null);

        btnGuardarComo.setBackground(new java.awt.Color(39, 39, 49));
        btnGuardarComo.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        btnGuardarComo.setForeground(java.awt.Color.white);
        btnGuardarComo.setIcon(new javax.swing.ImageIcon("assets/icons/guardarComo.png")); // NOI18N
        btnGuardarComo.setToolTipText("Guardar como...");
        btnGuardarComo.setBorder(null);

        btnAbrirArchivo.setBackground(new java.awt.Color(39, 39, 49));
        btnAbrirArchivo.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        btnAbrirArchivo.setForeground(java.awt.Color.white);
        btnAbrirArchivo.setIcon(new javax.swing.ImageIcon("assets/icons/abrir.png")); // NOI18N
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

        //analisisSintBtn.setBackground(new java.awt.Color(144, 156, 167));
        analisisSintBtn.setBackground(null);
        analisisSintBtn.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        analisisSintBtn.setForeground(java.awt.Color.white);
        analisisSintBtn.setIcon(new javax.swing.ImageIcon("assets/icons/sintaxis.png")); // NOI18N
        analisisSintBtn.setToolTipText("Analizar sintaxis");
        analisisSintBtn.setBorder(null);


        paso1Btn.setBackground(null);
        paso1Btn.setFont(new java.awt.Font("Cascadia Code PL SemiBold", 0, 36)); // NOI18N
        paso1Btn.setForeground(java.awt.Color.white);
        paso1Btn.setIcon(new javax.swing.ImageIcon("assets/icons/paso1.png")); // NOI18N
        paso1Btn.setToolTipText("Paso 1");
        paso1Btn.setBorder(null);

        ensamblarBtn.setBackground(null);
        ensamblarBtn.setIcon(new javax.swing.ImageIcon("assets/icons/ensamblar.png")); // NOI18N
        ensamblarBtn.setToolTipText("Ensamblar");
        ensamblarBtn.setBorder(null);

        paso2Btn.setBackground(null);
        paso2Btn.setIcon(new javax.swing.ImageIcon("assets/icons/paso2.png")); // NOI18N
        paso2Btn.setToolTipText("Paso 2");
        paso2Btn.setBorder(null);

        cargarBtn.setBackground(null);
        cargarBtn.setIcon(new javax.swing.ImageIcon("assets/icons/cargar.png")); // NOI18N
        cargarBtn.setToolTipText("Cargar");
        cargarBtn.setBorder(null);

        simularBtn.setBackground(null);
        simularBtn.setIcon(new javax.swing.ImageIcon("assets/icons/simular.png")); // NOI18N
        simularBtn.setToolTipText("Simular");
        simularBtn.setBorder(null);

        javax.swing.GroupLayout panelAccionesLayout = new javax.swing.GroupLayout(panelAcciones);
        panelAcciones.setLayout(panelAccionesLayout);
        panelAccionesLayout.setHorizontalGroup(
                panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAccionesLayout.createSequentialGroup()
                                .addComponent(analisisSintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(paso1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(paso2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(ensamblarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28,28,28)
                                .addComponent(cargarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28,28,28)
                                .addComponent(simularBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(paso2Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cargarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(simularBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))

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

        mapaMem.setBackground(new java.awt.Color(33, 31, 32));
        mapaMem.setForeground(java.awt.Color.white);
        mapaMem.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "0","1","2","3","4","5","6","7","8","9",
                        "A","B", "C","D","E","F",
                }
        ){
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false,
                    false, false, false, false, false,
                    false, false, false, false, false,
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        } );

        jScrollPaneR.setViewportView(mapaMem);

        //areaPObjs = areaPObjetos();
        panelResultados.addTab("ProgramaObjeto",areaPObjetos());

        panelResultados.addTab("Tabse",creaTabse());
        panelResultados.addTab("Mapa de memoria",jScrollPaneR);
        jTable2.setBackground(new java.awt.Color(33, 31, 32));
        jTable2.setForeground(java.awt.Color.white);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

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
            jTable2.getColumnModel().getColumn(0).setResizable(true);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(true);
            jTable2.getColumnModel().getColumn(4).setResizable(true);
        }

        jTabbedPane1.addTab("Archivo intermedio", jScrollPane5);

        panelResultados.setBackground(new java.awt.Color(44, 55, 64));
        panelResultados.setForeground(java.awt.Color.white);
        panelResultados.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N

        tabsim.setBackground(new java.awt.Color(33, 31, 32));
        tabsim.setForeground(java.awt.Color.white);
        tabsim.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Símbolo", "Direccion/Valor", "Tipo término"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class,java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabsim);
        if (tabsim.getColumnModel().getColumnCount() > 0) {
            tabsim.getColumnModel().getColumn(0).setResizable(false);
            tabsim.getColumnModel().getColumn(1).setResizable(false);
        }

        //panelResultados.addTab("Tabsim", jScrollPane3);
        jTabbedPane1.addTab("Tabsim",jScrollPane3);
        areaCodobj.setEditable(false);
        areaCodobj.setBackground(new java.awt.Color(33, 31, 32));
        areaCodobj.setColumns(20);
        areaCodobj.setForeground(java.awt.Color.white);
        areaCodobj.setRows(5);
        jScrollPane4.setViewportView(areaCodobj);

        //panelResultados.addTab("Programa objeto", jScrollPane4);
        jTabbedPane1.addTab("Programa objeto",jScrollPane4);
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

    private void creaMapaMemoria(){

    }

    // Variables declaration - do not modify
    public javax.swing.JTextArea areaTexto; // Area de texto del programa sicxe
    public JTextArea areaPObjs; // Area de texto de los programas objetos
    // <editor-fold defaultstate="collapsed" desc="Botones">
    public javax.swing.JButton btnNvoArchivo;
    public javax.swing.JButton paso2Btn;
    public javax.swing.JButton btnGuardarArch;
    public javax.swing.JButton btnGuardarComo;
    public javax.swing.JButton btnAbrirArchivo;
    public javax.swing.JButton noErrores;
    public javax.swing.JButton analisisSintBtn;
    public javax.swing.JButton paso1Btn;
    public javax.swing.JButton ensamblarBtn;
    public javax.swing.JButton cargarBtn;
    public javax.swing.JButton simularBtn;
    // </editor-fold>
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1; //Soporta el area de texto editable
    public javax.swing.JScrollPane jScrollPane3; //Soporta la tabsim
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5; // Soporta la tabla del archivo intermedio
    public javax.swing.JScrollPane jScrollPaneR; // Soporta la tabla del mapa de memoria

    public javax.swing.JSplitPane panelDividido; //Errores y programa fuente
    public javax.swing.JTabbedPane jTabbedPane1; // Tabs de ensamblado
    public javax.swing.JTabbedPane panelResultados; // Tabs de cargador-ligador
    public javax.swing.JTable tabsim; //Tabla de simbolos
    public javax.swing.JTable jTable2; // Tabla codigo objeto
    public javax.swing.JTable mapaMem; // Tabla mapa de memoria
    public javax.swing.JTable tabse; // Tabla tabse
    public javax.swing.JTextArea areaCodobj; //Registros objeto
    public javax.swing.JLabel lblNoErrores;
    public javax.swing.JPanel panelAcciones;
    public javax.swing.JPanel panelErrores;
    public javax.swing.JPanel panelMenu;
    public javax.swing.JLabel lblLineasErrores;
    public JComboBox<String> opcionesProgs; //Combobox con las opciones de inicio del programa
    public JLabel jLabel1; // Contiene la direccion de inicio del programa
    public JTextField inputTamProg;
    // End of variables declaration
}

package mvc.vistas;

import javax.swing.UIManager;

public class VistaClientes extends javax.swing.JFrame {

    public VistaClientes()throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtNumDNI = new javax.swing.JTextField();
        jtxtNombresCompletos = new javax.swing.JTextField();
        jtxtDireccion = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        jtxtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaClientes = new javax.swing.JTable();
        jbtRegistrarClientes = new javax.swing.JButton();
        jbtNuevo = new javax.swing.JButton();
        jbtModificar = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo780x490.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Decker", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("DNI:");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Nombres completos:");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Dirección:");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Género:");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Buscar:");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jtxtNumDNI.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtNumDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 250, -1));

        jtxtNombresCompletos.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtNombresCompletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 250, -1));

        jtxtDireccion.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 250, -1));

        jcbGenero.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----", "Masculino", "Femenino" }));
        jcbGenero.setFocusable(false);
        fondo.add(jcbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 250, -1));

        jtxtBuscar.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 217, 250, -1));

        jScrollPane1.setOpaque(false);

        jtListaClientes.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código del cliente", "DNI", "Nombres Completos", "Dirección", "Genero", "Modificar", "Remover"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaClientes.setOpaque(false);
        jtListaClientes.getTableHeader().setReorderingAllowed(false);
        jtListaClientes.setShowGrid(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaClientes.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaClientes.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane1.setViewportView(jtListaClientes);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 690, 210));

        jbtRegistrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarCliente110x30_OFF.png"))); // NOI18N
        jbtRegistrarClientes.setBorder(null);
        jbtRegistrarClientes.setBorderPainted(false);
        jbtRegistrarClientes.setContentAreaFilled(false);
        jbtRegistrarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegistrarClientes.setDefaultCapable(false);
        jbtRegistrarClientes.setFocusPainted(false);
        jbtRegistrarClientes.setFocusable(false);
        jbtRegistrarClientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarCliente110x30_ON.png"))); // NOI18N
        jbtRegistrarClientes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarCliente110x30_ON.png"))); // NOI18N
        fondo.add(jbtRegistrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jbtNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo110x30_OFF.png"))); // NOI18N
        jbtNuevo.setBorder(null);
        jbtNuevo.setBorderPainted(false);
        jbtNuevo.setContentAreaFilled(false);
        jbtNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNuevo.setDefaultCapable(false);
        jbtNuevo.setFocusPainted(false);
        jbtNuevo.setFocusable(false);
        jbtNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo110x30_ON.png"))); // NOI18N
        jbtNuevo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo110x30_ON.png"))); // NOI18N
        fondo.add(jbtNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jbtModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_OFF.png"))); // NOI18N
        jbtModificar.setBorder(null);
        jbtModificar.setBorderPainted(false);
        jbtModificar.setContentAreaFilled(false);
        jbtModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtModificar.setDefaultCapable(false);
        jbtModificar.setEnabled(false);
        jbtModificar.setFocusPainted(false);
        jbtModificar.setFocusable(false);
        jbtModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_ON.png"))); // NOI18N
        jbtModificar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_ON.png"))); // NOI18N
        fondo.add(jbtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        jbtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimirC110x30_OFF.png"))); // NOI18N
        jbtImprimir.setBorder(null);
        jbtImprimir.setBorderPainted(false);
        jbtImprimir.setContentAreaFilled(false);
        jbtImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtImprimir.setDefaultCapable(false);
        jbtImprimir.setFocusPainted(false);
        jbtImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimirC110x30_ON.png"))); // NOI18N
        jbtImprimir.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimirC110x30_ON.png"))); // NOI18N
        fondo.add(jbtImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtImprimir;
    public javax.swing.JButton jbtModificar;
    public javax.swing.JButton jbtNuevo;
    public javax.swing.JButton jbtRegistrarClientes;
    public javax.swing.JComboBox<String> jcbGenero;
    public javax.swing.JTable jtListaClientes;
    public javax.swing.JTextField jtxtBuscar;
    public javax.swing.JTextField jtxtDireccion;
    public javax.swing.JTextField jtxtNombresCompletos;
    public javax.swing.JTextField jtxtNumDNI;
    // End of variables declaration//GEN-END:variables
}

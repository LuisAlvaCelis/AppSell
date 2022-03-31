package mvc.vistas;

import javax.swing.UIManager;

public class VistaRegistrarProductos extends javax.swing.JFrame {

    public VistaRegistrarProductos()throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtCodigoProducto = new javax.swing.JTextField();
        jtxtTipProducto = new javax.swing.JTextField();
        jtxtNomProducto = new javax.swing.JTextField();
        jtxtCantidadProducto = new javax.swing.JTextField();
        jtxtPrecioProducto = new javax.swing.JTextField();
        jbtRegistrarProducto = new javax.swing.JButton();
        jbtNuevo = new javax.swing.JButton();
        jbtModificar = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo950x500.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        jtListaProductos.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo de producto", "Tipo de producto", "Nombre del producto", "Cantidad del producto", "Precio del producto", "Fecha de registro", "Modificar", "Remover"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaProductos.setOpaque(false);
        jtListaProductos.getTableHeader().setReorderingAllowed(false);
        jtListaProductos.setShowGrid(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaProductos.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaProductos.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane1.setViewportView(jtListaProductos);

        panelImage1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 920, 220));

        jLabel1.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Buscar:");
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jtxtBuscar.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        panelImage1.add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 228, 230, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo producto:");
        panelImage1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de producto:");
        panelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre del producto:");
        panelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad del producto:");
        panelImage1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio del producto:");
        panelImage1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jtxtCodigoProducto.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        panelImage1.add(jtxtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 170, -1));

        jtxtTipProducto.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtTipProducto.setForeground(new java.awt.Color(0, 0, 0));
        panelImage1.add(jtxtTipProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 170, -1));

        jtxtNomProducto.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtNomProducto.setForeground(new java.awt.Color(0, 0, 0));
        panelImage1.add(jtxtNomProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 170, -1));

        jtxtCantidadProducto.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtCantidadProducto.setForeground(new java.awt.Color(0, 0, 0));
        panelImage1.add(jtxtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 170, -1));

        jtxtPrecioProducto.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtPrecioProducto.setForeground(new java.awt.Color(0, 0, 0));
        panelImage1.add(jtxtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, -1));

        jbtRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarProdudcto110x30_OFF.png"))); // NOI18N
        jbtRegistrarProducto.setBorder(null);
        jbtRegistrarProducto.setBorderPainted(false);
        jbtRegistrarProducto.setContentAreaFilled(false);
        jbtRegistrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegistrarProducto.setDefaultCapable(false);
        jbtRegistrarProducto.setFocusPainted(false);
        jbtRegistrarProducto.setFocusable(false);
        jbtRegistrarProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarProdudcto110x30_ON.png"))); // NOI18N
        jbtRegistrarProducto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarProdudcto110x30_ON.png"))); // NOI18N
        panelImage1.add(jbtRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, -1));

        jbtNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo110x30_OFF_1.png"))); // NOI18N
        jbtNuevo.setToolTipText("");
        jbtNuevo.setBorder(null);
        jbtNuevo.setBorderPainted(false);
        jbtNuevo.setContentAreaFilled(false);
        jbtNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNuevo.setDefaultCapable(false);
        jbtNuevo.setFocusPainted(false);
        jbtNuevo.setFocusable(false);
        jbtNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo110x30_ON_1.png"))); // NOI18N
        panelImage1.add(jbtNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        jbtModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_OFF_2.png"))); // NOI18N
        jbtModificar.setBorder(null);
        jbtModificar.setBorderPainted(false);
        jbtModificar.setContentAreaFilled(false);
        jbtModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtModificar.setDefaultCapable(false);
        jbtModificar.setEnabled(false);
        jbtModificar.setFocusPainted(false);
        jbtModificar.setFocusable(false);
        jbtModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_ON_2.png"))); // NOI18N
        jbtModificar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_ON_2.png"))); // NOI18N
        panelImage1.add(jbtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, -1, -1));

        jbtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir110x30_OFF.png"))); // NOI18N
        jbtImprimir.setBorder(null);
        jbtImprimir.setBorderPainted(false);
        jbtImprimir.setContentAreaFilled(false);
        jbtImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtImprimir.setDefaultCapable(false);
        jbtImprimir.setFocusPainted(false);
        jbtImprimir.setFocusable(false);
        jbtImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir110x30_ON.png"))); // NOI18N
        jbtImprimir.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir110x30_ON.png"))); // NOI18N
        panelImage1.add(jbtImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtImprimir;
    public javax.swing.JButton jbtModificar;
    public javax.swing.JButton jbtNuevo;
    public javax.swing.JButton jbtRegistrarProducto;
    public javax.swing.JTable jtListaProductos;
    public javax.swing.JTextField jtxtBuscar;
    public javax.swing.JTextField jtxtCantidadProducto;
    public javax.swing.JTextField jtxtCodigoProducto;
    public javax.swing.JTextField jtxtNomProducto;
    public javax.swing.JTextField jtxtPrecioProducto;
    public javax.swing.JTextField jtxtTipProducto;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}

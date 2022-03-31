package mvc.vistas;

import javax.swing.UIManager;

public class VistaGenerarVentas extends javax.swing.JFrame {

    public VistaGenerarVentas() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jtxtBuscarCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtxtBuscarProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtListaPedidos = new javax.swing.JTable();
        jbtRegistrarNuevoCliente = new javax.swing.JButton();
        jbtFinalizarCompra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtxtDineroDadoCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtCodigoClienteSeleccionado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtSubTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtIGV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtTotal = new javax.swing.JTextField();
        jbtNuevoCliente = new javax.swing.JButton();
        jbtNuevaCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo950x500.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Buscar cliente:");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jtxtBuscarCliente.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 340, -1));

        jScrollPane1.setOpaque(false);

        jtListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo del cliente", "DNI", "Nombres completos", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaClientes.setToolTipText("");
        jtListaClientes.setOpaque(false);
        jtListaClientes.getTableHeader().setReorderingAllowed(false);
        jtListaClientes.setShowGrid(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaClientes.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaClientes.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane1.setViewportView(jtListaClientes);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 830, 130));

        jLabel2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Buscar producto:");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jtxtBuscarProducto.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 240, -1));

        jScrollPane2.setOpaque(false);

        jtListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Stock", "Precio", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaProductos.setOpaque(false);
        jtListaProductos.getTableHeader().setReorderingAllowed(false);
        jtListaProductos.setShowGrid(false);
        jScrollPane2.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaProductos.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaProductos.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane2.setViewportView(jtListaProductos);

        fondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 390, 220));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("---->");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        jScrollPane3.setOpaque(false);

        jtListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo producto", "Cantidad", "Total", "Remover"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaPedidos.setOpaque(false);
        jtListaPedidos.getTableHeader().setReorderingAllowed(false);
        jtListaPedidos.setShowGrid(false);
        jScrollPane3.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaPedidos.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaPedidos.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane3.setViewportView(jtListaPedidos);

        fondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 460, 230));

        jbtRegistrarNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarNuevoCliente110x30_OFF.png"))); // NOI18N
        jbtRegistrarNuevoCliente.setBorder(null);
        jbtRegistrarNuevoCliente.setBorderPainted(false);
        jbtRegistrarNuevoCliente.setContentAreaFilled(false);
        jbtRegistrarNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtRegistrarNuevoCliente.setDefaultCapable(false);
        jbtRegistrarNuevoCliente.setFocusPainted(false);
        jbtRegistrarNuevoCliente.setFocusable(false);
        jbtRegistrarNuevoCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarNuevoCliente110x30_ON.png"))); // NOI18N
        jbtRegistrarNuevoCliente.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarNuevoCliente110x30_ON.png"))); // NOI18N
        fondo.add(jbtRegistrarNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        jbtFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/finalizarCompra110x30_OFF.png"))); // NOI18N
        jbtFinalizarCompra.setBorder(null);
        jbtFinalizarCompra.setBorderPainted(false);
        jbtFinalizarCompra.setContentAreaFilled(false);
        jbtFinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtFinalizarCompra.setDefaultCapable(false);
        jbtFinalizarCompra.setFocusPainted(false);
        jbtFinalizarCompra.setFocusable(false);
        jbtFinalizarCompra.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/finalizarCompra110x30_ON.png"))); // NOI18N
        jbtFinalizarCompra.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/finalizarCompra110x30_ON.png"))); // NOI18N
        fondo.add(jbtFinalizarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 490, -1, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese dinero dado por el cliente:");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, -1, -1));

        jtxtDineroDadoCliente.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtDineroDadoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, 180, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Código del cliente seleccionado:");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, -1, -1));

        jtxtCodigoClienteSeleccionado.setEditable(false);
        jtxtCodigoClienteSeleccionado.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtCodigoClienteSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 170, -1));

        jLabel6.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sub total:");
        fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, -1, -1));

        jtxtSubTotal.setEditable(false);
        jtxtSubTotal.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, 110, -1));

        jLabel7.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IGV (18%):");
        fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

        jtxtIGV.setEditable(false);
        jtxtIGV.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 110, -1));

        jLabel8.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total:");
        fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, -1, -1));

        jtxtTotal.setEditable(false);
        jtxtTotal.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 350, 110, -1));

        jbtNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoCliente110x30_OFF.png"))); // NOI18N
        jbtNuevoCliente.setBorder(null);
        jbtNuevoCliente.setBorderPainted(false);
        jbtNuevoCliente.setContentAreaFilled(false);
        jbtNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtNuevoCliente.setDefaultCapable(false);
        jbtNuevoCliente.setFocusPainted(false);
        jbtNuevoCliente.setFocusable(false);
        jbtNuevoCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoCliente110x30_ON.png"))); // NOI18N
        jbtNuevoCliente.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoCliente110x30_ON.png"))); // NOI18N
        fondo.add(jbtNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, -1, -1));

        jbtNuevaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevaCompra110x30_OFF.png"))); // NOI18N
        jbtNuevaCompra.setBorder(null);
        jbtNuevaCompra.setBorderPainted(false);
        jbtNuevaCompra.setContentAreaFilled(false);
        jbtNuevaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtNuevaCompra.setDefaultCapable(false);
        jbtNuevaCompra.setFocusPainted(false);
        jbtNuevaCompra.setFocusable(false);
        jbtNuevaCompra.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevaCompra110x30_ON.png"))); // NOI18N
        jbtNuevaCompra.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevaCompra110x30_ON.png"))); // NOI18N
        fondo.add(jbtNuevaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton jbtFinalizarCompra;
    public javax.swing.JButton jbtNuevaCompra;
    public javax.swing.JButton jbtNuevoCliente;
    public javax.swing.JButton jbtRegistrarNuevoCliente;
    public javax.swing.JTable jtListaClientes;
    public javax.swing.JTable jtListaPedidos;
    public javax.swing.JTable jtListaProductos;
    public javax.swing.JTextField jtxtBuscarCliente;
    public javax.swing.JTextField jtxtBuscarProducto;
    public javax.swing.JTextField jtxtCodigoClienteSeleccionado;
    public javax.swing.JTextField jtxtDineroDadoCliente;
    public javax.swing.JTextField jtxtIGV;
    public javax.swing.JTextField jtxtSubTotal;
    public javax.swing.JTextField jtxtTotal;
    // End of variables declaration//GEN-END:variables
}

package mvc.vistas;

import javax.swing.UIManager;

public class VistaRegistroVentas extends javax.swing.JFrame {

    public VistaRegistroVentas() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jlTotalRecaudado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtxtBuscarCliente = new javax.swing.JTextField();
        jbtImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoRegistroVentas1000x500.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Decker", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("TOTAL RECAUDADO HASTA LA FECHA ACTUAL:");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jlTotalRecaudado.setFont(new java.awt.Font("Decker", 2, 18)); // NOI18N
        jlTotalRecaudado.setForeground(new java.awt.Color(51, 51, 51));
        fondo.add(jlTotalRecaudado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jScrollPane1.setOpaque(false);

        jtListaVentas.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtListaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo venta", "Codigo cliente", "Nombre producto", "Cantidad solicitada", "Importe", "Fecha de compra", "Remover fila", "Remover grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaVentas.setOpaque(false);
        jtListaVentas.getTableHeader().setReorderingAllowed(false);
        jtListaVentas.setShowGrid(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaVentas.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaVentas.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane1.setViewportView(jtListaVentas);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 940, 380));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Buscar cliente:");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jtxtBuscarCliente.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 220, -1));

        jbtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir110x30_OFF.png"))); // NOI18N
        jbtImprimir.setBorder(null);
        jbtImprimir.setBorderPainted(false);
        jbtImprimir.setContentAreaFilled(false);
        jbtImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtImprimir.setDefaultCapable(false);
        jbtImprimir.setFocusPainted(false);
        jbtImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir110x30_ON.png"))); // NOI18N
        jbtImprimir.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir110x30_ON.png"))); // NOI18N
        fondo.add(jbtImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtImprimir;
    public javax.swing.JLabel jlTotalRecaudado;
    public javax.swing.JTable jtListaVentas;
    public javax.swing.JTextField jtxtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}

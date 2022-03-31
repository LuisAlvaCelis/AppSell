package mvc.vistas;

import javax.swing.UIManager;

public class VistaDatosEmpleados extends javax.swing.JFrame {

    public VistaDatosEmpleados()throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaEmpleados = new javax.swing.JTable();
        jbtImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo850x400.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Decker", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Buscar:");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtxtBuscar.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        fondo.add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 18, 260, -1));

        jScrollPane1.setOpaque(false);

        jtListaEmpleados.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Teléfono / Celular", "Nombres Completos", "Correo", "Fecha de nacimiento", "Genero", "Usuario", "Clave", "Fecha de registro", "Modificar", "Remover"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaEmpleados.setOpaque(false);
        jtListaEmpleados.getTableHeader().setReorderingAllowed(false);
        jtListaEmpleados.setShowGrid(false);
        jScrollPane1.getViewport().setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)jtListaEmpleados.getDefaultRenderer(Object.class)).setOpaque(false);
        jtListaEmpleados.setDefaultRenderer(Object.class, new source.RenderizadoTablas());
        jScrollPane1.setViewportView(jtListaEmpleados);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1010, 330));

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
        fondo.add(jbtImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage fondo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtImprimir;
    public javax.swing.JTable jtListaEmpleados;
    public javax.swing.JTextField jtxtBuscar;
    // End of variables declaration//GEN-END:variables
}

package mvc.vistas;

import javax.swing.UIManager;

public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jmb = new javax.swing.JMenuBar();
        jmMenu = new javax.swing.JMenu();
        jmAdministrador = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jmiEmpleados = new javax.swing.JMenuItem();
        jmiRegistroVentas = new javax.swing.JMenuItem();
        jmiRegistroSQL = new javax.swing.JMenuItem();
        jmiGenerarVentas = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo600x400.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jmMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu32x32.png"))); // NOI18N
        jmMenu.setText("Menu");
        jmMenu.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N

        jmAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/administracion24x24.png"))); // NOI18N
        jmAdministrador.setText("Administrador");
        jmAdministrador.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N

        jmiClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiClientes.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jmiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente16x16.png"))); // NOI18N
        jmiClientes.setText("Clientes");
        jmAdministrador.add(jmiClientes);

        jmiProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmiProductos.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jmiProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos16x16.png"))); // NOI18N
        jmiProductos.setText("Productos");
        jmAdministrador.add(jmiProductos);

        jmiEmpleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiEmpleados.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jmiEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleados16x16.png"))); // NOI18N
        jmiEmpleados.setText("Empleados");
        jmAdministrador.add(jmiEmpleados);

        jmiRegistroVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmiRegistroVentas.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jmiRegistroVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporteVentas16x16.png"))); // NOI18N
        jmiRegistroVentas.setText("Registro de ventas");
        jmAdministrador.add(jmiRegistroVentas);

        jmiRegistroSQL.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiRegistroSQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sql16x16.png"))); // NOI18N
        jmiRegistroSQL.setText("Registrar SQL");
        jmAdministrador.add(jmiRegistroSQL);

        jmMenu.add(jmAdministrador);

        jmiGenerarVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jmiGenerarVentas.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jmiGenerarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarVentas24x24.png"))); // NOI18N
        jmiGenerarVentas.setText("Generar ventas");
        jmMenu.add(jmiGenerarVentas);

        jmiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jmiSalir.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jmiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir24x24.png"))); // NOI18N
        jmiSalir.setText("Salir");
        jmMenu.add(jmiSalir);

        jmb.add(jmMenu);

        setJMenuBar(jmb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage fondo;
    public javax.swing.JMenu jmAdministrador;
    public javax.swing.JMenu jmMenu;
    private javax.swing.JMenuBar jmb;
    public javax.swing.JMenuItem jmiClientes;
    public javax.swing.JMenuItem jmiEmpleados;
    public javax.swing.JMenuItem jmiGenerarVentas;
    public javax.swing.JMenuItem jmiProductos;
    public javax.swing.JMenuItem jmiRegistroSQL;
    public javax.swing.JMenuItem jmiRegistroVentas;
    public javax.swing.JMenuItem jmiSalir;
    // End of variables declaration//GEN-END:variables
}

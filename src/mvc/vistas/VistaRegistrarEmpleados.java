package mvc.vistas;

import javax.swing.UIManager;

public class VistaRegistrarEmpleados extends javax.swing.JFrame {

    public VistaRegistrarEmpleados() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jtxtNumDNI = new javax.swing.JTextField();
        jtxtNumTelCel = new javax.swing.JTextField();
        jtxtNombresCompletos = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        jbtRegistrarEmpleado = new javax.swing.JButton();
        jbtModificar = new javax.swing.JButton();
        jbtVerEmpleados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtUsuarioEmpleado = new javax.swing.JTextField();
        jpassClaveEmpleado = new javax.swing.JPasswordField();
        jbtMostrar = new javax.swing.JCheckBox();
        jbtNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo850x400.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtNumDNI.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtNumDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese número de DNI:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        fondo.add(jtxtNumDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, -1));

        jtxtNumTelCel.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtNumTelCel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese número de Teléfono/Celular:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        fondo.add(jtxtNumTelCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 240, -1));

        jtxtNombresCompletos.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtNombresCompletos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese nombres completos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        fondo.add(jtxtNombresCompletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 240, -1));

        jtxtCorreo.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese correo electronico:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        fondo.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 240, -1));

        jcbGenero.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----", "Masculino", "Femenino" }));
        jcbGenero.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione género:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        jcbGenero.setFocusable(false);
        fondo.add(jcbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 240, 50));

        jbtRegistrarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarEmpleado110x30_OFF.png"))); // NOI18N
        jbtRegistrarEmpleado.setBorder(null);
        jbtRegistrarEmpleado.setBorderPainted(false);
        jbtRegistrarEmpleado.setContentAreaFilled(false);
        jbtRegistrarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtRegistrarEmpleado.setDefaultCapable(false);
        jbtRegistrarEmpleado.setFocusPainted(false);
        jbtRegistrarEmpleado.setFocusable(false);
        jbtRegistrarEmpleado.setName("registrar"); // NOI18N
        jbtRegistrarEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarEmpleado110x30_ON.png"))); // NOI18N
        jbtRegistrarEmpleado.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarEmpleado110x30_ON.png"))); // NOI18N
        fondo.add(jbtRegistrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jbtModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_OFF_1.png"))); // NOI18N
        jbtModificar.setBorder(null);
        jbtModificar.setBorderPainted(false);
        jbtModificar.setContentAreaFilled(false);
        jbtModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtModificar.setDefaultCapable(false);
        jbtModificar.setEnabled(false);
        jbtModificar.setFocusPainted(false);
        jbtModificar.setFocusable(false);
        jbtModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_ON_1.png"))); // NOI18N
        jbtModificar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar110x30_ON_1.png"))); // NOI18N
        fondo.add(jbtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jbtVerEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verEmpleados110x30_OFF.png"))); // NOI18N
        jbtVerEmpleados.setBorder(null);
        jbtVerEmpleados.setBorderPainted(false);
        jbtVerEmpleados.setContentAreaFilled(false);
        jbtVerEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtVerEmpleados.setDefaultCapable(false);
        jbtVerEmpleados.setFocusPainted(false);
        jbtVerEmpleados.setFocusable(false);
        jbtVerEmpleados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verEmpleados110x30_ON.png"))); // NOI18N
        jbtVerEmpleados.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verEmpleados110x30_ON.png"))); // NOI18N
        fondo.add(jbtVerEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sindrome-boreout-gif-occmundial.gif"))); // NOI18N
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 210, 240));

        jtxtUsuarioEmpleado.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtUsuarioEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese usuario del empleado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        fondo.add(jtxtUsuarioEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, -1));

        jpassClaveEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese clave del empleado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Decker", 2, 12))); // NOI18N
        jpassClaveEmpleado.setEchoChar('*');
        fondo.add(jpassClaveEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 240, -1));

        jbtMostrar.setBorder(null);
        jbtMostrar.setContentAreaFilled(false);
        jbtMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_OFF.png"))); // NOI18N
        fondo.add(jbtMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        jbtNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoEmpleado110x30_OFF.png"))); // NOI18N
        jbtNuevo.setBorder(null);
        jbtNuevo.setBorderPainted(false);
        jbtNuevo.setContentAreaFilled(false);
        jbtNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtNuevo.setDefaultCapable(false);
        jbtNuevo.setFocusable(false);
        jbtNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoEmpleado110x30_ON.png"))); // NOI18N
        jbtNuevo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoEmpleado110x30_ON.png"))); // NOI18N
        fondo.add(jbtNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage fondo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton jbtModificar;
    public javax.swing.JCheckBox jbtMostrar;
    public javax.swing.JButton jbtNuevo;
    public javax.swing.JButton jbtRegistrarEmpleado;
    public javax.swing.JButton jbtVerEmpleados;
    public javax.swing.JComboBox<String> jcbGenero;
    public javax.swing.JPasswordField jpassClaveEmpleado;
    public javax.swing.JTextField jtxtCorreo;
    public javax.swing.JTextField jtxtNombresCompletos;
    public javax.swing.JTextField jtxtNumDNI;
    public javax.swing.JTextField jtxtNumTelCel;
    public javax.swing.JTextField jtxtUsuarioEmpleado;
    // End of variables declaration//GEN-END:variables
}

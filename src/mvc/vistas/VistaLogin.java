package mvc.vistas;

import javax.swing.UIManager;

public class VistaLogin extends javax.swing.JFrame {

    public VistaLogin() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jpComponents = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jpassContra = new javax.swing.JPasswordField();
        jbtIngresar = new javax.swing.JButton();
        jbtMostrarContra = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo490x500.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login128x128.png"))); // NOI18N
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, 140));

        jpComponents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpComponents.setOpaque(false);
        jpComponents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("USUARIO:");
        jpComponents.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("CONTRASEÑA:");
        jpComponents.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jtxtUsuario.setFont(new java.awt.Font("Decker", 0, 11)); // NOI18N
        jtxtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        jpComponents.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 240, -1));

        jpassContra.setForeground(new java.awt.Color(51, 51, 51));
        jpassContra.setEchoChar('*');
        jpComponents.add(jpassContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 240, -1));

        jbtIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresar110x30_OFF.png"))); // NOI18N
        jbtIngresar.setBorder(null);
        jbtIngresar.setBorderPainted(false);
        jbtIngresar.setContentAreaFilled(false);
        jbtIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtIngresar.setDefaultCapable(false);
        jbtIngresar.setFocusPainted(false);
        jbtIngresar.setFocusable(false);
        jbtIngresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresar110x30_ON.png"))); // NOI18N
        jbtIngresar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresar110x30_ON.png"))); // NOI18N
        jpComponents.add(jbtIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        jbtMostrarContra.setBorder(null);
        jbtMostrarContra.setContentAreaFilled(false);
        jbtMostrarContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_OFF.png"))); // NOI18N
        jbtMostrarContra.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_ON.png"))); // NOI18N
        jbtMostrarContra.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_ON.png"))); // NOI18N
        jpComponents.add(jbtMostrarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        fondo.add(jpComponents, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 400, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JButton jbtIngresar;
    public javax.swing.JRadioButton jbtMostrarContra;
    private javax.swing.JPanel jpComponents;
    public javax.swing.JPasswordField jpassContra;
    public javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}

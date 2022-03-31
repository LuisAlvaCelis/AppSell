package mvc.vistas;

import javax.swing.UIManager;

public class VistaRegistrarSQL extends javax.swing.JFrame {

    public VistaRegistrarSQL() throws Exception{
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
        jtxtIP = new javax.swing.JTextField();
        jtxtPORT = new javax.swing.JTextField();
        jtxtDATABASE = new javax.swing.JTextField();
        jtxtUSERNAME = new javax.swing.JTextField();
        jpassPASSWORD = new javax.swing.JPasswordField();
        jbtRegistrarSQL = new javax.swing.JButton();
        jbtMostrar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercado.png")).getImage());
        setResizable(false);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo400x450.png"))); // NOI18N
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("IP:");
        jLabel1.setToolTipText("");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PORT:");
        jLabel2.setToolTipText("");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DATABASE:");
        jLabel3.setToolTipText("");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("USERNAME:");
        jLabel4.setToolTipText("");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("PASSWORD:");
        jLabel5.setToolTipText("");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        fondo.add(jtxtIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 230, -1));
        fondo.add(jtxtPORT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 230, -1));
        fondo.add(jtxtDATABASE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 230, -1));
        fondo.add(jtxtUSERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 230, -1));

        jpassPASSWORD.setEchoChar('*');
        fondo.add(jpassPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 230, -1));

        jbtRegistrarSQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar110x30_OFF.png"))); // NOI18N
        jbtRegistrarSQL.setBorder(null);
        jbtRegistrarSQL.setBorderPainted(false);
        jbtRegistrarSQL.setContentAreaFilled(false);
        jbtRegistrarSQL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegistrarSQL.setDefaultCapable(false);
        jbtRegistrarSQL.setFocusPainted(false);
        jbtRegistrarSQL.setFocusable(false);
        jbtRegistrarSQL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar110x30_ON.png"))); // NOI18N
        jbtRegistrarSQL.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar110x30_ON.png"))); // NOI18N
        fondo.add(jbtRegistrarSQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        jbtMostrar.setBorder(null);
        jbtMostrar.setContentAreaFilled(false);
        jbtMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_OFF_1.png"))); // NOI18N
        jbtMostrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_ON_1.png"))); // NOI18N
        jbtMostrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar110x30_ON_1.png"))); // NOI18N
        fondo.add(jbtMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
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
    public javax.swing.JCheckBox jbtMostrar;
    public javax.swing.JButton jbtRegistrarSQL;
    public javax.swing.JPasswordField jpassPASSWORD;
    public javax.swing.JTextField jtxtDATABASE;
    public javax.swing.JTextField jtxtIP;
    public javax.swing.JTextField jtxtPORT;
    public javax.swing.JTextField jtxtUSERNAME;
    // End of variables declaration//GEN-END:variables
}

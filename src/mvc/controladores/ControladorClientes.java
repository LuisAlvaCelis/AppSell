package mvc.controladores;

import dao.ConexionSQL;
import dao.DAOClientes;
import dao.DAOImplements;
import dao.DAOInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import mvc.modelos.Cliente;
import source.Principal;
import mvc.vistas.VistaClientes;
import mvc.vistas.VistaGenerarVentas;
import mvc.vistas.VistaPrincipal;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import source.ArchivoYML;

public class ControladorClientes extends WindowAdapter implements ActionListener {
    
    private static ControladorClientes instance;
    private VistaClientes cf;
    private DAOInterface dao;
    private String codeCliente;
    private String usuario;
    private String modoEntrada;
    
    public static ControladorClientes getInstance(VistaClientes cf,String usuario){
       return instance=new ControladorClientes(cf, usuario);
    }
    
    public ControladorClientes(VistaClientes cf,String usuario){
        this.codeCliente=null;
        this.usuario=usuario;
        this.cf=cf;
        this.cf.setVisible(true);
        this.dao=new DAOImplements();
        this.dao.mostrarDatosJFrames(cf.jtListaClientes, 1, "");
        this.registerEvents();
    }
    
    public ControladorClientes setModoEntrada(String modoEntrada){
        this.modoEntrada=modoEntrada;
        return instance;
    }
    
    private void registerEvents(){
        this.cf.jbtRegistrarClientes.addActionListener(this);
        this.cf.jbtNuevo.addActionListener(this);
        this.cf.jbtModificar.addActionListener(this);
        this.cf.jbtImprimir.addActionListener(this);
        this.cf.jtListaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e);
            }
        });
        this.cf.jtxtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                dao.mostrarDatosJFrames(cf.jtListaClientes, 1, cf.jtxtBuscar.getText());
            }
        });
        this.cf.jtxtNumDNI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(Character.isLetter(e.getKeyChar())){
                    cf.getToolkit().beep();
                    e.consume();
                    Principal.getInstance().mensajeError("Error: No puede ingresar letras en este campo.");
                }
            }
        });
        this.cf.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cf.jbtRegistrarClientes==e.getSource()){
            this.btnRegistrarCliente();
        }else if(cf.jbtNuevo==e.getSource()){
            this.limpiar();
        }else if(cf.jbtModificar==e.getSource()){
            this.btnModificarCliente();
        }else if(cf.jbtImprimir==e.getSource()){
            this.btnImprimir();
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try {
            if(modoEntrada.equals("GenerarVentas")){
                ControladorGenerarVentas.getInstance(new VistaGenerarVentas(), usuario);
            }else{
                if(ArchivoYML.getInstance().getFileYML().getString("Cuenta.usuario").equals(usuario)){
                    ControladorPrincipal.getInstance(new VistaPrincipal(), usuario);
                }else{
                    ControladorPrincipal.getInstance(new VistaPrincipal(), usuario).tipoAcceso('E');
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void btnImprimir(){
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/reportes/ReporteClientes.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,null, new ConexionSQL().conectar());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnModificarCliente(){
        if(codeCliente!=null){
            if(!cf.jtxtNumDNI.getText().equalsIgnoreCase("")){
                if(!cf.jtxtNombresCompletos.getText().equalsIgnoreCase("")){
                    if(!cf.jtxtDireccion.getText().equalsIgnoreCase("")){
                        if(cf.jcbGenero.getSelectedIndex()!=0){
                            String dni=cf.jtxtNumDNI.getText();
                            String nomCompleto=cf.jtxtNombresCompletos.getText();
                            String direccion=cf.jtxtDireccion.getText();
                            String genero=cf.jcbGenero.getSelectedItem().toString();
                            if(DAOClientes.getInstance().actualizar(new Cliente(codeCliente,dni, nomCompleto, direccion, genero))){
                                this.dao.mostrarDatosJFrames(cf.jtListaClientes, 1, "");
                                this.cf.jbtNuevo.doClick();
                                Principal.getInstance().mensajeExito("Cliente actualizado con éxito.");
                            }else{
                                Principal.getInstance().mensajeError("Error: No se pudo actualizar al cliente, vuelva a intentarlo.");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Género del cliente no seleccionado.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: Dirección del cliente no ingresado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Nombres completos del cliente no ingresado.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Número de dni no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: No seleccionó a un cliente para modificarlo.");
        }
    }
    
    private void btnRegistrarCliente(){
        if(!cf.jtxtNumDNI.getText().equalsIgnoreCase("")){
            if(!cf.jtxtNombresCompletos.getText().equalsIgnoreCase("")){
                if(!cf.jtxtDireccion.getText().equalsIgnoreCase("")){
                    if(cf.jcbGenero.getSelectedIndex()!=0){
                        String dni=cf.jtxtNumDNI.getText();
                        String nomComplt=cf.jtxtNombresCompletos.getText();
                        String direccion=cf.jtxtDireccion.getText();
                        String genero=cf.jcbGenero.getSelectedItem().toString();
                        boolean encontrar=false;
                        for(Cliente c:DAOClientes.getInstance().obtenerLista()){
                            if(c.getDni().equals(dni)){
                                encontrar=true;
                            }
                        }
                        if(!encontrar){
                            if(DAOClientes.getInstance().insertar(new Cliente(Principal.getInstance().getPalabraRandom(),dni, nomComplt, direccion, genero))){
                                this.cf.jbtNuevo.doClick();
                                dao.mostrarDatosJFrames(cf.jtListaClientes, 1, "");
                                Principal.getInstance().mensajeExito("Cliente registrado con éxito.");
                            }else{
                                Principal.getInstance().mensajeError("Error: No se pudo registrar al cliente en la base de datos.");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Cliente ya ha sido registrado anteriormente, vuelva a intentarlo.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: Género del cliente no seleccionado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Dirección del cliente no ingresado.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Nombres completos del cliente no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: Número de dni no ingresado.");
        }
    }
    
    private void clickTable(MouseEvent e){
        int click=cf.jtListaClientes.rowAtPoint(e.getPoint());
        codeCliente=cf.jtListaClientes.getValueAt(click, 0).toString();
        int column=cf.jtListaClientes.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/cf.jtListaClientes.getRowHeight();
        int countrow=cf.jtListaClientes.getRowCount();
        int countcolumn=cf.jtListaClientes.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=cf.jtListaClientes.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("remover")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover al cliente?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Cliente c:DAOClientes.getInstance().obtenerLista()){
                            if(c.getCodeRandom().equals(codeCliente)){
                                if(DAOClientes.getInstance().eliminar(c)){
                                    dao.mostrarDatosJFrames(cf.jtListaClientes, 1, "");
                                    Principal.getInstance().mensajeExito("Cliente ha sido removido con éxito.");
                                    break;
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo remover al cliente.");
                                    break;
                                }
                            }
                        }
                    }
                }else if(button.getName().equals("modificar")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere modificar al cliente?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Cliente c:DAOClientes.getInstance().obtenerLista()){
                            if(c.getCodeRandom().equals(codeCliente)){
                                this.cf.jtxtNumDNI.setText(c.getDni());
                                this.cf.jtxtNombresCompletos.setText(c.getNombresCompletos());
                                this.cf.jtxtDireccion.setText(c.getDireccion());
                                this.cf.jcbGenero.setSelectedItem(c.getGenero());
                                this.cf.jbtModificar.setEnabled(true);
                                this.cf.jbtRegistrarClientes.setEnabled(false);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void limpiar(){
        this.cf.jtxtNumDNI.setText(null);
        this.cf.jtxtNombresCompletos.setText(null);
        this.cf.jtxtDireccion.setText(null);
        this.cf.jcbGenero.setSelectedIndex(0);
        this.cf.jbtModificar.setEnabled(false);
        this.cf.jbtRegistrarClientes.setEnabled(true);
        this.cf.jtListaClientes.clearSelection();
    }
}

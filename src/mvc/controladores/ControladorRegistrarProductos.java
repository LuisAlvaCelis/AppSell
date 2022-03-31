package mvc.controladores;

import dao.ConexionSQL;
import dao.DAOImplements;
import dao.DAOInterface;
import dao.DAOProductos;
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
import mvc.modelos.Producto;
import source.Principal;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaRegistrarProductos;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import source.ArchivoYML;

public class ControladorRegistrarProductos extends WindowAdapter implements ActionListener{
    
    private static ControladorRegistrarProductos instance;
    private VistaRegistrarProductos rpf;
    private String usuario;
    private DAOInterface dao;
    
    public static ControladorRegistrarProductos getInstance(VistaRegistrarProductos rpf,String usuario){
        return instance=new ControladorRegistrarProductos(rpf, usuario);
    }
    
    public ControladorRegistrarProductos(VistaRegistrarProductos rpf,String usuario){
        this.rpf=rpf;
        this.rpf.setVisible(true);
        this.usuario=usuario;
        this.dao=new DAOImplements();
        this.dao.mostrarDatosJFrames(rpf.jtListaProductos, 3, "");
        this.registerEvents();
    }
    
    private void registerEvents(){
        this.rpf.jbtNuevo.addActionListener(this);
        this.rpf.jbtModificar.addActionListener(this);
        this.rpf.jbtRegistrarProducto.addActionListener(this);
        this.rpf.jbtImprimir.addActionListener(this);
        this.rpf.jtxtCantidadProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(Character.isLetter(e.getKeyChar())){
                    rpf.getToolkit().beep();
                    e.consume();
                    Principal.getInstance().mensajeError("Error: No puede ingresar letras en este campo.");
                }
            }
        });
        this.rpf.jtxtPrecioProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(Character.isLetter(e.getKeyChar())){
                    rpf.getToolkit().beep();
                    e.consume();
                    Principal.getInstance().mensajeError("Error: No puede ingresar letras en este campo.");
                }
            }
        });
        this.rpf.jtxtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                dao.mostrarDatosJFrames(rpf.jtListaProductos, 3, rpf.jtxtBuscar.getText());
            }
        });
        this.rpf.jtListaProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e);
            }
        });
        this.rpf.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(rpf.jbtRegistrarProducto==e.getSource()){
            this.btnRegistrarProducto();
        }else if(rpf.jbtNuevo==e.getSource()){
            this.limpiar();
        }else if(rpf.jbtModificar==e.getSource()){
            this.btnModificarProducto();
        }else if(rpf.jbtImprimir==e.getSource()){
            this.btnImprimir();
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try{
            if(ArchivoYML.getInstance().getFileYML().getString("Cuenta.usuario").equals(usuario)){
                ControladorPrincipal.getInstance(new VistaPrincipal(), usuario);
            }else{
                ControladorPrincipal.getInstance(new VistaPrincipal(), usuario).tipoAcceso('E');
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void btnImprimir(){
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/reportes/ReporteProductos.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr, null,new ConexionSQL().conectar());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnModificarProducto(){
        if(!rpf.jtxtCodigoProducto.getText().equalsIgnoreCase("")){
            if(!rpf.jtxtTipProducto.getText().equalsIgnoreCase("")){
                if(!rpf.jtxtNomProducto.getText().equalsIgnoreCase("")){
                    if(!rpf.jtxtCantidadProducto.getText().equalsIgnoreCase("")){
                        if(!rpf.jtxtPrecioProducto.getText().equalsIgnoreCase("")){
                            if(Integer.parseInt(rpf.jtxtCantidadProducto.getText())>0){
                                String codigoProducto=rpf.jtxtCodigoProducto.getText();
                                String tipoProducto=rpf.jtxtTipProducto.getText();
                                String nomProducto=rpf.jtxtNomProducto.getText();
                                int cantidadProducto=Integer.parseInt(rpf.jtxtCantidadProducto.getText());
                                double precioProducto=Double.parseDouble(rpf.jtxtPrecioProducto.getText());
                                for(Producto p:DAOProductos.getInstance().obtenerLista()){
                                    if(p.getId()==Integer.parseInt(rpf.jtxtCodigoProducto.getName())){
                                        p.setCodeProducto(codigoProducto);
                                        p.setNomProducto(nomProducto);
                                        p.setTipProducto(tipoProducto);
                                        p.setPrecioProducto(precioProducto);
                                        int s=JOptionPane.showConfirmDialog(null, "¿Quiere agregar el stock ingresado al stock actual o\nmodificar de forma directa al stock actual con el stock ingresado?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                                        if(s==0){
                                            p.setCantProducto((p.getCantProducto()+cantidadProducto));
                                            if(DAOProductos.getInstance().actualizar(p)){
                                                this.rpf.jbtNuevo.doClick();
                                                this.dao.mostrarDatosJFrames(rpf.jtListaProductos, 3, "");
                                                Principal.getInstance().mensajeExito("Producto actualizado con éxito.");
                                                break;
                                            }else{
                                                Principal.getInstance().mensajeError("Error: No se pudo actualizar los datos del producto.");
                                                break;
                                            }
                                        }else if(s==1){
                                            p.setCantProducto(cantidadProducto);
                                            if(DAOProductos.getInstance().actualizar(p)){
                                                this.rpf.jbtNuevo.doClick();
                                                this.dao.mostrarDatosJFrames(rpf.jtListaProductos, 3, "");
                                                Principal.getInstance().mensajeExito("Producto actualizado con éxito.");
                                                break;
                                            }else{
                                                Principal.getInstance().mensajeError("Error: No se pudo actualizar los datos del producto.");
                                                break;
                                            }
                                        }else if(s==-1){
                                            break;
                                        }else{
                                            break;
                                        }
                                    }
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: La cantidad ingresada no puede ser menor o igual a 0");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Precio del producto no ingresado.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: Cantidad del producto no ingresado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Nombre del producto no ingresado.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Tipo de producto no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: Código del producto no ingresado.");
        } 
    }
    
    private void btnRegistrarProducto(){
        if(!rpf.jtxtCodigoProducto.getText().equalsIgnoreCase("")){
            if(!rpf.jtxtTipProducto.getText().equalsIgnoreCase("")){
                if(!rpf.jtxtNomProducto.getText().equalsIgnoreCase("")){
                    if(!rpf.jtxtCantidadProducto.getText().equalsIgnoreCase("")){
                        if(!rpf.jtxtPrecioProducto.getText().equalsIgnoreCase("")){
                            if(Integer.parseInt(rpf.jtxtCantidadProducto.getText())>0){
                                String codigoProducto=rpf.jtxtCodigoProducto.getText();
                                String tipoProducto=rpf.jtxtTipProducto.getText();
                                String nomProducto=rpf.jtxtNomProducto.getText();
                                int cantidadProducto=Integer.parseInt(rpf.jtxtCantidadProducto.getText());
                                double precioProducto=Double.parseDouble(rpf.jtxtPrecioProducto.getText());
                                boolean encontrar=false;
                                for(Producto p:DAOProductos.getInstance().obtenerLista()){
                                    if(p.getCodeProducto().equals(codigoProducto)){
                                        encontrar=true;
                                        break;
                                    }
                                }
                                if(!encontrar){
                                    if(DAOProductos.getInstance().insertar(new Producto(0, codigoProducto, tipoProducto, nomProducto, cantidadProducto, precioProducto, Principal.getInstance().getFechaHora()))){
                                        this.rpf.jbtNuevo.doClick();
                                        this.dao.mostrarDatosJFrames(rpf.jtListaProductos, 3, "");
                                        Principal.getInstance().mensajeExito("Producto registrado con éxito.");
                                    }else{
                                        Principal.getInstance().mensajeError("Error: No se pudo registrar los datos del producto en la base de datos.");
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: Producto ya ha sido registrado anteriormente en la base de datos.");
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: La cantidad ingresada no puede ser menor o igual a 0");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Precio del producto no ingresado.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: Cantidad del producto no ingresado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Nombre del producto no ingresado.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Tipo de producto no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: Código del producto no ingresado.");
        }
    }
    
    private void clickTable(MouseEvent e){
        int click=rpf.jtListaProductos.rowAtPoint(e.getPoint());
        int id=Integer.parseInt(rpf.jtListaProductos.getValueAt(click, 0).toString());
        int column=rpf.jtListaProductos.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/rpf.jtListaProductos.getRowHeight();
        int countrow=rpf.jtListaProductos.getRowCount();
        int countcolumn=rpf.jtListaProductos.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=rpf.jtListaProductos.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("remover")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover el producto?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Producto p:DAOProductos.getInstance().obtenerLista()){
                            if(p.getId()==id){
                                if(DAOProductos.getInstance().eliminar(p)){
                                    this.rpf.jbtNuevo.doClick();
                                    this.dao.mostrarDatosJFrames(rpf.jtListaProductos, 3, "");
                                    Principal.getInstance().mensajeExito("Producto removido con éxito.");
                                    break;
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo remover el producto, vuelva a intentarlo.");
                                    break;
                                }
                            }
                        }
                    }
                }else if(button.getName().equals("modificar")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere modificar este producto?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Producto p:DAOProductos.getInstance().obtenerLista()){
                            if(p.getId()==id){
                                this.rpf.jtxtCodigoProducto.setText(p.getCodeProducto());
                                this.rpf.jtxtCodigoProducto.setName(String.valueOf(id));
                                this.rpf.jtxtTipProducto.setText(p.getTipProducto());
                                this.rpf.jtxtNomProducto.setText(p.getNomProducto());
                                this.rpf.jtxtCantidadProducto.setText(String.valueOf(p.getCantProducto()));
                                this.rpf.jtxtPrecioProducto.setText(String.valueOf(p.getPrecioProducto()));
                                this.rpf.jbtRegistrarProducto.setEnabled(false);
                                this.rpf.jbtModificar.setEnabled(true);

                            }
                        }
                    }
                }
            }
        }
    }
    
    private void limpiar(){
        this.rpf.jtxtCodigoProducto.setText(null);
        this.rpf.jtxtCodigoProducto.setName(null);
        this.rpf.jtxtTipProducto.setText(null);
        this.rpf.jtxtNomProducto.setText(null);
        this.rpf.jtxtCantidadProducto.setText(null);
        this.rpf.jtxtPrecioProducto.setText(null);
        this.rpf.jtxtBuscar.setText(null);
        this.rpf.jbtModificar.setEnabled(false);
        this.rpf.jbtRegistrarProducto.setEnabled(true);
        this.rpf.jtListaProductos.clearSelection();
    }
}

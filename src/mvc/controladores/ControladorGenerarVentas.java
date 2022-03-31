package mvc.controladores;

import dao.DAOImplements;
import dao.DAOInterface;
import dao.DAOProductos;
import dao.DAOVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mvc.modelos.ComprobantePago;
import mvc.modelos.Producto;
import mvc.modelos.Ventas;
import source.Principal;
import mvc.vistas.VistaClientes;
import mvc.vistas.VistaGenerarVentas;
import mvc.vistas.VistaPrincipal;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import source.ArchivoYML;

public class ControladorGenerarVentas extends WindowAdapter implements ActionListener{
    
    private static ControladorGenerarVentas instance;
    private VistaGenerarVentas gvf;
    private DAOInterface dao;
    private String usuario;
    private List<Double> listaTotal;
    
    public ControladorGenerarVentas(VistaGenerarVentas gvf,String usuario){
        this.usuario=usuario;
        this.gvf=gvf;
        this.gvf.setVisible(true);
        this.dao=new DAOImplements();
        this.listaTotal=new ArrayList<>();
        this.dao.mostrarDatosJFrames(gvf.jtListaClientes, 4, "");
        this.dao.mostrarDatosJFrames(gvf.jtListaProductos, 5, "");
        this.registerEvents();
    }
    
    public static ControladorGenerarVentas getInstance(VistaGenerarVentas gvf,String usuario){
        return instance=new ControladorGenerarVentas(gvf, usuario);
    }
    
    private void registerEvents(){
        this.gvf.jbtNuevoCliente.addActionListener(this);
        this.gvf.jbtRegistrarNuevoCliente.addActionListener(this);
        this.gvf.jbtFinalizarCompra.addActionListener(this);
        this.gvf.jbtNuevaCompra.addActionListener(this);
        
        this.gvf.jtListaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 1);
            }
        });
        this.gvf.jtListaProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 2);
            }
        });
        this.gvf.jtListaPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e, 3);
            }
        });
        
        this.gvf.jtxtBuscarCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                dao.mostrarDatosJFrames(gvf.jtListaClientes, 4, gvf.jtxtBuscarCliente.getText());
            }
        });
        this.gvf.jtxtBuscarProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                dao.mostrarDatosJFrames(gvf.jtListaProductos, 5, gvf.jtxtBuscarProducto.getText());
            }
        });
        this.gvf.jtxtDineroDadoCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(Character.isLetter(e.getKeyChar())){
                    gvf.getToolkit().beep();
                    e.consume();
                    Principal.getInstance().mensajeError("Error: No puede ingresar letras en este campo.");
                }
            }
        });
        this.gvf.addWindowListener(this);
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try {
            if(ArchivoYML.getInstance().getFileYML().getString("Cuenta.usuario").equals(usuario)){
                ControladorPrincipal.getInstance(new VistaPrincipal(), usuario);
            }else{
                ControladorPrincipal.getInstance(new VistaPrincipal(), usuario).tipoAcceso('E');
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gvf.jbtRegistrarNuevoCliente==e.getSource()){
            this.btnRegistrarNuevoCliente();
        }else if(gvf.jbtNuevoCliente==e.getSource()){
            this.btnNuevoCliente();
        }else if(gvf.jbtFinalizarCompra==e.getSource()){
            this.btnFinalizarCompra();
        }else if(gvf.jbtNuevaCompra==e.getSource()){
            this.btnNuevaCompra();
        }
    }
    
    private void btnNuevaCompra(){
        if(gvf.jtListaPedidos.getRowCount()>0){
            int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere finalizar la compra actual para realizar otra?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
            if(s==0){
                this.listaTotal.clear();
                ((DefaultTableModel)gvf.jtListaPedidos.getModel()).getDataVector().removeAllElements();
                ((DefaultTableModel)gvf.jtListaPedidos.getModel()).fireTableDataChanged();
                this.calcular();
            }
        }
    }
    
    private void btnFinalizarCompra(){
        if(gvf.jtListaPedidos.getRowCount()>0){
            int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere realizar la compra?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
            if(s==0){
                if(!gvf.jtxtCodigoClienteSeleccionado.getText().equalsIgnoreCase("")){
                    if(!gvf.jtxtDineroDadoCliente.getText().equalsIgnoreCase("")){
                        double efectivo=Double.parseDouble(gvf.jtxtDineroDadoCliente.getText());
                        double totalCompra=Double.parseDouble(gvf.jtxtTotal.getText());
                        if(efectivo>=totalCompra){
                            String codigoVenta=Principal.getInstance().getPalabraRandom();
                            for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                                String codigoProducto=gvf.jtListaPedidos.getValueAt(i, 0).toString();
                                int cantidad=Integer.parseInt(gvf.jtListaPedidos.getValueAt(i, 1).toString());
                                double total=Double.parseDouble(gvf.jtListaPedidos.getValueAt(i, 2).toString());
                                if(DAOVentas.getInstance().insertar(new Ventas(0, codigoVenta, gvf.jtxtCodigoClienteSeleccionado.getText(), codigoProducto, Principal.getInstance().getFechaHora(), usuario, cantidad, total))){
                                    for(Producto p:DAOProductos.getInstance().obtenerLista()){
                                        if(p.getCodeProducto().equals(codigoProducto)){
                                            p.setCantProducto(p.getCantProducto()-cantidad);
                                            if(DAOProductos.getInstance().actualizar(p)){
                                                System.out.println(p.getCantProducto()+" "+p.getNomProducto()+" han sido vendidos con éxito.");
                                                break;
                                            }else{
                                                Principal.getInstance().mensajeError("Error: No se pudo actualizar el stock del producto con el código "+codigoProducto);
                                                break;
                                            }
                                        }
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo vender el producto con el código "+codigoProducto);
                                    break;
                                }
                            }
                            this.imprimir(1, codigoVenta);
                            this.dao.mostrarDatosJFrames(gvf.jtListaClientes, 4, "");
                            this.dao.mostrarDatosJFrames(gvf.jtListaProductos, 5, "");
                            this.gvf.jtxtCodigoClienteSeleccionado.setText(null);
                            this.gvf.jtxtDineroDadoCliente.setText(null);
                            Principal.getInstance().mensajeExito("Compra realizada con éxito");
                            this.gvf.jbtNuevaCompra.doClick();
                        }else{
                            Principal.getInstance().mensajeError("Error: Efectivo ingresado es menor que el total de la compra.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: No se ingresó el dinero del cliente");
                    }
                }else{
                    if(!gvf.jtxtDineroDadoCliente.getText().equalsIgnoreCase("")){
                        double efectivo=Double.parseDouble(gvf.jtxtDineroDadoCliente.getText());
                        double totalCompra=Double.parseDouble(gvf.jtxtTotal.getText());
                        if(efectivo>=totalCompra){
                            String codigoVenta=Principal.getInstance().getPalabraRandom();
                            for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                                String codigoProducto=gvf.jtListaPedidos.getValueAt(i, 0).toString();
                                int cantidad=Integer.parseInt(gvf.jtListaPedidos.getValueAt(i, 1).toString());
                                double total=Double.parseDouble(gvf.jtListaPedidos.getValueAt(i, 2).toString());
                                if(DAOVentas.getInstance().insertar(new Ventas(0, codigoVenta, "CLIENTE NO REGISTRADO", codigoProducto, Principal.getInstance().getFechaHora(), usuario, cantidad, total))){
                                    for(Producto p:DAOProductos.getInstance().obtenerLista()){
                                        if(p.getCodeProducto().equals(codigoProducto)){
                                            p.setCantProducto(p.getCantProducto()-cantidad);
                                            if(DAOProductos.getInstance().actualizar(p)){
                                                System.out.println(p.getCantProducto()+" "+p.getNomProducto()+" han sido vendidos con éxito.");
                                                break;
                                            }else{
                                                Principal.getInstance().mensajeError("Error: No se pudo actualizar el stock del producto con el código "+codigoProducto);
                                                break;
                                            }
                                        }
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo vender el producto con el código "+codigoProducto);
                                    break;
                                }
                            }
                            this.imprimir(2, codigoVenta);
                            this.dao.mostrarDatosJFrames(gvf.jtListaClientes, 4, "");
                            this.dao.mostrarDatosJFrames(gvf.jtListaProductos, 5, "");
                            Principal.getInstance().mensajeExito("Compra realizada con éxito");
                            this.gvf.jtxtDineroDadoCliente.setText(null);
                            this.gvf.jbtNuevaCompra.doClick();
                        }else{
                            Principal.getInstance().mensajeError("Error: Efectivo ingresado es menor que el total de la compra.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: No se ingresó el dinero del cliente");
                    }
                }
            }
        }
    }
    
    private void btnNuevoCliente(){
        this.gvf.jtxtCodigoClienteSeleccionado.setText(null);
        this.dao.mostrarDatosJFrames(gvf.jtListaClientes, 4, "");
    }
    
    private void btnRegistrarNuevoCliente(){
        try {
            ControladorClientes.getInstance(new VistaClientes(), usuario).setModoEntrada("GenerarVentas");
            this.gvf.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void clickTable(MouseEvent e,int num){
        if(num==1){
            this.tablaClientes(e);
        }else if(num==2){
            this.tablaProductos(e);
        }else if(num==3){
            this.tablaPedidos(e);
        }
    }
    
    private void tablaClientes(MouseEvent e){
        int click=gvf.jtListaClientes.rowAtPoint(e.getPoint());
        String codigoCliente=gvf.jtListaClientes.getValueAt(click, 0).toString();
        int column=gvf.jtListaClientes.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/gvf.jtListaClientes.getRowHeight();
        int countrow=gvf.jtListaClientes.getRowCount();
        int countcolumn=gvf.jtListaClientes.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=gvf.jtListaClientes.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("seleccionar")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere seleccionar a este cliente?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        this.gvf.jtxtCodigoClienteSeleccionado.setText(codigoCliente);
                        this.gvf.jtListaClientes.clearSelection();
                    }
                }
            }
        }
    }
    
    private void tablaProductos(MouseEvent e){
        int click=gvf.jtListaProductos.rowAtPoint(e.getPoint());
        String codigoProducto=gvf.jtListaProductos.getValueAt(click, 0).toString();
        int column=gvf.jtListaProductos.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/gvf.jtListaProductos.getRowHeight();
        int countrow=gvf.jtListaProductos.getRowCount();
        int countcolumn=gvf.jtListaProductos.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=gvf.jtListaProductos.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("seleccionar")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere seleccionar este producto?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        String cantidadS=(String)JOptionPane.showInputDialog(null, "Ingrese la cantidad de productos que desee:", "Cantidad", 0,new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")) , null, null);
                        if(cantidadS!=null){
                            String cantidadConvertida=cantidadS.replaceAll("[^0-9]", "");
                            if(!cantidadConvertida.isEmpty()){
                                int cant=Integer.parseInt(cantidadConvertida);
                                for(Producto p:DAOProductos.getInstance().obtenerLista()){
                                    if(p.getCodeProducto().equals(codigoProducto)){
                                        if(cant<=p.getCantProducto()){
                                            boolean encontrado=false;
                                            for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                                                if(gvf.jtListaPedidos.getValueAt(i, 0).equals(codigoProducto)){
                                                    encontrado=true;
                                                    break;
                                                }
                                            }
                                            if(!encontrado){
                                                double total=Math.round((p.getPrecioProducto() * cant)*100.0)/100.0;
                                                JButton boton=new JButton("Remover");
                                                boton.setName("remover");
                                                Object[] rows=new Object[gvf.jtListaPedidos.getModel().getColumnCount()];
                                                rows[0]=p.getCodeProducto();
                                                rows[1]=cant;
                                                rows[2]=total;
                                                rows[3]=boton;
                                                ((DefaultTableModel)gvf.jtListaPedidos.getModel()).addRow(rows);
                                                ((DefaultTableModel)gvf.jtListaPedidos.getModel()).fireTableDataChanged();
                                                this.listaTotal.add(total);
                                                this.calcular();
                                                this.gvf.jtListaProductos.clearSelection();
                                                break;
                                            }else{
                                                for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                                                    if(gvf.jtListaPedidos.getValueAt(i, 0).equals(codigoProducto)){
                                                        for(int j=0;j<listaTotal.size();i++){
                                                            if(listaTotal.get(i)==Double.parseDouble(gvf.jtListaPedidos.getValueAt(i, 2).toString())){
                                                                this.listaTotal.remove(j);
                                                                break;
                                                            }
                                                        }
                                                        int nuevaCantidad=Integer.parseInt(gvf.jtListaPedidos.getValueAt(i, 1).toString())+cant;
                                                        this.gvf.jtListaPedidos.setValueAt(nuevaCantidad, i, 1);
                                                        double total=Math.round((p.getPrecioProducto() * nuevaCantidad)*100.0)/100.0;
                                                        this.gvf.jtListaPedidos.setValueAt(total, i, 2);
                                                        this.listaTotal.add(total);
                                                        this.calcular();
                                                        this.gvf.jtListaProductos.clearSelection();
                                                    }
                                                }
                                            }
                                        }else{
                                            Principal.getInstance().mensajeError("Error: Cantidad solicitada supera al stock, vuelva a intentarlo.");
                                            break;
                                        }
                                    }
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: La cantidad ingresada debe ser en números.");
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void tablaPedidos(MouseEvent e){
        int click=gvf.jtListaPedidos.rowAtPoint(e.getPoint());
        double total=Double.parseDouble(gvf.jtListaPedidos.getValueAt(click, 2).toString());
        int column=gvf.jtListaPedidos.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/gvf.jtListaPedidos.getRowHeight();
        int countrow=gvf.jtListaPedidos.getRowCount();
        int countcolumn=gvf.jtListaPedidos.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=gvf.jtListaPedidos.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("remover")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover el pedido?", "Confirmación", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        ((DefaultTableModel)gvf.jtListaPedidos.getModel()).getDataVector().remove(gvf.jtListaPedidos.getSelectedRow());
                        ((DefaultTableModel)gvf.jtListaPedidos.getModel()).fireTableDataChanged();
                        listaTotal.clear();
                        for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                            double tt=Double.parseDouble(gvf.jtListaPedidos.getValueAt(i, 2).toString());
                            listaTotal.add(tt);
                        }
                        this.calcular();
                    }
                }
            }
        }
    }
    
    private void calcular(){
        double contador=0;
        for(int i=0;i<listaTotal.size();i++){
            contador=contador+listaTotal.get(i);
        }
        double igv=Math.round((0.18*contador)*100.0)/100.0;
        double totalCompra=Math.round((contador+igv)*100.0)/100.0;
        this.gvf.jtxtSubTotal.setText(String.valueOf(Math.round(contador*100.0)/100.0));
        this.gvf.jtxtIGV.setText(String.valueOf(igv));
        this.gvf.jtxtTotal.setText(String.valueOf(totalCompra));
    }
    
    private void imprimir(int num,String codigoVenta){
        if(num==1){
            ArrayList<ComprobantePago> lista=new ArrayList<>();
            for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                for(Producto p:DAOProductos.getInstance().obtenerLista()){
                    if(p.getCodeProducto().equals(gvf.jtListaPedidos.getValueAt(i, 0).toString())){
                        String producto=p.getNomProducto();
                        int cantidad=Integer.parseInt(gvf.jtListaPedidos.getValueAt(i, 1).toString());
                        double costo=Double.parseDouble(gvf.jtListaPedidos.getValueAt(i, 2).toString());
                        lista.add(new ComprobantePago(producto, cantidad, costo));
                        break;
                    }
                }
            }
            try {
                double montoDado=Math.round(Integer.parseInt(gvf.jtxtDineroDadoCliente.getText())*100.0)/100.0;
                double vuelto=montoDado-Double.parseDouble(gvf.jtxtTotal.getText());
                Map<String,Object> map=new HashMap<>();
                map.put("parameter1", "S/. "+gvf.jtxtSubTotal.getText());
                map.put("parameter2", "S/. "+gvf.jtxtIGV.getText());
                map.put("parameter3", "S/. "+gvf.jtxtTotal.getText());
                map.put("parameter4", "S/. "+Math.round(montoDado*100.0)/100.0);
                map.put("parameter5", "S/. "+Math.round(vuelto*100.0)/100.0);
                map.put("parameter6", codigoVenta);
                map.put("parameter7", gvf.jtxtCodigoClienteSeleccionado.getText());
                JasperReport jr=JasperCompileManager.compileReport("src/reportes/ReporteComprobante.jrxml");
                JasperPrint jp=JasperFillManager.fillReport(jr, map,new JRBeanCollectionDataSource(lista));
                JasperViewer.viewReport(jp,false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==2){
            ArrayList<ComprobantePago> lista=new ArrayList<>();
            for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                for(Producto p:DAOProductos.getInstance().obtenerLista()){
                    if(p.getCodeProducto().equals(gvf.jtListaPedidos.getValueAt(i, 0).toString())){
                        String producto=p.getNomProducto();
                        int cantidad=Integer.parseInt(gvf.jtListaPedidos.getValueAt(i, 1).toString());
                        double costo=Double.parseDouble(gvf.jtListaPedidos.getValueAt(i, 2).toString());
                        lista.add(new ComprobantePago(producto, cantidad, costo));
                        break;
                    }
                }
            }
            try {
                double montoDado=Math.round(Integer.parseInt(gvf.jtxtDineroDadoCliente.getText())*100.0)/100.0;
                double vuelto=montoDado-Double.parseDouble(gvf.jtxtTotal.getText());
                Map<String,Object> map=new HashMap<>();
                map.put("parameter1", "S/. "+gvf.jtxtSubTotal.getText());
                map.put("parameter2", "S/. "+gvf.jtxtIGV.getText());
                map.put("parameter3", "S/. "+gvf.jtxtTotal.getText());
                map.put("parameter4", "S/. "+Math.round(montoDado*100.0)/100.0);
                map.put("parameter5", "S/. "+Math.round(vuelto*100.0)/100.0);
                map.put("parameter6", codigoVenta);
                map.put("parameter7", "CLIENTE NO REGISTRADO");
                JasperReport jr=JasperCompileManager.compileReport("src/reportes/ReporteComprobante.jrxml");
                JasperPrint jp=JasperFillManager.fillReport(jr, map,new JRBeanCollectionDataSource(lista));
                JasperViewer.viewReport(jp,false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /*
    private void imprimir(int num){
        try {
            if(num==1){
                DefaultStyledDocument document = new DefaultStyledDocument();
                JTextArea jta=new JTextArea();
                jta.append("Venta de productos deportivos\n\n"
                        + "RUC 123123123    Tlf: 3159000 - 2067543 - AV. NOSEXD AEAMANITO Nro. 123123 \n\n"
                        + "FECHA DE EMISIÓN     : "+Principal.getInstance().getFechaHora()+"\n"
                        + "CÓDIGO DE COMPRA   : "+gvf.jtxtCodigoCompra.getText()+"\n"
                        + "CÓDIGO DEL CLIENTE  : "+gvf.jtxtCodigoClienteSeleccionado.getText()+"\n\n"
                        + "Cantidad  Importe  Producto\n");
                DecimalFormat df=new DecimalFormat("##0.00");
                for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                    jta.append((listaCantidadProductos.get(i)<99?"":"           ")+listaCantidadProductos.get(i)+"           "+(listaTotal.get(i)<99?"     ":"     ")+listaTotal.get(i)+"      "+dao.getNOMBREPRUDUCTO_CODIGOPRODUCTO(listaCodigosProductos.get(i))+"\n");
                }
                if(!dao.getNOMBRESCOMPLETOS_DNI(dao.getDNI_USUARIO(usuario)).equalsIgnoreCase("")){
                    jta.append("-----------------------------------------------------------------------------------------------------\n\n"
                            + "Sub Total            : "+df.format(Double.parseDouble(gvf.jtxtSubTotal.getText()))+"\n"
                            + "IGV (18%)          : "+df.format(Double.parseDouble(gvf.jtxtIGV.getText()))+"\n"
                            + "Total                   : "+gvf.jtxtTotal.getText()+"\n"
                            + "Efectivo              : "+df.format(efectivo)+"\n"
                            + "Vuelto                 : "+df.format((Double.parseDouble(gvf.jtxtDineroDadoCliente.getText()))-totalCompra)+"\n\n"
                            + "ATENDIDO POR\n"
                            + "         "+dao.getNOMBRESCOMPLETOS_DNI(dao.getDNI_USUARIO(usuario))+"\n\n"
                            + "GRACIAS POR SU COMPRA, VUELVA PRONTO\n\n"
                            + "                                    LIMA - 2019");
                    MessageFormat headerFormat=new MessageFormat("");
                    MessageFormat footerFormat=new MessageFormat("");
                    document.insertString(0, "\n\n"+jta.getText(), null);
                    JTextPane pane = new JTextPane(document);
                    pane.setEditable(false);
                    pane.insertIcon(new ImageIcon(getClass().getResource("/imagenes/fondo500x100.png")));
                    pane.print(headerFormat, footerFormat);
                    Principal.getInstance().mensajeExito("Commpra realizada.");
                    this.gvf.jbtNuevaCompra.doClick();
                }else{
                    jta.append("-----------------------------------------------------------------------------------------------------\n\n"
                            + "Sub Total            : "+df.format(Double.parseDouble(gvf.jtxtSubTotal.getText()))+"\n"
                            + "IGV (18%)          : "+df.format(Double.parseDouble(gvf.jtxtIGV.getText()))+"\n"
                            + "Total                   : "+gvf.jtxtTotal.getText()+"\n"
                            + "Efectivo              : "+df.format(efectivo)+"\n"
                            + "Vuelto                 : "+df.format((Double.parseDouble(gvf.jtxtDineroDadoCliente.getText()))-totalCompra)+"\n\n"
                            + "ATENDIDO POR\n"
                            + "         ADMINISTRADOR\n\n"
                            + "GRACIAS POR SU COMPRA, VUELVA PRONTO\n\n"
                            + "                                                 LIMA - 2019");
                    MessageFormat headerFormat=new MessageFormat("");
                    MessageFormat footerFormat=new MessageFormat("");
                    document.insertString(0, "\n\n"+jta.getText(), null);
                    JTextPane pane = new JTextPane(document);
                    pane.setEditable(false);
                    pane.insertIcon(new ImageIcon(getClass().getResource("/imagenes/fondo500x100.png")));
                    pane.print(headerFormat, footerFormat);
                    Principal.getInstance().mensajeExito("Commpra realizada.");
                    this.gvf.jbtNuevaCompra.doClick();
                }
            }else if(num==2){
                DefaultStyledDocument document = new DefaultStyledDocument();
                JTextArea jta=new JTextArea();
                jta.append("Venta de productos deportivos\n\n"
                        + "RUC 123123123    Tlf: 3159000 - 2067543 - AV. NOSEXD AEAMANITO Nro. 123123 \n\n"
                        + "FECHA DE EMISIÓN     : "+Principal.getInstance().getFechaHora()+"\n"
                        + "CÓDIGO DE COMPRA   : "+gvf.jtxtCodigoCompra.getText()+"\n\n"
                        + "Cantidad  Importe  Producto\n");
                DecimalFormat df=new DecimalFormat("##0.00");
                for(int i=0;i<gvf.jtListaPedidos.getRowCount();i++){
                    jta.append((listaCantidadProductos.get(i)<99?"":"           ")+listaCantidadProductos.get(i)+"           "+(listaTotal.get(i)<99?"     ":"     ")+listaTotal.get(i)+"      "+dao.getNOMBREPRUDUCTO_CODIGOPRODUCTO(listaCodigosProductos.get(i))+"\n");
                }
                if(!dao.getNOMBRESCOMPLETOS_DNI(dao.getDNI_USUARIO(usuario)).equalsIgnoreCase("")){
                    jta.append("-----------------------------------------------------------------------------------------------------\n\n"
                            + "Sub Total            : "+df.format(Double.parseDouble(gvf.jtxtSubTotal.getText()))+"\n"
                            + "IGV (18%)          : "+df.format(Double.parseDouble(gvf.jtxtIGV.getText()))+"\n"
                            + "Total                   : "+gvf.jtxtTotal.getText()+"\n"
                            + "Efectivo              : "+df.format(efectivo)+"\n"
                            + "Vuelto                 : "+df.format((Double.parseDouble(gvf.jtxtDineroDadoCliente.getText()))-totalCompra)+"\n\n"
                            + "ATENDIDO POR\n"
                            + "         "+dao.getNOMBRESCOMPLETOS_DNI(dao.getDNI_USUARIO(usuario))+"\n\n"
                            + "GRACIAS POR SU COMPRA, VUELVA PRONTO\n\n"
                            + "                                    LIMA - 2019");
                    MessageFormat headerFormat=new MessageFormat("");
                    MessageFormat footerFormat=new MessageFormat("");
                    document.insertString(0, "\n\n"+jta.getText(), null);
                    JTextPane pane = new JTextPane(document);
                    pane.setEditable(false);
                    pane.insertIcon(new ImageIcon(getClass().getResource("/imagenes/fondo500x100.png")));
                    pane.print(headerFormat, footerFormat);
                    Principal.getInstance().mensajeExito("Commpra realizada.");
                    this.gvf.jbtNuevaCompra.doClick();
                }else{
                    jta.append("-----------------------------------------------------------------------------------------------------\n\n"
                            + "Sub Total            : "+df.format(Double.parseDouble(gvf.jtxtSubTotal.getText()))+"\n"
                            + "IGV (18%)          : "+df.format(Double.parseDouble(gvf.jtxtIGV.getText()))+"\n"
                            + "Total                   : "+gvf.jtxtTotal.getText()+"\n"
                            + "Efectivo              : "+df.format(efectivo)+"\n"
                            + "Vuelto                 : "+df.format((Double.parseDouble(gvf.jtxtDineroDadoCliente.getText()))-totalCompra)+"\n\n"
                            + "ATENDIDO POR\n"
                            + "         ADMINISTRADOR\n\n"
                            + "GRACIAS POR SU COMPRA, VUELVA PRONTO\n\n"
                            + "                                                 LIMA - 2019");
                    MessageFormat headerFormat=new MessageFormat("");
                    MessageFormat footerFormat=new MessageFormat("");
                    document.insertString(0, "\n\n"+jta.getText(), null);
                    JTextPane pane = new JTextPane(document);
                    pane.setEditable(false);
                    pane.insertIcon(new ImageIcon(getClass().getResource("/imagenes/fondo500x100.png")));
                    pane.print(headerFormat, footerFormat);
                    Principal.getInstance().mensajeExito("Commpra realizada.");
                    this.gvf.jbtNuevaCompra.doClick();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

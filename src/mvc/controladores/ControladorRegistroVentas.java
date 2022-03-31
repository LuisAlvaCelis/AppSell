package mvc.controladores;

import dao.ConexionSQL;
import dao.DAOImplements;
import dao.DAOInterface;
import dao.DAOVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import mvc.modelos.Ventas;
import source.Principal;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaRegistroVentas;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import source.ArchivoYML;

public class ControladorRegistroVentas extends WindowAdapter implements ActionListener{
    
    private static ControladorRegistroVentas instance;
    private VistaRegistroVentas rvf;
    private DAOInterface dao;
    private String usuario;
    
    public static ControladorRegistroVentas getInstance(VistaRegistroVentas rvf,String usuario){
        return instance=new ControladorRegistroVentas(rvf, usuario);
    }
    
    public ControladorRegistroVentas(VistaRegistroVentas rvf,String usuario){
        this.rvf=rvf;
        this.rvf.setVisible(true);
        this.usuario=usuario;
        this.dao=new DAOImplements();
        this.dao.mostrarDatosJFrames(rvf.jtListaVentas, 6, "");
        this.registerEvents();
        this.calcularTotalRecaudado();
    }
    
    private void calcularTotalRecaudado(){
        double count=0;
        for(Ventas v:DAOVentas.getInstance().obtenerLista()){
            count=count+v.getImporteTotal();
        }
        this.rvf.jlTotalRecaudado.setText(String.valueOf(Math.round(count*100.0)/100.0));
    }
    
    private void registerEvents(){
        this.rvf.jbtImprimir.addActionListener(this);
        this.rvf.jtxtBuscarCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                dao.mostrarDatosJFrames(rvf.jtListaVentas, 6, rvf.jtxtBuscarCliente.getText());
            }
        });
        this.rvf.jtListaVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e);
            }
        });
        this.rvf.addWindowListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(rvf.jbtImprimir==e.getSource()){
            this.btnImprimir();
        }
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
    
    private void btnImprimir(){
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/reportes/ReporteVentas.jrxml");
            Map<String,Object> map=new HashMap<>();
            map.put("RecaudacionTotal"," S/."+rvf.jlTotalRecaudado.getText()+" soles");
            JasperPrint jp=JasperFillManager.fillReport(jr,map,new ConexionSQL().conectar());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void clickTable(MouseEvent e){
        int click=rvf.jtListaVentas.rowAtPoint(e.getPoint());
        int id=Integer.parseInt(rvf.jtListaVentas.getValueAt(click, 0).toString());
        int column=rvf.jtListaVentas.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/rvf.jtListaVentas.getRowHeight();
        int countrow=rvf.jtListaVentas.getRowCount();
        int countcolumn=rvf.jtListaVentas.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=rvf.jtListaVentas.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("removerF")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover la fila?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Ventas v:DAOVentas.getInstance().obtenerLista()){
                            if(v.getId()==id){
                                if(DAOVentas.getInstance().eliminar(v, 1)){
                                    this.calcularTotalRecaudado();
                                    this.dao.mostrarDatosJFrames(rvf.jtListaVentas, 6, "");
                                    Principal.getInstance().mensajeExito("Fila removida con éxito.");
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo remover la fila de venta, verifique la consola y/o revice su base de datos.");
                                }
                            }
                        }
                    }
                }else if(button.getName().equals("removerG")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover al grupo?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Ventas v:DAOVentas.getInstance().obtenerLista()){
                            if(v.getId()==id){
                                if(DAOVentas.getInstance().eliminar(v, 2)){
                                    this.calcularTotalRecaudado();
                                    this.dao.mostrarDatosJFrames(rvf.jtListaVentas, 6, "");
                                    Principal.getInstance().mensajeExito("Fila removida con éxito.");
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo remover la fila de venta, verifique la consola y/o revice su base de datos.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

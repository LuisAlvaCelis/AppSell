package mvc.controladores;

import dao.ConexionSQL;
import dao.DAOCuentas;
import dao.DAOEmpleados;
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
import mvc.modelos.Cuenta;
import mvc.modelos.Empleado;
import source.Principal;
import mvc.vistas.VistaDatosEmpleados;
import mvc.vistas.VistaRegistrarEmpleados;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ControladorDatosEmpleados extends WindowAdapter implements ActionListener{

    private static ControladorDatosEmpleados instance;
    private VistaDatosEmpleados def;
    private String usuario;
    private DAOInterface dao;
    
    public static ControladorDatosEmpleados getInstance(VistaDatosEmpleados def,String usuario){
        return instance=new ControladorDatosEmpleados(def, usuario);
    }
    
    public ControladorDatosEmpleados(VistaDatosEmpleados def,String usuario){
        this.def=def;
        this.def.setVisible(true);
        this.usuario=usuario;
        this.dao=new DAOImplements();
        this.dao.mostrarDatosJFrames(def.jtListaEmpleados, 2, "");
        this.registerEvents();
    }
    
    private void registerEvents(){
        this.def.jbtImprimir.addActionListener(this);
        this.def.jtListaEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                clickTable(e);
            }
        });
        this.def.jtxtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                try {
                    dao.mostrarDatosJFrames(def.jtListaEmpleados, 2, def.jtxtBuscar.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.def.addWindowListener(this);
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try {
            ControladorRegistrarEmpleados.getInstance(new VistaRegistrarEmpleados(), usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(def.jbtImprimir==e.getSource()){
            this.btnImprimir();
        }
    }
    
    private void clickTable(MouseEvent e){
        int click=def.jtListaEmpleados.rowAtPoint(e.getPoint());
        int id=Integer.parseInt(def.jtListaEmpleados.getValueAt(click, 0).toString());
        int column=def.jtListaEmpleados.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/def.jtListaEmpleados.getRowHeight();
        int countrow=def.jtListaEmpleados.getRowCount();
        int countcolumn=def.jtListaEmpleados.getColumnCount();
        if(row<countrow && row>=0 && column<countcolumn && column>=0){
            Object value=def.jtListaEmpleados.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("remover")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover al empleado?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        for(Cuenta auxC:DAOCuentas.getInstance().obtenerLista()){
                            if(auxC.getId()==id){
                                if(DAOCuentas.getInstance().eliminar(auxC)){
                                    for(Empleado auxE:DAOEmpleados.getInstance().obtenerLista()){
                                        if(auxE.getId()==id){
                                            if(DAOEmpleados.getInstance().eliminar(auxE)){
                                                dao.mostrarDatosJFrames(def.jtListaEmpleados, 2, "");
                                                Principal.getInstance().mensajeExito("Empleado actualizado con éxito.");
                                                break;
                                            }else{
                                                Principal.getInstance().mensajeError("Error: No se pudo remover la empleado.");
                                                break;
                                            }
                                        }
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: No se pudo remover la cuenta del empleado.");
                                    break;
                                }
                            }
                        }
                    }
                }else if(button.getName().equals("modificar")){
                    int s=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere modificar al empleado?", "Error", 0, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
                    if(s==0){
                        try{
                            ControladorRegistrarEmpleados.getInstance(new VistaRegistrarEmpleados(), usuario).setAction(id);
                            def.dispose();
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    private void btnImprimir(){
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/reportes/ReporteEmpleados.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr, null,new ConexionSQL().conectar());
            JasperViewer.viewReport(jp,false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

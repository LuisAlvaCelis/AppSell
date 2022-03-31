package mvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import source.ArchivoYML;
import source.Principal;
import mvc.vistas.VistaClientes;
import mvc.vistas.VistaGenerarVentas;
import mvc.vistas.VistaLogin;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaRegistrarEmpleados;
import mvc.vistas.VistaRegistrarProductos;
import mvc.vistas.VistaRegistrarSQL;
import mvc.vistas.VistaRegistroVentas;

public class ControladorPrincipal extends WindowAdapter implements ActionListener{

    private static ControladorPrincipal instance;
    private static VistaPrincipal pf;
    private String usuario;
    
    public static ControladorPrincipal getInstance(VistaPrincipal pf,String usuario){
        return instance=new ControladorPrincipal(pf,usuario);
    }
    
    public ControladorPrincipal(VistaPrincipal pf,String usuario){
        this.usuario=usuario;
        this.pf=pf;
        this.pf.setVisible(true);
        this.registerEvents();
    }
    
    private void registerEvents(){
        this.pf.jmiSalir.addActionListener(this);
        this.pf.jmiRegistroSQL.addActionListener(this);
        this.pf.jmiEmpleados.addActionListener(this);
        this.pf.jmiClientes.addActionListener(this);
        this.pf.jmiProductos.addActionListener(this);
        this.pf.jmiGenerarVentas.addActionListener(this);
        this.pf.jmiRegistroVentas.addActionListener(this);
        this.pf.addWindowListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(pf.jmiSalir==e.getSource()){
            this.btnSalir();
        }else if(pf.jmiRegistroSQL==e.getSource()){
            this.btnRegistroSQL();
        }else if(pf.jmiEmpleados==e.getSource()){
            this.btnEmpleados();
        }else if(pf.jmiClientes==e.getSource()){
            this.btnClientes();
        }else if(pf.jmiProductos==e.getSource()){
            this.btnProductos();
        }else if(pf.jmiGenerarVentas==e.getSource()){
            this.btnGenerarVentas();
        }else if(pf.jmiRegistroVentas==e.getSource()){
            this.btnRegistroVentas();
        }
    }
    
    private void btnRegistroVentas(){
        try {
            if(ArchivoYML.getInstance().getStatusYML()==true){
                ControladorRegistroVentas.getInstance(new VistaRegistroVentas(), usuario);
                this.pf.dispose();
            }else{
                Principal.getInstance().mensajeError("Error: SQL no registrado en el archivo YML.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnGenerarVentas(){
        try {
            if(ArchivoYML.getInstance().getStatusYML()==true){
                ControladorGenerarVentas.getInstance(new VistaGenerarVentas(), usuario);
                this.pf.dispose();
            }else{
                Principal.getInstance().mensajeError("Error: SQL no registrado en el archivo YML.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    private void btnProductos(){
        try {
            if(ArchivoYML.getInstance().getStatusYML()==true){
                ControladorRegistrarProductos.getInstance(new VistaRegistrarProductos(), usuario);
                this.pf.dispose();
            }else{
                Principal.getInstance().mensajeError("Error: SQL no registrado en el archivo YML.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnClientes(){
        try {
            if(ArchivoYML.getInstance().getStatusYML()==true){
                ControladorClientes.getInstance(new VistaClientes(), usuario).setModoEntrada("Principal");
                this.pf.dispose();
            }else{
                Principal.getInstance().mensajeError("Error: SQL no registrado en el archivo YML.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnEmpleados(){
        try {
            if(ArchivoYML.getInstance().getStatusYML()==true){
                ControladorRegistrarEmpleados.getInstance(new VistaRegistrarEmpleados(), usuario);
                this.pf.dispose();
            }else{
                Principal.getInstance().mensajeError("Error: SQL no registrado en el archivo YML.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnRegistroSQL(){
        try {
            ControladorRegistrarSQL.getIntance(new VistaRegistrarSQL(), usuario);
            this.pf.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnSalir(){
        try {
            ControladorLogin.getInstance(new VistaLogin());
            this.pf.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try {
            ControladorLogin.getInstance(new VistaLogin());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void tipoAcceso(char type){
        if(type=='E'){
            this.pf.jmMenu.remove(pf.jmAdministrador);
            this.pf.repaint();
        }
    }
}

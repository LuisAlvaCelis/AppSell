package mvc.controladores;

import dao.DAOImplements;
import dao.DAOInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import source.ArchivoYML;
import source.Principal;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaRegistrarSQL;

public class ControladorRegistrarSQL extends WindowAdapter implements ActionListener{

    private static ControladorRegistrarSQL instance;
    private VistaRegistrarSQL rsqlf;
    private String usuario;
    private DAOInterface dao;
    
    public ControladorRegistrarSQL(VistaRegistrarSQL rsqlf,String usuario){
        this.usuario=usuario;
        this.rsqlf=rsqlf;
        this.rsqlf.setVisible(true);
        this.dao=new DAOImplements();
        this.registerEvents();
    }
    
    public static ControladorRegistrarSQL getIntance(VistaRegistrarSQL rsqlf,String usuario){
        return instance=new ControladorRegistrarSQL(rsqlf, usuario);
    }
    
    private void registerEvents(){
        this.rsqlf.jbtMostrar.addActionListener(this);
        this.rsqlf.jbtRegistrarSQL.addActionListener(this);
        this.rsqlf.addWindowListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(rsqlf.jbtMostrar==e.getSource()){
            this.btnMostrar();
        }else if(rsqlf.jbtRegistrarSQL==e.getSource()){
            this.btnRegistrarSQL();
        }
    }
    
    private void btnRegistrarSQL(){
        if(!rsqlf.jtxtIP.getText().equalsIgnoreCase("")){
            if(!rsqlf.jtxtPORT.getText().equalsIgnoreCase("")){
                if(!rsqlf.jtxtDATABASE.getText().equalsIgnoreCase("")){
                    if(!rsqlf.jtxtUSERNAME.getText().equalsIgnoreCase("")){
                        String ip=rsqlf.jtxtIP.getText();
                        String port=rsqlf.jtxtPORT.getText();
                        String database=rsqlf.jtxtDATABASE.getText();
                        String username=rsqlf.jtxtUSERNAME.getText();
                        String password=null;
                        if(!rsqlf.jpassPASSWORD.getText().equalsIgnoreCase("")){
                            password=rsqlf.jpassPASSWORD.getText();
                        }else{
                            password="";
                        }
                        if(ArchivoYML.getInstance().reloadFileYML(true, ip, port, database, username, password)==true){
                            if(dao.crearBD()==true){
                                if(dao.crearTablaEmpleados()==true){
                                    if(dao.crearTablaCuentas()==true){
                                        if(dao.crearTablaClientes()==true){
                                            if(dao.crearTablaProductos()==true){
                                                if(dao.crearTablaVentas()==true){
                                                    this.limpiar();
                                                    Principal.getInstance().mensajeExito("Base de datos creado con éxito.");
                                                }else{
                                                    Principal.getInstance().mensajeError("Error: Tabla ventas no creada, verifique la consola y/o la base de datos.");
                                                }
                                            }else{
                                                Principal.getInstance().mensajeError("Error: Tabla productos no creada, verifique la consola y/o la base de datos.");
                                            }
                                        }else{
                                            Principal.getInstance().mensajeError("Error: Tabla clientes no creada, verifique la consola y/o la base de datos.");
                                        }
                                    }else{
                                        Principal.getInstance().mensajeError("Error: Tabla cuentas no creada, verifique la consola y/o la base de datos.");
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: Tabla empleados no creada, verifique la consola y/o la base de datos.");
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: No se pudo crear la base de datos, verifique la consola.");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: No se pudo guardar la cuenta de la base de datos en el archivo YML, verifique la consola.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: USERNAME no ingresado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: DATABASE no ingresada.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: PORT no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: IP no ingresado.");
        }
    }
    
    private void btnMostrar(){
        if(rsqlf.jbtMostrar.isSelected()){
            this.rsqlf.jpassPASSWORD.setEchoChar((char)0);
        }else{
            this.rsqlf.jpassPASSWORD.setEchoChar('*');
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
    
    private void limpiar(){
        this.rsqlf.jtxtIP.setText(null);
        this.rsqlf.jtxtPORT.setText(null);
        this.rsqlf.jtxtDATABASE.setText(null);
        this.rsqlf.jtxtUSERNAME.setText(null);
        this.rsqlf.jpassPASSWORD.setText(null);
    }
}

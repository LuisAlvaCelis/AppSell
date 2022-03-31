package mvc.controladores;

import dao.DAOCuentas;
import dao.DAOImplements;
import dao.DAOInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.modelos.Cuenta;
import source.ArchivoYML;
import source.Principal;
import mvc.vistas.VistaLogin;
import mvc.vistas.VistaPrincipal;

public class ControladorLogin implements ActionListener{

    private static ControladorLogin instance;
    private VistaLogin lf;
    private DAOInterface dao;
    
    public ControladorLogin(VistaLogin lf){
        this.lf=lf;
        this.lf.setVisible(true);
        this.dao=new DAOImplements();
        this.registerEvents();
    }
    
    public static ControladorLogin getInstance(VistaLogin lf){
        return instance=new ControladorLogin(lf);
    }
    
    private void registerEvents(){
        this.lf.jbtMostrarContra.addActionListener(this);
        this.lf.jbtIngresar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(lf.jbtMostrarContra==e.getSource()){
            this.btnMostrarContra();
        }else if(lf.jbtIngresar==e.getSource()){
            this.btnIngresar();
        }
    }
    
    private void btnIngresar(){
        try {
            if(!lf.jtxtUsuario.getText().equalsIgnoreCase("")){
                if(!lf.jpassContra.getText().equalsIgnoreCase("")){
                    String usuario=lf.jtxtUsuario.getText();
                    String clave=new String(lf.jpassContra.getPassword());
                    if(usuario.equalsIgnoreCase(ArchivoYML.getInstance().getFileYML().getString("Cuenta.usuario"))){
                        if(clave.equalsIgnoreCase(ArchivoYML.getInstance().getFileYML().getString("Cuenta.clave"))){
                            ControladorPrincipal.getInstance(new VistaPrincipal(), usuario).tipoAcceso('A');
                            this.lf.dispose();
                        }else{
                            Principal.getInstance().mensajeError("Error: Clave del administrador default no correcto.");
                        }
                    }else{
                        if(ArchivoYML.getInstance().getStatusYML()==true){
                            if(DAOCuentas.getInstance().obtenerLista().size()>0){
                                boolean accesoCuenta=false;
                                String auxClave=null;
                                String auxCargo=null;
                                for(Cuenta c:DAOCuentas.getInstance().obtenerLista()){
                                    if(c.getUsuario().equals(usuario)){
                                        accesoCuenta=true;
                                        auxClave=c.getClave();
                                        auxCargo=c.getCargo();
                                        break;
                                    }
                                }
                                if(accesoCuenta){
                                    if(auxClave.equals(clave)){
                                        if(auxCargo.equals("EMPLEADO")){
                                            ControladorPrincipal.getInstance(new VistaPrincipal(), usuario).tipoAcceso('E');
                                            this.lf.dispose();
                                        }else{
                                            Principal.getInstance().mensajeError("Error: Cargo del usuario no es empleado, verifique su base de datos.");
                                        }
                                    }else{
                                        Principal.getInstance().mensajeError("Error: Clave del usuario incorrecto.");
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: Usuario no encontrado en la base de datos.");
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: No hay ninguna cuenta registrada en la base de datos.");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Base de datos no registrado en el archivo YML");
                        }
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Contraseña no ingresada.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Usuario no ingresado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnMostrarContra(){
        if(lf.jbtMostrarContra.isSelected()){
            this.lf.jpassContra.setEchoChar((char)0);
        }else{
            this.lf.jpassContra.setEchoChar('*');
        }
    }
    
}

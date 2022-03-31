package mvc.controladores;

import dao.DAOCuentas;
import dao.DAOEmpleados;
import dao.DAOImplements;
import dao.DAOInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import mvc.modelos.Cuenta;
import mvc.modelos.Empleado;
import source.Principal;
import mvc.vistas.VistaDatosEmpleados;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaRegistrarEmpleados;
import org.joda.time.DateTime;
import source.ArchivoYML;

public class ControladorRegistrarEmpleados extends WindowAdapter implements ActionListener{
    
    private static ControladorRegistrarEmpleados instance;
    private VistaRegistrarEmpleados ref;
    private DAOInterface dao;
    private String usuario;
    private int id=0;
    
    public ControladorRegistrarEmpleados(VistaRegistrarEmpleados ref,String usuario){
        this.ref=ref;
        this.ref.setVisible(true);
        this.usuario=usuario;
        this.dao=new DAOImplements();
        this.registerEvents();
    }
    
    public static ControladorRegistrarEmpleados getInstance(VistaRegistrarEmpleados ref,String usuario){
        return instance=new ControladorRegistrarEmpleados(ref, usuario);
    }
    
    private void registerEvents(){
        this.ref.jbtNuevo.addActionListener(this);
        this.ref.jbtRegistrarEmpleado.addActionListener(this);
        this.ref.jbtMostrar.addActionListener(this);
        this.ref.jbtVerEmpleados.addActionListener(this);
        this.ref.jbtModificar.addActionListener(this);
        this.ref.jtxtNumTelCel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(Character.isLetter(e.getKeyChar())){
                    ref.getToolkit().beep();
                    e.consume();
                    Principal.getInstance().mensajeError("Error: No puede ingresar letras en este campo.");
                }
            }
        });
        this.ref.jtxtNumDNI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if(Character.isLetter(e.getKeyChar())){
                    ref.getToolkit().beep();
                    e.consume();
                    Principal.getInstance().mensajeError("Error: No puede ingresar letras en este campo.");
                }
            }
        });
        this.ref.addWindowListener(this);
    }
    
    public void setAction(int id){
        this.id=id;
        for(Cuenta c:DAOCuentas.getInstance().obtenerLista()){
            if(c.getId()==id){
                this.ref.jtxtUsuarioEmpleado.setText(c.getUsuario());
                this.ref.jpassClaveEmpleado.setText(c.getClave());
                break;
            }
        }
        for(Empleado e:DAOEmpleados.getInstance().obtenerLista()){
            if(e.getId()==id){
                this.ref.jtxtNumDNI.setText(e.getDni());
                this.ref.jtxtNumTelCel.setText(e.getTelcel());
                this.ref.jtxtNombresCompletos.setText(e.getNombresCompletos());
                this.ref.jtxtCorreo.setText(e.getCorreo());
                int año=Integer.parseInt(e.getFechaNacimiento().substring(6,10));
                int mes=Integer.parseInt(e.getFechaNacimiento().substring(3,5));
                int dia=Integer.parseInt(e.getFechaNacimiento().substring(0,2));
                this.ref.jccFN.setDate(new DateTime(año,mes,dia,0,0).toDate());
                this.ref.jcbGenero.setSelectedItem(e.getGenero());
                this.ref.jbtRegistrarEmpleado.setEnabled(false);
                this.ref.jbtModificar.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ref.jbtNuevo==e.getSource()){
            this.limpiar();
        }else if(ref.jbtModificar==e.getSource()){
            this.btnModificar();
        }else if(ref.jbtVerEmpleados==e.getSource()){
           this.btnVerEmpleados();
        }else if(ref.jbtRegistrarEmpleado==e.getSource()){
            this.btnRegistrarEmpleado();
        }else if(ref.jbtMostrar==e.getSource()){
            this.btnMostrar();
        }
    }
    
    private void btnMostrar(){
        if(ref.jbtMostrar.isSelected()){
            this.ref.jpassClaveEmpleado.setEchoChar((char)0);
        }else{
            this.ref.jpassClaveEmpleado.setEchoChar('*');
        }
    }
    
    private void btnRegistrarEmpleado(){
        if(!ref.jtxtNumDNI.getText().equalsIgnoreCase("")){
            if(!ref.jtxtNombresCompletos.getText().equalsIgnoreCase("")){
                if(!ref.jtxtNumTelCel.getText().equalsIgnoreCase("")){
                    if(!ref.jtxtCorreo.getText().equalsIgnoreCase("")){
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
                        int añoActual=Integer.parseInt(sdf.format(Calendar.getInstance().getTime()));
                        int añoPuesto=Integer.parseInt(sdf.format(ref.jccFN.getDate()));
                        if(añoPuesto<añoActual && añoPuesto<=(añoActual-18)){
                            if(ref.jcbGenero.getSelectedIndex()!=0){
                                if(!ref.jtxtUsuarioEmpleado.getText().equalsIgnoreCase("")){
                                    if(!ref.jpassClaveEmpleado.getText().equalsIgnoreCase("")){
                                        String dni=ref.jtxtNumDNI.getText();
                                        String nombresCompletos=ref.jtxtNombresCompletos.getText();
                                        String numTelcel=ref.jtxtNumTelCel.getText();
                                        String correo=ref.jtxtCorreo.getText();
                                        String genero=ref.jcbGenero.getSelectedItem().toString();
                                        String cuenta=ref.jtxtUsuarioEmpleado.getText();
                                        String clave=ref.jpassClaveEmpleado.getText();
                                        SimpleDateFormat sdfF=new SimpleDateFormat("dd/MM/yyyy");
                                        boolean cuentaEncontrada=false;
                                        for(Cuenta c:DAOCuentas.getInstance().obtenerLista()){
                                            if(c.getDni().equals(dni)){
                                                for(Empleado e:DAOEmpleados.getInstance().obtenerLista()){
                                                    if(e.getDni().equals(dni)){
                                                        cuentaEncontrada=true;
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        if(!cuentaEncontrada){
                                            if(DAOCuentas.getInstance().insertar(new Cuenta(0, cuenta, clave, dni, "EMPLEADO"))){
                                                if(DAOEmpleados.getInstance().insertar(new Empleado(0, dni, numTelcel, nombresCompletos, correo, sdfF.format(ref.jccFN.getDate()), genero, Principal.getInstance().getFechaHora()))){
                                                    this.ref.jbtNuevo.doClick();
                                                    Principal.getInstance().mensajeExito("Empleado registrado con éxito.");
                                                }else{
                                                    Principal.getInstance().mensajeError("Error: No se pudo registrar al empleado, verifique los datos o su base de datos.");
                                                }
                                            }else{
                                                Principal.getInstance().mensajeError("Error: No se pudo registrar la cuenta del empleado, verifique los datos o su base de datos.");
                                            }
                                        }else{
                                            Principal.getInstance().mensajeError("Error: Empleado ya está registrado en el sistema, vuelva a intentarlo.");
                                        }
                                    }else{
                                        Principal.getInstance().mensajeError("Error: Clave del empleado no ingresado.");
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: Usuario del empleado no ingresado.");
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: Género del empleado no seleccionado.");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Edad del empleado tiene que ser mayor o igual a 18 años.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: Correo electrónico del empleado no ingresado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Número de teléfono/celular del empleado no ingresado.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Nombres completos del empleado no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: Número de dni del empleado no ingresado.");
        }
    }
    
    private void btnVerEmpleados(){
        try {
            ControladorDatosEmpleados.getInstance(new VistaDatosEmpleados(), usuario);
            this.ref.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void btnModificar(){
        if(!ref.jtxtNumDNI.getText().equalsIgnoreCase("")){
            if(!ref.jtxtNombresCompletos.getText().equalsIgnoreCase("")){
                if(!ref.jtxtNumTelCel.getText().equalsIgnoreCase("")){
                    if(!ref.jtxtCorreo.getText().equalsIgnoreCase("")){
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
                        int añoActual=Integer.parseInt(sdf.format(Calendar.getInstance().getTime()));
                        int añoPuesto=Integer.parseInt(sdf.format(ref.jccFN.getDate()));
                        if(añoPuesto<añoActual && añoPuesto<=(añoActual-18)){
                            if(ref.jcbGenero.getSelectedIndex()!=0){
                                if(!ref.jtxtUsuarioEmpleado.getText().equalsIgnoreCase("")){
                                    if(!ref.jpassClaveEmpleado.getText().equalsIgnoreCase("")){
                                        String dni=ref.jtxtNumDNI.getText();
                                        String nombresCompletos=ref.jtxtNombresCompletos.getText();
                                        String numTelcel=ref.jtxtNumTelCel.getText();
                                        String correo=ref.jtxtCorreo.getText();
                                        String genero=ref.jcbGenero.getSelectedItem().toString();
                                        String cuenta=ref.jtxtUsuarioEmpleado.getText();
                                        String clave=ref.jpassClaveEmpleado.getText();
                                        SimpleDateFormat sdfF=new SimpleDateFormat("dd/MM/yyyy");
                                        for(Cuenta c:DAOCuentas.getInstance().obtenerLista()){
                                            if(c.getId()==id){
                                                c.setDni(dni);
                                                c.setUsuario(cuenta);
                                                c.setClave(clave);
                                                if(DAOCuentas.getInstance().actualizar(c)){
                                                    for(Empleado e:DAOEmpleados.getInstance().obtenerLista()){
                                                        if(e.getId()==id){
                                                            e.setDni(dni);
                                                            e.setCorreo(correo);
                                                            e.setFechaNacimiento(sdfF.format(ref.jccFN.getDate()));
                                                            e.setFechaRegistro(Principal.getInstance().getFechaHora());
                                                            e.setGenero(genero);
                                                            e.setNombresCompletos(nombresCompletos);
                                                            e.setTelcel(numTelcel);
                                                            if(DAOEmpleados.getInstance().actualizar(e)){
                                                                this.ref.jbtNuevo.doClick();
                                                                Principal.getInstance().mensajeExito("Datos del empleado actualizada con éxito");
                                                                break;
                                                            }else{
                                                                Principal.getInstance().mensajeError("Error: Datos del empleado no actualizada, verifique los datos o su base de datos");
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }else{
                                                    Principal.getInstance().mensajeError("Error: Datos de la cuenta del empleado no actualizada, verifique los datos o su base de datos");
                                                    break;
                                                }
                                            }
                                        }
                                    }else{
                                        Principal.getInstance().mensajeError("Error: Clave del empleado no ingresado.");
                                    }
                                }else{
                                    Principal.getInstance().mensajeError("Error: Usuario del empleado no ingresado.");
                                }
                            }else{
                                Principal.getInstance().mensajeError("Error: Género del empleado no seleccionado.");
                            }
                        }else{
                            Principal.getInstance().mensajeError("Error: Edad del empleado tiene que ser mayor o igual a 18 años.");
                        }
                    }else{
                        Principal.getInstance().mensajeError("Error: Correo electrónico del empleado no ingresado.");
                    }
                }else{
                    Principal.getInstance().mensajeError("Error: Número de teléfono/celular del empleado no ingresado.");
                }
            }else{
                Principal.getInstance().mensajeError("Error: Nombres completos del empleado no ingresado.");
            }
        }else{
            Principal.getInstance().mensajeError("Error: Número de dni del empleado no ingresado.");
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
        this.id=0;
        this.ref.jtxtNumDNI.setText(null);
        this.ref.jtxtNombresCompletos.setText(null);
        this.ref.jtxtNumTelCel.setText(null);
        this.ref.jtxtCorreo.setText(null);
        this.ref.jccFN.setDate(Calendar.getInstance().getTime());
        this.ref.jcbGenero.setSelectedIndex(0);
        this.ref.jtxtUsuarioEmpleado.setText(null);
        this.ref.jpassClaveEmpleado.setText(null);
        this.ref.jtxtNumDNI.setEnabled(true);
        this.ref.jbtModificar.setEnabled(false);
        this.ref.jbtRegistrarEmpleado.setEnabled(true);
        this.ref.jtxtNumDNI.requestFocus();
    }
}

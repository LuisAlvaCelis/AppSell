package source;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mvc.controladores.ControladorLogin;
import mvc.vistas.VistaLogin;

public class Principal {
    
    private static Principal instance;
    private SimpleDateFormat fechahora;
    private SimpleDateFormat hora;
    private SecureRandom secureRandom;
    
    public Principal(){
        this.fechahora=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
        this.hora=new SimpleDateFormat("hh:mm:ss aa");
        this.secureRandom=new SecureRandom();
    }
    
    public static Principal getInstance(){
        if(instance==null){
            instance=new Principal();
        }
        return instance;
    }
    
    public String getPalabraRandom(){
        return new BigInteger(50,secureRandom).toString(32);
    }
    
    public String getFechaHora(){
        return fechahora.format(Calendar.getInstance().getTime());
    }
    
    public String getHora(){
        return hora.format(Calendar.getInstance().getTime());
    }
    
    public void mensajeError(String msg){
        JOptionPane.showMessageDialog(null, msg, "Error", 0, new ImageIcon(getClass().getResource("/imagenes/error32x32.png")));
    }
    
    public void mensajeExito(String msg){
        JOptionPane.showMessageDialog(null, msg, "Éxito", 0, new ImageIcon(getClass().getResource("/imagenes/exito32x32.png")));
    }
    
    public void mensajeArchivo(String msg,String titulo){
        JOptionPane.showMessageDialog(null, msg, titulo, 0, new ImageIcon(getClass().getResource("/imagenes/archivos32x32.png")));
    }
    
    public static void main(String[] args) throws Exception{
        if(ArchivoYML.getInstance().crearYML()){
            ControladorLogin.getInstance(new VistaLogin());
        }
    }
    
}

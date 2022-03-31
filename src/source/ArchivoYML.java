
package source;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class ArchivoYML {
    
    private static ArchivoYML instance;
    private File directorio;
    private File archivo;
    private YamlConfiguration fileYML;
    
    public ArchivoYML(){
        this.directorio=new File("carpeta configuraciones");
        this.archivo=new File(directorio, "configuraciones.yml");
        this.fileYML=YamlConfiguration.loadConfiguration(archivo);
    }
    
    public static ArchivoYML getInstance(){
        if(instance==null){
            instance=new ArchivoYML();
        }
        return instance;
    }
    
    public boolean crearYML(){
        boolean status=false;
        try {
            if(!archivo.exists()){
                this.directorio.mkdir();
                this.archivo.createNewFile();
                this.fileYML.set("Cuenta.usuario", "admin");
                this.fileYML.set("Cuenta.clave", "ucv2019");
                this.fileYML.set("MySQL.status", false);
                this.fileYML.set("MySQL.ip", "");
                this.fileYML.set("MySQL.port", "");
                this.fileYML.set("MySQL.database", "");
                this.fileYML.set("MySQL.username", "");
                this.fileYML.set("MySQL.password", "");
                this.fileYML.save(archivo);
            }
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public YamlConfiguration getFileYML() {
        return fileYML;
    }
    
    public boolean reloadFileYML(boolean status,String ip,String port,String database,String username,String password){
        boolean verify=false;
        try {
            this.fileYML.set("MySQL.status", status);
            this.fileYML.set("MySQL.ip", ip);
            this.fileYML.set("MySQL.port", port);
            this.fileYML.set("MySQL.database", database);
            this.fileYML.set("MySQL.username", username);
            this.fileYML.set("MySQL.password", password);
            this.fileYML.save(archivo);
            verify=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verify;
    }
    
    public boolean getStatusYML(){
        return this.fileYML.getBoolean("MySQL.status");
    }
}

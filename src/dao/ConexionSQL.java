package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import source.ArchivoYML;

public class ConexionSQL {
    
    private Connection connection;
    
    public ConexionSQL(){}
    
    public Connection conectar(){
        try {
            if(ArchivoYML.getInstance().getFileYML().getBoolean("MySQL.status")==true){
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://"+ArchivoYML.getInstance().getFileYML().getString("MySQL.ip")+":"+ArchivoYML.getInstance().getFileYML().getString("MySQL.port")+"/"+ArchivoYML.getInstance().getFileYML().getString("MySQL.database")+"?allowPublicKeyRetrieval=true&useSSL=false";
                this.connection=DriverManager.getConnection(url,ArchivoYML.getInstance().getFileYML().getString("MySQL.username"),ArchivoYML.getInstance().getFileYML().getString("MySQL.password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }
    
    public void desconectar(){
        try {
            if(connection!=null){
                if(!connection.isClosed()){
                    this.connection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

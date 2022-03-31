package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.modelos.Cuenta;

public class DAOCuentas extends ConexionSQL{
    
    private static DAOCuentas instance;
    
    public DAOCuentas(){
        super();
    }
    
    public static DAOCuentas getInstance(){
        if(instance==null){
            instance=new DAOCuentas();
        }
        return instance;
    }
    
    public Cuenta buscar(String search){
        Cuenta cuenta=null;
        try {
            for(Cuenta aux:obtenerLista()){
                if(aux.getDni().equalsIgnoreCase(search)){
                    cuenta=new Cuenta(aux.getId(), aux.getUsuario(), aux.getClave(), aux.getDni(), aux.getCargo());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuenta;
    }
    
    public ArrayList<Cuenta> obtenerLista(){
        ArrayList<Cuenta> list=new ArrayList<>();
        try {
            String url="SELECT * FROM cuentas";
            Statement statement=conectar().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new Cuenta(rs.getInt("idCuenta"), rs.getString("Usuario"), rs.getString("Clave"), rs.getString("DNI"), rs.getString("Cargo")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return list;
    }
    
    public boolean insertar(Cuenta ce){
        boolean status=false;
        try {
            String url="INSERT INTO cuentas (DNI,Usuario,Clave,Cargo) VALUES (?,?,?,?)";
            PreparedStatement preparedstatement=conectar().prepareStatement(url);
            preparedstatement.setString(1, ce.getDni());
            preparedstatement.setString(2, ce.getUsuario());
            preparedstatement.setString(3, ce.getClave());
            preparedstatement.setString(4, ce.getCargo());
            int result=preparedstatement.executeUpdate();
            if(result>0){
                status=true;
            }
            preparedstatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    public boolean actualizar(Cuenta ce){
        boolean status=false;
        try {
            String url="UPDATE cuentas SET Cargo='"+ce.getCargo()+"', DNI='"+ce.getDni()+"', Usuario='"+ce.getUsuario()+"', Clave='"+ce.getClave()+"' WHERE idCuenta="+ce.getId()+"";
            PreparedStatement ps=conectar().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    
    public boolean eliminar(Cuenta ce){
        boolean status=false;
        try {
            String url="DELETE FROM cuentas WHERE idCuenta = "+ce.getId()+";";
            PreparedStatement ps=conectar().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
}


package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.modelos.Cliente;

public class DAOClientes extends ConexionSQL{
    
    private static DAOClientes instance;
    
    public DAOClientes(){
        super();
    }
    
    public static DAOClientes getInstance(){
        if(instance==null){
            instance=new DAOClientes();
        }
        return instance;
    }
    
    public Cliente buscar(String search){
        Cliente cliente=null;
        try {
            for(Cliente aux:obtenerLista()){
                if(aux.getCodeRandom().equalsIgnoreCase(search) || aux.getDni().equalsIgnoreCase(search)){
                    cliente=new Cliente(aux.getCodeRandom(), aux.getDni(), aux.getNombresCompletos(), aux.getDireccion(), aux.getGenero());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public ArrayList<Cliente> obtenerLista(){
        ArrayList<Cliente> list=new ArrayList<>();
        try {
             String url="SELECT * FROM clientes";
             Statement statement=conectar().createStatement();
             ResultSet rs=statement.executeQuery(url);
             while(rs.next()){
                 list.add(new Cliente(rs.getString("CodigoCliente"), rs.getString("DNI"), rs.getString("NombresCompletos"), rs.getString("Direccion"), rs.getString("Genero")));
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
    
    public boolean insertar(Cliente c){
        boolean status=false;
        try {
            String url="INSERT INTO clientes (CodigoCliente,DNI,NombresCompletos,Direccion,Genero) VALUES (?,?,?,?,?)";
            PreparedStatement preparedstatement=conectar().prepareStatement(url);
            preparedstatement.setString(1, c.getCodeRandom());
            preparedstatement.setString(2, c.getDni());
            preparedstatement.setString(3, c.getNombresCompletos());
            preparedstatement.setString(4, c.getDireccion());
            preparedstatement.setString(5, c.getGenero());
            int result=preparedstatement.executeUpdate();
            if(result>0){
                status=true;
            }
            preparedstatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    
    public boolean actualizar(Cliente c){
        boolean status=false;
        try {
            String url="UPDATE clientes SET NombresCompletos='"+c.getNombresCompletos()+"', Direccion='"+c.getDireccion()+"', Genero='"+c.getGenero()+"' WHERE DNI='"+c.getDni()+"'";
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
    
    public boolean eliminar(Cliente c){
        boolean status=false;
        try {
            String url="DELETE FROM clientes WHERE DNI = '"+c.getDni()+"';";
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
}
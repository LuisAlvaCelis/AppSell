package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.modelos.Producto;

public class DAOProductos extends ConexionSQL{
    
    private static DAOProductos instance;
    
    public DAOProductos(){
        super();
    }
    
    public static DAOProductos getInstance(){
        if(instance==null){
            instance=new DAOProductos();
        }
        return instance;
    }
    
    public Producto buscar(String codigo){
        Producto producto=null;
        try {
            for(Producto aux:obtenerLista()){
                if(aux.getCodeProducto().equalsIgnoreCase(codigo)){
                    producto=new Producto(aux.getId(), aux.getCodeProducto(), aux.getTipProducto(), aux.getNomProducto(), aux.getCantProducto(), aux.getPrecioProducto(), aux.getFechaRegistro());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }
    
    public ArrayList<Producto> obtenerLista(){
        ArrayList<Producto> list=new ArrayList<>();
        try {
            String url="SELECT * FROM productos";
            Statement statement=conectar().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new Producto(rs.getInt("idProducto"),rs.getString("CodigoProducto"), rs.getString("TipoProducto"), rs.getString("NombreProducto"), rs.getInt("CantidadProducto"), rs.getDouble("PrecioProducto"), rs.getString("FechaRegistro")));
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
    
    public boolean insertar(Producto p){
        boolean status=false;
        try {
            String url="INSERT INTO productos (CodigoProducto,TipoProducto,NombreProducto,CantidadProducto,PrecioProducto,FechaRegistro) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedstatement=conectar().prepareStatement(url);
            preparedstatement.setString(1, p.getCodeProducto());
            preparedstatement.setString(2, p.getTipProducto());
            preparedstatement.setString(3, p.getNomProducto());
            preparedstatement.setInt(4, p.getCantProducto());
            preparedstatement.setDouble(5, p.getPrecioProducto());
            preparedstatement.setString(6, p.getFechaRegistro());
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
    
    public boolean actualizar(Producto p){
        boolean status=false;
        try {
            String url="UPDATE productos SET CodigoProducto='"+p.getCodeProducto()+"', TipoProducto='"+p.getTipProducto()+"', NombreProducto='"+p.getNomProducto()+"',CantidadProducto="+p.getCantProducto()+",PrecioProducto="+p.getPrecioProducto()+" WHERE idProducto="+p.getId()+"";
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
    
    public boolean eliminar(Producto p){
        boolean status=false;
        try {
            String url="DELETE FROM productos WHERE idProducto = "+p.getId()+";";
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

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.modelos.Ventas;

public class DAOVentas extends ConexionSQL{
    
    private static DAOVentas instance;
    
    public DAOVentas(){
        super();
    }
    
    public static DAOVentas getInstance(){
        if(instance==null){
            instance=new DAOVentas();
        }
        return instance;
    }
    
    public Ventas buscar(String codigo){
        Ventas ventas=null;
        try {
            for(Ventas aux:obtenerLista()){
                if(aux.getCodigoVenta().equalsIgnoreCase(codigo) || aux.getCodigoCliente().equalsIgnoreCase(codigo)){
                    ventas=new Ventas(aux.getId(),aux.getCodigoVenta(), aux.getCodigoCliente(), aux.getNombreProducto(), aux.getFechaCompra(), aux.getAtendidoPor(),aux.getCantidadProducto(),aux.getImporteTotal());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ventas;
    }
    
    public ArrayList<Ventas> obtenerLista(){
        ArrayList<Ventas> list=new ArrayList<>();
        try {
            String url="SELECT * FROM ventas";
            Statement statement=conectar().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new Ventas(rs.getInt("idVenta"),rs.getString("CodigoVenta"), rs.getString("CodigoCliente"), rs.getString("NombreProducto"), rs.getString("FechaCompra"), rs.getString("AtendidoPor"), rs.getInt("Cantidad"), rs.getDouble("Total")));
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
    
    public boolean insertar(Ventas v){
        boolean status=false;
        try {
            String url="INSERT INTO ventas (CodigoVenta,CodigoCliente,NombreProducto,Cantidad,Total,FechaCompra,AtendidoPor) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedstatement=conectar().prepareStatement(url);
            preparedstatement.setString(1, v.getCodigoVenta());
            preparedstatement.setString(2, v.getCodigoCliente());
            preparedstatement.setString(3, v.getNombreProducto());
            preparedstatement.setInt(4, v.getCantidadProducto());
            preparedstatement.setDouble(5, v.getImporteTotal());
            preparedstatement.setString(6, v.getFechaCompra());
            preparedstatement.setString(7, v.getAtendidoPor());
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
    
    public boolean actualizar(Ventas v){
        boolean status=false;
        try {
            String url="UPDATE ventas SET CodigoCliente='"+v.getCodigoCliente()+"',NombreProducto='"+v.getNombreProducto()+"',Cantidad="+v.getCantidadProducto()+",Total="+v.getImporteTotal()+", FechaCompra='"+v.getFechaCompra()+"', AtendidoPor='"+v.getAtendidoPor()+"'  WHERE CodigoVenta='"+v.getCodigoVenta()+"'";
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
    
    public boolean eliminar(Ventas v,int opcion){
        boolean status=false;
        String url="";
        if(opcion==1){
            url="DELETE FROM ventas WHERE idVenta = "+v.getId()+";";
        }else if(opcion==2){
            url="DELETE FROM ventas WHERE CodigoVenta = '"+v.getCodigoVenta()+"';";
        }
        try {
            PreparedStatement ps=conectar().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
}

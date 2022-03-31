package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.modelos.Empleado;
import source.Principal;

public class DAOEmpleados extends ConexionSQL{
    
    private static DAOEmpleados instance;
    
    public DAOEmpleados(){
        super();
    }
    
    public static DAOEmpleados getInstance(){
        if(instance==null){
            instance=new DAOEmpleados();
        }
        return instance;
    }
    
    public Empleado buscar(String search){
        Empleado empleado=null;
        try {
            for(Empleado aux:obtenerLista()){
                if(aux.getDni().equalsIgnoreCase(search)){
                    empleado=new Empleado(aux.getId(), aux.getDni(), aux.getTelcel(), aux.getNombresCompletos(), aux.getCorreo(), aux.getFechaNacimiento(), aux.getGenero(), aux.getFechaRegistro());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }
    
    public ArrayList<Empleado> obtenerLista(){
        ArrayList<Empleado> list=new ArrayList<>();
        try {
            String url="SELECT * FROM empleados";
            Statement statement=conectar().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new Empleado(rs.getInt("idEmpleado"), rs.getString("DNI"), rs.getString("Telefono_Celular"), rs.getString("NombresCompletos"), rs.getString("Correo"), rs.getString("FechaNacimiento"), rs.getString("Genero"),rs.getString("FechaRegistro")));
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
    
    public boolean insertar(Empleado e){
        boolean status=false;
        try {
            String url="INSERT INTO empleados (DNI,Telefono_Celular,NombresCompletos,Correo,FechaNacimiento,Genero,FechaRegistro) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedstatement=conectar().prepareStatement(url);
            preparedstatement.setString(1, e.getDni());
            preparedstatement.setString(2, e.getTelcel());
            preparedstatement.setString(3, e.getNombresCompletos());
            preparedstatement.setString(4, e.getCorreo());
            preparedstatement.setString(5, e.getFechaNacimiento());
            preparedstatement.setString(6, e.getGenero());
            preparedstatement.setString(7, Principal.getInstance().getFechaHora());
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
    
    public boolean actualizar(Empleado e){
        boolean status=false;
        try {
            String url="UPDATE empleados SET DNI='"+e.getDni()+"', Telefono_Celular='"+e.getTelcel()+"', "
                    + "NombresCompletos='"+e.getNombresCompletos()+"', Correo='"+e.getCorreo()+"', "
                    + "FechaNacimiento='"+e.getFechaNacimiento()+"', Genero='"+e.getGenero()+"' "
                    + "WHERE idEmpleado="+e.getId()+";";
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
    
    public boolean eliminar(Empleado e){
        boolean status=false;
        try{
            String url="DELETE FROM empleados WHERE idEmpleado = "+e.getId()+";";
            PreparedStatement ps=conectar().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
}

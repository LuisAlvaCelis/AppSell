package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mvc.modelos.Cuenta;
import source.ArchivoYML;

public class DAOImplements extends ConexionSQL implements DAOInterface{
    
    public DAOImplements(){
        super();
    }
    
    @Override
    public boolean crearBD(){
        boolean status=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://"+
			ArchivoYML.getInstance().getFileYML().getString("MySQL.ip")+":"+ArchivoYML.getInstance().getFileYML().getString("MySQL.port")+"/?useSSL=false",ArchivoYML.getInstance().getFileYML().getString("MySQL.username"),ArchivoYML.getInstance().getFileYML().getString("MySQL.password"));
            Statement statement=connection.createStatement();
            int result=statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+ArchivoYML.getInstance().getFileYML().getString("MySQL.database"));
            if(result>0){
                status=true;
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean crearTablaCuentas(){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS `cuentas` ("
                    + "`idCuenta` INT PRIMARY KEY AUTO_INCREMENT,"
                    + "`DNI` VARCHAR(12), "
                    + "`Usuario` VARCHAR(100), "
                    + "`Clave` VARCHAR(100), "
                    + "`Cargo` VARCHAR(100))";
            Statement statement=conectar().createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }

    @Override
    public boolean crearTablaEmpleados(){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS `empleados` ("
                    + "`idEmpleado` INT PRIMARY KEY AUTO_INCREMENT, "
                    + "`DNI` VARCHAR(12), "
                    + "`Telefono_Celular` VARCHAR(15), "
                    + "`NombresCompletos` VARCHAR(150), "
                    + "`Correo` VARCHAR(100), "
                    + "`FechaNacimiento` VARCHAR(100), "
                    + "`Genero` VARCHAR(100), "
                    + "`FechaRegistro` VARCHAR(100))";
            Statement statement=conectar().createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    
    @Override
    public boolean crearTablaProductos(){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS `productos` ("
                    + "`idProducto` INT PRIMARY KEY AUTO_INCREMENT, "
                    + "`CodigoProducto` VARCHAR(50), "
                    + "`TipoProducto` VARCHAR(100), "
                    + "`NombreProducto` VARCHAR(100), "
                    + "`CantidadProducto` INT(3), "
                    + "`PrecioProducto` DOUBLE, "
                    + "`FechaRegistro` VARCHAR(30))";
            Statement statement=conectar().createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    
    @Override
    public boolean crearTablaVentas(){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS `ventas` ("
                    + "`idVenta` INT PRIMARY KEY AUTO_INCREMENT, "
                    + "`CodigoVenta` VARCHAR(100), "
                    + "`CodigoCliente` VARCHAR(100), "
                    + "`NombreProducto` VARCHAR(100), "
                    + "`Cantidad` INT(4), "
                    + "`Total` DOUBLE, "
                    + "`FechaCompra` VARCHAR(100), "
                    + "`AtendidoPor` VARCHAR(100))";
            Statement statement=conectar().createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    
    @Override
    public boolean crearTablaClientes(){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS `clientes` ("
                    + "`CodigoCliente` VARCHAR(50) PRIMARY KEY, "
                    + "`DNI` VARCHAR(12), "
                    + "`NombresCompletos` VARCHAR(100), "
                    + "`Direccion` VARCHAR(100), "
                    + "`Genero` VARCHAR(100))";
            Statement statement=conectar().createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            this.desconectar();
        }
        return status;
    }
    
    @Override
    public void mostrarDatosJFrames(JTable tabla, int num, String search){
        try {
            String[] columnas=new String[tabla.getModel().getColumnCount()];
            Object[] filas=new Object[tabla.getModel().getColumnCount()];
            for(int i=0;i<columnas.length;i++){
                columnas[i]=tabla.getModel().getColumnName(i);
            }
            DefaultTableModel dtm=new DefaultTableModel(null,columnas){
                @Override
                public boolean isCellEditable(int filas,int columnas){
                    return false;
                }
            };
            JButton botonM=new JButton("Modificar");
            botonM.setName("modificar");
            JButton botonR=new JButton("Remover");
            botonR.setName("remover");
            JButton botonS=new JButton("Seleccionar");
            botonS.setName("seleccionar");
            if(num==1){
                String url="SELECT * FROM clientes WHERE CONCAT(CodigoCliente,'',DNI,'',NombresCompletos,'',Direccion,'',Genero) LIKE '%"+search+"%'";
                Statement st=conectar().createStatement();
                ResultSet rs=st.executeQuery(url);
                while(rs.next()){
                    filas[0]=rs.getString("CodigoCliente");
                    filas[1]=rs.getString("DNI");
                    filas[2]=rs.getString("NombresCompletos");
                    filas[3]=rs.getString("Direccion");
                    filas[4]=rs.getString("Genero");
                    filas[5]=botonM;
                    filas[6]=botonR;
                    dtm.addRow(filas);
                }
                rs.close();
            }else if(num==2){
                String url="SELECT * FROM empleados WHERE CONCAT(idEmpleado,'',DNI,'',NombresCompletos,'',Correo,'',Telefono_Celular) LIKE '%"+search+"%'";
                Statement st=conectar().createStatement();
                ResultSet rs=st.executeQuery(url);
                while(rs.next()){
                    filas[0]=rs.getInt("idEmpleado");
                    filas[1]=rs.getString("DNI");
                    filas[2]=rs.getString("Telefono_Celular");
                    filas[3]=rs.getString("NombresCompletos");
                    filas[4]=rs.getString("Correo");
                    filas[5]=rs.getString("FechaNacimiento");
                    filas[6]=rs.getString("Genero");
                    for(Cuenta c:DAOCuentas.getInstance().obtenerLista()){
                        if(c.getDni().equals(rs.getString("DNI"))){
                            filas[7]=c.getUsuario();
                            filas[8]=c.getClave();
                            break;
                        }
                    }
                    filas[9]=rs.getString("FechaRegistro");
                    filas[10]=botonM;
                    filas[11]=botonR;
                    dtm.addRow(filas);
                }
                rs.close();
            }else if(num==3){
                String url="SELECT * FROM productos WHERE CONCAT(idProducto,'',CodigoProducto,'',TipoProducto,'',NombreProducto) LIKE '%"+search+"%'";
                Statement st=conectar().createStatement();
                ResultSet rs=st.executeQuery(url);
                while(rs.next()){
                    filas[0]=rs.getInt("idProducto");
                    filas[1]=rs.getString("CodigoProducto");
                    filas[2]=rs.getString("TipoProducto");
                    filas[3]=rs.getString("NombreProducto");
                    filas[4]=rs.getInt("CantidadProducto");
                    filas[5]=rs.getDouble("PrecioProducto");
                    filas[6]=rs.getString("FechaRegistro");
                    filas[7]=botonM;
                    filas[8]=botonR;
                    dtm.addRow(filas);
                }
                rs.close();
            }else if(num==4){
                String url="SELECT * FROM clientes WHERE CONCAT(CodigoCliente,'',DNI,'',NombresCompletos) LIKE '%"+search+"%'";
                Statement st=conectar().createStatement();
                ResultSet rs=st.executeQuery(url);
                while(rs.next()){
                    filas[0]=rs.getString("CodigoCliente");
                    filas[1]=rs.getString("DNI");
                    filas[2]=rs.getString("NombresCompletos");
                    filas[3]=botonS;
                    dtm.addRow(filas);
                }
                rs.close();
            }else if(num==5){
                String url="SELECT * FROM productos WHERE CONCAT(CodigoProducto,'',TipoProducto,'',NombreProducto) LIKE '%"+search+"%'";
                Statement st=conectar().createStatement();
                ResultSet rs=st.executeQuery(url);
                while(rs.next()){
                    if(rs.getInt("CantidadProducto")>0){
                        filas[0]=rs.getString("CodigoProducto");
                        filas[1]=rs.getString("NombreProducto");
                        filas[2]=rs.getInt("CantidadProducto");
                        filas[3]=rs.getDouble("PrecioProducto");
                        filas[4]=botonS;
                        dtm.addRow(filas);
                    }
                }
                rs.close();
            }else if(num==6){
                String url="SELECT * FROM ventas WHERE CONCAT(idVenta,'',CodigoVenta,'',CodigoCliente,'',NombreProducto,'',FechaCompra) LIKE '%"+search+"%'";
                Statement st=conectar().createStatement();
                ResultSet rs=st.executeQuery(url);
                JButton botonRF=new JButton("Remover fila");
                botonRF.setName("removerF");
                JButton botonRG=new JButton("Remover grupo");
                botonRG.setName("removerG");
                while(rs.next()){
                    filas[0]=rs.getInt("idVenta");
                    filas[1]=rs.getString("CodigoVenta");
                    filas[2]=rs.getString("CodigoCliente");
                    filas[3]=rs.getString("NombreProducto");
                    filas[4]=rs.getInt("Cantidad");
                    filas[5]=rs.getDouble("Total");
                    filas[6]=rs.getString("FechaCompra");
                    filas[7]=botonRF;
                    filas[8]=botonRG;
                    dtm.addRow(filas);
                }
                rs.close();
            }
            tabla.setModel(dtm);
            this.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

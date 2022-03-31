package dao;

import javax.swing.JTable;

public interface DAOInterface {
    
    public abstract boolean crearBD();
    public abstract boolean crearTablaCuentas();
    public abstract boolean crearTablaEmpleados();
    public abstract boolean crearTablaClientes();
    public abstract boolean crearTablaProductos();
    public abstract boolean crearTablaVentas();
    
    public abstract void mostrarDatosJFrames(JTable tabla,int num,String search);
    
}

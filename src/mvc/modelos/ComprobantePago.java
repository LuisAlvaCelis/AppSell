package mvc.modelos;

public class ComprobantePago {
    
    private String producto;
    private int cantidad;
    private double costo;

    public ComprobantePago(String producto, int cantidad, double costo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}

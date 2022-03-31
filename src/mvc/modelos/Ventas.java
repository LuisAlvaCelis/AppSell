package mvc.modelos;

public class Ventas {
    
    private int id;
    private String codigoVenta;
    private String codigoCliente;
    private String nombreProducto;
    private String fechaCompra;
    private String atendidoPor;
    private int cantidadProducto;
    private double importeTotal;

    public Ventas(int id,String codigoVenta,String codigoCliente, String nombreProducto,String fechaCompra,String atendidoPor, int cantidadProducto, double importeTotal) {
        this.id=id;
        this.codigoVenta=codigoVenta;
        this.codigoCliente = codigoCliente;
        this.nombreProducto = nombreProducto;
        this.fechaCompra=fechaCompra;
        this.atendidoPor=atendidoPor;
        this.cantidadProducto = cantidadProducto;
        this.importeTotal = importeTotal;
    }
    
    public Ventas(){}
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
       this.id=id; 
    }
    
    public String getCodigoVenta(){
        return this.codigoVenta;
    }
    
    public void setCodigoVenta(String codigoVenta){
        this.codigoVenta=codigoVenta;
    }

    public String getAtendidoPor(){
        return atendidoPor;
    }
    
    public void setAtendidoPor(String atendidoPor){
        this.atendidoPor=atendidoPor;
    }
    
    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}

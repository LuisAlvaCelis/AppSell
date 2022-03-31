package mvc.modelos;

public class Producto {
    
    private int id;
    private String codeProducto;
    private String tipProducto;
    private String nomProducto;
    private int cantProducto;
    private double precioProducto;
    private String fechaRegistro;

    public Producto(int id,String codeProducto, String tipProducto, String nomProducto, int cantProducto, double precioProducto,String fechaRegistro) {
        this.id=id;
        this.codeProducto = codeProducto;
        this.tipProducto = tipProducto;
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.precioProducto = precioProducto;
        this.fechaRegistro=fechaRegistro;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public String getFechaRegistro(){
        return fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro){
        this.fechaRegistro=fechaRegistro;
    }
    
    public String getCodeProducto() {
        return codeProducto;
    }

    public void setCodeProducto(String codeProducto) {
        this.codeProducto = codeProducto;
    }

    public String getTipProducto() {
        return tipProducto;
    }

    public void setTipProducto(String tipProducto) {
        this.tipProducto = tipProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}

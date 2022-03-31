package mvc.modelos;

public class Cuenta {
    
    private int id;
    private String usuario;
    private String clave;
    private String dni;
    private String cargo;

    public Cuenta(int id,String usuario, String clave, String dni, String cargo) {
        this.id=id;
        this.usuario = usuario;
        this.clave = clave;
        this.dni = dni;
        this.cargo = cargo;
    }
    
    public Cuenta(int id){
        this.id=id;
    }
    
    public Cuenta(String dni){
        this.dni=dni;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

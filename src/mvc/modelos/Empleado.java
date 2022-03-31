package mvc.modelos;

public class Empleado {
    
    private int id;
    private String dni;
    private String telcel;
    private String nombresCompletos;
    private String correo;
    private String fechaNacimiento;
    private String genero;
    private String fechaRegistro;

    public Empleado(int id,String dni, String telcel, String nombresCompletos, String correo, String fechaNacimiento, String genero,String fechaRegistro) {
        this.id=id;
        this.dni = dni;
        this.telcel = telcel;
        this.nombresCompletos = nombresCompletos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.fechaRegistro=fechaRegistro;
    }
    
    public Empleado(int id){
        this.id=id;
    }
    
    public Empleado(String dni){        
        this.dni=dni;
    }
    
    public Empleado(){}
    
    public String getFechaRegistro(){
        return fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro){
        this.fechaRegistro=fechaRegistro;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelcel() {
        return telcel;
    }

    public void setTelcel(String telcel) {
        this.telcel = telcel;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}

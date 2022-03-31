package mvc.modelos;

public class Cliente {
    
    private String codeRandom;
    private String dni;
    private String nombresCompletos;
    private String direccion;
    private String genero;

    public Cliente(String codeRandom,String dni, String nombresCompletos, String direccion, String genero) {
        this.codeRandom=codeRandom;
        this.dni = dni;
        this.nombresCompletos = nombresCompletos;
        this.direccion = direccion;
        this.genero = genero;
    }
    
    public Cliente(){}

    public String getCodeRandom() {
        return codeRandom;
    }

    public void setCodeRandom(String codeRandom) {
        this.codeRandom = codeRandom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

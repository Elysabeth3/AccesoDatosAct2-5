import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String apellidos;
    private String correo;
    private String numTel;
    private String descripcion;

    public Contacto(String nombre, String apellidos, String correo, String numTel) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.numTel = numTel;
    }

    public Contacto(String nombre, String apellidos, String correo, String numTel, String descripcion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.numTel = numTel;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Contacto:" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", numTel='" + numTel + '\'' +
                ", descripcion='" + descripcion;
    }
}

package co.edu.uniquindio.proyectofinal;

public class Persona {
    protected String id;
    protected String nombre;
    protected String correo;
    protected String telefono;

    public Persona(String id, String correo, String nombre, String telefono) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
    }
public abstract void mostrarInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

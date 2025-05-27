
package Modelo;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String fechaNacimiento;
    protected String correo;
    protected String telefono;

    public Persona(String id, String telefono, String fechaNacimiento, String nombre, String correo) {
        this.id = id;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.correo = correo;
    }

    public abstract String mostrarInformacionBasica();

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}

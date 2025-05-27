package Modelo;

public class Administrador extends Persona implements IGestionCitas {
    public Administrador(String id, String correo, String nombre, String telefono) {
        super(id, correo, nombre, telefono);
    }

    @Override
    public void agendarCitas(Cita cita) {

    }

    @Override
    public void cancelarCita(Cita cita) {

    }

    @Override
    public void verCita(Cita cita) {

    }

    @Override
    public void mostrarInfo() {

    }
}


package co.edu.uniquindio.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona implements IGestionCitas{
    private List<String> historialMedico;
    private List<Cita> citas;
    private List<Notificacion> notificaciones;

    public Paciente(String id, String correo, String nombre, String telefono, List<Cita> citas) {
        super(id, correo, nombre, telefono);
        this.historialMedico = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public List<String> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(List<String> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
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

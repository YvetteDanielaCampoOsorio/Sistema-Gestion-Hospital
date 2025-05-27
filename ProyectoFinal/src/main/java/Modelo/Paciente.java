package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona {
    private final List<String> historialMedico;
    private final List<Cita> citas;
    private final List<Notificacion> notificaciones;

    public Paciente(String id, String telefono, String fechaNacimiento, String nombre, String correo) {
        super(id, telefono, fechaNacimiento, nombre, correo);
        this.historialMedico = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public void agregarRegistroMedico(String registro) {
        if (registro == null || registro.isBlank()) {
            throw new IllegalArgumentException("Registro médico no válido");
        }
        historialMedico.add(registro);
    }

    public List<String> obtenerHistorial() {
        return new ArrayList<>(historialMedico);
    }

    public void agregarCita(Cita cita) {
        if (cita == null) throw new IllegalArgumentException("Cita no válida");
        citas.add(cita);
    }

    public void cancelarCita(Cita cita) {
        if (!citas.remove(cita)) {
            throw new IllegalArgumentException("Cita no encontrada");
        }
    }

    public List<Cita> obtenerCitas() {
        return new ArrayList<>(citas);
    }

    public void recibirNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public List<Notificacion> obtenerNotificaciones() {
        return new ArrayList<>(notificaciones);
    }

    @Override
    public String mostrarInformacionBasica() {
        return String.format("Paciente: %s (ID: %s), Tel: %s", nombre, id, telefono);
    }
}
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medico extends Persona implements IGestionCitas {
    private EspecialidadMedica especialidad;
    private final List<Cita> citas;

    // Constructor principal
    public Medico(String id, String telefono, LocalDate fechaNacimiento, String nombre,
                  String correo, EspecialidadMedica especialidad) {
        super(id, telefono, fechaNacimiento.toString(), nombre, correo);
        this.especialidad = Objects.requireNonNull(especialidad, "La especialidad no puede ser nula");
        this.citas = new ArrayList<>();
    }

    // Constructor alternativo simplificado
    public Medico(String id, String nombre, EspecialidadMedica especialidad) {
        this(id, "", LocalDate.now(), nombre, "", especialidad);
    }

    // Métodos de gestión de citas
    @Override
    public void agendarCitas(Cita cita) {
        Objects.requireNonNull(cita, "La cita no puede ser nula");
        if (citas.contains(cita)) {
            throw new IllegalStateException("La cita ya está agendada para este médico");
        }
        citas.add(cita);
    }

    @Override
    public void cancelarCita(Cita cita) {
        Objects.requireNonNull(cita, "La cita no puede ser nula");
        if (!citas.remove(cita)) {
            throw new IllegalArgumentException("La cita no existe en el calendario del médico");
        }
    }

    @Override
    public void verCita(Cita cita) {
        Objects.requireNonNull(cita, "La cita no puede ser nula");
        if (!citas.contains(cita)) {
            throw new IllegalArgumentException("El médico no tiene esta cita agendada");
        }
        System.out.println("Cita: " + cita.getMotivo() + " - Estado: " + cita.getEstado());
    }

    // Métodos de acceso
    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadMedica especialidad) {
        this.especialidad = Objects.requireNonNull(especialidad, "La especialidad no puede ser nula");
    }

    public List<Cita> getCitas() {
        return new ArrayList<>(citas);
    }

    @Override
    public String mostrarInformacionBasica() {
        return String.format("Dr. %s - %s | Tel: %s",
                getNombre(), especialidad, getTelefono());
    }

    // Método adicional útil
    public int cantidadCitasProgramadas() {
        return (int) citas.stream()
                .filter(c -> c.getEstado() == EstadoCita.PROGRAMADA)
                .count();
    }
}
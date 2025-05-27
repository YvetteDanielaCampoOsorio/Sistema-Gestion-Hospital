package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Cita {
    private String id;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private EstadoCita estado;
    private Paciente paciente;
    private Medico medico;

    public Cita(String id, String motivo) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.fecha = Objects.requireNonNull(fecha, "La fecha no puede ser nula");
        this.hora = Objects.requireNonNull(hora, "La hora no puede ser nula");
        this.motivo = Objects.requireNonNull(motivo, "El motivo no puede ser nulo");
        this.paciente = Objects.requireNonNull(paciente, "El paciente no puede ser nulo");
        this.medico = Objects.requireNonNull(medico, "El médico no puede ser nulo");
        this.estado = EstadoCita.PROGRAMADA;
    }

    // Constructor simplificado para casos básicos
    public Cita(String motivo, Paciente paciente, Medico medico) {
        this(generarIdAutomatico(),
                motivo);
    }

    private static String generarIdAutomatico() {
        return "CITA-" + System.currentTimeMillis();
    }

    public void cambiarEstado(EstadoCita nuevoEstado) {
        this.estado = Objects.requireNonNull(nuevoEstado, "El estado no puede ser nulo");
    }

    public void reagendar(LocalDate nuevaFecha, LocalTime nuevaHora) {
        this.fecha = Objects.requireNonNull(nuevaFecha, "La nueva fecha no puede ser nula");
        this.hora = Objects.requireNonNull(nuevaHora, "La nueva hora no puede ser nula");
    }

    // Getters
    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getMotivo() { return motivo; }
    public EstadoCita getEstado() { return estado; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }

    @Override
    public String toString() {
        return String.format("Cita #%s - %s %s | %s | %s | %s",
                id, fecha, hora, motivo, estado, paciente.getNombre());
    }
}
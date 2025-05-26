package Modelo;

import java.time.LocalTime;

public class Cita {
    private LocalTime fechaHora;
    private Medico medico;
    private Paciente paciente;
    private String motivo;
    private EstadoCita estadoCita;

    public Cita(LocalTime fechaHora, String motivo, Paciente paciente, Medico medico,EstadoCita estadoCita) {
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.paciente = paciente;
        this.medico = medico;
        this.estadoCita = estadoCita;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public LocalTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}

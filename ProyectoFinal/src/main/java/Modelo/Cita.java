package Modelo;

import java.time.LocalTime;

public class Cita {
    private LocalTime hora;
    private String motivo;
    private EstadoCita estado;

    public Cita(String motivo) {
        this.motivo = motivo;
        this.estado = EstadoCita.PROGRAMADA;
        this.hora = LocalTime.now();
    }

    public void cambiarEstado(EstadoCita nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters
    public LocalTime getHora() { return hora; }
    public String getMotivo() { return motivo; }
    public EstadoCita getEstado() { return estado; }
}

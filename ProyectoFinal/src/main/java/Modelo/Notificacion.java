package Modelo;

import java.time.LocalTime;

public record Notificacion(String mensaje, LocalTime fechaHora) {
    @Override
    public String toString() {
        return "Su cita fue programada"+ fechaHora + " - " + mensaje;
    }
}

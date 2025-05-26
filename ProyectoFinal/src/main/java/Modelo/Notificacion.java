package Modelo;

import java.time.LocalTime;

public record Notificacion(String mensaje, LocalTime fechaEnvio) {
}

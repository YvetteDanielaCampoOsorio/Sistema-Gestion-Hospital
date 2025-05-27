package Modelo;

public record Notificacion(String mensaje, String fecha) {
    @Override
    public String toString() {
        return String.format("Notificación [%s]: %s", fecha, mensaje);
    }
}
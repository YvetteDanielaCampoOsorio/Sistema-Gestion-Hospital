package Modelo;

import Modelo.Notificacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificacionTest {
    @Test
    void testCreacionNotificacion() {
        Notificacion notif = new Notificacion("Recordatorio de cita", "20/09/2023");
        assertEquals("Recordatorio de cita", notif.mensaje());
        assertEquals("20/09/2023", notif.fecha());
    }

    @Test
    void testToString() {
        Notificacion notif = new Notificacion("Su cita fue programada", "25/09/2023");
        String resultado = notif.toString();
        assertTrue(resultado.contains("25/09/2023"));
        assertTrue(resultado.contains("Su cita fue programada"));
    }
}
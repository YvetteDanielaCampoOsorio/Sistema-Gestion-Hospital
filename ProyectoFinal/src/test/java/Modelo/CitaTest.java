package Modelo;

import Modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CitaTest {
    @Test
    void testCreacionCita() {
        Cita cita = new Cita("Consulta general");
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
        assertNotNull(cita.getHora());
    }

    @Test
    void testCambiarEstado() {
        Cita cita = new Cita("Control");
        cita.cambiarEstado(EstadoCita.CANCELADA);
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}
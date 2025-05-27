package Modelo;

import Modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {
    private Paciente paciente;
    private Cita cita;
    private Notificacion notificacion;

    @BeforeEach
    void setUp() {
        paciente = new Paciente("P001", "5551234", "01/01/1990", "Juan Pérez", "juan@test.com");
        cita = new Cita("Consulta general");
        notificacion = new Notificacion("Recordatorio de cita", "20/09/2023");
    }

    @Test
    void testAgregarRegistroMedico() {
        paciente.agregarRegistroMedico("Alergia a medicamentos");
        assertEquals(1, paciente.obtenerHistorial().size());
    }

    @Test
    void testAgregarCita() {
        paciente.agregarCita(cita);
        assertEquals(1, paciente.obtenerCitas().size());
    }

    @Test
    void testMostrarInformacionBasica() {
        String info = paciente.mostrarInformacionBasica();
        assertTrue(info.contains("Juan Pérez"));
        assertTrue(info.contains("P001"));
    }
}
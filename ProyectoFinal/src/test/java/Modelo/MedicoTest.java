package Modelo;

import Modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {
    private Medico medico;
    private Cita cita;

    @BeforeEach
    void setUp() {
        medico = new Medico("M001", "555-9876", LocalDate.of(1980, 5, 15),
                "Ana López", "ana@hospital.com",
                EspecialidadMedica.PEDIATRIA);
        cita = new Cita("Control pediátrico");
    }

    @Test
    void testCreacionMedico() {
        assertEquals("M001", medico.getId());
        assertEquals("Ana López", medico.getNombre());
        assertEquals(EspecialidadMedica.PEDIATRIA, medico.getEspecialidad());
        assertTrue(medico.getCitas().isEmpty());
    }

    @Test
    void testAgendarCita() {
        medico.agendarCitas(cita);
        assertEquals(1, medico.getCitas().size());
        assertTrue(medico.getCitas().contains(cita));
    }

    @Test
    void testAgendarCitaNula() {
        assertThrows(NullPointerException.class, () -> medico.agendarCitas(null));
    }

    @Test
    void testCancelarCita() {
        medico.agendarCitas(cita);
        medico.cancelarCita(cita);
        assertEquals(0, medico.getCitas().size());
    }

    @Test
    void testCancelarCitaNoExistente() {
        assertThrows(IllegalArgumentException.class, () -> medico.cancelarCita(cita));
    }

    @Test
    void testVerCita() {
        medico.agendarCitas(cita);
        assertDoesNotThrow(() -> medico.verCita(cita));
    }

    @Test
    void testMostrarInformacionBasica() {
        String info = medico.mostrarInformacionBasica();
        assertTrue(info.contains("Dr. Ana López"));
        assertTrue(info.contains("PEDIATRIA"));
        assertTrue(info.contains("555-9876"));
    }

    @Test
    void testCantidadCitasProgramadas() {
        Cita cita2 = new Cita("Segundo control");
        cita2.cambiarEstado(EstadoCita.COMPLETADA);

        medico.agendarCitas(cita);
        medico.agendarCitas(cita2);

        assertEquals(1, medico.cantidadCitasProgramadas());
    }
}
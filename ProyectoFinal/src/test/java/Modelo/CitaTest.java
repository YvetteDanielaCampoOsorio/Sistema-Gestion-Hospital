package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaTest {
    private Cita cita;
    private Paciente paciente;
    private Medico medico;

    @BeforeEach
    void setUp() {
        paciente = new Paciente("P001", "555-1001", "10/05/1990",
                "Juan Pérez", "juan@mail.com");
        medico = new Medico("M001", "555-2001", "20/07/1975",
                "Dr. Rodríguez", "rodriguez@hospital.com",
                EspecialidadMedica.CARDIOLOGIA);
        cita = new Cita("C001",
                "Consulta general"
        );
    }

    @Test
    void testCreacionCita() {
        assertNotNull(cita.getId());
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
        assertEquals(paciente, cita.getPaciente());
        assertEquals(medico, cita.getMedico());
    }

    @Test
    void testCambiarEstado() {
        cita.cambiarEstado(EstadoCita.CANCELADA);
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }

    @Test
    void testReagendar() {
        LocalDate nuevaFecha = LocalDate.now().plusDays(2);
        LocalTime nuevaHora = LocalTime.of(15, 0);
        cita.reagendar(nuevaFecha, nuevaHora);
        assertEquals(nuevaFecha, cita.getFecha());
        assertEquals(nuevaHora, cita.getHora());
    }

    @Test
    void testToString() {
        String str = cita.toString();
        assertTrue(str.contains("Cita #C001"));
        assertTrue(str.contains("Consulta general"));
        assertTrue(str.contains("Juan Pérez"));
    }
}
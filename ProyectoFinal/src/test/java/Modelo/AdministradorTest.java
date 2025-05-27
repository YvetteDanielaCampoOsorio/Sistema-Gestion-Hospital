package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {
    private Administrador admin;
    private Paciente paciente1, paciente2;
    private Medico medico1, medico2;

    @BeforeEach
    void setUp() {
        List<Paciente> pacientesIniciales = new ArrayList<>();
        List<Medico> medicosIniciales = new ArrayList<>();

        admin = new Administrador("ADM001", "555-0001", "01/01/1980",
                "Admin Principal", "admin@hospital.com",
                medicosIniciales, pacientesIniciales);

        paciente1 = new Paciente("P101", "555-1001", "10/05/1990",
                "Juan Pérez", "juan@mail.com");
        paciente2 = new Paciente("P102", "555-1002", "15/03/1985",
                "María García", "maria@mail.com");

        medico1 = new Medico("M201", "555-2001", "20/07/1975",
                "Dr. Rodríguez", "rodriguez@hospital.com",
                EspecialidadMedica.CARDIOLOGIA);
        medico2 = new Medico("M202", "555-2002", "20/03/26",
                "Dra. Martínez", "martinez@hospital.com",
                EspecialidadMedica.PEDIATRIA);
    }

    @Test
    void testRegistrarPaciente_Exitoso() {
        assertTrue(admin.registrarPaciente(paciente1));
        assertEquals(1, admin.getPacientes().size());
    }

    @Test
    void testRegistrarPaciente_Duplicado() {
        admin.registrarPaciente(paciente1);
        assertFalse(admin.registrarPaciente(paciente1));
        assertEquals(1, admin.getPacientes().size());
    }

    @Test
    void testModificarPaciente_Exitoso() {
        admin.registrarPaciente(paciente1);
        Paciente modificado = new Paciente("P101", "555-1111", "10/05/1990",
                "Juan Pérez Modificado", "juan.nuevo@mail.com");
        assertTrue(admin.modificarPaciente(modificado));
        assertEquals("Juan Pérez Modificado", admin.getPacientes().get(0).getNombre());
    }

    @Test
    void testEliminarPaciente_Exitoso() {
        admin.registrarPaciente(paciente2);
        assertTrue(admin.eliminarPaciente("P102"));
        assertTrue(admin.getPacientes().isEmpty());
    }

    @Test
    void testRegistrarMedico_Exitoso() {
        assertTrue(admin.registrarMedico(medico1));
        assertEquals(1, admin.getMedicos().size());
    }

    @Test
    void testBuscarMedicosPorEspecialidad() {
        admin.registrarMedico(medico1);
        admin.registrarMedico(medico2);

        List<Medico> cardiologos = admin.buscarMedicosPorEspecialidad(EspecialidadMedica.CARDIOLOGIA);
        assertEquals(1, cardiologos.size());
        assertEquals("Dr. Rodríguez", cardiologos.get(0).getNombre());
    }

    @Test
    void testConstructorConFechaString() {
        Administrador adminConFecha = new Administrador("ADM002", "555-0002", "15/08/1975",
                "Admin Secundario", "admin2@hospital.com",
                new ArrayList<>(), new ArrayList<>());
        assertEquals("15/08/1975", adminConFecha.getFechaNacimiento());
    }
}
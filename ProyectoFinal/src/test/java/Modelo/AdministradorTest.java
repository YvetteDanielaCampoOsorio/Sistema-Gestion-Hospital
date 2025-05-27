package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {
    private Administrador admin;
    private Paciente paciente;
    private Medico medico;

    @BeforeEach
    public void setup() {
        admin = new Administrador("1", "admin@hospital.com", "Admin", "3112345678");

        paciente = new Paciente("101", "juan@correo.com", "Juan", "3001112233", new ArrayList<>());

        medico = new Medico("201", "maria@correo.com", "Dra. María", "3119876543",
                EspecialidadMedica.PEDIATRIA, new ArrayList<>());
    }

    @Test
    public void testRegistrarPaciente() {
        assertTrue(admin.registrarPaciente(paciente));
        assertEquals(1, admin.getPacientes().size());
    }

    @Test
    public void testModificarPaciente() {
        admin.registrarPaciente(paciente);
        Paciente actualizado = new Paciente("101", "juanp@correo.com", "Juan Pérez", "3001112244", new ArrayList<>());
        assertTrue(admin.modificarPaciente(actualizado));
        assertEquals("Juan Pérez", admin.getPacientes().get(0).getNombre());
    }

    @Test
    public void testEliminarPaciente() {
        admin.registrarPaciente(paciente);
        assertTrue(admin.eliminarPaciente("101"));
        assertEquals(0, admin.getPacientes().size());
    }

    @Test
    public void testRegistrarMedico() {
        assertTrue(admin.registrarMedico(medico));
        assertEquals(1, admin.getMedicos().size());
    }

    @Test
    public void testModificarMedico() {
        admin.registrarMedico(medico);
        Medico actualizado = new Medico("201", "mariag@correo.com", "Dra. María Gómez", "3119998877",
                EspecialidadMedica.PEDIATRIA, new ArrayList<>());
        assertTrue(admin.modificarMedico(actualizado));
        assertEquals("Dra. María Gómez", admin.getMedicos().get(0).getNombre());
    }

    @Test
    public void testEliminarMedico() {
        admin.registrarMedico(medico);
        assertTrue(admin.eliminarMedico("201"));
        assertEquals(0, admin.getMedicos().size());
    }
}
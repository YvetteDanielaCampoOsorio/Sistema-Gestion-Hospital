package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {
    private Administrador admin;
    private Paciente paciente1, paciente2;
    private Medico medico1, medico2;

    @BeforeEach
    public void setup() {
        admin = new Administrador("1", "admin@hospital.com", "Admin", "3112345678");

        paciente1 = new Paciente("101", "juan@correo.com", "Juan", "3001112233", new ArrayList<>());
        paciente2 = new Paciente("102", "julia@correo.com", "julia", "3254785748", new ArrayList<>());

        medico1 = new Medico("101", "maria@correo.com", "Dra. María", "3119876543",
                EspecialidadMedica.PEDIATRIA, new ArrayList<>());
        medico2 = new Medico("102", "grey@correo.com", "Dra. Grey", "3258745548",
                EspecialidadMedica.PEDIATRIA, new ArrayList<>());
    }

    @Test
    public void testRegistrarPaciente_Exitoso() {
        assertTrue(admin.registrarPaciente(paciente1));
    }

    @Test
    public void testRegistrarPaciente_Duplicado() {
        admin.registrarPaciente(paciente1);
        assertFalse(admin.registrarPaciente(paciente1));
    }

    @Test
    public void testModificarPaciente_Exitoso() {
        admin.registrarPaciente(paciente1);
        Paciente modificado = new Paciente("001", "nuevo@mail.com", "Ana María","3115485878", new ArrayList<>());
        assertTrue(admin.modificarPaciente(modificado));
    }

    @Test
    public void testModificarPaciente_NoExiste() {
        assertFalse(admin.modificarPaciente(paciente1));
    }

    @Test
    public void testEliminarPaciente_Exitoso() {
        admin.registrarPaciente(paciente2);
        assertTrue(admin.eliminarPaciente("002"));
    }

    @Test
    public void testEliminarPaciente_NoExiste() {
        assertFalse(admin.eliminarPaciente("999"));
    }

    @Test
    public void testRegistrarMedico_Exitoso() {
        assertTrue(admin.registrarMedico(medico1));
    }

    @Test
    public void testRegistrarMedico_Duplicado() {
        admin.registrarMedico(medico1);
        assertFalse(admin.registrarMedico(medico1));
    }

    @Test
    public void testModificarMedico_Exitoso() {
        admin.registrarMedico(medico2);
        Medico modificado = new Medico("102", "nuevo@mail.com", "Dra. Grey Modificada", "3119876543",
                EspecialidadMedica.PEDIATRIA, new ArrayList<>());
        assertTrue(admin.modificarMedico(modificado));
    }

    @Test
    public void testModificarMedico_NoExiste() {
        assertFalse(admin.modificarMedico(medico2));
    }

    @Test
    public void testEliminarMedico_Exitoso() {
        admin.registrarMedico(medico1);
        assertTrue(admin.eliminarMedico("101"));
    }

    @Test
    public void testEliminarMedico_NoExiste() {
        assertFalse(admin.eliminarMedico("999"));
    }

}
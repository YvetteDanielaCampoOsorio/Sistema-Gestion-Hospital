package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    private Administrador admin;
    private Paciente paciente1, paciente2;
    private Medico medico1, medico2;



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
        Paciente modificado = new Paciente("101", "Ana María", LocalDate.of(2001, 4, 4), "nuevo@mail.com", "3115485878", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        assertTrue(admin.modificarPaciente(modificado));
    }

    @Test
    public void testModificarPaciente_NoExiste() {
        assertFalse(admin.modificarPaciente(paciente1));
    }

    @Test
    public void testEliminarPaciente_Exitoso() {
        admin.registrarPaciente(paciente2);
        assertTrue(admin.eliminarPaciente("102"));
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
        Medico modificado = new Medico("202", "12345678", LocalDate.of(1975, 3, 15), "Joe", "hsnñas{sñ", EspecialidadMedica.PEDIATRIA, new ArrayList<>());
        assertTrue(admin.modificarMedico(modificado));
    }

    @Test
    public void testModificarMedico_NoExiste() {
        assertFalse(admin.modificarMedico(medico2));
    }

    @Test
    public void testEliminarMedico_Exitoso() {
        admin.registrarMedico(medico1);
        assertTrue(admin.eliminarMedico("201"));
    }

    @Test
    public void testEliminarMedico_NoExiste() {
        assertFalse(admin.eliminarMedico("999"));
    }
}

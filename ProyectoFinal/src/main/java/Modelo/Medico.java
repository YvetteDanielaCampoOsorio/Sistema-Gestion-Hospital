package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Medico extends Persona implements IGestionCitas {
    private EspecialidadMedica especialidad;
    private final List<Cita> citas;

    public Medico(String id, String telefono, String fechaNacimiento,
                  String nombre, String correo, EspecialidadMedica especialidad) {
        super(id, telefono, fechaNacimiento, nombre, correo);
        this.especialidad = Objects.requireNonNull(especialidad);
        this.citas = new ArrayList<>();
    }

    @Override
    public String mostrarInformacionBasica() {
        return String.format("Dr. %s - %s (ID: %s)", getNombre(), especialidad, getId());
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public List<Cita> getCitas() {
        return new ArrayList<>(citas);
    }

    @Override
    public void agendarCita(Cita cita) {

    }

    @Override
    public void cancelarCita(String idCita) {

    }

    @Override
    public Cita verCita(String idCita) {
        return null;
    }

    @Override
    public void reagendarCita(String idCita, LocalDate nuevaFecha, LocalTime nuevaHora) {

    }

    @Override
    public List<Cita> listarCitasPorPaciente(String idPaciente) {
        return List.of();
    }

    @Override
    public List<Cita> listarCitasPorMedico(String idMedico) {
        return List.of();
    }
}
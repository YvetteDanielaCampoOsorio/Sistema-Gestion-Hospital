package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Administrador extends Persona implements IGestorUsuarios {
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    public Administrador(String id, String nombre) {
        this(id, "", "01/01/1980", nombre, "", new ArrayList<>(), new ArrayList<>());
    }

    public Administrador(String id, String telefono, String fechaNacimiento,
                         String nombre, String correo,
                         List<Medico> medicos, List<Paciente> pacientes) {
        super(id, telefono, fechaNacimiento, nombre, correo);
        this.pacientes = new ArrayList<>(Objects.requireNonNull(pacientes));
        this.medicos = new ArrayList<>(Objects.requireNonNull(medicos));
    }

    @Override
    public boolean registrarPaciente(Paciente paciente) {
        Objects.requireNonNull(paciente, "El paciente no puede ser nulo");
        if (existePaciente(paciente.getId())) {
            return false;
        }
        return pacientes.add(paciente);
    }

    @Override
    public boolean modificarPaciente(Paciente paciente) {
        Objects.requireNonNull(paciente, "El paciente no puede ser nulo");
        return pacientes.stream()
                .filter(p -> p.getId().equals(paciente.getId()))
                .findFirst()
                .map(p -> {
                    int index = pacientes.indexOf(p);
                    pacientes.set(index, paciente);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean eliminarPaciente(String idPaciente) {
        Objects.requireNonNull(idPaciente, "El ID del paciente no puede ser nulo");
        return pacientes.removeIf(p -> p.getId().equals(idPaciente));
    }

    @Override
    public boolean registrarMedico(Medico medico) {
        Objects.requireNonNull(medico, "El médico no puede ser nulo");
        if (existeMedico(medico.getId())) {
            return false;
        }
        return medicos.add(medico);
    }

    @Override
    public boolean modificarMedico(Medico medico) {
        Objects.requireNonNull(medico, "El médico no puede ser nulo");
        return medicos.stream()
                .filter(m -> m.getId().equals(medico.getId()))
                .findFirst()
                .map(m -> {
                    int index = medicos.indexOf(m);
                    medicos.set(index, medico);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean eliminarMedico(String idMedico) {
        Objects.requireNonNull(idMedico, "El ID del médico no puede ser nulo");
        return medicos.removeIf(m -> m.getId().equals(idMedico));
    }

    public List<Paciente> buscarPacientesPorNombre(String nombre) {
        return pacientes.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Medico> buscarMedicosPorEspecialidad(EspecialidadMedica especialidad) {
        return medicos.stream()
                .filter(m -> m.getEspecialidad() == especialidad)
                .collect(Collectors.toList());
    }

    private boolean existePaciente(String id) {
        return pacientes.stream().anyMatch(p -> p.getId().equals(id));
    }

    private boolean existeMedico(String id) {
        return medicos.stream().anyMatch(m -> m.getId().equals(id));
    }

    @Override
    public String mostrarInformacionBasica() {
        return String.format("Administrador: %s (ID: %s)", getNombre(), getId());
    }

    // Getters con copias defensivas
    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public List<Medico> getMedicos() {
        return new ArrayList<>(medicos);
    }
}


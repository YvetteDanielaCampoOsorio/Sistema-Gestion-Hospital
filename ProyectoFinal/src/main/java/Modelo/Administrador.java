package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona implements IGestorUsuarios {

    private List<Paciente> pacientes;
    private List<Medico> medicos;

    public Administrador(String id, String correo, String nombre, String telefono) {
        super(id, correo, nombre, telefono);
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
    }

    private boolean existePaciente(String id) {
        return pacientes.stream().anyMatch(p -> p.getId().equals(id));
    }

    private boolean existeMedico(String id) {
        return medicos.stream().anyMatch(m -> m.getId().equals(id));
    }

    @Override
    public boolean registrarPaciente(Paciente paciente) {
        if (existePaciente(paciente.getId())) return false;
        return pacientes.add(paciente);
    }

    @Override
    public boolean modificarPaciente(Paciente paciente) {
        if (!existePaciente(paciente.getId())) return false;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId().equals(paciente.getId())) {
                pacientes.set(i, paciente);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarPaciente(String idPaciente) {
        if (!existePaciente(idPaciente)) return false;
        return pacientes.removeIf(p -> p.getId().equals(idPaciente));
    }

    @Override
    public boolean registrarMedico(Medico medico) {
        if (existeMedico(medico.getId())) return false;
        return medicos.add(medico);
    }

    @Override
    public boolean modificarMedico(Medico medico) {
        if (!existeMedico(medico.getId())) return false;
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId().equals(medico.getId())) {
                medicos.set(i, medico);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarMedico(String idMedico) {
        if (!existeMedico(idMedico)) return false;
        return medicos.removeIf(m -> m.getId().equals(idMedico));
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    // Getters para testing opcionales
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
}


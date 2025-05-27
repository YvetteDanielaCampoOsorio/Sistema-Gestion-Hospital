package Modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaHospital {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Sala> salas;
    private Agenda agenda;

    public SistemaHospital(List<Paciente> pacientes, Agenda agenda, List<Medico> medicos) {
        this.pacientes = pacientes;
        this.agenda = agenda;
        this.medicos = medicos;
        this.salas = new ArrayList<>();
    }

    public SistemaHospital() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.agenda = new Agenda();
    }

    public void registrarPaciente(Paciente paciente) {
        if (paciente != null && !pacientes.contains(paciente)) {
            pacientes.add(paciente);
        }
    }

    public void registrarMedico(Medico medico) {
        if (medico != null && !medicos.contains(medico)) {
            medicos.add(medico);
        }
    }

    public void registrarSala(Sala sala) {
        if (sala != null && !salas.contains(sala)) {
            salas.add(sala);
        }
    }


    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}

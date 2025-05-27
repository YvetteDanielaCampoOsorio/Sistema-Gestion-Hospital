package Modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaHospital {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private Agenda agenda;

    public SistemaHospital(List<Paciente> pacientes, Agenda agenda, List<Medico> medicos) {
        this.pacientes = pacientes;
        this.agenda = agenda;
        this.medicos = medicos;
    }

    public SistemaHospital() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.agenda = new Agenda();
    }



    // regitrar un nuevo paciente
    public void registrarPaciente() {
        pacientes.add(paciente);
    }
    //registrar un nuevo medico
    public void resgistrarMedico(Medico medico) {
        medicos.add(medico);
    }
    //registrar sala
    public void registrarSala(Sala sala) {
        if (sala != null && !sala.contains(sala)) {
            sala.add(sala);
        }
    }
    //dar manejo de citas a la agenda
    public void agendarCita(Cita cita) {
        agenda.agendarCita(cita);
        cita.getPaciente().agendarCitas(cita);
        cita.getMedico().agendarCitas(cita);
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

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void registrarPaciente(Paciente paciente) {
    }
}

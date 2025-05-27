package Modelo;

public interface IGestorUsuarios {
    boolean registrarPaciente(Paciente paciente);
    boolean modificarPaciente(Paciente paciente);
    boolean eliminarPaciente(String idPaciente);

    boolean registrarMedico(Medico medico);
    boolean modificarMedico(Medico medico);
    boolean eliminarMedico(String idMedico);
}

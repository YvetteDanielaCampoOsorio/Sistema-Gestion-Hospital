package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IGestionCitas {
    void agendarCita(Cita cita);
    void cancelarCita(String idCita);
    Cita verCita(String idCita);
    void reagendarCita(String idCita, LocalDate nuevaFecha, LocalTime nuevaHora);
    List<Cita> listarCitasPorPaciente(String idPaciente);
    List<Cita> listarCitasPorMedico(String idMedico);
}
package Modelo;

import java.time.LocalDate;
import java.util.List;

public record HistorislMedico(LocalDate fecha, String Diagnstico, List<String> Personal) {
}

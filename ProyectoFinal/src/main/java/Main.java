import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> pacientes = new ArrayList<>();
    private static List<String> medicos = new ArrayList<>();
    private static List<String> citas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "🏥 SISTEMA DE GESTIÓN HOSPITALARIA 🏥\n\n" +
                            "1. Registrar paciente\n" +
                            "2. Registrar médico\n" +
                            "3. Programar cita\n" +
                            "4. Ver pacientes\n" +
                            "5. Ver médicos\n" +
                            "6. Ver citas\n" +
                            "7. Salir\n\n" +
                            "Seleccione una opción:"
            );

            if (opcion == null || opcion.equals("7")) {
                JOptionPane.showMessageDialog(null, "¡Hasta pronto! 👋");
                System.exit(0);
            }

            switch (opcion) {
                case "1":
                    registrarPaciente();
                    break;
                case "2":
                    registrarMedico();
                    break;
                case "3":
                    programarCita();
                    break;
                case "4":
                    mostrarLista("Pacientes registrados", pacientes);
                    break;
                case "5":
                    mostrarLista("Médicos registrados", medicos);
                    break;
                case "6":
                    mostrarLista("Citas programadas", citas);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "❌ Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Métodos para cada funcionalidad
    private static void registrarPaciente() {
        String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
        String edad = JOptionPane.showInputDialog("Edad del paciente:");
        String id = JOptionPane.showInputDialog("ID del paciente:");

        if (nombre != null && edad != null && id != null) {
            pacientes.add("👤 " + nombre + " | Edad: " + edad + " | ID: " + id);
            JOptionPane.showMessageDialog(null, "✅ Paciente registrado con éxito");
        }
    }

    private static void registrarMedico() {
        String nombre = JOptionPane.showInputDialog("Nombre del médico:");
        String especialidad = JOptionPane.showInputDialog("Especialidad:");
        String id = JOptionPane.showInputDialog("ID del médico:");

        if (nombre != null && especialidad != null && id != null) {
            medicos.add("👨‍⚕️ " + nombre + " | Especialidad: " + especialidad + " | ID: " + id);
            JOptionPane.showMessageDialog(null, "✅ Médico registrado con éxito");
        }
    }

    private static void programarCita() {
        if (pacientes.isEmpty() || medicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❌ No hay pacientes o médicos registrados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idPaciente = JOptionPane.showInputDialog("ID del paciente:");
        String idMedico = JOptionPane.showInputDialog("ID del médico:");
        String fecha = JOptionPane.showInputDialog("Fecha (DD/MM/AAAA):");
        String hora = JOptionPane.showInputDialog("Hora (HH:MM):");

        if (idPaciente != null && idMedico != null && fecha != null && hora != null) {
            citas.add("📅 Paciente ID: " + idPaciente + " | Médico ID: " + idMedico + " | Fecha: " + fecha + " a las " + hora);
            JOptionPane.showMessageDialog(null, "✅ Cita programada con éxito");
        }
    }

    private static void mostrarLista(String titulo, List<String> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registros disponibles", titulo, JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String item : lista) {
                sb.append(item).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), titulo, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
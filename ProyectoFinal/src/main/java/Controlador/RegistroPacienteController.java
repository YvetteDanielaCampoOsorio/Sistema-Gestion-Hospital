package Controlador;

import Modelo.Cita;
import Modelo.Notificacion;
import Modelo.Paciente;
import Modelo.SistemaHospital;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroPacienteController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private DatePicker fechaNacimiento;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;

    private SistemaHospital sistema = new SistemaHospital();

    @FXML
    public void registrarPaciente() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        LocalDate fecha = fechaNacimiento.getValue();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();

        if (id.isEmpty() || nombre.isEmpty() || fecha == null || correo.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return;
        }

        // Crear listas vacías para el nuevo paciente

        List<Cita> citas = new ArrayList<>();
        List<String> historialMedico = new ArrayList<>();
        List<Notificacion> notificaciones = new ArrayList<>();

        Paciente paciente = new Paciente(id, correo, nombre, telefono, historialMedico, citas, notificaciones);
        sistema.registrarPaciente(paciente);
        mostrarAlerta("Paciente registrado correctamente.");
        limpiarCampos();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        fechaNacimiento.setValue(null);
        txtCorreo.clear();
        txtTelefono.clear();
    }
}
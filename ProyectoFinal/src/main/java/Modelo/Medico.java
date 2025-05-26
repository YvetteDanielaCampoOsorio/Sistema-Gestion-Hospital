package Modelo;

import java.util.List;

public abstract class Medico extends Persona implements IGestionCitas {
    private EspecialidadMedica especialidad;
    private List<Cita> citas;

    public Medico(String id, String correo, String nombre, String telefono, EspecialidadMedica especialidad, List<Cita> citas) {
        super(id, correo, nombre, telefono);
        this.especialidad = especialidad;
        this.citas = citas;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadMedica especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public Medico(String id, String correo, String nombre, String telefono) {
        super(id, correo, nombre, telefono);
    }
//metodos adstacto
    @Override
    public void mostrarInfo() {

    }
//metodos de la intefaz

    @Override
    public void cancelarCita(Cita cita) {

    }

    @Override
    public void verCita(Cita cita) {

    }

    @Override
    public void agendarCitas(Cita cita) {

    }
}

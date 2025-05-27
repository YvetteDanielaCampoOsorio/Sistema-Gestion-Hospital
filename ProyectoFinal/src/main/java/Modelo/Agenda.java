package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Cita> citas;

    //Agendar Cita
    public void  agendarCita (Cita cita){
        citas.add(cita);
    }
    //cancelar cita
    public  void cancelarCita (Cita cita){
        citas.remove(cita);
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}




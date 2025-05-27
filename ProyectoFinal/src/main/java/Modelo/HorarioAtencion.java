package Modelo;

import java.time.LocalDate;

public class HorarioAtencion {
    private LocalDate fecha;
    private String ubicacionAtencion;

    public HorarioAtencion(String ubicacion, LocalDate fecha) {
        this.ubicacionAtencion = ubicacion;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacionAtencion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacionAtencion = ubicacion;
    }
}


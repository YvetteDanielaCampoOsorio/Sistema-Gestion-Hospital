package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private String id;
    private String ubicacion;
    private String nombreSala;
    private List<Sala> salas = new ArrayList<>();

    public Sala(String id, String ubicacion, String nombreSala, List<Sala> salas) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.nombreSala = nombreSala;
        this.salas = salas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean contains(Sala sala) {
        return false;
    }
}




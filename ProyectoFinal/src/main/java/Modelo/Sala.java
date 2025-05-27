package Modelo;

public class Sala {

    private String id;
    private String ubicacion;
    private String nombreSala;

    public Sala(String id, String ubicacion, String nombreSala) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.nombreSala = nombreSala;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}




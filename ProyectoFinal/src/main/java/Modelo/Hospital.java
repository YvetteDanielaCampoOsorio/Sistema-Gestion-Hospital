package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nit;
    private String nombre;
    private List<Administrador> administradores;
    private List<Sala> salas;

    public Hospital(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        this.administradores = new ArrayList<>();
        this.salas =new ArrayList<>();
    }
    //Administradores registro
   public boolean registrarAdministrador(Administrador administrador) {
        return administradores.add(administrador);
   }
    //Administradores eliminar
    public boolean eliminarAdministrador(String idAdministrador) {
        for (Administrador administrador : administradores) {
            if (administrador.getId().equals(idAdministrador)) {
                administradores.remove(administrador);
                return true;
            }
        }
        return false;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Administrador> getAdministradores() {
        return administradores;
    }
    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }
    public List<Sala> getSalas() {
        return salas;
    }
    //Agregar Sala
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }
}

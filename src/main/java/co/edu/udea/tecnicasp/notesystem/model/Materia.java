package co.edu.udea.tecnicasp.notesystem.model;

import java.util.List;

public class Materia
{
    private String nombre;
    private Integer creditos;

    private List<Notas> notas;

    public Materia(String nombre, Integer creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }
}

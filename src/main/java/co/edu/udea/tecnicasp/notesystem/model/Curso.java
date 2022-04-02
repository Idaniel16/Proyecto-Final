package co.edu.udea.tecnicasp.notesystem.model;

import java.util.List;

public class Curso
{
    private Integer codigo;
    private String nombre;
    private Integer creditos;

    private List<Notas> notas;

    public Curso(Integer codigo, String nombre, Integer creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

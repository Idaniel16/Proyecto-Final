package co.edu.udea.tecnicasp.notesystem.model;

public class Notas
{
    private Float notas;
    private Float porcentajes;

    private Curso meteria;

    public Notas(Float notas, Float porcentajes) {
        this.notas = notas;
        this.porcentajes = porcentajes;
    }

    public Float getNotas() {
        return notas;
    }

    public void setNotas(Float notas) {
        this.notas = notas;
    }

    public Float getPorcentajes() {
        return porcentajes;
    }

    public void setPorcentajes(Float porcentajes) {
        this.porcentajes = porcentajes;
    }

    public Curso getCurso() {
        return meteria;
    }

    public void setCurso(Curso meteria) {
        this.meteria = meteria;
    }

}

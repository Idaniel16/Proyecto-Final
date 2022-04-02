package co.edu.udea.tecnicasp.notesystem.model;

public class Notas
{
    private Double notas;
    private Double porcentajes;

    private Materia meteria;

    public Notas(Double notas, Double porcentajes) {
        this.notas = notas;
        this.porcentajes = porcentajes;
    }

    public Double getNotas() {
        return notas;
    }

    public void setNotas(Double notas) {
        this.notas = notas;
    }

    public Double getPorcentajes() {
        return porcentajes;
    }

    public void setPorcentajes(Double porcentajes) {
        this.porcentajes = porcentajes;
    }

    public Materia getMeteria() {
        return meteria;
    }

    public void setMeteria(Materia meteria) {
        this.meteria = meteria;
    }
}

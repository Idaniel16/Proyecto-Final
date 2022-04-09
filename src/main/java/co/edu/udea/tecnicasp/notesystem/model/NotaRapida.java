package co.edu.udea.tecnicasp.notesystem.model;

public class NotaRapida
{
   private Double nota;
   private Double porcentaje;


    public NotaRapida(Double nota, Double porcentaje) {
        this.nota = nota;
        this.porcentaje = porcentaje;

    }


    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}

package co.edu.udea.tecnicasp.notesystem.model;

public class Semestre
{
   private Double notaFinal;

   public Semestre(Double notaFinal) {
      this.notaFinal = notaFinal;

   }

   public Double getNotaFinal() {
      return notaFinal;
   }

   public void setNotaFinal(Double notaFinal) {
      this.notaFinal = notaFinal;
   }
}

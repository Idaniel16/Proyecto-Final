package co.edu.udea.tecnicasp.notesystem.bsn;

public class NotaBsn
{
    public double CalcularNota(double porcentaje, double nota)
    {

            double porcentajeDecimal = porcentaje / 100;
            double promNota;
            promNota = nota * porcentajeDecimal;


        return promNota;
    }
}

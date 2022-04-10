package co.edu.udea.tecnicasp.notesystem.dao.exceptions;

public class NoExistenNotasException extends Exception
{
    public NoExistenNotasException()
    {
        super("no hay notas para calcular");
    }
}

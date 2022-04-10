package co.edu.udea.tecnicasp.notesystem.dao.exceptions;

public class CursoYaExiste extends Exception
{
    public CursoYaExiste()
    {
        super("El curso ya existe");
    }
}

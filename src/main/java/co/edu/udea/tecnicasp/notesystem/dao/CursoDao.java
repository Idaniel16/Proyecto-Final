package co.edu.udea.tecnicasp.notesystem.dao;

import co.edu.udea.tecnicasp.notesystem.dao.exceptions.CursoRepetidoException;
import co.edu.udea.tecnicasp.notesystem.model.Curso;

import java.util.List;

public interface CursoDao
{
    void registrarCurso(Curso curso) throws CursoRepetidoException;

    List<Curso>ListarCursos();

    Curso consultarCursoPorCod(Integer cod);


}

package co.edu.udea.tecnicasp.notesystem.dao;

import co.edu.udea.tecnicasp.notesystem.model.Notas;

import java.util.List;

public interface NotaDao
{
    void registrarNota(Notas notas);

    List<Notas> listarNotasPorCurso(Integer codigoCurso);

    Notas consultarNotasPorCodigoCurso(Integer codCurso);

}

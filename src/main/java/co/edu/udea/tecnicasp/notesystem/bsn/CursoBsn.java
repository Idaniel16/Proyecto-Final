package co.edu.udea.tecnicasp.notesystem.bsn;

import co.edu.udea.tecnicasp.notesystem.dao.CursoDao;
import co.edu.udea.tecnicasp.notesystem.dao.exceptions.CursoRepetidoException;
import co.edu.udea.tecnicasp.notesystem.dao.exceptions.CursoYaExiste;
import co.edu.udea.tecnicasp.notesystem.dao.impl.CursoDAOFile;
import co.edu.udea.tecnicasp.notesystem.model.Curso;

import java.util.List;

public class CursoBsn {

    private CursoDao cursoDao;

    public CursoBsn()
    {
        this.cursoDao = new CursoDAOFile();
    }

    public void registrarCurso(Curso curso) throws CursoYaExiste
    {
        try {
            this.cursoDao.registrarCurso(curso);
        }catch (CursoRepetidoException cre)
        {
            throw new CursoYaExiste();
        }
    }

    public List<Curso> listarCurso() {
        return this.cursoDao.ListarCursos();
    }


}

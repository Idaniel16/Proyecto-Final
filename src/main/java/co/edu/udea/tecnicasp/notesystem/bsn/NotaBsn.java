package co.edu.udea.tecnicasp.notesystem.bsn;

import co.edu.udea.tecnicasp.notesystem.dao.NotaDao;
import co.edu.udea.tecnicasp.notesystem.dao.impl.NotaDAOFile;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import co.edu.udea.tecnicasp.notesystem.model.Notas;

import java.util.List;

public class NotaBsn
{
    private NotaDao notaDao;


    public NotaBsn(){
        this.notaDao = new NotaDAOFile();
    }

    public void registrarNota(Notas notas){

            this.notaDao.registrarNota(notas);

    }

    public List<Notas> listarNotasPorCurso(Integer codigoCurso) {
        return this.notaDao.listarNotasPorCurso(codigoCurso);
    }

   /* public Notas consultarNotasPorCodigoCurso(Integer codCurso)
    {
        return this.notaDao.consultarNotasPorCodigoCurso(codCurso);
    }*/
}

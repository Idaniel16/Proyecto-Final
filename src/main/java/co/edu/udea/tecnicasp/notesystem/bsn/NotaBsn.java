package co.edu.udea.tecnicasp.notesystem.bsn;

import co.edu.udea.tecnicasp.notesystem.dao.NotaDao;
import co.edu.udea.tecnicasp.notesystem.dao.impl.NotaDAOFile;
import co.edu.udea.tecnicasp.notesystem.model.Notas;

public class NotaBsn
{
    private NotaDao notaDao;

    public NotaBsn(){
        this.notaDao = new NotaDAOFile();
    }

    public void registrarNota(Notas notas){

            this.notaDao.registrarNota(notas);

    }

}

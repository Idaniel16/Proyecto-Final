package co.edu.udea.tecnicasp.notesystem.bsn;

import co.edu.udea.tecnicasp.notesystem.dao.CalculoRapidoDao;
import co.edu.udea.tecnicasp.notesystem.dao.impl.CalculoRapidoDAOList;
import co.edu.udea.tecnicasp.notesystem.model.NotaRapida;
import co.edu.udea.tecnicasp.notesystem.model.Notas;
import java.util.List;

public class CalculoRapidoBsn
{

    private CalculoRapidoDao calculoRapidoDao;

    public CalculoRapidoBsn()
    {
        this.calculoRapidoDao = new CalculoRapidoDAOList();
    }

    public void guardarCalculoRapido(NotaRapida notaRapida)
    {

            this.calculoRapidoDao.guardarCalculoRapido(notaRapida);

    }
    public List<NotaRapida> consultarCalculoRapido()
    {
        return this.calculoRapidoDao.consultarOjectNotaRapida();
    }

}

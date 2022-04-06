package co.edu.udea.tecnicasp.notesystem.bsn;

import co.edu.udea.tecnicasp.notesystem.dao.CalculoRapidoDao;
import co.edu.udea.tecnicasp.notesystem.dao.impl.CalculoRapidoDAOList;
import co.edu.udea.tecnicasp.notesystem.model.CalculoRapido;

import java.util.List;

public class CalculoRapidoBsn {

    private CalculoRapidoDao calculoRapidoDao;

    public CalculoRapidoBsn()
    {
        this.calculoRapidoDao = new CalculoRapidoDAOList();
    }

    public void guardarCalculoRapido(CalculoRapido calculoRapido) {

            this.calculoRapidoDao.guardarCalculoRapido(calculoRapido);

    }

    public List<CalculoRapido> consultarCalculoRapido() {
        return this.calculoRapidoDao.consultarCalculoRapido();
    }

    public Double calcularNota(CalculoRapido calculoRapido)
    {

        Double nota = calculoRapido.getNota();
        Double porcentaje = calculoRapido.getPorcentaje();
        Double notaDecimal = nota * (porcentaje/100);

        return notaDecimal;
    }


}

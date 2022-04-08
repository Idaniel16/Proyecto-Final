package co.edu.udea.tecnicasp.notesystem.dao.impl;

import co.edu.udea.tecnicasp.notesystem.dao.CalculoRapidoDao;
import co.edu.udea.tecnicasp.notesystem.model.NotaRapida;

import java.util.ArrayList;
import java.util.List;

public class CalculoRapidoDAOList implements CalculoRapidoDao
{

    private static final List<NotaRapida> calculoRapidoBD = new ArrayList<>();

    @Override
    public void guardarCalculoRapido(NotaRapida calculoRapido)
    {

        calculoRapidoBD.add(calculoRapido);

    }

    @Override
    public List<NotaRapida> consultarOjectNotaRapida()
    {
        return calculoRapidoBD;
    }


}

package co.edu.udea.tecnicasp.notesystem.dao.impl;

import co.edu.udea.tecnicasp.notesystem.dao.CalculoRapidoDao;
import co.edu.udea.tecnicasp.notesystem.model.CalculoRapido;

import java.util.ArrayList;
import java.util.List;

public class CalculoRapidoDAOList implements CalculoRapidoDao {

    private static final List<CalculoRapido> calculoRapidoBD = new ArrayList<>();
    @Override
    public void guardarCalculoRapido(CalculoRapido calculoRapido) {

        calculoRapidoBD.add(calculoRapido);

    }

    @Override
    public List<CalculoRapido> consultarCalculoRapido()
    {

        return calculoRapidoBD;
    }


}

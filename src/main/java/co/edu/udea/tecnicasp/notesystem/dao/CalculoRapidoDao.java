package co.edu.udea.tecnicasp.notesystem.dao;

import co.edu.udea.tecnicasp.notesystem.model.NotaRapida;

import java.util.List;

public interface CalculoRapidoDao {

    void guardarCalculoRapido(NotaRapida notaRapida);

    List<NotaRapida> consultarOjectNotaRapida();



}

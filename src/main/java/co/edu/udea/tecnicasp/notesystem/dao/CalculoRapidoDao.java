package co.edu.udea.tecnicasp.notesystem.dao;

import co.edu.udea.tecnicasp.notesystem.model.CalculoRapido;
import co.edu.udea.tecnicasp.notesystem.model.Curso;

import java.util.List;

public interface CalculoRapidoDao {

    void guardarCalculoRapido(CalculoRapido calculoRapido);

    List<CalculoRapido> consultarCalculoRapido();



}

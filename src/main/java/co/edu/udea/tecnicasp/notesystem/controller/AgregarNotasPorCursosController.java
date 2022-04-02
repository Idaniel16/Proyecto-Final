package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import co.edu.udea.tecnicasp.notesystem.model.Notas;
import co.edu.udea.tecnicasp.notesystem.bsn.NotaBsn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;

public class AgregarNotasPorCursosController
{
    @FXML
    private ComboBox<Curso> cmbCurso;
    @FXML
    private TextField txtNota;
    @FXML
    private TextField txtPorcentaje;


    private CursoBsn cursoBsn;
    private NotaBsn notaBsn;

    public AgregarNotasPorCursosController(){
        this.cursoBsn = new CursoBsn();
        this.notaBsn = new NotaBsn();
    }

    @FXML
    private void initialize(){
        List<Curso> cursos = this.cursoBsn.listarCurso();
        ObservableList<Curso> cursoObservable = FXCollections.observableList(cursos);
        this.cmbCurso.setItems(cursoObservable);
    }

    public void cmdLimpiarCampos_action(){

    }

    public void cmdAgregar_action(){
        Curso cursoSeleccionado = this.cmbCurso.getValue();
        String nota = txtNota.getText();
        String porcentaje = txtPorcentaje.getText();
        Double nota1 = Double.parseDouble(nota);
        Double porcentaje1 = Double.parseDouble(porcentaje);

        Notas notas = new Notas(nota1, porcentaje1);
        notas.setCurso(cursoSeleccionado);
        this.notaBsn.registrarNota(notas);
    }
}


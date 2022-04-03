package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class ListaDeCursosController {
    @FXML
    private TableView<Curso> tblCursos;
    @FXML
    private TableColumn<Curso, String> clmNombres;
    @FXML
    private TableColumn<Curso, Integer> clmCreditos;
    private CursoBsn cursoBsn;

    public ListaDeCursosController() {
        this.cursoBsn = new CursoBsn();
    }
    @FXML
    private void initialize() {
        clmCreditos.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCreditos()).asObject());
        clmNombres.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        cargarListaCurso();
    }

    private void cargarListaCurso() {
        List<Curso> cursoList = this.cursoBsn.listarCurso();
        ObservableList<Curso> cursoObservableList = FXCollections.observableList(cursoList);
        tblCursos.setItems(cursoObservableList);
    }
}

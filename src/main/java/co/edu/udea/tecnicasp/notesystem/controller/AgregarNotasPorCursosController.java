package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import co.edu.udea.tecnicasp.notesystem.model.Notas;
import co.edu.udea.tecnicasp.notesystem.bsn.NotaBsn;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AgregarNotasPorCursosController
{

    @FXML
    private ComboBox<Curso> cmbCurso;
    @FXML
    private TextField txtNota;
    @FXML
    private TextField txtPorcentaje;
    @FXML
    private TableView<Notas> tblNotas;
    @FXML
    private TableColumn<Notas, Double> clmNotas;
    @FXML
    private TableColumn<Notas, Double> clmPorcentaje;
    @FXML
    private Label lblNota;
    @FXML
    private Label lblPorcentaje;

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

        this.cmbCurso.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, cursoPrevio, cursoNuevo) -> cmbCursoItemSeleccionado_listener(cursoNuevo)
        );
        this.clmNotas.setCellValueFactory(cellValue -> new SimpleDoubleProperty(cellValue.getValue().getNotas()).asObject());
        this.clmPorcentaje.setCellValueFactory(cellValue -> new SimpleDoubleProperty(cellValue.getValue().getPorcentajes()).asObject());

        txtNota.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^\\d+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));
        txtPorcentaje.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^\\d+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));

    }

    private void cmbCursoItemSeleccionado_listener(Curso cursoNuevo) {
        if (cursoNuevo != null) {
            List<Notas> notasCurso = this.notaBsn.cunsultarNotasPorCurso(cursoNuevo.getCodigo());
            ObservableList<Notas> notasCursoObservables = FXCollections.observableList(notasCurso);
            tblNotas.setItems(notasCursoObservables);
        }

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
        this.tblNotas.getItems().add(notas);
        txtPorcentaje.clear();
        txtNota.clear();

    }
    public void cmdCalcular_action()
    {
        Curso cursoSeleccionado = this.cmbCurso.getValue();
        List<Notas> notasList = notaBsn.cunsultarNotasPorCurso(cursoSeleccionado.getCodigo());
        Double notaFinal = 0.0, porcentajeAcumulado = 0.0;

        for(int i=0; i<notasList.size(); i++){
            notaFinal = notaFinal + notasList.get(i).getNotas()*(notasList.get(i).getPorcentajes()/100);
            porcentajeAcumulado = porcentajeAcumulado + notasList.get(i).getPorcentajes();
        }
        lblNota.setText(notaFinal.toString());
        lblPorcentaje.setText(porcentajeAcumulado.toString());

    }
}


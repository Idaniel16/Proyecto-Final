package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.dao.exceptions.NoExistenNotasException;
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

        validacionNumerica(txtNota);
        validacionNumerica(txtPorcentaje);

    }

    private void cmbCursoItemSeleccionado_listener(Curso cursoNuevo)
    {
        if (cursoNuevo != null) {
            List<Notas> notasCurso = this.notaBsn.cunsultarNotasPorCurso(cursoNuevo.getCodigo());
            ObservableList<Notas> notasCursoObservables = FXCollections.observableList(notasCurso);
            tblNotas.setItems(notasCursoObservables);
        }
    }

    public void cmdAgregar_action()
    {
        try {
            Curso cursoSeleccionado = this.cmbCurso.getValue();
            String nota = txtNota.getText();
            String porcentaje = txtPorcentaje.getText();

            Float nota1 = Float.parseFloat(nota);
            Float porcentaje1 = Float.parseFloat(porcentaje);

            Notas notas = new Notas(nota1, porcentaje1);
            try {
                notas.setCurso(cursoSeleccionado);
                this.notaBsn.registrarNota(notas);
                this.tblNotas.getItems().add(notas);
            }catch (NullPointerException npe)
            {
                alertInformativoSeleccion();
            }
            txtPorcentaje.clear();
            txtNota.clear();
        }catch (NumberFormatException nfe)
        {
            alertInformativoCamposVacios();
        }

    }
    public void cmdCalcular_action() throws NoExistenNotasException {
        try {
            Curso cursoSeleccionado = this.cmbCurso.getValue();
            List<Notas> notasList = notaBsn.cunsultarNotasPorCurso(cursoSeleccionado.getCodigo());
            Float notaFinal = 0f, porcentajeAcumulado = 0f;
            if(notasList.size() > 0) {
                for (int i = 0; i < notasList.size(); i++) {
                    notaFinal += notasList.get(i).getNotas() * (notasList.get(i).getPorcentajes() / 100);
                    porcentajeAcumulado += notasList.get(i).getPorcentajes();
                }
                lblNota.setText(notaFinal.toString());
                lblPorcentaje.setText(porcentajeAcumulado.toString() + "%");
            }else
            {
                alertInformativoNota();
            }
        }catch (NullPointerException npe)
        {
            alertInformativo();
        }

    }

    public static void validacionNumerica(TextField campo)
    {
        campo.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^\\d+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));
    }

    public void alertInformativo()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Seleccione curso");
        alert.setContentText("No se puede calcular la nota sin antes seleccionar un curso");
        alert.showAndWait();
    }
    public void alertInformativoNota()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("No hay notas");
        alert.setContentText("No tienes notas para efectuar la operacion, favor agregar notas al curso");
        alert.showAndWait();
    }

    public void alertInformativoCamposVacios()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Campos vacios");
        alert.setContentText("Tienes que digitar la nota y el porcentaje");
        alert.showAndWait();
    }
    public void alertInformativoSeleccion()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Seleccionar Curso");
        alert.setContentText("No Tienes seleccionado ningun curso");
        alert.showAndWait();
    }
}


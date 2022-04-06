package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CalculoRapidoBsn;
import co.edu.udea.tecnicasp.notesystem.model.CalculoRapido;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class CalculoRapidoController
{

    @FXML
    private TextField txtNota;
    @FXML
    private TextField txtPorcentaje;
    @FXML
    private Label lblNota;
    @FXML
    private Label lblPorcentaje;
    @FXML
    private TableView<CalculoRapido> tblNotas;
    @FXML
    private TableColumn<CalculoRapido, Double> cmlNotas;
    @FXML
    private TableColumn<CalculoRapido, Double> cmlPorcentajes;
    private CalculoRapido nuevoCalculo;
    private  Double notaAcumulada;
    private Double porcentajeAcumulado;


    private CalculoRapidoBsn calculoRapidoBsn;

    public CalculoRapidoController()
    {
        notaAcumulada = 0.0;
        porcentajeAcumulado = 0.0;
        calculoRapidoBsn = new CalculoRapidoBsn();
    }

    @FXML
    private void initialize() {
        cmlNotas.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getNota()).asObject());
        cmlPorcentajes.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPorcentaje()).asObject());
    }


    public void agregar_action()
    {
        Double notaIngresada = Double.parseDouble(txtNota.getText());
        Double porcentajeIgresado = Double.parseDouble(txtPorcentaje.getText());
        nuevoCalculo = new CalculoRapido(notaIngresada,porcentajeIgresado);

        this.tblNotas.getItems().add(nuevoCalculo);
        calculoRapidoBsn.guardarCalculoRapido(nuevoCalculo);
        porcentajeAcumulado = porcentajeAcumulado + porcentajeIgresado;

        txtNota.clear();
        txtPorcentaje.clear();

    }
    public void calcular_action()
    {
        notaAcumulada = notaAcumulada + calculoRapidoBsn.calcularNota(nuevoCalculo);
        lblNota.setText(notaAcumulada.toString());
        lblPorcentaje.setText(porcentajeAcumulado.toString());

    }

}

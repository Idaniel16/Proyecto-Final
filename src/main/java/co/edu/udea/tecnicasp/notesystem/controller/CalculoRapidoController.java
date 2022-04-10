package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CalculoRapidoBsn;
import co.edu.udea.tecnicasp.notesystem.model.NotaRapida;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private TableView<NotaRapida> tblNotas;
    @FXML
    private TableColumn<NotaRapida, Double> cmlNotas;
    @FXML
    private TableColumn<NotaRapida, Double> cmlPorcentajes;


    private CalculoRapidoBsn calculoRapidoBsn;

    public CalculoRapidoController()
    {
        calculoRapidoBsn = new CalculoRapidoBsn();
    }

    @FXML
    private void initialize() {
        cmlNotas.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getNota()).asObject());
        cmlPorcentajes.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPorcentaje()).asObject());

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


    public void agregar_action()
    {
        Double notaIngresada = Double.parseDouble(txtNota.getText());
        Double porcentajeIgresado = Double.parseDouble(txtPorcentaje.getText());
        NotaRapida notasRapidas = new NotaRapida(notaIngresada,porcentajeIgresado);

        this.tblNotas.getItems().add(notasRapidas);
        calculoRapidoBsn.guardarCalculoRapido(notasRapidas);

        txtNota.clear();
        txtPorcentaje.clear();

    }
    public void calcular_action()
    {

        List<NotaRapida> notaRapidaList = calculoRapidoBsn.consultarCalculoRapido();
        Double notaFinal = 0.0, porcentajeAcumulado = 0.0;
        for(int i=0; i<notaRapidaList.size(); i++){
           notaFinal = notaFinal + notaRapidaList.get(i).getNota()*(notaRapidaList.get(i).getPorcentaje()/100);
           porcentajeAcumulado = porcentajeAcumulado + notaRapidaList.get(i).getPorcentaje();
        }
        lblNota.setText(notaFinal.toString());
        lblPorcentaje.setText(porcentajeAcumulado.toString());
    }

}

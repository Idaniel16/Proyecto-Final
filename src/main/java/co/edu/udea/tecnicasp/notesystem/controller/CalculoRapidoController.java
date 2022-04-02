package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.NotaBsn;
import co.edu.udea.tecnicasp.notesystem.bsn.NotaRapidaBsn;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    private NotaRapidaBsn notaRapidaBsn;

    public CalculoRapidoController()
    {
        notaRapidaBsn = new NotaRapidaBsn();
    }


    public void agregar_action()
    {
        double notaIngresada = Double.parseDouble(txtNota.getText());
        double porcentajeIgresado = Double.parseDouble(txtPorcentaje.getText());
     

    }
    public void calcular_action()
    {



    }

}

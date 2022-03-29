package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.NotaBsn;
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

    private NotaBsn notaBsn;

    public CalculoRapidoController()
    {
        notaBsn = new NotaBsn();
    }


    public void agregar_action()
    {
        double notaIngresada = Double.parseDouble(txtNota.getText());
        double porcentajeIgresado = Double.parseDouble(txtPorcentaje.getText());
        double AcumNota = notaBsn.CalcularNota(porcentajeIgresado, notaIngresada);
        String nt = Double.toString(AcumNota);
        lblNota.setText(nt);

    }
    public void calcular_action()
    {



    }

}

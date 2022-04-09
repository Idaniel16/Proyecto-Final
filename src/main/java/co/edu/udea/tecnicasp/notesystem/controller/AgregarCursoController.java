package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class AgregarCursoController
{
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCreditos;

    private CursoBsn cursoBsn;

//    @FXML
//    private void initialize()
//    {
//        clmIdentificacion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdentificacion()).asObject());
//        clmNombres.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.));
//
//        txtCodigo.setTextFormatter(new TextFormatter<>(change -> {
//            if (change.getControlNewText().matches("^\\d+$") || change.getControlNewText().isEmpty()) {
//                return change;
//            }
//            return null;
//        }));
//
//        txtNombre.setTextFormatter(new TextFormatter<>(change -> {
//            if (change.getControlNewText().matches("^[\\p{L} .'-]+$") || change.getControlNewText().isEmpty()) {
//                return change;
//            }
//            return null;
//        }));
//
//    }

    public AgregarCursoController()
    {
        this.cursoBsn = new CursoBsn();
    }

    public void agregar_action()
    {
        String codigoIngresado = txtCodigo.getText();
        String nombreIngresado = txtNombre.getText();
        String creditosIngresado = txtCreditos.getText();

        Integer cod = Integer.parseInt(codigoIngresado);
        Integer creditos = Integer.parseInt(creditosIngresado);

        Curso curso = new Curso(cod,nombreIngresado,creditos);
        cursoBsn.registrarCurso(curso);

        limpiarCampos();
    }

    public void limpiar_action()
    {
        limpiarCampos();
    }

    public void limpiarCampos()
    {
        txtCodigo.clear();
        txtNombre.clear();
        txtCreditos.clear();
    }

}

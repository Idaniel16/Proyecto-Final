package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.dao.exceptions.CursoRepetidoException;
import co.edu.udea.tecnicasp.notesystem.dao.exceptions.CursoYaExiste;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML
    private void initialize()
    {

        validacionNumerica(txtCodigo);

        txtNombre.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^[\\p{L} .'-]+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));

        validacionNumerica(txtCreditos);

    }

    public AgregarCursoController()
    {
        this.cursoBsn = new CursoBsn();
    }

    public void agregar_action() throws CursoYaExiste
    {
        try {
            String codigoIngresado = txtCodigo.getText();
            String nombreIngresado = txtNombre.getText();
            String creditosIngresado = txtCreditos.getText();

            Integer cod = Integer.parseInt(codigoIngresado);
            Integer creditos = Integer.parseInt(creditosIngresado);
            if(nombreIngresado.isBlank())
            {
                alertInformativoCamposVacios();
                return;
            }

            Curso curso = new Curso(cod, nombreIngresado, creditos);
            try {
                cursoBsn.registrarCurso(curso);
                alertInformativo();
                limpiarCampos();
                txtCodigo.requestFocus();
            } catch (CursoYaExiste cye) {
                alertError();
                limpiarCampos();
                txtCodigo.requestFocus();
            }
            limpiarCampos();
        }catch (NumberFormatException nfe)
        {
            alertInformativoCamposVacios();
        }
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

    public void alertError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Curso Ya existe");
        alert.setContentText("ya está registrado en tu lista de cursos");
        alert.showAndWait();
    }

    public void alertInformativo()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Proceso Exitoso");
        alert.setContentText("El curso se agregó correctamente");
        alert.showAndWait();
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
    public void alertInformativoCamposVacios()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Campo(s) vacio(s)");
        alert.setContentText("Los datos codigo del curso , Nombre del curso y Creditos son Obligatorios , favor digitarlos");
        alert.showAndWait();
    }

}

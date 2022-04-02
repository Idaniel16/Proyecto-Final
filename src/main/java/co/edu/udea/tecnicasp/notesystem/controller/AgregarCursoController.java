package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.bsn.CursoBsn;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import javafx.scene.control.TextField;

public class AgregarCursoController
{
    private TextField txtCodigo;
    private TextField txtNombre;
    private TextField txtCreditos;

    private CursoBsn cursoBsn;

    public AgregarCursoController() {
        this.cursoBsn = new CursoBsn();
    }

    public void agregar_action()
    {
        String codigoIngresado = txtCodigo.getText();
        String nombreIngresado = txtNombre.getText();
        String creditosIngresado = txtCreditos.getText();

        Integer cod = Integer.parseInt(codigoIngresado);
        Integer creditos = Integer.parseInt(codigoIngresado);

        Curso curso = new Curso(cod,nombreIngresado,creditos);
    }

    public void limpiar_action() {
        this.limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCreditos.clear();



    }

}

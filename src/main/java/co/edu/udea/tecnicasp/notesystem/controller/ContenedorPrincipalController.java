package co.edu.udea.tecnicasp.notesystem.controller;

import co.edu.udea.tecnicasp.notesystem.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ContenedorPrincipalController
{
    @FXML
    private BorderPane contenedorPrincipal;

    public void mnuCerrar_action()
    {
        System.exit(0);

    }
    public void mnuAgregarNotar_action() throws IOException
    {
        AnchorPane agregarNota = FXMLLoader.load(HelloApplication.class.getResource("view/agregar-nota.fxml"));
        contenedorPrincipal.setCenter(agregarNota);


    }
    public void mnuCalculoRapido_action() throws IOException {

        AnchorPane calculoRapido = FXMLLoader.load(HelloApplication.class.getResource("view/calculo-rapido.fxml"));
        contenedorPrincipal.setCenter(calculoRapido);
    }

    public void mnuFuncion_action() throws IOException
    {
        AnchorPane funcion = FXMLLoader.load(HelloApplication.class.getResource("view/viewInformativas/descripcion-aplicacion.fxml"));
        contenedorPrincipal.setCenter(funcion);
    }
    public void mnuQuienes_action() throws IOException
    {
        AnchorPane quienes = FXMLLoader.load(HelloApplication.class.getResource("view/viewInformativas/sobre-nosotros.fxml"));
        contenedorPrincipal.setCenter(quienes);
    }


}
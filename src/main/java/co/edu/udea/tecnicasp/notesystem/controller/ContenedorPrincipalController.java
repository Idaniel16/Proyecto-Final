package co.edu.udea.tecnicasp.notesystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContenedorPrincipalController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
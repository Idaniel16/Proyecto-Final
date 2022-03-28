module co.edu.udea.tecnicasp.notesystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens co.edu.udea.tecnicasp.notesystem to javafx.fxml;
    exports co.edu.udea.tecnicasp.notesystem;
}
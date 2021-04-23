package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccueilController {

    @FXML
    private AnchorPane root;

    @FXML
    private Button boutonBarman;

    @FXML
    private Button boutonClient;

    @FXML
    void Barman(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void Client(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("interface-barman.fxml"));
        root.getChildren().setAll(pane);

    }

}

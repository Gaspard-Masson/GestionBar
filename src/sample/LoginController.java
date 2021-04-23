package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class LoginController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField textfieldUsername;

    @FXML
    private PasswordField passwordfieldPassword;

    @FXML
    private Button boutonConnecter;

    @FXML
    private Button boutonQuitter;

    @FXML
    private Label labelError;

    @FXML
    void Connecter(ActionEvent event) throws IOException {
        HashMap<String, String> usermap = new HashMap<String,String>();
        usermap.put("barman","abcd");
        ObservableMap<String,String> observablemap = FXCollections.observableMap(usermap);
        if(observablemap.containsKey(textfieldUsername.getText())&& observablemap.get(textfieldUsername.getText()).equals(passwordfieldPassword.getText()))
        {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("interface-barman.fxml"));
            root.getChildren().setAll(pane);
        }else
        {
            labelError.setText("erreur, veuillez vous connecter en client");
            textfieldUsername.setText("");
            passwordfieldPassword.setText("");
        }
    }

    @FXML
    void Quitter(ActionEvent event) {
        Stage stage =(Stage)boutonQuitter.getScene().getWindow();
        stage.close();
    }

}

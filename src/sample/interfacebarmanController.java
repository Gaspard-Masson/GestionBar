package sample;
import com.cytech.gestionFichiers.*;
import com.cytech.ingredients.Boisson;
import com.cytech.ingredients.BoissonAlcoolisee;
import com.cytech.ingredients.BoissonNonAlcoolisee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class interfacebarmanController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Boisson> tableListeBoissons;

    @FXML
    private TableColumn<Boisson, String> colNom;

    @FXML
    private TableColumn<Boisson, Float> colContenance;

    @FXML
    private TableColumn<Boisson, Double> colPrix;

    @FXML
    private TableColumn<Boisson, Integer> colStock;

    @FXML
    private TableColumn<Boisson, Float> colDegre;

    @FXML
    private TableColumn<Boisson, String> colType;

    @FXML
    private Label labelListeBoissons;

    @FXML
    private Button boutonQuitter;

    @FXML
    private TextField textfieldNom;

    @FXML
    private TextField textfieldContenance;

    @FXML
    private TextField textfieldPrix;

    @FXML
    private TextField textfieldStock;

    @FXML
    private TextField textfieldDegre;

    @FXML
    private ChoiceBox choiceboxType;

    ObservableList<String> listchoix= FXCollections.observableArrayList("BoissonAlcoolisee","BoissonNonAlcoolisee");

    @FXML
    private Button boutonAjouter;

    @FXML
    private Label labelErrorNom;

    @FXML
    private Label labelErrorContenance;

    @FXML
    private Label labelErrorPrix;

    @FXML
    private Label labelErrorStock;

    @FXML
    private Label labelErrorDegre;


    @FXML
    void Ajouter(ActionEvent event) {
        Boolean b1 = emptyTextField(textfieldNom,labelErrorNom,"attention champs vide");
        Boolean b2 = emptyTextField(textfieldContenance,labelErrorContenance,"attention champs vide");
        Boolean b3 = emptyTextField(textfieldDegre,labelErrorDegre,"attention champs vide");
        Boolean b4 = emptyTextField(textfieldPrix,labelErrorPrix,"attention champs vide");
        Boolean b5 = emptyTextField(textfieldStock,labelErrorStock,"attention champs vide");
        Boolean b6 = notNumberTextField(textfieldContenance,labelErrorContenance,"champs non numérique");
        Boolean b7 = notNumberTextField(textfieldDegre,labelErrorDegre,"champs non numérique");
        Boolean b8 = notNumberTextField(textfieldPrix,labelErrorPrix,"champs non numérique");
        Boolean b9 = notNumberTextField(textfieldStock,labelErrorStock,"champs non numérique");

        if(!b1 && !b2 && !b3 && !b4 && !b5)
        {
            // if boisson alcoolisee ou non + construire et add
            //Boisson b = new Boisson(textfieldNom.getText(), Float.parseFloat(textfieldContenance.getText()), Integer.parseInt(tfquantite.getText()));
            //tableview.getItems().add(p);
            textfieldNom.setText("");
            textfieldContenance.setText("");
            textfieldPrix.setText("");
            textfieldStock.setText("");
            textfieldDegre.setText("");

            //label error à faire :

            lberrorprix.setText("");
            lberrorquantite.setText("");
        }
    }

    @FXML
    void Quitter(ActionEvent event) {
        Stage stage = (Stage)boutonQuitter.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colContenance.setCellValueFactory(new PropertyValueFactory<>("contenance"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prixB"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colDegre.setCellValueFactory(new PropertyValueFactory<>("degre"));
        ArrayList<Boisson> LB = new ArrayList<Boisson>();
        try {
            init.chargerListeBoisson(LB);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<Boisson> list= FXCollections.observableArrayList(LB);
        tableListeBoissons.setItems(list);

        choiceboxType.setValue("BoissonNonAlcoolisee");
        choiceboxType.setItems(listchoix);


    }

    ////////////////////////////////////////////

    public boolean emptyTextField(TextField tf)
    {
        if (!emptyTextField(tf)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean emptyTextField(TextField tf, Label lberrordes2, String msgerror)
    {
        if(!emptyTextField(tf))
        {
            return false;
        }else
        {
            lberrordes2.setText(msgerror);
            return true;
        }
    }

    public boolean notNumberTextField(TextField tf)
    {
        if (tf.getText().matches("-?\\d*")||tf.getText().matches("-?\\d+\\.\\d+"))
        {
            return false;
        }
        else
            return true;

    }

    public boolean notNumberTextField (TextField tf, Label lb, String msgerror)
    {
        if (notNumberTextField (tf))
        {
            lb.setText(msgerror);
            return true;
        }

        /*else if (Float.valueOf(tf.getText())<0)
        {
        lb.setText("value must be positif");
         return true;
        }*/
        else
            return false;

    }
}
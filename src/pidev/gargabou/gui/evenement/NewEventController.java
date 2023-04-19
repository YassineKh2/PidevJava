/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class NewEventController implements Initializable {

    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private JFXButton btretourtoevenements;
    @FXML
    private JFXButton btadresse;
    @FXML
    private Button ajouterevenement;
    @FXML
    private TextField tfnomevenement;
    @FXML
    private TextField prixevenement;
    @FXML
    private TextField tfnombreparticipant;
    @FXML
    private TextField tfimageevent;
    @FXML
    private TextField typeevenement;
    @FXML
    private DatePicker tfdateevenement;
    @FXML
    private ImageView IVimage;
    @FXML
    private TextArea tfdescriptionevent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

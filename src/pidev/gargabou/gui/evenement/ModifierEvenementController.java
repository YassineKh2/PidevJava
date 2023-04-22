/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private JFXButton btretourtoevenements;
    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btadresse;
    @FXML
    private JFXButton btorganisateur;
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
    @FXML
    private Button modifierevenement;
    @FXML
    private Button importimageevent;
    @FXML
    private ComboBox<?> fxidorganisateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         btorganisateur.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../organisateur/HomeOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
               
        });
        btevenement.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
               
        });
       btadresse.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../adresse/HomeAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
               
        });
        
        
        
           btretourtoevenements.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                 System.out.println(ex.getMessage());
            }
       });
    }    
    
}

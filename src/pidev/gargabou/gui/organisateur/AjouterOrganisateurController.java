/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.organisateur;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.gui.adresse.NewAdresseController;
import pidev.gargabou.services.OrganisateurCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class AjouterOrganisateurController implements Initializable {

    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btadresse;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private Button ajouterorganisateur;
    @FXML
    private TextField fxnomorganisateur;
    @FXML
    private TextField fxnumtel;
    @FXML
    private TextField fxpourcentage;   
    @FXML
    private JFXButton btretourtoorganisateur;
    String entity="organisateur";
    int idorg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btorganisateur.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../evenement/HomeEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
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
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
               
        });
              
           btretourtoorganisateur.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                 System.out.println(ex.getMessage());
            }
       });
             ajouterorganisateur.setOnAction(event -> {
                   if (fxnomorganisateur.getText().length() < 1 || fxnomorganisateur.getText().length() > 50) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("entrer un nom valide inferieur a 50 charactere");
                alert.showAndWait();
                return;
            }
                    try{
            int numtel = Integer.parseInt(fxnumtel.getText());
              if (numtel < 0 || fxnumtel.getText().length() != 8  ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" numero Invalide");
                alert.setContentText("entrer un numero de 8 chiffre !!");
                alert.showAndWait();
                return;
                   } }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("numero Invalid !");
                alert.setContentText("entrer un numero de 8 chiffre !!");
                alert.showAndWait();
                return;
                }
                  try{   
                float pourcentage = Integer.parseInt(fxpourcentage.getText());
              if (pourcentage < 0 || pourcentage > 100) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" pourcentage Invalide");
                alert.setContentText("Le pourcentage doit etre entre 0 et 100 !!");
                alert.showAndWait();
                return;
            } }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" pourcentage Invalide !");
                alert.setContentText("Le pourcentage doit etre entre 0 et 100 !!");
                alert.showAndWait();
                return;
            }    
                    
                 try {
                 OrganisateurCRUD ocd =new OrganisateurCRUD();
                 String nomorg =fxnomorganisateur.getText();
                 int numtel= Integer.parseInt(fxnumtel.getText());
                 float pourc =Integer.parseInt(fxpourcentage.getText());
                 Organisateur O = new Organisateur(nomorg, numtel, pourc);
                 idorg=ocd.ajouterOrganisateur(O);
                 
                 
                 
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("../adresse/NewAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                NewAdresseController sendidevent =loader.getController();
                
                sendidevent.setidorg(idorg);
               sendidevent.setentity(entity);
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
                 
                 
                 
                 });
             
           
    }    
    
}

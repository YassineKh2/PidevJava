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
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.gui.adresse.ModifierAdresseController;
import pidev.gargabou.gui.adresse.NewAdresseController;
import pidev.gargabou.services.AdresseCRUD;
import pidev.gargabou.services.OrganisateurCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class ModifierOrganisateurController implements Initializable {

    @FXML
    private JFXButton btretourtoorganisateur;
    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btadresse;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private Button modifierorganisateur;
    @FXML
    private TextField fxnomorganisateur;
    @FXML
    private TextField fxnumtel;
    @FXML
    private TextField fxpourcentage;
    int idorg;
    String entity="organisateur";
    int ida;
    

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
           modifierorganisateur.setOnAction(event -> {
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
                float pourcentage = Float.parseFloat(fxpourcentage.getText());
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
                // ida=ocd.findorganisateurbyid(idorg).getIdAdresse();
                 String nomorg =fxnomorganisateur.getText();
                 int numtel= Integer.parseInt(fxnumtel.getText());
                 float pourc =Float.parseFloat(fxpourcentage.getText());
                 Organisateur O = new Organisateur(nomorg, numtel, pourc);
                 ocd.modifierorganisateur(idorg, O);
                       System.out.println(idorg);
                 
                 
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("../adresse/ModifierAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                ModifierAdresseController sendidevent =loader.getController();
                AdresseCRUD acd =new AdresseCRUD();
                Adresse A ;//= new Adresse();
                A=acd.afficherseulAdresse(ida);
                sendidevent.setnomadresse(A.getNomRue());
                 sendidevent.setnumadresse(String.valueOf(A.getNumRue()));
                 sendidevent.setcodepostal(String.valueOf(A.getCodePostal()));
                  sendidevent.setgouvernorat(A.getGouvernorat());
                sendidevent.setidadresse(ida);
                
               sendidevent.setentity(entity);
                       System.out.println(ida);
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
                  
                                 
    });
           }    
    
    public void setnomorg(String msg){
        this.fxnomorganisateur.setText(msg);
    }
    public void setnumtel(String msg){
        this.fxnumtel.setText(msg);
    }
    public void setpourc(String msg){
        this.fxpourcentage.setText(msg);               
    }
    public void setidorg(int idorg){
        this.idorg = idorg;
    }
     public void setentity(String entity){
        this.entity=entity;
    }
}

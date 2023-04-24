/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.adresse;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class ItemAdresseController implements Initializable {

   private int ida ;
    @FXML
    private Label Alnomrue;
    @FXML
    private Label ALgouvernorat;
    @FXML
    private Label Alcodepostal;
   
    @FXML
    private Label Alnumrue;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    public void afficheradresses(Adresse adresse){
             
              Alnomrue.setText(adresse.getNomRue());
              Alcodepostal.setText(String.valueOf(adresse.getCodePostal()));
              Alnumrue.setText(String.valueOf(adresse.getNumRue()));
              ALgouvernorat.setText(adresse.getGouvernorat());
               ida=adresse.getId();
                                        
    }
    @FXML
    private void supprimerAdresse(ActionEvent event) {
         try {
          System.out.println( ida);
          AdresseCRUD acd = new AdresseCRUD();
          acd.supprimerAdresse(ida);
          
          FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeAdresse.fxml"));
            Parent root = loader.load(); // load the new FXML file
            Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
            Node sourceNode = (Node) event.getSource(); // get the source node of the current event
            Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
            Stage stage = (Stage) currentScene.getWindow(); // get the current stage
            stage.setScene(scene); // set the new scene as the content of the stage
             
         } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
          
    }

    @FXML
    private void modifierAdresse(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                ModifierAdresseController Showadresse = loader.getController();
                Showadresse.setnomadresse(Alnomrue.getText());
                Showadresse.setnumadresse(Alnumrue.getText());
                Showadresse.setcodepostal(Alcodepostal.getText());
                Showadresse.setgouvernorat(ALgouvernorat.getText());
                Showadresse.setidadresse(ida);
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
               
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
    }
    
}

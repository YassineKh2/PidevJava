/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.adresse;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class ModifierAdresseController implements Initializable {

    @FXML
    private JFXButton btretourtoadresses;
    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private TextField tfnomrue;
    @FXML
    private TextField tfgouvernorat;
    @FXML
    private TextField tfnumrue;
    @FXML
    private TextField tfcodepostal;
    private int ida ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
      btretourtoadresses.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeAdresse.fxml"));
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

    @FXML
    private void ModifierAdresse(ActionEvent event) {
         try {
            
            String nomrue = tfnomrue.getText();
            int numrue =  Integer.parseInt(tfnumrue.getText());
            int codepostal =  Integer.parseInt(tfcodepostal.getText());
            String gouvernorat =tfgouvernorat.getText();
            Adresse A =new Adresse(nomrue, numrue, codepostal, gouvernorat);
            AdresseCRUD acd = new AdresseCRUD();
            acd.modifierAdresse(ida, A);
           
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    
    public void setnomadresse (String msg){
       this.tfnomrue.setText(msg);
    }
    public void setnumadresse(String msg){
        this.tfnumrue.setText(msg);
    }
    public void setcodepostal(String msg){
        this.tfcodepostal.setText(msg);
    }
    public void setgouvernorat(String msg){
        this.tfgouvernorat.setText(msg);
    }
    public void setidadresse(int id){
        this.ida= id;
    }
}

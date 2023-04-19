/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.adresse;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class HomeAdresseController implements Initializable {

    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btajouteradresse;
    @FXML
    private JFXButton btretour;
    @FXML
    private GridPane gridcontainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btevenement.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorie.fxml"));
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
        btorganisateur.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorie.fxml"));
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
        btajouteradresse.setOnAction( event -> {
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NewAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content               
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node                
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
               
                stage.setScene(scene); // set the new scene as the content of the stage
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
               
        });
        btretour.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Home.fxml"));
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
         refreshNodes();
    }    
private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        AdresseCRUD acd = new AdresseCRUD();
        
        ArrayList<Adresse> Adresses = (ArrayList) acd.afficherAdresse();
        
        System.out.println();
        Node [] nodes = new  Node[Adresses.size()];
        
        for(int i = 0; i<Adresses.size(); i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemAdresse.fxml"));
                Node node = (Node) loader.load();
                ItemAdresseController controller = loader.getController();
                controller.afficheradresses(Adresses.get(i));
                
               pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           
        }  
    }

    
}

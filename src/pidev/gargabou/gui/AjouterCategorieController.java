/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private TextField fxNomCateogrie;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private ImageView fxImageCategorie;
    @FXML
    private JFXButton fxAjouterCategorieButton;
    @FXML
    private JFXButton fxAnunulerAjouteCategorieButton;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fxAjouterCategorieButton.setOnAction( event -> {
           try {
               String nom = fxNomCateogrie.getText();
               ServiceCategorie sp = new ServiceCategorie();
               Categorie Categ = new Categorie(nom,"test");
               sp.ajouter(Categ);
               
               FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
    private void handleButtonAction(MouseEvent event) {
    }
    
}

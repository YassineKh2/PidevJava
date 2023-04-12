/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
public class ModiferCategorieController implements Initializable {

    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label lbl_completed;
    @FXML
    private TextField fxNomCateogrie;
    @FXML
    private Button fxModiferCategorieButton;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private ImageView fxImageCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxModiferCategorieButton.setOnAction( event -> {
            
            try {
                String NomCateg = fxNomCateogrie.getText();
                String id = fxIdCategorie.getText();
                int IdCateg = Integer.parseInt(id);
                ServiceCategorie sp = new ServiceCategorie();
                Categorie Categ = sp.FindOne(IdCateg);
                Categorie NewCateg = new Categorie(IdCateg,NomCateg,Categ.getImageCategorie(),Categ.getArticles());
                sp.modifier(NewCateg);
                
                
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
    
    public void setNomCategorie(String message){
        this.fxNomCateogrie.setText(message);
    }
    public void setIdCategorie(String message){
        this.fxIdCategorie.setText(message);
    }
    public void setImageCategorie(Image img){
        this.fxImageCategorie.setImage(img);
    }
}

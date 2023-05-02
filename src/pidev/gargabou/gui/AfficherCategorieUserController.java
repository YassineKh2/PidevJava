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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.gargabou.entites.Categorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AfficherCategorieUserController implements Initializable {

    @FXML
    private JFXButton fxsShowArticleButton;
    @FXML
    private ImageView fxImageCateg;
    @FXML
    private Label fxIdCateg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxsShowArticleButton.setOnAction( event -> {
            try {
                
            int idc = Integer.parseInt(fxIdCateg.getText());
            Categorie.setIdc(idc);    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeArticleUser.fxml"));
            Parent root = loader.load(); // load the new FXML file
            ArticleHomeControllerUser controller = loader.getController();
            
            controller.setIdCateg(fxsShowArticleButton.getText());
            controller.refreshNodes();
            
            
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
    public void setCategorie(Categorie categ){

        Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+categ.getImageCategorie(), true);
        
        fxsShowArticleButton.setText(categ.getNomCategorie());
        fxImageCateg.setImage(img);
        fxIdCateg.setText(Integer.toString(categ.getId()));
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;
import pidev.gargabou.utils.DataSource;
import sun.security.krb5.Config;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class CategorieItemController implements Initializable {

    @FXML
    private Label fxNomCategorie;
    @FXML
    private Label fxNombreArticleCateogire;
    @FXML
    private ImageView fxImageCateogire;
    @FXML
    private Label fxCategorieId;
    @FXML
    private JFXButton fxSupprimerCategorie;
    @FXML
    private JFXButton fxModiferCategorie;
    @FXML
    private Label fxPathImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxModiferCategorie.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModiferCategorie.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                ModiferCategorieController ShowCateg = loader.getController();
                ShowCateg.setNomCategorie(fxNomCategorie.getText());
                ShowCateg.setIdCategorie(fxCategorieId.getText());
                ShowCateg.setImageCategorie(fxImageCateogire.getImage());
                ShowCateg.setImagePath(fxPathImage.getText());
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
        
        fxNomCategorie.setText(categ.getNomCategorie());
        String nArticle = "0";
        if(categ.getArticles() != null){
        int nbArticle = categ.getArticles().size();
        nArticle = Integer.toString(nbArticle);
        }
        fxImageCateogire.setImage(img);
        fxNombreArticleCateogire.setText(nArticle);
        int idCateg = categ.getId();
        String idC= Integer.toString(idCateg);
        fxCategorieId.setText(idC);
        fxPathImage.setText(categ.getImageCategorie());
    }

    @FXML
    private void fxSupprimerCategorie(ActionEvent event) {
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
        if (choice == JOptionPane.YES_OPTION) {
              try {
            String idC = fxCategorieId.getText();
            int idCateg  = Integer.parseInt(idC);
            System.out.println(idCateg);
            ServiceCategorie Sc = new ServiceCategorie();
            Sc.supprimer(idCateg);
            
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
        } else if (choice == JOptionPane.NO_OPTION) {
            System.out.println("User clicked No button");
        }
      

    }
   
    
    
}

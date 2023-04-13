/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.services.ServiceArticles;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleItemController implements Initializable {

    @FXML
    private Label fxNomArticle;
    @FXML
    private Label fxQuantiteArticle;
    @FXML
    private Label fxRemiseArticle;
    @FXML
    private Label fxDiscriptionArticle;
    @FXML
    private ImageView fxImageArticle;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private Label fxArticleId;
    @FXML
    private JFXButton fxSupprimerArticle;
    @FXML
    private JFXButton fxModiferArticle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

   public void setArticle(Article article){
       
       
       
        Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+article.getImageArticle(), true);
        
        fxNomArticle.setText(article.getNomArticle());
        fxDiscriptionArticle.setText(article.getArticleDiscription());
        fxImageArticle.setImage(img);
        int quantite = article.getQuantiteArticle();
        String QuantiteArticle = Integer.toString(quantite);
        fxQuantiteArticle.setText(QuantiteArticle);
        float remise = article.getRemisePourcentageArticle();
        String remiseArticle = Float.toString(remise);
        fxRemiseArticle.setText(remiseArticle);
        int idArticle = article.getId();
        String idA= Integer.toString(idArticle);
        fxArticleId.setText(idA);
       
   }

    @FXML
    private void fxSupprimerArticle(ActionEvent event) {
        
        try {
            String idA = fxArticleId.getText();
            int idArticle  = Integer.parseInt(idA);
            System.out.println(idArticle);
            ServiceArticles Sa = new ServiceArticles();
            Sa.supprimer(idArticle);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeArticle.fxml"));
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

    @FXML
    private void fxModiferArticle(ActionEvent event) {
           try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModiferCategorie.fxml"));
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
}

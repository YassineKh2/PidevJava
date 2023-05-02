/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Payment;
import pidev.gargabou.services.ServiceArticles;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleItemControllerUserPannier implements Initializable {

    @FXML
    private Label fxNomArticle;
    @FXML
    private Label fxQuantiteArticle;
    @FXML
    private Label fxDiscriptionArticle;
    @FXML
    private ImageView fxImageArticle;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private Label fxArticleId;
    @FXML
    private Label fxPrixArticle;
    @FXML
    private Label fxPathImageArticle;
    @FXML
    private Button fxPlusQuantity;
    @FXML
    private Button fxMinusQuantiy;
    @FXML
    private Button fxDeleteArticleFromPannierButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxDeleteArticleFromPannierButton.setOnAction( event ->{
            try {
                ArrayList<Article> Articles = Payment.getPannier();
                ArrayList<Integer> Quantite = Payment.getQuntite();
                
                ServiceArticles Sa = new ServiceArticles();
                int ida = Integer.parseInt(fxArticleId.getText());
                Article Arc = Sa.findArticleById(ida);
                
                int index = Articles.indexOf(Arc);
                Articles.remove(Arc);
                Quantite.remove(index);
                
                Payment.setPannier(Articles);
                Payment.setQuntite(Quantite);
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePannier.fxml"));
                Parent root = loader.load(); // load the new FXML file
                PannierHomeController controller = loader.getController();
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
    public void setArticle(Article article,int Quantite){
       
       
       
        Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+article.getImageArticle(), true);
        
        fxNomArticle.setText(article.getNomArticle());
        fxDiscriptionArticle.setText(article.getArticleDiscription());
        fxImageArticle.setImage(img);
        String QuantiteArticle = Integer.toString(Quantite);
        fxQuantiteArticle.setText(QuantiteArticle);
        int idArticle = article.getId();
        String idA= Integer.toString(idArticle);
        fxArticleId.setText(idA);
        float prix = article.getPrixArticle();
        prix = prix * Quantite;
        float discount = (prix * article.getRemisePourcentageArticle()) / 100;
        prix = prix - discount;
        String prixArticle = Float.toString(prix);
        fxPrixArticle.setText(prixArticle);
   }
}

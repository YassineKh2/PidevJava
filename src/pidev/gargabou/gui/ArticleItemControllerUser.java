/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pidev.gargabou.entites.Article;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleItemControllerUser implements Initializable {

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
    private Label fxPrixArticle;
    @FXML
    private Label fxPathImageArticle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        float prix = article.getPrixArticle();
        String prixArticle = Float.toString(prix);
        fxPrixArticle.setText(prixArticle);
   }
}

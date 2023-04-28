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
import javafx.scene.control.Alert;
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
public class ArticleItemControllerUser implements Initializable {

    @FXML
    private JFXButton fxNomArticle;
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
    @FXML
    private JFXButton fxAjouterAuPannier;
    @FXML
    private Label fxQuantiteSelected;
    @FXML
    private Button fxplusButton;
    @FXML
    private Button fxMinusButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fxAjouterAuPannier.setOnAction(event -> {
            ArrayList<Article> pan = Payment.getPannier();
            ArrayList<Integer> Quantite = Payment.getQuntite();
//            System.out.println(pan);
            ServiceArticles Sa = new ServiceArticles();
            int idA = Integer.parseInt(fxArticleId.getText());
            Article Arc = Sa.findArticleById(idA);
            pan.add(Arc);
            Payment.setPannier(pan);
            String quantite = fxQuantiteSelected.getText();
            int quantiteA = Integer.parseInt(quantite);
            Quantite.add(quantiteA);
            Payment.setQuntite(Quantite);

            System.out.println(Payment.getPannier());
            System.out.println(Payment.getQuntite());
        });
        fxQuantiteSelected.setText("1");
        fxplusButton.setOnAction(event -> {
            String quantite = fxQuantiteSelected.getText();
            int quantiteA = Integer.parseInt(quantite);
            quantiteA++;
            quantite = Integer.toString(quantiteA);
            fxQuantiteSelected.setText(quantite);
        });
        fxMinusButton.setOnAction(event -> {
            String quantite = fxQuantiteSelected.getText();
            int quantiteA = Integer.parseInt(quantite);
            if (quantiteA < 2) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("La quantite doit etre positive");
                alert.showAndWait();
                return;
            }
            quantiteA--;
            quantite = Integer.toString(quantiteA);
            fxQuantiteSelected.setText(quantite);
        });

        fxNomArticle.setOnAction(event -> {
            try {
                int arc = Integer.parseInt(fxArticleId.getText());
                Article.setIdArc(arc);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeArticleDetails.fxml"));
                Parent root = loader.load(); // load the new FXML file
                ArticleDetailsHomeController controller = loader.getController();
                
                controller.setDiscriptionArticle(fxDiscriptionArticle.getText());
                controller.setImageArticle(fxImageArticle.getImage());
                controller.setNomArticle(fxNomArticle.getText());
                controller.setRemiseArticle(fxRemiseArticle.getText());
                
               
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

    public void setArticle(Article article) {

        Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/" + article.getImageArticle(), true);

        fxNomArticle.setText(article.getNomArticle());
        fxDiscriptionArticle.setText(article.getArticleDiscription());
        fxImageArticle.setImage(img);
        float remise = article.getRemisePourcentageArticle();
        if (remise != 0f) {
            String remiseArticle = Float.toString(remise);
            fxRemiseArticle.setText(remiseArticle + "%");
        }
        int idArticle = article.getId();
        String idA = Integer.toString(idArticle);
        fxArticleId.setText(idA);
        float prix = article.getPrixArticle();
        String prixArticle = Float.toString(prix);
        fxPrixArticle.setText(prixArticle);
    }
}

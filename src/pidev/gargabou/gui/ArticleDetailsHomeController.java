/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Rating;
import pidev.gargabou.services.ServiceArticles;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleDetailsHomeController implements Initializable {

    @FXML
    private ImageView fxImageArticleDetails;
    @FXML
    private Label fxNomArticleDetails;
    @FXML
    private Label fxPrixArticleDetails;
    @FXML
    private Label fxRemiseArticleDetails;
    @FXML
    private JFXTextArea fxArticleDiscriptionDetails;
    @FXML
    private VBox pnl_scrollDetails;
    @FXML
    private JFXButton fxGoToCateogrieDetails;
    @FXML
    private Label fxidarc;
    @FXML
    private JFXButton fxAjouterAvis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxGoToCateogrieDetails.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeCategorieUser.fxml"));
                Parent root = loader.load(); // load the new FXML file
                CategorieHomeUserController controller = loader.getController();
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        fxAjouterAvis.setOnAction( event -> {
             try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeReview.fxml"));
                Parent root = loader.load(); // load the new FXML file
                ReviewHomeController controller = loader.getController();
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
        pnl_scrollDetails.getChildren().clear();
        ServiceArticles Sa = new ServiceArticles();
       
        int ida = Article.getIdArc();
        Article Arc = Sa.findArticleById(ida);
        System.out.println(Arc);
        
        ArrayList<Rating> Ratings = Arc.getRatingArticleTab();
        
        System.out.println();
        Node [] nodes = new  Node[Ratings.size()];
        
        for(int i = 0; i<Ratings.size(); i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ReviewItem.fxml"));
                Node node = (Node) loader.load();
                ReviewItemController controller = loader.getController();
                controller.setReview(Ratings.get(i));
                
               pnl_scrollDetails.getChildren().add(node);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           
        }  
    }

    public void setNomArticle(String message) {
        fxNomArticleDetails.setText(message);
    }

    public void setPrixArticle(String message) {
        fxPrixArticleDetails.setText(message);
    }

    public void setDiscriptionArticle(String message) {
        fxArticleDiscriptionDetails.setText(message);
    }

    public void setRemiseArticle(String message) {
        fxRemiseArticleDetails.setText(message);
    }

    public void setImageArticle(Image message) {
        fxImageArticleDetails.setImage(message);
    }
    public void setida(String message){
        fxidarc.setText(message);
    }
    
}

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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceArticles;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleHomeControllerUser implements Initializable {

    @FXML
    private JFXButton fxAjouterArticle;
    @FXML
    private GridPane pnl_scroll;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private JFXButton fxRetourCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshNodes();
        fxRetourCategorie.setOnAction( event ->{
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
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    public void refreshNodes() {

        // System.out.println(fxIdCategorie.getText());
        String nameC = fxIdCategorie.getText();

      
        ServiceCategorie Sc = new ServiceCategorie();
        int idc = Categorie.getIdc();
        Categorie categ = Sc.FindOne(idc);
       
       
        pnl_scroll.getChildren().clear();
        ServiceArticles Sa = new ServiceArticles();

        ArrayList<Article> Articles = categ.getArticles();
      
       
        
   
        int column=1;
        int row=1; 

       // Node[] nodes = new Node[Articles.size()];

        for (int i = 0; i < Articles.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleItemUser.fxml"));
                Node node = (Node) loader.load();
                ArticleItemControllerUser controller = loader.getController();
                controller.setArticle(Articles.get(i));
                if(column == 3){
                  column = 1;
                  ++row;
                }
                pnl_scroll.add(node, ++column, row);
                 GridPane.setMargin(node,new Insets(10));
                //pnl_scroll.getChildren().add(node);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public int getCateg(){
        
        
        return 0;
        
    }
    public void setIdCateg(String mesasge) {
        fxIdCategorie.setText(mesasge);
    }

}

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
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
    private VBox pnl_scroll;
    @FXML
    private JFXButton fxGoToCateogrie;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label fxIdCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshNodes();
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
    
    private void refreshNodes()
    {
//        int idcateg = Integer.parseInt(fxIdCategorie.getText());
//        ServiceCategorie Sc = new ServiceCategorie();
//        Categorie categ = Sc.FindOne(idcateg);
        
        pnl_scroll.getChildren().clear();
        ServiceArticles Sa = new ServiceArticles();
        
        ArrayList<Article> Articles = (ArrayList<Article>) Sa.getAll();
        
        
        
        Node [] nodes = new  Node[Articles.size()];
        
        for(int i = 0; i<Articles.size(); i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleItemUser.fxml"));
                Node node = (Node) loader.load();
                ArticleItemControllerUser controller = loader.getController();
                controller.setArticle(Articles.get(i));
                
               pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           
        }  
    }
   
    public void setIdCateg(String mesasge){
        fxIdCategorie.setText(mesasge);
    }
    
}

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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class CategorieHomeUserController implements Initializable {

    @FXML
    private JFXButton fxAjouterCategorie;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton fxGoToArticle;

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
        pnl_scroll.getChildren().clear();
        ServiceCategorie Sc = new ServiceCategorie();
        
        ArrayList<Categorie> Categories = (ArrayList) Sc.getAll();
        
        System.out.println();
        Node [] nodes = new  Node[Categories.size()];
        
        for(int i = 0; i<Categories.size(); i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorieUserItem.fxml"));
                Node node = (Node) loader.load();
                AfficherCategorieUserController controller = loader.getController();
                controller.setCategorie(Categories.get(i));
                
               pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           
        }  
    }
}

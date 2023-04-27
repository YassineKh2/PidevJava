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
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class CategorieHomeUserController implements Initializable {

    @FXML
    private GridPane pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton fxGoToArticle;
    @FXML
    private JFXButton fxGoToPannier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxGoToPannier.setOnAction( event -> {
            try {
                
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePannier.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        
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
        //Node [] nodes = new  Node[Categories.size()];
        
        int column=1;
        int row=1;
    
        for(int i = 0; i<Categories.size(); i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorieUserItem.fxml"));
                Node node = (Node) loader.load();
                AfficherCategorieUserController controller = loader.getController();
                controller.setCategorie(Categories.get(i));
                if(column == 3){
                  column = 1;
                  ++row;
                }
                pnl_scroll.add(node, ++column, row);
                 GridPane.setMargin(node,new Insets(10));
                 
             //  pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           
        }  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.gui.adresse.ItemAdresseController;
import pidev.gargabou.services.AdresseCRUD;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    
      @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label lbl_completed;
    @FXML
    private GridPane gridcontainer;
    
    private List<Adresse> adresses;
    AdresseCRUD acd = new AdresseCRUD();
    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btadresse;
    @FXML
    private JFXButton btorganisateur;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btadresse.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adresse/HomeAdresse.fxml"));
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
        
    }    
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
               pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
    }
    
//    @FXML
//    private void ajoutAdresse(){
//        pnl_scroll.getChildren().clear();
//        try {
//            Node[] nodes = new Node[1] ;
//            nodes[0] = (Node)FXMLLoader.load(getClass().getResource("NewAdresse.fxml"));
//             pnl_scroll.getChildren().add(nodes[0]);
//        } catch (IOException ex) {
//            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        } 
        
//     private void AfficherAdresse(){
//    
//        pnl_scroll.getChildren().clear();
//        List<Adresse> adresses =acd.afficherAdresse();
//         Node[] nodes = new Node[adresses.size()] ;
//         try {
//         for (int i = 0; i < adresses.size(); i++) {
//             Adresse adresse = adresses.get(i);  
//            
//      
//             FXMLLoader fxmlLoader=new FXMLLoader(); 
//             fxmlLoader.setLocation(getClass().getResource("AfficherAdresse.fxml"));              
//             VBox adresseBox = fxmlLoader.load();
//     
//             ItemAdresseController afficheradressecontroller = fxmlLoader.getController();
//             afficheradressecontroller.afficheradresses(adresse);
//             gridcontainer.add(adresseBox, 0, i);
//             GridPane.setMargin(adresseBox, new Insets(20));
//         }
//        
//         } catch (IOException ex) {
//             System.out.println(ex.getMessage());      
//         }
//        
        
        
//        Node [] nodes = new  Node[1];
//        
//        for(int i = 0; i<10; i++)
//        {
//            try {
//                nodes[0] = (Node)FXMLLoader.load(getClass().getResource("../gui/AfficherAdresse.fxml"));
//               pnl_scroll.getChildren().add(nodes[0]);
//                
//            } catch (IOException ex) {
//                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
//        }  
//    }

    @FXML
    private void ajoutAdresse(ActionEvent event) {
    }
     
    
}

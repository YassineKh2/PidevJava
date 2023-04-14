/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.dashboard;

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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.gui.AfficherAdresseController;
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
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
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
    
    @FXML
    private void ajoutAdresse(){
        pnl_scroll.getChildren().clear();
        try {
            Node[] nodes = new Node[1] ;
            nodes[0] = (Node)FXMLLoader.load(getClass().getResource("../gui/NewAdresse.fxml"));
             pnl_scroll.getChildren().add(nodes[0]);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
        
      @FXML
     private void AfficherAdresse()
    {
        pnl_scroll.getChildren().clear();
        List<Adresse> adresses =acd.afficherAdresse();
         Node[] nodes = new Node[adresses.size()] ;
         try {
         for (int i = 0; i < adresses.size(); i++) {
             Adresse adresse = adresses.get(i);  
            
        System.out.println(adresse);
             FXMLLoader fxmlLoader=new FXMLLoader(); 
             fxmlLoader.setLocation(getClass().getResource("../gui/AfficherAdresse.fxml"));              
             VBox adresseBox = fxmlLoader.load();
      //  System.out.println(adresse);
             AfficherAdresseController afficheradressecontroller = fxmlLoader.getController();
             afficheradressecontroller.afficheradresses(adresse);
             gridcontainer.add(adresseBox, 0, i);
             GridPane.setMargin(adresseBox, new Insets(20));
         }
        
         } catch (IOException ex) {
             System.out.println(ex.getMessage());      
         }
        
        
        
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
    }
    
}

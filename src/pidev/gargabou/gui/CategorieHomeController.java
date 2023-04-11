package pidev.gargabou.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;

/**
 *
 * @author oXCToo
 */
public class CategorieHomeController implements Initializable {
    
    @FXML
    private Label label;
    
      @FXML
    private VBox pnl_scroll;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         refreshNodes();
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CategorieItem.fxml"));
                Node node = (Node) loader.load();
                CategorieItemController controller = loader.getController();
                controller.setCategorie(Categories.get(i));
                
               pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(CategorieHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
    }
    
}

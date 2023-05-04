/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import pidev.gargabou.entites.Publication;
import pidev.gargabou.services.PublicationService;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AdminAllPubsController implements Initializable {

    @FXML
    private VBox pnl_scroll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            refreshNodes();
        } catch (SQLException ex) {
            Logger.getLogger(IAPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void refreshNodes() throws SQLException {
        pnl_scroll.getChildren().clear();
        PublicationService ps = new PublicationService();
        
        
        ArrayList<Publication> publication = (ArrayList<Publication>) ps.recuperer();

        Node[] nodes = new Node[publication.size()];

        for (int i = 0; i < publication.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPubItem.fxml"));
                Node node = (Node) loader.load();
                AdminPubItemController controller = loader.getController();
                controller.setPublication(publication.get(i));
                pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(IAPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
}

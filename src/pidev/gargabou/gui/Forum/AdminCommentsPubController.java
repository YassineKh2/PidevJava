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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pidev.gargabou.entites.CommantairePublication;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AdminCommentsPubController implements Initializable {

    @FXML
    private Label fxIdPub;
    @FXML
    private VBox pnl_scroll;
ArrayList<CommantairePublication> commentaires;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    private void refreshNodes() throws SQLException {
    try {
//            int id = Integer.parseInt(fxIdPub.getText());
//            //System.out.println(id);
            pnl_scroll.getChildren().clear();

            System.out.println("heyy!!!");
            //CommantaireService ps = new CommantaireService();
            // PublicationItemController item = PublicationItemController.getInstance();
            // System.out.println(Integer.parseInt(item.getId()));
            //List<CommantairePublication> commentaires = ps.recupererParpublication(id);
          //  Node[] nodes = new Node[commentaires.size()];
            for (int i = 0; i < commentaires.size(); i++) {
               
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentaireItem.fxml"));
               Node node = (Node) loader.load();
                CommentaireItemController controller = loader.getController();
                controller.setCommentaire(commentaires.get(i));
                pnl_scroll.getChildren().add(node);
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//        try {
//            int id = Integer.parseInt(fxIdPub.getText());
//            System.out.println(id);
//            pnl_scroll.getChildren().clear();
//
//            System.out.println("heyy!!!");
//            CommantaireService ps = new CommantaireService();
//            // PublicationItemController item = PublicationItemController.getInstance();
//            // System.out.println(Integer.parseInt(item.getId()));
//            List<CommantairePublication> commentaires = ps.recupererParpublication(id);
//            Node[] nodes = new Node[commentaires.size()];
//            for (int i = 0; i < commentaires.size(); i++) {
//
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentaireItem.fxml"));
//                Node node = (Node) loader.load();
//                CommentaireItemController controller = loader.getController();
//                controller.setCommentaire(commentaires.get(i));
//                pnl_scroll.getChildren().add(node);
//                
//                refresh();
//                
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
   }
    public void setListComments(ArrayList commentaires) {
        this.commentaires = commentaires;
        System.out.println("setted");
    }

    @FXML
    private void refresh(ActionEvent event) throws SQLException {
        refreshNodes();
    }
    
}

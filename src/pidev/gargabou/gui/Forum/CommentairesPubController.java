/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import pidev.gargabou.entites.CommantairePublication;
import pidev.gargabou.entites.Publication;

import pidev.gargabou.services.CommantaireService;
import pidev.gargabou.services.PublicationService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class CommentairesPubController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label fxIdPub;
    ArrayList<CommantairePublication> commentaires;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println(commentaires);
        
//        System.out.println();
//
//        try {
//            // TODO
//
//            refreshNodes();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
        
//        System.out.println();
//
//        try {
//            // TODO
//             
//            refreshNodes();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
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
    private void refresh() throws SQLException {
        refreshNodes();
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
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

}

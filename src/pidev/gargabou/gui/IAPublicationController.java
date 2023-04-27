/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import pidev.gargabou.entities.Publication;
import pidev.gargabou.services.PublicationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class IAPublicationController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btnAjouterPubForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        btnAjouterPubForm.setOnAction( event -> {
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPublication.fxml"));
//                Parent root = loader.load(); // load the new FXML file
//                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
//                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
//                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
//                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
//                stage.setScene(scene); // set the new scene as the content of the stage
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//               
//        });
        try {
            // TODO
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PublicationItem.fxml"));
                Node node = (Node) loader.load();
                PublicationItemController controller = loader.getController();
                controller.setPublication(publication.get(i));
                pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(IAPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

//    @FXML
//    private void addPublication(ActionEvent event) {
//        try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPublication.fxml"));
//                Parent root = loader.load(); // load the new FXML file
//                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
//                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
//                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
//                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
//                stage.setScene(scene); // set the new scene as the content of the stage
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//    }

    @FXML
    private void redirectToAddPub(ActionEvent event) {
       
        
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPublication.fxml"));
        Parent root = loader.load();
        Dialog dialog = new Dialog();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.getDialogPane().setContent(root);
        
        dialog.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }
    

}

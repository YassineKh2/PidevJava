/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import pidev.gargabou.entities.CommantairePublication;
import pidev.gargabou.entities.Publication;
import pidev.gargabou.services.CommantaireService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AddCommentaireController implements Initializable {

    @FXML
    private JFXTextArea taContenuComment;
    @FXML
    private Label fxIdPub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addComment(ActionEvent event) throws SQLException {
        try {
                CommantaireService cs = new CommantaireService();
                if (taContenuComment.getText().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Champ vide");
                            alert.setHeaderText("Vous pouvez pas publier un commentaire vide!");
                            alert.showAndWait();
                }
                String contenuComent = taContenuComment.getText();
                Date dateComent = new Date();
                int id = Integer.parseInt(fxIdPub.getText());
                CommantairePublication comment = new CommantairePublication(id,dateComent,contenuComent,2);
                cs.ajouter(comment);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("IAPublication.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    public void setIdPublication(String message) {
        this.fxIdPub.setText(message);
    }
    
}

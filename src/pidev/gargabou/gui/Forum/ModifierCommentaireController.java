/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import com.jfoenix.controls.JFXTextArea;
import pidev.gargabou.entites.CommantairePublication;
import pidev.gargabou.services.CommantaireService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
public class ModifierCommentaireController implements Initializable {

    @FXML
    private JFXTextArea taContenuComment;
    @FXML
    private Label fxComentId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierComment(ActionEvent event) throws SQLException {
        try {
                if(taContenuComment.getText().isEmpty()){
                    
                Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Champ vide");
                            alert.setHeaderText("Vous pouvez pas publier un commentaire vide!");
                            alert.showAndWait();
                 }
                else{
                String contenuPub = taContenuComment.getText();

                int id = Integer.parseInt(fxComentId.getText());
                CommantaireService cs = new CommantaireService();
                CommantairePublication newComent = new CommantairePublication( contenuPub,  id);
                cs.modifier(newComent);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentairesPub.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("confirm");
                            alert.setHeaderText("modifie");
                            alert.showAndWait();
                
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    public void setContenuCommentaire(String message) {
        this.taContenuComment.setText(message);
    }

    public void setIdCommentaire(String message) {
        this.fxComentId.setText(message);
    }
    
}

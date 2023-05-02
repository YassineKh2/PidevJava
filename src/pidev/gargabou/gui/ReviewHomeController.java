/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Rating;
import pidev.gargabou.services.ServiceRating;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ReviewHomeController implements Initializable {

    @FXML
    private JFXButton fxGoToCateogrieDetails;
    @FXML
    private TextField fxNoteReview;
    @FXML
    private JFXTextArea fxCommantaireReview;
    @FXML
    private Button fxAddReviewButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxAddReviewButton.setOnAction(event -> {
        try {
            int Quantite = Integer.parseInt(fxNoteReview.getText());
            if (Quantite < 0 && Quantite > 5) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("La note doit etre entre 0 et 5!!");
                alert.showAndWait();
                return;
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" Invalid !");
            alert.setContentText("La Quantite est invalide !!");
            alert.showAndWait();
            return;
        }
        if ("".equals(fxCommantaireReview.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" Invalid Length");
            alert.setContentText("Le commataire est obligatoire");
            alert.showAndWait();
            return;
        }
            ServiceRating Sr = new ServiceRating();
            int note = Integer.parseInt(fxNoteReview.getText());
            String comment = fxCommantaireReview.getText();
            LocalDate currentDate = LocalDate.now();
            Date date = java.sql.Date.valueOf(currentDate);
            int idArc = Article.getIdArc();

            Rating rate = new Rating(note, comment, idArc, date, 2);
            Sr.ajouter(rate);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeCategorieUser.fxml"));
                Parent root = loader.load(); // load the new FXML file
                CategorieHomeUserController controller = loader.getController();
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
}

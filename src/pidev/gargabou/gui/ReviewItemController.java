/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pidev.gargabou.entites.Rating;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ReviewItemController implements Initializable {

    @FXML
    private Label fxIdReviewRating;
    @FXML
    private Label fxArticleIdRating;
    @FXML
    private Label fxRating;
    @FXML
    private JFXTextArea fxDiscriptionArticleReview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setReview(Rating Rating) {

        String idA= Integer.toString(Rating.getIdArticle());
        fxArticleIdRating.setText(idA);
        fxDiscriptionArticleReview.setText(Rating.getComment());
        String rating = Integer.toString(Rating.getStars());
        fxRating.setText(rating);
        String idR = Integer.toString(Rating.getId());
        fxIdReviewRating.setText(idR);
        
    }
    
}

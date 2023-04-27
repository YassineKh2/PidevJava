/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleDetailsHomeController implements Initializable {

    @FXML
    private JFXButton fxAjouterArticle;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton fxGoToCateogrie;
    @FXML
    private Label lbl_pending;
    @FXML
    private ImageView fxImageArticle;
    @FXML
    private Label fxNomArticle;
    @FXML
    private Label fxPrixArticle;
    @FXML
    private Label fxRemiseArticle;
    @FXML
    private JFXTextArea fxArticleDiscription;
    @FXML
    private Label fxIdArticle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
    
    public void setNomArticle(String message){
        fxNomArticle.setText(message);
    }
    public void setPrixArticle(String message){
        fxPrixArticle.setText(message);
    }
    public void setDiscriptionArticle(String message){
        fxArticleDiscription.setText(message);
    }
    public void setIdArticle(String message){
        fxIdArticle.setText(message);
    }
    public void setRemiseArticle(String message){
        fxRemiseArticle.setText(message);
    }
    public void setImageArticle(Image message){
        fxImageArticle.setImage(message);
    }
    
}

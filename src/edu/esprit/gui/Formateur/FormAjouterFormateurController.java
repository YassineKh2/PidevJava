/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui.Formateur;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormAjouterFormateurController implements Initializable {

    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private TextField tx_nom_formateur;
    @FXML
    private JFXButton btn_ajout_formateur;
    @FXML
    private TextField tx_image_fm;
    @FXML
    private TextField tx_pn_formateur;
    @FXML
    private JFXTextArea tx_email;
    @FXML
    private JFXRadioButton tx_male;
    @FXML
    private JFXRadioButton tx_female;
    @FXML
    private JFXTextArea tx_num;
    @FXML
    private Label label_error;
    @FXML
    private Label ct_num;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServicesFormateur sfm = new ServicesFormateur();
        
        
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        
        tx_num.setOnKeyTyped(ec->{
                if(ec.getCharacter().matches("[a-zA-Z]")){
                    
                    ec.consume();
                    ct_num.getStyleClass().add("error");
                    ct_num.setText("veiller entrer des nombres");
                    
                    
                    
                }
            });    
        

        btn_ajout_formateur.setOnMouseClicked(e ->{
            
            String nom = tx_nom_formateur.getText();
            String img= tx_image_fm.getText();
            String prenom = tx_pn_formateur.getText();
            String email =tx_email.getText();
            int num=Integer.parseInt(tx_num.getText());
            String sexe = null;
            
            if (tx_male.isSelected()) {
                    sexe = tx_male.getText();
                    
                    // Do something with the selected value...
                };
            
            if (tx_female.isSelected()) {
                    sexe = tx_female.getText();
            }
            check_fields();
            
            Formateur f_aj = new Formateur(nom, prenom, sexe, email, num, img);
                    sfm.ajouter(f_aj);
                    Label conf=new Label();
                    conf.setText("Formateur bien ajouté");
                    conf.setLayoutX(174);
                    conf.setLayoutY(609);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);
                });
    }
        public void check_fields(){
            String nom = tx_nom_formateur.getText();
            String img= tx_image_fm.getText();
            String prenom = tx_pn_formateur.getText();
            String email =tx_email.getText();
            int num=Integer.parseInt(tx_num.getText());
            String sexe = null;
            
            if (tx_male.isSelected()) {
                    sexe = tx_male.getText();
                    
                    // Do something with the selected value...
                };
            
            if (tx_female.isSelected()) {
                    sexe = tx_female.getText();
            }
        
        if(nom.isEmpty()|| img.isEmpty() || prenom.isEmpty()|| email.isEmpty()  || (!tx_male.isSelected() && !tx_female.isSelected())){
            
            label_error.setText("tous les champs sont obligatoires");
            
            /*KeyFrame kf = new KeyFrame(javafx.util.Duration.seconds(5));
            Timeline timeline = new Timeline(kf);
            timeline.setCycleCount(1);
            
            timeline.setOnFinished(event -> {
                label_error.setVisible(false);
            });
            timeline.play();*/
            
            whole_form_scene.getChildren().add(label_error);
            
            
        }
        
        
        
       
    }    
    
}

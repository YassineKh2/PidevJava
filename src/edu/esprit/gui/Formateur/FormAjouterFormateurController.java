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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    @FXML
    private Label ct_nom;
    @FXML
    private Label ct_prenom;
    @FXML
    private Label ct_mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServicesFormateur sfm = new ServicesFormateur();
        
        
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        
        tx_num.setOnKeyTyped(ec->{
                if(ec.getCharacter().matches("[a-zA-Z]") && tx_num.getText().length()!=8){
                    
                    ec.consume();
                    ct_num.getStyleClass().add("error");
                    ct_num.setText("veiller entrer des nombres");
                    
                    
                    
                }
                else{
                    ct_num.setText("");
                }
                
            });    
        
        tx_nom_formateur.setOnKeyTyped(ec->{
                if(ec.getCharacter().matches("^[0-9]+$")){
                    
                    ec.consume();
                    ct_nom.getStyleClass().add("error");
                    ct_nom.setText("veiller entrer des caracteres");
                    
                    
                    
                }
                else{
                    ct_nom.setText("");
                }
            });
        tx_pn_formateur.setOnKeyTyped(ec->{
                if(ec.getCharacter().matches("^[0-9]+$")){
                    
                    ec.consume();
                    ct_prenom.getStyleClass().add("error");
                    ct_prenom.setText("veiller entrer des caracteres");
                    
                    
                    
                }
                else{
                    ct_prenom.setText("");
                }
            });
        
        tx_email.setOnKeyPressed(ec->{
            String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(tx_email.getText());
                if(!matcher.matches()){
                    
                    ec.consume();
                    ct_mail.getStyleClass().add("error");
                    ct_mail.setText("veillez un email de la form example@gmail.com");
                      
                }
                else{
                    ct_mail.setText("");
                }
            });
        
        
        

        btn_ajout_formateur.setOnMouseClicked(e ->{
            
            String nom = tx_nom_formateur.getText();
            String img= tx_image_fm.getText();
            String prenom = tx_pn_formateur.getText();
            String email =tx_email.getText();
            
            String sexe = null;
            
            if (tx_male.isSelected()) {
                    sexe = tx_male.getText();
                    
                    // Do something with the selected value...
                }
            
            if (tx_female.isSelected()) {
                    sexe = tx_female.getText();
            }
            if(check_fields()==true){
                int num=Integer.parseInt(tx_num.getText());
                Formateur f_aj = new Formateur(nom, prenom, sexe, email, num, img);
                    label_error.setVisible(false);
                    sfm.ajouter(f_aj);
                    Label conf=new Label();
                    conf.setText("Formateur bien ajouté");
                    conf.setLayoutX(174);
                    conf.setLayoutY(609);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);
            }
            
            });
    }
        public boolean check_fields(){
            String nom = tx_nom_formateur.getText();
            String img= tx_image_fm.getText();
            String prenom = tx_pn_formateur.getText();
            String email =tx_email.getText();
            
            String sexe;
            
            if (tx_male.isSelected()) {
                    sexe = tx_male.getText();
                    
                    // Do something with the selected value...
                }
            
            if (tx_female.isSelected()) {
                    sexe = tx_female.getText();
            }
            
        
        if(nom.isEmpty()|| img.isEmpty() || prenom.isEmpty()|| email.isEmpty() || tx_num.getText().isEmpty() || (!tx_male.isSelected() && !tx_female.isSelected())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Confirmation");
                alert.setHeaderText("tu dois remplir tous les champs");
                Optional<ButtonType> result = alert.showAndWait();
                return false;
        }
 
        else{
            return true;
        } 
    }    
    
}

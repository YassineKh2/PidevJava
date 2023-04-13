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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
public class FormModFormateurController implements Initializable {

    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private TextField tx_nom_formateur;
    @FXML
    private JFXButton btn_mod_formateur;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        for(Formateur f:formateur){
            
            if(Formateur.getChamp_id_formateur()==f.getId()){
                tx_nom_formateur.setText(f.getNomFormateur());
                tx_pn_formateur.setText(f.getPrenomFormateur());
                tx_email.setText(f.getEmailFormateur());
                if(f.getSexeFormateur().equals("Masculin") || f.getSexeFormateur().equals("1") ){
                   tx_male.setSelected(true);
                }
                else {
                    tx_female.setSelected(true);
                }
                tx_image_fm.setText(f.getImageFormateur());
                tx_num.setText(Integer.toString(f.getNumTelFormateur()));}
            
        }
        btn_mod_formateur.setOnAction(e ->{
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
            Formateur f_up = new Formateur(Formateur.getChamp_id_formateur(),nom, prenom, sexe, email, num, img);
                    sfm.modifier(f_up);
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
    }    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import java.awt.Insets;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormAjouterController implements Initializable {

    @FXML
    private MenuButton values_formateur;
    @FXML
    private TextField tx_nom_formation;
    @FXML
    private JFXTextArea tx_description;
    @FXML
    private Spinner<Integer> values_niveau;
    @FXML
    private JFXButton btn_ajout_formation;
    @FXML
    private TextField tx_image_fm;
    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private Label label_error;
    private Label Controle;
    @FXML
    private Label ct_nom;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServicesFormation sf = new ServicesFormation();
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        for(Formateur fm:formateur){
            MenuItem item = new MenuItem(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Create a MenuItem with formateur's name
            item.setOnAction(event -> {
            values_formateur.setText(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Set the selected formateur's name as the text of MenuButton
                });
            values_formateur.getItems().add(item);
        }
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        values_niveau.setValueFactory(valueFactory);
        

        btn_ajout_formation.setOnMouseClicked(e ->{
            
            String nom = tx_nom_formation.getText();
            String img= tx_image_fm.getText();
            String desc = tx_description.getText();
            String fmr = values_formateur.getText();
            int nv=values_niveau.getValue();
            check_fields();
            
            for(Formateur fm:formateur){
                if(fmr.equals(fm.getNomFormateur()+ " " + fm.getPrenomFormateur())){
                    Formation f_aj= new Formation(nom,nv,fm.getId(),img,desc);
                    sf.ajouter(f_aj);
                    label_error.setVisible(false);
                    Label conf=new Label();
                    conf.setText("Formation bien ajouté");
                    conf.setLayoutX(174);
                    conf.setLayoutY(609);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);
                    
                }}
                
        });
     
    }
    public void check_fields(){
        String nom = tx_nom_formation.getText();
        String img= tx_image_fm.getText();
        String desc = tx_description.getText();
        String fmr = values_formateur.getText();
        int nv=values_niveau.getValue();
        
        if(nom.isEmpty()|| img.isEmpty() || desc.isEmpty()|| fmr.isEmpty()){
           label_error.getStyleClass().add("error");


        
            label_error.setText("tous les champs sont obligatoires");
            label_error.setLayoutX(174);
            label_error.setLayoutY(609);
            label_error.setPrefWidth(250);
            /*KeyFrame kf = new KeyFrame(javafx.util.Duration.seconds(5));
            Timeline timeline = new Timeline(kf);
            timeline.setCycleCount(1);
            
            timeline.setOnFinished(event -> {
                label_error.setVisible(false);
            });
            timeline.play();*/
            
            
            whole_form_scene.getChildren().add(label_error);
            
            
        }
        
        if(desc.length()<20){
            label_error.setStyle("-fx-background-color: red; -fx-font-weight: bold;");
            label_error.setText("la description doit contient 20 caracteres au min");
            label_error.setLayoutX(174);
            label_error.setLayoutY(609);
            label_error.setPrefWidth(350);
            whole_form_scene.getChildren().add(label_error);
        }
        
        
       
    }

    @FXML
    private void ControleNumbers(KeyEvent event) {
    }
}
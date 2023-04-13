/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormModController implements Initializable {

    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private TextField tx_nom_formation;
    @FXML
    public JFXTextArea tx_description;
    @FXML
    private JFXButton btn_mod_formation;
    @FXML
    private MenuButton values_formateur;
    @FXML
    private Spinner<Integer> values_niveau;
    @FXML
    private TextField tx_image_fm;
    
    @FXML
    public JFXTextArea getDescription(){
        return tx_description;
    };
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllFormation.fxml"));
        
        AllFormationController controller = loader.getController();
        loader.setController(controller);
                 
        ServicesFormation sf = new ServicesFormation();
        ServicesFormateur sfm = new ServicesFormateur();
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        
        JFXTextArea id_f= new JFXTextArea();
        id_f.setLayoutX(107);
        id_f.setLayoutY(603);
        id_f.setPrefHeight(38);
        id_f.setPrefWidth(186);
        id_f.setUnFocusColor(Paint.valueOf("#8aeacb"));
        JFXButton search= new JFXButton("Rechercher");
        
        search.setLayoutX(322);
        search.setLayoutY(609);
        whole_form_scene.getChildren().addAll(id_f,search);
        search.setOnAction(e ->{
            for(Formation f:formation){
            String champ = id_f.getText();
            if(champ.equals(f.getNomFormation()) || champ.equals(f.getId())){
                tx_nom_formation.setText(f.getNomFormation());
                for(Formateur fm:formateur){
                    MenuItem item = new MenuItem(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Create a MenuItem with formateur's name
                    item.setOnAction(event -> {
                    values_formateur.setText(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Set the selected formateur's name as the text of MenuButton
                        });
                    values_formateur.getItems().add(item);
                    if(fm.getId()==f.getIdFormateur()){
                        
                        values_formateur.setText(fm.getNomFormateur() + " " + fm.getPrenomFormateur());
                        }}
                        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
                        values_niveau.setValueFactory(valueFactory);
                        values_niveau.getValueFactory().setValue(f.getNiveauFormation());
                tx_image_fm.setText(f.getImageFormation());
                tx_description.setText(f.getDescriptionFormation());
            }
            
        }});
        for(Formation f:formation){
            
            if(Formation.getChamp_id()==f.getId()){
                tx_nom_formation.setText(f.getNomFormation());
                for(Formateur fm:formateur){
                    MenuItem item = new MenuItem(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Create a MenuItem with formateur's name
                    item.setOnAction(event -> {
                    values_formateur.setText(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Set the selected formateur's name as the text of MenuButton
                        });
                    values_formateur.getItems().add(item);
                    if(fm.getId()==f.getIdFormateur()){
                        
                        values_formateur.setText(fm.getNomFormateur() + " " + fm.getPrenomFormateur());
                        }}
                        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
                        values_niveau.setValueFactory(valueFactory);
                        values_niveau.getValueFactory().setValue(f.getNiveauFormation());
                tx_image_fm.setText(f.getImageFormation());
                tx_description.setText(f.getDescriptionFormation());
            }
        }
        
        btn_mod_formation.setOnAction(e -> {
            String nom = tx_nom_formation.getText();
            String img= tx_image_fm.getText();
            String desc = tx_description.getText();
            String fmr = values_formateur.getText();
            int nv=values_niveau.getValue();
            for(Formateur fm:formateur){
                if(fmr.equals(fm.getNomFormateur()+ " " + fm.getPrenomFormateur())){
                    Formation f_up= new Formation(Formation.getChamp_id(),nom,nv,fm.getId(),img,desc);
                    sf.modifier(f_up);
                    Label conf=new Label();
                    conf.setText("Formation modifié");
                    conf.setLayoutX(174);
                    conf.setLayoutY(690);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);     
                }}
            
        });
        
        
        
    }    
    
}

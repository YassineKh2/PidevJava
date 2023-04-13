/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui.Module;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesModule;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormModModuleController implements Initializable {

    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private JFXButton btn_mod_module;
    @FXML
    private JFXTextArea tx_contenue;
    @FXML
    private JFXTextArea tx_duree;
    @FXML
    private JFXTextArea tx_pre;
    @FXML
    private JFXTextArea tx_nom_module;
    @FXML
    private MenuButton values_formation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormation sf = new ServicesFormation();
        ServicesModule sm = new ServicesModule();
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        ArrayList<ModuleFormation> module = (ArrayList) sm.getAll();
        
        for(ModuleFormation m:module){
            if(ModuleFormation.getChamp_id_module()==m.getId()){
                tx_nom_module.setText(m.getNomModule());
                tx_pre.setText(m.getPrerequisModule());
                tx_duree.setText(m.getDureeModule());
                tx_contenue.setText(m.getContenuModule());
                for(Formation fm:formation){
                    MenuItem item = new MenuItem(fm.getNomFormation()); // Create a MenuItem with formateur's name
                    item.setOnAction(event -> {
                    values_formation.setText(fm.getNomFormation()); // Set the selected formateur's name as the text of MenuButton
                        });
                    values_formation.getItems().add(item);
                    if(fm.getId()==m.getIdFormation()){
                        
                        values_formation.setText(fm.getNomFormation());
                        }}
                
            }
        }
        btn_mod_module.setOnAction(e ->{
            String nom = tx_nom_module.getText();
            String pre= tx_pre.getText();
            String duree = tx_duree.getText();
            String contenue =tx_contenue.getText();
            String fr = values_formation.getText();
            
            for(Formation f:formation){
                if(fr.equals(f.getNomFormation())){
                    ModuleFormation m_up = new ModuleFormation(ModuleFormation.getChamp_id_module(),f.getId(), nom, pre, duree, contenue);
                    sm.modifier(m_up);
                    Label conf=new Label();
                    conf.setText("Module Modifié");
                    conf.setLayoutX(174);
                    conf.setLayoutY(700);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);}}
        });
    }    
    
}

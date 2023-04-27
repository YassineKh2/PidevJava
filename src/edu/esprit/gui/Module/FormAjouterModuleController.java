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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormAjouterModuleController implements Initializable {

    @FXML
    private AnchorPane whole_form_scene;
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
    @FXML
    private JFXButton btn_ajout_module;

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
        
        for(Formation fm:formation){
                MenuItem item = new MenuItem(fm.getNomFormation()); // Create a MenuItem with formateur's name
                item.setOnAction(event -> {
                values_formation.setText(fm.getNomFormation()); // Set the selected formateur's name as the text of MenuButton
                    });
                values_formation.getItems().add(item);
                }
        btn_ajout_module.setOnMouseClicked(e ->{
            
            String nom = tx_nom_module.getText();
            String pre= tx_pre.getText();
            String duree = tx_duree.getText();
            String contenue =tx_contenue.getText();
            String fr = values_formation.getText();
            if(check_fields()==true){
            for(Formation f:formation){
                if(fr.equals(f.getNomFormation())){
                    ModuleFormation m_aj = new ModuleFormation(f.getId(), nom, pre, duree, contenue);
                    sm.ajouter(m_aj);
                    Label conf=new Label();
                    conf.setText("Module bien ajouté");
                    conf.setLayoutX(174);
                    conf.setLayoutY(750);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);}}}
                });
    }
    public boolean check_fields(){
        String nom = tx_nom_module.getText();
            String pre= tx_pre.getText();
            String duree = tx_duree.getText();
            String contenue =tx_contenue.getText();
            String fr = values_formation.getText();
        if(nom.isEmpty()|| pre.isEmpty() || duree.isEmpty()|| contenue.isEmpty() || fr.isEmpty()){
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

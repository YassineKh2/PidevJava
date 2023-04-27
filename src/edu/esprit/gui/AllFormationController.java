/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesModule;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class AllFormationController implements Initializable {

    
    @FXML
    private JFXButton handle_form_ajout;
    @FXML
    private JFXButton handle_form_mod;
    @FXML
    private JFXButton handle_supprimer;
    @FXML
    private AnchorPane whole_formation;
    @FXML
    private JFXListView<Formation> list_formation;
    @FXML
    private JFXListCell<String> cell_nom;
    
    
    
    
    
    
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
        
        for(Formation f:formation){
            
            list_formation.setCellFactory(p -> new FormationCell());
            list_formation.getItems().add(f);
        }
        handle_form_ajout.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formAjouter.fxml"));
             Dialog dialog= new Dialog();
             dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
             try {
            dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
        // handle exception
            }
             dialog.show();
        });
        
        
        handle_form_mod.setOnAction(e ->{
            try {
                
                Formation selectedFormation = list_formation.getSelectionModel().getSelectedItem();
                Formation.setChamp_id(selectedFormation.getId());
                                
                Dialog dialog= new Dialog();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formMod.fxml"));
                FormModController controller = loader.getController();
                
                loader.setController(controller);
                dialog.getDialogPane().setContent(loader.load());
                
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.show();
                
                
            } catch (IOException ex) {
                Logger.getLogger(AllFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
        

        handle_supprimer.setOnAction(e -> {
            Formation selectedFormation = list_formation.getSelectionModel().getSelectedItem();
            if (selectedFormation != null) {
                
                sf.supprimer(selectedFormation.getId());
                list_formation.getItems().remove(selectedFormation);
    }
        });
        
    
}
}

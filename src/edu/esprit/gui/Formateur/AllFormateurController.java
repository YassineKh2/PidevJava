/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui.Formateur;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formateur;

import edu.esprit.gui.FormModController;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesModule;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class AllFormateurController implements Initializable {

    @FXML
    private AnchorPane whole_formateur;
    @FXML
    private JFXButton handle_form_ajout;
    @FXML
    private JFXButton handle_form_mod;
    @FXML
    private JFXButton handle_supprimer;
    @FXML
    private JFXListView<Formateur> list_formateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        
        for(Formateur f:formateur){
            list_formateur.setCellFactory(p -> new FormateurCell());
            list_formateur.getItems().add(f);
        }
        handle_form_ajout.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formAjouterFormateur.fxml"));
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
                
                Formateur selectedFormateur = list_formateur.getSelectionModel().getSelectedItem();
                Formateur.setChamp_id_formateur(selectedFormateur.getId());
                                
                Dialog dialog= new Dialog();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formModFormateur.fxml"));
                FormModController controller = loader.getController();
                
                loader.setController(controller);
                dialog.getDialogPane().setContent(loader.load());
                
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.show();
                
                
            } catch (IOException ex) {
                Logger.getLogger(AllFormateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
        

        handle_supprimer.setOnAction(e -> {
            Formateur selectedFormateur = list_formateur.getSelectionModel().getSelectedItem();
            if (selectedFormateur != null) {
                
                sfm.supprimer(selectedFormateur.getId());
                list_formateur.getItems().remove(selectedFormateur);
    }
        });
        
    
}
    
}

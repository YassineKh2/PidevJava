/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Module;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.ModuleFormation;
import pidev.gargabou.gui.Formation.AllFormationController;
import pidev.gargabou.gui.Formation.FormModController;
import pidev.gargabou.services.ServicesFormateur;
import pidev.gargabou.services.ServicesFormation;
import pidev.gargabou.services.ServicesModule;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class AllModuleController implements Initializable {

    @FXML
    private AnchorPane whole_formateur;
    @FXML
    private JFXButton handle_form_ajout;
    @FXML
    private JFXButton handle_form_mod;
    @FXML
    private JFXButton handle_supprimer;
    @FXML
    private JFXListView<ModuleFormation> list_module;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormation sf = new ServicesFormation();
        ServicesModule sm = new ServicesModule();
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        
        ArrayList<ModuleFormation> module = (ArrayList) sm.getAll();
        
        for(ModuleFormation m:module){
            list_module.setCellFactory(p -> new ModuleCell());
            list_module.getItems().add(m);
        }
        handle_form_ajout.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formAjouterModule.fxml"));
             Dialog dialog= new Dialog();
             dialog.setTitle("Ajout Module Formation");
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
                
                ModuleFormation selectedModule = list_module.getSelectionModel().getSelectedItem();
                ModuleFormation.setChamp_id_module(selectedModule.getId());
                                
                Dialog dialog= new Dialog();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formModModule.fxml"));
                FormModController controller = loader.getController();
                dialog.setTitle("Modification Module Formation");
                loader.setController(controller);
                dialog.getDialogPane().setContent(loader.load());
                
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.show();
                
                
            } catch (IOException ex) {
                Logger.getLogger(AllFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
        

        handle_supprimer.setOnAction(e -> {
            ModuleFormation selectedModule = list_module.getSelectionModel().getSelectedItem();
            if (selectedModule != null) {
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("est tu sure que tu veut supprimer ce Module?");
                alert.setContentText("cette operation peut etre annulé.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    sm.supprimer(selectedModule.getId());
                    list_module.getItems().remove(selectedModule);
                }}
        });
    }    
    
}

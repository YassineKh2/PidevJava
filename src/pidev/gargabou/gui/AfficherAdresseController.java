/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class AfficherAdresseController implements Initializable {

   
    @FXML
    private Label Alnomrue;
    @FXML
    private Label ALgouvernorat;
    @FXML
    private Label Alcodepostal;
   
    @FXML
    private Label Alnumrue;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    public void afficheradresses(Adresse adresse){
  
              Alnomrue.setText(adresse.getNomRue());
              Alcodepostal.setText(String.valueOf(adresse.getCodePostal()));
              Alnumrue.setText(String.valueOf(adresse.getNumRue()));
              ALgouvernorat.setText(adresse.getGouvernorat());
                                        
    }
    @FXML
    private void supprimerAdresse(ActionEvent event) {
          ALgouvernorat.setText("");
    }

    @FXML
    private void modifierAdresse(ActionEvent event) {
        
    }
    
}

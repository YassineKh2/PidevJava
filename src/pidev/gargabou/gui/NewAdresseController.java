/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class NewAdresseController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private TextField tfNomRue;
    @FXML
    private TextField tfNumRue;
    @FXML
    private TextField tfGouvernorat;
    @FXML
    private TextField tfCodePostal;
    AdresseCRUD acd = new AdresseCRUD();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    @FXML
    private void AjouterEvenement(ActionEvent event) {
        String nomrue = tfNomRue.getText();
        int numrue =  Integer.parseInt(tfNumRue.getText());
        int codepostal =  Integer.parseInt(tfCodePostal.getText());
        String gouvernorat =tfGouvernorat.getText();
        Adresse A =new Adresse(nomrue, numrue, codepostal, gouvernorat);
        
        acd.ajouteradresse(A);
        
        reset();
    }
    public void reset(){
        tfNomRue.setText("");
        tfNumRue.setText("");        
        tfCodePostal.setText("");
        tfGouvernorat.setText(""); 
    }
}

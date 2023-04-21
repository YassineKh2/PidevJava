/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class DetailController implements Initializable {

    @FXML
    private Label lblNom;
    @FXML
    private Label lblPrenom;
    @FXML
    private Label lblemail;
    @FXML
    private Label lblPsuedo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setNom(String nom){
        lblNom.setText(nom);
    }
    
    public void setPrenom(String prenom){
        lblPrenom.setText(prenom);
    }
     public void setemail(String email){
        lblemail.setText(email);
    }
    
    public void setPsuedo(String PseudoUtilisateur){
        lblPsuedo.setText(PseudoUtilisateur);
    }
    
}

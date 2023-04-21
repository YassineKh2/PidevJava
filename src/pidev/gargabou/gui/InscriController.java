/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.userCRUD;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class InscriController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfpsuedo;
    @FXML
    private TextField tfpass;
    @FXML
    private Button btnValider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterperssone(ActionEvent event) {
        String nom =tfNom.getText();
         String prenom =tfPrenom.getText();
          String email =tfemail.getText();
           String password =tfpass.getText();
            String PseudoUtilisateur =tfpsuedo.getText();
        User u =new User(email,password,nom,prenom,PseudoUtilisateur);
        userCRUD ucd =new userCRUD() ;
        ucd.ajouter2(u);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("detail.fxml"));
        try {
            Parent root = loader.load();
            DetailController dc=loader.getController();
            dc.setNom(""+u.getNom());
            dc.setPrenom(""+u.getPrenom());
            dc.setPsuedo(""+u.getPseudoUtilisateur());
            dc.setemail(""+ u.getEmail());
            
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}

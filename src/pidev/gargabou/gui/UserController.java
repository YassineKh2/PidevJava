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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.userCRUD;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class UserController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label mail;
    @FXML
    private Label num;
    @FXML
    private ImageView imge;
    
    @FXML
    private Label role;
    @FXML
    private Label awah;
@FXML
    private Button approve;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUser(User u) {

    String name = u.getNom();
     String prenomy = u.getPrenom();
      String email = u.getEmail();

   
        nom.setText(name);

        mail.setText(email);
        prenom.setText(prenomy);
        
        String rolee = u.getRoles();
      if (rolee.contains("ROLE_PATIENT")) {
                role.setText("Patient");

            } else {
                role.setText("Therapist");
            }
      
    }}
    
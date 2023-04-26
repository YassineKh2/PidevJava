/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.userCRUD;
import pidev.gargabou.utils.passwordHasher;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class InscriTController implements Initializable {

    @FXML
    private Button bchoix;
    @FXML
    private Button sinscri;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_email;
    @FXML
    private PasswordField tf_mdp;

    @FXML
    private TextField tf_num;
    @FXML
    private Hyperlink blogin;
    @FXML
    private TextField tf_spetialite;
    @FXML
    private TextField tf_numlic;
    @FXML
    private PasswordField tf_mdp1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private Stage stage;
    private Scene scene;
    private Parent root;

    
        @FXML
    void showpass(MouseEvent event) {
  tf_mdp.setPromptText(tf_mdp.getText());
                tf_mdp.setText("");
    }

         @FXML
    void hidepass(MouseEvent event) {
 tf_mdp.setText(tf_mdp.getPromptText());
                tf_mdp.setPromptText("");
    }
    @FXML
    private void switchtologin(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private Stage stage1;
    private Scene scene1;
    private Parent root1;

     @FXML
    private void switchtochoix(ActionEvent event) throws IOException {
        root1=FXMLLoader.load(getClass().getResource("choix.fxml"));
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene1= new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }
    @FXML
    private void ajouterTherapist(ActionEvent event) throws IOException {
        String nom = tf_nom.getText();
        String prenom = tf_prenom.getText();
        String email = tf_email.getText();
        String password = tf_mdp.getText();
        String specialite = tf_spetialite.getText();
        String numero =tf_num.getText();
        String Licence = tf_numlic.getText();
        String role = "[\"ROLE_THERAPIST\"]";
        String cpass = tf_mdp1.getText();
        String hashedPassword = passwordHasher.hashPassword(password);
        
         if (nom.isEmpty()||prenom.isEmpty()||email.isEmpty()||specialite.isEmpty()||password.isEmpty()||cpass.isEmpty()||numero.isEmpty()||Licence.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" form pas remply");
                alert.setContentText("veuiller remplir tous les collones");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;}
         else{
         
          if (!email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" Email Invalid");
                alert.setContentText("enterr un Email valid : example@email.com");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;}
           if (!nom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nom Invalid");
                alert.setContentText("entrer un nom valid");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
              if (!prenom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Prenom Invalid");
                alert.setContentText("entrer un prenom valid");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
               if (!specialite.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Specialite Invalid");
                alert.setContentText("entrer un specialite valid");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
               if (!password.equals(cpass)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password Invalid");
                alert.setContentText("Utiliser la meme Passwords");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }   if (password.length()<6){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password Invalid");
                alert.setContentText("Utiliser un Passwordsde 6 charachtere");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
               
               if (!password.matches("^(?=.*[0-9])(?=.*[A-Z]).+$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" Password Invalid");
                alert.setContentText("Mot De passe doit avoir une lettre majuscule et un nombre");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
           if (!numero.matches("([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("numero Invalid");
                alert.setContentText("entrer un numero valid(8)");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
             if (!Licence.matches("[1-9]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("numero Invalid");
                alert.setContentText("entrer un numero Licence valid");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
         
         
          else{  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setContentText("compte creer et entrain d'etre verifier");
                alert.setHeaderText(null);
                alert.showAndWait();
          
         }
             
            
         }
        
        
        
        User u = new User(email,role, hashedPassword, nom, prenom, numero, Licence, specialite);
          userCRUD ucd =new userCRUD() ;
        ucd.ajouterT(u);
           root1=FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene1= new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }

   
 
    
    }

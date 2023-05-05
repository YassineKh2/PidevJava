/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.adresse;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.gui.Formation.IAFormationController;
import pidev.gargabou.services.AdresseCRUD;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.services.OrganisateurCRUD;
import pidev.gargabou.utils.changeScene;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class NewAdresseController implements Initializable {

    private TextField tfNomRue;
    private TextField tfNumRue;
    private TextField tfGouvernorat;
    private TextField tfCodePostal;
  //  AdresseCRUD acd = new AdresseCRUD();
    @FXML
    private JFXButton btretourtoadresses;
    private JFXButton btevenement;
    private JFXButton btorganisateur;
    @FXML
    private TextField tfnomrue;
    @FXML
    private TextField tfgouvernorat;
    @FXML
    private TextField tfnumrue;
    @FXML
    private TextField tfcodepostal;
    @FXML
    private Button ajouterAdresse;
    private JFXButton btadresse;
    int ide;
    int ida;
    int ido;
    String entity="adresse";
    @FXML
    private JFXButton util;
    @FXML
    private JFXButton approve;
    @FXML
    private JFXButton fxGoToForum;
    @FXML
    private JFXButton fxGoToCategorie;
    @FXML
    private JFXButton fxGoToArticle;
    @FXML
    private JFXButton fxGoToEvenement;
    @FXML
    private JFXButton fxGoToOrganisateur;
    @FXML
    private JFXButton fxGoToAdresse;
    @FXML
    private JFXButton fxGoToCentre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btretourtoadresses.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                 System.out.println(ex.getMessage());
            }
       });
         fxGoToForum.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Forum/AdminAllPubs.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
           fxGoToArticle.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/HomeArticle.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            fxGoToCategorie.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/HomeCategorie.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); fxGoToEvenement.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/evenement/HomeEvenement.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         fxGoToAdresse.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/adresse/HomeAdresse.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); fxGoToOrganisateur.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/organisateur/HomeOrganisateur.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         fxGoToCentre.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Centre/ListCentreBack.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       ajouterAdresse.setOnAction(event -> {
             try{
            int numrue = Integer.parseInt(tfnumrue.getText());
              if (numrue < 0 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" numero rue invalide");
                alert.setContentText("Le numero rue est invalide !!");
                alert.showAndWait();
                return;
            } }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid !");
                alert.setContentText("Le numero rue est invalide !!");
                alert.showAndWait();
                return;
            }
             
             
               try{
            int codepostal = Integer.parseInt(tfcodepostal.getText());
              if (codepostal < 1000 ||codepostal >9999 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" code postal invalide");
                alert.setContentText("Le code postal est invalide !!");
                alert.showAndWait();
                return;
            } }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid !");
                alert.setContentText("Le code postal est invalide !!");
                alert.showAndWait();
                return;
            }
               
               
               
                if (tfgouvernorat.getText().length() < 1 || tfgouvernorat.getText().length() > 100) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("entrer la gouvernorat");
                alert.showAndWait();
                return;
            }
                if (tfnomrue.getText().length() < 1 || tfnomrue.getText().length() > 100) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("entrer le nomrue");
                alert.showAndWait();
                return;
            }
                
                
            String nomrue = tfnomrue.getText();
            int numrue =  Integer.parseInt(tfnumrue.getText());
            int codepostal =  Integer.parseInt(tfcodepostal.getText());
            String gouvernorat =tfgouvernorat.getText();
            Adresse A =new Adresse(nomrue, numrue, codepostal, gouvernorat);
            AdresseCRUD acd = new AdresseCRUD();
            ida=acd.ajouteradresse(A);
            if("event".equals(entity)){
                 EvenementCRUD ecd = new EvenementCRUD();
                 ecd.updateadresse(ide, ida);
                  try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../evenement/HomeEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            }
             if("organisateur".equals(entity)){
                 OrganisateurCRUD ocd = new OrganisateurCRUD();
                 ocd.updateadresse(ido, ida);
                  try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../organisateur/HomeOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            }
           
                if("adresse".equals(entity)){
             try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
}
                
                
                
                
        });
       
    }    
  public void setidevent(int id){
      this.ide=id;
  }
  public void setidorg(int id){
      this.ido=id;
  }
  public void setentity(String msg){
      this.entity=msg;
  }
   
    public void reset(){
        tfNomRue.setText("");
        tfNumRue.setText("");        
        tfCodePostal.setText("");
        tfGouvernorat.setText(""); 
    }

    @FXML
    private void show(ActionEvent event) {
    }

    @FXML
    private void showapp(ActionEvent event) {
    }

    @FXML
    private void showban(ActionEvent event) {
    }

}

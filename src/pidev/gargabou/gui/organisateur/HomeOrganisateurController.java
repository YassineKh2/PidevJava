/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.organisateur;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.gui.Formation.IAFormationController;

import pidev.gargabou.services.OrganisateurCRUD;
import pidev.gargabou.utils.changeScene;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class HomeOrganisateurController implements Initializable {

    
    @FXML
    private JFXButton btretour;
    private JFXButton btevenement;
    private JFXButton btadresse;
    private JFXButton btorganisateur;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btajouterorganisateur;
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
        btajouterorganisateur.setOnAction( event -> {
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content               
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node                
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
               
                stage.setScene(scene); // set the new scene as the content of the stage
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
               
        });
        btretour.setOnAction( event -> { 
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Home.fxml"));
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
          refreshNodes();
    }    
    private void refreshNodes()
    {
        
        OrganisateurCRUD ocd = new OrganisateurCRUD();
        
        ArrayList<Organisateur> Organisateur = (ArrayList) ocd.afficherOrganisateur();
                
      //  Node [] nodes = new  Node[Adresses.size()];
        pnl_scroll.getChildren().clear();
        for(int i = 0; i<Organisateur.size(); i++)
        {
            try {
               
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemOrganisateur.fxml"));
                Node node = (Node) loader.load();
                ItemOrganisateurController controller = loader.getController();
                controller.afficherorganisateur(Organisateur.get(i));
                
               pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           
        }  
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

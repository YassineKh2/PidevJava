/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.organisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.services.AdresseCRUD;
import pidev.gargabou.services.OrganisateurCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class ItemOrganisateurController implements Initializable {

    @FXML
    private Label fxnomorganisateur1;
    @FXML
    private Label Alnumrue;
    @FXML
    private Label Alnomrue;
    @FXML
    private Label ALgouvernorat;
    @FXML
    private Label Alcodepostal;
    @FXML
    private Label fxnomorganisateur2;
    @FXML
    private Label fxnumtel;
    int ida;
    int ido;
    @FXML
    private Label fxpourcentage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void afficherorganisateur(Organisateur organisateur) {
        fxnomorganisateur1.setText(organisateur.getNomOrganisateur());
        fxnomorganisateur2.setText(organisateur.getNomOrganisateur());
        fxnumtel.setText(String.valueOf(organisateur.getNumTelOrganisateur()));
        fxpourcentage.setText(String.valueOf(organisateur.getPourcentageRevenuOrganisateur()));
        ida = organisateur.getIdAdresse();
        ido = organisateur.getId();
        AdresseCRUD acd = new AdresseCRUD();
        Adresse A = acd.afficherseulAdresse(ida);
        Alnomrue.setText(A.getNomRue());
        Alcodepostal.setText(String.valueOf(A.getCodePostal()));
        Alnumrue.setText(String.valueOf(A.getNumRue()));
        ALgouvernorat.setText(A.getGouvernorat());

    }

    @FXML
    private void modifierOrganisaur(ActionEvent event) {
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                
                ModifierOrganisateurController showorganisateur = loader.getController();
                
                showorganisateur.setnomorg(fxnomorganisateur1.getText());
                showorganisateur.setnumtel(fxnumtel.getText());
                showorganisateur.setpourc(fxpourcentage.getText());
                showorganisateur.ida=ida;
                
                
                 Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
          } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
    }

    @FXML
    private void supprimerOrganisateur(ActionEvent event) {
         try {
         OrganisateurCRUD ocd = new OrganisateurCRUD();
         AdresseCRUD acd = new AdresseCRUD();
         ocd.supprimerOrganisateur(ido);
         acd.supprimerAdresse(ida);
         
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeOrganisateur.fxml"));
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

}

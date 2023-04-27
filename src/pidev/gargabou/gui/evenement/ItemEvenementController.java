/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.services.OrganisateurCRUD;
import sun.util.calendar.LocalGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;

import pidev.gargabou.services.EvenementCRUD;

/**
 * FXML Controller class
 * 
 * @author omran
 */
public class ItemEvenementController implements Initializable {

    @FXML
    private ImageView itemimage;
    @FXML
    private Label tfnomevenement;
    @FXML
    private Label tfdateevenement;
    @FXML
    private Label tftypeevenement;
    @FXML
    private Label tfplacerestante;
    @FXML
    private JFXTextArea tfdescription;
     LocalDate ldate;
    int ide ;
    int idadresse;
    int nbrparticip;
    int prixevent;
    Image img;
    String imgpath ;
    String nomorganisateur;
    String myformatteddate;
    String nomevenement;
    String typeevenement;
    String placesrestantes;
    String description;
    String prix;
    int numberoflikes;
    @FXML
    private Label organisepar;
    @FXML
    private VBox itembox;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      itembox.setOnMouseClicked(event -> {
           try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                ShowEvenementController showevenement = loader.getController();
                AdresseCRUD acd = new AdresseCRUD();
                Adresse A=acd.afficherseulAdresse(idadresse);
                showevenement.setnomrue(A.getNomRue());
                showevenement.setnumrue(String.valueOf(A.getNumRue()));
                showevenement.setcodepostal(String.valueOf(A.getCodePostal()));
                showevenement.setgovernorat(A.getGouvernorat());
                showevenement.setidevent(ide);
                showevenement.setnomevenement(nomevenement);
                showevenement.setorganisateur(nomorganisateur);
                showevenement.setdescription(description);
                showevenement.setimage(img);
                showevenement.setprixevenement(prix);
                showevenement.settypeevent(typeevenement);
                showevenement.setplacesrestantes(placesrestantes);
                showevenement.setnumberoflikes(String.valueOf(numberoflikes));
                
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
               
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        });
      
      
    }    
    
   

    public void afficherevenment(Evenement evenement){
         
        ldate = convertToLocalDateViaSqlDate(evenement.getDateEvenement());
          myformatteddate = ldate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        ide=evenement.getId();
        nbrparticip=evenement.getNombreParticipantEvenement();
        prixevent=evenement.getPrixEvenement();
        imgpath=evenement.getImageevenement();
        nomevenement =evenement.getNomEvenement();
        typeevenement=evenement.getTypeEvenement();
        placesrestantes=String.valueOf(evenement.getPlacesRestantes());
        description=evenement.getDescription();
        prix=String.valueOf(evenement.getPrixEvenement());
        idadresse=evenement.getIdAdresse();
        numberoflikes=evenement.getNumberoflikes();
         OrganisateurCRUD ocd =new OrganisateurCRUD();
         Organisateur O =ocd.findorganisateurbyid(evenement.getIdOrganisateur());
         nomorganisateur=O.getNomOrganisateur();
       
          img = new Image("file:/C:/Users/omran/Documents/GitHub/3a39-gargabou/public/"+evenement.getImageevenement(), true);
       
        itemimage.setImage(img);
        tfnomevenement.setText(nomevenement);
        tfdateevenement.setText(myformatteddate);
        tftypeevenement.setText(typeevenement);
        tfplacerestante.setText(placesrestantes+" places restantes");
        tfdescription.setText(description);
         organisepar.setText("Organisé par "+ nomorganisateur);  
         
                }
  
  
    @FXML
    private void modifierevent(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                
                
                ModifierEvenementController showevenement = loader.getController();
                
                
                showevenement.setnomevenement(tfnomevenement.getText());
               // showevenement.setdateevenement(LocalDate.parse(tfdateevenement.getText()));
                showevenement.setdateevenement(ldate);
                showevenement.setnmbredeparticipation(String.valueOf(nbrparticip));
                showevenement.setprixevenement(String.valueOf(prixevent));
                showevenement.settypeevent(tftypeevenement.getText());
                showevenement.setimage(img);
                showevenement.setpath(imgpath);
                showevenement.setorganisateur(nomorganisateur);
                showevenement.setdescription(tfdescription.getText());
                showevenement.id=ide;
                
                
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
               
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
    
    }

    @FXML
    private void supprimerevent(ActionEvent event) {
         try {
          
          EvenementCRUD ecd = new EvenementCRUD();
        
          AdresseCRUD acd =new AdresseCRUD();
          
           ecd.supprimerEvenement(ide);
           acd.supprimerAdresse(idadresse);
          FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEvenement.fxml"));
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
    
//        public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
//    return dateToConvert.toInstant()
//      .atZone(ZoneId.systemDefault())
//      .toLocalDate();}
        
        
        
  public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
}
    }
    
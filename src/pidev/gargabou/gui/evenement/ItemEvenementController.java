/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXTextArea;
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
    
    int ide ;
    @FXML
    private Label organisepar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   

    public void afficherevenment(Evenement evenement){
         
        LocalDate ldate = convertToLocalDateViaSqlDate(evenement.getDateEvenement());
         String myformatteddate = ldate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        ide=evenement.getId();
         OrganisateurCRUD ocd =new OrganisateurCRUD();
         Organisateur O =ocd.findorganisateurbyid(evenement.getIdOrganisateur());
         
       
         Image img = new Image("file:/C:/Users/omran/Documents/GitHub/3a39-gargabou/public/"+evenement.getImageevenement(), true);
       
        itemimage.setImage(img);
        tfnomevenement.setText(evenement.getNomEvenement());
        tfdateevenement.setText(myformatteddate);
        tftypeevenement.setText(evenement.getTypeEvenement());
        tfplacerestante.setText(String.valueOf(evenement.getPlacesRestantes())+" places restantes");
        tfdescription.setText(evenement.getDescription());
         organisepar.setText("Organisé par "+ O.getNomOrganisateur());  
         
                }
  
  
    @FXML
    private void modifierevent(ActionEvent event) {
    }

    @FXML
    private void supprimerevent(ActionEvent event) {
    }
        public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();}
        
        
        
  public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
}
    }
    
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Centre;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;
import pidev.gargabou.utils.DataSource;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class AjoutPlanningController implements Initializable {

    @FXML
    private TextField titrep;
    @FXML
    private TextField descriptionp;
    @FXML
    private DatePicker datef;
    @FXML
    private DatePicker dated;
    @FXML
    private ComboBox<String> idCentre;
    @FXML
    private Button btnAjouterPlanning;
    @FXML
    private Button btnClearPlanning;
    @FXML
    private TextField numeroSMS;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane addPlanningPane;

     @FXML
     void open_ListPlanning() throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("ListPlanningBack.fxml"));
         addPlanningPane.getChildren().removeAll();
         addPlanningPane.getChildren().setAll(fxml);
     }
     
     
    CentreService cs = new CentreService();
    List<Centre> centres = cs.recuperer();
    private int centreId=-1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Map<String, Integer> valuesMap = new HashMap<>();
        for(Centre c : centres){
            idCentre.getItems().add(c.getNomCentre());
            valuesMap.put(c.getNomCentre(),c.getId());
        }
        
        idCentre.setOnAction(event ->{
            String SelectedOption = null;
            SelectedOption = idCentre.getValue();
            int SelectedValue = 0;
            SelectedValue = valuesMap.get(SelectedOption);
            centreId = SelectedValue;
        });
    }    
    
    
  @FXML
private void AjoutPlanningCentre(ActionEvent event) throws SQLException {
    
    //check if not empty
    if(event.getSource() == btnAjouterPlanning){
        if (titrep.getText().isEmpty() || descriptionp.getText().isEmpty() ||   centreId==-1 || dated.getValue() == null) 
        {    
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information manquante");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir tous les détails concernant votre planning.");
            Optional<ButtonType> option = alert.showAndWait();
            
        } else {    
            LocalDate dateDebut = dated.getValue();
            LocalDate dateActuelle = LocalDate.now();

            if(dateDebut.isBefore(dateActuelle)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("La date de début doit être supérieure ou égale à la date actuelle.");
                alert.showAndWait();
            } else {
                ajouterPlanningCentre();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajouté avec succès");
                alert.setHeaderText(null);
                alert.setContentText("Votre planning a été ajouté avec succès.");
                Optional<ButtonType> option = alert.showAndWait();

                clearFieldsPlanningCentre();
                send_SMS();
            }
        }
        
    }
    if(event.getSource() == btnClearPlanning){
        clearFieldsPlanningCentre();
    }
}


    
    
    @FXML
    private void clearFieldsPlanningCentre() {
        titrep.clear();
        descriptionp.clear();
    }
    
    
 private void ajouterPlanningCentre() throws SQLException {
        
    String titre = titrep.getText();
    String description = descriptionp.getText();

    if (titre.length() > 15) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Longueur du titre dépassée");
        alert.setHeaderText(null);
        alert.setContentText("Le titre ne doit pas dépasser 15 caractères.");
        alert.showAndWait();
        return;
    }

    if (description.length() > 50) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Longueur de la description dépassée");
        alert.setHeaderText(null);
        alert.setContentText("La description ne doit pas dépasser 50 caractères.");
        alert.showAndWait();
        return;
    }

    LocalDate localDateDebut = dated.getValue();
    if (localDateDebut == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Date de début manquante");
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrer une date de début.");
        alert.showAndWait();
        return;
    }

    LocalDate now = LocalDate.now();
    if (localDateDebut.isBefore(now)) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Date de début invalide");
        alert.setHeaderText(null);
        alert.setContentText("La date de début doit être supérieure ou égale à la date actuelle.");
        alert.showAndWait();
        return;
    }

    Date dateDebut = null;
    try {
        Instant instant = Instant.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()));
        dateDebut = Date.from(instant);
    } catch (Exception e) {
        e.printStackTrace();
    }

    Date dateFin = null;
    try {
        LocalDate localDateFin = datef.getValue();
        if (localDateFin != null) {
            Instant instant = Instant.from(localDateFin.atStartOfDay(ZoneId.systemDefault()));
            dateFin = Date.from(instant);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    int idC = centreId;

    DataSource db = DataSource.getInstance();
    PlanningCentre pc = new PlanningCentre(idC, dateDebut, dateFin, titre, description);
    PlanningCentreService cs = new PlanningCentreService();
    cs.ajouter(pc);
}


    
    
    void send_SMS (){
        
        String ACCOUNT_SID = "AC9f55c7ecafc7f09ebb1f6ab9b5897825";
        String AUTH_TOKEN = "c1896fc9be5d630f09e438dcb3931f15";
             
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String recipientNumber = "+216" + numeroSMS.getText();
            String message = "Bonjour Mr ,\n"
                    + "Nous sommes ravis de vous informer qu'un planning a été ajouté.\n "
                    + "Veuillez contactez l'administration pour plus de details.\n "
                    + "Merci de votre fidélité et à bientôt chez Rehab Lab.\n"
                    + "Cordialement,\n"
                    + "RehabLab 2023";
                
            Message twilioMessage = Message.creator(
                new PhoneNumber(recipientNumber),
                new PhoneNumber("+14345058256"),message).create();
                
            System.out.println("SMS envoyé : " + twilioMessage.getSid());
          

        
         
     }
    
    
    
}

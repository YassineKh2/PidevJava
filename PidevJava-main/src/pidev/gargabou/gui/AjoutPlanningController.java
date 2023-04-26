/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;
import javafx.scene.control.Alert.AlertType;

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
import javafx.scene.control.Alert.AlertType;


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
        if (titrep.getText().isEmpty() || descriptionp.getText().isEmpty() ||   centreId==-1) 
        {    
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information manquante");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir tous les détails concernant votre planning.");
            Optional<ButtonType> option = alert.showAndWait();

        } else {    

            LocalDate currentDate = LocalDate.now();
            LocalDate startDate = dated.getValue();
            if (startDate == null || startDate.isBefore(currentDate)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("La date de début doit être supérieure ou égale à la date actuelle.");
                alert.showAndWait();
                return;
            }

            ajouterPlanningCentre();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajouté avec succès");
            alert.setHeaderText(null);
            alert.setContentText("Votre planning a été ajoutée avec succès.");
            Optional<ButtonType> option = alert.showAndWait();

            clearFieldsPlanningCentre();
            send_SMS();
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
    LocalDate localStartDate = dated.getValue();
    LocalDate localEndDate = datef.getValue();
    Date startDate = null;
    Date endDate = null;

    // Vérification de la validité de la date de début
    if (localStartDate != null) {
        Instant instant = Instant.from(localStartDate.atStartOfDay(ZoneId.systemDefault()));
        startDate = Date.from(instant);

        Instant currentInstant = Instant.now();
        Date currentDate = Date.from(currentInstant);

        if (startDate.before(currentDate)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("La date de début doit être supérieure ou égale à la date actuelle.");
            alert.showAndWait();
            return;
        } else {
            System.out.println("Date de début valide.");
        }
    }

    // Conversion des dates de fin
    if (localEndDate != null) {
        Instant instant = Instant.from(localEndDate.atStartOfDay(ZoneId.systemDefault()));
        endDate = Date.from(instant);
    }

    int idC = centreId;
    DataSource db = DataSource.getInstance();
    PlanningCentre pc = new PlanningCentre(idC, startDate, endDate, titre, description);
    PlanningCentreService cs = new PlanningCentreService();
    cs.ajouter(pc);
}


    
    
    
    void send_SMS (){
        
        String ACCOUNT_SID = "AC9f55c7ecafc7f09ebb1f6ab9b5897825";
        String AUTH_TOKEN = "e15fdf348cac841057475e3e0bf55dea";
             
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

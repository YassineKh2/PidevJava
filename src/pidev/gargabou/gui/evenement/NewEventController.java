/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.ZoneId.systemDefault;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.gui.adresse.NewAdresseController;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.services.OrganisateurCRUD;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class NewEventController implements Initializable {

    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private JFXButton btretourtoevenements;
    @FXML
    private JFXButton btadresse;
    @FXML
    private Button ajouterevenement;
    @FXML
    private TextField tfnomevenement;
    @FXML
    private TextField prixevenement;
    @FXML
    private TextField tfnombreparticipant;
    @FXML
    private TextField tfimageevent;
    @FXML
    private TextField typeevenement;
    @FXML
    private DatePicker tfdateevenement;
    @FXML
    private ImageView IVimage;
    @FXML
    private TextArea tfdescriptionevent;
    @FXML
    private Button importimageevent;
    @FXML
    private ComboBox<String> fxidorganisateur;
    String outputPath;
    BufferedImage image;
    int idevent;
    String entity="event";
    String pathimag="Back/images/events/NoImageFound.png";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrganisateurCRUD ocd = new OrganisateurCRUD();
        ArrayList<Organisateur> organisateur = (ArrayList<Organisateur>) ocd.afficherOrganisateur();
        for(Organisateur org :organisateur){
            fxidorganisateur.getItems().add(org.getNomOrganisateur());
            tfimageevent.setText(pathimag);
        }                  
        btorganisateur.setOnAction( event -> {
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
               
        });
        btevenement.setOnAction( event -> {
            try {
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
               
        });
       btadresse.setOnAction( event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../adresse/HomeAdresse.fxml"));
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
              
           btretourtoevenements.setOnAction( event -> {
            try {
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
       });
            ajouterevenement.setOnAction(event -> {
                 if (tfnomevenement.getText().length() < 1 || tfnomevenement.getText().length() > 50) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("entrer un nom valide inferieur a 50 charactere");
                alert.showAndWait();
                return;
            }
                 try{
            int Prix = Integer.parseInt(prixevenement.getText());
              if (Prix < 0 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Prix Invalide");
                alert.setContentText("Le prix doit etre positive !!");
                alert.showAndWait();
                return;
            } }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid !");
                alert.setContentText("Le prix est invalide !!");
                alert.showAndWait();
                return;
            }
                try{
            int nbpart = Integer.parseInt(tfnombreparticipant.getText());
              if (nbpart < 0 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("Le nombre de participant doit etre positive !!");
                alert.showAndWait();
                return;
            } }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid !");
                alert.setContentText("Le nombre est invalide !!");
                alert.showAndWait();
                return;
            }  
               
                if (typeevenement.getText().length() < 1 || typeevenement.getText().length() > 20) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("entrer le type d'evenement");
                alert.showAndWait();
                return;
            }
                LocalDate today=LocalDate.now();
                 if (tfdateevenement.getValue().isBefore(today) ){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Date");
                alert.setContentText("La date doit etre supérieur a aujourd'hui");
                alert.showAndWait();
                return;
            }
                 
                 if (tfdescriptionevent.getText().length() < 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("entrer une description pour l'evenement");
                alert.showAndWait();
                return;
            }
             
                
            try {
                EvenementCRUD ecd = new EvenementCRUD();
                String nom =tfnomevenement.getText();
                LocalDate ldate =tfdateevenement.getValue();
                Date date = Date.from(ldate.atStartOfDay(systemDefault()).toInstant());
                int nbrdeparticipant=Integer.parseInt(tfnombreparticipant.getText());
                int prixevent =Integer.parseInt(prixevenement.getText());
                String typevent =typeevenement.getText();
                
                pathimag = tfimageevent.getText();
              
                String desc = tfdescriptionevent.getText();
                Organisateur org =ocd.findorganisateurbyname(fxidorganisateur.getValue());
                int idorg = org.getId();
                Evenement EVT = new Evenement(nom,date,nbrdeparticipant,prixevent,typevent,idorg,pathimag,desc);
                idevent =ecd.ajouterEvenement(EVT);
                if (outputPath!=null){
                File outputFile = new File(outputPath);
                ImageIO.write(image, "png", outputFile);
                }
               
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../adresse/NewAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                NewAdresseController sendidevent =loader.getController();
                
                sendidevent.setidevent(idevent);
               sendidevent.setentity(entity);
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });
        importimageevent.setOnAction(event -> {
            
            
              try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NewEvent.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root,1800,850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                
                
                // Create a FileChooser object
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select an Image");
                
                // Set the initial directory to the user's home directory
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

                // Add a filter to show only image files
                fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
                );

// Show the file chooser dialog and wait for the user to select a file
File selectedFile = fileChooser.showOpenDialog(stage);
if (selectedFile != null) {
    
        // Read the selected image file into a BufferedImage object
         image = ImageIO.read(selectedFile);
       
        
        
        // Convert the BufferedImage to a JavaFX Image object
        Image fxImage = SwingFXUtils.toFXImage(image, null);
        
        // Display the image in an ImageView
        IVimage.setImage(fxImage);
        
        // Save the image to a file
        String randomString = UUID.randomUUID().toString();
         outputPath = "C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/Back/images/events/"+randomString+".png";
        tfimageevent.setText("Back/images/events/"+randomString+".png");
        
    
}
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        

            
     
           
           
    }    
    
    
    
}

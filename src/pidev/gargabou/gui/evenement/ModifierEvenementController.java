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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.services.OrganisateurCRUD;


/**
 * FXML Controller class
 *
 * @author omran
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private JFXButton btretourtoevenements;
    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btadresse;
    @FXML
    private JFXButton btorganisateur;
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
    private Button modifierevenement;
    @FXML
    private Button importimageevent;
    @FXML
    private ComboBox<String> fxidorganisateur;
    int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrganisateurCRUD ocd = new OrganisateurCRUD();
        ArrayList<Organisateur> organisateur = (ArrayList<Organisateur>) ocd.afficherOrganisateur();
        for(Organisateur org :organisateur){
            fxidorganisateur.getItems().add(org.getNomOrganisateur());
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
           
           modifierevenement.setOnAction(event -> {
            try {
                EvenementCRUD ecd = new EvenementCRUD();
                String nom =tfnomevenement.getText();
                LocalDate ldate =tfdateevenement.getValue();
                Date date = Date.from(ldate.atStartOfDay(systemDefault()).toInstant());
                int nbrdeparticipant=Integer.parseInt(tfnombreparticipant.getText());
                int prixevent =Integer.parseInt(prixevenement.getText());
                String typevent =typeevenement.getText();
                String pathimag = tfimageevent.getText();
                String desc = tfdescriptionevent.getText();
                Organisateur org =ocd.findorganisateurbyname(fxidorganisateur.getValue());
                int idorg = org.getId();
                Evenement EVT = new Evenement(nom,date,nbrdeparticipant,prixevent,typevent,idorg,pathimag,desc);
                ecd.modifierEvenement(id,EVT);
                
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
           importimageevent.setOnAction(event -> {
            
            
              try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvenement.fxml"));
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
    try {
        // Read the selected image file into a BufferedImage object
        BufferedImage image = ImageIO.read(selectedFile);
       
        
        
        // Convert the BufferedImage to a JavaFX Image object
        Image fxImage = SwingFXUtils.toFXImage(image, null);
        
        // Display the image in an ImageView
        IVimage.setImage(fxImage);
        
        // Save the image to a file
        String randomString = UUID.randomUUID().toString();
        String outputPath = "C:/Users/omran/Documents/GitHub/3a39-gargabou/public/Back/images/events/"+randomString+".png";
        File outputFile = new File(outputPath);
        tfimageevent.setText("Back/images/events/"+randomString+".png");
        ImageIO.write(image, "png", outputFile);
    } catch (IOException ex) {
        ex.getMessage();
    }
}
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
    }    
    
    
    public void setid(int id){
        this.id=id;
    }
    public void setnomevenement(String msg){
        this.tfnomevenement.setText(msg);
    }
    public void setdateevenement(LocalDate msg){
        this.tfdateevenement.setValue(msg);
    }
    public void setnmbredeparticipation(String msg){
        this.tfnombreparticipant.setText(msg);
    }
    public void setprixevenement(String msg){
        this.prixevenement.setText(msg);
    }
    public void settypeevent(String msg){
        this.typeevenement.setText(msg);
    }
    public void setimage(Image img){
        this.IVimage.setImage(img);
    }
    public void setpath(String msg){
        this.tfimageevent.setText(msg);
    }
    public void setorganisateur(String msg){
        this.fxidorganisateur.setValue(msg);
    }
    public void setdescription(String msg){
        this.tfdescriptionevent.setText(msg);
    }
    
}
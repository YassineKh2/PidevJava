/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class AjoutCentreController implements Initializable {

     @FXML
    private Button btnAjouterCentre;
    @FXML
    private TextField capacite;
    @FXML
    private ImageView imgCentre;
    @FXML
    private TextField localisationc;
    @FXML
    private TextField nomc;
    @FXML
    private TextField numrf;
    @FXML
    private Button btnClearCentre;

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private AnchorPane addCentrePane;

     @FXML
     void open_ListCentre() throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("ListCentreBack.fxml"));
         addCentrePane.getChildren().removeAll();
         addCentrePane.getChildren().setAll(fxml);
     }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private File selectedImageFile;
    private String imageName = null ;
    
    
    @FXML
    void ajouterImage() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        selectedImageFile = fileChooser.showOpenDialog(imgCentre.getScene().getWindow());
        if (selectedImageFile != null) {
            Image image = new Image(selectedImageFile.toURI().toString());
            imgCentre.setImage(image);

            // Générer un nom de fichier unique pour l'image
            String uniqueID = UUID.randomUUID().toString();
            String extension = selectedImageFile.getName().substring(selectedImageFile.getName().lastIndexOf("."));
            imageName = uniqueID + extension;

            Path destination = Paths.get(System.getProperty("user.dir"), "src", "uploads", imageName);
            Files.copy(selectedImageFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

        }
    }
    
    
   @FXML
private void AjoutCentre(ActionEvent event) throws SQLException {
    //check if not empty
    if(event.getSource() == btnAjouterCentre){
        if (capacite.getText().isEmpty() || localisationc.getText().isEmpty() || nomc.getText().isEmpty() || numrf.getText().isEmpty() ||  imageName==null) 
        {    
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information manquante");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir tous les détails concernant votre centre.");
            Optional<ButtonType> option = alert.showAndWait();
            
        } else if (numrf.getText().length() != 8) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Numéro de téléphone invalide");
            alert.setHeaderText(null);
            alert.setContentText("Le numéro de téléphone doit être de 8 chiffres.");
            Optional<ButtonType> option = alert.showAndWait();
        } else {    
            ajouterCentre();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajouté avec succès");
            alert.setHeaderText(null);
            alert.setContentText("Votre centre a été ajoutée avec succès.");
            Optional<ButtonType> option = alert.showAndWait();
            
            clearFieldsCentre();
        }
    }
    if(event.getSource() == btnClearCentre){
        clearFieldsCentre();
    }
}

    
    
    @FXML
    private void clearFieldsCentre() {
        capacite.clear();
        localisationc.clear();
        nomc.clear();
        numrf.clear();
    }
    
    
    private void ajouterCentre() throws SQLException {
        
         
        String nomCentre = nomc.getText();
        int capaciteC = Integer.parseInt(capacite.getText());
        int numero = Integer.parseInt(numrf.getText());
        String localisation = localisationc.getText();
        String imgCentre = imageName;
       
        
        DataSource db = DataSource.getInstance();
        Centre c = new Centre(
                nomCentre, capaciteC, numero, imgCentre,localisation );
        CentreService cs = new CentreService();
        cs.ajouter(c);
    }
    
}

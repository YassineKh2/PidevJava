/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private TextField fxNomCateogrie;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private ImageView fxImageCategorie;
    @FXML
    private JFXButton fxAjouterCategorieButton;
    @FXML
    private JFXButton fxAnunulerAjouteCategorieButton;
    @FXML
    private Button fxImportImageCategorie;
    @FXML
    private Label fxPathImageCateg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxAjouterCategorieButton.setOnAction(event -> {
            if (fxNomCateogrie.getText().length() < 3 || fxNomCateogrie.getText().length() > 100) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("Nom doit etre entre 10 et 100 !!");
                alert.showAndWait();
                return;
            }
            if ("".equals(fxNomCateogrie.getText().length()) ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("Nom non valide !!");
                alert.showAndWait();
                return;
            }
            
            try {
                String nom = fxNomCateogrie.getText();
                ServiceCategorie sp = new ServiceCategorie();
                String Path = fxPathImageCateg.getText();
                Categorie Categ = new Categorie(nom, Path);
                sp.ajouter(Categ);
                
                
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });

        fxImportImageCategorie.setOnAction(event -> {
          
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorie.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
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
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
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
        fxImageCategorie.setImage(fxImage);
        
        // Save the image to a file
        String randomString = UUID.randomUUID().toString();
        String outputPath = "C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/Back/images/CategorieImages/"+randomString+".jpg";
        File outputFile = new File(outputPath);
        fxPathImageCateg.setText("Back/images/CategorieImages/"+randomString+".jpg");
        ImageIO.write(image, "jpg", outputFile);
    } catch (IOException ex) {
        ex.getMessage();
    }
}
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        

    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class ModiferCategorieController implements Initializable {

    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private TextField fxNomCateogrie;
    @FXML
    private Button fxModiferCategorieButton;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private ImageView fxImageCategorie;
    @FXML
    private JFXButton fxAnunulerCategorieButton1;
    @FXML
    private Button fxImpoterImageCategorieModify;
    @FXML
    private Label fxPathImageCategModif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxModiferCategorieButton.setOnAction( event -> {
            
            try {
                String NomCateg = fxNomCateogrie.getText();
                String id = fxIdCategorie.getText();
                int IdCateg = Integer.parseInt(id);
                ServiceCategorie sp = new ServiceCategorie();
                Categorie Categ = sp.FindOne(IdCateg);
                String Path = fxPathImageCategModif.getText();
                Categorie NewCateg = new Categorie(IdCateg,NomCateg,Path,Categ.getArticles());
                sp.modifier(NewCateg);
                
                
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
       fxAnunulerCategorieButton1.setOnAction( event -> {
            try {
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
       
       fxImpoterImageCategorieModify.setOnAction( event -> {
           
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
        System.out.println("this is selected file :"+selectedFile);
        
        
        // Convert the BufferedImage to a JavaFX Image object
        Image fxImage = SwingFXUtils.toFXImage(image, null);
        
        // Display the image in an ImageView
        fxImageCategorie.setImage(fxImage);
        
        // Save the image to a file
        String randomString = UUID.randomUUID().toString();
        String outputPath = "C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/Back/images/CategorieImages/"+randomString+".png";
        File outputFile = new File(outputPath);
        System.out.println(outputPath);
        System.out.println(randomString+".png");
        fxPathImageCategModif.setText("Back/images/CategorieImages/"+randomString+".png");
        
        ImageIO.write(image, "png", outputFile);
        System.out.println("this is the image: "+image);
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
    
    public void setNomCategorie(String message){
        this.fxNomCateogrie.setText(message);
    }
    public void setIdCategorie(String message){
        this.fxIdCategorie.setText(message);
    }
    public void setImageCategorie(Image img){
        this.fxImageCategorie.setImage(img);
    }
    public void setImagePath(String message){
        this.fxPathImageCategModif.setText(message);
    }
}

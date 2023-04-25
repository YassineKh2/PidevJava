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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceArticles;
import pidev.gargabou.services.ServiceCategorie;
/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AjouterArticleController implements Initializable {

    @FXML
    private JFXButton fxAjouterCategorie;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton fxGoToArticle;
    @FXML
    private TextField fxNomArticle;
    @FXML
    private TextField fxQuantiteArticle;
    @FXML
    private TextField fxPrixArticle;
    @FXML
    private TextArea fxDescriptionArticle;
    @FXML
    private TextField fxRemiseArticle;
    @FXML
    private JFXButton fxAjouterArticle;
    @FXML
    private JFXButton fxAnnulerArticle;
    @FXML
    private ComboBox<String> fxIdCategorieArticle;
    @FXML
    private Button fxImporterImageArticle;
    @FXML
    private ImageView fxImagevViewArticle;
    @FXML
    private Label fxPathImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceCategorie sp = new ServiceCategorie();
         ArrayList<Categorie> Categ = (ArrayList<Categorie>) sp.getAll();
         for(Categorie Cat : Categ)
         {
         fxIdCategorieArticle.getItems().add(Cat.getNomCategorie());
         }
         
         
        fxAjouterArticle.setOnAction( event -> {
            
            if (fxDescriptionArticle.getText().length() < 20 || fxDescriptionArticle.getText().length() > 1000) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("La discription doit etre entre 20 et 100 !!");
                alert.showAndWait();
                return;
            }
            
         try{
            Float Prix = Float.parseFloat(fxPrixArticle.getText());
              if (Prix < 0 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("Le prix doit etre positive !!");
                alert.showAndWait();
                return;
            }
         }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid !");
                alert.setContentText("Le prix est invalide !!");
                alert.showAndWait();
                return;
            }
        try{
             int Quantite = Integer.parseInt(fxQuantiteArticle.getText());
              if (Quantite < 0 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("La Quantite doit etre positive !!");
                alert.showAndWait();
                return;
            }
         }catch(NumberFormatException  ex){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid !");
                alert.setContentText("La Quantite est invalide !!");
                alert.showAndWait();
                return;
            }
        
         if (fxNomArticle.getText().length() < 3 || fxNomArticle.getText().length() > 100) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Invalid Length");
                alert.setContentText("Le nom doit etre entre 3 et 100 !!");
                alert.showAndWait();
                return;
            }
        
        
        
           try {
               String NomArticle = fxNomArticle.getText();
               int Quantite = Integer.parseInt(fxQuantiteArticle.getText());
               Float Prix = Float.parseFloat(fxPrixArticle.getText());
               String CateogireSelected = fxIdCategorieArticle.getValue();
               String DescriptionArticle = fxDescriptionArticle.getText();
               String ImageArticle = fxPathImage.getText();
               Float resmise = Float.parseFloat(fxRemiseArticle.getText());
               Categorie Catego = sp.FindCategorieByName(CateogireSelected);
               int IdCateg = Catego.getId();
               
               Article Arc = new Article(IdCateg,NomArticle,Prix,Quantite,ImageArticle,DescriptionArticle,resmise,0);
               ServiceArticles Sa = new ServiceArticles();
               Sa.ajouter(Arc);
               
               /*ArrayList<Article> Article = Catego.getArticles();
               Article.add(Arc);
               Catego.setArticles(Article);*/
               
               
               FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeArticle.fxml"));
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
        
        fxImporterImageArticle.setOnAction(event -> {
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
        fxImagevViewArticle.setImage(fxImage);
        
        // Save the image to a file
        String randomString = UUID.randomUUID().toString();
        String outputPath = "C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/Back/images/CategorieImages/"+randomString+".jpg";
        File outputFile = new File(outputPath);
        fxPathImage.setText("Back/images/CategorieImages/"+randomString+".jpg");
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

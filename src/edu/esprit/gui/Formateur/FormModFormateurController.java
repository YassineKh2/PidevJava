/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui.Formateur;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.services.ServicesFormateur;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormModFormateurController implements Initializable {

    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private TextField tx_nom_formateur;
    @FXML
    private JFXButton btn_mod_formateur;
    private TextField tx_image_fm;
    @FXML
    private TextField tx_pn_formateur;
    @FXML
    private JFXTextArea tx_email;
    @FXML
    private JFXRadioButton tx_male;
    @FXML
    private JFXRadioButton tx_female;
    @FXML
    private JFXTextArea tx_num;
    @FXML
    private ImageView img_frmteur;
    @FXML
    private Label fxPath_img;
    @FXML
    private JFXButton fx_import;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        for(Formateur f:formateur){
            
            if(Formateur.getChamp_id_formateur()==f.getId()){
                Image img_f = new Image("file:/C:/Users/MsiAs/Desktop/ProjIng/public/"+f.getImageFormateur(), true);
                img_frmteur.setImage(img_f);
                tx_nom_formateur.setText(f.getNomFormateur());
                tx_pn_formateur.setText(f.getPrenomFormateur());
                tx_email.setText(f.getEmailFormateur());
                if(f.getSexeFormateur().equals("Masculin") || f.getSexeFormateur().equals("1") ){
                   tx_male.setSelected(true);
                }
                else {
                    tx_female.setSelected(true);
                }
                fxPath_img.setText(f.getImageFormateur());
                tx_num.setText(Integer.toString(f.getNumTelFormateur()));}
                
        }
        fx_import.setOnAction(e->{
            try {
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("formModFormateur.fxml"));
                Parent root = loader1.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) e.getSource(); // get the source node of the current event
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
                img_frmteur.setImage(fxImage);
                    
                // Save the image to a file
                String randomString = UUID.randomUUID().toString();
                String outputPath = "C:/Users/MsiAs/Desktop/ProjIng/public/Front/formateur/images/"+randomString+".jpg";
                File outputFile = new File(outputPath);
                fxPath_img.setText("Front/formateur/images/"+randomString+".jpg");
                ImageIO.write(image, "jpg", outputFile);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
        });
        btn_mod_formateur.setOnAction(e ->{
            String nom = tx_nom_formateur.getText();
            String img= fxPath_img.getText();
            String prenom = tx_pn_formateur.getText();
            String email =tx_email.getText();
            int num=Integer.parseInt(tx_num.getText());
            String sexe = null;
            
            if (tx_male.isSelected()) {
                    sexe = tx_male.getText();
                    
                    // Do something with the selected value...
                };
            
            if (tx_female.isSelected()) {
                    sexe = tx_female.getText();
            }
            Formateur f_up = new Formateur(Formateur.getChamp_id_formateur(),nom, prenom, sexe, email, num, img);
                    sfm.modifier(f_up);
                    Label conf=new Label();
                    conf.setText("Formateur bien ajouté");
                    conf.setLayoutX(174);
                    conf.setLayoutY(609);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);
        });
    }
    }    
    


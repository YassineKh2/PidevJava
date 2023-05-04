/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import pidev.gargabou.services.PublicationService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import pidev.gargabou.entites.Publication;
import pidev.gargabou.services.EnvoyerEmail;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AddPublicationController implements Initializable {

    @FXML
    private JFXTextArea taContenuPup;
    @FXML
    private Button btnImportPubImg;
    @FXML
    private JFXButton btnAjouterPub;
    @FXML
    private ImageView fxImgPub;
    @FXML
    private Label fxPathImgPub;
    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void addPublication(ActionEvent event) throws SQLException, MessagingException {
        try {
                PublicationService ps = new PublicationService();
                if(taContenuPup.getText().isEmpty() || fxPathImgPub.getText().isEmpty() ){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Champ vide");
                            alert.setHeaderText("Vous pouvez pas publier une publication vide!");
                            alert.showAndWait();
                            // return to current dialog
                }else{
                String contenuPub = taContenuPup.getText();
                Date datePup = new Date();
                String Path = fxPathImgPub.getText();
                Publication pub = new Publication(3,datePup,contenuPub, Path);
                ps.ajouter(pub);
                /////mailing
                //sendEmail(emailUser, contenuPub );
                
                ///////
                FXMLLoader loader = new FXMLLoader(getClass().getResource("IAPublication.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation");
                            alert.setHeaderText("Publication ajouter!");
                            alert.showAndWait();} // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        
    }

    @FXML
    private void importPubImage(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPublication.fxml"));
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
                        fxImgPub.setImage(fxImage);

                        // Save the image to a file
                        String randomString = UUID.randomUUID().toString();
                        String outputPath = "C:/Users/Anas/Desktop/ProjIng/public/Back/images/forum/" + randomString + ".jpg";
                        File outputFile = new File(outputPath);
                        fxPathImgPub.setText("Back/images/forum/" + randomString + ".jpg");
                        boolean write;
                        write = ImageIO.write(image, "jpg", outputFile);
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
    }

    
//   public void sendEmail( String email, String contenu) throws MessagingException {
//    
//            
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Congrats");
//            alert.setHeaderText("we just send u an email");
//            alert.setContentText("Please check your e-mail box");
//            alert.show();
//            
//            
//            EnvoyerEmail.envoyer(email,contenu);
//            
//        
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import pidev.gargabou.entites.Publication;
import pidev.gargabou.services.PublicationService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class ModifierPublicationController implements Initializable {

    @FXML
    private JFXTextArea taContenuPup;
    @FXML
    private Button btnImportPubImg;
    @FXML
    private ImageView fxImgPub;
    @FXML
    private Label fxPathImgPub;
    @FXML
    private JFXButton btnModifierPub;
    @FXML
    private Label fxIdPub;
    @FXML
    private Label dxDatePub;
    private int idpub;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void importPubImage(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierPublication.fxml"));
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
                        System.out.println("this is selected file :" + selectedFile);

                        // Convert the BufferedImage to a JavaFX Image object
                        Image fxImage = SwingFXUtils.toFXImage(image, null);

                        // Display the image in an ImageView
                        fxImgPub.setImage(fxImage);

                        // Save the image to a file
                        String randomString = UUID.randomUUID().toString();
                        String outputPath = "C:/Users/Anas/Desktop/ProjIng/public/Back/images/forum/" + randomString + ".png";
                        File outputFile = new File(outputPath);
                        System.out.println(outputPath);
                        System.out.println(randomString + ".png");
                        fxPathImgPub.setText("Back/images/CategorieImages/" + randomString + ".png");

                        ImageIO.write(image, "png", outputFile);
                        System.out.println("this is the image: " + image);
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
    }

    @FXML
    private void modifierPub(ActionEvent event) throws SQLException {
        try {
                if(taContenuPup.getText().isEmpty()){
                    
                Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Champ vide");
                            alert.setHeaderText("Vous pouvez pas publier une publication vide!");
                            alert.showAndWait();
                 }
                else{
                String contenuPub = taContenuPup.getText();
                String Path = fxPathImgPub.getText();

                PublicationService ps = new PublicationService();
                Publication newPub = new Publication( contenuPub, Path, idpub);
                ps.modifier(newPub);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("IAPublication.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("confirm");
                            alert.setHeaderText("modifie");
                            alert.showAndWait();
                
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    public void setContenuPublication(String message) {
        this.taContenuPup.setText(message);
    }

    public void setIdPublication(int id) {
        this.idpub =id;
    }

    public void setImagePublication(Image img) {
        this.fxImgPub.setImage(img);
    }

    public void setImagePath(String message) {
        this.fxPathImgPub.setText(message);
    }
}

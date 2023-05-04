/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Formation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import pidev.gargabou.entites.Formateur;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.services.ServicesFormateur;
import pidev.gargabou.services.ServicesFormation;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormAjouterController implements Initializable {

    @FXML
    private MenuButton values_formateur;
    @FXML
    private TextField tx_nom_formation;
    @FXML
    private JFXTextArea tx_description;
    @FXML
    private Spinner<Integer> values_niveau;
    @FXML
    private JFXButton btn_ajout_formation;
    
    @FXML
    private AnchorPane whole_form_scene;
    @FXML
    private Label label_error;
    private Label Controle;
    @FXML
    private Label ct_nom;
    @FXML
    private ImageView img_frmtion;
    @FXML
    private Label fxPath_img;
    @FXML
    private JFXButton fx_import;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServicesFormation sf = new ServicesFormation();
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        for(Formateur fm:formateur){
            MenuItem item = new MenuItem(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Create a MenuItem with formateur's name
            item.setOnAction(event -> {
            values_formateur.setText(fm.getNomFormateur()+ " " + fm.getPrenomFormateur()); // Set the selected formateur's name as the text of MenuButton
                });
            values_formateur.getItems().add(item);
        }
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        values_niveau.setValueFactory(valueFactory);
        
        fx_import.setOnAction(e ->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formAjouter.fxml"));
                Parent root = loader.load(); // load the new FXML file
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
                img_frmtion.setImage(fxImage);
                    
                // Save the image to a file
                String randomString = UUID.randomUUID().toString();
                String outputPath = "file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+randomString+".jpg";
                File outputFile = new File(outputPath);
                fxPath_img.setText("Front/formation/images/"+randomString+".jpg");
                ImageIO.write(image, "jpg", outputFile);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
        });
        btn_ajout_formation.setOnMouseClicked(e ->{
            
            String nom = tx_nom_formation.getText();
            String img= fxPath_img.getText();
            String desc = tx_description.getText();
            String fmr = values_formateur.getText();
            int nv=values_niveau.getValue();
            check_fields();
            if(check_fields()==true){
            for(Formateur fm:formateur){
                if(fmr.equals(fm.getNomFormateur()+ " " + fm.getPrenomFormateur())){
                    Formation f_aj= new Formation(nom,nv,fm.getId(),img,desc);
                    sf.ajouter(f_aj);
                    label_error.setVisible(false);
                    Label conf=new Label();
                    conf.setText("Formation bien ajouté");
                    conf.setLayoutX(174);
                    conf.setLayoutY(609);
                    conf.setPrefHeight(26);
                    conf.setPrefWidth(192);
                    conf.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
                    whole_form_scene.getChildren().add(conf);
                    
                }}}
                
        });
     
    }
    public boolean check_fields(){
        String nom = tx_nom_formation.getText();
        String img= fxPath_img.getText();
        String desc = tx_description.getText();
        String fmr = values_formateur.getText();
        int nv=values_niveau.getValue();
        
        if(nom.isEmpty()|| img.isEmpty() || desc.isEmpty()|| fmr.isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Confirmation");
                alert.setHeaderText("tu dois remplir tous les champs");
                Optional<ButtonType> result = alert.showAndWait();
                return false;
                
        }
        
        else if(desc.length()<20){
            label_error.setStyle("-fx-background-color: red; -fx-font-weight: bold;");
            label_error.setText("la description doit contient 20 caracteres au min");
            label_error.setLayoutX(174);
            label_error.setLayoutY(609);
            label_error.setPrefWidth(350);
            whole_form_scene.getChildren().add(label_error);
            return false;
        }
        else{
            return true;
        }
    }

    @FXML
    private void ControleNumbers(KeyEvent event) {
    }
}

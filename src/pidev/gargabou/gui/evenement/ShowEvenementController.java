/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.ZoneId.systemDefault;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.services.ServiceMetier;
//import com.esri.arcgisruntime.mapping.view.MapView;

/**
 * FXML Controller class
 *
 * @author omran
 */
public class ShowEvenementController implements Initializable {

    @FXML
    private JFXButton btretour;
    @FXML
    private JFXButton btevenement;
    @FXML
    private JFXButton btadresse;
    @FXML
    private JFXButton btorganisateur;
    @FXML
    private ImageView bigimageevenement;
    @FXML
    private Label fxnomevenement;
    @FXML
    private JFXButton btparticiper;
    @FXML
    private Label fxplacesrestantes;
    @FXML
    private Label fxdateevenement;
    @FXML
    private JFXButton btlike;
    @FXML
    private Label fxtypeevenement;
    @FXML
    private Label fxadresse;
    @FXML
    private Label fxnumrue;
    @FXML
    private Label fxnomrue;
    @FXML
    private Label fxprix;
    @FXML
    private Label fxcodepostal;
    @FXML
    private Label fxgovernorat;
    @FXML
    private JFXTextArea fxdescription;
   
    @FXML
    private Label fxorganisateur;
    @FXML
    private Label fxnumberoflikes;
    int ide;
    int idu=1;
    boolean isliked;
    boolean isparticipated;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
            
       
        btlike.setOnAction( event -> {
            ServiceMetier sm = new ServiceMetier();
           isliked=sm.isLiked(idu, ide);
            if(!isliked){
                sm.addlike(idu, ide); 
                btlike.setButtonType(JFXButton.ButtonType.FLAT);
            }else{
                sm.deleteLike(idu, ide);
                 btlike.setButtonType(JFXButton.ButtonType.RAISED);
            }
            int nblkes = sm.countLikes(ide);
            String Snblkes= String.valueOf(nblkes);
            setnumberoflikes(Snblkes);
           
           
        });
        
        btparticiper.setOnAction( event -> {
               ServiceMetier sm = new ServiceMetier();
             int nbplce = sm.countparticip(ide);
             if (nbplce<1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" pas de places restantes");
                alert.setContentText("pas de places restantes!!");
                alert.showAndWait();
                return;
            }
           
            isparticipated=sm.isparticipated(idu, ide);
            if(!isparticipated){
                sm.addparticip(idu, ide); 
            }else{
                sm.deleteparticip(idu, ide);
            }
             nbplce = sm.countparticip(ide);
            String Snbplce= String.valueOf(nbplce);
            setplacesrestantes(Snbplce);
           
        });
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
        
        
        
           btretour.setOnAction( event -> {
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
         

    }    
    public void setidevent(int id){
        this.ide=id;
    }
    public void setnomevenement(String msg){
        this.fxnomevenement.setText(msg);      
    }  
    public void setdateevenement(String msg){
        this.fxdateevenement.setText(msg);
    } 
    public void setprixevenement(String msg){
        this.fxprix.setText("à "+ msg +"$");
    }
    public void settypeevent(String msg){
        this.fxtypeevenement.setText(msg);
    }
    public void setimage(Image img){
        this.bigimageevenement.setImage(img);
    }
    
    public void setorganisateur(String msg){
        this.fxorganisateur.setText(msg);
    }
    public void setdescription(String msg){
        this.fxdescription.setText(msg);
    }
    public void setplacesrestantes(String msg){
        this.fxplacesrestantes.setText(msg + " places restantes");
                
    }
    public void setnomrue(String msg){
        this.fxnomrue.setText(msg);
    }
    public void setnumrue(String msg){
        this.fxnumrue.setText(msg);
    }
    public void setcodepostal(String msg){
        this.fxcodepostal.setText(msg);
    }
    public void setgovernorat(String msg){
        this.fxgovernorat.setText(msg);
    }
    public void setnumberoflikes(String msg){
        this.fxnumberoflikes.setText(msg+"personnes aime ça");
    }
}

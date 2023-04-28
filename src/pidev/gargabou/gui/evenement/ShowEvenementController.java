/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.evenement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import java.net.URL;
import java.time.LocalDate;
import static java.time.ZoneId.systemDefault;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javafx.scene.layout.Pane;
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.services.ServiceMetier;
//import com.esri.arcgisruntime.mapping.view.MapView;

import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.teamdev.jxmaps.swing.MapView;

import com.teamdev.jxmaps.*;


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
    int idu = 1;
    boolean isliked;
    boolean isparticipated;
    @FXML
    private Pane mappane;
      private static Map map;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btlike.setOnAction(event -> {
            ServiceMetier sm = new ServiceMetier();
            isliked = sm.isLiked(idu, ide);
            if (!isliked) {
                sm.addlike(idu, ide);
                btlike.setButtonType(JFXButton.ButtonType.FLAT);
            } else {
                sm.deleteLike(idu, ide);
                btlike.setButtonType(JFXButton.ButtonType.RAISED);
            }
            int nblkes = sm.countLikes(ide);
            String Snblkes = String.valueOf(nblkes);
            setnumberoflikes(Snblkes);

        });

        btparticiper.setOnAction((ActionEvent event) -> {
            ServiceMetier sm = new ServiceMetier();
            int nbplce = sm.countparticip(ide);
            if (nbplce < 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" pas de places restantes");
                alert.setContentText("pas de places restantes!!");
                alert.showAndWait();
                return;
            }

            isparticipated = sm.isparticipated(idu, ide);
            if (!isparticipated) {
                sm.addparticip(idu, ide);
                sendmail();
            } else {
                sm.deleteparticip(idu, ide);
            }
            nbplce = sm.countparticip(ide);
            String Snbplce = String.valueOf(nbplce);
            setplacesrestantes(Snbplce);

        });
        btorganisateur.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../organisateur/HomeOrganisateur.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root, 1800, 850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });
        btevenement.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root, 1800, 850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });
        btadresse.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../adresse/HomeAdresse.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root, 1800, 850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });

        btretour.setOnAction(event -> {
            try { 
                

  
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEvenement.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root, 1800, 850); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });

    }
//    public void map(){
//        setOnMapReadyHandler(new MapReadyHandler() {
//			@Override
//			public void onMapReady(MapStatus status) {
//				// Check if the map is loaded correctly
//				if (status == MapStatus.MAP_STATUS_OK) {
//					// Getting the associated map object
//					map = getMap();
//					MapOptions mapOptions = new MapOptions();
//					MapTypeControlOptions controlOptions = new MapTypeControlOptions();
//					controlOptions.setPosition(ControlPosition.BOTTOM_LEFT);
//					mapOptions.setMapTypeControlOptions(controlOptions);
//					
//					map.setOptions(mapOptions);
//					map.setCenter(new LatLng(36.901107, 10.19012));
//					map.setZoom(10);
//                            System.out.print("Wait until map is generated");
//				}
//			}
//		});
//    }

    public void setidevent(int id) {
        this.ide = id;
    }

    public void setnomevenement(String msg) {
        this.fxnomevenement.setText(msg);
    }

    public void setdateevenement(String msg) {
        this.fxdateevenement.setText(msg);
    }

    public void setprixevenement(String msg) {
        this.fxprix.setText("à " + msg + "$");
    }

    public void settypeevent(String msg) {
        this.fxtypeevenement.setText(msg);
    }

    public void setimage(Image img) {
        this.bigimageevenement.setImage(img);
    }

    public void setorganisateur(String msg) {
        this.fxorganisateur.setText(msg);
    }

    public void setdescription(String msg) {
        this.fxdescription.setText(msg);
    }

    public void setplacesrestantes(String msg) {
        this.fxplacesrestantes.setText(msg + " places restantes");

    }

    public void setnomrue(String msg) {
        this.fxnomrue.setText(msg);
    }

    public void setnumrue(String msg) {
        this.fxnumrue.setText(msg);
    }

    public void setcodepostal(String msg) {
        this.fxcodepostal.setText(msg);
    }

    public void setgovernorat(String msg) {
        this.fxgovernorat.setText(msg);
    }

    public void setnumberoflikes(String msg) {
        this.fxnumberoflikes.setText(msg + "personnes aime ça");
    }

    public void sendmail() {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            String username = "rehabradar123@gmail.com";
            String password = "kglifegaigjdcdix";

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rehabradar123@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("omrankhadraoui@gmail.com"));
            message.setSubject("HTML Email Example");
            String htmlContent = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "    <title>participation</title>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <style>\n"
                    + "        body {\n"
                    + "            font-family: Arial, sans-serif;\n"
                    + "            font-size: 14px;\n"
                    + "            line-height: 1.5;\n"
                    + "            color: #333;\n"
                    + "            margin: 0;\n"
                    + "            padding: 0;\n"
                    + "        }\n"
                    + "        .container {\n"
                    + "            max-width: 600px;\n"
                    + "            margin: 0 auto;\n"
                    + "            padding: 20px;\n"
                    + "            background-color: #f7f7f7;\n"
                    + "            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n"
                    + "        }\n"
                    + "        h1 {\n"
                    + "            font-size: 24px;\n"
                    + "            margin-bottom: 20px;\n"
                    + "        }\n"
                    + "        table {\n"
                    + "            width: 100%;\n"
                    + "            border-collapse: collapse;\n"
                    + "            margin-bottom: 20px;\n"
                    + "        }\n"
                    + "        table th {\n"
                    + "            font-weight: bold;\n"
                    + "            background-color: #eee;\n"
                    + "            padding: 10px;\n"
                    + "            text-align: left;\n"
                    + "            border-bottom: 2px solid #ccc;\n"
                    + "        }\n"
                    + "        table td {\n"
                    + "            padding: 10px;\n"
                    + "            border-bottom: 1px solid #ccc;\n"
                    + "        }\n"
                    + "        .total {\n"
                    + "            font-weight: bold;\n"
                    + "            font-size: 18px;\n"
                    + "            margin-top: 20px;\n"
                    + "            text-align: right;\n"
                    + "        }\n"
                    + "    </style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<div class=\"container\">\n"                                      
                    + "    <a href=\"http://127.0.0.1:8000/index\" class=\"logo me-auto\"><img src=\"C:\\Users\\omran\\Documents\\GitHub\\3a39-gargabou\\public\\{{ asset('Front/img/logo.png') }}\" alt=\"\" class=\"img-fluid\" style=\"height: 100px; width: 100px\"> <h1 class=\"logo me-auto\"><a href=\"#\">Rehab Radar</a></h1></a>\n"
                    + "    <h1>A propos de l'evenement</h1>\n"
                    + "    <table>\n"
                    + "        <thead>\n"
                    + "        <tr>\n"
                    
                    + "        </tr>\n"
                    + "        </thead>\n"
                    + "        <tbody>\n";
           

      
            message.setContent(htmlContent, "text/html");
            Transport.send(message);
            System.out.println("HTML email sent successfully");

        } catch (MessagingException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

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
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.userCRUD;
import pidev.gargabou.utils.passwordHasher;


/**
 * FXML Controller class
 *
 * @author alisl
 */
public class InscriPController implements Initializable {
       @FXML
    private ImageView ela;
   @FXML
    private Button bchoix;

    @FXML
    private Hyperlink blogin;

    @FXML
    private Button sinscri;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField tf_mdp;

    @FXML
    private PasswordField tf_mdp1;

    @FXML
    private TextField tf_nom;

    @FXML
    private TextField tf_num;

    @FXML
    private TextField tf_prenom;

    @FXML
    private TextField tf_psuedo;
    
    
    @FXML
    private Label fxPathImage;

    /**
     * Initializes the controller class.
     */
      public static void sendemail() throws AddressException, MessagingException {
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
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("alislimia01@gmail.com"));
                message.setSubject("compte creer");
                String htmlContent = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <title>votre comte a etait creer</title>\n"
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
                        + "    <a>Rehab Radar</a></h1></a>\n"
                        + "    <h1>votre comte a etait creer</h1>\n"
                
                   
                        + "\n"
                        + "</div>\n"
                        + "<div class=\"container\">\n"
                        + "    <h1>Merci</h1>\n"
                        + "    <p>Cher(e) Utilisateur,</p>\n"
                        + "    <p>Je voulais simplement prendre un moment pour vous remercier d'avoir rejoint notre application. Nous sommes ravis de vous avoir parmi nous et nous espérons que vous trouverez notre plateforme utile et agréable à utiliser.\n" +
"\n" +
"Si vous avez des questions ou des commentaires, n'hésitez pas à nous contacter à tout moment. Nous sommes là pour vous aider et nous apprécions vos commentaires.\n" +
"\n" +
"Merci encore pour votre confiance en nous et pour votre soutien. Nous avons hâte de vous aider à atteindre vos objectifs grâce à notre application.\n" +
"\n" +
"Cordialement,\n" +
"[L'équipe de l'application]</p>\n"
                       
                        + "    <div class=\"signature\">Cordialement,<br>RehabRadar</div>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "</html>\n"
                        + "\n";
                message.setContent(htmlContent, "text/html");
                Transport.send(message);
                System.out.println("HTML email sent successfully");
            }

    @FXML
    private Button addEmployee_importBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void switchtologin(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private Stage stage1;
    private Scene scene1;
    private Parent root1;

        @FXML
    void showpass(MouseEvent event) {
  tf_mdp.setPromptText(tf_mdp.getText());
                tf_mdp.setText("");
    }

         @FXML
    void hidepass(MouseEvent event) {
 tf_mdp.setText(tf_mdp.getPromptText());
                tf_mdp.setPromptText("");
    }
     @FXML
    private void switchtochoix(ActionEvent event) throws IOException {
        root1=FXMLLoader.load(getClass().getResource("choix.fxml"));
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene1= new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }
   

    
    @FXML
    private void ajouterpatient(ActionEvent event) throws IOException, MessagingException {
        
        String nom = tf_nom.getText();
        String prenom = tf_prenom.getText();
        String email = tf_email.getText();
        String password = tf_mdp.getText();
        String PseudoUtilisateur = tf_psuedo.getText();
        String numero = tf_num.getText();
        String role = "[\"ROLE_PATIENT\"]";
        String cpass = tf_mdp1.getText();
        String hashedPassword = passwordHasher.hashPassword(password);
        String image = fxPathImage.getText();
        int fill= 0;
    
            if (nom.isEmpty()||prenom.isEmpty()||email.isEmpty()||PseudoUtilisateur.isEmpty()||password.isEmpty()||cpass.isEmpty()||numero.isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(" form pas remply");
                alert.setContentText("veuiller remplir tous les collones");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            


          
            }else{
                if (!nom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Nom Invalid");
                alert.setContentText("entrer un nom valid");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
              if (!prenom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Prenom Invalid");
                alert.setContentText("entrer un prenom valid");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
                if (!numero.matches("([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("numero Invalid");
                alert.setContentText("entrer un numero valid(8)");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
              
           
               if (!password.equals(cpass)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Password Invalid");
                alert.setContentText("Utiliser la meme Passwords");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
               if (password.length()<6){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Password Invalid");
                alert.setContentText("Utiliser un Passwordsde 6 charachtere");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
               if (!password.matches("^(?=.*[0-9])(?=.*[A-Z]).+$")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(" Password Invalid");
                alert.setContentText("Mot De passe doit avoir une lettre majuscule et un nombre");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
                 if (!email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(" Email Invalid");
                alert.setContentText("enterr un Email valid : example@email.com");
                 alert.setHeaderText(null);
                alert.showAndWait();
                return;}
   
               else{  Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setContentText("compte creer");
                alert.setHeaderText(null);
                alert.showAndWait();
          sendemail();
                   
               }
  
            }
 
             
        User u =new User(email,hashedPassword,role,nom,prenom,numero,PseudoUtilisateur,image,fill);
        userCRUD ucd =new userCRUD() ;
        ucd.ajouter(u);
         root1=FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene1= new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
         
    }
    
   @FXML
    void importimgP(ActionEvent event){
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
                ela.setImage(fxImage);
                
                // Save the image to a file
                String randomString = UUID.randomUUID().toString();
                String outputPath = "C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/uploads/"+randomString+".jpg";
                File outputFile = new File(outputPath);
                fxPathImage.setText("src\\img"+randomString+".jpg");
                ImageIO.write(image, "jpg", outputFile);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        }
  
}



    

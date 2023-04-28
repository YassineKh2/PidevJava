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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.userCRUD;
import pidev.gargabou.utils.DataSource;
import pidev.gargabou.utils.passwordHasher;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class HomeFController implements Initializable {
      @FXML
    private Label path;
      
    @FXML
    private Label path1;


    @FXML
    private AnchorPane profileDETAIL1;

    @FXML
    private Label getemailT;

    @FXML
    private Label getlicT;

    @FXML
    private Label getnomT;

    @FXML
    private Label getnumt;

    @FXML
    private Label getprenomT;

    @FXML
    private Label getrolet;

    @FXML
    private Label getspecialiteT;

    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lblNom;
    @FXML
    private Label lblPreom;

    @FXML
    private Label lblRole;

    @FXML
    private Label GETMAIL;

    @FXML
    private Label GETNOM;

    @FXML
    private Label GETNUM;

    @FXML
    private Label GETPRENOM;

    @FXML
    private Label GETPSUDO;

    @FXML
    private Label GETROLE;

    @FXML
    private AnchorPane profileDETAIL;

    @FXML
    private JFXButton profileshow;
    @FXML
    private AnchorPane profile;
    @FXML
    private Button detailBTN;

    @FXML
    private TextField eemail;

    @FXML
    private TextField elicence;

    @FXML
    private TextField enom;

    @FXML
    private TextField enumuro;

    @FXML
    private TextField eprenom;

    @FXML
    private TextField erole;

    @FXML
    private TextField espec;
    @FXML
    private AnchorPane profileedit;
    @FXML
    private Button editBTN;
    @FXML
    private Button editBTN1;
    @FXML
    private TextField eemail1;

    @FXML
    private TextField editrole1;

    @FXML
    private TextField enom1;

    @FXML
    private TextField enumuro1;
    @FXML
    private TextField eprenom1;

    @FXML
    private TextField epsudo1;

    @FXML
    private AnchorPane profileedit1;
@FXML
    private ImageView imageuser;
   @FXML
    private ImageView detailpatpic;

    @FXML
    private ImageView detailtherpic;
      @FXML
    private ImageView ela;
      @FXML
    private ImageView elp;
      @FXML
      private ImageView virif;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        profile.setVisible(false);
        profileDETAIL.setVisible(false);
        profileDETAIL1.setVisible(false);
        profileedit.setVisible(false);
        profileedit1.setVisible(false);
    }

    @FXML
    private JFXButton logout;

    private DataSource connect = DataSource.getInstance();
    private Alert alert;
    private ResultSet result;
//hadhy ta3 profile generale

    public void info() throws SQLException {
        String query = "SELECT * FROM user WHERE  id = ? ";

        PreparedStatement ps = connect.getCnx().prepareStatement(query);
        int id = userNow.getid();
        
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String name = rs.getString("nom"); // retrieve the name from the result set
            String prenom = rs.getString(6); // retrieve the name from the result set
            String role = rs.getString("roles");
            int st =rs.getInt("approve");
            Image img1 = new Image("file:C:/Users/alisl/Documents/aha/pidev/src/img/green_eco_loop_leaf_check_mark.jpg");
             Image img2 = new Image("file:C:/Users/alisl/Documents/aha/pidev/src/img/eye (1).png");
            if (role.contains("ROLE_PATIENT")) {
                lblRole.setText("Patient");

            } else {
                lblRole.setText("Therapist");
            }
            if(st==1){virif.setImage(img1);
            
            }else {
            virif.setImage(img2);
            }
            Image img = new Image("file:C:/Users/alisl/Desktop/pics/"+rs.getString("image"), true);
            imageuser.setImage(img);
            lblNom.setText(name); // set the label text to the retrieved name
            lblPreom.setText(prenom); // set the label text to the retrieved name

        }

        rs.close(); // close the result set
        ps.close(); // close the prepared statement

    }
//hadhy ta3 detail

    public void infoD() throws SQLException {
        String query = "SELECT * FROM user WHERE  id = ? ";

        PreparedStatement ps = connect.getCnx().prepareStatement(query);
        int id = userNow.getid();
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String name = rs.getString("nom"); // retrieve the name from the result set
            String prenom = rs.getString(6); // retrieve the name from the result set
            String role = rs.getString("roles");
            String email = rs.getString("email");
            String num = rs.getString("numero");
            String psudo = rs.getString("PseudoUtilisateur");
            Image img = new Image("file:C:/Users/alisl/Desktop/pics/"+rs.getString("image"), true);
           
            if (role.contains("ROLE_PATIENT")) {
                profileDETAIL.setVisible(true);
                profileDETAIL1.setVisible(false);
                GETROLE.setText("Patient");
                GETMAIL.setText(email);
                GETNOM.setText(name);
                GETNUM.setText(num);
                GETPRENOM.setText(prenom);
                GETPSUDO.setText(psudo);

detailtherpic.setImage(img);
            } else {
                String spec = rs.getString("spetialite");
                String lic = rs.getString("licence");
                profileDETAIL.setVisible(false);
                profileDETAIL1.setVisible(true);
                getrolet.setText("Therapist");
                getemailT.setText(email);
                getnomT.setText(name);
                getnumt.setText(num);
                getprenomT.setText(prenom);
                getlicT.setText(lic);
                getspecialiteT.setText(spec);

   detailpatpic.setImage(img);
            }
 
          
            
            lblNom.setText(name); // set the label text to the retrieved name
            lblPreom.setText(prenom); // set the label text to the retrieved name
            
        }

        rs.close(); // close the result set
        ps.close(); // close the prepared statement

    }

    //prfole edit show
    public void edit() throws SQLException {

        String query = "SELECT * FROM user WHERE  id = ? ";

        PreparedStatement ps = connect.getCnx().prepareStatement(query);
        int id = userNow.getid();
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String name = rs.getString("nom"); // retrieve the name from the result set
            String prenom = rs.getString(6); // retrieve the name from the result set
            String role = rs.getString("roles");
            String email = rs.getString("email");
            String num = rs.getString("numero");
            String psudo = rs.getString("PseudoUtilisateur");
             Image img = new Image("file:C:/Users/alisl/Desktop/pics/"+rs.getString("image"), true);
             Image img1 = new Image("file:C:/Users/alisl/Desktop/pics/"+rs.getString("photo licence"), true);
            if (role.contains("ROLE_PATIENT")) {
                profileDETAIL.setVisible(false);
                profileDETAIL1.setVisible(false);
                profileedit1.setVisible(true);
                profileedit.setVisible(false);

                eemail1.setText(email);
                enom1.setText(name);
                enumuro1.setText(num);
                eprenom1.setText(prenom);
                epsudo1.setText(psudo);
                ela.setImage(img);
            } else {
                String spec = rs.getString("spetialite");
                String lic = rs.getString("licence");
                profileDETAIL.setVisible(false);
                profileDETAIL1.setVisible(false);
                profileedit1.setVisible(false);
                profileedit.setVisible(true);
                elp.setImage(img);
                eemail.setText(email);
                enom.setText(name);
                enumuro.setText(num);
                eprenom.setText(prenom);

                espec.setText(spec);
            }

            lblNom.setText(name); // set the label text to the retrieved name
            lblPreom.setText(prenom); // set the label text to the retrieved name

        }

        rs.close(); // close the result set
        ps.close(); // close the prepared statement

    }
//profile general

    @FXML
    void show(ActionEvent event) {
        profile.setVisible(true);
        try {
            profileDETAIL.setVisible(false);
            profileDETAIL1.setVisible(false);
            profileedit.setVisible(false);
            profileedit1.setVisible(false);

            info();
        } catch (SQLException ex) {
            Logger.getLogger(HomeFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//profile special

    @FXML
    void detail(ActionEvent event) {
        profile.setVisible(false);

        try {
            infoD();
        } catch (SQLException ex) {
            Logger.getLogger(HomeFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void edit(ActionEvent event) {
        profile.setVisible(false);

        try {
            edit();
        } catch (SQLException ex) {
            Logger.getLogger(HomeFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //logout
    public void lbara() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                userNow.kahaw();
                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
        }

    }
//edit patient

    @FXML
    void editpatient(ActionEvent event) {
        String nom = enom1.getText();
        String prenom = eprenom1.getText();
        String email = eemail1.getText();
        String PseudoUtilisateur = epsudo1.getText();
        String numero = enumuro1.getText();
        int id = userNow.getid();
        String image = path.getText();
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || PseudoUtilisateur.isEmpty() || numero.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" form pas remply");
            alert.setContentText("veuiller remplir tous les collones");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;

        } else {
            if (!nom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nom Invalid");
                alert.setContentText("entrer un nom valid");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
            if (!prenom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Prenom Invalid");
                alert.setContentText("entrer un prenom valid");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
            if (!numero.matches("([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("numero Invalid");
                alert.setContentText("entrer un numero valid(8)");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }

            if (!email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" Email Invalid");
                alert.setContentText("enterr un Email valid : example@email.com");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setContentText("compte modifier");
                alert.setHeaderText(null);
                alert.showAndWait();

            }

        }
        int fill =0;
        User u = new User(id, email, nom, prenom, numero,fill,image, PseudoUtilisateur);
        userCRUD ucd = new userCRUD();
        ucd.modifier(u);

    }
      @FXML
    void edittherapist(ActionEvent event) {
        String nom = enom.getText();
        String prenom = eprenom.getText();
        String email = eemail.getText();
        String numero = enumuro.getText();
        String specialite = espec.getText();
        int id = userNow.getid();
        String image = path1.getText();
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || numero.isEmpty()|| specialite.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" form pas remply");
            alert.setContentText("veuiller remplir tous les collones");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;

        } else {
            if (!nom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nom Invalid");
                alert.setContentText("entrer un nom valid");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
            if (!prenom.matches("[a-zA-Z]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Prenom Invalid");
                alert.setContentText("entrer un prenom valid");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
            if (!numero.matches("([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])([1-9])")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("numero Invalid");
                alert.setContentText("entrer un numero valid(8)");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }

            if (!email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" Email Invalid");
                alert.setContentText("enterr un Email valid : example@email.com");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setContentText("compte modifier");
                alert.setHeaderText(null);
                alert.showAndWait();

            }

        }
  
        User u = new User(id, email, nom, prenom, numero,image,specialite);
        userCRUD ucd1 = new userCRUD();
        ucd1.modifierTherapist(u);

    }
    private Stage stage ; 
 @FXML
    void jibela(ActionEvent event) {
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
                String outputPath = "C:/Users/alisl/Desktop/pics/"+randomString+".jpg";
                File outputFile = new File(outputPath);
                path.setText(randomString+".jpg");
                ImageIO.write(image, "jpg", outputFile);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }

    @FXML
    void jibelp(ActionEvent event) {
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
                elp.setImage(fxImage);
                
                // Save the image to a file
                String randomString = UUID.randomUUID().toString();
                String outputPath = "C:/Users/alisl/Desktop/pics/"+randomString+".jpg";
                File outputFile = new File(outputPath);
                path1.setText(randomString+".jpg");
                ImageIO.write(image, "jpg", outputFile);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }
}

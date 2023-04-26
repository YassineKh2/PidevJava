/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.utils.DataSource;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class HomeFController implements Initializable {
    
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
    private Label  GETMAIL;

    @FXML
    private Label  GETNOM;

    @FXML
    private Label  GETNUM;

    @FXML
    private Label  GETPRENOM;

    @FXML
    private Label  GETPSUDO;

    @FXML
    private Label  GETROLE;

    @FXML
    private AnchorPane profileDETAIL;

    @FXML
    private JFXButton profileshow;
    @FXML
    private AnchorPane profile;
    @FXML
    private Button detailBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        profile.setVisible(false);
        profileDETAIL.setVisible(false);
        profileDETAIL1.setVisible(false);
    }

    @FXML
    private JFXButton logout;

    private DataSource connect = DataSource.getInstance();
    private Alert alert;
    private ResultSet result;

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
            if (role.contains("ROLE_PATIENT")) {
                lblRole.setText("Patient");

            } else {
                lblRole.setText("Therapist");
            }

            lblNom.setText(name); // set the label text to the retrieved name
            lblPreom.setText(prenom); // set the label text to the retrieved name

        }

        rs.close(); // close the result set
        ps.close(); // close the prepared statement

    }

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
            String num =rs.getString("numero");
            String psudo =rs.getString("PseudoUtilisateur");
            if (role.contains("ROLE_PATIENT")) {
                        profileDETAIL.setVisible(true);
                        profileDETAIL1.setVisible(false);
                GETROLE.setText("Patient");
                GETMAIL.setText(email);
                GETNOM.setText(name);
                GETNUM.setText(num);
                GETPRENOM.setText(prenom);
                GETPSUDO.setText(psudo);


            } else {
                String spec =rs.getString("spetialite");
                String lic =rs.getString("licence");
                        profileDETAIL.setVisible(false);
                        profileDETAIL1.setVisible(true);
                         getrolet.setText("Therapist");
                          getemailT.setText(email);
                getnomT.setText(name);
                getnumt.setText(num);
                getprenomT.setText(prenom);
           getlicT.setText(lic);
           getspecialiteT.setText(spec);

            }

            lblNom.setText(name); // set the label text to the retrieved name
            lblPreom.setText(prenom); // set the label text to the retrieved name

        }

        rs.close(); // close the result set
        ps.close(); // close the prepared statement

    }

    @FXML
    void show(ActionEvent event) {
        profile.setVisible(true);
        try {
                    profileDETAIL.setVisible(false);
                    profileDETAIL1.setVisible(false);

            info();
        } catch (SQLException ex) {
            Logger.getLogger(HomeFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void detail(ActionEvent event) {
        profile.setVisible(false);

        try {
            infoD();
        } catch (SQLException ex) {
            Logger.getLogger(HomeFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

}

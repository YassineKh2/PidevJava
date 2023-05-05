/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.gargabou.entites.User;
import pidev.gargabou.utils.DataSource;
import pidev.gargabou.utils.changeScene;
import pidev.gargabou.utils.passwordHasher;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField tf_Email;
    @FXML
    private PasswordField tf_Password;
    @FXML
    private Button buttom_login;
    @FXML
    private Hyperlink li_oubliee;
    @FXML
    private Hyperlink li_register;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        @FXML
    void showpass(MouseEvent event) {
  tf_Password.setPromptText(tf_Password.getText());
                tf_Password.setText("");
    }

         @FXML
    void hidepass(MouseEvent event) {
 tf_Password.setText(tf_Password.getPromptText());
                tf_Password.setPromptText("");
    }
    
     private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private void switchtosignin(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("choix.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private DataSource connect= DataSource.getInstance();
    private Alert alert;
    private ResultSet result;
  @FXML
    private void loginUser(ActionEvent event) throws SQLException, IOException {
          String selectData = "SELECT * FROM user WHERE email = ? ";
        try {
            if (tf_Email.getText().isEmpty() || tf_Password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("entrer votre email et mot de pass");
                alert.showAndWait();
            } 
             else{
                PreparedStatement ps = connect.getCnx().prepareStatement(selectData);
                ps.setString(1, tf_Email.getText());
              
                ResultSet result = ps.executeQuery();
                if (result.next()) {
                    String hashedPassword = result.getString("password");
                    if (hashedPassword != null && passwordHasher.verifyPassword(tf_Password.getText(), hashedPassword)) {
                           
                        int id = result.getInt("id");
                        int stat = result.getInt(9);
                        if (stat!=1){ 
                        userNow.setid(id);
                        
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Login");
                        alert.showAndWait();

                       changeScene.changeScene(event, "/pidev/gargabou/gui/HomeF.fxml", "home");
                       }else{ alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("tu est bannee");
                        alert.showAndWait();
                        }
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("mot de passe incorrect");
                        alert.showAndWait();
                    }} else {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(" Email Incorrect ");
                    alert.showAndWait();
                }
                 }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }}
    


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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.gargabou.utils.DataSource;
import pidev.gargabou.utils.changeScene;


/**
 * FXML Controller class
 *
 * @author alisl
 */
public class LoginAdminController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button lognBtn;
private DataSource connect= DataSource.getInstance();
    private Alert alert;
    private ResultSet result;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAdmin(ActionEvent event) throws SQLException {
          String selectData = "SELECT * FROM admin WHERE nom_admin = ? and password_admin = ?";
        try {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("entrer votre nom et mot de pass");
                alert.showAndWait();
            } 
             else{
                PreparedStatement ps = connect.getCnx().prepareStatement(selectData);
                ps.setString(1, username.getText());
                ps.setString(2, password.getText());
                ResultSet result = ps.executeQuery();
                if(result.next()){
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    
                   lognBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    

                    stage.setScene(scene);
                    stage.show();
                    
                 
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
            }catch(IOException | SQLException e){}
        
    }
    }

    
    


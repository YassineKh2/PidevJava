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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.gargabou.utils.DataSource;

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
    private void loginUser(ActionEvent event) throws SQLException {
          String selectData = "SELECT * FROM user WHERE email = ?and password = ? ";
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
                ps.setString(2, tf_Password.getText());
                ResultSet result = ps.executeQuery();
                if(result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    
                   buttom_login.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("homeF.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    

                    stage.setScene(scene);
                    stage.show();
                    
                 
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("fausse email/Password");
                    alert.showAndWait();
                }
            }
            }catch(IOException | SQLException e){}
        
    }
    }

    
    


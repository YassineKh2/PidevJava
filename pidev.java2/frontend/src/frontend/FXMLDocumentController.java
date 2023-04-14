/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author alisl
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button buttom_login;
    @FXML
    private Hyperlink li_oubliee;
    @FXML
    private Hyperlink li_register;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
     //base de donnee things xd
     private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
 
    
    private double x = 0;
    private double y = 0;
    
    public void loginuser() throws ClassNotFoundException{
        
        String sql = "SELECT * FROM user  WHERE nom = ? and password = ?";
        
        connect = DataBase.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
            Alert alert;
            
            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("entrer votre nom et mot de pass  ");
                alert.showAndWait();
            }else{
                if(result.next()){
                    
                   
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    
                    buttom_login.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
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
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private void switchtocreate(ActionEvent event)throws IOException {
         {
        root=FXMLLoader.load(getClass().getResource("signin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    }
    
}

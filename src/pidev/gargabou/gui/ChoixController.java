/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class ChoixController implements Initializable {

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
    

     public void switchtoPatient(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("inscriP.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
      private Stage stage1;
    private Scene scene1;
    private Parent root1;
      public void switchtoT(ActionEvent event) throws IOException{
         root1=FXMLLoader.load(getClass().getResource("inscriT.fxml"));
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene1= new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }
}



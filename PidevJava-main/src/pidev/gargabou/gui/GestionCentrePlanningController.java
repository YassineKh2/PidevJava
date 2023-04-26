/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class GestionCentrePlanningController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private AnchorPane gestion;

     @FXML
     void open_AjoutCentre() throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("ListCentreBack.fxml"));
         gestion.getChildren().removeAll();
         gestion.getChildren().setAll(fxml);
     }
     
     @FXML
     void open_AjoutPlanning() throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("ListPlanningBack.fxml"));
         gestion.getChildren().removeAll();
         gestion.getChildren().setAll(fxml);
     }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ShowCategorieController implements Initializable {

    @FXML
    private TextField fxNomCategorie;
    @FXML
    private TextField fxImageCategorie;
    @FXML
    private ImageView fxImgeCateg;
   
    
    
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setNomCategorie(String message){
        this.fxNomCategorie.setText(message);
    }
    public void setImageCategorie(String message){
        this.fxImageCategorie.setText(message);
    }
    public void setImgeCateg(Image message){
        this.fxImgeCateg.setImage(message);
    }
   
}

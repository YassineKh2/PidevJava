/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AddCategorieController implements Initializable {

    @FXML
    private TextField tfNomCategorie;
    @FXML
    private TextField tfImageCategorie;
    @FXML
    private Button btnAjouterCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveCategorie(ActionEvent event) {
        String nom = tfNomCategorie.getText();
        String image = tfImageCategorie.getText();
        
            
        
        Image imageC = new Image("testimg.jpg");
       
        
        Categorie categ = new Categorie(nom,image);
        ServiceCategorie Sc = new ServiceCategorie();
        Sc.ajouter(categ);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowCategorieGui.fxml"));
        
        try {
            Parent root = loader.load();
            ShowCategorieController ShowCateg = loader.getController();
            ShowCateg.setNomCategorie(nom);
            ShowCateg.setImageCategorie(image);
            ShowCateg.setImgeCateg(imageC);
            
            tfNomCategorie.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}

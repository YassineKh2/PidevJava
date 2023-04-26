/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.entites.Centre;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class CategorieItemController implements Initializable {

    @FXML
    private Label fxLocalisationCentre;
    @FXML
    private Label fxcapaciteCentre;
    @FXML
    private Label fxNumtelfCentre;
    @FXML
    private ImageView imgCentre;
    @FXML
    private Label fxNomCentre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

      public void setCentre(Centre c){

        Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+c.getImg(), true);
        
        fxNomCentre.setText(c.getNomCentre());
   
        }
        fxImageCateogire.setImage(img);
        fxNombreArticleCateogire.setText(nArticle);
        int idCateg = categ.getId();
        String idC= Integer.toString(idCateg);
        fxCategorieId.setText(idC);
        fxPathImage.setText(categ.getImageCategorie());
    }
}

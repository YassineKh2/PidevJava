/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesModule;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class DetailFormationController implements Initializable {

    @FXML
    private Pane fmt_detail;
    @FXML
    private ImageView image_formation;
    @FXML
    private Label label_nom;
    @FXML
    private JFXButton btn_email_formateur;
    @FXML
    private Label tx_nom_formateur;
    @FXML
    private Label tx_niveau;
    @FXML
    private JFXTextArea tx_description;
    @FXML
    private ImageView image_fm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormation sf = new ServicesFormation();
        ServicesModule sm = new ServicesModule();
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        ArrayList<ModuleFormation> module = (ArrayList) sm.getAll();
        
        for(Formation f:formation){
            if(Formation.getChamp_id()==f.getId()){
                label_nom.setText(f.getNomFormation());
                tx_description.setText(f.getDescriptionFormation());
                tx_niveau.setText(Integer.toString(f.getNiveauFormation()));
                String value_img = f.getImageFormation();
                Image img = new Image("file:/C:/Users/MsiAs/Desktop/ProjIng/public/"+value_img, true);
                image_formation.setImage(img);
                for(Formateur fr:formateur){
                    if(fr.getId()==f.getIdFormateur()){
                        Image img_f = new Image("file:/C:/Users/MsiAs/Desktop/ProjIng/public/"+fr.getImageFormateur(), true);
                        image_fm.setImage(img_f);

                        String nom_fm=fr.getNomFormateur() +" " +fr.getPrenomFormateur();
                        tx_nom_formateur.setText(nom_fm);
                }
            }
                
            }
        }
    }    
    
}
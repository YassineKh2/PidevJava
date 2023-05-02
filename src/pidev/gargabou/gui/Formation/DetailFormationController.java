/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Formation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pidev.gargabou.entites.Formateur;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.ModuleFormation;
import pidev.gargabou.services.ServicesFormateur;
import pidev.gargabou.services.ServicesFormation;
import pidev.gargabou.services.ServicesModule;

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
    @FXML
    private JFXButton btn_join;

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
                Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+value_img, true);
                image_formation.setImage(img);
                for(Formateur fr:formateur){
                    if(fr.getId()==f.getIdFormateur()){
                        Image img_f = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+fr.getImageFormateur(), true);
                        image_fm.setImage(img_f);

                        String nom_fm=fr.getNomFormateur() +" " +fr.getPrenomFormateur();
                        tx_nom_formateur.setText(nom_fm);
                }
            }
                
            }
        }
        btn_email_formateur.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ContactFormateur.fxml"));
                Parent root=loader.load();
                
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Consulter Formateur");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DetailFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn_join.setOnAction(e->{
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formJoin.fxml"));
                Parent root=loader.load();
                
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Joindre Formation");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DetailFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesModule;
import edu.esprit.tools.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class ItemController implements Initializable {

    @FXML
    private Label label_nom;
    @FXML
    private Label label_id;
    
    private int id;
    @FXML
    private Label tx_nom_formateur;
    @FXML
    private Label tx_niveau;
    @FXML
    private JFXTextArea tx_description;
    @FXML
    private ImageView image_formation;
    @FXML
    private Label label_nom_module;
    @FXML
    private Label label_pre_module;
    @FXML
    private Pane pane_mod;
    //
    public void setId(Formation formation) {
    this.id = formation.getId();
    try {
        Connection cnx = DataSource.getInstance().getCnx();
        ServicesFormateur sfm = new ServicesFormateur();
        ServicesModule sm = new ServicesModule();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        ArrayList<ModuleFormation> module = (ArrayList) sm.getAll();

        String req = "SELECT * FROM formation WHERE id = " + id;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        if (rs.next()) {
            String value = rs.getString("nom_formation");
            int value_niveau = rs.getInt("niveau_formation");
            String value_description = rs.getString("description_formation");
            int value_formateur = rs.getInt("formateur_id");
            for(Formateur f:formateur){
                if(f.getId()==value_formateur){
                    String nom_fm=f.getNomFormateur() +" " +f.getPrenomFormateur();
                    tx_nom_formateur.setText(nom_fm);
                }
            }
            for(ModuleFormation m:module){
                if(m.getIdFormation()==id){
                    String nom_m=m.getNomModule();
                    String pre_m=m.getPrerequisModule();
                    label_nom_module.setText(nom_m);
                    label_pre_module.setText(pre_m);
                    
                    
                    
                    
                }
            }
            tx_description.setText(value_description);
            tx_niveau.setText(Integer.toString(value_niveau));
            label_nom.setText(value);
            label_id.setText(Integer.toString(id));
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui.Session;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Session;
import edu.esprit.services.ServicesSession;
import edu.esprit.tools.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Card_SessionController implements Initializable {
    private int id;
    @FXML
    private ImageView img_session;
    @FXML
    private Label fx_nom;
    @FXML
    private Label fx_nbr;
    @FXML
    private JFXButton btn_detail;
    @FXML
    private Label fx_date_debut;
    @FXML
    private Label fx_date_fin;
    @FXML
    private JFXTextArea fx_desc;
    @FXML
    private Pane pane_style;
    
    public void setData(Session session){
        try {
            ServicesSession s=new ServicesSession();
            this.id = session.getId();
            Connection cnx = DataSource.getInstance().getCnx();
            String req = "SELECT * FROM formation WHERE id = " + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                
                Image img_s = new Image("file:/C:/Users/MsiAs/Desktop/ProjIng/public/"+session.getImageSession(), true);
                img_session.setImage(img_s);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                fx_date_debut.setText(dateFormat.format(session.getDateDebutSession()));
                fx_nbr.setText(Integer.toString(session.getNombreParticipantSession()));
                fx_nom.setText(session.getNomSession());
                fx_date_fin.setText(dateFormat.format(session.getDateFinSession()));
                fx_desc.setText(session.getDescriptionSession());
                
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Card_SessionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Centre;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class CentreItemController implements Initializable {

    @FXML
    private Label NomCentre;
    @FXML
    private Label LocalisationCentre;
    @FXML
    private Label NumrTelf;
    @FXML
    private Label CapaciteCentre;
    @FXML
    private Label fxDiscriptionArticle;
    @FXML
    private ImageView imgCentre;
    private int id;
    public void setData(Centre centre){
        try {
            CentreService s=new CentreService();
            this.id = centre.getId();
            Connection cnx = DataSource.getInstance().getCnx();
            String req = "SELECT * FROM centre WHERE id = " + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                
                
                NomCentre.setText(centre.getNomCentre());
                NumrTelf.setText(Integer.toString(centre.getNombreBlocCentre()));
                LocalisationCentre.setText(centre.getLocalisation());
                CapaciteCentre.setText(Integer.toString(centre.getCapaciteCentre()));
                
                Image img = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/PidevJava-Shop/src/uploads/"+centre.getImg(), true); 
                      imgCentre.setImage(img);   
            }
        } catch (SQLException ex) {
            
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

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.services.PlanningCentreService;
import pidev.gargabou.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class PlanningCentreItemController implements Initializable {

    @FXML
    private Label TitrePlanning;
    @FXML
    private Label DescriptionPlanning;
    @FXML
    private Label DateFinP;
    @FXML
    private Label DateDebutP;
    @FXML
    private Label fxDiscriptionArticle;
    private int id;
    public void setData(PlanningCentre planningcentre){
        try {
            PlanningCentreService s=new PlanningCentreService();
            this.id = planningcentre.getId();
            Connection cnx = DataSource.getInstance().getCnx();
            String req = "SELECT * FROM planning_centre WHERE id = " + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                
                
                TitrePlanning.setText( planningcentre.getTitre());
                DescriptionPlanning.setText( planningcentre.getDescription());
                 DateDebutP.setText( String.valueOf(planningcentre.getDateDebutPlanning()));
                  DateFinP.setText( String.valueOf(planningcentre.getDateFinPlanning()));

                
                
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

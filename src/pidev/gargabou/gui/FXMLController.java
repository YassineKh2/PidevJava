/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import pidev.gargabou.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class FXMLController implements Initializable {

    @FXML
    private Label ali;
    @FXML
    private Label slaimia;
    @FXML
    private Button myButton;

    @FXML
private void handleButtonClick(ActionEvent event) {
    try {
      info();
    } catch (SQLException ex) {
        // handle any SQL exceptions here
    }
}
    
     private DataSource connect= DataSource.getInstance();

    public void info() throws SQLException{
 
     String query  = "SELECT * FROM user WHERE  id = ? ";

           PreparedStatement ps = connect.getCnx().prepareStatement(query );
            ps.setInt(1, 39); 
              ResultSet rs = ps.executeQuery();
             

   
if (rs.next()) {
    String name = rs.getString("nom"); // retrieve the name from the result set
    ali.setText(name); // set the label text to the retrieved name
} else {
    ali.setText("No data found"); // set a default text if no data is found
}

rs.close(); // close the result set
ps.close(); // close the prepared statement

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

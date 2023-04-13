/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;
 
import com.jfoenix.controls.JFXButton;
import edu.esprit.entities.Formation;
import edu.esprit.services.ServicesFormation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.CLOSE;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class IAFormationController implements Initializable {

    
      @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton handle_ajout;
    @FXML
    private JFXButton handle_ajout1;
    @FXML
    private JFXButton handle_ajout2;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         refreshNodes();
         handle_ajout.setOnAction(e ->{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("AllFormation.fxml"));
             Dialog dialog= new Dialog();
             dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
             try {
             dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
        // handle exception
            }
             dialog.show();
         });
         handle_ajout1.setOnAction(e ->{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/gui/Module/AllModule.fxml"));
             Dialog dialog= new Dialog();
             dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
             try {
             dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
        // handle exception
            }
             dialog.show();
         });
         handle_ajout2.setOnAction(e ->{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/gui/Formateur/AllFormateur.fxml"));
             Dialog dialog= new Dialog();
             dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
             try {
             dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
        // handle exception
            }
             dialog.show();
         });
         
         
         
    }    
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        ServicesFormation sf = new ServicesFormation();
        ArrayList<Formation> formation = (ArrayList<Formation>) sf.getAll();
        
        Node [] nodes = new  Node[formation.size()];
        

        for(int i = 0; i<formation.size(); i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            Node node = (Node) loader.load();
            ItemController controller = loader.getController();
            controller.setId(formation.get(i));
            pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
    }
}

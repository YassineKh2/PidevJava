/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;
 
import com.jfoenix.controls.JFXButton;
import edu.esprit.entities.Formation;
import edu.esprit.entities.Session;
import edu.esprit.gui.Session.Card_SessionController;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesSession;
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
    private JFXButton show_formation;
    @FXML
    private JFXButton show_session;
    
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
             dialog.setTitle("Interface Admin Formation");
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
             dialog.setTitle("Interface Admin Module Formation");
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
             dialog.setTitle("Interface Admin Formateur");
             dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
             try {
             dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
        // handle exception
            }
             dialog.show();
         });
         show_session.setOnMouseClicked(e->{
                refreshSession();
         });
         show_formation.setOnMouseClicked(e->{
             refreshNodes();
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
            
            controller.cns_detail.setOnMouseClicked(e->{
                try {
                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("detailFormation.fxml"));
                    
                    IAFormationController cntr= loader1.getController();
                    Node n = (Node) loader1.load();
                    pnl_scroll.getChildren().clear();
                    pnl_scroll.getChildren().add(n);
                    
                } catch (IOException ex) {
                    Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            pnl_scroll.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
    }
    public void refreshSession(){
        ServicesSession s=new ServicesSession();
             ArrayList<Session> session = (ArrayList) s.getAll();
             pnl_scroll.getChildren().clear();
             for(int i=0;i<session.size();i++){
             try {
                 
                 FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/edu/esprit/gui/Session/Card_Session.fxml"));
                 
                 
                 Node n = (Node) loader1.load();
                 Card_SessionController cntr= loader1.getController();
                 cntr.setData(session.get(i));
                 
                 pnl_scroll.getChildren().add(n);
                 lbl_currentprojects.setText("Tous les Sessions");
                 lbl_currentprojects.setOnMouseClicked(e->{
                     refreshSession();
                 });
             } catch (IOException ex) {
                 Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
         
    }
    
    
}

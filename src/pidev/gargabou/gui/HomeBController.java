/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.userCRUD;
import pidev.gargabou.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class HomeBController implements Initializable {
 
    @FXML
    private JFXButton approve;

    @FXML
    private Button approvebtn;

    @FXML
    private Button approvebtn1;

    @FXML
    private Button approvebtn11;

    @FXML
    private TextField approvein;

    @FXML
    private TextField approvein1;

    @FXML
    private AnchorPane haprovexd;

    @FXML
    private AnchorPane haprovexd1;

    @FXML
    private HBox hbox;

    @FXML
    private JFXButton logout;

    @FXML
    private VBox pnl_scroll;



    @FXML
    private Label usercount;

    @FXML
    private Label usercount1;

    @FXML
    private Label usercount11;

    @FXML
    private Label usercount2;

    @FXML
    private Label usercount21;

    @FXML
    private JFXButton util;

    @FXML
    private AnchorPane utilisateur;
     @FXML
    void saha(ActionEvent event) {
          approve();
            Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
                alert.setContentText("user approved");
                alert.setHeaderText(null);
                alert.showAndWait();
        
    }
    public void approve(){
        String mail = approvein.getText();
        User u = new User(mail);
        u.setApprove(1);
        userCRUD uc= new userCRUD();
        uc.approve(mail);
        
    }
    public void ban(){
        String mail = approvein1.getText();
        User u = new User(mail);
        u.setStatus(1);
        userCRUD uc= new userCRUD();
        uc.ban(mail);
          Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
                alert.setContentText("user banned");
                alert.setHeaderText(null);
                alert.showAndWait();
    } 
    public void unban(){
        String mail = approvein1.getText();
        User u = new User(mail);
        u.setStatus(0);
        userCRUD uc= new userCRUD();
        uc.unban(mail);
          Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
                alert.setContentText("user unbanned");
                alert.setHeaderText(null);
                alert.showAndWait();
    }
      @FXML
    void showban(ActionEvent event) {
  utilisateur.setVisible(false);
       haprovexd.setVisible(false);
         haprovexd1.setVisible(true);
    }
  @FXML
    void show(ActionEvent event) {
       utilisateur.setVisible(true);
       haprovexd.setVisible(false);
         haprovexd1.setVisible(false);
    }
      @FXML
    void showapp(ActionEvent event) {
utilisateur.setVisible(false);
       haprovexd.setVisible(true);
        haprovexd1.setVisible(false);
    }

public void displayNumberOfCustomer() throws SQLException {
        int noc = 0;

        String sql = "SELECT COUNT(id) FROM `user`";


Connection cnx = DataSource.getInstance().getCnx();
   
  

        Statement st = cnx.createStatement();
           
            
               ResultSet result = st.executeQuery(sql);
               System.out.println("counted !");
            if (result.next()) {
                 noc = result.getInt("COUNT(id)");
            }  usercount.setText("nombre d'utilisateur:" + noc);
        }
      
public void displayNumberOfPatients() throws SQLException {
        int noc = 0;

        String sql = "SELECT COUNT(id) FROM `user` WHERE roles LIKE CONCAT('%', 'ROLE_PATIENT', '%');";


Connection cnx = DataSource.getInstance().getCnx();
   
  

        Statement st = cnx.createStatement();
           
            
               ResultSet result = st.executeQuery(sql);
               System.out.println("counted p !");
            if (result.next()) {
                 noc = result.getInt("COUNT(id)");
            }  usercount1.setText("nombre des patient:" + noc);
        }
public void displayNumberOfTHERAPIST() throws SQLException {
        int noc = 0;

        String sql = "SELECT COUNT(id) FROM `user` WHERE roles LIKE CONCAT('%', 'ROLE_THERAPIST', '%');";


Connection cnx = DataSource.getInstance().getCnx();
   
  

        Statement st = cnx.createStatement();
           
            
               ResultSet result = st.executeQuery(sql);
               System.out.println("counted p !");
            if (result.next()) {
                 noc = result.getInt("COUNT(id)");
            }  usercount11.setText("nombre des therapist:" + noc);
        }

        

    /**
     * Initializes the controller class.
     */private double x = 0;
    private double y = 0;
    @FXML
    /*private JFXButton logout;*/
    
    public void lbara() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("loginAdmin.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

               

                


                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateur.setVisible(false);
        haprovexd.setVisible(false);
         haprovexd1.setVisible(false);
    try {
        displayNumberOfCustomer();
    } catch (SQLException ex) {
        Logger.getLogger(HomeBController.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        displayNumberOfPatients();
    } catch (SQLException ex) {
        Logger.getLogger(HomeBController.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        displayNumberOfTHERAPIST();
    } catch (SQLException ex) {
        Logger.getLogger(HomeBController.class.getName()).log(Level.SEVERE, null, ex);
    }
    refreshNodes();
    }    
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();  
        userCRUD ucd =new userCRUD() ;

        List<User> user = (List) ucd.getAll();

        System.out.println();
        Node [] nodes = new  Node[user.size()];

        for(int i = 0; i<user.size(); i++)
        { 
      try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
                Node node = (Node) loader.load();
                UserController controller = loader.getController();
               controller.setUser(user.get(i));
               
               pnl_scroll.getChildren().add(node);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}

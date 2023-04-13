/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.java2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 * FXML Controller class
 *
 * @author alisl
 */
public class DashboardController implements Initializable {
 @FXML
    private AnchorPane ADDEmployee_form;

    @FXML
    private AnchorPane Employee_formBtn;

    @FXML
    private TableColumn<userData, String> addCentre_col_email;

    @FXML
    private TableColumn<userData, String> addCentre_col_nom;

    @FXML
    private TableColumn<userData, String> addCentre_col_num;

    @FXML
    private TableColumn<userData, String> addCentre_col_prenom;

    @FXML
    private TableColumn<userData, String> addCentre_col_psuedo;

    @FXML
    private TableColumn<userData, String> addCentre_col_role;

    @FXML
    private TableColumn<userData, ?> addCentre_col_statue;

    @FXML
    private TableView<userData> addCentre_col_tableView;

    @FXML
    private TextField addCentre_email;

    @FXML
    private TextField addCentre_nom;

    @FXML
    private TextField addCentre_num;

    @FXML
    private TextField addCentre_prenom;

    @FXML
    private TextField addCentre_psuedo;

    @FXML
    private TextField addCentre_search;

    @FXML
    private Button approvebtn;

    @FXML
    private Button banbtn;

    @FXML
    private Label centre_total;

    @FXML
    private AreaChart<?, ?> chart;

    @FXML
    private Button home;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button manage_center_btn;

    @FXML
    private Label patient_total;

    @FXML
    private Label therapist_total;

    @FXML
    private Label username;

    @FXML
    void addCentre_deleteBtn(ActionEvent event) {

    }

    @FXML
    void addCentre_updateBtn(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void switchForm(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    


    public void swich(ActionEvent event) {

        if (event.getSource() == home) {
            home_form.setVisible(true);
            main_form.setVisible(false);


            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #272b3f, #256b51);");
            manage_center_btn.setStyle("-fx-background-color:transparent");


           
        } else if (event.getSource() == manage_center_btn) {
            home_form.setVisible(false);
            main_form.setVisible(true);
           

            manage_center_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#272b3f, #256b51);");
            home.setStyle("-fx-background-color:transparent");
            


       
        }

    }
     public void displayUsername() {
        username.setText(getData.username);
    }
     private Connection connect;

    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

     public ObservableList<userData> addUserListData() {

        ObservableList<userData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM user";

     try {
         connect = DataBase.connectDb();
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
     }

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            userData userD;

            while (result.next()) {
                userD = new userData(result.getInt("id"),
                        result.getString("email"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getInt("numero"),
                        
                        result.getString("PseudoUtilisateur"),
                        result.getString("role"));
                listData.add(userD);

            }
            

        } catch (SQLException e) {
        }
        return listData;
    }
     
    private ObservableList<userData> addUserList;
     public void addUserShowListData() {
        addUserList = addUserListData();

     
        addCentre_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        addCentre_col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        addCentre_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        addCentre_col_num.setCellValueFactory(new PropertyValueFactory<>("numero"));
        addCentre_col_psuedo.setCellValueFactory(new PropertyValueFactory<>("PseudoUtilisateur"));
        addCentre_col_role.setCellValueFactory(new PropertyValueFactory<>("role"));

        addCentre_col_tableView.setItems(addUserList);

    }
 private double x = 0;
    private double y = 0;
     public void lbara() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });



                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        }    
    
}

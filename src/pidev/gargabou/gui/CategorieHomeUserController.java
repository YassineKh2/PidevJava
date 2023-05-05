/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.Session;
import pidev.gargabou.gui.Formation.IAFormationController;
import pidev.gargabou.gui.Formation.ItemController;
import pidev.gargabou.gui.Session.Card_SessionController;
import pidev.gargabou.services.ServiceCategorie;
import pidev.gargabou.services.ServicesFormation;
import pidev.gargabou.services.ServicesSession;
import pidev.gargabou.utils.changeScene;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class CategorieHomeUserController implements Initializable {

    @FXML
    private GridPane pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton fxGoToPannier;
    @FXML
    private JFXButton fxGoToCentres;
    @FXML
    private JFXButton fxGoToTherapist;
    @FXML
    private JFXButton fxGoToShop;
    @FXML
    private JFXButton fxGoToForum;
    @FXML
    private JFXButton fxGoToEvent;
    @FXML
    private JFXButton fxGoToFormation;
    @FXML
    private JFXButton fxGoToSession;
    @FXML
    private JFXButton profileshow;
    @FXML
    private JFXButton logoutbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxGoToForum.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Forum/IAPublication.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToSession.setOnAction(e -> {
            Formation.Choose = 2;
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Formation/IAFormation.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(HomeFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        profileshow.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/HomeF.fxml", "Profile");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToFormation.setOnAction(e -> {
            Formation.Choose = 1;
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Formation/IAFormation.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(HomeFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToEvent.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/evenement/FrontHomeEvenement.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToShop.setOnAction(e->{
            try {
                changeScene.changeScene(e, "HomeCategorieUser.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         fxGoToCentres.setOnAction(e->{
             try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Centre/gestionCentrePlanning.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToPannier.setOnAction(event -> {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePannier.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });

        // TODO
        refreshNodes();
//        fxGoToSession.setOnMouseClicked(e -> {
//
//            try {
//                Formation.Choose=2;
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/Formation/IAFormation.fxml"));
//                Parent root = loader.load(); // load the new FXML file
//                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
//                Node sourceNode = (Node) e.getSource(); // get the source node of the current event
//                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
//                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
//                stage.setScene(scene); // set the new scene as the content of the stage
//                
//               
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        });
//        fxGoToFormation.setOnMouseClicked(e -> {
//            try {
//                 Formation.Choose=1;
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/Formation/IAFormation.fxml"));
//                refreshSession();
//                Parent root = loader.load(); // load the new FXML file
//                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
//                Node sourceNode = (Node) e.getSource(); // get the source node of the current event
//                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
//                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
//                stage.setScene(scene); // set the new scene as the content of the stage
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        });

    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();
        ServiceCategorie Sc = new ServiceCategorie();

        ArrayList<Categorie> Categories = (ArrayList) Sc.getAll();

        System.out.println();
        //Node [] nodes = new  Node[Categories.size()];

        int column = 1;
        int row = 1;

        for (int i = 0; i < Categories.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorieUserItem.fxml"));
                Node node = (Node) loader.load();
                AfficherCategorieUserController controller = loader.getController();
                controller.setCategorie(Categories.get(i));
                if (column == 3) {
                    column = 1;
                    ++row;
                }
                pnl_scroll.add(node, ++column, row);
                GridPane.setMargin(node, new Insets(10));

                //  pnl_scroll.getChildren().add(node);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
@FXML
    public void lbara() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                userNow.kahaw();
                logoutbtn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
        }

    }
    public void refreshSession() {
        ServicesSession s = new ServicesSession();
        ArrayList<Session> session = (ArrayList) s.getAll();
        pnl_scroll.getChildren().clear();
        for (int i = 0; i < session.size(); i++) {
            try {

                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/Session/Card_Session.fxml"));

                Node n = (Node) loader1.load();
                Card_SessionController cntr = loader1.getController();
                cntr.setData(session.get(i));

                pnl_scroll.getChildren().add(n);
                lbl_currentprojects.setText("Tous les Sessions");
                lbl_currentprojects.setOnMouseClicked(e -> {
                    refreshSession();
                });
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void show(ActionEvent event) {
    }

    @FXML
    private void lbara(ActionEvent event) {
    }

}

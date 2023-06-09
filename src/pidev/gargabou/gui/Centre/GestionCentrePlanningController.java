/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Centre;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.gui.Formation.IAFormationController;
import pidev.gargabou.gui.HomeFrontController;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;
import pidev.gargabou.utils.changeScene;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class GestionCentrePlanningController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane gestion;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox pan_scroll;
    @FXML
    private Button show_planning;
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

    void open_AjoutCentre() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ListCentreBack.fxml"));
        gestion.getChildren().removeAll();
        gestion.getChildren().setAll(fxml);
    }

    void open_AjoutPlanning() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ListPlanningBack.fxml"));
        gestion.getChildren().removeAll();
        gestion.getChildren().setAll(fxml);
    }

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
        refreshcentre();
        show_planning.setOnMouseClicked(e -> {
            pan_scroll.getChildren().clear();
            refreshplan();
        });
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
    private void refreshcentre() {
        CentreService s = new CentreService();
        ArrayList<Centre> centre = (ArrayList) s.recuperer();

        for (int i = 0; i < centre.size(); i++) {
            try {

                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("CentreItem.fxml"));

                Node n = (Node) loader1.load();
                CentreItemController cntr = loader1.getController();
                cntr.setData(centre.get(i));

                pan_scroll.getChildren().add(n);

            } catch (IOException ex) {
                Logger.getLogger(GestionCentrePlanningController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void refreshplan() {
        PlanningCentreService s = new PlanningCentreService();
        ArrayList<PlanningCentre> planningcentre = (ArrayList) s.recuperer();

        for (int i = 0; i < planningcentre.size(); i++) {
            try {

                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("PlanningCentreItem.fxml"));

                Node n = (Node) loader2.load();
                PlanningCentreItemController cntr1 = loader2.getController();
                cntr1.setData(planningcentre.get(i));

                pan_scroll.getChildren().add(n);

            } catch (IOException ex) {
                Logger.getLogger(GestionCentrePlanningController.class.getName()).log(Level.SEVERE, null, ex);
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

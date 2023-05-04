/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Centre;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;

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
    private Button BTNgestionPlanning;
    @FXML
    private Button BTNgestionCentre;
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
    private JFXButton show_formation;
    @FXML
    private JFXButton show_session;

    @FXML
    void open_AjoutCentre() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ListCentreBack.fxml"));
        gestion.getChildren().removeAll();
        gestion.getChildren().setAll(fxml);
    }

    @FXML
    void open_AjoutPlanning() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ListPlanningBack.fxml"));
        gestion.getChildren().removeAll();
        gestion.getChildren().setAll(fxml);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshcentre();
        show_planning.setOnMouseClicked(e -> {
            pan_scroll.getChildren().clear();
            refreshplan();
        });
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Centre;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;

/**
 * FXML Controller class
 *
 * @author azizo
 */
public class StatistiquesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private LineChart<String, Integer> lineChartCentre;
    
    
    @FXML
    private AnchorPane statPane;
    
    @FXML
    void return_listCentre(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("listCentreBack.fxml"));
        statPane.getChildren().removeAll();
        statPane.getChildren().setAll(fxml);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statistique();
    }   
    
    
    public void statistique() {
        CentreService cs = new CentreService();
        PlanningCentreService pcs = new PlanningCentreService();

        List<Centre> centre = null;
        centre = cs.recuperer();
        
        

        // Créer les axes pour le graphique
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Nom Centre");
        yAxis.setLabel("Nombre des plans");

        // Créer la série de données à afficher
        XYChart.Series series = new XYChart.Series();
        series.setName("Statistiques des centres celon  leurs planning");
        for (Centre c : centre) {
            try {
                series.getData().add(new XYChart.Data<>(c.getNomCentre(), pcs.findPlanningCentre(c.getId()).size()));
            } catch (SQLException ex) {
                Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Créer le graphique et ajouter la série de données
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Statistiques des centre");
        lineChart.getData().add(series);

        // Afficher le graphique dans votre scène
        lineChartCentre.setCreateSymbols(false);
        lineChartCentre.getData().add(series);
        
        


    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesModule;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author rayen
 */
public class StaticsController implements Initializable {

    @FXML
    private BarChart<String, Integer> chart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    
    ServicesFormation sfm = new ServicesFormation();
    ServicesModule sm = new ServicesModule();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        populateChart();
    }

    private void populateChart() {
      List<Formation> formation = sfm.getAll();
      List<ModuleFormation> module = sm.getAll();
      ArrayList <Integer> m_t_f = new ArrayList<Integer>();
      for(Formation f:formation){
          int i = 0;
          for(ModuleFormation m:module){
              if(m.getIdFormation()==f.getId()){
                    i++;  
            }
          
            
          }
            m_t_f.add(i);
      }

      Map<String, XYChart.Series<String, Integer>> seriesMap = new HashMap<>();
      for (Formation f : formation) {
          int index_f= formation.indexOf(f);
          int m = m_t_f.get(index_f);
          String nom = f.getNomFormation();
          if (!seriesMap.containsKey(nom)) {
              XYChart.Series<String, Integer> series = new XYChart.Series<>();
              series.setName(nom);
              series.getData().add(new XYChart.Data<>(nom, m));
              seriesMap.put(nom, series);
              }
           else {
              XYChart.Series<String, Integer> series = seriesMap.get(nom);
              int count = series.getData().get(0).getYValue() + 1;
              series.getData().set(0, new XYChart.Data<>(nom, count));
          }
      }
      for (XYChart.Series<String, Integer> series : seriesMap.values()) {
          chart.getData().add(series);
      }
}
  }


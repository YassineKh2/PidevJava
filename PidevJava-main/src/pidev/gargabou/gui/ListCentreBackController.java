/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.services.CentreService;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class ListCentreBackController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane listCentrePane;
    
    @FXML
    void open_addCentre(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("AjoutCentre.fxml"));
        listCentrePane.getChildren().removeAll();
        listCentrePane.getChildren().setAll(fxml);
    }

    @FXML
    void open_ListGestion() throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("gestionCentrePlanning.fxml"));
        listCentrePane.getChildren().removeAll();
        listCentrePane.getChildren().setAll(fxml);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherCentre();
    }    
    
    
     @FXML
    private Button btnSupprimerCentre;
    @FXML
    private TableColumn<Centre, Integer> capaciteCellCentre;
    @FXML
    private TableColumn<Centre, Integer> idCellCentre;
    @FXML
    private TableColumn<Centre, String> localisationCellCentre;
    @FXML
    private TableColumn<Centre, String> nomCellCentre;
    @FXML
    private TableColumn<Centre, Integer> numCellCentre;
    @FXML
    private TableView<Centre> tableCentre;
    
    
    ObservableList<Centre> dataCentre = FXCollections.observableArrayList();  
    
    
    public void AfficherCentre()
    {
        CentreService cs = new CentreService();
        cs.recuperer().stream().forEach((c) -> {
            dataCentre.add(c);
        });
        
        idCellCentre.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCellCentre.setCellValueFactory(new PropertyValueFactory<>("NomCentre"));
        nomCellCentre.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCellCentre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Centre, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Centre, String> event) {
                Centre c = event.getRowValue();
                c.setNomCentre(event.getNewValue());
                CentreService cs = new CentreService();
                cs.modifier(c);
            }
        });
        numCellCentre.setCellValueFactory(new PropertyValueFactory<>("NombreBlocCentre"));
        numCellCentre.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        numCellCentre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Centre, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Centre, Integer> event) {
                Centre c = event.getRowValue();
                c.setNombreBlocCentre(event.getNewValue());
                CentreService cs = new CentreService();
                cs.modifier(c);
            }
        });
        capaciteCellCentre.setCellValueFactory(new PropertyValueFactory<>("CapaciteCentre"));
        capaciteCellCentre.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        capaciteCellCentre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Centre, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Centre, Integer> event) {
                Centre c = event.getRowValue();
                c.setCapaciteCentre(event.getNewValue());
                CentreService cs = new CentreService();
                cs.modifier(c);
            }
        });
        localisationCellCentre.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        localisationCellCentre.setCellFactory(TextFieldTableCell.forTableColumn());
        localisationCellCentre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Centre, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Centre, String> event) {
                Centre c = event.getRowValue();
                c.setLocalisation(event.getNewValue());
                CentreService cs = new CentreService();
                cs.modifier(c);
            }
        });
        
        tableCentre.setItems(dataCentre);
    }
    
    @FXML
    private void supprimerCentre(ActionEvent event) throws SQLException {
        CentreService cs = new CentreService();
        
        if (tableCentre.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez sélectionner le centre à supprimer");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce centre ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Récupérer l'ID du Centre sélectionnée dans la vue de la table
            int id = tableCentre.getSelectionModel().getSelectedItem().getId();

         
            cs.supprimer(id);
            
            AfficherCentre();
           
            tableCentre.refresh();
        }
    }
    
}

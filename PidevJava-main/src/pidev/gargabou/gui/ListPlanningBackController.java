/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;

/**
 * FXML Controller class
 *
 * @author MOHAMED MHAMDI
 */
public class ListPlanningBackController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane listPlanningPane;
        
    @FXML
    void open_addPlanning(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("AjoutPlanning.fxml"));
        listPlanningPane.getChildren().removeAll();
        listPlanningPane.getChildren().setAll(fxml);
    }
    
    @FXML
     void open_ListGestion() throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("gestionCentrePlanning.fxml"));
         listPlanningPane.getChildren().removeAll();
         listPlanningPane.getChildren().setAll(fxml);
     }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherPlanningCentre();
    }    
    
    
    
    @FXML
    private Button btnSupprimerPlanning;
    @FXML
    private TableColumn<PlanningCentre, Date> datedebutCellPlanning;
    @FXML
    private TableColumn<PlanningCentre, Date> datefinCellPlanning;
    @FXML
    private TableColumn<PlanningCentre, String> descriptionCellPlanning;
    @FXML
    private TableColumn<PlanningCentre, Integer> idCellPlanning;
    @FXML
    private TableView<PlanningCentre> tablePlanningCentre;
    @FXML
    private TableColumn<PlanningCentre, String> titreCellPlanning;
 
    
    ObservableList<PlanningCentre> dataPlanningCentre = FXCollections.observableArrayList();  
    
    
    public void AfficherPlanningCentre()
    {
        PlanningCentreService cs = new PlanningCentreService();
        cs.recuperer().stream().forEach((c) -> {
            dataPlanningCentre.add(c);
        });
        
        idCellPlanning.setCellValueFactory(new PropertyValueFactory<>("id"));
        titreCellPlanning.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        titreCellPlanning.setCellFactory(TextFieldTableCell.forTableColumn());
        titreCellPlanning.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PlanningCentre, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PlanningCentre, String> event) {
                PlanningCentre c = event.getRowValue();
                c.setTitre(event.getNewValue());
                PlanningCentreService cs = new PlanningCentreService();
                cs.modifier(c);
            }
        });
        descriptionCellPlanning.setCellValueFactory(new PropertyValueFactory<>("Description"));
        descriptionCellPlanning.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCellPlanning.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PlanningCentre, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PlanningCentre, String> event) {
                PlanningCentre c = event.getRowValue();
                c.setDescription(event.getNewValue());
                PlanningCentreService cs = new PlanningCentreService();
                cs.modifier(c);
            }
        });
        datedebutCellPlanning.setCellValueFactory(new PropertyValueFactory<>("DateDebutPlanning"));
        datedebutCellPlanning.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Date>() {
            private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            @Override
            public String toString(Date object) {
                return dateFormat.format(object);
            }

            @Override
            public Date fromString(String string) {
                try {
                    
                    return dateFormat.parse(string);
                } catch (ParseException e) {
                    e.printStackTrace();
                   
                    return null;
                }
            }
        }));
        datedebutCellPlanning.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PlanningCentre, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PlanningCentre, Date> event) {
                PlanningCentre c = event.getRowValue();
                c.setDateDebutPlanning(event.getNewValue());
                PlanningCentreService cs = new PlanningCentreService();
                cs.modifier(c);
            }
        });
        datefinCellPlanning.setCellValueFactory(new PropertyValueFactory<>("DateFinPlanning"));
        datefinCellPlanning.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Date>() {
            private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            @Override
            public String toString(Date object) {
                return dateFormat.format(object);
            }

            @Override
            public Date fromString(String string) {
                try {
                    
                    return dateFormat.parse(string);
                } catch (ParseException e) {
                    e.printStackTrace();
                    // If the string can't be parsed, return null
                    return null;
                }
            }
        }));
        datefinCellPlanning.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PlanningCentre, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PlanningCentre, Date> event) {
                PlanningCentre c = event.getRowValue();
                c.setDateFinPlanning(event.getNewValue());
                PlanningCentreService cs = new PlanningCentreService();
                cs.modifier(c);
            }
        });
        
        tablePlanningCentre.setItems(dataPlanningCentre);
    }
    
    @FXML
    private void supprimerPlanningCentre(ActionEvent event) throws SQLException {
        PlanningCentreService cs = new PlanningCentreService();
        
        if (tablePlanningCentre.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez sélectionner le planning à supprimer");
            alert.showAndWait();
            return;
        }

        // Afficher une boîte de dialogue de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce planning ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Récupérer l'ID du Plannig sélectionnée dans la vue de la table
            int id = tablePlanningCentre.getSelectionModel().getSelectedItem().getId();

            // Supprimer le Planning de la base de données
            cs.supprimer(id);
            // Rafraîchir la liste de données
            dataPlanningCentre.clear();
            AfficherPlanningCentre();
            // Rafraîchir la vue de la table
            tablePlanningCentre.refresh();
        }
    }

}

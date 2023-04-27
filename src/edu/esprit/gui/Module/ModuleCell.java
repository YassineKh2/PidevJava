/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.gui.Module;

/**
 *
 * @author MsiAs
 */
import com.jfoenix.controls.JFXListCell;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesModule;
import java.util.ArrayList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author MsiAs
 */
public class ModuleCell extends JFXListCell<ModuleFormation> {
    private GridPane gridPane = new GridPane();
    private Label lblTitre = new Label();
    private Label lblDesc = new Label();
    private Label lblPre = new Label();
    private Label lblDuree = new Label();
    private Label lblFormation = new Label();

    public ModuleCell() {
        super();
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getRowConstraints().add(new RowConstraints(30));

        gridPane.add(lblTitre, 0, 0);
        gridPane.add(lblFormation, 1, 0);
        gridPane.add(lblPre, 2, 0);
        gridPane.add(lblDesc, 3, 0);
        gridPane.add(lblDuree, 4, 0);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }

    @Override
    protected void updateItem(ModuleFormation module, boolean empty) {
        super.updateItem(module, empty);
        ServicesFormation sm = new ServicesFormation();
        
        ArrayList<Formation> formation = (ArrayList) sm.getAll();
        if (empty || module == null) {
            setText(null);
            setGraphic(null);
        } else {
            lblTitre.setText(module.getNomModule());
            for(Formation fm:formation){
                if(fm.getId()==module.getIdFormation()){
                    lblFormation.setText(fm.getNomFormation());
                }
            }
            lblDesc.setText(module.getContenuModule());
            lblPre.setText(module.getPrerequisModule());
            lblDuree.setText(module.getDureeModule());
            setGraphic(gridPane);
        }
    }
}


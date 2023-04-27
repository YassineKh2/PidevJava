/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXListCell;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
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
public class FormationCell extends JFXListCell<Formation> {
    private GridPane gridPane = new GridPane();
    private Label lblTitre = new Label();
    private Label lblDesc = new Label();
    private Label lblnv = new Label();
    private Label lblimg = new Label();
    private Label lblFormateur = new Label();

    public FormationCell() {
        super();
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getRowConstraints().add(new RowConstraints(30));

        gridPane.add(lblTitre, 0, 0);
        gridPane.add(lblFormateur, 1, 0);
        gridPane.add(lblnv, 2, 0);
        gridPane.add(lblDesc, 3, 0);
        gridPane.add(lblimg, 4, 0);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }

    @Override
    protected void updateItem(Formation formation, boolean empty) {
        super.updateItem(formation, empty);
        ServicesModule sm = new ServicesModule();
        ServicesFormateur sfm = new ServicesFormateur();
        
        
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        ArrayList<ModuleFormation> module = (ArrayList) sm.getAll();
        if (empty || formation == null) {
            setText(null);
            setGraphic(null);
        } else {
            lblTitre.setText(formation.getNomFormation());
            for(Formateur fm:formateur){
                if(fm.getId()==formation.getIdFormateur()){
                    lblFormateur.setText(fm.getNomFormateur() + " " + fm.getPrenomFormateur());
                }
            }
            lblDesc.setText(formation.getDescriptionFormation());
            lblnv.setText(Integer.toString(formation.getNiveauFormation()));
            lblimg.setText(formation.getImageFormation());
            setGraphic(gridPane);
        }
    }
}

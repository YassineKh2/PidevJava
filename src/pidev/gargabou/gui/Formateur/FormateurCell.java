/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.gui.Formateur;

/**
 *
 * @author MsiAs
 */
import com.jfoenix.controls.JFXListCell;
import java.util.ArrayList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import pidev.gargabou.entites.Formateur;

/**
 *
 * @author MsiAs
 */
public class FormateurCell extends JFXListCell<Formateur> {
    private GridPane gridPane = new GridPane();
    private Label lblTitre = new Label();
    private Label lblSexe = new Label();
    private Label lblEmail = new Label();
    private Label lblNum = new Label();
    private Label lblimg = new Label();

    public FormateurCell() {
        super();
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.getRowConstraints().add(new RowConstraints(30));

        gridPane.add(lblTitre, 0, 0);
        gridPane.add(lblimg, 1, 0);
        gridPane.add(lblEmail, 2, 0);
        gridPane.add(lblSexe, 3, 0);
        gridPane.add(lblNum, 4, 0);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }

    @Override
    protected void updateItem(Formateur formateur, boolean empty) {
        super.updateItem(formateur, empty);
        
        if (empty || formateur == null) {
            setText(null);
            setGraphic(null);
        } else {
            lblTitre.setText(formateur.getNomFormateur() + " " + formateur.getPrenomFormateur());
            
            lblimg.setText(formateur.getImageFormateur());
                
            
            lblSexe.setText(formateur.getSexeFormateur());
            lblEmail.setText(formateur.getEmailFormateur());
            lblNum.setText(Integer.toString(formateur.getNumTelFormateur()));
            setGraphic(gridPane);
        }
    }
}


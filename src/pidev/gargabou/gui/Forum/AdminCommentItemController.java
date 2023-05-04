/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.gargabou.entites.CommantairePublication;
import pidev.gargabou.services.CommantaireService;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AdminCommentItemController implements Initializable {

    @FXML
    private ImageView fxUserImg;
    @FXML
    private Label fxDateComent;
    @FXML
    private Label fxContenuComent;
    @FXML
    private Label fxComentId;
    @FXML
    private Label fxPubId;
    @FXML
    private Label fxUserNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setCommentaire(CommantairePublication coment) {
        int idcoment = coment.getId();
        String idc = Integer.toString(idcoment);
        fxComentId.setText(idc);
        int idPub = coment.getIdPublication();
        String idP = Integer.toString(idPub);
        fxPubId.setText(idP);
        fxContenuComent.setText(coment.getContenuCommantaire());
        fxDateComent.setText(coment.getDateCommantaire().toString());

    }

    @FXML
    private void supprimerComment(ActionEvent event) throws SQLException {
        try {
            String idC = fxComentId.getText();
            int idComent = Integer.parseInt(idC);
            System.out.println(idComent);
            CommantaireService ps = new CommantaireService();
            ps.supprimer(idComent);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("are you sure!");
            alert.showAndWait();

            MenuItem menuItem = (MenuItem) event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentairesPub.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) menuItem.getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

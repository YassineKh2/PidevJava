/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pidev.gargabou.entites.CommantairePublication;
import pidev.gargabou.entites.Publication;
import pidev.gargabou.services.CommantaireService;
import pidev.gargabou.services.PublicationService;
import pidev.gargabou.services.ReactionPublicationService;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AdminPubItemController implements Initializable {

    @FXML
    private ImageView fxUserPic;
    @FXML
    private Label fxUserNom;
    @FXML
    private Label fxDatePub;
    @FXML
    private Label fxContenuPub;
    @FXML
    private ImageView fxImagePub;
    @FXML
    private MenuItem btnSupprimerPub;
    @FXML
    private Label fxIdPub;
    @FXML
    private Label fxPathImage;
    @FXML
    private Label fxNbrLikes;
    private int idpub;
    @FXML
    private Label fxbaned;
    @FXML
    private MenuItem btnBan;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void setPublication(Publication pub) throws SQLException {

        Image image = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/" + pub.getImageForum(), true);

        fxContenuPub.setText(pub.getContenuPublication());
        fxImagePub.setImage(image);
        fxDatePub.setText(pub.getDatePublication().toString());
        idpub = pub.getId();
        // String idP = Integer.toString(idPub);
        //   fxIdPub.setText(idP);
        fxPathImage.setText(pub.getImageForum());
        ReactionPublicationService rps = new ReactionPublicationService();
        fxNbrLikes.setText(String.valueOf(rps.countLikes(idpub)));
        if(pub.isIsBanned()){
            fxbaned.setText("Banned");
            btnBan.setDisable(true);
        }
        
    }    

    @FXML
    private void SupprimerPub(ActionEvent event) throws SQLException {
        try {
            int idPub = idpub;
            PublicationService ps = new PublicationService();
            ps.supprimer(idPub);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("are you sure!");
            alert.showAndWait();

            MenuItem menuItem = (MenuItem) event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminAllPubs.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) menuItem.getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
        private void downloadPdf(ActionEvent event) throws FileNotFoundException, DocumentException, SQLException, BadElementException, IOException {

        try {
            PublicationService ps = new PublicationService();
            Publication pub = ps.recupererParId(idpub);

            // Create a new PDF document
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home") + "/Downloads/pdf/Publication_" + idpub + ".pdf"));

            // Open the document
            document.open();
            // Get the PdfContentByte object from the PdfWriter
            PdfContentByte canvas = writer.getDirectContent();
            // Set the stroke color to #3929E0
            canvas.setColorStroke(new BaseColor(57, 41, 224));
            // Draw a rectangle around the entire page
            canvas.rectangle(document.left(), document.bottom(), document.right() - document.left(), document.top() - document.bottom());
            canvas.stroke();
            //
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(new File("C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/" + pub.getImageForum()).getAbsolutePath());
            image.scaleAbsolute(200f, 200f);
            image.setAlignment(Element.ALIGN_CENTER);
            Paragraph paragraph = new Paragraph(pub.getContenuPublication());
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(image);
            // Close the document
            document.close();

            // Show a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Telechargement réussie");
            alert.setContentText("pdf de cet publication sauvgargé 'C:/Users/Anas/Downloads/pdfFiles/Publication_" + idpub + ".pdf'");
            alert.showAndWait();
        } catch (Exception e) {
            // Show an error message if an exception occurs
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur lors de l'impression");
            alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des sponsors.");
            alert.showAndWait();
            System.out.println(e.getMessage());

        }

    }


    @FXML
    private void AfficherCommentaires(ActionEvent event) throws SQLException {
        try {
//            Publication pub = new Publication();
//            PublicationService psi = new PublicationService();
//            pub = psi.recupererParId (Integer.parseInt(fxIdPub.getText()));
            CommantaireService cs = new CommantaireService();
            ArrayList<CommantairePublication> commentaires = (ArrayList<CommantairePublication>) cs.recupererParpublication(idpub);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminCommentsPub.fxml"));
            Parent root = loader.load();
            Dialog dialog = new Dialog();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            dialog.getDialogPane().setContent(root);
            AdminCommentsPubController ShowPub = loader.getController();

            ShowPub.setListComments(commentaires);
            dialog.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void banPub(ActionEvent event) throws SQLException {
        PublicationService ps = new PublicationService();
        Publication pub = ps.recupererParId(idpub);
        ps.banPub(pub);
        btnBan.setDisable(true);
        ps.recuperer();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Publication banner!");
        alert.showAndWait();
    }
    
}

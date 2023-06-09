/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Centre;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.twilio.rest.preview.sync.service.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.gui.Formation.IAFormationController;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;
import pidev.gargabou.utils.changeScene;

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
    private JFXButton util;
    @FXML
    private JFXButton approve;
    @FXML
    private JFXButton fxGoToForum;
    @FXML
    private JFXButton fxGoToCategorie;
    @FXML
    private JFXButton fxGoToArticle;
    @FXML
    private JFXButton fxGoToEvenement;
    @FXML
    private JFXButton fxGoToOrganisateur;
    @FXML
    private JFXButton fxGoToAdresse;
    @FXML
    private JFXButton fxGoToCentre;
    @FXML
    private Button btnPdf;
        
    @FXML
    void open_addPlanning(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("AjoutPlanning.fxml"));
        listPlanningPane.getChildren().removeAll();
        listPlanningPane.getChildren().setAll(fxml);
    }
    
    void open_ListGestion() throws IOException{
         Parent fxml = FXMLLoader.load(getClass().getResource("gestionCentrePlanning.fxml"));
         listPlanningPane.getChildren().removeAll();
         listPlanningPane.getChildren().setAll(fxml);
     }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherPlanningCentre();
         fxGoToForum.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Forum/AdminAllPubs.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
           fxGoToArticle.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/HomeArticle.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            fxGoToCategorie.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/HomeCategorie.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); fxGoToEvenement.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/evenement/HomeEvenement.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         fxGoToAdresse.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/adresse/HomeAdresse.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); fxGoToOrganisateur.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/organisateur/HomeOrganisateur.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         fxGoToCentre.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Centre/ListCentreBack.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
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
    
    
    @FXML
    void genererPDF(MouseEvent event) {
        // Afficher la boîte de dialogue de sélection de fichier
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le fichier PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers PDF", "*.pdf"));
        File selectedFile = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            // Générer le fichier PDF avec l'emplacement de sauvegarde sélectionné
            // Récupérer la liste des produits
            PlanningCentreService pcs = new PlanningCentreService();
            List<PlanningCentre> planningList = pcs.recuperer();

            try {
                // Créer le document PDF
                com.itextpdf.text.Document document = new com.itextpdf.text.Document();
                PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
                document.open();

                // Créer une instance de l'image
                /*Image image = Image.getInstance(System.getProperty("user.dir") + "/src/images/LogoGymBlack.png");

                // Positionner l'image en haut à gauche
                image.setAbsolutePosition(5, document.getPageSize().getHeight() - 120);

                // Modifier la taille de l'image
                image.scaleAbsolute(152, 100);

                // Ajouter l'image au document
                document.add(image);*/

                // Créer une police personnalisée pour la date
                Font fontDate = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
                BaseColor color = new BaseColor(114, 0, 0); // Rouge: 114, Vert: 0, Bleu: 0
                fontDate.setColor(color); // Définir la couleur de la police

                // Créer un paragraphe avec le lieu
                Paragraph tunis = new Paragraph("Ariana", fontDate);
                tunis.setIndentationLeft(455); // Définir la position horizontale
                tunis.setSpacingBefore(-30); // Définir la position verticale
                // Ajouter le paragraphe au document
                document.add(tunis);

                // Obtenir la date d'aujourd'hui
                LocalDate today = LocalDate.now();

                // Créer un paragraphe avec la date
                Paragraph date = new Paragraph(today.toString(), fontDate);

                date.setIndentationLeft(437); // Définir la position horizontale
                date.setSpacingBefore(1); // Définir la position verticale
                // Ajouter le paragraphe au document
                document.add(date);

                // Créer une police personnalisée
                Font font = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD);
                BaseColor titleColor = new BaseColor(114, 0, 0); //
                font.setColor(titleColor);

                // Ajouter le contenu au document
                Paragraph title = new Paragraph("Liste des plannings", font);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingBefore(50); // Ajouter une marge avant le titre pour l'éloigner de l'image
                title.setSpacingAfter(20);
                document.add(title);

                PdfPTable table = new PdfPTable(5); // 5 colonnes pour les 5 attributs des activités
                table.setWidthPercentage(100);
                table.setSpacingBefore(30f);
                table.setSpacingAfter(30f);

                // Ajouter les en-têtes de colonnes
                Font hrFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
                BaseColor hrColor = new BaseColor(255, 255, 255); //
                hrFont.setColor(hrColor);

                PdfPCell cell1 = new PdfPCell(new Paragraph("Centre", hrFont));
                BaseColor bgColor = new BaseColor(114, 0, 0);
                cell1.setBackgroundColor(bgColor);
                cell1.setBorderColor(titleColor);
                cell1.setPaddingTop(20);
                cell1.setPaddingBottom(20);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell2 = new PdfPCell(new Paragraph("Date Debut", hrFont));
                cell2.setBackgroundColor(bgColor);
                cell2.setBorderColor(titleColor);
                cell2.setPaddingTop(20);
                cell2.setPaddingBottom(20);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell3 = new PdfPCell(new Paragraph("Date Fin", hrFont));
                cell3.setBackgroundColor(bgColor);
                cell3.setBorderColor(titleColor);
                cell3.setPaddingTop(20);
                cell3.setPaddingBottom(20);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell4 = new PdfPCell(new Paragraph("Titre", hrFont));
                cell4.setBackgroundColor(bgColor);
                cell4.setBorderColor(titleColor);
                cell4.setPaddingTop(20);
                cell4.setPaddingBottom(20);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell5 = new PdfPCell(new Paragraph("Description", hrFont));
                cell5.setBackgroundColor(bgColor);
                cell5.setBorderColor(titleColor);
                cell5.setPaddingTop(20);
                cell5.setPaddingBottom(20);
                cell5.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);

                Font hdFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);
                BaseColor hdColor = new BaseColor(255, 255, 255); //
                hrFont.setColor(hdColor);
                // Ajouter les données des produits
                for (PlanningCentre pc : planningList) {
                    PdfPCell cellR1 = new PdfPCell(new Paragraph(String.valueOf(pc.getIdCentre()), hdFont));
                    cellR1.setBorderColor(titleColor);
                    cellR1.setPaddingTop(10);
                    cellR1.setPaddingBottom(10);
                    cellR1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellR1);

                    PdfPCell cellR2 = new PdfPCell(new Paragraph(String.valueOf(pc.getDateDebutPlanning()), hdFont));
                    cellR2.setBorderColor(titleColor);
                    cellR2.setPaddingTop(10);
                    cellR2.setPaddingBottom(10);
                    cellR2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellR2);

                    PdfPCell cellR3 = new PdfPCell(new Paragraph(String.valueOf(pc.getDateFinPlanning()), hdFont));
                    cellR3.setBorderColor(titleColor);
                    cellR3.setPaddingTop(10);
                    cellR3.setPaddingBottom(10);
                    cellR3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellR3);

                    PdfPCell cellR4 = new PdfPCell(new Paragraph(pc.getTitre(), hdFont));
                    cellR4.setBorderColor(titleColor);
                    cellR4.setPaddingTop(10);
                    cellR4.setPaddingBottom(10);
                    cellR4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellR4);

                    PdfPCell cellR5 = new PdfPCell(
                            new Paragraph(pc.getDescription(), hdFont));
                    cellR5.setBorderColor(titleColor);
                    cellR5.setPaddingTop(10);
                    cellR5.setPaddingBottom(10);
                    cellR5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellR5);

                }
                table.setSpacingBefore(20);
                document.add(table);
                document.close();

                System.out.println("Le fichier PDF a été généré avec succès.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    
    }

    @FXML
    private void show(ActionEvent event) {
    }

    @FXML
    private void showapp(ActionEvent event) {
    }

    @FXML
    private void showban(ActionEvent event) {
    }



    
}

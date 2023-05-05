/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.services.ServiceArticles;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pidev.gargabou.gui.Formation.IAFormationController;
import pidev.gargabou.utils.changeScene;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleHomeController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_pending;
    @FXML
    private JFXButton fxAjouterArticle;
    @FXML
    private JFXButton fxGoToCateogrie;
    @FXML
    private JFXButton fxArticleExcel;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        fxGoToCateogrie.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeCategorie.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        fxAjouterArticle.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterArticle.fxml"));
                Parent root = loader.load(); // load the new FXML file
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        fxArticleExcel.setOnAction(event -> {
            final String[] columns = {"ID", "ID de catégorie", "Nom de l'article", "Prix", "Quantité", "Description", "Réduction (%)", "Nombre de ventes"};
            ServiceArticles sa = new ServiceArticles();
            final List<Article> data = sa.getAll(); // List of Article objects with data

            // Generate Excel file and fill it with data
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = (Sheet) workbook.createSheet("Articles");

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Create data rows
            int rowNum = 1;
            for (Article article : data) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(article.getId());
                row.createCell(1).setCellValue(article.getIdCategorie());
                row.createCell(2).setCellValue(article.getNomArticle());
                row.createCell(3).setCellValue(article.getPrixArticle());
                row.createCell(4).setCellValue(article.getQuantiteArticle());
                row.createCell(5).setCellValue(article.getArticleDiscription());
                row.createCell(6).setCellValue(article.getRemisePourcentageArticle());
                row.createCell(7).setCellValue(article.getSaleNumberArticle());
            }

            // Autosize columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Save workbook to file
            try {
                FileOutputStream outputStream = new FileOutputStream("Articles.xlsx");
                workbook.write(outputStream);
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        refreshNodes();
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();
        ServiceArticles Sa = new ServiceArticles();

        ArrayList<Article> Articles = (ArrayList) Sa.getAll();

        System.out.println();
        Node[] nodes = new Node[Articles.size()];

        for (int i = 0; i < Articles.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleItem.fxml"));
                Node node = (Node) loader.load();
                ArticleItemController controller = loader.getController();
                controller.setArticle(Articles.get(i));

                pnl_scroll.getChildren().add(node);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceArticles;
import pidev.gargabou.services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ModiferArticleController implements Initializable {

    @FXML
    private JFXButton fxAjouterCategorie;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton fxGoToArticle;
    @FXML
    private TextField fxNomArticle;
    @FXML
    private TextField fxQuantiteArticle;
    @FXML
    private TextField fxPrixArticle;
    @FXML
    private TextArea fxDescriptionArticle;
    @FXML
    private TextField fxImageArticle;
    @FXML
    private TextField fxRemiseArticle;
    @FXML
    private JFXButton fxAnnulerArticle;
    @FXML
    private ComboBox<String> fxIdCategorieArticle;
    @FXML
    private JFXButton fxModiferArticle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceCategorie sp = new ServiceCategorie();
         ArrayList<Categorie> Categ = (ArrayList<Categorie>) sp.getAll();
         for(Categorie Cat : Categ)
         {
         fxIdCategorieArticle.getItems().add(Cat.getNomCategorie());
         }
        fxModiferArticle.setOnAction( event -> {
            try{
               String NomArticle = fxNomArticle.getText();
               int Quantite = Integer.parseInt(fxQuantiteArticle.getText());
               Float Prix = Float.parseFloat(fxPrixArticle.getText());
               String CateogireSelected = fxIdCategorieArticle.getValue();
               String DescriptionArticle = fxDescriptionArticle.getText();
               String ImageArticle = fxImageArticle.getText();
               Float resmise = Float.parseFloat(fxRemiseArticle.getText());
               Categorie Catego = sp.FindCategorieByName(CateogireSelected);
               int IdCateg = Catego.getId();
               
               Article Arc = new Article(IdCateg,NomArticle,Prix,Quantite,ImageArticle,DescriptionArticle,resmise,0);
               ServiceArticles Sa = new ServiceArticles();
               Sa.ajouter(Arc);
               
               /*ArrayList<Article> Article = Catego.getArticles();
               Article.add(Arc);
               Catego.setArticles(Article);*/
               
               
               FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeArticle.fxml"));
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
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
   
    
    
    public void setNomArticle(String message){
    fxNomArticle.setText(message);
}
   public void QuantiteArticle(String message){
    fxQuantiteArticle.setText(message);
   }
   public void PrixArticle(String message){
    fxPrixArticle.setText(message);
   }
   public void DescriptionArticle(String message){
    fxDescriptionArticle.setText(message);
   }
   public void RemiseArticle(String message){
       fxRemiseArticle.setText(message);
   }
}

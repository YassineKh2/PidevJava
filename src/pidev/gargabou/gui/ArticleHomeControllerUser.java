/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.gui.Formation.IAFormationController;
import pidev.gargabou.services.ServiceArticles;
import pidev.gargabou.services.ServiceCategorie;
import pidev.gargabou.utils.changeScene;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ArticleHomeControllerUser implements Initializable {

    @FXML
    private JFXButton fxAjouterArticle;
    @FXML
    private GridPane pnl_scroll;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label fxIdCategorie;
    @FXML
    private JFXButton fxRetourCategorie;
    @FXML
    private JFXButton fxGoToCentres;
    @FXML
    private JFXButton fxGoToTherapist;
    @FXML
    private JFXButton fxGoToShop;
    @FXML
    private JFXButton fxGoToForum;
    @FXML
    private JFXButton fxGoToEvent;
    @FXML
    private JFXButton fxGoToFormation;
    @FXML
    private JFXButton fxGoToSession;
    @FXML
    private JFXButton profileshow;
    @FXML
    private JFXButton logoutbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         fxGoToForum.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Forum/IAPublication.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         profileshow.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/HomeF.fxml", "Profile");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToSession.setOnAction(e -> {
            Formation.Choose = 2;
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Formation/IAFormation.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(HomeFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToFormation.setOnAction(e -> {
            Formation.Choose = 1;
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Formation/IAFormation.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(HomeFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToEvent.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/evenement/FrontHomeEvenement.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToShop.setOnAction(e->{
            try {
                changeScene.changeScene(e, "HomeCategorieUser.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         fxGoToCentres.setOnAction(e->{
             try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Centre/gestionCentrePlanning.fxml", "");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        // TODO
        refreshNodes();
        fxRetourCategorie.setOnAction( event ->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeCategorieUser.fxml"));
                Parent root = loader.load(); // load the new FXML file
                CategorieHomeUserController controller = loader.getController();
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
    @FXML
    public void lbara() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                userNow.kahaw();
                logoutbtn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
        }

    }
    public void refreshNodes() {

        // System.out.println(fxIdCategorie.getText());
        String nameC = fxIdCategorie.getText();

      
        ServiceCategorie Sc = new ServiceCategorie();
        int idc = Categorie.getIdc();
        Categorie categ = Sc.FindOne(idc);
       
       
        pnl_scroll.getChildren().clear();
        ServiceArticles Sa = new ServiceArticles();

        ArrayList<Article> Articles = categ.getArticles();
      
       
        
   
        int column=1;
        int row=1; 

       // Node[] nodes = new Node[Articles.size()];

        for (int i = 0; i < Articles.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleItemUser.fxml"));
                Node node = (Node) loader.load();
                ArticleItemControllerUser controller = loader.getController();
                controller.setArticle(Articles.get(i));
                if(column == 3){
                  column = 1;
                  ++row;
                }
                pnl_scroll.add(node, ++column, row);
                 GridPane.setMargin(node,new Insets(10));
                //pnl_scroll.getChildren().add(node);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public int getCateg(){
        
        
        return 0;
        
    }
    public void setIdCateg(String mesasge) {
        fxIdCategorie.setText(mesasge);
    }

    @FXML
    private void show(ActionEvent event) {
    }

}

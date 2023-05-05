/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Formation;

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
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.CLOSE;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.Session;
import pidev.gargabou.entites.User;
import pidev.gargabou.gui.CategorieHomeUserController;
import pidev.gargabou.gui.HomeUserController;
import pidev.gargabou.gui.Session.Card_SessionController;
import pidev.gargabou.services.ServicesFormation;
import pidev.gargabou.services.ServicesSession;
import pidev.gargabou.services.userCRUD;
import pidev.gargabou.utils.changeScene;
import pidev.gargabou.utils.userNow;

public class IAFormationController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private JFXButton handle_ajout;
    @FXML
    private JFXButton handle_ajout1;
    @FXML
    private JFXButton handle_ajout2;
    @FXML
    private JFXButton show_formation;
    @FXML
    private JFXButton show_session;
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
    private ImageView user_img;
    @FXML
    private Label user_pseudo;
    @FXML
    private JFXButton profileshow;
    @FXML
    private JFXButton logoutbtn;

    @FXML
    private void handleButtonAction(MouseEvent event) {
        refreshFormation();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userCRUD uc = new userCRUD();
        ArrayList<User> user = (ArrayList) uc.getAll();
        fxGoToShop.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/HomeCategorieUser.fxml"));
                Parent root = loader.load(); // load the new FXML file
                CategorieHomeUserController controller = loader.getController();
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
            } catch (IOException ex) {
                Logger.getLogger(HomeUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        if (Formation.Choose == 1) {
            refreshFormation();
        } else {
            refreshSession();
        }
        handle_ajout.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AllFormation.fxml"));
            Dialog dialog = new Dialog();
            dialog.setTitle("Interface Admin Formation");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            try {
                dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
                // handle exception
            }
            dialog.show();
        });
        handle_ajout1.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/Module/AllModule.fxml"));
            Dialog dialog = new Dialog();
            dialog.setTitle("Interface Admin Module Formation");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            try {
                dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
                // handle exception
            }
            dialog.show();
        });
        handle_ajout2.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/Formateur/AllFormateur.fxml"));
            Dialog dialog = new Dialog();
            dialog.setTitle("Interface Admin Formateur");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            try {
                dialog.getDialogPane().setContent(loader.load());
            } catch (IOException ex) {
                // handle exception
            }
            dialog.show();
        });
        show_session.setOnMouseClicked(e -> {
            Formation.Choose = 2;
            handle_ajout.setVisible(false);
            handle_ajout1.setVisible(false);
            handle_ajout2.setVisible(false);
            refreshSession();
        });
        show_formation.setOnMouseClicked(e -> {
            Formation.Choose = 1;
            lbl_currentprojects.setText("Tous les Formations");
            handle_ajout.setVisible(true);
            handle_ajout1.setVisible(true);
            handle_ajout2.setVisible(true);
            refreshFormation();
            
            lbl_currentprojects.setOnMouseClicked(ev -> {
                refreshFormation();
            });
            
            
        });
        fxGoToForum.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/Forum/IAPublication.fxml", "Forum");
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fxGoToEvent.setOnAction(e->{
            try {
                changeScene.changeScene(e, "/pidev/gargabou/gui/evenement/FrontHomeEvenement.fxml", "Evenement");
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
        logoutbtn.setOnAction(e->{
            lbara();
        });
        
        
        
        for (User us : user) {
            if (userNow.getid() == us.getId()) {
                System.out.println(userNow.getid());
                Image img_f = new Image("file:C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/uploads/" + us.getImage(), true);
                user_img.setImage(img_f);
                user_pseudo.setText(us.getPseudoUtilisateur());
                if (us.getRoles().contains("[\"ROLE_ADMIN\"]")) {
                    handle_ajout.setVisible(true);
                    handle_ajout1.setVisible(true);
                    handle_ajout2.setVisible(true);
                } else {
                    handle_ajout.setVisible(false);
                    handle_ajout1.setVisible(false);
                    handle_ajout2.setVisible(false);
                }
            }

        }

    }

    private void refreshFormation() {
        userCRUD uc = new userCRUD();
        ArrayList<User> user = (ArrayList) uc.getAll();
        for (User us : user) {
            if (userNow.getid() == us.getId()) {
                
                if (us.getRoles().equals("[\"ROLE_ADMIN\"]")) {
                    handle_ajout.setVisible(true);
                    handle_ajout1.setVisible(true);
                    handle_ajout2.setVisible(true);
                } else {
                    handle_ajout.setVisible(false);
                    handle_ajout1.setVisible(false);
                    handle_ajout2.setVisible(false);
                }
            }

        }

    
        pnl_scroll.getChildren().clear();
        
        ServicesFormation sf = new ServicesFormation();
        ArrayList<Formation> formation = (ArrayList<Formation>) sf.getAll();

        Node[] nodes = new Node[formation.size()];

        for (int i = 0; i < formation.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
                Node node = (Node) loader.load();
                ItemController controller = loader.getController();
                controller.setId(formation.get(i));

                controller.cns_detail.setOnMouseClicked(e -> {
                    try {
                        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("detailFormation.fxml"));

                        IAFormationController cntr = loader1.getController();
                        Node n = (Node) loader1.load();
                        pnl_scroll.getChildren().clear();
                        pnl_scroll.getChildren().add(n);

                    } catch (IOException ex) {
                        Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                pnl_scroll.getChildren().add(node);

            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void refreshSession() {
        ServicesSession s = new ServicesSession();
        ArrayList<Session> session = (ArrayList) s.getAll();
        pnl_scroll.getChildren().clear();
        for (int i = 0; i < session.size(); i++) {
            try {

                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/pidev/gargabou/gui/Session/Card_Session.fxml"));

                Node n = (Node) loader1.load();
                Card_SessionController cntr = loader1.getController();
                cntr.setData(session.get(i));

                pnl_scroll.getChildren().add(n);
                lbl_currentprojects.setText("Tous les Sessions");
                lbl_currentprojects.setOnMouseClicked(e -> {
                    refreshSession();
                });
            } catch (IOException ex) {
                Logger.getLogger(IAFormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
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
                Parent root = FXMLLoader.load(getClass().getResource("/pidev/gargabou/gui/Authentification.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
        }

    }

}

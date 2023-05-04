/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui.Formation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.User;
import pidev.gargabou.services.ServicesFormation;
import pidev.gargabou.utils.userNow;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class FormJoinController implements Initializable {

    @FXML
    private JFXTextArea tx_nom_user;
    @FXML
    private JFXTextArea tx_prenom_user;
    @FXML
    private JFXTextArea tx_mail_user;
    @FXML
    private JFXTextArea tx_num_user;
    @FXML
    private JFXButton btn_join_by_sms;
    @FXML
    private ImageView img_formation;
    @FXML
    private Label label_num;
    @FXML
    private Label label_mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicesFormation sf = new ServicesFormation();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        for(Formation f:formation){
            if(f.getId()==Formation.getChamp_id()){
                Image img_f = new Image("file:/C:/Users/yassine/Desktop/9raya/Pidev/ProjIng/public/"+f.getImageFormation(), true);
                    img_formation.setImage(img_f);
                    img_formation.setFitHeight(276);
                    img_formation.setFitWidth(609);
            }
        
    }
        tx_mail_user.setOnKeyPressed(ec->{
            String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(tx_mail_user.getText());
                if(!matcher.matches()){
                    
                    ec.consume();
                    label_mail.getStyleClass().add("error");
                    label_mail.setText("veillez un email de la form example@gmail.com");
                      
                }
                else{
                    label_mail.setText("");
                }
            });
        tx_num_user.setOnKeyTyped(ec->{
                if(ec.getCharacter().matches("[a-zA-Z]")){
                    
                    ec.consume();
                    label_num.getStyleClass().add("error");
                    label_num.setText("veiller entrer des nombres");
                    
                    
                    
                }
                else{
                    label_num.setText("");
                }
                
            });
        btn_join_by_sms.setOnAction(e->{
                SendSms sms = new SendSms();
                Formation.setUserid(userNow.getid());
                System.out.println(Formation.getUserid());
                sms.send_SMS(Integer.parseInt(tx_num_user.getText()));
                JOptionPane.showMessageDialog(null,"Votre Code a été Envoyer à votre numéro"); 
                System.out.println("sent");
                
                
            
        });
    
}}

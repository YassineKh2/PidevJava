/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.esprit.entities.Formateur;
import edu.esprit.entities.Formation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.HTMLEditor;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MsiAs
 */
public class ContactFormateurController implements Initializable {

    @FXML
    private JFXTextArea tx_mail_fr;
    @FXML
    private JFXTextArea tx_mail_user;
    @FXML
    private JFXButton btn_send_mail;
    @FXML
    private HTMLEditor tx_ctn_mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tx_mail_fr.setEditable(false);
        tx_mail_fr.setDisable(true);
        tx_mail_user.setPromptText("Votre Email");
        
        ServicesFormateur sfm = new ServicesFormateur();
        ServicesFormation sf = new ServicesFormation();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        
        Map<String, String> data = new HashMap<>();
                data.put("emailSubject", "Email de Contact");
                
        for(Formation f:formation){
            if(Formation.getChamp_id()==f.getId()){
            for(Formateur fm:formateur){
                if(fm.getId()==f.getIdFormateur()){
                    tx_mail_fr.setText(fm.getEmailFormateur());
                }
            }
            }
        }
        

        btn_send_mail.setOnAction(e ->{    
            try {
                SendEmail.send(tx_mail_user.getText(), tx_ctn_mail.getHtmlText(),data,tx_mail_fr.getText());
                JOptionPane.showMessageDialog(null,"Votre mail est Envoyé"); 
                System.out.println("sent");
            } catch (MessagingException ex) {
                Logger.getLogger(ContactFormateurController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Please check your internet connection");
            }
            
           
        });
    }    
    
}

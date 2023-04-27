/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author MsiAs
 */
public class SendSms {
    void send_SMS (int num){
        // Initialisation de la bibliothèque Twilio avec les informations de votre compte
        String ACCOUNT_SID = "ACbf5cbc7ecda1d5c1e74b536c427c51bc";
        String AUTH_TOKEN = "8ec354e481f9b046db64939fc376fc97";
             
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String recipientNumber = "+216" + num;
            String message = "Bonjour Mr/Ms ,\n"
                    + "Celui-ci c'est votre Code de joindre :"+"ACbf5cbc7 \n"
                    + "le lien pour joindre va étre envoyer depuis votre mail\n "
                    + "Merci d'étre interresé à notre Formation\n"
                    + "Cordialement,\n"
                    + "RehabRadar";
                
            Message twilioMessage = Message.creator(
                new PhoneNumber(recipientNumber),
                new PhoneNumber("+16206229853"),message).create();
                
            System.out.println("SMS envoyé : " + twilioMessage.getSid());
            

        
         
     }
}

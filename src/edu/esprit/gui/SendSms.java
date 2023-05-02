/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Random;

/**
 *
 * @author MsiAs
 */
public class SendSms {
    void send_SMS (int num){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
        // Initialisation de la bibliothèque Twilio avec les informations de votre compte
        String ACCOUNT_SID = "ACbf5cbc7ecda1d5c1e74b536c427c51bc";
        String AUTH_TOKEN = "1dbb6aeeb88806717748ab6b35089357";
             
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String recipientNumber = "+216" + num;
            String message = "Bonjour Mr/Ms ,\n"
                    + "Celui-ci c'est votre Code de joindre : "+ generatedString +"\n"
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

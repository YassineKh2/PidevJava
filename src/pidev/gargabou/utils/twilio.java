/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.utils;

/**
 *
 * @author alisl
 */

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class twilio {
  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID = "AC2277d555302c574d80cc9d2e51bc43fa";
  public static final String AUTH_TOKEN = "a7b3e8d2bfb37eae575461edee8ad1f3";

  public static void sms() {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber("+21628488443"),
      new com.twilio.type.PhoneNumber("+15674853710"),
      "vous aves etes approvee dans Rehab Radar"

    ).create();

    System.out.println(message.getSid());
  }
}
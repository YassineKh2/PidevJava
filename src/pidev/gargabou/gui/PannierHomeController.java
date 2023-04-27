/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.gargabou.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Payment;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class PannierHomeController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton fxGoToCateogrie;
    @FXML
    private Label fxPrixTotal;
    @FXML
    private JFXButton fxPayerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxGoToCateogrie.setOnAction(event -> {
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
        fxPayerButton.setOnAction(event -> {
            float totalprice = 0;
            ArrayList<Article> Articles = Payment.getPannier();
            ArrayList<Integer> Quantite = Payment.getQuntite();
            try {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");

                String username = "rehabradar123@gmail.com";
                String password = "kglifegaigjdcdix";

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("rehabradar123@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yassinekhemiri@ieee.org"));
                message.setSubject("Merci pour votre achat !");
                String htmlContent = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <title>Receipt</title>\n"
                        + "    <meta charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <style>\n"
                        + "        body {\n"
                        + "            font-family: Arial, sans-serif;\n"
                        + "            font-size: 14px;\n"
                        + "            line-height: 1.5;\n"
                        + "            color: #333;\n"
                        + "            margin: 0;\n"
                        + "            padding: 0;\n"
                        + "        }\n"
                        + "        .container {\n"
                        + "            max-width: 600px;\n"
                        + "            margin: 0 auto;\n"
                        + "            padding: 20px;\n"
                        + "            background-color: #f7f7f7;\n"
                        + "            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n"
                        + "        }\n"
                        + "        h1 {\n"
                        + "            font-size: 24px;\n"
                        + "            margin-bottom: 20px;\n"
                        + "        }\n"
                        + "        table {\n"
                        + "            width: 100%;\n"
                        + "            border-collapse: collapse;\n"
                        + "            margin-bottom: 20px;\n"
                        + "        }\n"
                        + "        table th {\n"
                        + "            font-weight: bold;\n"
                        + "            background-color: #eee;\n"
                        + "            padding: 10px;\n"
                        + "            text-align: left;\n"
                        + "            border-bottom: 2px solid #ccc;\n"
                        + "        }\n"
                        + "        table td {\n"
                        + "            padding: 10px;\n"
                        + "            border-bottom: 1px solid #ccc;\n"
                        + "        }\n"
                        + "        .total {\n"
                        + "            font-weight: bold;\n"
                        + "            font-size: 18px;\n"
                        + "            margin-top: 20px;\n"
                        + "            text-align: right;\n"
                        + "        }\n"
                        + "    </style>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<div class=\"container\">\n"
                        + "    <a href=\"http://127.0.0.1:8000/index\" class=\"logo me-auto\"><img src=\"C:\\Users\\yassine\\Desktop\\ProjIng\\public\\{{ asset('Front/img/logo.png') }}\" alt=\"\" class=\"img-fluid\" style=\"height: 100px; width: 100px\"> <h1 class=\"logo me-auto\"><a href=\"#\">Rehab Radar</a></h1></a>\n"
                        + "    <h1>Receipt</h1>\n"
                        + "    <table>\n"
                        + "        <thead>\n"
                        + "        <tr>\n"
                        + "            <th>Image</th>\n"
                        + "            <th>Nom</th>\n"
                        + "            <th>Prix</th>\n"
                        + "            <th>Quantite</th>\n"
                        + "            <th>Remise</th>\n"
                        + "            <th>Total</th>\n"
                        + "        </tr>\n"
                        + "        </thead>\n"
                        + "        <tbody>\n";
                for (Article arc : Articles) {
                    int index = Articles.indexOf(arc);
                    int quantity = Quantite.get(index);
                    float totatp = arc.getPrixArticle() * quantity;
                    float totalArcPrice = totatp - ((totatp * arc.getRemisePourcentageArticle()) / 100);
                  
                        htmlContent += "<tr>\n"
                                + "<td><img src=\"" +arc.getImageArticle()+ "\" alt=\"\" style=\"width: 50px;\"></td>"
                                + "<td>" + arc.getNomArticle() + "</td>\n"
                                + "<td>" + arc.getPrixArticle() + "DT</td>\n"
                                + "<td>" + quantity + "</td>\n"
                                + "<td>" + arc.getRemisePourcentageArticle() + "%</td>\n"
                                + "<td>" + totalArcPrice + "</td>\n"
                                + "</tr>\n";
                        totalprice += totalArcPrice;
                        
                }

                htmlContent += "</tbody>\n"
                        + "    </table>\n"
                        + "  <h4>Prix Total = " + totalprice + " DT</h4>\n"
                        + "\n"
                        + "</div>\n"
                        + "<div class=\"container\">\n"
                        + "    <h1>Merci</h1>\n"
                        + "    <p>Cher(e) Client,</p>\n"
                        + "    <p>Nous tenons à vous remercier chaleureusement pour votre achat auprès de notre entreprise. Nous sommes ravis de vous compter parmi nos clients fidèles et nous espérons que vous avez été satisfait(e) de notre service et de nos produits.</p>\n"
                        + "    <p>Nous attachons une grande importance à la qualité de notre service clientèle et de nos produits, c'est pourquoi votre satisfaction est notre priorité absolue. Si vous avez des commentaires ou des suggestions à nous faire part, n'hésitez pas à nous contacter à tout moment.</p>\n"
                        + "    <p>Encore une fois, merci d'avoir choisi RehabRadar et nous espérons vous revoir bientôt pour votre prochain achat.</p>\n"
                        + "    <div class=\"signature\">Cordialement,<br>RehabRadar</div>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "</html>\n"
                        + "\n";
                message.setContent(htmlContent, "text/html");
                Transport.send(message);
                System.out.println("HTML email sent successfully");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePannierThanks.fxml"));
                Parent root = loader.load(); // load the new FXML file
                PannierHomeThanksController controller = loader.getController();
                Scene scene = new Scene(root); // create a new scene with the new FXML file as its content
                Node sourceNode = (Node) event.getSource(); // get the source node of the current event
                Scene currentScene = sourceNode.getScene(); // get the current scene from the source node
                Stage stage = (Stage) currentScene.getWindow(); // get the current stage
                stage.setScene(scene); // set the new scene as the content of the stage
                
            } catch (MessagingException ex) {
                Logger.getLogger(PannierHomeController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PannierHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        refreshNodes();
    }

    private void refreshNodes() {
        float prix = 0;
        pnl_scroll.getChildren().clear();

        ArrayList<Article> Aricles = Payment.getPannier();
        ArrayList<Integer> Quantite = Payment.getQuntite();

        Node[] nodes = new Node[Aricles.size()];

        for (int i = 0; i < Aricles.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ArticleItemUserPannier.fxml"));
                Node node = (Node) loader.load();
                ArticleItemControllerUserPannier controller = loader.getController();
                controller.setArticle(Aricles.get(i), Quantite.get(i));
                Article arc = Aricles.get(i);
                prix += arc.getPrixArticle() * Quantite.get(i);
                float discount = (prix * arc.getRemisePourcentageArticle()) / 100;
                prix = prix - discount;
                pnl_scroll.getChildren().add(node);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
        String prixtotal = Float.toString(prix);
        fxPrixTotal.setText(prixtotal);
    }

}

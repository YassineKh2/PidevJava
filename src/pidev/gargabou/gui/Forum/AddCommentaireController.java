/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.gui.Forum;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import pidev.gargabou.services.CommantaireService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import javax.mail.MessagingException;
import pidev.gargabou.entites.CommantairePublication;

import pidev.gargabou.services.EnvoyerEmail;

/**
 * FXML Controller class
 *
 * @author Anas
 */
public class AddCommentaireController implements Initializable {

    @FXML
    private JFXTextArea taContenuComment;
    @FXML
    private Label fxIdPub;
    private int idpub;
    /**
     * Initializes the controller class.
     */
    private String emailUser = "mohamedanas.atallah@esprit.tn";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
//    private static final String API_KEY = "Eyg9nN/aFmT08oZOH/rJsw==bKSz8jQPh6auqPC6";
//
//    public String filterComment(String comment) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        String url = "https://api.api-ninjas.com/v1/profanityfilter?text=";
//        String json = new Gson().toJson(new FilterRequest(comment));
//        RequestBody body = RequestBody.create(json, JSON);
//        Request request = new Request.Builder()
//                .url(url)
//                .addHeader("X-Api-Key", API_KEY)
//                .post(body)
//                .build();
//        Response response = client.newCall(request).execute();
//        if (!response.isSuccessful()) {
//            throw new IOException("Unexpected response code " + response);
//        }
//        System.out.println(response.body().string());
//        String filteredComment = new Gson().fromJson(response.body().string(), FilterResponse.class).getText();
//        return filteredComment;
//    }
//
//    private static class FilterRequest {
//
//        private final String text;
//
//        public FilterRequest(String text) {
//            this.text = text;
//        }
//
//        public String getText() {
//            return text;
//        }
//    }
//
//    private static class FilterResponse {
//
//        private final String text;
//
//        public FilterResponse(String text) {
//            this.text = text;
//        }
//
//        public String getText() {
//            return text;
//        }
//    }
//contenuComent = filterComment(contenuComent); // filter the comment
    @FXML
    private void addComment(ActionEvent event) throws SQLException, MessagingException {
    try {
        CommantaireService cs = new CommantaireService();
        if (taContenuComment.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ vide");
            alert.setHeaderText("Vous pouvez pas publier un commentaire vide!");
            alert.showAndWait();
        }
        else {
            // Define a list of bad words
            List<String> badWords = Arrays.asList("fuck", "asshole", "bitch", "damn");

            String contenuComent = taContenuComment.getText();
            Date dateComent = new Date();
            int id = idpub;

            // Replace bad words with asterisks
            for (String word : badWords) {
                String asterisks = new String(new char[word.length()]).replace('\0', '*');
                contenuComent = contenuComent.replaceAll("(?i)\\b" + word + "\\b", asterisks);
            }

            // Create the comment object and add it to the database
            CommantairePublication comment = new CommantairePublication(id, dateComent, contenuComent, 2);
            cs.ajouter(comment);
            sendEmail(emailUser, contenuComent );

            // Load the new FXML file and set it as the content of the stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IAPublication.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Node sourceNode = (Node) event.getSource();
            Scene currentScene = sourceNode.getScene();
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(scene);
        }
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
//@FXML
//private void addCommente(ActionEvent event) throws SQLException {
//    try {
//        CommantaireService cs = new CommantaireService();
//        if (taContenuComment.getText().isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Champ vide");
//            alert.setHeaderText("Vous pouvez pas publier un commentaire vide!");
//            alert.showAndWait();
//        } else {
//            String contenuComent = taContenuComment.getText();
//            
//            // Call Profanity Filter API to censor bad words
//            String apiKey = "YOUR_API_KEY_HERE";
//            String apiUrl = "https://api.api-ninjas.com/v1/profanityfilter?text=" + contenuComent;
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("X-Api-Key", apiKey);
//            connection.setRequestProperty("accept", "application/json");
//            InputStream responseStream = connection.getInputStream();
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode rot = mapper.readTree(responseStream);
//            String censoredComent = rot.path("censored").asText();
//            boolean hasProfanity = rot.path("has_profanity").asBoolean();
//            
//            if (hasProfanity) {
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Contenu inapproprié");
//                alert.setHeaderText("Votre commentaire contient des mots inappropriés.");
//                alert.setContentText("Le commentaire suivant sera publié : " + censoredComent);
//                alert.showAndWait();
//            }
//            
//            Date dateComent = new Date();
//            int id = Integer.parseInt(fxIdPub.getText());
//            CommantairePublication comment = new CommantairePublication(id, dateComent, censoredComent, 2);
//            cs.ajouter(comment);
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("IAPublication.fxml"));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            Node sourceNode = (Node) event.getSource();
//            Scene currentScene = sourceNode.getScene();
//            Stage stage = (Stage) currentScene.getWindow();
//            stage.setScene(scene);
//        }
//    } catch (Exception ex) {
//        System.out.println(ex.getMessage());
//    }
//}
    public void setIdPublication(int idpub) {
        this.idpub= idpub;
    }
    
    public void sendEmail( String email, String contenu) throws MessagingException {
    
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sending...");
            alert.setHeaderText("we just send u an email");
            alert.setContentText("Please check your e-mail box");
            alert.show();
            
            
            EnvoyerEmail.envoyer(email,contenu);
            
        
    }

}

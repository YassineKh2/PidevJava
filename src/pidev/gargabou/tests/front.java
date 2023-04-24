/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pidev.gargabou.tests;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
/**
 *
 * @author alisl
 */
public class front extends Application {
    
    private double x = 0;
    private double y = 0;
    @Override
    public void start(Stage primaryStage) throws IOException {
   
        Parent root = FXMLLoader.load(getClass().getResource("/pidev/gargabou/gui/authentification.fxml"));
        Scene scene = new Scene(root);
        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });
        
        
        root.setOnMouseDragged((MouseEvent event) ->{
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
            
            primaryStage.setOpacity(.8);
        });
        
        root.setOnMouseReleased((MouseEvent event) ->{
            primaryStage.setOpacity(1);
        });
        
        primaryStage.setTitle("Rehab Radar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

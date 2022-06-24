/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.prs.db.DBConnection;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class LoadingController implements Initializable {

    @FXML
    private AnchorPane loadingAnchPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        applyFadeTransition(loadingAnchPane, Duration.millis(1000), (evt) ->{
            try {
                Parent root=FXMLLoader.load(getClass().getResource("/lk/ijse/prs/view/logIn.fxml"));
                Scene temp=new Scene(root);
                Stage stage=(Stage) this.loadingAnchPane.getScene().getWindow();
                stage.setScene(temp);
                stage.centerOnScreen();
                
                TranslateTransition trans = new TranslateTransition(Duration.millis(300), temp.getRoot());
                trans.setFromY(-temp.getHeight());
                trans.setToY(0);
                trans.play();
                    
            } catch (IOException ex) {
                Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    public void applyFadeTransition(Node node, Duration duration, EventHandler<ActionEvent>event){
        javafx.animation.FadeTransition fadeIn1 = new javafx.animation.FadeTransition(duration, node);
        fadeIn1.setCycleCount(1);
        fadeIn1.setFromValue(0.6);
        fadeIn1.setToValue(1);
        fadeIn1.setAutoReverse(true);
        fadeIn1.setOnFinished(event);
        
        javafx.animation.FadeTransition fadeOut1 = new javafx.animation.FadeTransition(duration, node);
        fadeOut1.setCycleCount(1);
        fadeOut1.setFromValue(1);
        fadeOut1.setToValue(0.6);
        fadeOut1.setAutoReverse(true);
        
        javafx.animation.FadeTransition fadeIn2 = new javafx.animation.FadeTransition(duration, node);
        fadeIn2.setCycleCount(1);
        fadeIn2.setFromValue(0.6);
        fadeIn2.setToValue(1);
        fadeIn2.setAutoReverse(true);
        fadeIn2.setOnFinished(event);
        
        javafx.animation.FadeTransition fadeOut2 = new javafx.animation.FadeTransition(duration, node);
        fadeOut2.setCycleCount(1);
        fadeOut2.setFromValue(1);
        fadeOut2.setToValue(0.6);
        fadeOut2.setAutoReverse(true);
        fadeOut2.setOnFinished(event);
        
        fadeOut1.play();
        fadeOut1.setOnFinished((evt) -> {
            fadeIn1.play();
        });
        fadeIn1.setOnFinished((evt) -> {
            fadeOut2.play();
        });
        fadeOut2.setOnFinished((evt) -> {
            fadeIn2.play();
        });
      
    }    
    
}

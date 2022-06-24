/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.main;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.prs.controller.InOutBoardController;

/**
 *
 * @author Thushara Supun
 */
public class StartUp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/loading.fxml"));
        Scene temp=new Scene(root);
        primaryStage.setScene(temp);
        primaryStage.getIcons().add(new Image("/lk/ijse/prs/asset/logo_icon.png"));
        primaryStage.setTitle("WorkDay PayRoll System");
        primaryStage.centerOnScreen();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        
        Calendar thatTime = Calendar.getInstance();
        thatTime.set(Calendar.HOUR_OF_DAY, 11);
        thatTime.set(Calendar.MINUTE, 31);
        thatTime.set(Calendar.SECOND, 0);
        
        Timer timer = new Timer();
        timer.schedule(new myTask(), thatTime.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // period: 1 day
        
        launch(args);
    } 
}

class myTask extends TimerTask{

    @Override
    public void run() {
        InOutBoardController.checkAttendanceNoPay();
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class MainDashController implements Initializable {

    @FXML
    private AnchorPane mainDashAnchPane;
    @FXML
    private Label stagePane_closeBtn;
    @FXML
    private Label stagePane_minimizeBtn;
    @FXML
    private HBox incomeTaxHBox;
    @FXML
    private HBox ETFEPFHBox;
    @FXML
    private HBox salaryHBox;
    @FXML
    private HBox lateComingHBox;
    @FXML
    private HBox overTimeHBox;
    @FXML
    private HBox inOutBoardHBox;
    @FXML
    private HBox leavesHolidaysHBox;
    @FXML
    private HBox employeesHBox;
    @FXML
    private HBox companyHBox;
    @FXML
    private HBox ratesHBox;
    @FXML
    private HBox holidaysHBox;
    @FXML
    private HBox helpHBox;
    @FXML
    private HBox aboutHBox;
    @FXML
    private HBox logOutHBox;
    @FXML
    private HBox exitHBox;
    @FXML
    private HBox dashBoardHBox;
    @FXML
    private Label childPaneTitleLbl;
    @FXML
    private Pane mainDashChildrenPane;

    private HBox lastClicked;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FadeTransition trans = new FadeTransition(Duration.millis(1000), mainDashAnchPane);
        trans.setFromValue(0.0);
        trans.setToValue(1.00);
        trans.play();

        dashBoardHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = dashBoardHBox;
        childPaneTitleLbl.setText("DashBoard");
        MouseEvent event = null;
        dashBoardHBox_onMouseClicked(event);

    }

    @FXML
    private void stagePane_closeBtn_onMouseClicked(MouseEvent event) {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To Exit?", ButtonType.YES, ButtonType.NO);
        exitAlert.setTitle("Exit?");
        exitAlert.setHeaderText(null);
        Optional<ButtonType> action = exitAlert.showAndWait();

        if (action.get() == ButtonType.YES) {
            System.exit(0);
        }
    }

    @FXML
    private void stagePane_minimizeBtn_onMouseClicked(MouseEvent event) {
        Stage stage = (Stage) this.mainDashAnchPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void dashBoardHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        dashBoardHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = dashBoardHBox;
        childPaneTitleLbl.setText("DashBoard");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/dashBoard.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(350), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void incomeTaxHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        incomeTaxHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = incomeTaxHBox;
        childPaneTitleLbl.setText("Income Tax");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/incomeTax.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ETFEPFHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        ETFEPFHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = ETFEPFHBox;
        childPaneTitleLbl.setText("ETF/EPF");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/etf_Epf.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void salaryHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        salaryHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = salaryHBox;
        childPaneTitleLbl.setText("Salary");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/salary.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lateComingHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        lateComingHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = lateComingHBox;
        childPaneTitleLbl.setText("Late Coming");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/lateComing.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void overTimeHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        overTimeHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = overTimeHBox;
        childPaneTitleLbl.setText("Over Time");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/overTime.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void inOutBoardHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        inOutBoardHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = inOutBoardHBox;
        childPaneTitleLbl.setText("In-Out Board");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/inOutBoard.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void leavesHolidaysHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        leavesHolidaysHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = leavesHolidaysHBox;
        childPaneTitleLbl.setText("Leaves & Holiday");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/leavesAndHolidays.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void employeesHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        employeesHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = employeesHBox;
        childPaneTitleLbl.setText("Employee");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/employee.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void companyHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        companyHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = companyHBox;
        childPaneTitleLbl.setText("Company");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/company.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ratesHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        ratesHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = ratesHBox;
        childPaneTitleLbl.setText("Rates");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/rates.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void holidaysHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        holidaysHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = holidaysHBox;
        childPaneTitleLbl.setText("Holiday");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/holidays.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void helpHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        helpHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = helpHBox;
        childPaneTitleLbl.setText("Help");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/help.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aboutHBox_onMouseClicked(MouseEvent event) {
        lastClicked.setStyle("-fx-background-color: transparent; :hover{-fx-background-color:#204767;}");
        aboutHBox.setStyle("-fx-background-color:#204767;  -fx-border-color:#1FB8F4;  -fx-border-width: 0px 0px 0px 4px;");
        lastClicked = aboutHBox;
        childPaneTitleLbl.setText("About");

        try {
            AnchorPane employeeAnchPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/about.fxml"));
            mainDashChildrenPane.getChildren().clear();
            mainDashChildrenPane.getChildren().add(employeeAnchPane);
            TranslateTransition trans = new TranslateTransition(Duration.millis(300), employeeAnchPane);
            trans.setFromX(1200);
            trans.setToX(0);
            trans.play();
        } catch (IOException ex) {
            Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logOutHBox_onMouseClicked(MouseEvent event) {

        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To LogOut?", ButtonType.YES, ButtonType.NO);
        exitAlert.setTitle("LogOut?");
        exitAlert.setHeaderText(null);
        Optional<ButtonType> action = exitAlert.showAndWait();

        if (action.get() == ButtonType.YES) {
            try {
                Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/logIn.fxml"));
                Scene temp = new Scene(root);
                Stage stage = (Stage) this.mainDashAnchPane.getScene().getWindow();
                stage.setScene(temp);
                stage.centerOnScreen();

                TranslateTransition trans = new TranslateTransition(Duration.millis(300), temp.getRoot());
                trans.setFromY(-temp.getHeight());
                trans.setToY(0);
                trans.play();
            } catch (IOException ex) {
                Logger.getLogger(MainDashController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void exitHBox_onMouseClicked(MouseEvent event) {
        stagePane_closeBtn.fireEvent(event);
    }

}

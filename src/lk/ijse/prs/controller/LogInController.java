/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import lk.ijse.prs.business.BOFactory;
import lk.ijse.prs.business.custom.LogInBO;
import lk.ijse.prs.dto.LogInDTO;
import lk.ijse.prs.main.ed;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class LogInController implements Initializable {

    @FXML
    private AnchorPane logInAnchPane;
    @FXML
    private JFXTextField usenameTF;
    @FXML
    private JFXPasswordField passwordPF;
    @FXML
    private JFXButton logInBtn;
    @FXML
    private Label stagePane_closeBtn;
    @FXML
    private Label stagePane_minimizeBtn;
    @FXML
    private Label statusLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logInBtn_onAction(ActionEvent event) throws IOException {

        String user = usenameTF.getText();
        String pass = passwordPF.getText();

        LogInDTO logInDTO = new LogInDTO(user, pass);
        

        try {
            LogInBO logInBO = (LogInBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGIN);
            boolean result = logInBO.verifyUserPass(logInDTO);

            if (result) {
                Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/prs/view/mainDash.fxml"));
                Scene temp = new Scene(root);
                Stage stage = (Stage) this.logInAnchPane.getScene().getWindow();
                stage.setScene(temp);
                stage.centerOnScreen();
            } else {
                usenameTF.setText("");
                passwordPF.setText("");
                statusLbl.setText("Error in Username or Password.");
                usenameTF.requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        Stage stage = (Stage) this.logInAnchPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void usenameTF_onAction(ActionEvent event) {
        passwordPF.requestFocus();
    }

    @FXML
    private void passwordPF_onAction(ActionEvent event) {
        logInBtn.fire();
    }
    
}

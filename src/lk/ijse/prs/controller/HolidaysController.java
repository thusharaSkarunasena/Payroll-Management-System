/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.prs.business.BOFactory;
import lk.ijse.prs.dto.HolidayAndLeavesDTO;
import lk.ijse.prs.view.util.tblmodel.HolidayAndLeavesTM;
import lk.ijse.prs.business.custom.HolidayAndLeavesBO;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class HolidaysController implements Initializable {

    private JFXTextField employeeIDTF;
    private JFXTextField monthTF;
    private JFXTextField holidayTypeTF;
    private JFXTextField descriptionTF;
    private TableView<HolidayAndLeavesTM> holidayTbl;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    

    private void clearBtn_onAction(ActionEvent event) {
        
    }

    private void holidayTbl_onMouseClick(MouseEvent event) {
        
    }

    private void refreshBtn_onAction(ActionEvent event) {
        
    }

    
    
}

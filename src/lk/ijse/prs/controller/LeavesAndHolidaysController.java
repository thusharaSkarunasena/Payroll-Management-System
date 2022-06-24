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
public class LeavesAndHolidaysController implements Initializable {

    @FXML
    private JFXTextField employeeIDTF;
    @FXML
    private JFXTextField monthTF;
    @FXML
    private JFXTextField holidayTypeTF;
    @FXML
    private JFXButton viewMoreBtn;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXTextField descriptionTF;
    @FXML
    private TableView<HolidayAndLeavesTM> leavesAndHolidayTbl;
    @FXML
    private JFXButton refreshBtn;

    HolidayAndLeavesBO holidayBO=(HolidayAndLeavesBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.HOLIDAYANDLEAVES);
    
    ObservableList<HolidayAndLeavesTM> holidayTM;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        leavesAndHolidayTbl.getColumns().get(0).setStyle("-fx-alignment:center");
        leavesAndHolidayTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        leavesAndHolidayTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        leavesAndHolidayTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("holidayType"));
        leavesAndHolidayTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("description"));
        
        loadAllHolidaysAndLeaves();
    }    
    
    private void loadAllHolidaysAndLeaves() {
        try {
            ArrayList<HolidayAndLeavesDTO> holidayDTOs = holidayBO.getAll();
            
            holidayTM=leavesAndHolidayTbl.getItems();
            holidayTM.removeAll(holidayTM);
            
            for(HolidayAndLeavesDTO hdto:holidayDTOs){
                holidayTM.add(new HolidayAndLeavesTM(
                        hdto.getEmployeeID(),
                        hdto.getDate(),
                        hdto.getHolidayType(),
                        hdto.getDescription()
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(HolidaysController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void viewMore_onAction(ActionEvent event) {
    }

    @FXML
    private void clearBtn_onAction(ActionEvent event) {
        employeeIDTF.setText("");
        monthTF.setText("");
        holidayTypeTF.setText("");
        descriptionTF.setText("");
    }

    @FXML
    private void leavesAndHolidayTbl_onMouseClick(MouseEvent event) {
        HolidayAndLeavesTM htm= leavesAndHolidayTbl.getSelectionModel().getSelectedItem();
        if (holidayTM == null) {
            //DO Nothing
        } else {
            employeeIDTF.setText(htm.getEmployeeID());
            monthTF.setText(htm.getDate());
            holidayTypeTF.setText(htm.getHolidayType());
            descriptionTF.setText(htm.getDescription());
        }
        
    }

    @FXML
    private void refreshBtn_onAction(ActionEvent event) {
        loadAllHolidaysAndLeaves();
    }
    
}

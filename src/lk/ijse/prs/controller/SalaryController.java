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
import lk.ijse.prs.business.custom.SalaryBO;
import lk.ijse.prs.dto.SalaryDTO;
import lk.ijse.prs.view.util.tblmodel.SalaryTM;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class SalaryController implements Initializable {

    @FXML
    private TableView<SalaryTM> salaryTbl;
    @FXML
    private JFXButton refreshBtn;
    
    SalaryBO salaryBO=(SalaryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SALARY);
    
    ObservableList<SalaryTM> salaryTM;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        salaryTbl.getColumns().get(0).setStyle("-fx-alignment:center");
        salaryTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        salaryTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Month"));
        salaryTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("basicSalary"));
        salaryTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("noPay"));
        salaryTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("totalSalary"));
        salaryTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("grossSalary"));
        salaryTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("netSalary"));
        
        loadAllDetails();
    }    
    
    
    public void loadAllDetails(){
        try {
            ArrayList<SalaryDTO> salaryDTOs = salaryBO.loadAllDetails();
            
            salaryTM=salaryTbl.getItems();
            salaryTM.removeAll(salaryTM);
            
            for(SalaryDTO sdto:salaryDTOs){
                salaryTM.add(new SalaryTM(
                        sdto.getEmployeeID(),
                        sdto.getMonth(),
                        sdto.getBasicSalary(),
                        sdto.getNoPay(),
                        sdto.getTotalSalary(),
                        sdto.getGrossSalary(),
                        sdto.getTotalSalary()
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(SalaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refreshBtn_onAction(ActionEvent event) {
        loadAllDetails();
    }

    
}

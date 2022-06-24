/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.prs.business.BOFactory;
import lk.ijse.prs.business.custom.EmployeeBO;
import lk.ijse.prs.business.custom.InOutBoardBO;
import lk.ijse.prs.dto.EmployeeDTO;
import lk.ijse.prs.dto.InOutBoardDTO;
import lk.ijse.prs.view.util.tblmodel.InOutBoardTM;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class InOutBoardController implements Initializable {

    @FXML
    private AnchorPane inOutBoardAnchPane;
    @FXML
    private JFXTextField dateTF;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXTimePicker outTImeTP;
    @FXML
    private JFXTimePicker inTimeTP;
    @FXML
    private JFXTextField employeeIDTF;
    @FXML
    private JFXComboBox<String> employeeIDComBox;
    @FXML
    private JFXButton inBtn;
    @FXML
    private JFXButton outBtn;
    @FXML
    private Label dateLbl;
    @FXML
    private Label timeLbl;
    @FXML
    private TextField searchBoxTF;
    @FXML
    private TableView<InOutBoardTM> inOutBoardTbl;
    @FXML
    private JFXDatePicker searchDP;
    @FXML
    private Pane dateAndTimePane;
    @FXML
    private JFXButton noWork;
    
    InOutBoardBO inOutBoardBO=(InOutBoardBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.INOUTBOARD);
    ObservableList<InOutBoardTM> inOutBoardTM;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        inOutBoardTbl.getColumns().get(0).setStyle("-fx-alignment:center");
        inOutBoardTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        inOutBoardTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        inOutBoardTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("inTime"));
        inOutBoardTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("outTime"));
        
        Timeline dateNtime = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy  E");
            dateLbl.setText(LocalDate.now().format(formatter));
            timeLbl.setText(LocalTime.now().toString().substring(0,8));
        }));
            
        dateNtime.setCycleCount(Animation.INDEFINITE);
        dateNtime.play();
        
        cleanAndRefresh();
        noWork.requestFocus();
    }    

    public void cleanAndRefresh(){
        employeeIDComBox.setValue(null);
        disableInOutBtn();
        employeeIDTF.setText("");
        dateTF.setText("");
        inTimeTP.setValue(null);
        outTImeTP.setValue(null);
        disableInOutBtn();
        disableUpdateDeleteBtn();
        
        loadAllEmployeeIDs();
        loadAllRecords();
    }
    
    public void disableInOutBtn(){
        inBtn.setDisable(true);
        outBtn.setDisable(true);
    }
    
    public void disableUpdateDeleteBtn(){
        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);
    }
    
    public void loadAllEmployeeIDs(){
        try {
            EmployeeBO employeeBO=(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.EMPLOYEE);
            ArrayList<EmployeeDTO> employeeDTOs = employeeBO.getAllEmployees();
            
            ObservableList<String> employeeIDs=FXCollections.observableArrayList();
            
            for(EmployeeDTO edto:employeeDTOs){
                employeeIDs.add(edto.getEmployeeID());
            }
            
            employeeIDComBox.setItems(employeeIDs);
        } catch (Exception ex) {
            Logger.getLogger(InOutBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadAllRecords(){
        try {
            ArrayList<InOutBoardDTO> inOutBoardDTOs=inOutBoardBO.loadAllRecords();
            
            inOutBoardTM=inOutBoardTbl.getItems();
            inOutBoardTM.removeAll(inOutBoardTM);
            
            for(InOutBoardDTO iobdto:inOutBoardDTOs){
                inOutBoardTM.add(new InOutBoardTM(
                        iobdto.getEmployeeID(),
                        iobdto.getDate(),
                        iobdto.getInTime(),
                        iobdto.getOutTime()
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(InOutBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void deleteBtn_onAction(ActionEvent event) {
        cleanAndRefresh();
    }

    @FXML
    private void updateBtn_onAction(ActionEvent event) {
        cleanAndRefresh();
    }

    @FXML
    private void inBtn_onAction(ActionEvent event) {
        try {
            String employeeID=employeeIDComBox.getValue();
            String date=LocalDate.now().toString();
            String inTime=LocalTime.now().toString();
            String outTime=null;
            
            InOutBoardDTO iobdto=new InOutBoardDTO(
                    employeeID,
                    date,
                    inTime,
                    outTime
            );
            
            inOutBoardBO.inBtn(iobdto);
            
            cleanAndRefresh();
        } catch (Exception ex) {
            Logger.getLogger(InOutBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void outBtn_onAction(ActionEvent event) {
        try {
            String employeeID=employeeIDComBox.getValue();
            String date=LocalDate.now().toString();
            String inTime=null;
            String outTime=LocalTime.now().toString();;
            
            ObservableList<InOutBoardTM> inOutBoardTMs=inOutBoardTbl.getItems();
            
            for(InOutBoardTM iobtm:inOutBoardTMs){
                if(iobtm.getEmployeeID().equals(employeeID) & iobtm.getDate().equals(date)){
                    inTime=iobtm.getInTime();
                    break;
                }
            }
            
            InOutBoardDTO iobdto=new InOutBoardDTO(
                    employeeID,
                    date,
                    inTime,
                    outTime
            );
            
            inOutBoardBO.outBtn(iobdto);
            
            cleanAndRefresh();
        } catch (Exception ex) {
            Logger.getLogger(InOutBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchBox_onMouseClick(MouseEvent event) {
        cleanAndRefresh();
    }

    @FXML
    private void searchBox_onKeyReleased(KeyEvent event) {
        String searchText=searchBoxTF.getText();
        
        if(searchText.isEmpty()){
            loadAllRecords();
        }else{
            ObservableList<InOutBoardTM> inOutBoardTMs=inOutBoardTbl.getItems();
        
            inOutBoardTM=inOutBoardTbl.getItems();
            inOutBoardTM.removeAll(inOutBoardTM);

            for(InOutBoardTM iobtm:inOutBoardTMs){
                if(searchText.contains(iobtm.getEmployeeID()) | iobtm.getDate().contains(searchText)){
                    inOutBoardTM.add(iobtm);
                } else {
                }
            }
        }
    }

    @FXML
    private void inOutBoardTbl_onMouseClick(MouseEvent event) {
        InOutBoardTM iobtm=inOutBoardTbl.getSelectionModel().getSelectedItem();
        
        employeeIDTF.setText(iobtm.getEmployeeID());
        dateTF.setText(iobtm.getDate());
        inTimeTP.setValue(LocalTime.parse(iobtm.getInTime()));
        outTImeTP.setValue(LocalTime.parse(iobtm.getOutTime()));
    }

    @FXML
    private void searchDP_onAction(ActionEvent event) {
        cleanAndRefresh();
    }

    @FXML
    private void employeeIDComBox_onAction(ActionEvent event) {
        String employeeID=employeeIDComBox.getValue();
        String curDate=LocalDate.now().toString();
        
        ObservableList<InOutBoardTM> inOutBoardTMs=inOutBoardTbl.getItems();
        
        Integer isExists_idDate=0;
        Integer isExists_outTime=0;
        
        for(InOutBoardTM iobtm:inOutBoardTMs){
            if(iobtm.getEmployeeID().equals(employeeID) & iobtm.getDate().equals(curDate)){
                isExists_idDate=1;
                break;
            }
        }
        
        for(InOutBoardTM iobtm:inOutBoardTMs){
            if(iobtm.getEmployeeID().equals(employeeID) & iobtm.getDate().equals(curDate) & "Still Inside".equals(iobtm.getOutTime())){
                isExists_outTime=1;
                break;
            }
        }
        
        if(isExists_idDate==0 & ((LocalTime.now().getHour())+(LocalTime.now().getMinute()/60))<=11.5 && ((LocalTime.now().getHour())+(LocalTime.now().getMinute()/60))>=7.5){
            inBtn.setDisable(false);
            outBtn.setDisable(true);
        }else if(isExists_idDate==1 & isExists_outTime==0 & ((((LocalTime.now().getHour())+(LocalTime.now().getMinute()/60))>11.5 & ((LocalTime.now().getHour())+(LocalTime.now().getMinute()/60))<12.5) | (((LocalTime.now().getHour())+(LocalTime.now().getMinute()/60))>17))){
            inBtn.setDisable(true);
            outBtn.setDisable(false);
        }else{
            inBtn.setDisable(true);
            outBtn.setDisable(true);
        }
        
    }
    
    public static void checkAttendanceNoPay(){
        try {
            InOutBoardBO iobbo=(InOutBoardBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.INOUTBOARD);
            iobbo.checkAttendanceNoPay();
        } catch (Exception ex) {
            Logger.getLogger(InOutBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

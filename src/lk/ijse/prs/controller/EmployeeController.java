/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.prs.business.BOFactory;
import lk.ijse.prs.business.custom.EmployeeBO;
import lk.ijse.prs.dto.EmployeeDTO;
import lk.ijse.prs.view.util.tblmodel.EmployeeTM;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class EmployeeController implements Initializable {

    @FXML
    private AnchorPane employeeAnchPane;
    @FXML
    private JFXButton newBtn;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXTextField employeeIdTF;
    @FXML
    private JFXTextField nicTF;
    @FXML
    private JFXTextField tel_homeTF;
    @FXML
    private JFXTextField tel_mobileTF;
    @FXML
    private JFXTextField address_villageTF;
    @FXML
    private JFXTextField address_streetTF;
    @FXML
    private JFXTextField address_noTF;
    @FXML
    private JFXTextField address_cityTF;
    @FXML
    private JFXTextField otherDetailsTF;
    @FXML
    private JFXComboBox<String> employeeTypeComBox;
    @FXML
    private TextField searchBoxTF;
    @FXML
    private TableView<EmployeeTM> employeeTbl;
    @FXML
    private JFXTextField nameTF;
    
    EmployeeBO employeeBO=(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.EMPLOYEE);
    
    ObservableList<EmployeeTM> employeeTM;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeTbl.getColumns().get(0).setStyle("-fx-alignment:center");
        employeeTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        employeeTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("employment"));
        
        loadAllEmployees();
        generateEmployeeID();
        loadEmployeeTypeComboBox();
    }    

    public void loadAllEmployees(){
        try {
            ArrayList<EmployeeDTO> employeeDTOs = employeeBO.getAllEmployees();
            
            employeeTM=employeeTbl.getItems();
            employeeTM.removeAll(employeeTM);
            
            for(EmployeeDTO edto:employeeDTOs){
                employeeTM.add(new EmployeeTM(
                        edto.getEmployeeID(),
                        edto.getName(),
                        edto.getNic(),
                        edto.getEmployeeTypeName()
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generateEmployeeID(){
        try {
            employeeIdTF.setText(employeeBO.generateEmployeeID());
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadEmployeeTypeComboBox(){
        try {
            ArrayList<String> employeeTypesList=employeeBO.loadEmployeeTypeComboBox();
            ObservableList<String> employeeTypeNameList=FXCollections.observableArrayList();
            
            for(String type:employeeTypesList){
                employeeTypeNameList.add(type);
            }
            employeeTypeComBox.setItems(employeeTypeNameList);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void newBtn_onAction(ActionEvent event) {
        clearAndRefreshAll();
    }

    public void clearAndRefreshAll(){
        employeeIdTF.setText("");
        employeeTypeComBox.setValue("");
        nameTF.setText("");
        nicTF.setText("");
        address_noTF.setText("");
        address_streetTF.setText("");
        address_villageTF.setText("");
        address_cityTF.setText("");
        tel_homeTF.setText("");
        tel_mobileTF.setText("");
        otherDetailsTF.setText("");
        searchBoxTF.setText("");
        
        generateEmployeeID();
        loadAllEmployees();
    }
    
    @FXML
    private void saveBtn_onAction(ActionEvent event) {
        int isAlreadyHave=0;
        employeeTM=employeeTbl.getItems();
        for(EmployeeTM emtm : employeeTM){
            if(employeeIdTF.getText().equals(emtm.getEmployeeID()) | nicTF.getText().equals(emtm.getNic())){
                isAlreadyHave=1;
            }
        }
        
        if(isAlreadyHave==1){
            new Alert(Alert.AlertType.ERROR,"The employee you are going to save is already in employee table.",ButtonType.OK).show();
        }
        else{
            try {
                String employeeID=employeeIdTF.getText();
                String employeeType=employeeTypeComBox.getValue();
                String name=nameTF.getText();
                String nic=nicTF.getText();
                String address_no=address_noTF.getText();
                String address_street=address_streetTF.getText();
                String address_village=address_villageTF.getText();
                String address_city=address_cityTF.getText();
                String contact_home=tel_homeTF.getText();
                String contact_mobile=tel_mobileTF.getText();
                String other_details=otherDetailsTF.getText();

                EmployeeDTO employeeDTO=new EmployeeDTO(employeeID,employeeType,name,nic,address_no,address_street,address_village,address_city,contact_home,contact_mobile,other_details);

                boolean matches1=name.matches("[a-z A-Z .]{3,}");
                boolean matches2=nic.matches("[0-9]{9,11}[V]");
                boolean matches3=address_no.matches("([0-9 A-Z]{1,})?([/]?[A-Z 0-9])?([/]?[A-Z 0-9])");
                boolean matches4=address_street.matches("[a-z A-Z 0-9]{5,}");
                boolean matches5=address_village.matches("[a-z A-Z]{5,}");
                boolean matches6=address_city.matches("([a-z A-Z]{5,})?");
                boolean matches7=contact_home.matches("([0-9]{10})?");
                boolean matches8=contact_mobile.matches("([0-9]{10})?");
                boolean matches9=other_details.matches("([a-z A-Z 0-9 ~!@#$%^&*()_+,./;'{}:\"<>{}-]{1,})?");

                boolean result=false;

                if(matches1){
                    if(matches2){
                        if(matches3){
                            if(matches4){
                                if(matches5){
                                    if(matches6){
                                        if(matches7){
                                            if(matches8){
                                                if(matches9){
                                                    result=employeeBO.saveEmployee(employeeDTO);
                                                }else{
                                                    new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Other Details.",ButtonType.OK).show();
                                                    otherDetailsTF.requestFocus();
                                                }
                                            }else{
                                                new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Contact Number Mobile.",ButtonType.OK).show();
                                                tel_mobileTF.requestFocus();
                                            }
                                        }else{
                                            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Contact Number Home.",ButtonType.OK).show();
                                            tel_homeTF.requestFocus();
                                        }
                                    }else{
                                        new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address City.",ButtonType.OK).show();
                                        address_cityTF.requestFocus();
                                    }
                                }else{
                                    new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address Village.",ButtonType.OK).show();
                                    address_villageTF.requestFocus();
                                }
                            }else{
                                new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address Street.",ButtonType.OK).show();
                                address_streetTF.requestFocus();
                            }
                        }else{
                            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address No.",ButtonType.OK).show();
                            address_noTF.requestFocus();
                        }
                    }else{
                        new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in NIC.",ButtonType.OK).show();
                        nicTF.requestFocus();
                    }
                }else{
                    new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Employee Name.",ButtonType.OK).show();
                    nameTF.requestFocus();
                }

                if(result){
                    new Alert(Alert.AlertType.INFORMATION, "Employee has been saved successfully.", ButtonType.OK).show();
                    clearAndRefreshAll();
                }else{
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Employee.", ButtonType.OK).show();
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteBtn_onAction(ActionEvent event) {
        try {
            String employeeID=employeeIdTF.getText();
            
            boolean result=employeeBO.deleteEmployee(employeeID);
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Employee has been deleted successfully.", ButtonType.OK).show();
                clearAndRefreshAll();
            }else{
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Employee.", ButtonType.OK).show();
                clearAndRefreshAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void updateBtn_onAction(ActionEvent event) {
        try {
            String employeeID=employeeIdTF.getText();
            String employeeType=employeeTypeComBox.getValue();
            String name=nameTF.getText();
            String nic=nicTF.getText();
            String address_no=address_noTF.getText();
            String address_street=address_streetTF.getText();
            String address_village=address_villageTF.getText();
            String address_city=address_cityTF.getText();
            String contact_home=tel_homeTF.getText();
            String contact_mobile=tel_mobileTF.getText();
            String other_details=otherDetailsTF.getText();
            
            EmployeeDTO employeeDTO=new EmployeeDTO(employeeID,employeeType,name,nic,address_no,address_street,address_village,address_city,contact_home,contact_mobile,other_details);
            
            boolean matches1=name.matches("[a-z A-Z .]{3,}");
            boolean matches2=nic.matches("[0-9]{9,11}[V]");
            boolean matches3=address_no.matches("([0-9 A-Z]{1,})?([/]?[A-Z 0-9])?([/]?[A-Z 0-9])");
            boolean matches4=address_street.matches("[a-z A-Z 0-9]{5,}");
            boolean matches5=address_village.matches("[a-z A-Z]{5,}");
            boolean matches6=address_city.matches("([a-z A-Z]{5,})?");
            boolean matches7=contact_home.matches("([0-9]{10})?");
            boolean matches8=contact_mobile.matches("([0-9]{10})?");
            boolean matches9=other_details.matches("([a-z A-Z 0-9 ~!@#$%^&*()_+,./;'{}:\"<>{}-]{1,})?");
            
            boolean result=false;
            
            if(matches1){
                if(matches2){
                    if(matches3){
                        if(matches4){
                            if(matches5){
                                if(matches6){
                                    if(matches7){
                                        if(matches8){
                                            if(matches9){
                                                result=employeeBO.updateEmployee(employeeDTO);
                                            }else{
                                                new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Other Details.",ButtonType.OK).show();
                                                otherDetailsTF.requestFocus();
                                            }
                                        }else{
                                            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Contact Number Mobile.",ButtonType.OK).show();
                                            tel_mobileTF.requestFocus();
                                        }
                                    }else{
                                        new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Contact Number Home.",ButtonType.OK).show();
                                        tel_homeTF.requestFocus();
                                    }
                                }else{
                                    new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address City.",ButtonType.OK).show();
                                    address_cityTF.requestFocus();
                                }
                            }else{
                                new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address Village.",ButtonType.OK).show();
                                address_villageTF.requestFocus();
                            }
                        }else{
                            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address Street.",ButtonType.OK).show();
                            address_streetTF.requestFocus();
                        }
                    }else{
                        new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address No.",ButtonType.OK).show();
                        address_noTF.requestFocus();
                    }
                }else{
                    new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in NIC.",ButtonType.OK).show();
                    nicTF.requestFocus();
                }
            }else{
                new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Employee Name.",ButtonType.OK).show();
                nameTF.requestFocus();
            }
            
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Employee has been updated successfully.", ButtonType.OK).show();
                clearAndRefreshAll();
            }else{
                new Alert(Alert.AlertType.ERROR, "Failed to update the Employee.", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void nameTF_onAction(ActionEvent event) {
        String name = nameTF.getText();
        boolean matches=name.matches("[a-z A-Z .]{3,}");
        if(matches){
            nicTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Employee Name.",ButtonType.OK).show();
            nameTF.requestFocus();
        }
    }

    @FXML
    private void nicTF_onAction(ActionEvent event) {
        String nic = nicTF.getText();
        boolean matches=nic.matches("[0-9]{9,11}[V]");
        if(matches){
            address_noTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in NIC.",ButtonType.OK).show();
            nicTF.requestFocus();
        }
    }

    @FXML
    private void tel_homeTF_onAction(ActionEvent event) {
        String tel_home = tel_homeTF.getText();
        boolean matches=tel_home.matches("([0-9]{10})?");
        if(matches){
            tel_mobileTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Contact Number Home.",ButtonType.OK).show();
            tel_homeTF.requestFocus();
        }
    }

    @FXML
    private void tel_mobileTF_onAction(ActionEvent event) {
        String tel_mobile = tel_mobileTF.getText();
        boolean matches=tel_mobile.matches("([0-9]{10})?");
        if(matches){
            otherDetailsTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Contact Number Mobile.",ButtonType.OK).show();
            tel_mobileTF.requestFocus();
        }
    }

    @FXML
    private void address_villageTF_onAction(ActionEvent event) {
        String address_village = address_villageTF.getText();
        boolean matches=address_village.matches("[a-z A-Z]{5,}");
        if(matches){
            address_cityTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address Village.",ButtonType.OK).show();
            address_villageTF.requestFocus();
        }
    }

    @FXML
    private void address_streetTF_onAction(ActionEvent event) {
        String address_street = address_streetTF.getText();
        boolean matches=address_street.matches("[a-z A-Z 0-9]{5,}");
        if(matches){
            address_villageTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address Street.",ButtonType.OK).show();
            address_streetTF.requestFocus();
        }
    }

    @FXML
    private void address_noTF_onAction(ActionEvent event) {
        String address_no = address_noTF.getText();
        boolean matches=address_no.matches("([0-9 A-Z]{1,})?([/]?[A-Z 0-9])?([/]?[A-Z 0-9])");
        if(matches){
            address_streetTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address No.",ButtonType.OK).show();
            address_noTF.requestFocus();
        }
    }

    @FXML
    private void address_cityTF_onAction(ActionEvent event) {
        String address_city = address_cityTF.getText();
        boolean matches=address_city.matches("([a-z A-Z]{5,})?");
        if(matches){
            tel_homeTF.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR,"Oops... Something wrong in Address City.",ButtonType.OK).show();
            address_cityTF.requestFocus();
        }
    }


    @FXML
    private void employeeTypeComBox_onAction(ActionEvent event) {
        nameTF.requestFocus();
    }

    @FXML
    private void searchBox_onMouseClick(MouseEvent event) {
        clearAndRefreshAll();
    }

    @FXML
    private void searchBox_onKeyReleased(KeyEvent event) {
        if(searchBoxTF.getText()==null){
            loadAllEmployees();
        }else{
            try {                
                ArrayList<EmployeeDTO> employeeDTOs = employeeBO.searchEmployee(searchBoxTF.getText());
                if(employeeDTOs.isEmpty()){
                    searchBoxTF.setStyle("-fx-text-fill: #D91022");
                    loadAllEmployees();
                }else{
                    searchBoxTF.setStyle("-fx-text-fill: #000000");
                    employeeTM = employeeTbl.getItems();
                    employeeTM.removeAll(employeeTM);
                  
                    for(EmployeeDTO edto : employeeDTOs){
                        employeeTM.add(new EmployeeTM(
                                edto.getEmployeeID(),
                                edto.getName(),
                                edto.getNic(),
                                edto.getEmployeeTypeName()
                        ));
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void employeeTbl_onMouseClick(MouseEvent event) {
        try {
            EmployeeTM employeeTM=employeeTbl.getSelectionModel().getSelectedItem();
            if(employeeTM==null){
                //DO Nothing
            }else{
                EmployeeDTO employeeDTO=employeeBO.getSelectedEmployee(employeeTM.getEmployeeID());
            
                employeeIdTF.setText(employeeDTO.getEmployeeID());
                nameTF.setText(employeeDTO.getName());
                employeeTypeComBox.setValue(employeeDTO.getEmployeeTypeName());
                address_noTF.setText(employeeDTO.getAddressNo());
                address_streetTF.setText(employeeDTO.getAddressStreet());
                address_villageTF.setText(employeeDTO.getAddressVillage());
                address_cityTF.setText(employeeDTO.getAddressCity());
                nicTF.setText(employeeDTO.getNic());
                tel_homeTF.setText(employeeDTO.getContactNoHome());
                tel_mobileTF.setText(employeeDTO.getContactNoMobile());
                otherDetailsTF.setText(employeeDTO.getOtherDetail());
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

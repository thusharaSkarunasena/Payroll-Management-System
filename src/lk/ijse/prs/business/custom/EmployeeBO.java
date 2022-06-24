/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom;

import java.util.ArrayList;
import lk.ijse.prs.business.SuperBO;
import lk.ijse.prs.dto.EmployeeDTO;

/**
 *
 * @author Thushara Supun
 */
public interface EmployeeBO extends SuperBO{
 
    public ArrayList<EmployeeDTO> getAllEmployees()throws Exception;
    
    public String generateEmployeeID() throws Exception;
    
    public ArrayList<String> loadEmployeeTypeComboBox() throws Exception;
    
    public EmployeeDTO getSelectedEmployee(String employeeID) throws Exception;
    
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception;
    
    public boolean deleteEmployee(String employeeID) throws Exception;
    
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws Exception;
    
    public ArrayList<EmployeeDTO> searchEmployee(String searchText) throws Exception;
    
}

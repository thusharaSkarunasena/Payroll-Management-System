/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom;

import java.util.ArrayList;
import lk.ijse.prs.dao.CrudDAO;
import lk.ijse.prs.entity.Employee;

/**
 *
 * @author Thushara Supun
 */
public interface EmployeeDAO extends CrudDAO<Employee, String>{
    
    public String generateEmployeeID() throws Exception;
    
    public ArrayList<String> loadEmployeeTypeComboBox() throws Exception;
    
    public Employee getSelectedEmployee(String employeeID) throws Exception;
    
    public ArrayList<Employee> searchEmployee(String searchText) throws Exception;

}

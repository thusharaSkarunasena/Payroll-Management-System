/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.prs.business.custom.EmployeeBO;
import lk.ijse.prs.dao.DAOFactory;
import lk.ijse.prs.dao.custom.EmployeeDAO;
import lk.ijse.prs.dto.EmployeeDTO;
import lk.ijse.prs.entity.Employee;

/**
 *
 * @author Thushara Supun
 */
public class EmployeeBOImpl implements EmployeeBO{
    
    EmployeeDAO employeeDAO=(EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() throws Exception {
        ArrayList<Employee> employees=employeeDAO.getAll();
        ArrayList<EmployeeDTO> employeeDTOs=new ArrayList<>();
        
        for(Employee employee:employees){
            employeeDTOs.add(new EmployeeDTO(
                    employee.getEmployeeID(),
                    employee.getEmployeeTypeName(),
                    employee.getName(),
                    employee.getNic(),
                    employee.getAddressNo(),
                    employee.getAddressStreet(),
                    employee.getAddressVillage(),
                    employee.getAddressCity(),
                    employee.getContactNoHome(),
                    employee.getContactNoMobile(),
                    employee.getOtherDetail()
            ));
        }
        return employeeDTOs;
    }

    @Override
    public String generateEmployeeID() throws Exception {
        return employeeDAO.generateEmployeeID();
    }
    
    @Override
    public ArrayList<String> loadEmployeeTypeComboBox() throws Exception {
        return employeeDAO.loadEmployeeTypeComboBox();
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeID) throws Exception {
        Employee employee=employeeDAO.getSelectedEmployee(employeeID);
        return new EmployeeDTO(
                employee.getEmployeeID(),
                employee.getEmployeeTypeName(),
                employee.getName(),
                employee.getNic(),
                employee.getAddressNo(),
                employee.getAddressStreet(),
                employee.getAddressVillage(),
                employee.getAddressCity(),
                employee.getContactNoHome(),
                employee.getContactNoMobile(),
                employee.getOtherDetail()
        );
    }

    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception {
        return employeeDAO.save(new Employee(
                employeeDTO.getEmployeeID(),
                employeeDTO.getEmployeeTypeName(),
                employeeDTO.getName(),
                employeeDTO.getNic(),
                employeeDTO.getAddressNo(),
                employeeDTO.getAddressStreet(),
                employeeDTO.getAddressVillage(),
                employeeDTO.getAddressCity(),
                employeeDTO.getContactNoHome(),
                employeeDTO.getContactNoMobile(),
                employeeDTO.getOtherDetail()
        ));
    }

    @Override
    public boolean deleteEmployee(String employeeID) throws Exception {
        return employeeDAO.delete(employeeID);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws Exception {
        return employeeDAO.update(new Employee(
                employeeDTO.getEmployeeID(),
                employeeDTO.getEmployeeTypeName(),
                employeeDTO.getName(),
                employeeDTO.getNic(),
                employeeDTO.getAddressNo(),
                employeeDTO.getAddressStreet(),
                employeeDTO.getAddressVillage(),
                employeeDTO.getAddressCity(),
                employeeDTO.getContactNoHome(),
                employeeDTO.getContactNoMobile(),
                employeeDTO.getOtherDetail()
        ));
    }

    @Override
    public ArrayList<EmployeeDTO> searchEmployee(String searchText) throws Exception {
        ArrayList<Employee> employees=employeeDAO.searchEmployee(searchText);
        ArrayList<EmployeeDTO> employeeDTOs=new ArrayList<>();
        
        for(Employee employee:employees){
            employeeDTOs.add(new EmployeeDTO(
                    employee.getEmployeeID(),
                    employee.getEmployeeTypeName(),
                    employee.getName(),
                    employee.getNic(),
                    employee.getAddressNo(),
                    employee.getAddressStreet(),
                    employee.getAddressVillage(),
                    employee.getAddressCity(),
                    employee.getContactNoHome(),
                    employee.getContactNoMobile(),
                    employee.getOtherDetail()
            ));
        }
        return employeeDTOs;
    }

    
}

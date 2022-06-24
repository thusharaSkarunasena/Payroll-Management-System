/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.prs.dao.CrudUtill;
import lk.ijse.prs.dao.custom.EmployeeDAO;
import lk.ijse.prs.entity.Employee;

/**
 *
 * @author Thushara Supun
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public ArrayList<Employee> getAll() throws Exception {
        ResultSet rst1 = CrudUtill.executeQuery("call getAllEmployees()");
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Employee> finalEmployeeList = new ArrayList<>();
        String employeeTypeName = null;

        while (rst1.next()) {
            employees.add(new Employee(
                    rst1.getString(1),
                    rst1.getString(2),
                    rst1.getString(3),
                    rst1.getString(4),
                    rst1.getString(5),
                    rst1.getString(6),
                    rst1.getString(7),
                    rst1.getString(8),
                    rst1.getString(9),
                    rst1.getString(10),
                    rst1.getString(11)
            ));
        }

        for (Employee emp : employees) {
            ResultSet rst2 = CrudUtill.executeQuery("select getEmployeeTypeName('" + emp.getEmployeeTypeName() + "')");
            while (rst2.next()) {
                employeeTypeName = rst2.getString(1);
            }

            finalEmployeeList.add(new Employee(
                    emp.getEmployeeID(),
                    employeeTypeName,
                    emp.getName(),
                    emp.getNic(),
                    emp.getAddressNo(),
                    emp.getAddressStreet(),
                    emp.getAddressVillage(),
                    emp.getAddressCity(),
                    emp.getContactNoHome(),
                    emp.getContactNoMobile(),
                    emp.getOtherDetail()
            ));
        }

        return finalEmployeeList;
    }

    @Override
    public String generateEmployeeID() throws Exception {
        ResultSet rst = CrudUtill.executeQuery("select getLastEmployeeID()");
        String lastEmpId = null;
        Integer NpartDCount = 0;

        if (rst.next()) {
            lastEmpId = rst.getString(1);

            String[] output = lastEmpId.split("-");

            Integer Npart = Integer.parseInt(output[1]);
            Npart = Npart + 1;
            Integer testNpart = Npart;

            while (testNpart != 0) {
                testNpart = testNpart / 10;
                NpartDCount++;
            }

            String nextEmpId = "EMP-";

            Integer rounds = 4 - NpartDCount;

            while (rounds != 0) {
                nextEmpId = nextEmpId + "0";
                rounds--;
            }

            nextEmpId = nextEmpId + "" + Npart;

            return nextEmpId;
        } else {
            return "EMP-0001";
        }
    }

    @Override
    public boolean save(Employee entity) throws Exception {
        return CrudUtill.executeUpdate("call saveEmployee(?,?,?,?,?,?,?,?,?,?,?)", entity.getEmployeeID(), entity.getEmployeeTypeName(), entity.getName(), entity.getNic(), entity.getAddressNo(), entity.getAddressStreet(), entity.getAddressVillage(), entity.getAddressCity(), entity.getContactNoHome(), entity.getContactNoMobile(), entity.getOtherDetail());
    }

    @Override
    public boolean update(Employee entity) throws Exception {
        return CrudUtill.executeUpdate("call updateEmployee(?,?,?,?,?,?,?,?,?,?,?)", entity.getEmployeeTypeName(), entity.getName(), entity.getNic(), entity.getAddressNo(), entity.getAddressStreet(), entity.getAddressVillage(), entity.getAddressCity(), entity.getContactNoHome(), entity.getContactNoMobile(), entity.getOtherDetail(), entity.getEmployeeID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtill.executeUpdate("call deleteEmployee(?)", id);
    }

    @Override
    public ArrayList<String> loadEmployeeTypeComboBox() throws Exception {
        ResultSet rst1 = CrudUtill.executeQuery("call getAllEmployeeTypes()");
        ArrayList<String> allEmployeeTypes = new ArrayList<>();

        while (rst1.next()) {
            ResultSet rst2 = CrudUtill.executeQuery("select getEmployeeTypeName('" + rst1.getString(1) + "')");
            while (rst2.next()) {
                allEmployeeTypes.add(rst2.getString(1));
            }
        }

        return allEmployeeTypes;
    }

    @Override
    public Employee getSelectedEmployee(String employeeID) throws Exception {
        ResultSet rst1 = CrudUtill.executeQuery("call getAnEmployee('" + employeeID + "')");
        Employee employee = null;
        String employeeTypeName = null;

        while (rst1.next()) {
            ResultSet rst2 = CrudUtill.executeQuery("select getEmployeeTypeName('" + rst1.getString(2) + "')");
            while (rst2.next()) {
                employeeTypeName = rst2.getString(1);
            }
            employee = new Employee(
                    rst1.getString(1),
                    employeeTypeName,
                    rst1.getString(3),
                    rst1.getString(4),
                    rst1.getString(5),
                    rst1.getString(6),
                    rst1.getString(7),
                    rst1.getString(8),
                    rst1.getString(9),
                    rst1.getString(10),
                    rst1.getString(11)
            );
        }
        return employee;
    }

    @Override
    public ArrayList<Employee> searchEmployee(String searchText) throws Exception {
        ResultSet rst1 = CrudUtill.executeQuery("call searchEmployees('" + searchText + "')");
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Employee> finalEmployeeList = new ArrayList<>();
        String employeeTypeName = null;

        while (rst1.next()) {
            employees.add(new Employee(
                    rst1.getString(1),
                    rst1.getString(2),
                    rst1.getString(3),
                    rst1.getString(4),
                    rst1.getString(5),
                    rst1.getString(6),
                    rst1.getString(7),
                    rst1.getString(8),
                    rst1.getString(9),
                    rst1.getString(10),
                    rst1.getString(11)
            ));
        }

        for (Employee emp : employees) {
            ResultSet rst2 = CrudUtill.executeQuery("select getEmployeeTypeName('" + emp.getEmployeeTypeName() + "')");
            while (rst2.next()) {
                employeeTypeName = rst2.getString(1);
            }

            finalEmployeeList.add(new Employee(
                    emp.getEmployeeID(),
                    employeeTypeName,
                    emp.getName(),
                    emp.getNic(),
                    emp.getAddressNo(),
                    emp.getAddressStreet(),
                    emp.getAddressVillage(),
                    emp.getAddressCity(),
                    emp.getContactNoHome(),
                    emp.getContactNoMobile(),
                    emp.getOtherDetail()
            ));
        }

        return finalEmployeeList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom.impl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import lk.ijse.prs.dao.CrudUtill;
import lk.ijse.prs.dao.custom.InOutBoardDAO;
import lk.ijse.prs.entity.Employee;
import lk.ijse.prs.entity.InOutBoard;

/**
 *
 * @author Thushara Supun
 */
public class InOutBoardDAOImpl implements InOutBoardDAO {

    @Override
    public ArrayList<InOutBoard> getAll() throws Exception {
        ResultSet rst = CrudUtill.executeQuery("call getAllInOutRecods()");

        ArrayList<InOutBoard> inOutBoards = new ArrayList<>();
        ArrayList<InOutBoard> newInOutBoards = new ArrayList<>();

        while (rst.next()) {
            inOutBoards.add(new InOutBoard(
                    rst.getString(1),
                    rst.getDate(2).toString(),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }

        String defaultOutT = "00:00:00";
        String outTime = "Still Inside";
        for (InOutBoard iob : inOutBoards) {
            if (iob.getOutTime().equals(defaultOutT)) {
                newInOutBoards.add(new InOutBoard(
                        iob.getEmployeeID(),
                        iob.getDate(),
                        iob.getInTime(),
                        outTime
                ));
            } else {
                newInOutBoards.add(new InOutBoard(
                        iob.getEmployeeID(),
                        iob.getDate(),
                        iob.getInTime(),
                        iob.getOutTime()
                ));
            }
        }
        return newInOutBoards;
    }

    @Override
    public boolean save(InOutBoard entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(InOutBoard entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inBtn(InOutBoard inOutBoard) throws Exception {
        CrudUtill.executeUpdate("call saveInOutRecord(?,?,?,?)", inOutBoard.getEmployeeID(), inOutBoard.getDate(), inOutBoard.getInTime(), "00:00:00");
    }

    @Override
    public void outBtn(InOutBoard inOutBoard) throws Exception {
        CrudUtill.executeUpdate("call updateInOutRecord(?,?,?,?)", inOutBoard.getEmployeeID(), inOutBoard.getDate(), inOutBoard.getInTime(), inOutBoard.getOutTime());
    }

    @Override
    public void checkAttendanceNoPay() throws Exception {
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

        for (Employee employee : employees) {
            CrudUtill.executeQuery("call AttendanceNoPay(?,?)", employee.getEmployeeID(), LocalDate.now().toString());
        }
        
    }
    
}

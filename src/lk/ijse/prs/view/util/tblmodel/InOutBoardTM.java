/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.view.util.tblmodel;

/**
 *
 * @author Thushara Supun
 */
public class InOutBoardTM {
    private String employeeID;
    private String date;
    private String inTime;
    private String outTime;

    public InOutBoardTM() {
    }

    public InOutBoardTM(String employeeID, String date, String inTime, String outTime) {
        this.employeeID = employeeID;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the inTime
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the outTime
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * @param outTime the outTime to set
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "InOutBoardTM{" + "employeeID=" + employeeID + ", date=" + date + ", inTime=" + inTime + ", outTime=" + outTime + '}';
    }
    
}

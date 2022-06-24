/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dto;

/**
 *
 * @author Thushara Supun
 */
public class HolidayAndLeavesDTO {
    private String employeeID;
    private String date;
    private String holidayType;
    private String description;

    public HolidayAndLeavesDTO() {
    }

    public HolidayAndLeavesDTO(String employeeID, String date, String holidayType, String description) {
        this.employeeID = employeeID;
        this.date = date;
        this.holidayType = holidayType;
        this.description = description;
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
     * @return the holidayType
     */
    public String getHolidayType() {
        return holidayType;
    }

    /**
     * @param holidayType the holidayType to set
     */
    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HolidayDTO{" + "employeeID=" + employeeID + ", date=" + date + ", holidayType=" + holidayType + ", description=" + description + '}';
    }
    
}

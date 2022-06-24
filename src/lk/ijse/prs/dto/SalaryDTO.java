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
public class SalaryDTO {
    private String EmployeeID;
    private String month;
    private double basicSalary;
    private double noPay;
    private double totalSalary;
    private double grossSalary;
    private double netSalary;

    public SalaryDTO() {
    }

    public SalaryDTO(String EmployeeID, String month, double basicSalary, double noPay, double totalSalary, double grossSalary, double netSalary) {
        this.EmployeeID = EmployeeID;
        this.month = month;
        this.basicSalary = basicSalary;
        this.noPay = noPay;
        this.totalSalary = totalSalary;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
    }

    /**
     * @return the EmployeeID
     */
    public String getEmployeeID() {
        return EmployeeID;
    }

    /**
     * @param EmployeeID the EmployeeID to set
     */
    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the basicSalary
     */
    public double getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @return the noPay
     */
    public double getNoPay() {
        return noPay;
    }

    /**
     * @param noPay the noPay to set
     */
    public void setNoPay(double noPay) {
        this.noPay = noPay;
    }

    /**
     * @return the totalSalary
     */
    public double getTotalSalary() {
        return totalSalary;
    }

    /**
     * @param totalSalary the totalSalary to set
     */
    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    /**
     * @return the grossSalary
     */
    public double getGrossSalary() {
        return grossSalary;
    }

    /**
     * @param grossSalary the grossSalary to set
     */
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    /**
     * @return the netSalary
     */
    public double getNetSalary() {
        return netSalary;
    }

    /**
     * @param netSalary the netSalary to set
     */
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" + "EmployeeID=" + EmployeeID + ", month=" + month + ", basicSalary=" + basicSalary + ", noPay=" + noPay + ", totalSalary=" + totalSalary + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + '}';
    }
    
    
}

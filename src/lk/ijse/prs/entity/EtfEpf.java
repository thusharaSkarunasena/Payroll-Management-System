/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.entity;

/**
 *
 * @author Thushara Supun
 */
public class EtfEpf {
    private String customerID;
    private String month;
    private double etfAmount;
    private double epfAmount;

    public EtfEpf() {
    }

    public EtfEpf(String customerID, String month, double etfAmount, double epfAmount) {
        this.customerID = customerID;
        this.month = month;
        this.etfAmount = etfAmount;
        this.epfAmount = epfAmount;
    }

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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
     * @return the etfAmount
     */
    public double getEtfAmount() {
        return etfAmount;
    }

    /**
     * @param etfAmount the etfAmount to set
     */
    public void setEtfAmount(double etfAmount) {
        this.etfAmount = etfAmount;
    }

    /**
     * @return the epfAmount
     */
    public double getEpfAmount() {
        return epfAmount;
    }

    /**
     * @param epfAmount the epfAmount to set
     */
    public void setEpfAmount(double epfAmount) {
        this.epfAmount = epfAmount;
    }

    @Override
    public String toString() {
        return "EtfEpf{" + "customerID=" + customerID + ", month=" + month + ", etfAmount=" + etfAmount + ", epfAmount=" + epfAmount + '}';
    }
    
}

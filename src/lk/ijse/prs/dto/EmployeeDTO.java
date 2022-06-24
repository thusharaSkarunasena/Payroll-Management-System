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
public class EmployeeDTO {
    private String employeeID;
    private String employeeTypeName;
    private String name;
    private String nic;
    private String addressNo;
    private String addressStreet;
    private String addressVillage;
    private String addressCity;
    private String contactNoHome;
    private String contactNoMobile;
    private String otherDetail;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeID, String employeeTypeName, String name, String nic, String addressNo, String addressStreet, String addressVillage, String addressCity, String contactNoHome, String contactNoMobile, String otherDetail) {
        this.employeeID = employeeID;
        this.employeeTypeName = employeeTypeName;
        this.name = name;
        this.nic = nic;
        this.addressNo = addressNo;
        this.addressStreet = addressStreet;
        this.addressVillage = addressVillage;
        this.addressCity = addressCity;
        this.contactNoHome = contactNoHome;
        this.contactNoMobile = contactNoMobile;
        this.otherDetail = otherDetail;
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
     * @return the employeeTypeName
     */
    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    /**
     * @param employeeTypeName the employeeTypeName to set
     */
    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the addressNo
     */
    public String getAddressNo() {
        return addressNo;
    }

    /**
     * @param addressNo the addressNo to set
     */
    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    /**
     * @return the addressStreet
     */
    public String getAddressStreet() {
        return addressStreet;
    }

    /**
     * @param addressStreet the addressStreet to set
     */
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    /**
     * @return the addressVillage
     */
    public String getAddressVillage() {
        return addressVillage;
    }

    /**
     * @param addressVillage the addressVillage to set
     */
    public void setAddressVillage(String addressVillage) {
        this.addressVillage = addressVillage;
    }

    /**
     * @return the addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * @param addressCity the addressCity to set
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     * @return the contactNoHome
     */
    public String getContactNoHome() {
        return contactNoHome;
    }

    /**
     * @param contactNoHome the contactNoHome to set
     */
    public void setContactNoHome(String contactNoHome) {
        this.contactNoHome = contactNoHome;
    }

    /**
     * @return the contactNoMobile
     */
    public String getContactNoMobile() {
        return contactNoMobile;
    }

    /**
     * @param contactNoMobile the contactNoMobile to set
     */
    public void setContactNoMobile(String contactNoMobile) {
        this.contactNoMobile = contactNoMobile;
    }

    /**
     * @return the otherDetail
     */
    public String getOtherDetail() {
        return otherDetail;
    }

    /**
     * @param otherDetail the otherDetail to set
     */
    public void setOtherDetail(String otherDetail) {
        this.otherDetail = otherDetail;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeID=" + employeeID + ", employeeTypeName=" + employeeTypeName + ", name=" + name + ", nic=" + nic + ", addressNo=" + addressNo + ", addressStreet=" + addressStreet + ", addressVillage=" + addressVillage + ", addressCity=" + addressCity + ", contactNoHome=" + contactNoHome + ", contactNoMobile=" + contactNoMobile + ", otherDetail=" + otherDetail + '}';
    }
}

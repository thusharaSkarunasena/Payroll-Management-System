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
public class EmployeeTM {
    private String employeeID;
    private String name;
    private String nic;
    private String employment;

    public EmployeeTM() {
    }

    public EmployeeTM(String employeeID, String name, String nic, String employment) {
        this.employeeID = employeeID;
        this.name = name;
        this.nic = nic;
        this.employment = employment;
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
     * @return the employment
     */
    public String getEmployment() {
        return employment;
    }

    /**
     * @param employment the employment to set
     */
    public void setEmployment(String employment) {
        this.employment = employment;
    }

    @Override
    public String toString() {
        return "EmployeeTM{" + "employeeID=" + employeeID + ", name=" + name + ", nic=" + nic + ", employment=" + employment + '}';
    }
    
}

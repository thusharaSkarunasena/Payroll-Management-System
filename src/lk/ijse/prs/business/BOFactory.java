/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business;

import lk.ijse.prs.business.custom.impl.EmployeeBOImpl;
import lk.ijse.prs.business.custom.impl.EtfEpfBOImpl;
import lk.ijse.prs.business.custom.impl.HolidayAndLeavesBOImpl;
import lk.ijse.prs.business.custom.impl.InOutBoardBOImpl;
import lk.ijse.prs.business.custom.impl.LogInBOImpl;
import lk.ijse.prs.business.custom.impl.SalaryBOImpl;

/**
 *
 * @author Thushara Supun
 */
public class BOFactory {
    
    public enum BOTypes{
        LOGIN, EMPLOYEE, INOUTBOARD, SALARY, ETFEPF, HOLIDAYANDLEAVES;
    }
    
    private static  BOFactory bOFactory;

    public BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if(bOFactory==null){
            bOFactory=new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOTypes bOTypes){
        switch(bOTypes){
            case LOGIN:
                return new LogInBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case INOUTBOARD:
                return new InOutBoardBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case ETFEPF:
                return new EtfEpfBOImpl();
            case HOLIDAYANDLEAVES:
                return new HolidayAndLeavesBOImpl();
            default:
                return null;
        }
    }
    
    
    
}

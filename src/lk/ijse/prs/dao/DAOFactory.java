/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao;

import lk.ijse.prs.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.prs.dao.custom.impl.EtfEpfDAOImpl;
import lk.ijse.prs.dao.custom.impl.HolidayAndLeavesDAOImpl;
import lk.ijse.prs.dao.custom.impl.InOutBoardDAOImpl;
import lk.ijse.prs.dao.custom.impl.LogInDAOImpl;
import lk.ijse.prs.dao.custom.impl.SalaryDAOImpl;

/**
 *
 * @author Thushara Supun
 */
public class DAOFactory {
    
    public enum DAOTypes{
        LOGIN, EMPLOYEE, INOUTBOARD, SALARY, ETFEPF, HOLIDAYANDLEAVES;
    }
    
    private static DAOFactory dAOFactory;

    public DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if(dAOFactory==null){
            dAOFactory=new DAOFactory();
        }
        return dAOFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case LOGIN:
                return new LogInDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case INOUTBOARD:
                return new InOutBoardDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case ETFEPF:
                return new EtfEpfDAOImpl();
            case HOLIDAYANDLEAVES:
                return new HolidayAndLeavesDAOImpl();
            default:
                return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.prs.business.custom.SalaryBO;
import lk.ijse.prs.dao.DAOFactory;
import lk.ijse.prs.dao.custom.SalaryDAO;
import lk.ijse.prs.dto.SalaryDTO;
import lk.ijse.prs.entity.Salary;

/**
 *
 * @author Thushara Supun
 */
public class SalaryBOImpl implements SalaryBO{
    
    SalaryDAO salaryDAO=(SalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public ArrayList<SalaryDTO> loadAllDetails() throws Exception {
        ArrayList<Salary> salarys=salaryDAO.getAll();
        ArrayList<SalaryDTO> sdtos=new ArrayList<>();
        
        for(Salary s:salarys){
            sdtos.add(new SalaryDTO(
                    s.getEmployeeID(),
                    s.getMonth(),
                    s.getBasicSalary(),
                    s.getNoPay(),
                    s.getTotalSalary(),
                    s.getGrossSalary(),
                    s.getNetSalary()
            ));
        }
        return sdtos;
    }
    
}

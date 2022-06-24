/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.prs.dao.CrudUtill;
import lk.ijse.prs.dao.custom.SalaryDAO;
import lk.ijse.prs.entity.Salary;

/**
 *
 * @author Thushara Supun
 */
public class SalaryDAOImpl implements SalaryDAO{

    @Override
    public ArrayList<Salary> getAll() throws Exception {
        ResultSet rst=CrudUtill.executeQuery("call getAllSalarys()");
        ArrayList<Salary> salarys=new ArrayList<>();
        
        while(rst.next()){
            salarys.add(new Salary(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7)
            ));
        }
        return salarys;
    }

    @Override
    public boolean save(Salary entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salary entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

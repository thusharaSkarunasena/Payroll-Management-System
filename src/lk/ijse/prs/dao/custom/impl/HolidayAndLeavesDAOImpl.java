/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.prs.dao.CrudUtill;
import lk.ijse.prs.entity.HolidayAndLeaves;
import lk.ijse.prs.dao.custom.HolidayAndLeavesDAO;

/**
 *
 * @author Thushara Supun
 */
public class HolidayAndLeavesDAOImpl implements HolidayAndLeavesDAO{

    @Override
    public ArrayList<HolidayAndLeaves> getAll() throws Exception {
        ResultSet rst=CrudUtill.executeQuery("call getAllHolidays()");
        ArrayList<HolidayAndLeaves> holidays=new ArrayList<>();
        
        while(rst.next()){
            holidays.add(new HolidayAndLeaves(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return holidays;
    }
    
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom;

import java.util.ArrayList;
import lk.ijse.prs.dao.SuperDAO;
import lk.ijse.prs.entity.HolidayAndLeaves;

/**
 *
 * @author Thushara Supun
 */
public interface HolidayAndLeavesDAO extends SuperDAO{
    
    public ArrayList<HolidayAndLeaves> getAll() throws Exception;
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom;

import java.util.ArrayList;
import lk.ijse.prs.business.SuperBO;
import lk.ijse.prs.dto.HolidayAndLeavesDTO;

/**
 *
 * @author Thushara Supun
 */
public interface HolidayAndLeavesBO extends SuperBO{
    
    public ArrayList<HolidayAndLeavesDTO> getAll() throws Exception;
    
}

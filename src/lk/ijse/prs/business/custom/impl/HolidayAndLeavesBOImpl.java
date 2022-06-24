/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.prs.dao.DAOFactory;
import lk.ijse.prs.dto.HolidayAndLeavesDTO;
import lk.ijse.prs.entity.HolidayAndLeaves;
import lk.ijse.prs.business.custom.HolidayAndLeavesBO;
import lk.ijse.prs.dao.custom.HolidayAndLeavesDAO;

/**
 *
 * @author Thushara Supun
 */
public class HolidayAndLeavesBOImpl implements HolidayAndLeavesBO{
    
    HolidayAndLeavesDAO holidayDAO=(HolidayAndLeavesDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.HOLIDAYANDLEAVES);

    @Override
    public ArrayList<HolidayAndLeavesDTO> getAll() throws Exception {
        ArrayList<HolidayAndLeaves> holidays=holidayDAO.getAll();
        ArrayList<HolidayAndLeavesDTO> holidayDTOs=new ArrayList<>();
        
        for (HolidayAndLeaves holiday : holidays) {
            holidayDTOs.add(new HolidayAndLeavesDTO(
                    holiday.getEmployeeID(),
                    holiday.getDate(),
                    holiday.getHolidayType(),
                    holiday.getDescription()
            ));
        }
        return holidayDTOs;
    }
    
}

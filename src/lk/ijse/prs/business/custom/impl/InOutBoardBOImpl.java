/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.prs.business.custom.InOutBoardBO;
import lk.ijse.prs.dao.DAOFactory;
import lk.ijse.prs.dao.custom.InOutBoardDAO;
import lk.ijse.prs.dto.InOutBoardDTO;
import lk.ijse.prs.entity.InOutBoard;

/**
 *
 * @author Thushara Supun
 */
public class InOutBoardBOImpl implements InOutBoardBO{

    InOutBoardDAO inOutBoardDAO=(InOutBoardDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INOUTBOARD);
    
    @Override
    public ArrayList<InOutBoardDTO> loadAllRecords() throws Exception{
        ArrayList<InOutBoard> inOutBoardRecords=inOutBoardDAO.getAll();
        ArrayList<InOutBoardDTO> inOutBoardRecordDTOs=new ArrayList<>();
        
        for(InOutBoard iob:inOutBoardRecords){
            inOutBoardRecordDTOs.add(new InOutBoardDTO(
                    iob.getEmployeeID(),
                    iob.getDate(),
                    iob.getInTime(),
                    iob.getOutTime()
            ));
        }
        return inOutBoardRecordDTOs;
    }

    @Override
    public void inBtn(InOutBoardDTO inOutBoardDTO) throws Exception {
        inOutBoardDAO.inBtn(new InOutBoard(
            inOutBoardDTO.getEmployeeID(),
            inOutBoardDTO.getDate(),
            inOutBoardDTO.getInTime(),
            inOutBoardDTO.getOutTime()
        ));
    }

    @Override
    public void outBtn(InOutBoardDTO inOutBoardDTO) throws Exception {
        inOutBoardDAO.outBtn(new InOutBoard(
            inOutBoardDTO.getEmployeeID(),
            inOutBoardDTO.getDate(),
            inOutBoardDTO.getInTime(),
            inOutBoardDTO.getOutTime()
        ));
    }

    @Override
    public void checkAttendanceNoPay() throws Exception {
        inOutBoardDAO.checkAttendanceNoPay();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom;

import java.util.ArrayList;
import lk.ijse.prs.business.SuperBO;
import lk.ijse.prs.dto.InOutBoardDTO;

/**
 *
 * @author Thushara Supun
 */
public interface InOutBoardBO extends SuperBO{
    
    public ArrayList<InOutBoardDTO> loadAllRecords() throws Exception;
    
    public void inBtn(InOutBoardDTO inOutBoardDTO) throws Exception;
    
    public void outBtn(InOutBoardDTO inOutBoardDTO) throws Exception;
    
    public void checkAttendanceNoPay() throws Exception;
   
}

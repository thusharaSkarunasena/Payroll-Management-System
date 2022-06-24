/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom;

import lk.ijse.prs.dao.CrudDAO;
import lk.ijse.prs.entity.InOutBoard;

/**
 *
 * @author Thushara Supun
 */
public interface InOutBoardDAO extends CrudDAO<InOutBoard, String>{
    
    public void inBtn(InOutBoard inOutBoard) throws Exception;
    
    public void outBtn(InOutBoard inOutBoard) throws Exception;
    
    public void checkAttendanceNoPay() throws Exception;
    
}

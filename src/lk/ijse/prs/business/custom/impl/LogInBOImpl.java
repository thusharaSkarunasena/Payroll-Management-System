/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom.impl;

import lk.ijse.prs.business.custom.LogInBO;
import lk.ijse.prs.dao.DAOFactory;
import lk.ijse.prs.dao.custom.LogInDAO;
import lk.ijse.prs.dto.LogInDTO;
import lk.ijse.prs.entity.LogIn;

/**
 *
 * @author Thushara Supun
 */
public class LogInBOImpl implements LogInBO{
    
    LogInDAO logInDAO=(LogInDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    @Override
    public boolean verifyUserPass(LogInDTO logInDTO) throws Exception {
        LogIn logIn=new LogIn(logInDTO.getUsername(), logInDTO.getPassword());
        return logInDAO.verifyUserPass(logIn);
    }
    
}

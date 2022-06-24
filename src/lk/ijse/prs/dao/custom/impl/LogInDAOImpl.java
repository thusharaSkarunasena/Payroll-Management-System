/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom.impl;

import java.sql.ResultSet;
import lk.ijse.prs.dao.CrudUtill;
import lk.ijse.prs.dao.custom.LogInDAO;
import lk.ijse.prs.entity.LogIn;

/**
 *
 * @author Thushara Supun
 */
public class LogInDAOImpl implements LogInDAO{

    @Override
    public boolean verifyUserPass(LogIn login) throws Exception {
        
        ResultSet rst=CrudUtill.executeQuery("call verifyUserPass(?,?)", login.getUsername(), login.getPassword());
        
        if(rst.next()){
            return true;
        }else{
            return false;
        }
    }
    
}

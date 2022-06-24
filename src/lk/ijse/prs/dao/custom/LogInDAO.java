/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom;

import lk.ijse.prs.dao.SuperDAO;
import lk.ijse.prs.entity.LogIn;

/**
 *
 * @author Thushara Supun
 */
public interface LogInDAO extends SuperDAO{
    
    public boolean verifyUserPass(LogIn logIn) throws Exception;
    
}

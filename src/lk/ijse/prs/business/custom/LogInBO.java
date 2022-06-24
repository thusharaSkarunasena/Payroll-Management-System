/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom;

import lk.ijse.prs.business.SuperBO;
import lk.ijse.prs.dto.LogInDTO;

/**
 *
 * @author Thushara Supun
 */
public interface LogInBO extends SuperBO{
    
        public boolean verifyUserPass(LogInDTO logInDTO) throws Exception;
    
}

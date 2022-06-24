/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.prs.dao.CrudUtill;
import lk.ijse.prs.dao.custom.EtfEpfDAO;
import lk.ijse.prs.entity.EtfEpf;

/**
 *
 * @author Thushara Supun
 */
public class EtfEpfDAOImpl implements EtfEpfDAO{

    @Override
    public ArrayList<EtfEpf> getAll() throws Exception {
        ResultSet rst=CrudUtill.executeQuery("call getAllETFEPF()");
        
        ArrayList<EtfEpf> epfs=new ArrayList<>();
        
        while(rst.next()){
            epfs.add(new EtfEpf(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4)
            ));
        }
        return epfs;
    }
    
}

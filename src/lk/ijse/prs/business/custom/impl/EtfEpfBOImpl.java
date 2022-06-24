/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.prs.business.custom.EtfEpfBO;
import lk.ijse.prs.dao.DAOFactory;
import lk.ijse.prs.dao.custom.EtfEpfDAO;
import lk.ijse.prs.dto.EtfEpfDTO;
import lk.ijse.prs.entity.EtfEpf;

/**
 *
 * @author Thushara Supun
 */
public class EtfEpfBOImpl implements EtfEpfBO{
    EtfEpfDAO etfEpfDAO=(EtfEpfDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ETFEPF);

    @Override
    public ArrayList<EtfEpfDTO> getAll() throws Exception {
        ArrayList<EtfEpf> etfEpfs=etfEpfDAO.getAll();
        ArrayList<EtfEpfDTO> epfDTOs=new ArrayList<>();
        
        for (EtfEpf etfEpf : etfEpfs) {
            epfDTOs.add(new EtfEpfDTO(
                    etfEpf.getCustomerID(),
                    etfEpf.getMonth(),
                    etfEpf.getEtfAmount(),
                    etfEpf.getEpfAmount()
            ));
        }
        return epfDTOs;
    }
    
}

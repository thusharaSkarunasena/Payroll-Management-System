/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.prs.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.prs.business.BOFactory;
import lk.ijse.prs.business.custom.EtfEpfBO;
import lk.ijse.prs.dto.EtfEpfDTO;
import lk.ijse.prs.view.util.tblmodel.EtfEpfTM;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class Etf_EpfController implements Initializable {

    @FXML
    private JFXTextField employeeIDTF;
    @FXML
    private JFXTextField monthTF;
    @FXML
    private JFXTextField EtfTF;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXTextField EpfTF1;
    @FXML
    private JFXButton refreshBtn;
    @FXML
    private JFXButton viewMoreBtn;
    @FXML
    private TableView<EtfEpfTM> etfEpfTbl;

    EtfEpfBO etfEpfBO = (EtfEpfBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ETFEPF);

    ObservableList<EtfEpfTM> etfEpfTM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        etfEpfTbl.getColumns().get(0).setStyle("-fx-alignment:center");
        etfEpfTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        etfEpfTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("month"));
        etfEpfTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("etfAmount"));
        etfEpfTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("epfAmount"));

        loadAllEtfEpf();
    }

    public void loadAllEtfEpf() {
        try {
            ArrayList<EtfEpfDTO> etfEpfDTOs = etfEpfBO.getAll();

            if (etfEpfDTOs == null) {
                //Do Nothing
            } else {
                etfEpfTM = etfEpfTbl.getItems();
                etfEpfTM.removeAll(etfEpfTM);

                for (EtfEpfDTO eedto : etfEpfDTOs) {
                    etfEpfTM.add(new EtfEpfTM(
                            eedto.getCustomerID(),
                            eedto.getMonth(),
                            eedto.getEtfAmount(),
                            eedto.getEpfAmount()
                    ));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Etf_EpfController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clearBtn_onAction(ActionEvent event) {
        employeeIDTF.setText("");
        monthTF.setText("");
        EtfTF.setText("");
        EpfTF1.setText("");
    }

    @FXML
    private void refreshBtn_onAction(ActionEvent event) {
        loadAllEtfEpf();
    }

    @FXML
    private void viewMore_onAction(ActionEvent event) {
    }

    @FXML
    private void etfEpfTbl_onMouseClick(MouseEvent event) {
        EtfEpfTM etfEpfTM = etfEpfTbl.getSelectionModel().getSelectedItem();
        if (etfEpfTM == null) {
            //DO Nothing
        } else {
            employeeIDTF.setText(etfEpfTM.getCustomerID());
            monthTF.setText(etfEpfTM.getMonth());
            EtfTF.setText(Double.toString(etfEpfTM.getEtfAmount()));
            EpfTF1.setText(Double.toString(etfEpfTM.getEpfAmount()));
        }

    }

}

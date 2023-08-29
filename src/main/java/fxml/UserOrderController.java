/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rpl.labman.labman.Order;

/**
 * FXML Controller class
 *
 * @author Iyes
 */
public class UserOrderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label tanggal;

    @FXML
    private Label lab;

    @FXML
    private Label email;

    @FXML
    private Label status;
    
    public void setData(Order order){        
        String statusIn = order.getStats();
        String statusOut="Default";
        if("1".equals(statusIn)){
            statusOut="Menunggu";
        } else if("2".equals(statusIn)){
            statusOut="Diterima";
        } else if("3".equals(statusIn)){
            statusOut="Ditolak";
        } else
            statusOut="Hasil Else";
        email.setText(order.getAdminEmail());
        lab.setText(order.getLab());
        tanggal.setText(order.getTanggal());
        status.setText(statusOut);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

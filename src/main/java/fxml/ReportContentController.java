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
public class ReportContentController implements Initializable {

    
    @FXML
    private Label pemesan;

    @FXML
    private Label penerima;

    @FXML
    private Label tanggal;

    @FXML
    private Label lab;
    
    public void setData(Order order){
        pemesan.setText(order.getEmail());
        penerima.setText(order.getAdminEmail());
        tanggal.setText(order.getTanggal());
        lab.setText(order.getLab());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

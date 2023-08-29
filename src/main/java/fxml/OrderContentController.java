package fxml;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rpl.labman.labman.HomePageController;
import rpl.labman.labman.Order;
/**
 * FXML Controller class
 *
 * @author Iyes
 */
public class OrderContentController implements Initializable {

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
    
    
    private Order order;    
    public void setData(Order order){
        String statusOut=order.getStats();
        if (statusOut.equals("1")){
            statusOut="Menunggu";
        } else if (statusOut.equals("2")) {
            statusOut="Diterima";
        } else if (statusOut.equals("3")) {
            statusOut="Ditolak";
        }
        email.setText(order.getEmail());
        lab.setText(order.getLab());
        status.setText(statusOut);
        tanggal.setText(order.getTanggal());
        this.order=order;
    }
    
    public void pilihOrder(){
        HomePageController.selectedOrder=order.getId();
        System.out.println("Order dengan ID "+order.getId()+" telah terpilih");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

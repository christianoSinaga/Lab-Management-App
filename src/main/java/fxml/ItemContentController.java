/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import rpl.labman.labman.Item;
import rpl.labman.labman.HomePageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Iyes
 */
public class ItemContentController implements Initializable {

    @FXML
    private Label itemId;
    @FXML
    private Label itemNama;
    @FXML
    private Label itemLokasi;
    @FXML
    private Label itemStatus;

    /**
     * Initializes the controller class.
     */
    private Item item;
    public void setData(Item item){
        String status = item.getStatus();
        if(status.equals("1")){
            status="Tersedia";
        } else if (status.equals("2")) {
            status="Dalam Perbaikan";
        }
        itemNama.setText(item.getName());
        itemLokasi.setText(item.getLoc());
        itemStatus.setText(status);
        this.item=item;
    }
    
    public void selectItem(){
        HomePageController.selectedItem=item.getId();
        System.out.println("Anda memilih item "+item.getId());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

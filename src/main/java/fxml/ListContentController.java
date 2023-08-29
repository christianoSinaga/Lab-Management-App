/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;
import rpl.labman.labman.Lab;
import rpl.labman.labman.HomePageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Iyes
 */
public class ListContentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label labLoc;

    @FXML
    private Button labButton;

    @FXML
    private Label labName;

    @FXML
    private Label labStats;
        
    private Lab lab;
    public void setData(Lab lab){
        String status=lab.getLabStats();
        if (status.equals("1")){
            status="Tersedia";
        } else if (status.equals("2")) {
            status="Dalam Perbaikan";
        }
        labName.setText(lab.getLabName());
        labLoc.setText(lab.getLabLoc());
        labStats.setText(status);
        this.lab=lab;
    }
    public void openCreateOrder(){        
        HomePageController.selectedLab=lab.getLabId();
        System.out.println("Lab "+lab.getLabId()+" telah terpilih!");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}

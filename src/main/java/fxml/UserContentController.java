/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import rpl.labman.labman.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import rpl.labman.labman.HomePageController;

/**
 * FXML Controller class
 *
 * @author Iyes
 */
public class UserContentController implements Initializable {

    @FXML
    private Label userEmail;
    @FXML
    private Label userName;
    @FXML
    private Label userPass;
    @FXML
    private Label userRole;
    @FXML
    private Button deleteButton;

    /**
     * Initializes the controller class.
     */
    private User user;
    public void setData(User user){
        String role=user.getRole();
        if (role.equals("1")){
            role="Admin Lab";
        } else if (role.equals("2")) {
            role="Kasublab & Pimpinan Fakultas";
        } else if (role.equals("3")) {
            role="Dosen & Mahasiswa";
        }
        userEmail.setText(user.getEmail());
        userName.setText(user.getUsername());
        userPass.setText(user.getPassword());
        userRole.setText(role);
        this.user=user;     
    }
    public void deleteUser(ActionEvent event){
        System.out.println("User "+user.getUserId()+" is Selected");
        HomePageController.selectedUser=user.getUserId();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

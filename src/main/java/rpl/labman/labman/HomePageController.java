/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package rpl.labman.labman;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import rpl.labman.labman.Lab;
import fxml.ListContentController;
import java.io.IOException;
import rpl.labman.labman.User;
import fxml.UserContentController;
import rpl.labman.labman.Item;
import fxml.ItemContentController;
import fxml.OrderContentController;
import fxml.UserOrderController;
import fxml.ReportContentController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import rpl.labman.labman.Item;
import rpl.labman.labman.Item;
import rpl.labman.labman.Item;
import rpl.labman.labman.Item;
import rpl.labman.labman.Lab;
import rpl.labman.labman.Lab;
import rpl.labman.labman.Lab;
import rpl.labman.labman.Lab;
import rpl.labman.labman.Order;
import rpl.labman.labman.Order;
import rpl.labman.labman.Order;
import rpl.labman.labman.Order;
import rpl.labman.labman.User;
import rpl.labman.labman.User;
import rpl.labman.labman.User;
import rpl.labman.labman.User;

/**
 * FXML Controller class
 *
 * @author Iyes
 */
public class HomePageController implements Initializable {
    
    @FXML
    private Label itemNameOut, itemLabOut, itemCpuOut, itemGpuOut, itemJmlOut,itemRamOut,itemSoOut;
    @FXML
    private VBox sideBar;
    @FXML
    private Button homeButton, exitButton;
    @FXML
    private Button loginButton, manageButton, addButton, manageItemButton, managePesananButton;
    @FXML
    private VBox p_home, sidebar;
    @FXML
    private HBox topBar;
    @FXML
    private AnchorPane p_login, p_register, p_manage, p_add, p_addOrder, p_userManage, p_itemManage, p_createOrder, p_labManage, p_createLab, p_createItem;
    @FXML
    private AnchorPane p_orderManage, p_admOrderManage, p_itemDetails, p_userOrder, p_orderReport, p_labUpdate;
    @FXML
    private Button regisButton, login, regis;
    @FXML
    private VBox labContainer, userContainer, itemManageContainer, labManageContainer, orderContainer, userOrderContainer, orderReportContainer;
    @FXML   
    private TextField loginEmailInput, regisEmailInput, regisUsernameInput, regisPasswordInput, labNameInput, labLocInput;
    @FXML
    private TextField itemNameInput, itemSisopInput, itemCpuInput, itemGpuInput, itemRamInput, itemJumlahInput;    
    @FXML
    private PasswordField loginPasswordInput;
    @FXML
    private ComboBox<String> regisRoleInput, labStatusInput, labStatusUpdate;
    @FXML
    private ComboBox<String> timePicker, itemStatusInput, orderManageInput, itemStatusUpdate;
    @FXML
    private ComboBox<Integer> pilihLabInput;
    @FXML
    private DatePicker tanggalInput;
    @FXML
    public static Button openCreateOrderButton;
    
    
    public static int currentUserID, currentUserRole, selectedLab, selectedOrder, selectedUser, selectedItem;
    private Connection conn;

    /**
     * Initializes the controller class.
     */
    
    public void setDBConnection(Connection conn){
        this.conn=conn;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        regisRoleInput.getItems().addAll("1 : Admin Lab", "2 : Kasublab & Pimpinan Fakultas", "3 : Mahasiswa & Dosen");
        labStatusInput.getItems().addAll("1 : Tersedia", "2 : Dalam Perbaikan");
        timePicker.getItems().addAll("07:00", "09:00", "11:00","13:00","15:00");
        itemStatusInput.getItems().addAll("1 : Tersedia", "2 : Dalam Perbaikan");
        orderManageInput.getItems().addAll("Terima", "Tolak");
        itemStatusUpdate.getItems().addAll("1 : Tersedia", "2 : Dalam Perbaikan");
        labStatusUpdate.getItems().addAll("1 : Tersedia", "2 : Dalam Perbaikan");
        manageButton.setVisible(false);        
        addButton.setVisible(false);
        // TODO
        List<Lab> lab = new ArrayList<>(lab());
        for(int i=0; i<lab.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("listContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                ListContentController lcc = fxmlLoader.getController();
                lcc.setData(lab.get(i));
                labContainer.getChildren().add(hBox);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        
        List<Lab> labManage = new ArrayList<>(lab());
        for(int i=0; i<labManage.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("listContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                ListContentController lcc = fxmlLoader.getController();
                lcc.setData(labManage.get(i));
                labManageContainer.getChildren().add(hBox);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        
        List<User> user = new ArrayList<>(user());
        for(int i=0; i<user.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("userContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                UserContentController ucc = fxmlLoader.getController();
                ucc.setData(user.get(i));
                userContainer.getChildren().add(hBox);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        
        List<Item> item = new ArrayList<>(item());
        for(int i=0; i<item.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("itemContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                ItemContentController icc = fxmlLoader.getController();
                icc.setData(item.get(i));
                itemManageContainer.getChildren().add(hBox);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        
        List<Order> order = new ArrayList<>(order());
        for(int i=0; i<order.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("orderContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                OrderContentController occ = fxmlLoader.getController();
                occ.setData(order.get(i));
                orderContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
        List<Order> userOrder = new ArrayList<>(userOrder());
        for(int i=0; i<userOrder.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("userOrder.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                UserOrderController uoc=fxmlLoader.getController();
                uoc.setData(userOrder.get(i));
                userOrderContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        List<Order> report = new ArrayList<>(report());
        for(int i=0; i<report.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("reportContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                ReportContentController rcc=fxmlLoader.getController();
                rcc.setData(report.get(i));
                orderReportContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
    
    /**                                                         Controller                                                          **/    
    //PAGE CONTROLLER   
    public void closePage(){
        Platform.exit();
        System.exit(0);
    }        
    public void openHome(){           
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(true);   
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        p_admOrderManage.setVisible(false);
        p_itemDetails.setVisible(false);
        p_userOrder.setVisible(false);
        p_orderReport.setVisible(false);
        p_labUpdate.setVisible(false);

    }    
    public void openLogin(){        
        p_login.setVisible(true);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false); 
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        p_admOrderManage.setVisible(false);
        p_itemDetails.setVisible(false);
        p_userOrder.setVisible(false);
        p_orderReport.setVisible(false);
        p_labUpdate.setVisible(false);
    }    
    public void openRegis(){
        p_login.setVisible(false);
        p_register.setVisible(true);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false); 
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
    }    
    public void openManage(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(true);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        p_admOrderManage.setVisible(false);
        p_itemDetails.setVisible(false);
        p_userOrder.setVisible(false);    
        p_orderReport.setVisible(false);
        p_labUpdate.setVisible(false);
    }    
    public void openAdd(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(true);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        p_itemDetails.setVisible(false);
        p_userOrder.setVisible(false);
        p_orderReport.setVisible(false);
        p_labUpdate.setVisible(false);
    }    
    public void openAddOrder(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(true);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
    }    
    public void openUserManage(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(true);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
    }    
    public void openItemManage(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(true);
        p_createOrder.setVisible(false);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        p_itemDetails.setVisible(false);
    }
    public void openCreateOrder(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(true);
        p_createLab.setVisible(false);
        p_labManage.setVisible(false);
        System.out.println("Anda akan membuat pesanan dengan lab "+selectedLab);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        
    }
    public void openCreateLab(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_labManage.setVisible(false);
        p_createLab.setVisible(true);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
    }
    public void openLabManage(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_labManage.setVisible(true);
        p_createLab.setVisible(false);
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
    }
    public void openCreateItem(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_labManage.setVisible(false);
        p_createLab.setVisible(false); 
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            Statement st=conn.createStatement();
            String query="SELECT LAB_ID FROM LAB;";
            ResultSet resultSet=st.executeQuery(query);
            while(resultSet.next()){
                int labId=resultSet.getInt("LAB_ID");
                pilihLabInput.getItems().add(labId);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }        
        p_createItem.setVisible(true);  
        p_orderManage.setVisible(false);
    }
    public void openOrderManage(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_labManage.setVisible(false);
        p_createLab.setVisible(false); 
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(true);
        p_admOrderManage.setVisible(false);
    }
    public void openAdmOrderManage(){
        p_login.setVisible(false);
        p_register.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
        p_home.setVisible(false);
        p_addOrder.setVisible(false);
        p_userManage.setVisible(false);
        p_itemManage.setVisible(false);
        p_createOrder.setVisible(false);
        p_labManage.setVisible(false);
        p_createLab.setVisible(false); 
        p_createItem.setVisible(false); 
        p_orderManage.setVisible(false);
        p_admOrderManage.setVisible(true);
    }
    public void openItemDetails(){
        p_itemManage.setVisible(false);
        p_itemDetails.setVisible(true);
        itemDetails();
    }
    public void openUserOrder(){
        p_addOrder.setVisible(false);
        p_userOrder.setVisible(true);
    }
    public void openOrderReport(){
        p_orderReport.setVisible(true);
        p_login.setVisible(false);
        p_home.setVisible(false);
        p_manage.setVisible(false);
        p_add.setVisible(false);
    }
    public void openLabUpdate(){
        p_labManage.setVisible(false);
        p_labUpdate.setVisible(true);
    }
    
    //REFRESH CONTENT
    private void refreshItemListView() {
        itemManageContainer.getChildren().clear(); // Clear the existing list items

        List<Item> item = new ArrayList<>(item());
        for (int i = 0; i < item.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("itemContent.fxml"));
            try {
                HBox hBox = fxmlLoader.load();
                ItemContentController icc = fxmlLoader.getController();
                icc.setData(item.get(i));
                itemManageContainer.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void refreshUserListView() {
        userContainer.getChildren().clear(); // Clear the existing list items

        List<User> user = new ArrayList<>(user());
        for (int i = 0; i < user.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("userContent.fxml"));
            try {
                HBox hBox = fxmlLoader.load();
                UserContentController ucc = fxmlLoader.getController();
                ucc.setData(user.get(i));
                userContainer.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void refreshLabListView() {
        labContainer.getChildren().clear(); // Clear the existing list items        
        List<Lab> lab = new ArrayList<>(lab());
        for (int i = 0; i < lab.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("listContent.fxml"));
            try {
                HBox hBox = fxmlLoader.load();
                ListContentController lcc = fxmlLoader.getController();
                lcc.setData(lab.get(i));
                labContainer.getChildren().add(hBox);               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void refreshLabManageView(){
        labManageContainer.getChildren().clear();
        List<Lab> labManage = new ArrayList<>(lab());
        for(int i=0; i<labManage.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("listContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                ListContentController lcc = fxmlLoader.getController();
                lcc.setData(labManage.get(i));
                labManageContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    private void refreshOrderManageView(){
        orderContainer.getChildren().clear();
        List<Order> order = new ArrayList<>(order());
        for(int i=0; i<order.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("orderContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                OrderContentController occ = fxmlLoader.getController();
                occ.setData(order.get(i));
                orderContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    private void refreshUserOrderView(){
        userOrderContainer.getChildren().clear();
        List<Order> userOrder = new ArrayList<>(userOrder());
        for(int i=0; i<userOrder.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("userOrder.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                UserOrderController userControl=fxmlLoader.getController();
                userControl.setData(userOrder.get(i));
                userOrderContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    private void refreshReportView(){
        orderReportContainer.getChildren().clear();
        List<Order> report = new ArrayList<>(report());
        for(int i=0; i<report.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("reportContent.fxml"));
            try{
                HBox hBox = fxmlLoader.load();
                ReportContentController rcc=fxmlLoader.getController();
                rcc.setData(report.get(i));
                orderReportContainer.getChildren().add(hBox);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
        
    //LIST FUNCTION
    private List<Lab> lab(){
        List<Lab> ls = new ArrayList<>();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            Statement st=conn.createStatement();
            String query="SELECT LAB_NAME, LAB_LOCATION, LAB_STATUS, LAB_ID FROM LAB;";
            ResultSet resultSet=st.executeQuery(query);
            while(resultSet.next()){
                Lab lab = new Lab();
                lab.setLabName(resultSet.getString("LAB_NAME"));
                lab.setLabLoc(resultSet.getString("LAB_LOCATION"));
                lab.setLabStats(resultSet.getString("LAB_STATUS"));
                lab.setLabId(resultSet.getInt("LAB_ID"));
                ls.add(lab);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return ls;
    }               
    private List<User> user(){
        List<User> ls = new ArrayList<>();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            Statement st=conn.createStatement();
            String query="SELECT USER_ID, USER_EMAIL, USER_USERNAME, USER_PASSWORD, USER_ROLE FROM PENGGUNA;";
            ResultSet resultSet=st.executeQuery(query);
            while(resultSet.next()){
                User user = new User();
                user.setEmail(resultSet.getString("USER_EMAIL"));
                user.setUsername(resultSet.getString("USER_USERNAME"));
                user.setPassword(resultSet.getString("USER_PASSWORD"));
                user.setRole(resultSet.getString("USER_ROLE"));
                user.setUserId(resultSet.getInt("USER_ID"));
                ls.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }                        
        return ls;
    }    
    private List<Item> item(){
        List<Item> ls = new ArrayList<>();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            Statement st=conn.createStatement();
            String query="SELECT ITEM.ITEM_ID, ITEM.ITEM_NAME, ITEM.ITEM_STATUS, LAB.LAB_NAME AS LAB_LOC\n" +
                        "FROM ITEM ITEM\n" +
                        "LEFT JOIN LAB LAB ON ITEM.LAB_ID = LAB.LAB_ID;";
            ResultSet resultSet=st.executeQuery(query);
            while(resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getInt("ITEM_ID"));
                item.setName(resultSet.getString("ITEM_NAME"));
                item.setLoc(resultSet.getString("LAB_LOC"));
                item.setStatus(resultSet.getString("ITEM_STATUS"));
                ls.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return ls;
    }
    private List<Order> order(){
        List<Order> ls = new ArrayList<>();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            Statement st = conn.createStatement();
            String query = "SELECT o.order_id, o.order_date, o.order_status, l.lab_name, u.user_email\n" +
                        "FROM `pesanan` o\n" +
                        "INNER JOIN lab l ON o.lab_id = l.lab_id\n" +
                        "INNER JOIN pengguna u ON o.user_id = u.user_id\n"+
                        "WHERE o.order_status = 1;";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("order_id"));
                order.setEmail(resultSet.getString("user_email"));                
                order.setTanggal(resultSet.getString("order_date"));
                order.setStats(resultSet.getString("order_status"));
                order.setLab(resultSet.getString("lab_name"));
                ls.add(order);
            }            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ls;
    }
    private List<Order> userOrder(){
        List<Order> ls = new ArrayList<>();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query = "SELECT o.order_id, o.order_date, o.order_status, l.lab_name, u.user_email, a.user_email as adm_email\n" +
                        "FROM `pesanan` o\n" +
                        "INNER JOIN lab l ON o.lab_id = l.lab_id\n" +
                        "INNER JOIN pengguna u ON o.user_id = u.user_id\n"+
                        "LEFT JOIN pengguna a ON o.ADM_USER_ID = a.USER_ID\n"+
                        "WHERE o.user_id = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, currentUserID);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setAdminEmail(resultSet.getString("adm_email"));
                order.setLab(resultSet.getString("lab_name"));
                order.setTanggal(resultSet.getString("order_date"));
                order.setStats(resultSet.getString("order_status"));
                ls.add(order);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ls;
    }
    private List<Order> report(){
        List<Order> ls = new ArrayList<>();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            Statement st = conn.createStatement();
            String query = "SELECT o.order_id, o.order_date, o.order_status, l.lab_name, u.user_email, a.user_email as adm_email\n" +
                        "FROM `pesanan` o\n" +
                        "INNER JOIN lab l ON o.lab_id = l.lab_id\n" +
                        "INNER JOIN pengguna u ON o.user_id = u.user_id\n"+
                        "LEFT JOIN pengguna a ON o.ADM_USER_ID = a.USER_ID\n"+
                        "WHERE o.order_status = 2;";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()){
                Order order = new Order();
                order.setEmail(resultSet.getString("user_email"));
                order.setAdminEmail(resultSet.getString("adm_email"));
                order.setLab(resultSet.getString("lab_name"));
                order.setTanggal(resultSet.getString("order_date"));
                order.setStats(resultSet.getString("order_status"));
                ls.add(order);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ls;
    }
    
    //INPUT DB FUNCTION    
    public void loginUser(){
        String email=loginEmailInput.getText();
        String password=loginPasswordInput.getText();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="SELECT * FROM PENGGUNA WHERE USER_EMAIL = ? AND USER_PASSWORD = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                // Berhasil login
                currentUserID = resultSet.getInt("USER_ID");
                currentUserRole = resultSet.getInt("USER_ROLE");
                String role = "null";
                if(currentUserRole==1)
                    role="Admin Lab";
                else if(currentUserRole==2)
                    role="Kasublab & Pimpinan Fakultas";
                else if(currentUserRole==3)
                    role="Mahasiswa & Dosen";
                showAlert("Login sukses dengan role "+role, Alert.AlertType.INFORMATION);
            } else {
                // Gagal login
                showAlert("Login failed", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Error while connecting to the database", Alert.AlertType.ERROR);
            e.printStackTrace();
        }        
        
        loginEmailInput.clear();
        loginPasswordInput.clear();
        if (currentUserRole == 3){
            addButton.setVisible(false);
            manageButton.setVisible(true);
            manageItemButton.setVisible(false);
            managePesananButton.setVisible(false);
        } else if (currentUserRole == 2){
            addButton.setVisible(false);
            manageButton.setVisible(true);
            manageItemButton.setVisible(true);
            managePesananButton.setVisible(true);
        } else if (currentUserRole == 1){
            addButton.setVisible(true);
            manageButton.setVisible(true);
            manageItemButton.setVisible(true);
            managePesananButton.setVisible(true);
        }
        refreshUserOrderView();
        openHome();
    }    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }    
    public void regisUser(){
        String email=regisEmailInput.getText();
        String username=regisUsernameInput.getText();
        String password=regisPasswordInput.getText();
        int role=1;
        String selectedRole=regisRoleInput.getValue();
        if(selectedRole.equals("1 : Admin Lab")){
            role=1;
        } else if(selectedRole.equals("2 : Kasublab & Pimpinan Fakultas")){
            role=2;
        } else if(selectedRole.equals("3 : Mahasiswa & Dosen")){
            role=3;
        }
        
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="INSERT INTO PENGGUNA (USER_EMAIL, USER_USERNAME, USER_PASSWORD, USER_ROLE, ADM_USER_ID) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setInt(4, role);
            ps.setInt(5, currentUserID);
            int rowsAffected = ps.executeUpdate();
            
            if(rowsAffected>0){
                showAlert("Registration successful", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Registration failed", Alert.AlertType.ERROR);
            }            
        } catch(SQLException e){
            showAlert("Error while connecting to the database", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
        regisEmailInput.clear();
        regisUsernameInput.clear();
        regisPasswordInput.clear();   
        refreshUserListView();
    }    
    public void createLab(){
        String name=labNameInput.getText();
        String location=labLocInput.getText();
        int status=1;
        String statusInput=labStatusInput.getValue();
        if(statusInput.equals("1 : Tersedia")){
            status=1;
        } else if(statusInput.equals("2 : Dalam Perbaikan")){
            status=2;
        }
        
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="INSERT INTO LAB (LAB_NAME, LAB_LOCATION, LAB_STATUS, USER_ID) VALUES (?, ?, ?, ?);";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setInt(3, status);
            ps.setInt(4, currentUserID);
            int rowsAffected = ps.executeUpdate();
            
            if(rowsAffected>0){
                showAlert("Registration successful", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Registration failed", Alert.AlertType.ERROR);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        refreshLabListView();
        refreshLabManageView();
    }      
    public void createOrder(){
        int hour=0, minute=0;
        String selectedTime=timePicker.getValue();
        if(selectedTime.equals("07:00")){
            hour=7;
        } else if(selectedTime.equals("09:00")){
            hour=9;
        } else if(selectedTime.equals("11:00")){
            hour=11;
        } else if(selectedTime.equals("13:00")){
            hour=13;
        } else if(selectedTime.equals("15:00")){
            hour=15;
        }
        LocalDate selectedDate = tanggalInput.getValue();
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="INSERT INTO PESANAN (LAB_ID, ORDER_DATE, USER_ID, ORDER_STATUS) VALUES (?, ?, ?, ?);";
            PreparedStatement ps=conn.prepareStatement(query);
            java.sql.Timestamp timestamp=java.sql.Timestamp.valueOf(selectedDate.atTime(hour,minute));
            ps.setInt(1, selectedLab);
            ps.setTimestamp(2, timestamp);
            ps.setInt(3, currentUserID);
            ps.setInt(4, 1);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected>0){
                showAlert("Registration successful", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Registration failed", Alert.AlertType.ERROR);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }      
        refreshUserOrderView();
        refreshOrderManageView();
        openAddOrder();
    }    
    public void createItem(){
        String name=itemNameInput.getText();
        int status=0;
        String statusInput=itemStatusInput.getValue();
        String sisOp=itemSisopInput.getText();
        String cpu=itemCpuInput.getText();
        String gpu=itemGpuInput.getText();
        String ram=itemRamInput.getText();
        String jumlah=itemJumlahInput.getText();
        if(statusInput.equals("1 : Tersedia"))
            status=1;
        else if(statusInput.equals("2 : Dalam Perbaikan"))
            status=2;
        int idLab=pilihLabInput.getValue();
        
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="INSERT INTO ITEM (ITEM_NAME, ITEM_STATUS, LAB_ID, USER_ID, ITEM_SO, ITEM_CPU, ITEM_GPU, ITEM_RAM, ITEM_JUMLAH) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, status);
            ps.setInt(3, idLab);
            ps.setInt(4, currentUserID);
            ps.setString(5, sisOp);
            ps.setString(6, cpu);
            ps.setString(7, gpu);
            ps.setString(8,ram);
            ps.setString(9, jumlah);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                showAlert("Registration successful", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Registration failed", Alert.AlertType.ERROR);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        refreshItemListView();
    }
    public void manageOrder(){
        int stats=1;
        String orderStatsInput = orderManageInput.getValue();
        if(orderStatsInput.equals("Terima"))
            stats=2;
        else if(orderStatsInput.equals("Tolak"))
            stats=3;
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="UPDATE PESANAN SET ORDER_STATUS = ?, ADM_USER_ID = ? WHERE ORDER_ID = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, stats);
            ps.setInt(2, HomePageController.currentUserID);
            ps.setInt(3, selectedOrder);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                showAlert("Berhasil diubah oleh "+currentUserID, Alert.AlertType.INFORMATION);
            } else {
                showAlert("Gagal", Alert.AlertType.ERROR);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        refreshReportView();
        refreshOrderManageView();
    }
    public void deleteUser(){
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="DELETE FROM PENGGUNA WHERE USER_ID = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, selectedUser);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                showAlert("Berhasil menghapus user dengan "+selectedUser+" oleh "+currentUserID, Alert.AlertType.INFORMATION);
            } else {
                showAlert("Gagal", Alert.AlertType.ERROR);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        refreshUserListView();
    }
    public void itemDetails(){
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="SELECT I.ITEM_NAME, L.LAB_NAME, I.ITEM_STATUS, I.ITEM_SO, I.ITEM_CPU, I.ITEM_GPU, I.ITEM_RAM, I.ITEM_JUMLAH\n" +
                        "FROM ITEM I\n" +
                        "LEFT JOIN LAB L ON I.LAB_ID = L.LAB_ID\n" +
                        "WHERE I.ITEM_ID = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, selectedItem);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                itemNameOut.setText(resultSet.getString("i.item_name"));
                itemLabOut.setText(resultSet.getString("l.lab_name"));
                itemSoOut.setText(resultSet.getString("i.item_so"));
                itemCpuOut.setText(resultSet.getString("i.item_cpu"));
                itemGpuOut.setText(resultSet.getString("i.item_gpu"));
                itemRamOut.setText(resultSet.getString("i.item_ram"));
                itemJmlOut.setText(resultSet.getString("i.item_jumlah"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void manageLab(){
        int stats=1;
        String statusInput = labStatusUpdate.getValue();
        if(statusInput.equals("1 : Tersedia")){
            stats=1;
        } else if(statusInput.equals("2 : Dalam Perbaikan")){
            stats=2;
        }
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="UPDATE LAB SET LAB_STATUS = ? WHERE LAB_ID = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, stats);
            ps.setInt(2, selectedLab);
            int rowsAffected = ps.executeUpdate();
            
            if(rowsAffected>0){
                showAlert("Registration successful", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Registration failed", Alert.AlertType.ERROR);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        refreshLabManageView();
    }
    public void itemDetailsUpdate(){
        int stats = 1;
        String statusInput = itemStatusUpdate.getValue();
        if(statusInput.equals("1 : Tersedia")){
            stats=1;
        } else if(statusInput.equals("2 : Dalam Perbaikan")){
            stats=2;
        }
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "")){
            String query="UPDATE ITEM SET ITEM_STATUS = ?, USER_ID = ? WHERE ITEM_ID = ?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, stats);
            ps.setInt(2, currentUserID);
            ps.setInt(3, selectedItem);
            int rowsAffected = ps.executeUpdate();
            
            if(rowsAffected>0){
                showAlert("Registration successful", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Registration failed", Alert.AlertType.ERROR);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        openItemManage();
    }

}
    

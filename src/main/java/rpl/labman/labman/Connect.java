/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rpl.labman.labman;
import java.sql.*;
/**
 *
 * @author Iyes
 */
public class Connect {

    /**
     * @param args the command line arguments
     */
    public static void connect() {
        String user="root";
        String password="";
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", user, password);
            System.out.println("Connected With the database successfully");
        } catch (SQLException e){
            System.out.println("Error while connecting to the database"+e.getMessage());
        }
    }
    
}

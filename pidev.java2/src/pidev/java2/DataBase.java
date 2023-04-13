/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.java2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alisl
 */
public class DataBase {
    public static Connection connectDb() throws ClassNotFoundException{
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/piidev", "root", "");
            return connect;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}

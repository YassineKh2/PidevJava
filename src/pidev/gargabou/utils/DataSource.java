/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author alisl
 */
public class DataSource {
    private Connection cnx;
    private static DataSource instance;
    
    private final String USER = "root";
    private final String PWD = "";
    private final String URL = "jdbc:mysql://localhost:3306/piidev";

    public DataSource() {
        try {
            cnx = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if(instance == null)
            instance = new DataSource();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}

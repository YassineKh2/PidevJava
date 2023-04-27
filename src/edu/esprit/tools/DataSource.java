/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MsiAs
 */
public class DataSource {
    private final String URL="jdbc:mysql://localhost:3306/pidev1";
    private final String USER="root";
    private final String PWD="";
    private Connection cnx;
    private static DataSource instance;
    
    private DataSource(){
        try{
            cnx = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connected To DB");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static DataSource getInstance() {
        if(instance == null)
            instance = new DataSource();
        return instance;
    }
    
    
}

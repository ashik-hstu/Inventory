/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ashikulislam
 */


  

    public class ConnectionProvider {
    public static Connection getCon() {
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/inventory?useSSL=false";
            String user = "ashik";  
            String password = "ashik";  
            
            // Try to establish a connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully!");  // Success Message
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Ensure MySQL Connector/J is added.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}






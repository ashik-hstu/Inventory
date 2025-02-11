/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ashikulislam
 */
//public class tables {
//
//    public static void main(String[] args) {
//        Connection con = null;
//        Statement st = null;
//        try {
//            con = ConnectionProvider.getCon();
//            st = con.createStatement();
////            st.executeUpdate("CREATE TABLE appuser(appuser_pk int AUTO_INCREMENT PRIMARY KEY,userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50),address varchar(200),status varchar(50) )");                 
//            st.executeUpdate("INSERT INTO appuser(userRole,name,mobileNumber,email,password,address,status) values('superAdmin','Super Admin','12345','superadmin@gmail.com','admin','Bangladesh','Active' )  ");
//                 JOptionPane.showMessageDialog(null,"table created and data entry is successful");
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//        } finally {
//            try {
//
//                con.close();
//                st.close();
//            } catch (Exception e) {
//
//            }
//        }
//    }
//}


public class tables {
    public static void main(String[] args) {
        Connection con = ConnectionProvider.getCon();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed!");
            return;
        }
        Statement st = null;
        try {
            st = con.createStatement();
//             st.executeUpdate("CREATE TABLE appuser(appuser_pk int AUTO_INCREMENT PRIMARY KEY,userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50),address varchar(200),status varchar(50) )");
            st.executeUpdate("INSERT INTO appuser(userRole, name, mobileNumber, email, password, address, status) "
                    + "VALUES('superAdmin', 'Super Admin', '12345', 'superadmin@gmail.com', 'admin', 'Bangladesh', 'Active')");
            JOptionPane.showMessageDialog(null, "Data entry successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


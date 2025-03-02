/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ashikulislam
 */
//public class tables {
//
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

//            User table............
//    st.executeUpdate("CREATE TABLE IF NOT EXISTS appuser ("
//            + "appuser_pk INT AUTO_INCREMENT PRIMARY KEY, "
//            + "userRole VARCHAR(50), "
//            + "name VARCHAR(200), "
//            + "mobileNumber VARCHAR(50), "
//            + "email VARCHAR(200), "
//            + "password VARCHAR(50), "
//            + "address VARCHAR(200), "
//            + "status VARCHAR(50))");
//    System.out.println("Table created successfully.");
//    st.executeUpdate("INSERT INTO appuser(userRole, name, mobileNumber, email, password, address, status) "
//            + "VALUES('Owner', 'Owner Ashik', '12345', 'admin@gmail.com', 'admin', 'Bangladesh', 'Active')");
//    JOptionPane.showMessageDialog(null, "Data inserted successfully.");
// Category table.........
//    st.executeUpdate("CREATE TABLE IF NOT EXISTS category ("
//            + "category_pk INT AUTO_INCREMENT PRIMARY KEY, "
//            + "name VARCHAR(200))");
//    JOptionPane.showMessageDialog(null, "Category table created successfully.");
//    st.executeUpdate("INSERT INTO category(name) VALUES('')");
// Product table.....
//    st.executeUpdate("CREATE TABLE IF NOT EXISTS product ("
//            + "product_pk INT AUTO_INCREMENT PRIMARY KEY, "
//            + "name VARCHAR(200), "
//            + "quantity int,"
//            + "price int, "
//            + "description VARCHAR(300), "
//            + "category_fk int)");
//     JOptionPane.showMessageDialog(null, "Product table created successfully.");
// Customer table
//            st.executeUpdate("CREATE TABLE IF NOT EXISTS customer("
//                    + "customer_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                    + "name VARCHAR(200), "
//                    + "mobileNumber VARCHAR(50),"
//                    + "email VARCHAR(200), "
//                    + "address VARCHAR(200))");
//            JOptionPane.showMessageDialog(null, "Customer table created successfully.");
//Order table
//            st.executeUpdate("CREATE TABLE IF NOT EXISTS orderDetail("
//                    + "order_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                    + "orderId VARCHAR(200), "
//                    + "customer_fk int,"
//                    + "orderDate VARCHAR(200), "
//                    + "totalPaid int)");
//            JOptionPane.showMessageDialog(null, "Order table created successfully.");
//            JOptionPane.showMessageDialog(null, "Data inserted successfully.");
// User activity table
//            st.executeUpdate("CREATE TABLE IF NOT EXISTS userActivity ("
//                    + "    activity_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                    + "    user_fk INT, "
//                    + "    name VARCHAR(200), "
//                    + "    mobileNumber VARCHAR(50), "
//                    + "    date DATE, "
//                    + "    login_time TIME, "
//                    + "    logout_time TIME, "
//                    + "    FOREIGN KEY (user_fk) REFERENCES appuser(appuser_pk) "
//                    + ");");
//            JOptionPane.showMessageDialog(null, "User Activity table created successfully.");

//  String sql = "CREATE TABLE IF NOT EXISTS soldProduct ("
//                + "soldProduct_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                + "product_fk INT, "
//                + "product_name VARCHAR(200), "
//                + "sold_amount INT, "
//                + "FOREIGN KEY (product_fk) REFERENCES product(product_pk))";
//
//    st.executeUpdate(sql);
//    JOptionPane.showMessageDialog(null, "soldProduct table created successfully!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


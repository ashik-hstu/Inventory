/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashikulislam
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import dao.ConnectionProvider;

public class UpdateSoldProduct {

    public static void updateSoldProduct(int productId, int quantitySold) {
        Connection con = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;

        try {
            con = ConnectionProvider.getCon();

            // Get the current quantity of the product
            String query1 = "SELECT quantity FROM product WHERE product_pk = ?";
            pst1 = con.prepareStatement(query1);
            pst1.setInt(1, productId);
            ResultSet rs = pst1.executeQuery();
            int oldQuantity = 0;
            if (rs.next()) {
                oldQuantity = rs.getInt("quantity");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found!");
                return;
            }

            // Update the product quantity
            String query2 = "UPDATE product SET quantity = quantity - ? WHERE product_pk = ?";
            pst2 = con.prepareStatement(query2);
            pst2.setInt(1, quantitySold);
            pst2.setInt(2, productId);
            pst2.executeUpdate();

            // Insert the sold product record
            String query3 = "INSERT INTO soldProduct (product_fk, product_name, sold_amount) "
                           + "SELECT p.product_pk, p.name, (? - p.quantity) AS sold_amount "
                           + "FROM product p "
                           + "WHERE p.product_pk = ?";
            pst3 = con.prepareStatement(query3);
            pst3.setInt(1, oldQuantity);  // Set oldQuantity for calculation
            pst3.setInt(2, productId);
            pst3.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sold product updated successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pst1 != null) pst1.close();
                if (pst2 != null) pst2.close();
                if (pst3 != null) pst3.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

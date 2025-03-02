/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashikulislam
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import dao.ConnectionProvider;

public class FetchTopSoldProducts {

    public static void fetchTopSoldProducts() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            String sql = "SELECT p.name AS product_name, SUM(sp.sold_amount) AS sold_amount "
                       + "FROM soldProduct sp "
                       + "JOIN product p ON sp.product_fk = p.product_pk "
                       + "GROUP BY sp.product_fk "
                       + "ORDER BY sold_amount DESC "
                       + "LIMIT 5";

            rs = st.executeQuery(sql);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No top-selling products found.");
                return;
            }

            do {
                String productName = rs.getString("product_name");
                int soldAmount = rs.getInt("sold_amount");
                System.out.println("Product: " + productName + ", Sold Amount: " + soldAmount);
            } while (rs.next());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        fetchTopSoldProducts();
    }
}

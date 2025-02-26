/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashikulislam
 */
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserActivity {

    
    public void updateLogoutTime() {
        int userId = Session.getCurrentUserId();  

        if (userId == 0) {
            JOptionPane.showMessageDialog(null, "No user is currently logged in.");
            return;
        }

       String updateLogoutTimeQuery = "UPDATE userActivity SET logout_time = NOW() WHERE activity_pk = "
                + "(SELECT activity_pk FROM (SELECT activity_pk FROM userActivity WHERE user_fk = ? AND logout_time IS NULL ORDER BY activity_pk DESC LIMIT 1) AS subquery)";

        try (Connection con = ConnectionProvider.getCon(); PreparedStatement pst = con.prepareStatement(updateLogoutTimeQuery)) {

            pst.setInt(1, userId);  
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
//                JOptionPane.showMessageDialog(null, "Log out thik moto place hoise");
            } else {
                JOptionPane.showMessageDialog(null, "No active session is found for this user.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }
}

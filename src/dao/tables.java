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
public class tables {
    
    public static void main(String[] args) {
        Connection con =null;
        Statement st= null;
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            st.executeUpdate("CREATE TABLE connected (userManual_pk INT(20) PRIMARY KEY, roll VARCHAR(20), mov VARCHAR(10))");
                    }        
        
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        finally{
            try{
              
                con.close();
                st.close();
            }
            catch(Exception e){
                
            }
        }
    }
}

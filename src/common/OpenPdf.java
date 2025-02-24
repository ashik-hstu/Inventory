/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;



import dao.InventoryUtils;
import java.io.File;
import javax.swing.JOptionPane;

public class OpenPdf {

    public static void OpenById(String id) {
        try {
            File file = new File(InventoryUtils.billPath + id + ".pdf");
            if (file.exists()) {
                // Use xdg-open for Linux
                Process p = Runtime.getRuntime().exec("xdg-open " + file.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "File does not exist: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error opening PDF: " + e.getMessage());
        }
    }
}



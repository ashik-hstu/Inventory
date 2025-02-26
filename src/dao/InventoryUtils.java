/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;

public class InventoryUtils {
    public static String billPath = "/home/ashikulislam/bills/"; 

    static {
        try {
            File dir = new File(billPath);
            if (!dir.exists() && !dir.mkdirs()) {
                System.err.println("Failed to create directory: " + billPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

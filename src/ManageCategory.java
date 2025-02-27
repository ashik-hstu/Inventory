
import dao.ConnectionProvider;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ashikulislam
 */
public class ManageCategory extends javax.swing.JFrame {

    private int categoryPk = 0;

    /**
     * Creates new form ManageCategory
     */
    public ManageCategory() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(824, 600);
    }

    private boolean validateFields() {
        if (!txtName.getText().isEmpty()) {
            return false;
        }
        return true; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aaaa.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableCategory.setBackground(new java.awt.Color(204, 204, 255));
        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        tableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCategory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 95, 407, 499));

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel1.setText(".............Type Management");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jLabel2.setText("Name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtName.setBackground(new java.awt.Color(204, 255, 255));
        txtName.setPreferredSize(new java.awt.Dimension(70, 30));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 360, -1));

        btnSave.setBackground(new java.awt.Color(51, 255, 0));
        btnSave.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save3.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(90, 30));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update1.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(90, 30));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 110, -1));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close2.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(90, 30));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 100, -1));

        btnReset.setBackground(new java.awt.Color(204, 204, 255));
        btnReset.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset1.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(90, 30));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 110, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aaaa.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
        
        
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("category_pk"), rs.getString("name")});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            e.printStackTrace();
        }
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        String name = txtName.getText();
       

        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "Please fill up the type data.");
          setVisible(true);
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into category(name) values(?)");
                ps.setString(1, name);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "New Type Added Successfully.");
                setVisible(false);
                new ManageCategory().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        
        
        
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageCategory().setVisible(true);
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
             String name = txtName.getText();
       

        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "Please fill up the type data properly.");
          setVisible(true);
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update category set name=? where category_pk=?");
                ps.setString(1, name);
                ps.setInt(2, categoryPk);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Type updated Successfully.");
                setVisible(false);
                new ManageCategory().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
                e.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoryMouseClicked
        // TODO add your handling code here:
        
         int index = tableCategory.getSelectedRow();
        TableModel model = tableCategory.getModel();

        String id = model.getValueAt(index, 0).toString();
        categoryPk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtName.setText(name);
        
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        
    }//GEN-LAST:event_tableCategoryMouseClicked

    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCategory;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

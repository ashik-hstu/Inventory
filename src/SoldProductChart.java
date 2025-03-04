/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashikulislam
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import dao.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SoldProductChart extends JFrame {

    public SoldProductChart() {
        initComponents();
        showTopSoldProductsChart();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void showTopSoldProductsChart() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        try (Connection con = ConnectionProvider.getCon(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(
                "SELECT p.name AS product_name, SUM(sp.sold_amount) AS sold_amount "
                + "FROM soldProduct sp "
                + "JOIN product p ON sp.product_fk = p.product_pk "
                + "GROUP BY sp.product_fk "
                + "ORDER BY sold_amount DESC "
                + "LIMIT 5"
        )) {

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                String productName = rs.getString("product_name");
                int soldAmount = rs.getInt("sold_amount");
                pieDataset.setValue(productName, soldAmount);
            }

            if (!hasData) {
                
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "No data available to display.");
                });
                return;
            }

            JFreeChart chart = ChartFactory.createPieChart(
                    "Top 5 Most Sold Products",
                    pieDataset,
                    true,
                    true,
                    true
            );

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(600, 600));

            // remove and add content to the chart..
            getContentPane().removeAll();
            getContentPane().add(chartPanel, BorderLayout.CENTER);
            revalidate();
            repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void initComponents() {
        setTitle("Most Sold Products");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new SoldProductChart().setVisible(true));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mwathsilu
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        carRecordCount();
        customerRecordCount();
        bookingRecordCount();
        displayRentedCar();
        displayRevenue();
    }
    Connection con;
    PreparedStatement pst;


    private void carRecordCount() {
        try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
            String query = "SELECT COUNT(vid) FROM vehicle";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        carlbl.setText(String.valueOf(count));
                    }
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., show an error message
            JOptionPane.showMessageDialog(this, "Error fetching record count: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void customerRecordCount() {
        try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
            String query = "SELECT COUNT(cid) FROM customer";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        custlbl.setText(String.valueOf(count));
                    }
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., show an error message
            JOptionPane.showMessageDialog(this, "Error fetching record count: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bookingRecordCount() {
        try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
            String query = "SELECT COUNT(rentid) FROM booking";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        blbl.setText(String.valueOf(count));
                    }
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., show an error message
            JOptionPane.showMessageDialog(this, "Error fetching record count: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayRentedCar() {
        try {
            try ( // Establish a database connection
                    java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
                String sql = "SELECT rentid, vid, cid, rentin, rentout, rfee FROM booking";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                DefaultTableModel tableModel = (DefaultTableModel) dashtbl.getModel();

                while (resultSet.next()) {
                    String rentid = resultSet.getString("rentid");
                    String carRegistration = resultSet.getString("vid");
                    String customerId = resultSet.getString("cid");
                    Date rentdate = resultSet.getDate("rentin");
                    Date returndate = resultSet.getDate("rentout");
                    int RENTFEE = resultSet.getInt("rfee");

                    // Add the fetched data as a new row in the table
                    tableModel.addRow(new Object[]{rentid, carRegistration, customerId, rentdate, returndate, RENTFEE});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    
    private void displayRevenue() {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
        String query = "SELECT SUM(total) FROM departure";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    double totalRevenue = resultSet.getDouble(1);
                    // Assuming rlbl is your JLabel for displaying revenue
                    rlbl.setText("Rs."+ String.format("%.2f", totalRevenue));
                }
            }
        }
    } catch (SQLException e) {
        // Handle the exception appropriately, e.g., show an error message
        JOptionPane.showMessageDialog(this, "Error fetching total revenue: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        blbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        carlbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        custlbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rlbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dashtbl = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        dashlbl = new javax.swing.JLabel();
        vlbl = new javax.swing.JLabel();
        clbl = new javax.swing.JLabel();
        inlbl = new javax.swing.JLabel();
        outlbl = new javax.swing.JLabel();
        loglbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Report = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(227, 244, 255));

        jPanel2.setBackground(new java.awt.Color(227, 244, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(749, 170));

        jPanel3.setBackground(new java.awt.Color(241, 208, 62));
        jPanel3.setPreferredSize(new java.awt.Dimension(229, 106));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL BOOKINGS");

        blbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        blbl.setForeground(new java.awt.Color(255, 255, 255));
        blbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blbl.setText("100");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-bookmark-94.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(142, 142, 250));
        jPanel5.setPreferredSize(new java.awt.Dimension(229, 106));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOTAL CARS");

        carlbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        carlbl.setForeground(new java.awt.Color(255, 255, 255));
        carlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carlbl.setText("100");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-car-94.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(carlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(186, 123, 247));
        jPanel6.setPreferredSize(new java.awt.Dimension(229, 106));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL CUSTOMERS");

        custlbl.setBackground(new java.awt.Color(186, 123, 247));
        custlbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        custlbl.setForeground(new java.awt.Color(255, 255, 255));
        custlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custlbl.setText("100");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-people-94.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(custlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(custlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(229, 106));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL REVENUE");

        rlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rlbl.setForeground(new java.awt.Color(255, 255, 255));
        rlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rlbl.setText("100");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-sales-performance-94.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(rlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        dashtbl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        dashtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Vehicle ID", "Customer ID", "Check-in date", "Check-out date", "Recievable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dashtbl.setGridColor(new java.awt.Color(255, 255, 255));
        dashtbl.setRowHeight(40);
        dashtbl.setSelectionBackground(new java.awt.Color(51, 0, 102));
        dashtbl.setSelectionForeground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setViewportView(dashtbl);

        jPanel7.setBackground(new java.awt.Color(51, 0, 102));
        jPanel7.setPreferredSize(new java.awt.Dimension(144, 318));

        dashlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dashlbl.setForeground(new java.awt.Color(255, 255, 255));
        dashlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashlbl.setText("DASHBOARD");
        dashlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashlblMouseClicked(evt);
            }
        });

        vlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vlbl.setForeground(new java.awt.Color(255, 255, 255));
        vlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vlbl.setText("VEHICLE");
        vlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vlblMouseClicked(evt);
            }
        });

        clbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clbl.setForeground(new java.awt.Color(255, 255, 255));
        clbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clbl.setText("CUSTOMER");
        clbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clblMouseClicked(evt);
            }
        });

        inlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inlbl.setForeground(new java.awt.Color(255, 255, 255));
        inlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inlbl.setText("CHECK-IN");
        inlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inlblMouseClicked(evt);
            }
        });

        outlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        outlbl.setForeground(new java.awt.Color(255, 255, 255));
        outlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outlbl.setText("CHECK-OUT");
        outlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outlblMouseClicked(evt);
            }
        });

        loglbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loglbl.setForeground(new java.awt.Color(255, 255, 255));
        loglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loglbl.setText("LOGOUT");
        loglbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loglblMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashicon.png"))); // NOI18N

        Report.setBackground(new java.awt.Color(0, 255, 51));
        Report.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Report.setText("REPORT");
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(loglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Report, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashlblMouseClicked
        Dashboard newform = new Dashboard();
        newform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newform.pack();
        newform.setVisible(true);
        dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_dashlblMouseClicked

    private void vlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vlblMouseClicked
        VehicleRegistration newform = new VehicleRegistration();
        newform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newform.pack();
        newform.setVisible(true);
        dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_vlblMouseClicked

    private void clblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clblMouseClicked
        CustomerRegistration newform = new CustomerRegistration();
        newform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newform.pack();
        newform.setVisible(true);
        dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_clblMouseClicked

    private void inlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inlblMouseClicked
        Booking newform = new Booking();
        newform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newform.pack();
        newform.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_inlblMouseClicked

    private void outlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outlblMouseClicked
        CheckOut newform = new CheckOut();
        newform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newform.pack();
        newform.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_outlblMouseClicked

    private void loglblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loglblMouseClicked
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to Logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // User clicked "Yes", so proceed with the logout
            dispose();
            LoginForm newform = new LoginForm();
            newform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newform.pack();
            newform.setVisible(true);
        } else {
            // User clicked "No," so take no action
        }         // TODO add your handling code here:
    }//GEN-LAST:event_loglblMouseClicked

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\mwath\\Downloads\\EAD project\\src\\View\\report1.jrxml");
            String query = "select * from departure";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null , con);
            
            JasperViewer.viewReport(jprint);
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ReportActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Report;
    private javax.swing.JLabel blbl;
    private javax.swing.JLabel carlbl;
    private javax.swing.JLabel clbl;
    private javax.swing.JLabel custlbl;
    private javax.swing.JLabel dashlbl;
    private javax.swing.JTable dashtbl;
    private javax.swing.JLabel inlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loglbl;
    private javax.swing.JLabel outlbl;
    private javax.swing.JLabel rlbl;
    private javax.swing.JLabel vlbl;
    // End of variables declaration//GEN-END:variables
}

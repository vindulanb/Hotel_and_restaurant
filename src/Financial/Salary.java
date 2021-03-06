package Financial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Financial.MyCodes.DbConnect;
import Financial.MyCodes.Methods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Vindula
 */
public class Salary extends javax.swing.JFrame {

    /**
     * Creates new form Salary
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null, rs2 = null;

    final String sqlCode = "SELECT p.`SID`, s.`name` as 'Name', p.`PaidAmount` as 'Paid Amount', date_format(p.`record_date`, '%Y-%m-%d') as 'Paid Date' "
            + "FROM `payroll` p, `staff` s "
            + "WHERE p.`SID` = s.`SID`";
    
    public Salary() {
        initComponents();
        con = DbConnect.connect();
        jTable1.setDefaultEditor(Object.class, null); // not editable tables
        tableLoad(sqlCode);

    }
    
    public void tableLoad(String sql)
    {
        try
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        sYear = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        showAll = new javax.swing.JButton();
        showSelected = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Paid Salaries");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Filter By Year");

        sYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        sYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sYearItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("&  Month");

        month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Months", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthItemStateChanged(evt);
            }
        });
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        showAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show view.png"))); // NOI18N
        showAll.setText("Show All");
        showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllActionPerformed(evt);
            }
        });

        showSelected.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/select.png"))); // NOI18N
        showSelected.setText("Show Selected");
        showSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sYear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(sYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {showAll, showSelected});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sYearItemStateChanged
        //System.out.println("f");
    }//GEN-LAST:event_sYearItemStateChanged

    private void monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthItemStateChanged

    }//GEN-LAST:event_monthItemStateChanged

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllActionPerformed

        
        tableLoad(sqlCode);
    }//GEN-LAST:event_showAllActionPerformed

    private void showSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSelectedActionPerformed

        String sqlSalSelected = "";
        String month1 = month.getSelectedItem().toString();
        String mon = "";
        String yer = sYear.getSelectedItem().toString();
        Methods dd = new Methods();
        int monthNo = dd.getMonthNo(month1);

        if(monthNo < 10)
            mon = "-0"+monthNo+"-";
        else
            mon = "-"+monthNo+"-";
        
        if("All Months".equals(month1))
        {
            System.out.println(yer+month1);
            sqlSalSelected = " SELECT p.`SID`, s.`name` as 'Name', p.`PaidAmount` as 'Paid Amount', date_format(p.`record_date`, '%Y-%m-%d') as 'Paid Date' "
                    + "FROM `payroll` p, `staff` s "
                    + "WHERE p.`SID` = s.`SID` AND `record_date` LIKE '"+yer+"%'";
        }
        else
        {
            System.out.println(yer+mon);
            sqlSalSelected = " SELECT p.`SID`, s.`name` as 'Name', p.`PaidAmount` as 'Paid Amount', date_format(p.`record_date`, '%Y-%m-%d') as 'Paid Date' "
                    + "FROM `payroll` p, `staff` s "
                    + "WHERE p.`SID` = s.`SID` AND `record_date` LIKE '"+yer+mon+"%'";

        }

        tableLoad(sqlSalSelected);

    }//GEN-LAST:event_showSelectedActionPerformed

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
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox month;
    private javax.swing.JComboBox sYear;
    private javax.swing.JButton showAll;
    private javax.swing.JButton showSelected;
    // End of variables declaration//GEN-END:variables
}




import java.beans.PropertyVetoException;
import java.util.Date;
import javax.swing.JOptionPane;


public class EventsCatering extends javax.swing.JInternalFrame {

    public static String customerid="";//nic
    public static String customername="";
    public static String event="";
    public static String deliveraddress="";
    public static int contactno;
    public static Date eventdate;
    public static String time;
    public static int paid=0;

    public EventsCatering() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
                UpdateOrders oh=new UpdateOrders();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(oh);
        oh.setLocation(0, 0);
        oh.setVisible(true);
        try 
        {
            oh.setMaximum(true);
        } 
        catch (PropertyVetoException e)
        {
            JOptionPane.showMessageDialog(null, "Maximaize error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        placeorder = new javax.swing.JButton();
        updateorders = new javax.swing.JButton();
        updatemenus = new javax.swing.JButton();
        updatecustomers = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        placeorder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        placeorder.setText("Place Order");
        placeorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeorderActionPerformed(evt);
            }
        });

        updateorders.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateorders.setText("Update Orders");
        updateorders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateordersActionPerformed(evt);
            }
        });

        updatemenus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatemenus.setText("Update Menus");
        updatemenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatemenusActionPerformed(evt);
            }
        });

        updatecustomers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatecustomers.setText("Update Customer Details");
        updatecustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecustomersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placeorder, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateorders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updatecustomers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(updatemenus, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(placeorder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateorders, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updatemenus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updatecustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void placeorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeorderActionPerformed

        CustomerRegistration cr=new CustomerRegistration();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(cr);
        cr.setLocation(0, 0);
        cr.setVisible(true);
        try
        {
            cr.setMaximum(true);
        }
        catch (PropertyVetoException e)
        {
            JOptionPane.showMessageDialog(null, "Maximaize error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_placeorderActionPerformed

    private void updateordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateordersActionPerformed

        UpdateOrders uo=new UpdateOrders();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(uo);
        uo.setLocation(0, 0);
        uo.setVisible(true);
        try
        {
            uo.setMaximum(true);
        }
        catch (PropertyVetoException e)
        {
            JOptionPane.showMessageDialog(null, "Maximaize error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updateordersActionPerformed

    private void updatemenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatemenusActionPerformed

        UpdateMenus umenu=new UpdateMenus();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(umenu);
        umenu.setLocation(0, 0);
        umenu.setVisible(true);
        try
        {
            umenu.setMaximum(true);
        }
        catch (PropertyVetoException e)
        {
            JOptionPane.showMessageDialog(null, "Maximaize error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updatemenusActionPerformed

    private void updatecustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatecustomersActionPerformed

        UpdateCustomers ucustomers=new UpdateCustomers();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(ucustomers);
        ucustomers.setLocation(0, 0);
        ucustomers.setVisible(true);
        try
        {
            ucustomers.setMaximum(true);
        }
        catch (PropertyVetoException e)
        {
            JOptionPane.showMessageDialog(null, "Maximaize error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updatecustomersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    public javax.swing.JButton placeorder;
    private javax.swing.JButton updatecustomers;
    private javax.swing.JButton updatemenus;
    private javax.swing.JButton updateorders;
    // End of variables declaration//GEN-END:variables
}

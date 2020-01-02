/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author udara
 */
public class UpdateCustomers extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    boolean registered=false;
    
    
    public UpdateCustomers() {
        initComponents();
        conn=Dbconnecter.con();
        update.setEnabled(false);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        String query="select * from customer";
        try{
                                
                pst =conn.prepareStatement(query);
                rs=pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             }catch(Exception e){}
    }

  boolean checkRegistration(){
    String nicno="";
    
        nicno=nic.getText();
        if(!nicno.equalsIgnoreCase("")){
            
            try{
                String querry="Select * from customer where nic='"+nicno+"'";
                pst=conn.prepareStatement(querry);
                rs=pst.executeQuery();
                
                if(rs.next()==true){
                    fname.setText(rs.getString(2));
                    lname.setText(rs.getString(3));
                    address.setText(rs.getString(8));
                    city.setText(rs.getString(7));
                    pno.setText(rs.getString(5));
                    email.setText(rs.getString(6));
                    
                    registered=true;
                    update.setEnabled(true);
                    
                    
                }else{
                   fname.setText("");
                   lname.setText("");
                   address.setText("");
                   city.setText("");
                   pno.setText("");
                   email.setText("");
                   registered=false;
                   update.setEnabled(false);
                }
            }catch(Exception e){
                
            }
           
        }
        return registered;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("NIC :");

        nic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nicMouseClicked(evt);
            }
        });
        nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nicKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("First name :");

        fname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnameFocusGained(evt);
            }
        });
        fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fnameMouseClicked(evt);
            }
        });
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fnameKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Last name :");

        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnameKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Address :");

        address.setColumns(20);
        address.setRows(5);
        address.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(address);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("City :");

        city.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cityKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Contact No :");

        pno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("E-Mail :");

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pno, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(update))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nic, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nicMouseClicked

        checkRegistration();
    }//GEN-LAST:event_nicMouseClicked

    private void nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!nic.getText().equalsIgnoreCase("")){
                if(checkRegistration()){
                }else{
                    JOptionPane.showMessageDialog(null, "You are Not Registerd");
                }

            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }

        }
    }//GEN-LAST:event_nicKeyPressed

    private void nicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyReleased

    }//GEN-LAST:event_nicKeyReleased

    private void fnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameFocusGained

    }//GEN-LAST:event_fnameFocusGained

    private void fnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseClicked
        checkRegistration();
    }//GEN-LAST:event_fnameMouseClicked

    private void fnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!fname.getText().equalsIgnoreCase("")){
                lname.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }
        }
    }//GEN-LAST:event_fnameKeyPressed

    private void lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!lname.getText().equalsIgnoreCase("")){
                address.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }

        }
    }//GEN-LAST:event_lnameKeyPressed

    private void addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!address.getText().equalsIgnoreCase("")){
                city.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }

        }
    }//GEN-LAST:event_addressKeyPressed

    private void cityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!city.getText().equalsIgnoreCase("")){
                pno.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }

        }
    }//GEN-LAST:event_cityKeyPressed

    private void pnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!pno.getText().equalsIgnoreCase("")){
                email.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }

        }
    }//GEN-LAST:event_pnoKeyPressed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!email.getText().equalsIgnoreCase("")){
            }else{
                JOptionPane.showMessageDialog(null, "You are Not Registerd");
            }

        }

    }//GEN-LAST:event_emailKeyPressed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       int row[]= jTable1.getSelectedRows();
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Update?");
        if(x==0){ 
        String ni=nic.getText();
        String fn=fname.getText();
        String ln=lname.getText();
        String add=address.getText();
        String ct=city.getText();
        String pn=pno.getText();
        String eml=email.getText();
        
        boolean valiedfname = Validation.isfname(fn);
            boolean valiedlname = Validation.islname(ln);
            boolean valiednic = Validation.isValidNIC(ni);
            boolean valiedphone = Validation.isValidPhoneNo(pn);
            boolean valiedemail = Validation.isValidEmail(eml);
            boolean valiedecity = Validation.iscity(ct);
            if (valiedfname == true) {
                if (valiedlname == true) {
                    if (valiednic == true) {
                        if (valiedphone == true) {
                            if (valiedemail == true) {
                                if (valiedecity == true) {
        
        String query="update customer set fname='"+fn+"',lname='"+ln+"',phone='"+pn+"',email='"+eml+"',city='"+ct+"',address='"+add+"' where nic='"+ni+"'";
         try{
                            pst=conn.prepareStatement(query);
                            pst.execute();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        
                JOptionPane.showMessageDialog(this, "Update successfully!");
                   nic.setText("");
                   fname.setText("");
                   lname.setText("");
                   address.setText("");
                   city.setText("");
                   pno.setText("");
                   email.setText("");
                   update.setEnabled(false);
                  
                              } else {
                                    JOptionPane.showMessageDialog(this, "Please enter valied city");
                                }

                            } else {
                                JOptionPane.showMessageDialog(this, "Please enter valied email adress");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Please enter 10 digit phone number");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please enter valied nic number");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valied lname");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter valied fname");
            }
                   
                  String query="select * from customer";
        try{
                                
                pst =conn.prepareStatement(query);
                rs=pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             }catch(Exception e){}
        
        
        }
    
    }//GEN-LAST:event_updateActionPerformed

    private void updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateKeyPressed
        
    }//GEN-LAST:event_updateKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        update.setEnabled(true);
        int row=jTable1.getSelectedRow();
        String nicno=(String) jTable1.getValueAt(row, 3);
        try{
                String querry="Select * from customer where nic='"+nicno+"'";
                pst=conn.prepareStatement(querry);
                rs=pst.executeQuery();
                
                if(rs.next()==true){
                    nic.setText(nicno);
                    fname.setText(rs.getString(2));
                    lname.setText(rs.getString(3));
                    address.setText(rs.getString(8));
                    city.setText(rs.getString(7));
                    pno.setText(rs.getString(5));
                    email.setText(rs.getString(6));
                    
                }else{
                   nic.setText("");
                   fname.setText("");
                   lname.setText("");
                   address.setText("");
                   city.setText("");
                   pno.setText("");
                   email.setText("");
                }
        }catch(Exception e){}
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField city;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField pno;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

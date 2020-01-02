/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

public class CustomerRegistration extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    boolean registered=false;
    EventsCatering ec=new EventsCatering();
    
    public CustomerRegistration() {
        initComponents();
        disableDateChoserMinDate();
        login.setEnabled(false);
        conn=Dbconnecter.con();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        String events=event.getSelectedItem().toString();
        if(events.equalsIgnoreCase("Outside Event")){
           jDateChooser1.setEnabled(true);
           jComboBox1.setEnabled(true);
    }else if(events.equalsIgnoreCase("Inside Event")){
          jDateChooser1.setEnabled(false);
          jComboBox1.setEnabled(false);
    }
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
                    notify.setText("Allways Registered !");
                    fname.setText(rs.getString(2));
                    lname.setText(rs.getString(3));
                    address.setText(rs.getString(8));
                    city.setText(rs.getString(7));
                    pno.setText(rs.getString(5));
                    email.setText(rs.getString(6));
                    register.setEnabled(false);
                    login.setEnabled(true);
                    
                    registered=true;
                    
                    
                }else{
                   notify.setText("Not Registered !");
                   fname.setText("");
                   lname.setText("");
                   address.setText("");
                   city.setText("");
                   pno.setText("");
                   email.setText("");
                   register.setEnabled(true);
                   login.setEnabled(false);
                   registered=false;
                }
            }catch(Exception e){
                
            }
           
        }
        return registered;
}

public void fieldclear(){
    nic.setText("");
    fname.setText("");
    lname.setText("");
    address.setText("");
    city.setText("");
    pno.setText("");
    email.setText("");
    notify.setText("");
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notify = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        event = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pno = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("NIC :");

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

        event.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        event.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inside Event", "Outside Event" }));
        event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventActionPerformed(evt);
            }
        });
        event.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eventKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Event Date :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Time :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Noon", "Night" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressKeyTyped(evt);
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

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("E-Mail :");

        login.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });

        register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        register.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jDateChooser1MousePressed(evt);
            }
        });
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pno, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(160, 160, 160)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(429, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(event, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(276, 276, 276))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(576, 576, 576)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7))
                            .addGap(17, 17, 17)
                            .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(notify, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(324, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(event, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addComponent(notify, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nicMouseClicked

        
    }//GEN-LAST:event_nicMouseClicked

    private void nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!nic.getText().equalsIgnoreCase("")){
                if(checkRegistration()){
                    event.requestFocus();
                }else{
                    fname.requestFocus();
                }

            }else{
                JOptionPane.showMessageDialog(null, "Please Enter Nic");
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
                JOptionPane.showMessageDialog(null, "Please Enter First Name");
            }
        }
    }//GEN-LAST:event_fnameKeyPressed

    private void lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!lname.getText().equalsIgnoreCase("")){
                address.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter Last Name");
            }

        }
    }//GEN-LAST:event_lnameKeyPressed

    private void eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventActionPerformed
        
        String events=event.getSelectedItem().toString();
        if(events.equalsIgnoreCase("Outside Event")){
           jDateChooser1.setEnabled(true);
           jComboBox1.setEnabled(true);
    }else if(events.equalsIgnoreCase("Inside Event")){
          jDateChooser1.setEnabled(false);
          jComboBox1.setEnabled(false);
    }
        
    }//GEN-LAST:event_eventActionPerformed

    private void eventKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eventKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){

            jDateChooser1.requestFocus();

        }
    }//GEN-LAST:event_eventKeyPressed

    private void addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!address.getText().equalsIgnoreCase("")){
                city.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter Address");
            }

        }
    }//GEN-LAST:event_addressKeyPressed

    private void cityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!city.getText().equalsIgnoreCase("")){
                pno.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter City");
            }

        }
    }//GEN-LAST:event_cityKeyPressed

    private void pnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!pno.getText().equalsIgnoreCase("")){
                email.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter Phone Number");
            }

        }
    }//GEN-LAST:event_pnoKeyPressed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!email.getText().equalsIgnoreCase("")){
                event.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter Email");
            }

        }

    }//GEN-LAST:event_emailKeyPressed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        //nic=customerid (using to get the cusid in funcion)//////////////////////////
        ec.eventdate=jDateChooser1.getDate();
        if(registered){
            EventsCatering ec=new EventsCatering();
            ec.customerid=nic.getText();
            ec.customername=fname.getText()+" "+lname.getText();
            ec.event=event.getSelectedItem().toString();
            ec.time=jComboBox1.getSelectedItem().toString();
            if(event.getSelectedItem().toString().equalsIgnoreCase("Inside Event")){
                EMain e1 = new EMain();
                e1.setVisible(true);
                fieldclear();

            }else if(event.getSelectedItem().toString().equalsIgnoreCase("Outside Event") ){
               
                if(ec.eventdate!=null){
                OutsideCatering oc=new OutsideCatering();
                oc.setVisible(true);
                fieldclear();
                }else{
                    JOptionPane.showMessageDialog(null, "Date Field is Empty!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            
           
        }else{
            JOptionPane.showMessageDialog(this, "You are not Registered !");
        }
    }//GEN-LAST:event_loginActionPerformed

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
        ec.eventdate=jDateChooser1.getDate();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            EventsCatering ec=new EventsCatering();
            ec.customerid=nic.getText();
            ec.customername=fname.getText()+" "+lname.getText();

            if(event.getSelectedItem().toString().equalsIgnoreCase("Inside Event")){
                EMain e1 = new EMain();
                e1.setVisible(true);
                fieldclear();

            }else if(event.getSelectedItem().toString().equalsIgnoreCase("Outside Event")){
                if(ec.eventdate!=null){
                OutsideCatering oc=new OutsideCatering();
                oc.setVisible(true);
                fieldclear();
                }else{
                    JOptionPane.showMessageDialog(null, "Date Field is Empty!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }

            this.dispose();
        }
    }//GEN-LAST:event_loginKeyPressed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        String ni=nic.getText();
        String fn=fname.getText();
        String ln=lname.getText();
        String add=address.getText();
        String ct=city.getText();
        String pn=pno.getText();
        String eml=email.getText();
        String type=event.getSelectedItem().toString();
        ec.eventdate=jDateChooser1.getDate();

        if(ni.isEmpty()|| fn.isEmpty() || ln.isEmpty() || pn.isEmpty() || eml.isEmpty() ||  ct.isEmpty() ||  add.isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "one or more filed empty ");
        }
        else
        {
            
            //emplement add customer
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

                                    String query = "INSERT INTO `customer`(`fname`, `lname`, `nic`, `phone`, `email`, `city`, `address`) VALUES ('" + fn + "','" + ln + "','" + ni + "','" + pn + "','" + eml + "','" + ct + "','" + add + "')";
                                    try {
                                        pst = conn.prepareStatement(query);
                                        pst.execute();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    JOptionPane.showMessageDialog(this, "Registration successfully!");

                                    EventsCatering ec = new EventsCatering();
                                    ec.customerid = nic.getText();
                                    ec.customername = fname.getText() + " " + lname.getText();
                                    ec.event = event.getSelectedItem().toString();
                                    ec.time = jComboBox1.getSelectedItem().toString();

                                    if (event.getSelectedItem().toString().equalsIgnoreCase("Inside Event")) {
                                         EMain e1 = new EMain();
                                            e1.setVisible(true);
                                            fieldclear();

                                    } else if (event.getSelectedItem().toString().equalsIgnoreCase("Outside Event")) {
                                        if (ec.eventdate != null) {
                                            OutsideCatering oc = new OutsideCatering();
                                            oc.setVisible(true);
                                            fieldclear();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Date Field is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }

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
            
           
        }
    }//GEN-LAST:event_registerActionPerformed

    private void registerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerKeyPressed
        ec.eventdate=jDateChooser1.getDate();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){

            String ni=nic.getText();
            String fn=fname.getText();
            String ln=lname.getText();
            String add=address.getText();
            String ct=city.getText();
            String pn=pno.getText();
            String eml=email.getText();

            if(ni.isEmpty()|| fn.isEmpty() || ln.isEmpty() || pn.isEmpty() || eml.isEmpty() ||  ct.isEmpty() ||  add.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "one or more filed empty ");
            }
            else
            {
                //emplement add customer
                boolean valiednic=Validation.isValidNIC(ni);
                boolean valiedphone=Validation.isValidPhoneNo(pn);
                boolean valiedemail=Validation.isValidEmail(eml);
                if(valiednic==true){
                    if(valiedphone==true){
                        if(valiedemail==true){

                            String query="INSERT INTO `customer`(`fname`, `lname`, `nic`, `phone`, `email`, `city`, `address`) VALUES ('"+fn+"','"+ln+"','"+ni+"','"+pn+"','"+eml+"','"+ct+"','"+add+"')";
                            try{
                                pst=conn.prepareStatement(query);
                                pst.execute();
                            }catch(Exception e){
                                System.out.println(e);
                            }
                            JOptionPane.showMessageDialog(this, "Registration successfully!");

                            EventsCatering ec=new EventsCatering();
                            ec.customerid=nic.getText();
                            ec.customername=fname.getText()+" "+lname.getText();
                            if(event.getSelectedItem().toString().equalsIgnoreCase("Inside Event")){
                                EMain e1 = new EMain();
                                            e1.setVisible(true);
                                            fieldclear();

                            }else if(event.getSelectedItem().toString().equalsIgnoreCase("Outside Event")){
                                if(ec.eventdate!=null){
                                    OutsideCatering oc=new OutsideCatering();
                                    oc.setVisible(true);
                                    fieldclear();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Date Field is Empty!","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                            }
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Please enter valied email adress");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Please enter 10 digit phone number");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Please enter valied nic number");
                }
            }

        }
    }//GEN-LAST:event_registerKeyPressed

    private void jXDatePicker1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXDatePicker1KeyPressed
       
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){

            jComboBox1.requestFocus();

        }
        
    }//GEN-LAST:event_jXDatePicker1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(registered){
                login.requestFocus();
            }else{
                register.requestFocus();
            }
            

        }
        
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void addressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyReleased
        // TODO add your handling code here:
        String add=address.getText();
        boolean length=Validation.isValidLengthadd(60, add);
        if(length==false){
              jLabel5.setText("length is to long");
        }
        else{
            jLabel5.setText("");
        }
    }//GEN-LAST:event_addressKeyReleased

    private void addressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyTyped
        // TODO add your handling code here:
        String add=address.getText();
        boolean length=Validation.isValidLengthadd(60, add);
        if(length==false){
              jLabel5.setText("length is to long");
        }
        else{
            jLabel5.setText("");
        }
    }//GEN-LAST:event_addressKeyTyped

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        
        ec.eventdate=jDateChooser1.getDate();
        System.out.print("cbjsgcjsgsjg");
        
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyPressed
        
        
        
    }//GEN-LAST:event_jDateChooser1KeyPressed

    public void disableDateChoserMinDate(){
        jDateChooser1.setMinSelectableDate(new Date());
    }
    
    private void jDateChooser1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MousePressed
                     
    }//GEN-LAST:event_jDateChooser1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField city;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> event;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JButton login;
    private javax.swing.JTextField nic;
    private javax.swing.JLabel notify;
    private javax.swing.JTextField pno;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.PropertyVetoException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;




public class UpdateMenus extends javax.swing.JInternalFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    double menuprice=0.00;
    int r=0;
    int row[];
    String foodid="";
    int id;
    String menuid="";
    int status=0;
    int selectrow;
    boolean used=false;
    
    public UpdateMenus() {
        initComponents();
        jButton5.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton6.setEnabled(false);
        jButton5.setEnabled(false);
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jLabel1.setText("");
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        conn=Dbconnecter.con();
        String querry="Select * from menu";
        table1Load(querry);
        querry="Select * from food";
        table2Load(querry);
    }

    public void querryexecute(String querry){
    try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 pst.executeQuery();     //get Result with execute query
                                 
                            }catch(Exception e){}
    
}

public void execute(String querry){
    
                            try{
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){
                                
                            }
}
    
public boolean table1Load(String querry){
        boolean result=false;
        int rowcount=0;
                            try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 rs=pst.executeQuery();     //get Result with execute query
                                 jTable1.setModel(DbUtils.resultSetToTableModel(rs));  //set records to table
                                 
                                  rowcount=jTable1.getRowCount();
                                  
                                  int row=jTable1.getSelectedRowCount();
                                  
            
                if(rowcount<1){     //check Table Have Data
                    result=false;
                }else{
                       
                     result=true;
                     
                } 
                                 
                            }catch(Exception e){}
                             return result;       
                          }
    
public boolean table2Load(String querry){
        boolean result=false;
        int rowcount=0;
                            try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 rs=pst.executeQuery();     //get Result with execute query
                                 jTable2.setModel(DbUtils.resultSetToTableModel(rs));  //set records to table
                                 
                                  rowcount=jTable2.getRowCount();
                                  
                                  int row=jTable2.getSelectedRowCount();
                                  
            
                if(rowcount<1){     //check Table Have Data
                    result=false;
                    jButton5.setEnabled(false);
                }else{
                       
                     result=true;
                } 
                                 
                            }catch(Exception e){}
                             return result;       
                          }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTable1MouseDragged(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("Delete Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("Remove Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setText("View Menu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setText("Add to menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton8.setText("Create New Menu");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Change Name");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        if(status==0){
            r=jTable1.getSelectedRow();
            menuid=(String) jTable1.getValueAt(r, 1);
            jButton4.setEnabled(true);
            jButton6.setEnabled(true);
            menuprice=(double) jTable1.getValueAt(r, 2);
            jLabel1.setText("Rs:"+menuprice+"0");
        }else if(status==1){
            jButton2.setEnabled(true);
            r=jTable1.getSelectedRow();
        }
        jButton1.setEnabled(true);
        jTextField1.setText(menuid);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton4.setEnabled(false);
        jButton2.setEnabled(false);
        jButton6.setEnabled(false);
        jButton5.setEnabled(false);
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jTextField1.setText("");
        jLabel1.setText("");
        status=0;
        String querry="Select * from menu";
        table1Load(querry);
        jTable1.setRowSelectionInterval(selectrow,selectrow );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if(status==1){
            jButton5.setEnabled(true);
           
            
        }else{
            jButton5.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(used){
            JOptionPane.showMessageDialog(null, "Cannot modify! because other part using this menu","Error",JOptionPane.ERROR_MESSAGE);
        }else{
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Remove?");
        if(x==0){
        int row[]=jTable1.getSelectedRows();
        for(int i=0;i<row.length;i++){
        id=parseInt(jTable1.getValueAt(row[i], 0).toString());
        String query="delete from menufood where foodid='"+id+"' and menuname='"+menuid+"'";
        execute(query);
        }
        }
        
        
        
        String query="select sum(f.Price) from food f,menufood mf where mf.foodid=f.foodID and mf.menuname='"+menuid+"'";
        try{
                    pst =conn.prepareStatement(query);
                    rs=pst.executeQuery(); 
                    if(rs.next()){
                        menuprice=rs.getDouble(1);
                    }
            }catch(Exception e){
            }
        jLabel1.setText("Rs:"+menuprice+"0");
        query="update menu set menuprice='"+menuprice+"' where menuname='"+menuid+"'";
        execute(query);
        query="select f.foodID,f.foodName from menufood mf,food f where f.foodID=mf.foodid and mf.menuname='"+menuid+"'";
        table1Load(query);
        JOptionPane.showMessageDialog(this, "Successfuly..!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String query="select menu from function where menu='"+menuid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   used=true;
                  JOptionPane.showMessageDialog(null, "Cannot delete! because other part using this menu","Error",JOptionPane.ERROR_MESSAGE);
               }else{
                   used=false;
                   int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Delete Menu?");
        if(x==0){
        
        query="delete from menu where menuname='"+menuid+"'";
        execute(query);
        query="delete from menufood where menuname='"+menuid+"'";
        execute(query);
        query="Select * from menu";
        table1Load(query);
        JOptionPane.showMessageDialog(this, "Successfuly..!");
        jLabel1.setText("");
        jButton4.setEnabled(false);
        jButton6.setEnabled(false);
        }
               }
        }catch(Exception e){}
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String query="select menu from function where menu='"+menuid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   used=true;
                  
               }else{
                   used=false;
               }
        }catch(Exception e){}
        
        status=1;
        selectrow=jTable1.getSelectedRow();
        query="select f.foodID,f.foodName from food f,menufood mf where f.foodID=mf.foodid and menuname='"+menuid+"'";
        table1Load(query);
        jButton4.setEnabled(false);
        jButton6.setEnabled(false);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(used){
            JOptionPane.showMessageDialog(null, "Cannot modify! because other part using this menu","Error",JOptionPane.ERROR_MESSAGE);
        }else{
        boolean inserterror=true;
         int row[]=jTable2.getSelectedRows();
            for(int i=0;i<row.length;i++){
                int fid=parseInt(jTable2.getValueAt(row[i], 2).toString());
                String fname=(String) jTable2.getValueAt(row[i], 1);
                
                String query="insert into menufood(menuname,foodid) values('"+menuid+"','"+fid+"')";
                try{
                                 pst =conn.prepareStatement(query);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){
                                inserterror=false;
                            }
            }
        
        
        String query="select sum(f.Price) from food f,menufood mf where mf.foodid=f.foodID and mf.menuname='"+menuid+"'";
        try{
                    pst =conn.prepareStatement(query);
                    rs=pst.executeQuery(); 
                    if(rs.next()){
                        menuprice=rs.getDouble(1);
                    }
            }catch(Exception e){
            }
        jLabel1.setText("Rs:"+menuprice+"0");
        
        query="update menu set menuprice='"+menuprice+"' where menuname='"+menuid+"'";
        execute(query);
        query="select f.foodID,f.foodname from food f,menufood mf where f.foodID=mf.foodid and menuname='"+menuid+"'";
        table1Load(query);
        
        if(inserterror)
        JOptionPane.showMessageDialog(this, "Successfuly..!");
        else
            JOptionPane.showMessageDialog(this, "Allready Added..!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseDragged
        
    }//GEN-LAST:event_jTable1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String query="select menu from function where menu='"+menuid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   used=true;
                  JOptionPane.showMessageDialog(null, "Cannot rename! because other part using this menu","Error",JOptionPane.ERROR_MESSAGE);
               }else{
        used=false;
        String name=jTextField1.getText();
        if(name.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Name Can't be Empty!");
        }else{
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Change Name?");
        if(x==0){
            
            query="update menu set menuname='"+name+"' where menuname='"+menuid+"'";
            execute(query);
            query="update menufood set menuname='"+name+"' where menuname='"+menuid+"'";
            execute(query);
            String querry="Select * from menu";
            table1Load(querry);
            JOptionPane.showMessageDialog(this, "Successfuly..!");
            status=0;
            jButton3.setEnabled(false);
        }
        }
               }
        }catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

            String search=jTextField2.getText();
            String querry="select * from food where foodName like '"+search+"%'";
            table2Load(querry);


    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        boolean result;
        String search=jTextField2.getText();
        String querry="select * from food where foodName like '%"+search+"%'";
        result=table2Load(querry);
        if(result){

        }else{
            JOptionPane.showMessageDialog(null, "No result Found!","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
       
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
         jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
       
        
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String menuname=jTextField1.getText();
        int c=jTable2.getSelectedRowCount();
        int row[]=jTable2.getSelectedRows();
        if(menuname.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(this,"Name Can't be Empty!");
            
        }else{
            if(c==0){
                 JOptionPane.showMessageDialog(this,"Please Add Some Food..!");
            }else{
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Create New Menu?");
        if(x==0){
        
        double price=0.00;
        
            
            
            for(int i=0;i<row.length;i++){
                int fid=parseInt(jTable2.getValueAt(row[i], 2).toString());
                String fname=(String) jTable2.getValueAt(row[i], 1);
                
                String query="insert into menufood(menuname,foodid) values('"+menuname+"','"+fid+"')";
                execute(query);
            }
            String query="select sum(f.Price) from food f,menufood mf where mf.foodid=f.foodID and mf.menuname='"+menuname+"'";
        try{
                    pst =conn.prepareStatement(query);
                    rs=pst.executeQuery(); 
                    if(rs.next()){
                        menuprice=rs.getDouble(1);
                    }
            }catch(Exception e){
                System.out.println(e);
            }
            query="insert into menu(menuname,menuprice) values('"+menuname+"','"+menuprice+"')";
            execute(query);
        
            JOptionPane.showMessageDialog(this, "successfully!");
            String querry="Select * from menu";
            table1Load(querry);
        }
        }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

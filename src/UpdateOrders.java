


import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class UpdateOrders extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    boolean error=false;
    int status=0;
    boolean paid=false;
    boolean updatable=true;
    double alltotal=0.00;
    double total=0.00;
    double uprice=0.00;
    
    public UpdateOrders() {
        initComponents();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        cancell.setEnabled(false);
        jButton5.setEnabled(false);
        jTextField3.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jTextField1.setText("");
        jLabel7.setText("");
        jLabel5.setText("");
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        conn=Dbconnecter.con();
        String query="select * from cateringorder";
        tableLoad(query);
        
    }
public void querryexecute(String querry){
    try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 pst.executeQuery();     //get Result with execute query
                                 
                            }catch(Exception e){
                                
                            }
    
}

public boolean execute(String querry){
    
                            try{
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 pst.execute();
                                 error=true;
                                 
                            }catch(Exception e){
                                 JOptionPane.showMessageDialog(null, e);
//                                error=false;
                            }
                            return error;
}
    
public boolean tableLoad(String querry){
        boolean result=false;
        int rowcount=0;
                            try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 rs=pst.executeQuery();     //get Result with execute query
                                 jTable1.setModel(DbUtils.resultSetToTableModel(rs));  //set records to table
                                 
                                  rowcount=jTable1.getRowCount();  
            
                if(rowcount<1){     //check Table Have Data
                    result=false;
                }else{
                
                     result=true;
                     
                } 
                                 
                            }catch(Exception e){}
                             return result;       
                          }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        cancell = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Customer Id", "Product Id", "Customer Name", "Quantity", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Order Id :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Product Id :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantity :");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-filled-25.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(63, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(63, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-bin-25.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-undo-25.png"))); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(63, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(63, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-25.png"))); // NOI18N
        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Update Orders");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Paid");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        cancell.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-filled-25.png"))); // NOI18N
        cancell.setText("Cancell Order");
        cancell.setPreferredSize(new java.awt.Dimension(67, 23));
        cancell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-send-file-25.png"))); // NOI18N
        jButton5.setText("Send Request");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setForeground(new java.awt.Color(204, 0, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cancell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(cancell, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
       cancell.setEnabled(false);
       int oid=parseInt(jTextField1.getText());
       
       String query="select productid as `Product Id`,productname as `Name`,quantity as `Quantity`,price as`Price` from orderproduct where orderid='"+oid+"'";
       error=tableLoad(query);
       
        if(error){
                status=1;
                jTextField1.setEnabled(false);
                
                cancell.setEnabled(false);
                jButton3.setEnabled(true);
                
                
        
        
        if(updatable){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jTextField3.setEnabled(true);
            if(paid){
                    jCheckBox1.setEnabled(false);
                }else{
                    jCheckBox1.setEnabled(true);
                }
        }else{
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jTextField3.setEnabled(false);
            jCheckBox1.setEnabled(false);
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       
       int length1=jTextField1.getText().length();
       char arr[]=new char[length1];
       boolean res=false;
       arr=jTextField1.getText().toCharArray();
       char c;
       for(int x=0;x<length1;x++){
           c=arr[x];
           
           if(Character.isDigit(c)){
               res=true;
           } else {
               res=false;
               break;
           }
       }
      if(!jTextField1.getText().equalsIgnoreCase("")){
       if(res){
           {
               String query="select * from cateringorder where orderid like '"+jTextField1.getText()+"%'";
               tableLoad(query);
               jLabel5.setText("");
               jButton4.setEnabled(true);
           }
           
       }else{
           
               jLabel5.setText("Insert only Digits.");
               jButton4.setEnabled(false);
       }
        
       }else{
           jLabel5.setText("");
           String query="select * from cateringorder";
           tableLoad(query);
           jButton4.setEnabled(true);
       }
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
        int id=0;
        jLabel5.setText("");
        jButton4.setEnabled(true);
        if(status==0){
            cancell.setEnabled(true);
            int row=jTable1.getSelectedRow();
            id= parseInt(jTable1.getValueAt(row, 0).toString());
            paid=(boolean) jTable1.getValueAt(row, 10);
            jTextField1.setText(""+id);
            
            jButton5.setEnabled(true);
            
        }else if(status==1 && updatable){
            int row=jTable1.getSelectedRow();
            id=parseInt(jTable1.getValueAt(row, 0).toString());
            String qty= jTable1.getValueAt(row, 2).toString();
            jTextField3.setText(qty);
            jLabel4.setText(id+"");
            jButton2.setEnabled(true);
            jButton1.setEnabled(true);
            
           
        }else if(status==1){
            cancell.setEnabled(false);
        }
        
        String query="select delivered from cateringorder where orderid='"+id+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   String s=rs.getString(1);
                   if(s.equalsIgnoreCase("notdelivered")){
                       jButton5.setEnabled(true);
                       cancell.setEnabled(true);
                       updatable=true;
                   }else if(s.equalsIgnoreCase("delivered")){
                       jButton5.setEnabled(false);
                       cancell.setEnabled(false);
                       updatable=false;
                   }else if(s.equalsIgnoreCase("pending..")){
                       jButton5.setEnabled(false);
                       cancell.setEnabled(true);
                       updatable=false;
                   }else if(s.equalsIgnoreCase("Cancelled")){
                       jButton5.setEnabled(false);
                       cancell.setEnabled(false);
                       updatable=false;
                   }
               }                 
            }catch(Exception e){}
        
        
        }catch(Exception e){}
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        String query="select * from cateringorder";
        tableLoad(query);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField1.setEnabled(true);
        jTable1.setEnabled(true);
        jLabel4.setText("");
        jLabel7.setText("");
        jTextField3.setText("");
        status=0;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row=jTable1.getSelectedRow();
        int oid=parseInt(jTextField1.getText());
        String pid="";
        pid=jLabel4.getText();
        
        if(!pid.equalsIgnoreCase("")){
        String query="select total from cateringorder where orderid='"+oid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   alltotal=rs.getDouble(1);
               }                 
            }catch(Exception e){}
        query="select quantity,price from orderproduct where orderid='"+oid+"' and productid='"+pid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   uprice=rs.getDouble(2);
                   int qty=rs.getInt(1);
                   total=uprice*qty;
               }                 
            }catch(Exception e){}

        
        
        
            int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Delete?");
            if(x==0){
                double newtotal=alltotal-total;
                
            query="delete from orderproduct where orderid='"+oid+"' and productid='"+pid+"'";
            execute(query);
            query="update cateringorder set total='"+newtotal+"' where orderid='"+oid+"'";
            execute(query);
            query="select productid as `Product Id`,productname as `Name`,quantity as `Quantity`,price as `Price` from orderproduct where orderid='"+oid+"'";
            tableLoad(query);
            JOptionPane.showMessageDialog(this, "Deleted!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "please Select product to update..");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int row=jTable1.getSelectedRow();
        int oid=parseInt(jTextField1.getText());
        String pid="";
        pid=jLabel4.getText();
        
        if(!pid.equalsIgnoreCase("")){
            String query="select total from cateringorder where orderid='"+oid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   alltotal=rs.getDouble(1);
               }                 
            }catch(Exception e){}
        query="select quantity,price from orderproduct where orderid='"+oid+"' and productid='"+pid+"'";
        try{
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               if(rs.next()){
                   uprice=rs.getDouble(2);
                   int qty=rs.getInt(1);
                   total=uprice*qty;
               }                 
            }catch(Exception e){}

        
        
        int qty=parseInt(jTextField3.getText());
            double temp=uprice*qty;
        
            int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Update?");
            if(x==0){
                double newtotal=alltotal-total+temp;
                
            query="Update orderproduct set quantity='"+qty+"' where orderid='"+oid+"' and productid='"+pid+"'";
            execute(query);
            query="Update cateringorder set total='"+newtotal+"' where orderid='"+oid+"'";
            execute(query);
            query="select productid as `Product Id`,productname as `Name`,quantity as `Quantity`,price as `Price` from orderproduct where orderid='"+oid+"'";
            tableLoad(query);
            JOptionPane.showMessageDialog(this, "Update Successfuly..!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "please Select product to update..");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellActionPerformed
       int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Cancell This Order?");
            if(x==0){
            int oid=parseInt(jTextField1.getText());
            String query="update cateringorder set delivered='Cancelled' where orderid='"+oid+"'";
            execute(query);
            JOptionPane.showMessageDialog(this, "Cancelled..!");
            
            }
            String query="select * from cateringorder";
            tableLoad(query);
            cancell.setEnabled(false);
            jButton5.setEnabled(false);
            jTextField1.setText("");
    }//GEN-LAST:event_cancellActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String orderinfo="";
        String stafposition="Cater";
        orderinfo=jTextArea1.getText();
        int row=jTable1.getSelectedRow();
        String workplace=jTable1.getValueAt(row, 5).toString();
        String time=jTable1.getValueAt(row, 7).toString();
        int id=parseInt(jTextField1.getText());
        if(orderinfo.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Request field is Empty..!","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            String query="insert into request(`OID`,`StaffPos`,`workplace`,`OrderInfo`,`Start`,`End`) values('"+id+"','"+stafposition+"','"+workplace+"','"+orderinfo+"','"+time+"','"+time+"')";
            execute(query);
            query="update cateringorder set delivered='pending..' where orderid='"+id+"'";
            execute(query);
            JOptionPane.showMessageDialog(this, "Request Sent..!");
            query="select * from cateringorder";
            tableLoad(query);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
 
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        
       
        int length1=jTextField3.getText().length();
       char arr[]=new char[length1];
       boolean res=false;
       arr=jTextField3.getText().toCharArray();
       char c;
       for(int x=0;x<length1;x++){
           c=arr[x];
           
           if(Character.isDigit(c)){
               res=true;
           } else {
               res=false;
               break;
           }
       }
       if(!jTextField3.getText().equalsIgnoreCase("") && !jTextField3.getText().equalsIgnoreCase("0") ){
       if(res ){
            
               
               jLabel7.setText("");
               jButton1.setEnabled(true);
               jButton2.setEnabled(true);
            
       }else{
           
               jLabel7.setText("Insert only positive numbers.");
               jButton1.setEnabled(false);
               jButton2.setEnabled(false);
       }
        
       }else{
           jLabel7.setText("");
           jButton1.setEnabled(false);
           jButton2.setEnabled(false);
       }
        
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        
        String s=jTextArea1.getText();
        if(s.length()>199){
            jLabel8.setText("Too..");
            jButton5.setEnabled(false);
        }else{
           jLabel8.setText("");
            jButton5.setEnabled(true); 
        }
        
        
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to update This Order?");
            if(x==0){
        int row=jTable1.getSelectedRow();
        int oid=parseInt(jTextField1.getText());
        if(jCheckBox1.isSelected()){
            String query="update cateringorder set paid='1' where orderid='"+oid+"'";
        execute(query);
        }else{
            String query="update cateringorder set paid='0' where orderid='"+oid+"'";
        }
            }
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancell;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

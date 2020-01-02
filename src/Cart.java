/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author udara
 */
public class Cart extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    double total=0.00;
    public Cart() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initComponents();
        conn=Dbconnecter.con();
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart order by id asc";
        tableLoad(querry);
        
        
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
                                 
                            }catch(Exception e){}
}
    
public boolean tableLoad(String querry){
        boolean result=false;
        jButton1.setEnabled(false);
        int rowcount=0;
        total=0.00;
        
                            try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 rs=pst.executeQuery();     //get Result with execute query
                                 jTable1.setModel(DbUtils.resultSetToTableModel(rs));  //set records to table
                                 
                                  rowcount=jTable1.getRowCount(); 
                                  for(int i=0;i<rowcount;i++){
                                      double val=(double) jTable1.getValueAt(i, 2);
                                      int qty=(int) jTable1.getValueAt(i, 3);
                                      total=total+(val*qty);
                                  }
                                  
                                  jLabel2.setText("Total : "+total+"0");
            
                if(rowcount<1){     //check Table Have Data
                    result=false;
                }else{
                
                     result=true;
                     jButton1.setEnabled(true);
                } 
                                 
                            }catch(Exception e){}
                             return result;       
                          }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTable1MouseDragged(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-bin-25.png"))); // NOI18N
        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-filled-25.png"))); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "name", "quantity", "price" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cart");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sort By:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(284, 284, 284)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String search=jTextField1.getText();
        boolean result;
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart where name like '%"+search+"%'";
        result=tableLoad(querry);
        if(result){
            
        }else{
            JOptionPane.showMessageDialog(null, "No result Found!","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int row[]= jTable1.getSelectedRows();
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Remove?");
        if(x==0){
            for(int i=0;i<row.length;i++){
        String id=jTable1.getValueAt(row[i], 0).toString();
        String query="Delete from cart where id='"+id+"'";
        execute(query);
        
            }
        
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart order by id asc";
        tableLoad(querry);
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String selection=jComboBox2.getSelectedItem().toString();
        String order=jComboBox3.getSelectedItem().toString();
        String search=jTextField1.getText();
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart where name like '"+search+"%' order by "+selection+" "+order+"";
        tableLoad(querry);
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        String selection=jComboBox2.getSelectedItem().toString();
        String order=jComboBox3.getSelectedItem().toString();
        String search=jTextField1.getText();
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart where name like '"+search+"%' order by "+selection+" "+order+"";
        tableLoad(querry);

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_DELETE ){
                int r=jTable1.getSelectedRow();
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Remove?");
        if(x==0){
        String id=jTable1.getValueAt(r, 0).toString();
        String query="Delete from cart where id='"+id+"'";
        execute(query);
        JOptionPane.showMessageDialog(this, "successfully!");
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart";
        tableLoad(querry);
        }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseDragged
       
       
        
    }//GEN-LAST:event_jTable1MouseDragged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        
        String selection=jComboBox2.getSelectedItem().toString();
        String order=jComboBox3.getSelectedItem().toString();
        String search=jTextField1.getText();
        String querry="Select id as `ID`, name as `Product Name`, price as `Price`, quantity as `Quantity` from cart where name like '"+search+"%' order by "+selection+" "+order+"";
        tableLoad(querry);
        
    }//GEN-LAST:event_jComboBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

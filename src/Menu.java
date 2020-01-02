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
public class Menu extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    double total=0.00;
    
    public Menu() {
        initComponents();
        conn=Dbconnecter.con();
        jButton4.setEnabled(false);
        
        String querry="Select f.foodID as `Food ID`, f.foodName as `Food Name`, f.category as `Type`, f.Price as `Unit Price` from tempmenu tm,food f where f.foodID=tm.foodid";
        tableLoad(querry);
        
        

                        
         
         
        
    }

public void execute(String querry){
    
                            try{
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){}
}
    
public boolean tableLoad(String querry){
        boolean result=false;
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        int rowcount=0;
                            try{
                                
                                 pst =conn.prepareStatement(querry);  //Prepare Query for Execute
                                 rs=pst.executeQuery();     //get Result with execute query
                                 jTable1.setModel(DbUtils.resultSetToTableModel(rs));  //set records to table
                                 
                                 rowcount=jTable1.getRowCount();
                                 
                                  
                if(rowcount<1){     //check Table Have Data
                    result=false;
                    jLabel1.setText("Total RS: 0.00");
                }else{
                
                     result=true;
                     jButton3.setEnabled(true);
                     
                     
                                  for(int i=0;i<rowcount;i++){
                                      double val=(double) jTable1.getValueAt(i, 3);
                                      total=total+val;
                                      
                                  }
                                  
                                  
                                    jLabel1.setText("Total RS: "+total+"0");
                } 
                                 
                            }catch(Exception e){}
                             return result;       
                          }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        quantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(250, 85));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-filled-25.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-bin-25.png"))); // NOI18N
        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-shopping-cart-filled-40.png"))); // NOI18N
        jButton4.setText("Add to Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Quantity");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(48, 48, 48)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double menuprice=0.00;
        
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Remove?");
         if(x==0){
        int r[]=jTable1.getSelectedRows();
        for(int i=0;i<r.length;i++){
             int id=parseInt(jTable1.getValueAt(r[i], 0).toString());
             String query="delete from tempmenu where foodid='"+id+"'";
             execute(query);
        }
        
        String query="select sum(price) from tempmenu";
        try{
                    pst =conn.prepareStatement(query);
                    rs=pst.executeQuery(); 
                    if(rs.next()){
                        menuprice=rs.getDouble(1);
                    }
            }catch(Exception e){
            }
         String querry="Select f.foodID as `Food ID`, f.foodName as `Food Name`, f.category as `Type`, f.Price as `Unit Price` from tempmenu tm,food f where f.foodID=tm.foodid";
         tableLoad(querry);
         jLabel1.setText(""+menuprice);
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int rowcount=jTable1.getRowCount();
        for(int i=0;i<rowcount;i++){
            String pid=jTable1.getValueAt(i, 0).toString();
            String name=jTable1.getValueAt(i, 1).toString();
            double uprice= (double) jTable1.getValueAt(i, 3);
            
            
            int qty=parseInt(quantity.getText());
            
            
           // String query="insert into menufood(menuname,foodid) values ('"+name+"','"+pid+"')";
           // execute(query);
            
           // String query="insert into menu(menuid,menuname,menuprice) values ('"+menuid+"','"+name+"','"+total+"')";
           // execute(query);
            
            String query="insert into cart(id,name,price,quantity) values ('"+pid+"','"+name+"','"+uprice+"','"+qty+"')";
            execute(query);
        }
        int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Added to cart");
        if(x==0){
            String query="TRUNCATE TABLE tempmenu";
            execute(query);
            this.dispose();
        }
            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        
        
                int length1=quantity.getText().length();
       char arr[]=new char[length1];
       boolean res=false;
       arr=quantity.getText().toCharArray();
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
       if(!quantity.getText().equalsIgnoreCase("") && !quantity.getText().equalsIgnoreCase("0") ){
       if(res ){
            
               
               jLabel3.setText("");
               jButton4.setEnabled(true);
            
       }else{
           
               jLabel3.setText("Insert only digits.");
               jButton4.setEnabled(false);
       }
        
       }else{
           jLabel3.setText("");
           jButton4.setEnabled(false);
       }
        
    }//GEN-LAST:event_quantityKeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       
        if(evt.getKeyCode()==KeyEvent.VK_DELETE ){
            int r=jTable1.getSelectedRow();
        String id=(String) jTable1.getValueAt(r, 0);
         int x=JOptionPane.showConfirmDialog(null, "Do You Realy Want to Remove?");
         if(x==0){
             String query="delete from tempmenu where foodid='"+id+"'";
             execute(query);
         }
         String querry="Select f.foodID as `Food ID`, f.foodName as `Food Name`, f.category as `Type`, f.Price as `Unit Price` from tempmenu tm,food f where f.foodID=tm.foodid";
        tableLoad(querry);
        }
        
        
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}

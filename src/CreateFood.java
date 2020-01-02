

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
public class CreateFood extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    boolean error=true;

    public CreateFood() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initComponents();
        conn=Dbconnecter.con();
        String querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food";
        tableLoad(querry);
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
                                
                                error=false;
                            }
                            return error;
}
    
public boolean tableLoad(String querry){
        boolean result=false;
        jButton1.setEnabled(false);
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
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product id", "Name", "type", "Unit price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
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

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-plus-filled-25.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Rice", "Meals", "Fast Food", "Juice", "Dessert", "Cake" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Foods");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-25.png"))); // NOI18N
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "foodid", "foodname", "category", "price" }));
        jComboBox6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sort By:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
            boolean result;
            String search=jTextField1.getText();
            String querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food where foodname like '%"+search+"%'";
            result=tableLoad(querry);
            if(result){
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No result Found!","Error",JOptionPane.ERROR_MESSAGE);
            }
       

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int row[]=jTable1.getSelectedRows();   //assign selected row number
        boolean result=false;
        for(int i=0;i<row.length;i++){
        int id=parseInt(jTable1.getValueAt(row[i], 0).toString());
        String name=jTable1.getValueAt(row[i], 1).toString();
        String type=jTable1.getValueAt(row[i], 2).toString();
        double uprice=Double.valueOf(jTable1.getValueAt(row[i], 3).toString());
        
        String querry="insert into tempmenu(foodid,price) values ('"+id+"','"+uprice+"')";
        result=execute(querry);
        }
        if(result){
            JOptionPane.showMessageDialog(this, "successfully..!");
        }else{
            JOptionPane.showMessageDialog(this, "Allready added..!");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        jTextField1.setText("");
        String selection=jComboBox2.getSelectedItem().toString();
        String orderselect=jComboBox6.getSelectedItem().toString();
        String order=jComboBox5.getSelectedItem().toString();
        String querry="";
        if(selection.equalsIgnoreCase("All")){
            querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food order by "+orderselect+" "+order+"";
        }else{
            querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food where category='"+selection+"' order by "+orderselect+" "+order+"";
        
        }
        tableLoad(querry);
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        String selection=jComboBox2.getSelectedItem().toString();
        String orderselect=jComboBox6.getSelectedItem().toString();
        String order=jComboBox5.getSelectedItem().toString();
        if(selection.equalsIgnoreCase("All")){
        
            String search=jTextField1.getText();
            String querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food where foodname like '"+search+"%' order by "+orderselect+" "+order+"";
            tableLoad(querry);
            
        }else{
            String search=jTextField1.getText();
            String querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food where foodname like '"+search+"%' and category='"+selection+"' order by "+orderselect+" "+order+"";
            tableLoad(querry);
        }
        
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        Menu menu=new Menu();
        menu.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_SHIFT){
            int row=jTable1.getSelectedRow();   //assign selected row number
        int id=parseInt(jTable1.getValueAt(row, 0).toString());
        String name=jTable1.getValueAt(row, 1).toString();
        String type=jTable1.getValueAt(row, 2).toString();
        double uprice=Double.valueOf(jTable1.getValueAt(row, 3).toString());
        
        String querry="insert into tempmenu(foodid,price) values ('"+id+"','"+uprice+"')";
        boolean result=execute(querry);
        
        if(result){
            JOptionPane.showMessageDialog(this, "successfully..!");
        }else{
            JOptionPane.showMessageDialog(this, "Allready added..!");
        }
        }
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed

        String selection=jComboBox2.getSelectedItem().toString();
        String orderselect=jComboBox6.getSelectedItem().toString();
        String order=jComboBox5.getSelectedItem().toString();
        String search=jTextField1.getText();
        String querry="";
        if(selection.equalsIgnoreCase("All")){
            querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food order by "+orderselect+" "+order+"";
        }else{
            querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food where foodtype='"+selection+"' and foodname like '"+search+"%' order by "+orderselect+" "+order+"";
        
        }
        tableLoad(querry);

    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        String selection=jComboBox2.getSelectedItem().toString();
        String orderselect=jComboBox6.getSelectedItem().toString();
        String order=jComboBox5.getSelectedItem().toString();
        String search=jTextField1.getText();
        String querry="";
        if(selection.equalsIgnoreCase("All")){
            querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food order by "+orderselect+" "+order+"";
        }else{
            querry="select foodID as `Food Id`, foodName as `Food Name`, category as `Type`, Price as `Unit Price` from food where foodtype='"+selection+"' and foodname like '"+search+"%' order by "+orderselect+" "+order+"";
        
        }
        tableLoad(querry);
    }//GEN-LAST:event_jComboBox6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

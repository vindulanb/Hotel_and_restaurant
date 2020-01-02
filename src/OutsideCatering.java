/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class OutsideCatering extends javax.swing.JFrame {

    int step=0;
   
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int lastorderid=0;
    public static String contactNo="";
    public static double cashmoney=0.00;
    
    
    public OutsideCatering() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        conn=Dbconnecter.con();
        step=1;
        submit.setEnabled(false);
        jButton9.setEnabled(false);
        CreateFood cf=new CreateFood();
        jDesktopPane1.add(cf);
        cf.setVisible(true);

        try {
            cf.setMaximum(true);
        } catch (PropertyVetoException ex) {

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

        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-truck-filled-40.png"))); // NOI18N
        jButton6.setText("Deliver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-shopping-cart-filled-40.png"))); // NOI18N
        jButton4.setText("View Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton2.setText("Renting Equipment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-restaurant-menu-filled-40.png"))); // NOI18N
        jButton5.setText("Food menus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-halal-food-filled-40.png"))); // NOI18N
        jButton1.setText("Foods");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("Back");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Next");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-print-filled-25.png"))); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancel-subscription-40.png"))); // NOI18N
        jButton10.setText("Cancell");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        step=5;
        submit.setEnabled(true);
        jButton8.setEnabled(false);
        jButton9.setEnabled(true);
        Deliver del=new Deliver();
        jDesktopPane1.add(del);
        del.setVisible(true);

        try {
            del.setMaximum(true);
        } catch (PropertyVetoException ex) {

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        step=4;
        submit.setEnabled(false);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        Cart cart=new Cart();
        jDesktopPane1.add(cart);
        cart.setVisible(true);

        try {
            cart.setMaximum(true);
        }catch (PropertyVetoException ex) {

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        step=3;
        submit.setEnabled(false);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        Renting ren=new Renting();
        jDesktopPane1.add(ren);
        ren.setVisible(true);

        try {
            ren.setMaximum(true);
        } catch (PropertyVetoException ex) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        step=2;
        submit.setEnabled(false);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        FoodMenu vf=new FoodMenu();
        jDesktopPane1.add(vf);
        vf.setVisible(true);

        try {
            vf.setMaximum(true);
        }catch (PropertyVetoException ex) {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        step=1;
        submit.setEnabled(false);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        CreateFood f=new CreateFood();
        jDesktopPane1.add(f);
        f.setVisible(true);

        try {
            f.setMaximum(true);
        } catch (PropertyVetoException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        step=step-1;

        if(step==1){
            CreateFood f=new CreateFood();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(false);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }else if(step==2){
            FoodMenu f=new FoodMenu();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }
        else if(step==3){
            Renting f=new Renting();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }
        else if(step==4){
            Cart f=new Cart();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }else if(step==5){
            Deliver f=new Deliver();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(true);
            jButton8.setEnabled(false);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }
        else if(step>5){
            step=5;
        }
        else if(step<1){
            step=1;

        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        step=step+1;
        if(step==1){
            CreateFood f=new CreateFood();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }else if(step==2){
            FoodMenu f=new FoodMenu();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }
        else if(step==3){
            Renting f=new Renting();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }
        else if(step==4){
            Cart f=new Cart();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(false);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }else if(step==5){
            Deliver f=new Deliver();
            jDesktopPane1.add(f);
            f.setVisible(true);
            submit.setEnabled(true);
            jButton8.setEnabled(false);
            jButton9.setEnabled(true);

            try {
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }

        }else if(step>5){
            step=5;
        }
        else if(step<1){
            step=1;
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

        Cart cart=new Cart();
        int rowcount=cart.jTable1.getRowCount();
        
        //// jhgfijdhfihfhfe
        if(step==4){
            submit.setVisible(true);

            step=5;
            Deliver del=new Deliver();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(del);
            del.setVisible(true);

            try {
                del.setMaximum(true);
            } catch (PropertyVetoException ex) {

            }
        }else if(step==5){

            EventsCatering ec=new EventsCatering();
            Deliver delivery=new Deliver();
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String createdate=sdf.format(date);
            SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yyyy");
            String eventdate=sdf2.format(ec.eventdate);
            String custid=ec.customerid;
            String event=ec.event;
            String location=ec.deliveraddress;
            String time=ec.time;
            double total=cart.total;
            double payment=0.00;
            if(ec.paid==1){
               payment =total;
            }else{
                payment=cashmoney;
                ec.paid=0;
            }
            
            boolean valiedphone=Validation.isValidPhoneNo(contactNo);
            int c1=parseInt(contactNo);
            
            if(valiedphone==true){
                
                if(cashmoney<=0.00){
                    JOptionPane.showMessageDialog(this, "Enter Some Cash..");
                }else{
                    String query="INSERT INTO `cateringorder`(`customernic`,`phone` ,`event`, `datecreated`, `deliveryaddress`, `eventdate`, `time`, `total`, `payment`, `paid`) VALUES ('"+custid+"','"+c1+"','"+event+"','"+createdate+"','"+location+"','"+eventdate+"','"+time+"','"+total+"','"+payment+"','"+ec.paid+"')";
                 try{
                                 pst =conn.prepareStatement(query);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){
                                System.out.println(e);
                            }
                            
            query="select orderid from cateringorder";
                         try{
                                
                                 pst =conn.prepareStatement(query);  //Prepare Query for Execute
                                 rs=pst.executeQuery();     //get Result with execute query
                                 
                                 int i=0;
                                 
                                 while(rs.next()){
                                     i++;
                                     lastorderid=rs.getInt(1);
                                 }
                                 System.out.println(lastorderid);
                                 
                            }catch(Exception e){}
            
            for(int i=0;i<rowcount;i++){
                String productid=cart.jTable1.getValueAt(i, 0).toString();
                String productname=cart.jTable1.getValueAt(i, 1).toString();
                double productprice=(double) cart.jTable1.getValueAt(i, 2);
                int quantity=(int) cart.jTable1.getValueAt(i, 3);
                
                
                 
                 query="INSERT INTO `orderproduct`(`orderid`,`productid`,`productname`, `quantity`,`price`) VALUES('"+lastorderid+"','"+productid+"','"+productname+"','"+quantity+"','"+productprice+"')";
                 try{
                                 pst =conn.prepareStatement(query);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){
                                System.out.println(e);
                            }
            }
            
            
            
            JOptionPane.showMessageDialog(this, "successfully!");
            getBill(lastorderid,total,cashmoney);
            
            query="TRUNCATE TABLE cart";
                 try{
                                 pst =conn.prepareStatement(query);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){
                                System.out.println(e);
                            }
            ec.customerid="";
            ec.customername="";
            ec.event="";
            ec.time="";
            contactNo="";
            ec.deliveraddress="";
            ec.setVisible(true);
            this.dispose();
                }
                
            
            

               }else{
                    JOptionPane.showMessageDialog(this, "Please enter 10 digit phone number");
                }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
       EventsCatering ec=new EventsCatering();
       String query="TRUNCATE TABLE cart";
                 try{
                                 pst =conn.prepareStatement(query);  //Prepare Query for Execute
                                 pst.execute();     //get Result with execute query
                                 
                            }catch(Exception e){
                                System.out.println(e);
                            }
            ec.customerid="";
            ec.customername="";
            ec.event="";
            ec.time="";
            contactNo="";
            ec.deliveraddress="";
            ec.setVisible(true);
            this.dispose();
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    public void getBill(int orderid,double total,double payment){
        String cname="";
        int qty=0;
        double change=0.0;
        String paid="";
        double price=0.0;
        if(total>payment){
            change=0.0;
            paid="Not paid";
        }else if(total==payment){
            change=0.0;
            paid="Fully paid";
        }else if(total<payment){
            change=payment-total;
            paid="Fully paid";
        }
        
        int i=1;
        EventsCatering ec=new EventsCatering();
        
        
        Document doc =new Document();
         try {
             PdfWriter.getInstance(doc, new FileOutputStream("orderbill.pdf"));
             doc.open();
             //Image image=Image.getInstance("image2993.png");
             //doc.add(image);
             
             doc.add(new Paragraph("INVOICE",FontFactory.getFont(FontFactory.TIMES_BOLD, 18,Font.BOLD,BaseColor.BLACK)));
             doc.add(new Paragraph(new Date().toString()));
             doc.add(new Paragraph("                                                                                                                      Koga Food"));
             doc.add(new Paragraph("                                                                                                                      Koswatta Rd,"));
             doc.add(new Paragraph("                                                                                                                      Phone : 077 535 5110"));
               
             doc.add(new Paragraph("______________________________________________________________________"));
             
             doc.add(new Paragraph("Customer name : "+ec.customername+""));
             doc.add(new Paragraph("Contact No : "+contactNo+""));
             doc.add(new Paragraph("Order ID : "+orderid+""));
             doc.add(new Paragraph("_____________________________________________________________________"));
             doc.add(new Paragraph(""));
             float[] columnWidths = {1.5f, 5f, 2f, 2f,2f};
             PdfPTable table = new PdfPTable(columnWidths);
             String query="SELECT productname,quantity,price FROM orderproduct WHERE orderid='"+orderid+"'";
             try{
                 
             PdfPCell cell1 = new PdfPCell(new Paragraph("S.No"));
             PdfPCell cell2 = new PdfPCell(new Paragraph("Item Name"));
             PdfPCell cell3 = new PdfPCell(new Paragraph("Qty"));
             PdfPCell cell4 = new PdfPCell(new Paragraph("rate"));
             PdfPCell cell5 = new PdfPCell(new Paragraph("Total"));
             
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
               pst =conn.prepareStatement(query);  //Prepare Query for Execute
               rs=pst.executeQuery();     //get Result with execute query
               while(rs.next()){
                   double gtotal=0.0;
                   cname=rs.getString(1);
                   qty=rs.getInt(2);
                   price=rs.getDouble(3);
                   gtotal=price*qty;
                   
                   
                   
             PdfPCell cell6 = new PdfPCell(new Paragraph(""+i,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,BaseColor.BLACK)));
             PdfPCell cell7 = new PdfPCell(new Paragraph(""+cname,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,BaseColor.BLACK)));
             PdfPCell cell8 = new PdfPCell(new Paragraph(""+qty,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,BaseColor.BLACK)));
             PdfPCell cell9 = new PdfPCell(new Paragraph(""+price,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,BaseColor.BLACK)));
             PdfPCell cell10 = new PdfPCell(new Paragraph(""+gtotal,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,BaseColor.BLACK)));
             
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);

                   i++;
               }
               doc.add(table);
               
             }catch(Exception e){}
             doc.add(new Paragraph("  "));
             doc.add(new Paragraph("_________________________________________________________________________"));
             doc.add(new Paragraph("  "));
             doc.add(new Paragraph("Total Items : "+(i-1)+"                                                                                     Grand Total    : "+total+"0"));
             doc.add(new Paragraph("                                                                                                            Tandered Amount: "+payment+"0"));
             doc.add(new Paragraph("                                                                                                            Change Due     : "+change+"0"));
             doc.add(new Paragraph("                                                                                                            Payment Status : "+paid+""));
             
             doc.close();
            
             JOptionPane.showMessageDialog(null,"Invoice susesfully print");
             try{
                 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler orderbill.pdf");
             }catch (Exception ex) {}
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ViewHistory.class.getName()).log(Level.SEVERE, null, ex);
         } catch (DocumentException ex) {
             Logger.getLogger(ViewHistory.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
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
            java.util.logging.Logger.getLogger(OutsideCatering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OutsideCatering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OutsideCatering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OutsideCatering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OutsideCatering().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

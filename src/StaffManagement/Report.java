package StaffManagement;

import javax.print.PrintService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author P.Shashitha
 */
public class Report extends javax.swing.JInternalFrame {
    Connection con = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        con = StaffManagement.DbConnector.con();
    }

    public void tableload(String sql,javax.swing.JTable a )
        {
            try 
            {
                //Implemnt request data...
                
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            
                a.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this, "Given details Incorrect! ", "Not Found!", JOptionPane.OK_OPTION);
            }
        }
    
    public void printTable(javax.swing.JTable a, String Title){
                    MessageFormat header = new MessageFormat("'"+Title+"'");
                    MessageFormat footer = new MessageFormat("page{0,number,integer}");
                    try{
                        a.print(JTable.PrintMode.NORMAL, header, footer);
                        
                    }catch(java.awt.print.PrinterException e){
                        System.err.format("Error Printing ! %s%n",e.getMessage());
                    }
    
    }
    
    public void GenReport(javax.swing.JTable a, String repTitle, String tabTitle, String FileName){
        try{
            
            
            
                        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                            jfc.setDialogTitle("Choose a directory to save your file: ");
                            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                            int returnValue = jfc.showSaveDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            if (jfc.getSelectedFile().isDirectory()) {
				System.out.println("You selected the directory: " + jfc.getSelectedFile());
                            }
                        }
            
            
                        int sr = a.getRowCount();
                        int cc = a.getColumnCount();
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(""+jfc.getSelectedFile()+"\\"+FileName+""));
                        document.open();
                        Image image = Image.getInstance("profile.jpg");//Image path
                        document.add(new Paragraph(""));//Image title
                        document.add(image);
                        
                        document.add(new Paragraph("'"+repTitle+"'",FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
                        document.add(new Paragraph(new Date().toString()));
                        document.add(new Paragraph("---------------------------------------------------------------------------------"));
                        PdfPTable table = new PdfPTable(cc);
                        
                        PdfPCell cell = new PdfPCell(new Paragraph("'"+tabTitle+"'"));
                        cell .setColspan(cc);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBackgroundColor(BaseColor.GREEN);
                        table.addCell(cell);
                        for(int i=0;i<a.getColumnCount();i++){
                            
                            PdfPCell cellCol = new PdfPCell(new Paragraph(a.getColumnName(i),FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
                            cellCol.setColspan(1);
                            cellCol.setHorizontalAlignment(Element.ALIGN_CENTER);
                            
                            table.addCell(cellCol);
   
                        }
                        if(sr>0)
                            for(int i=0;i<sr;i++){
                                
                                for(int j=0;j<cc;j++)   
                                    if(a.getValueAt(i, j)!=null)
                                        table.addCell(new Paragraph(a.getValueAt(i, j).toString(),FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL)));
                                    else
                                        table.addCell(" ");

                            }
       
                        document.add(table);
                        document.close();
                        JOptionPane.showMessageDialog(null,"Report Saved");
                    
                        try{
                            
                            

                            JFileChooser jfch = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                            returnValue = jfch.showOpenDialog(null);
                            // int returnValue = jfc.showSaveDialog(null);

                            if (returnValue == JFileChooser.APPROVE_OPTION) {
                                File selectedFile = jfch.getSelectedFile();
                                System.out.println(selectedFile.getAbsolutePath());
                            
                            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+
                                    ""+selectedFile.getAbsolutePath()+"");//"//"+FileName+
                            
                             FileInputStream in = new FileInputStream(""+selectedFile.getAbsolutePath()+"");
                             Doc doc = new SimpleDoc(in, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
                             PrintService service = PrintServiceLookup.lookupDefaultPrintService();

                                try {
                                        service.createPrintJob().print(doc, null);
                                } catch (PrintException e) {
                                        e.printStackTrace();
                                }
                            }
                        }catch(Exception ex){
                            
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    
        }catch(Exception ex){
                
                         JOptionPane.showMessageDialog(null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SID", "Name", "CurrDate", "attendance", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable5.setAutoCreateRowSorter(true);
        jTable5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TID", "TStatus", "Where", "Feedback"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton3.setText("Payroll");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("Attendance");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton4.setText("Staff");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Tasks (Jobs)");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("F:\\Temp 1\\New folder (12)\\hotelandresturent\\src\\StaffManagement\\icon\\show view.png")); // NOI18N
        jButton1.setText("Select and Generate Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(13, 13, 13)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter A File Name To Save Report(with extention .pdf):");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StaffManagement/icon/graph small2.png"))); // NOI18N
        jButton4.setText("Generate Graph");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StaffManagement/icon/print.png"))); // NOI18N
        jButton5.setText("Print  Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StaffManagement/icon/report small.png"))); // NOI18N
        jButton2.setText("Generate Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 102, 102));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setToolTipText("If Not Given Report will be saved as \"Report.pdf\" For Given Destination..");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Staff Reports...");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Main");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton3);
        group.add(jRadioButton4);
        group.add(jRadioButton2);    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql1="";
        if(jRadioButton1.isSelected()){
            sql1="SELECT * FROM attendance";
            tableload(sql1,jTable1);
        
        }
        else if(jRadioButton2.isSelected()){
            sql1="SELECT * FROM task";
            tableload(sql1,jTable5);
        
        
        }
         else if(jRadioButton3.isSelected()){
             sql1="SELECT * FROM payroll";
             tableload(sql1,jTable1);
         }
         else if(jRadioButton4.isSelected()){
             sql1="SELECT * FROM staff";
             tableload(sql1,jTable5);
         }
            JOptionPane.showMessageDialog(this, "Generated from one Table! ", "Report!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void genGraph(javax.swing.JTable a, String b, String c,int n){
                int sr,rc;
                String Name; 
                sr = a.getRowCount();
                
//                    JDBCCategoryDataset dataset;
                    DefaultPieDataset dataset = new DefaultPieDataset();
 
                            
                        for(int i=0;i<sr;i++)
                        {
                        
                            Name=a.getValueAt(i, n).toString();

                            int count=0;
                            for(int j=0;j<sr;j++){
                                if(a.getValueAt(j, n).toString().equals(Name))
                                    count++;
                                
                            }
                            
                            System.out.println(count);
                            dataset.setValue ("'"+Name+"'", new Integer (count));
                        }
                
                

 
                    JFreeChart chart = ChartFactory.createPieChart("'"+b+"'", dataset, true, true, true);
 
                    ChartFrame yourFrame = new ChartFrame ("'"+c+"'", chart);
 
                    yourFrame.setSize(600, 600);
 
                    yourFrame.setVisible(true);
            
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                //report Generated for selected option and from both tables, selected rows analysing
               
                String FileName;
                if(jTextField1.toString().isEmpty()){
                    FileName = "Report.pdf";
                    jLabel3.setText("No file name given from textfield then, file will be saved with 'Report.pdf' Name in given Dir...");
                }
                else
                    FileName = jTextField1.getText();

                
                if(jRadioButton1.isSelected()){
               
                    //Report.pdf
                    GenReport(jTable1,"Report Staff Attendance", "Staff Attendance Table", ""+FileName+"");
                    
 
                }
                else if(jRadioButton2.isSelected()){
                    

                    
                    //Report.pdf
                
                    GenReport(jTable5,"Report Staff Task", "Staff Task Table",""+FileName+"");
                    
            
                
                }
                else if(jRadioButton3.isSelected()){
                    

                    
                    //Report.pdf
                
                    GenReport(jTable1,"Report Staff Payroll!!", "Staff Payroll Table",""+FileName+"");
                    
            
                
                }
                else if(jRadioButton4.isSelected()){
                    

                    
                    //Report.pdf
                
                    GenReport(jTable5,"Report Staff Details", "Staff Details Table",""+FileName+"");
                    
            
                
                }

                
               
 
           
 
            
 
            
                
                
                
               
                
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
                if(jRadioButton1.isSelected()){
               
                   
                    
                    
                    
                    //Generate Graph
                    String sql1;
                    sql1="SELECT * FROM attendance WHERE Attended = 'Attended'";
                    tableload(sql1,jTable1);
                    genGraph(jTable1,"Staff Attendance", "Attendance",0);
                    
 
               
                }
                else if(jRadioButton2.isSelected()){
                    
                    //Generate Graph
                    genGraph(jTable5,"Staff Tasks", "Task",1);
                    

                
                }
                else if(jRadioButton3.isSelected()){
                
                    //Generate Graph
                    String sql1;
                    sql1="SELECT NIC,SUM(MonthlySalary) FROM payroll GROUP BY NIC";
                    tableload(sql1,jTable1);
                    genGraph(jTable1,"Staff Payroll", "Payroll",0,1);
                    
                    
                    try
        {
            String sqlSelect = "SELECT `NIC`, SUM(MonthlySalary) FROM payroll  GROUP BY NIC";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(Financial.MyCodes.DbConnect.connect(),sqlSelect);
            
            
            
            JFreeChart chart = ChartFactory.createLineChart("Total Earne Salary", "NIC", "Sum Payment", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer=null;
            CategoryPlot plot = null;
            renderer=new BarRenderer();
            ChartFrame frame=new ChartFrame("Loan Chart",chart);
            frame.setVisible(true);
            frame.setSize(1000,900);
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
                
                    
                    
                    
                }
                else if(jRadioButton4.isSelected()){
                
                    //Generate Graph
                    genGraph(jTable5,"Staff Position", "Staff",6);
                    genGraph(jTable5,"Staff Work Type", "Staff",7);
                }
                

    }//GEN-LAST:event_jButton4ActionPerformed
public void genGraph(javax.swing.JTable a, String b, String c,int n,int m){
                int sr,rc;
                String Name ; 
                Double Payment;
                sr = a.getRowCount();
                
   
                    DefaultPieDataset dataset = new DefaultPieDataset();
 
                            for(int i=0 ; i<sr; i++){
                                Name = a.getValueAt(i, n).toString();
                                Payment = Double.parseDouble(a.getValueAt(i, m).toString());
                                dataset.setValue ("'"+Name+"'", new Double(Payment));
                        

                            }
                    JFreeChart chart = ChartFactory.createPieChart("'"+b+"'", dataset, true, true, true);
 
                    ChartFrame yourFrame = new ChartFrame ("'"+c+"'", chart);
 
                    yourFrame.setSize(600, 600);
 
                    yourFrame.setVisible(true);
            
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
                if(jRadioButton1.isSelected()){
                                   
                    //BackupTable
                    printTable(jTable1,"Staff Attendance Table");

                }
                else if(jRadioButton2.isSelected()){
                    
                   
                    
                    //Backup table    
                    printTable(jTable5,"Staff Task Table");
                    
                
                }
                else if(jRadioButton3.isSelected()){
                
                    //BackupTable
                    printTable(jTable5,"Staff Payroll");
                
                }
                else if(jRadioButton4.isSelected()){
                
                    //BackupTable
                    printTable(jTable5,"Staff Details");
                    
                }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton3);
        group.add(jRadioButton4);
        group.add(jRadioButton2); 
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

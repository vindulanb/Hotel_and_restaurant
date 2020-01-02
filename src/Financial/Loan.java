package Financial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Financial.MyCodes.Methods;
import Financial.MyCodes.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Vindula
 */
public class Loan extends javax.swing.JFrame {

    /**
     * Creates new form Loan1
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null, rs2 = null;
    public String formatAmount = "0.0";
    public String interestS = "";
    public String lender1 = "";
    String sqlLoanId = "SELECT `loan_id` FROM `loan`";
    String sqlCount = "SELECT Count(`loan_id`) as count FROM `loan`";
    String sqlCode = "SELECT `loan_id` as 'Loan ID',"
            + " `loan_from` as 'Lender', `date_taken` as 'Date Taken',"
            + " `duedate` as 'Duedate',"
            + " `interest_rate` as 'Interest Rate', `total_to_pay` as 'Payable Amount',"
            + " case when `status` = 1 then 'Finished'"
            + " when `status` = 0 then 'Pending' "
            + "else 'UNDEFINED' end AS 'Loan Status' "
            + "FROM `loan`";
    
    public Loan() {
        initComponents();
        con = DbConnect.connect();
        
        //getNewRowNumber();
        tableLoad(sqlCode);
        Date date = new Date();
        dateTaken.setDate(date); // set current date 
        dueDate.setDate(date);

        
        jTable1.setDefaultEditor(Object.class, null); // not editable tables
        
        //int j = getNewRowNumber();
       // System.out.println(j);
        delete.setEnabled(false);
        update.setEnabled(false);
        pending.setEnabled(false);
        finishLoan.setEnabled(false);
        addLoan.setEnabled(false);
    }
    
    public void tableLoad(String sql)
    {
        try
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            
        }
    }
    
    public int getNewRowNumber()
    {
        //String sqlLoanId1 = "SELECT `loan_id` FROM `loan`";
       // String sqlCount1 = "SELECT Count(`loan_id`) as count FROM `loan`";
        int rowCount = 0;
        boolean found = false; // if found the element from resultSet
        int checkValue = 1; //sequence value
        
        try
        {
            pst = con.prepareStatement(sqlLoanId);
            rs = pst.executeQuery();
            pst = con.prepareStatement(sqlCount);
            rs2 = pst.executeQuery();
            
            if(rs2.next())
                rowCount = rs2.getInt(1); // get number of elements 
            
            int[] elements = new int[rowCount];
            rowCount = 0;
            
            while (rs.next()) 
            {
                elements[rowCount] = rs.getInt(1);
                rowCount++;
            }
            
            for(checkValue = 1; checkValue <= rowCount; checkValue++)
            {
                for(int j = 0; j < rowCount; j++)
                {
                    found = false;
                    if(checkValue == elements[j])
                    {
                        found = true;
                        break;
                    }
                }
                if(found == false)
                    return checkValue;
                
                found = false;
            }
        }catch(Exception e){
            return -1;
        }
        return checkValue;
    }
    
    public void ValidationPass()
    {
        if(((interestLabel.getText().isEmpty())) && 
                ((lenderError1.getText().isEmpty())) && 
                ((lenderErr.getText()).isEmpty()))
        {
           
            if(lender.getText().isEmpty() || 
                amount.getText().isEmpty() ||
                interest.getText().isEmpty())
            {
                addLoan.setEnabled(false);
            }
            else
            {
                int j = -1; 
                j = jTable1.getSelectedRow();
                if(j >= 0)
                {
                    addLoan.setEnabled(true);
                    update.setEnabled(true);
                }
                else
                {
                    addLoan.setEnabled(true);
                    update.setEnabled(false);
                }
            }
            if(!(lender.getText().isEmpty()) || 
                !(amount.getText().isEmpty()) ||
                !(interest.getText().isEmpty()))
            { //check if atleast one textfied has a contex
                int j = -1; 
                j = jTable1.getSelectedRow();
                if(j >= 0) //check valid row number- if selected
                {
                    update.setEnabled(true);
                }
                else //invalid row
                {
                    //System.out.println("incorrect count");
                    update.setEnabled(false);
                }
            }
            
            if(lender.getText().isEmpty() && 
                amount.getText().isEmpty() &&
                interest.getText().isEmpty())
            { //check if all textboxes empty
                update.setEnabled(false);
            }
            
        }
        else
        {
            addLoan.setEnabled(false);
            update.setEnabled(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addLoan = new javax.swing.JButton();
        finishLoan = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        interest = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lender = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sYear = new javax.swing.JComboBox();
        delete = new javax.swing.JButton();
        dueDate = new com.toedter.calendar.JDateChooser();
        dateTaken = new com.toedter.calendar.JDateChooser();
        pending = new javax.swing.JButton();
        lenderError = new javax.swing.JLabel();
        lenderError1 = new javax.swing.JLabel();
        interestLabel = new javax.swing.JLabel();
        lenderErr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loans");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Loan ID", "Lender", "Date Taken", "Due Date", "Amount Rs.", "Monthly Interest", "Total Payable Value Rs.", "Satus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addLoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addLoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add small.png"))); // NOI18N
        addLoan.setText("Add Loan");
        addLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLoanActionPerformed(evt);
            }
        });

        finishLoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        finishLoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/like 2.png"))); // NOI18N
        finishLoan.setText("Finish Loan");
        finishLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishLoanActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean3.png"))); // NOI18N
        clear.setText("Clear All");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Monthly Interest (%)");

        interest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                interestMouseClicked(evt);
            }
        });
        interest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                interestKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                interestKeyReleased(evt);
            }
        });

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Payable Amount Rs.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Due Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Date Taken ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lender");

        lender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenderActionPerformed(evt);
            }
        });
        lender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lenderKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Filter By Year Taken");

        sYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Years", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        sYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sYearItemStateChanged(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove 3.png"))); // NOI18N
        delete.setText("Remove");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        dueDate.setToolTipText("Start Date");
        dueDate.setDateFormatString("yyyy-MM-dd");
        dueDate.setMinSelectableDate(new java.util.Date(789939090000L));
        dueDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dueDatePropertyChange(evt);
            }
        });

        dateTaken.setToolTipText("Start Date");
        dateTaken.setDateFormatString("yyyy-MM-dd");
        dateTaken.setMinSelectableDate(new java.util.Date(789939090000L));
        dateTaken.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTakenPropertyChange(evt);
            }
        });

        pending.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/penduing.png"))); // NOI18N
        pending.setText("Set Pending");
        pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingActionPerformed(evt);
            }
        });

        lenderError.setForeground(new java.awt.Color(255, 0, 0));

        lenderError1.setForeground(new java.awt.Color(255, 0, 0));

        interestLabel.setForeground(new java.awt.Color(255, 0, 0));

        lenderErr.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(215, 215, 215)
                                    .addComponent(interestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(125, 125, 125))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3))
                                            .addGap(72, 72, 72)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(dueDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lender, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dateTaken, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(amount)
                                                .addComponent(interest))))
                                    .addGap(44, 44, 44)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lenderError, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lenderErr, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lenderError1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(123, 123, 123)))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pending, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(sYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lender, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lenderError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lenderErr, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateTaken, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lenderError1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(interestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(interest, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pending, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLoanActionPerformed

        
        Methods mm = new Methods();
        int loanId = getNewRowNumber();
        System.out.println("idddd : " + loanId);
        if((Integer.toString(loanId).length()) > 3)
        {
            int y = JOptionPane.showConfirmDialog(null, "Table is full. Please remove some records", "Table Full", JOptionPane.OK_CANCEL_OPTION);
        }
        if(loanId >= 0)
        {
            String lender1 = lender.getText();

            Date sDate1 = dateTaken.getDate();
            Format formatter = new SimpleDateFormat("yyyy/MM/dd");
            String s1 = formatter.format(sDate1);
            s1 = s1.replace('/', '-');

            Date sDate2 = dueDate.getDate();
            String s2 = formatter.format(sDate2);
            s2 = s2.replace('/', '-');

            
            if(sDate1.after(sDate2)) //date validation
            {
                int x = JOptionPane.showConfirmDialog(null, "Start date is grater than the end date!", "Check Dates", JOptionPane.OK_CANCEL_OPTION);
            } 
            else
            {
                String amount1 = amount.getText();
                String interest1 = interest.getText();


                Methods mth = new Methods();
                double myAmount = mth.withoutCommaToDouble(amount1);
                double myInterest = mth.getValidInterest(interest1);

                //double total1 = myAmount + (myAmount * myInterest);
                //String totalValue = Double.toString(total1);
//                String qt = "INSERT INTO `loan` ("
//                        + "`loan_id`,`loan_from`, `date_taken`, `duedate`, `interest_rate`, `total_to_pay`, `status`)"
//                        + " VALUES ('"+ loanId +"','"+ lender1 +"','"+ s1 +"','"+ s2 +"', '"+ myInterest +"', '"+ myAmount +"', '0')";
                
                String q = "INSERT INTO `loan`(`loan_id`, `loan_from`, `date_taken`, `duedate`, `interest_rate`, `total_to_pay`, `status`) "
                        + "VALUES ('"+ loanId +"','"+ lender1 +"','"+ s1 +"','"+ s2 +"', '"+ myInterest +"', '"+ myAmount +"', '0')";
                try
                {

                    pst = con.prepareStatement(q);
                    System.out.println("ok prepare");
                    pst.execute();
                    System.out.println("ok execute");
                    tableLoad(sqlCode);
                     System.out.println("ok");
                }catch(Exception e){
                    System.out.println("No");
                }
                clear.doClick();//After adding auto clik clear buttton

                delete.setEnabled(false);
                pending.setEnabled(false);
                finishLoan.setEnabled(false);
            }
            
        }
            
        
    }//GEN-LAST:event_addLoanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        interestLabel.setText("");
        lenderError1.setText("");
        lenderErr.setText("");
        int r = jTable1.getSelectedRow();
        //System.out.println("This is rrr " + r);
        lender1 = jTable1.getValueAt(r, 1).toString();
        String sDate = jTable1.getValueAt(r, 2).toString();
        String eDate = jTable1.getValueAt(r, 3).toString();
        double amount1 = (double) jTable1.getValueAt(r, 5);
        double interest1 = (double) jTable1.getValueAt(r, 4);
        
        //System.out.println(interest1);
        lender.setText(lender1);
       
        sDate = sDate.replace('-', '/');
        eDate = eDate.replace('-', '/');
        Date date1 = null;
        Date date2 = null;
        try {  
             date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
             date2 = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
        } catch (ParseException ex) {
            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
        }
        dateTaken.setDate(date1);
        dueDate.setDate(date2);
        
        DecimalFormat dc = new DecimalFormat("###,###,###.00");
        formatAmount = dc.format(amount1);
        amount.setText(formatAmount);
        
        //interest1  = (double) Math.round(interest1 * 1000.0) / 1000.0;
        System.out.println(interest1);
        interest1 = interest1 * 100.000;
        interest1  = (double) Math.round(interest1 * 1000.0) / 1000.0;
        interestS = Double.toString(interest1);
        System.out.println(interestS);
        interest.setText(interestS);
        
        //double total1 = amount1 + ((amount1 * interest1)/100.0);
        amount1  = (double) Math.round(amount1 * 100.0) / 100.0;
        String formatTotal = dc.format(amount1);
        //System.out.println(formatTotal + "  this is double>" + total1);
        //total.setText(formatTotal);    

        addLoan.setEnabled(true);
        delete.setEnabled(true);
        update.setEnabled(true);
        pending.setEnabled(true);
        finishLoan.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void lenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lenderActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        int y = JOptionPane.showConfirmDialog(null, "Do you want to remove selected row?", "Confirm", JOptionPane.YES_NO_OPTION);

        if(y == JOptionPane.YES_OPTION)
        {
            int r = -1; 
            int loanId = -1;
            String status = "";
            try // Check if it is selected or not
            {
                r = jTable1.getSelectedRow();//get selected row
                loanId = (int)jTable1.getValueAt(r, 0);//get selected loan id
                status = jTable1.getValueAt(r, 6).toString();
                System.out.println("Status : " + status);
            }catch(Exception e)
            {
                System.out.println("not selected");
            }

            String deletQuery = "DELETE FROM `loan` WHERE `loan_id` = '"+ loanId +"'";
            if("Pending".equals(status))
            {
                JOptionPane.showMessageDialog(null, "This record still pending", "Pending", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                try
                {
                    pst = con.prepareStatement(deletQuery);
                    pst.execute();
                    tableLoad(sqlCode);
                }catch(Exception e){

                }
                clear.doClick();//After adding auto clik clear buttton
            }
         
            delete.setEnabled(false);
            pending.setEnabled(false);
            finishLoan.setEnabled(false);
        }
                        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void finishLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishLoanActionPerformed
        int r = -1; 
        int loanId = -1;
        try // Check if it is selected or not
        {
            r = jTable1.getSelectedRow();//get selected row
            loanId = (int)jTable1.getValueAt(r, 0);//get selected loan id
        }catch(Exception e)
        {
            System.out.println("not selected");
        }
        
        String changeStatus = "UPDATE `loan` SET `status`='1' WHERE `loan_id` = '"+ loanId +"'";
        try
        {
            pst = con.prepareStatement(changeStatus);
            pst.execute();
            tableLoad(sqlCode);
        }catch(Exception e){
            
        }
        delete.setEnabled(false);
        update.setEnabled(false);
        pending.setEnabled(false);
        finishLoan.setEnabled(false);
    }//GEN-LAST:event_finishLoanActionPerformed

    private void pendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingActionPerformed
        int r = -1; 
        int loanId = -1;
        try // Check if it is selected or not
        {
            r = jTable1.getSelectedRow();//get selected row
            loanId = (int)jTable1.getValueAt(r, 0);//get selected loan id
        }catch(Exception e)
        {
            System.out.println("not selected");
        }
        
        String changeStatus = "UPDATE `loan` SET `status`='0' WHERE `loan_id` = '"+ loanId +"'";
        try
        {
            pst = con.prepareStatement(changeStatus);
            pst.execute();
            tableLoad(sqlCode);
        }catch(Exception e){
            
        }
        delete.setEnabled(false);
        update.setEnabled(false);
        pending.setEnabled(false);
        finishLoan.setEnabled(false);
    }//GEN-LAST:event_pendingActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        int y = JOptionPane.showConfirmDialog(null, "Do you want to update selected row?", "Confirm", JOptionPane.YES_NO_OPTION);

        Date sDate1 = dateTaken.getDate();
        Format formatter = new SimpleDateFormat("yyyy/MM/dd");
        String s1 = formatter.format(sDate1);
        s1 = s1.replace('/', '-'); 

        Date sDate2 = dueDate.getDate();
        String s2 = formatter.format(sDate2);
        s2 = s2.replace('/', '-');

        int x = 1;
            //Date date = new Date();
        if(sDate1.after(sDate2)) //date validation
        {
            x = JOptionPane.showConfirmDialog(null, "Start date is grater than the end date!", "Check Dates", JOptionPane.OK_CANCEL_OPTION);
        }       
        else if(y == JOptionPane.YES_OPTION)
        {
            String lenderNew;
            String amountNew;
            String interestNew;
            int r = -1; 
            int loanId = -1;
            try // Check if it is selected or not
            {
                r = jTable1.getSelectedRow();
                loanId = (int)jTable1.getValueAt(r, 0);//get selected loan id
            }catch(Exception e)
            {
                System.out.println("not selected");
            }

            if("".equals(lender.getText()))
            {
                lenderNew = lender1;
            }
            else
            {
                lenderNew = lender.getText();
            }

            
            if("".equals(amount.getText()))
            {
                amountNew = formatAmount;
            }
            else
            {
                amountNew = amount.getText();
            }

            if("".equals(interest.getText()))
            {
                interestNew = interestS;
            }
            else
            {
                interestNew = interest.getText();
            }
            //String interest1 = interest.getText();

            Methods mth = new Methods();
            double myAmount = mth.withoutCommaToDouble(amountNew);
            double myInterest = mth.getValidInterest(interestNew);

            //double total1 = myAmount + (myAmount * myInterest);
            String q = "UPDATE `loan` SET `"
                    + "loan_from`= '"+ lenderNew +"',`date_taken`='"+ s1 +"',"
                    + "`duedate`='"+ s2 +"',"
                    + "`interest_rate`='"+ myInterest +"',`total_to_pay`= '"+ myAmount +"'"
                    + " WHERE `loan_id` = '"+ loanId +"'";

            try
            {
                pst = con.prepareStatement(q);
                pst.execute();
                tableLoad(sqlCode);
            }catch(Exception e){

            }
            clear.doClick();
            
            delete.setEnabled(false);
            pending.setEnabled(false);
            finishLoan.setEnabled(false);
        }
       
    }//GEN-LAST:event_updateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        
        lender.setText("");
        lenderErr.setText("");
        interestLabel.setText("");
        Date date1 = new Date();
        dateTaken.setDate(date1);
        dueDate.setDate(date1);
        amount.setText("");
        interest.setText("");
        //total.setText("000.00");   
        
        addLoan.setEnabled(false);
        update.setEnabled(false);
    }//GEN-LAST:event_clearActionPerformed

    private void sYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sYearItemStateChanged
        
        String year = sYear.getSelectedItem().toString();
        
        if("All Years".equals(year))
        {
            try
            {
                tableLoad(sqlCode);//load full table
            }catch(Exception e){

            }
        }
        else
        {
            String filterYear = "SELECT `loan_id` as 'Loan ID',"
            + " `loan_from` as 'Lender', `date_taken` as 'Date Taken',"
            + " `duedate` as 'Duedate',"
            + " `interest_rate` as 'Interest Rate', `total_to_pay` as 'Payable Amount',"
            + " case when `status` = 1 then 'Finished'"
            + " when `status` = 0 then 'Pending' "
            + "else 'UNDEFINED' end AS 'Loan Status' "
            + "FROM `loan`"
            + "WHERE `date_taken` LIKE '"+year+"%'";
        
            try
            {
                tableLoad(filterYear);
            }catch(Exception e){
                   System.out.println("error");
            }
        }
        clear.doClick();
        pending.setEnabled(false);
        finishLoan.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_sYearItemStateChanged

    private void amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyReleased
        
        String amount1 = amount.getText();
    
        Methods mth = new Methods();
        double myAmount = mth.withoutCommaToDouble(amount1);
        if(myAmount == -1.321)
            lenderError1.setText("Error");
        
        else if(!(mth.isValidIntPart(8,2,amount1)))
            lenderError1.setText("Too");
        
        else//the corret position
        {
            lenderError1.setText("");
            //update.setEnabled(true);
        }
        
        if("".equals(amount1)) //empty position
        {
            lenderError1.setText("");     
            //update.setEnabled(true);
        }
      
        ValidationPass();
        
    }//GEN-LAST:event_amountKeyReleased

    private void interestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_interestKeyReleased
        
        Methods mth = new Methods();
       
        String interestRate = interest.getText();
        /*if(mth.isValidIntPart(1,1,interestRate))
        {
            
        }
        else
        {
            lenderError1.setText("Too");  
        }*/
        //Methods mth = new Methods();
        double myInterestRate = mth.getValidInterest(interestRate);
        if(myInterestRate == -1.321)
        {
            interestLabel.setText("Error");  
           
        }
        else if(!(mth.isValidIntPart(2,1,interestRate)))
            interestLabel.setText("Too");
        else
        {
            interestLabel.setText("");
            //update.setEnabled(true);
        }
        
        if("".equals(interestRate))
        {
            interestLabel.setText("");
        }
        ValidationPass();
    }//GEN-LAST:event_interestKeyReleased

    private void lenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lenderKeyReleased
        
        String myLender = lender.getText();
        if(myLender.length() > 30)
        {
            lenderErr.setText("Too");
        }
        else
            lenderErr.setText("");
        ValidationPass();
    }//GEN-LAST:event_lenderKeyReleased

    private void dueDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dueDatePropertyChange
        
        ((JTextField)dueDate.getDateEditor().getUiComponent()).setEditable(false); //set editable false in  date chooser via typing
    }//GEN-LAST:event_dueDatePropertyChange

    private void dateTakenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTakenPropertyChange
       ((JTextField)dateTaken.getDateEditor().getUiComponent()).setEditable(false); //set editable false in  date chooser via typing
        ((JTextField)dateTaken.getDateEditor().getUiComponent()).setEditable(false); //set editable false in  date chooser via typing
    }//GEN-LAST:event_dateTakenPropertyChange

    private void interestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_interestMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_interestMouseClicked

    private void interestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_interestKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_interestKeyPressed

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
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLoan;
    private javax.swing.JTextField amount;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser dateTaken;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser dueDate;
    private javax.swing.JButton finishLoan;
    private javax.swing.JTextField interest;
    private javax.swing.JLabel interestLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lender;
    private javax.swing.JLabel lenderErr;
    private javax.swing.JLabel lenderError;
    private javax.swing.JLabel lenderError1;
    private javax.swing.JButton pending;
    private javax.swing.JComboBox sYear;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    /*private String formatStringDate(String sDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

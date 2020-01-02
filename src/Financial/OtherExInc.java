package Financial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Financial.FinancialUnit;
import Financial.MyCodes.DbConnect;
import Financial.MyCodes.Methods;
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
public class OtherExInc extends javax.swing.JFrame {

    /**
     * Creates new form oExForm
     */
    public static int frameType = -1;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    public String description1 = "0.0";
    public String formatAmount = "";
    
    String sqlRecId = "SELECT `record_id` FROM `other_expences`";
    String sqlCount = "SELECT Count(`record_id`) as count FROM `other_expences`";
    
    String sqlRecIdM = "SELECT `record_id` FROM `bill_cost`";
    String sqlCountM = "SELECT Count(`record_id`) as count FROM `bill_cost`";
    
    final String sqlExpen = "SELECT `record_id` as 'Record ID', `discription` as 'Description',"
            + " `expend_date` as 'Date Expended', `total_expence` as 'Total Expence' "
            + " FROM `other_expences`";
    
    final String sqlInc = "SELECT `record_id` as 'Record ID', `discription` as 'Discription',"
            + " `date` as 'Date Receive', `amount` as 'Amount' FROM `other_income`";
    
    final String sqlMonthlyEx = "SELECT `record_id` as 'Record ID',"
                    + " `expense_type` as 'Description',"
                    + " `date_paid` as 'Date Paid',"
                    + " `cost` as 'Total Paid'"
                    + " FROM `bill_cost`";
    
    final String sqlMaEx = "SELECT `Maintancetype` as 'Discription', `Cost`, `Startdate` as 'Start Date'"
                    + " FROM `longtime`";
    
    final String sqlDilEx = "SELECT `Order_ID` as 'Order ID', `Vehicle_ID` as 'Vehicle No.',`date` as 'Date', `charges` as 'Total'"
                    + " FROM `delivery_chages`";
    
    final String sqlExIn = "SELECT `itemno` as 'Item No', `itemname` as 'Item Name', `quantity` as 'Quantity',"
            + " `unitprice` as 'Unit Price', (`unitprice` * `quantity`) as 'Total'"
            + " FROM `ingredients`";
    
    final String sqlExEq = "SELECT `itemno` as 'No', `itemname` as 'Name',"
            + " `quantity` as 'Qty', `unitprice` as 'Unit Price', (`unitprice` * `quantity`) as 'Total Cost' "
            + "FROM `equipments`";
    
    public OtherExInc() {
        
        initComponents();
        
        //searchBox.setText("Search in description...");
        delete.setEnabled(false);
        update.setEnabled(false);
        addLoan.setEnabled(false);
        
        frameType = FinancialUnit.passingValue;
        con = DbConnect.connect();
        lenderErr.setText("");
        //System.out.println("" + frameType);
        jTable1.setDefaultEditor(Object.class, null); // not editable tables
        if(frameType == 2)
        {
            setTitle("Other Expenses");
            tableLoad(sqlExpen);
            dateTitle.setText("Date Expended");
            title.setText("Select Table");

        }
        if(frameType == 1)
        {
            setTitle("Other Incomes");
            sqlRecId = "SELECT `record_id` FROM `other_income`";
            sqlCount = "SELECT Count(`record_id`) as count FROM `other_income`";
            tableLoad(sqlInc);
            dateTitle.setText("Date Received");
            title.setText("Other Earnings");
            tableSelect.setVisible(false);

        }

        Date date = new Date();
        exDate.setDate(date);
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

    public void ValidationPass()
    {
        if(((lenderErr1.getText().isEmpty())) && 
                ((lenderErr.getText()).isEmpty())) //checking labels empty
        {
            //update.setEnabled(true);
            if((description.getText().isEmpty()) || 
                (expense.getText().isEmpty()))
            {
                addLoan.setEnabled(false);
            }
            
            else //correct position
            {
                int j = -1; 
                j = jTable1.getSelectedRow();
                if(j >= 0) //correct row
                {
                    addLoan.setEnabled(true);
                    update.setEnabled(true);
                }
                else //invalid row
                {
                    System.out.println("incorrect count");
                    addLoan.setEnabled(true);
                    update.setEnabled(false);
                }
            }
            
            if(!(description.getText().isEmpty()) || 
                !(expense.getText().isEmpty()))
            {
                int j = -1; 
                j = jTable1.getSelectedRow();
                if(j >= 0)
                {
                    update.setEnabled(true);
                }
                else //invalid row
                {
                    System.out.println("incorrect count");
                    update.setEnabled(false);
                }
            }                 
        }
        else
        {
            addLoan.setEnabled(false);
            update.setEnabled(false);
        }
    }
      
    public int getNewRowNumber()
    {
        int rowCount = 0;
        boolean found = false; // if found the element from resultSet
        int checkValue = 1; //sequence value
        
        try
        {
            if(frameType == 5)//if monthly expenses
            {
                pst = con.prepareStatement(sqlRecIdM);
                rs = pst.executeQuery();
                pst = con.prepareStatement(sqlCountM);
                rs2 = pst.executeQuery();
            }
            else
            {
                pst = con.prepareStatement(sqlRecId);
                rs = pst.executeQuery();
                pst = con.prepareStatement(sqlCount);
                rs2 = pst.executeQuery();
            }
            
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tableSelect = new javax.swing.JComboBox();
        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        value = new javax.swing.JLabel();
        expense = new javax.swing.JTextField();
        dateTitle = new javax.swing.JLabel();
        exDate = new com.toedter.calendar.JDateChooser();
        lenderErr1 = new javax.swing.JLabel();
        lenderErr = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        selectDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        showSelected1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sYear = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        showSelected = new javax.swing.JButton();
        showAll = new javax.swing.JButton();
        searchBox = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        addLoan = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        tableSelect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Other Expenses", "Maintain Costs", "Delivery Costs", "Monthly Expenses", "Ingredients", "Equipments" }));
        tableSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tableSelectItemStateChanged(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        title.setText("Select Table ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Description here");

        description.setColumns(20);
        description.setRows(5);
        description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(description);

        value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        value.setText("Value Rs.");

        expense.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                expenseKeyReleased(evt);
            }
        });

        dateTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateTitle.setText("Date Expended");

        exDate.setToolTipText("Start Date");
        exDate.setDateFormatString("yyyy-MM-dd");
        exDate.setMinSelectableDate(new java.util.Date(789939090000L));
        exDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                exDatePropertyChange(evt);
            }
        });

        lenderErr1.setForeground(new java.awt.Color(255, 0, 0));

        lenderErr.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(exDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateTitle)
                                .addComponent(value)
                                .addComponent(expense, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lenderErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lenderErr, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lenderErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(value)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expense, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lenderErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(dateTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        selectDate.setToolTipText("Start Date");
        selectDate.setDateFormatString("yyyy-MM-dd");
        selectDate.setMinSelectableDate(new java.util.Date(789939090000L));
        selectDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                selectDatePropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Select the date");

        showSelected1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showSelected1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calender.png"))); // NOI18N
        showSelected1.setText("Show Selected");
        showSelected1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSelected1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Filter By Year");

        sYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        sYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sYearItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("&  Month");

        month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Months", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthItemStateChanged(evt);
            }
        });
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        showSelected.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/select.png"))); // NOI18N
        showSelected.setText("Show Selected");
        showSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSelectedActionPerformed(evt);
            }
        });

        showAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show view.png"))); // NOI18N
        showAll.setText("Show All");
        showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllActionPerformed(evt);
            }
        });

        searchBox.setText("Search in discription..");
        searchBox.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                searchBoxHierarchyChanged(evt);
            }
        });
        searchBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchBoxFocusLost(evt);
            }
        });
        searchBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoxMouseEntered(evt);
            }
        });
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchBoxKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showSelected1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sYear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showSelected1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(sYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {showSelected, showSelected1});

        delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove 3.png"))); // NOI18N
        delete.setText("Remove");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        addLoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addLoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add small.png"))); // NOI18N
        addLoan.setText("Add Row");
        addLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLoanActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addComponent(tableSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 797, Short.MAX_VALUE))
                            .addComponent(jScrollPane4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addLoan, clear, delete, update});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addLoan, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tableSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addLoan, clear, delete, update});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        int y = JOptionPane.showConfirmDialog(null, "Do you want to remove selected row?", "Confirm", JOptionPane.YES_NO_OPTION);

        if(y == JOptionPane.YES_OPTION)
        {
            int r = -1;
            int recId = -1;
            try // Check if it is selected or not
            {
                r = jTable1.getSelectedRow();//get selected row
                recId = (int)jTable1.getValueAt(r, 0);//get selected record id
            }catch(Exception e)
            {
                System.out.println("not selected");
            }

            String deletQuery = "";
            if(frameType == 2)
            {
                deletQuery = "DELETE FROM `other_expences` WHERE `record_id` = '"+ recId +"'";
            }
            if(frameType == 1)
            {
                deletQuery = "DELETE FROM `other_income` WHERE `record_id` = '"+ recId +"'";
            }
            if(frameType == 5)
            {
                deletQuery = "DELETE FROM `bill_cost` WHERE `record_id` = '"+ recId +"'";
            }

            try
            {
                pst = con.prepareStatement(deletQuery);
                pst.execute();
                if(frameType == 2)
                {
                    tableLoad(sqlExpen);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlInc);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonthlyEx);
                }
            }catch(Exception e){

            }
            clear.doClick();//After adding auto clik clear buttton
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        description.setText("");
        Date date1 = new Date();
        exDate.setDate(date1);
        expense.setText("");
        addLoan.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        int y = JOptionPane.showConfirmDialog(null, "Do you want to update selected row?", "Confirm", JOptionPane.YES_NO_OPTION);

        if(y == JOptionPane.YES_OPTION)
        {
            int r = -1;
            int recId = -1;
            try // Check if it is selected or not
            {
                r = jTable1.getSelectedRow();
                recId = (int)jTable1.getValueAt(r, 0);//get selected loan id
            }catch(Exception e)
            {
                System.out.println("not selected");
            }

            if(!( "".equals(description.getText())))
            {
                description1 = description.getText();
            }
            if(!( "".equals(expense.getText())))
            {
                formatAmount = expense.getText();
            }
            

            Date exDate1 = exDate.getDate();
            Format formatter = new SimpleDateFormat("yyyy/MM/dd");
            String s1 = formatter.format(exDate1);
            s1 = s1.replace('/', '-');


            Methods mth = new Methods();
            double expd = mth.withoutCommaToDouble(formatAmount); // validation of double

            String q ="";
            if(frameType == 2)
            {
                 q = "UPDATE `other_expences` "
                    + "SET `discription`='"+ description1 +"',"
                    + "`expend_date`='"+ s1 +"',`total_expence`='"+ expd +"' "
                    + "WHERE `record_id` = '"+ recId +"'";
            }
            if(frameType == 1)
            {
                q = "UPDATE `other_income` "
                    + "SET `discription`='"+ description1 +"',"
                    + "`date`='"+ s1 +"',`amount`='"+ expd +"' "
                    + "WHERE `record_id` = '"+ recId +"'";
            }
            if(frameType == 5)
            {
                q = "UPDATE `bill_cost` "
                    + "SET `expense_type`='"+ description1 +"',"
                    + "`date_paid`='"+ s1 +"',`cost`='"+ expd +"' "
                    + "WHERE `record_id` = '"+ recId +"'";
            }

            try
            {
                pst = con.prepareStatement(q);
                pst.execute();
                if(frameType == 2)
                {
                    tableLoad(sqlExpen);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlInc);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonthlyEx);
                }
            }catch(Exception e){

            }
        }
       clear.doClick();
    }//GEN-LAST:event_updateActionPerformed

    private void addLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLoanActionPerformed

        
        Methods mth = new Methods();
        int recId = getNewRowNumber();
        String des = description.getText();
        /*if(!mth.isValidLength(50, des))
        {
            
        }*/
        System.out.println("This is recid " + recId);
        if((Integer.toString(recId).length()) > 3)
        {
            int y = JOptionPane.showConfirmDialog(null, "Table is full. Please remove some records", "Table Full", JOptionPane.OK_CANCEL_OPTION);
        }
        if(recId > 0)
        {
            String exp = expense.getText();
            double total = mth.withoutCommaToDouble(exp);

            Date date = exDate.getDate(); 
            Format formatter = new SimpleDateFormat("yyyy/MM/dd");
            String s1 = formatter.format(date);
            s1 = s1.replace('/', '-'); 

            System.out.println("frame type " + frameType);
            System.out.println("recId " + recId);
            System.out.println("des " + des);
            System.out.println("total " + total);
            System.out.println("s1 " + s1);
            String q = "";
            if(frameType == 2)
            {
                q = "INSERT INTO `other_expences`(`record_id`, `discription`, `expend_date`, `total_expence`)"
                    + " VALUES ('"+ recId +"','"+ des +"','"+ s1 +"','"+ total +"')";
            }
            if(frameType == 1)
            {
               
                q = "INSERT INTO `other_income`(`record_id`, `discription`, `date`, `amount`)"
                    + " VALUES ('"+ recId +"','"+ des +"','"+ s1 +"','"+ total +"')";
            }
            
            if(frameType == 5)
            {
                System.out.println("Rec ID : " + recId);
                q = "INSERT INTO `bill_cost`(`record_id`, `date_paid`, `expense_type`, `cost`)"
                        + " VALUES ('"+ recId +"','2017-08-01','Water Bill','5000.00')";
            }

            try
            {
                pst = con.prepareStatement(q);
                pst.execute();
                if(frameType == 2)
                {
                    tableLoad(sqlExpen);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlInc);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonthlyEx);
                }
            }catch(Exception e){

            }

            clear.doClick();
        }
        //After adding auto clik clear buttton
    }//GEN-LAST:event_addLoanActionPerformed

    private void sYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sYearItemStateChanged
        //System.out.println("f");
    }//GEN-LAST:event_sYearItemStateChanged

    private void monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthItemStateChanged
       
    }//GEN-LAST:event_monthItemStateChanged

    private void showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllActionPerformed

        delete.setEnabled(false);
        addLoan.setEnabled(false);
        update.setEnabled(false);
        
        try
            {
                if(frameType == 2)
                {
                    tableLoad(sqlExpen);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlInc);
                }
                if(frameType == 4)
                {
                    tableLoad(sqlMaEx);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonthlyEx);
                }
                if(frameType == 3)
                {
                    tableLoad(sqlDilEx);
                }
                
            }catch(Exception e){
                   System.out.println("error");
                   
            }
        //clear.doClick();
    }//GEN-LAST:event_showAllActionPerformed

    private void showSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSelectedActionPerformed

        delete.setEnabled(false);

        String sqlExpenSelected = "";
        String sqlIncSelected = "";
        String sqlManSelected = "";
        String sqlMonSelected = "";
        String sqlDilSelected = "";
        String month1 = month.getSelectedItem().toString();
        String mon = "";
        String yer = sYear.getSelectedItem().toString();
        Methods dd = new Methods();
        int monthNo = dd.getMonthNo(month1);
        
        if(monthNo < 10)
        {
            mon = "-0"+monthNo+"-";
        }
        else
        {
            mon = "-"+monthNo+"-";
        }
        
        if("All Months".equals(month1))
        {
            //System.out.println(yer+month1);
            sqlExpenSelected = "SELECT `record_id` as 'Record ID', `discription` as 'Description',"
            + " `expend_date` as 'Date Expended', `total_expence` as 'Total Expence' "
            + " FROM `other_expences` "
            + "WHERE `expend_date` LIKE '"+yer+"%'";
    
            sqlIncSelected = "SELECT `record_id` as 'Record ID', `discription` as 'Discription',"
                + " `date` as 'Date Receive', `amount` as 'Amount' "
                + "FROM `other_income` "
                + "WHERE `date` LIKE '"+yer+"%'";
            
            sqlManSelected = "SELECT `Maintancetype` as 'Discription', `Cost`, `Startdate` as 'Start Date'"
                    + " FROM `longtime` "
                    + "WHERE `Startdate` LIKE '"+yer+"%'";
            
            sqlMonSelected = "SELECT `record_id` as 'Record ID',"
                    + " `expense_type` as 'Description',"
                    + " `date_paid` as 'Date Paid',"
                    + " `cost` as 'Total Paid'"
                    + " FROM `bill_cost` WHERE `date_paid` LIKE '"+yer+"%'";
            
            sqlDilSelected = "SELECT `Order_ID` as 'Order ID', `Vehicle_ID` as 'Vehicle No.', `date` as 'Date', `charges` as 'Total'"
                    + " FROM `delivery_chages` WHERE `date` LIKE '"+yer+"%'";
        }
        else
        {
            System.out.println(yer+mon);

            sqlExpenSelected = "SELECT `record_id` as 'Record ID', `discription` as 'Description',"
            + " `expend_date` as 'Date Expended', `total_expence` as 'Total Expence' "
            + " FROM `other_expences` "
            + "WHERE `expend_date` LIKE '"+yer+mon+"%'";
    
            sqlIncSelected = "SELECT `record_id` as 'Record ID', `discription` as 'Discription',"
                + " `date` as 'Date Receive', `amount` as 'Amount' "
                + "FROM `other_income` "
                + "WHERE `date` LIKE '"+yer+mon+"%'";
            
            sqlManSelected = "SELECT `Maintancetype` as 'Discription', `Cost`, `Startdate` as 'Start Date'"
                    + " FROM `longtime` "
                    + "WHERE `Startdate` LIKE '"+yer+mon+"%'";
            
            sqlMonSelected = "SELECT `record_id` as 'Record ID',"
                    + " `expense_type` as 'Description',"
                    + " `date_paid` as 'Date Paid',"
                    + " `cost` as 'Total Paid'"
                    + " FROM `bill_cost` WHERE `date_paid` LIKE '"+yer+mon+"%'";
            
            sqlDilSelected = "SELECT `Order_ID` as 'Order ID', `Vehicle_ID` as 'Vehicle No.',`date` as 'Date', `charges` as 'Total'"
                    + " FROM `delivery_chages` WHERE `date` LIKE '"+yer+mon+"%'";
        }
        
            try
            {
                if(frameType == 4)
                {
                    tableLoad(sqlManSelected);
                }
                if(frameType == 2)
                {
                    tableLoad(sqlExpenSelected);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlIncSelected);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonSelected);
                }
                if(frameType == 3)
                {
                    tableLoad(sqlDilSelected);
                }
            }catch(Exception e){
                   System.out.println("error");
            }                                 
            clear.doClick();
    }//GEN-LAST:event_showSelectedActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void searchBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBoxFocusGained
       
    }//GEN-LAST:event_searchBoxFocusGained

    private void searchBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseClicked
        
        searchBox.setText("");
      
        
    }//GEN-LAST:event_searchBoxMouseClicked

    private void searchBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBoxFocusLost
        
        searchBox.setText("Search in description...");
        //delete.setEnabled(false);
        showAll.doClick();
    }//GEN-LAST:event_searchBoxFocusLost

    private void searchBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyTyped
        
    }//GEN-LAST:event_searchBoxKeyTyped

    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
 
    }//GEN-LAST:event_searchBoxKeyPressed

    private void searchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyReleased

        update.setEnabled(false);
        addLoan.setEnabled(false);
        delete.setEnabled(false);
        String searchText = searchBox.getText();
        //System.out.println(searchText);
        
        String sqlExpenSearch = "SELECT `record_id` as 'Record ID', `discription` as 'Description',"
            + " `expend_date` as 'Date Expended', `total_expence` as 'Total Expence' "
            + " FROM `other_expences` "
            + "WHERE `discription` LIKE '%"+searchText+"%'";
    
        String sqlIncSearch = "SELECT `record_id` as 'Record ID', `discription` as 'Discription',"
                + " `date` as 'Date Receive', `amount` as 'Amount' "
                + "FROM `other_income` "
                + "WHERE `discription` LIKE '%"+searchText+"%'";
        
        String sqlManSearch =  "SELECT `Maintancetype` as 'Discription', `Cost`, `Startdate` as 'Start Date'"
                    + " FROM `longtime` "
                    + "WHERE `Maintancetype` LIKE '"+searchText+"%'";
        
        String sqlMonSearch = "SELECT `record_id` as 'Record ID',"
                    + " `expense_type` as 'Description',"
                    + " `date_paid` as 'Date Paid',"
                    + " `cost` as 'Total Paid'"
                    + " FROM `bill_cost` WHERE `expense_type` LIKE '"+searchText+"%'";
        
        String sqlDilSearch = "SELECT `Order_ID` as 'Order ID', `Vehicle_ID` as 'Vehicle No.', `charges` as 'Total'"
                    + " FROM `delivery_chages` WHERE `Order_ID` LIKE '"+searchText+"%'";
        
        String sqlIngSearch = "SELECT `itemno` as 'Item No', `itemname` as 'Item Name', `quantity` as 'Quantity',"
            + " `unitprice` as 'Unit Price', (`unitprice` * `quantity`) as 'Total'"
            + " FROM `ingredients` WHERE `itemno` LIKE '"+searchText+"%'";
        
        String sqlEqSearch = "SELECT `itemno` as 'No', `itemname` as 'Name',"
            + " `quantity` as 'Qty', `unitprice` as 'Unit Price', (`unitprice` * `quantity`) as 'Total Cost' "
            + "FROM `equipments` WHERE `itemno` LIKE '"+searchText+"%'";
        
            try
            {
                if(frameType == 4)
                {
                    tableLoad(sqlManSearch);
                }
                if(frameType == 2)
                {
                    tableLoad(sqlExpenSearch);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlIncSearch);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonSearch);
                }
                if(frameType == 3)
                {
                    tableLoad(sqlDilSearch);
                }
                if(frameType == 6)
                {
                    tableLoad(sqlEqSearch);
                }
                if(frameType == 7)
                {
                    tableLoad(sqlIngSearch);
                }
            }catch(Exception e){
                   System.out.println("error");
            }  
    }//GEN-LAST:event_searchBoxKeyReleased

    private void searchBoxHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_searchBoxHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxHierarchyChanged
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int r = jTable1.getSelectedRow();
        System.out.println(r);
        if(r >= 0)
        {
            
            String date = "1995-01-13";
            double amount1 = 0.0;
            if((frameType == 2) || (frameType == 1) || (frameType == 5))
            {
               description1 = jTable1.getValueAt(r, 1).toString();
               date = jTable1.getValueAt(r, 2).toString();
               amount1 = (double) jTable1.getValueAt(r, 3);
            }

            if(frameType == 4)
            {
               description1 = jTable1.getValueAt(r, 0).toString();
               amount1 = (double) jTable1.getValueAt(r, 1);
               date = jTable1.getValueAt(r, 2).toString();         
            }
            description.setText(description1);

            date = date.replace('-', '/');

            Date date1 = null;
            try {  
                 date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
            }
            exDate.setDate(date1);

            DecimalFormat dc = new DecimalFormat("###,###,###.00");
            formatAmount = dc.format(amount1);
            expense.setText(formatAmount);
            
            delete.setEnabled(true);
            update.setEnabled(true);
            addLoan.setEnabled(true);
            
            if(frameType == 3 || frameType == 4 || frameType == 6 || frameType == 7)
            {
                delete.setEnabled(false);
                update.setEnabled(false);
                addLoan.setEnabled(false);
                description.setText("Discription Not Available");
                expense.setText("Discription Not Available");
            }
            
        }
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void tableSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tableSelectItemStateChanged
       
        String select = tableSelect.getSelectedItem().toString();
        delete.setEnabled(false);
        update.setEnabled(false);
        addLoan.setEnabled(false);
        if("Delivery Costs".equals(select))
        {
            tableLoad(sqlDilEx);
            frameType = 3;
            
            searchBox.setText("Search in Order Id...");
            description.setText("Discription Not Available");
            description.setEnabled(false);
            expense.setText("Discription Not Available");
            expense.setEnabled(false);
            exDate.setEnabled(false);
            clear.setEnabled(false);
        }
        if("Maintain Costs".equals(select))
        {
           
            tableLoad(sqlMaEx);
            frameType = 4;
            
            searchBox.setText("Search in description...");
            description.setText("Discription Not Available");
            description.setEnabled(false);
            expense.setText("Discription Not Available");
            expense.setEnabled(false);
            exDate.setEnabled(false);
            clear.setEnabled(false);
        }
        
        if("Monthly Expenses".equals(select))
        {
            tableLoad(sqlMonthlyEx);
            frameType = 5;
            
            searchBox.setText("Search in description...");
            description.setEnabled(true);
            expense.setEnabled(true);
            exDate.setEnabled(true);
            clear.setEnabled(true);
        }
        
        if("Other Expenses".equals(select))
        {
            tableLoad(sqlExpen);
            frameType = 2;
            
            searchBox.setText("Search in description...");
            description.setEnabled(true);
            expense.setEnabled(true);
            exDate.setEnabled(true);
            clear.setEnabled(true);
        }      
        
        if("Equipments".equals(select))
        {
            tableLoad(sqlExEq);
            frameType = 6;
            
            searchBox.setText("Search in Item number...");
            description.setText("Discription Not Available");
            description.setEnabled(false);
            expense.setText("Discription Not Available");
            expense.setEnabled(false);
            exDate.setEnabled(false);
            clear.setEnabled(false);
        } 
        
        if ("Ingredients".equals(select))
        {
            tableLoad(sqlExIn);
            frameType = 7;
            
            searchBox.setText("Search in Item number...");
            description.setText("Discription Not Available");
            description.setEnabled(false);
            expense.setText("Discription Not Available");
            expense.setEnabled(false);
            exDate.setEnabled(false);
            clear.setEnabled(false);
        } 
    }//GEN-LAST:event_tableSelectItemStateChanged

    private void descriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionKeyReleased
        
        Methods mm = new Methods();
        if("".equals(description.getText()))
        {
            lenderErr.setText("");
        }
        else if(!(mm.isValidLength(50,description.getText())))
        {
            lenderErr.setText("Too long");
        }
        else
        {
            lenderErr.setText("");
        }
        ValidationPass();
    }//GEN-LAST:event_descriptionKeyReleased

    private void expenseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expenseKeyReleased

        Methods mm = new Methods();
        double d = mm.withoutCommaToDouble(expense.getText());
        if("".equals(expense.getText()))
        {
            lenderErr1.setText("");
        }
        else if(d == -1.321)
        {
            lenderErr1.setText("Error");
        }
        else
        {
            lenderErr1.setText("");
        }
        ValidationPass();
        
    }//GEN-LAST:event_expenseKeyReleased

    private void exDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_exDatePropertyChange
   
        ((JTextField)exDate.getDateEditor().getUiComponent()).setEditable(false); //set editable false in  date chooser via typing

    }//GEN-LAST:event_exDatePropertyChange

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        
     
    }//GEN-LAST:event_jTable1FocusLost

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        
        
    }//GEN-LAST:event_jTable1FocusGained

    private void searchBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxMouseEntered

    private void selectDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_selectDatePropertyChange

        ((JTextField)exDate.getDateEditor().getUiComponent()).setEditable(false); //set editable false in  date chooser via typing

    }//GEN-LAST:event_selectDatePropertyChange

    private void showSelected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSelected1ActionPerformed

        Date selectDate1 = selectDate.getDate();
        Format formatter = new SimpleDateFormat("yyyy/MM/dd");
        String s1 = formatter.format(selectDate1);
        s1 = s1.replace('/', '-');
        
        System.out.println("This is date : " + s1);
        String sqlExpenSelected = "SELECT `record_id` as 'Record ID', `discription` as 'Description',"
            + " `expend_date` as 'Date Expended', `total_expence` as 'Total Expence' "
            + " FROM `other_expences` "
            + "WHERE `expend_date` = '"+s1+"'";
    
        String sqlIncSelected = "SELECT `record_id` as 'Record ID', `discription` as 'Discription',"
                + " `date` as 'Date Receive', `amount` as 'Amount' "
                + "FROM `other_income` "
                + "WHERE `date` = '"+s1+"'";
            
        String sqlManSelected = "SELECT `Maintancetype` as 'Discription', `Cost`, `Startdate` as 'Start Date'"
                    + " FROM `longtime` "
                    + "WHERE `Startdate` = '"+s1+"'";
            
        String sqlMonSelected = "SELECT `record_id` as 'Record ID',"
                    + " `expense_type` as 'Description',"
                    + " `date_paid` as 'Date Paid',"
                    + " `cost` as 'Total Paid'"
                    + " FROM `bill_cost` WHERE `date_paid` = '"+s1+"'";
            
        String sqlDilSelected = "SELECT `Order_ID` as 'Order ID', `Vehicle_ID` as 'Vehicle No.', `date` as 'Date', `charges` as 'Total'"
                    + " FROM `delivery_chages` WHERE `date` = '"+s1+"'";
            
        try
            {
                if(frameType == 4)
                {
                    tableLoad(sqlManSelected);
                }
                if(frameType == 2)
                {
                    tableLoad(sqlExpenSelected);
                }
                if(frameType == 1)
                {
                    tableLoad(sqlIncSelected);
                }
                if(frameType == 5)
                {
                    tableLoad(sqlMonSelected);
                }
                if(frameType == 3)
                {
                    tableLoad(sqlDilSelected);
                }
            }catch(Exception e){
                   System.out.println("error");
            }                                 
        clear.doClick();
    }//GEN-LAST:event_showSelected1ActionPerformed

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
            java.util.logging.Logger.getLogger(OtherExInc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OtherExInc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OtherExInc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OtherExInc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtherExInc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLoan;
    private javax.swing.JButton clear;
    private javax.swing.JLabel dateTitle;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea description;
    private com.toedter.calendar.JDateChooser exDate;
    private javax.swing.JTextField expense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lenderErr;
    private javax.swing.JLabel lenderErr1;
    private javax.swing.JComboBox month;
    private javax.swing.JComboBox sYear;
    private javax.swing.JTextField searchBox;
    private com.toedter.calendar.JDateChooser selectDate;
    private javax.swing.JButton showAll;
    private javax.swing.JButton showSelected;
    private javax.swing.JButton showSelected1;
    private javax.swing.JComboBox tableSelect;
    private javax.swing.JLabel title;
    private javax.swing.JButton update;
    private javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}

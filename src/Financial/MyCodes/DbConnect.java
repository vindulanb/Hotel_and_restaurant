/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial.MyCodes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Vindula
 */
public class DbConnect 
{
    public static Connection connect()
    {
        Connection conn = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelandresturent","root","");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Connection error", "Error",
                                    JOptionPane.ERROR_MESSAGE);
        }
        
        return conn;
    }
    
}



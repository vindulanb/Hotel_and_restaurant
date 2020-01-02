/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author GIMHANI
 */
public class Dbconnecter {
    public static Connection con() {
        Connection con=null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelandresturent","root","");
           
       }
       catch (Exception e){
           System.out.println(e);
       }
        return con;
        
        
    }
}

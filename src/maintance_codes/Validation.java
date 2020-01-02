package maintance_codes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Validation {
    
     //validate phone no
    public static boolean isValidPhoneNo(String no) {
        
        String noPattern="\\d{10}";
        
        Pattern pattern=Pattern.compile(noPattern);
        Matcher regexmatcher=pattern.matcher(no);
        
        if(!regexmatcher.matches())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
     //validate email
     public static boolean isValidEmail(String email) {
      
        
          String emailPattern="[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}[.][a-zA-Z]{2,3}$";
          
          Pattern pattern=Pattern.compile(emailPattern);
          Matcher Regexmatcher=pattern.matcher(email);
          
          if(!Regexmatcher.matches())
          {
              return false;
          }
          else
          {
              return true;
          }
    }
     
      //validate nic
       public static boolean isValidNIC(String nic){
        
          String idPattern="[0-9]{9}[v|V]$";
//          /^[0-9]{9}[vVxX]$/
          
          Pattern pattern=Pattern.compile(idPattern);
          Matcher Regexmatcher=pattern.matcher(nic);
          
          if(!Regexmatcher.matches())
          {
              return false;
          }
          else
          {
              return true;
          }
    }
       
     public static boolean isvaliedtime1(String strat,String type) throws ParseException{
//         String ampattern="[0-9]$";
//        String pmpattern="[12-23]$";
         SimpleDateFormat format = new SimpleDateFormat("HH mm");
        Date date1 = format.parse(strat);

        int  starth = date1.getHours();
        JOptionPane.showMessageDialog(null, starth);
         if((type.equalsIgnoreCase("am") && starth < 12)||(type.equalsIgnoreCase("pm") && starth > 11)){
                return true;
         }
         else{
                return false;
           
         }
         
     }
     public static boolean isvaliedtime2(String end,String type) throws ParseException{
//         String ampattern="[0-9]$";
//        String pmpattern="[12-23]$";
         SimpleDateFormat format = new SimpleDateFormat("HH mm");
        Date date1 = format.parse(end);

        int  starth = date1.getHours();
        JOptionPane.showMessageDialog(null, starth);
         if((type.equalsIgnoreCase("am") && starth < 12)||(type.equalsIgnoreCase("pm") && starth > 11)){
                return true;
         }
         else{
                return false;
           
         }
         
     } 
     
      public static boolean ispeople(String people,String seats) {
          int nopeople=Integer.parseInt(people);
          int capacity=Integer.parseInt(seats);
         if(nopeople>capacity){
            return false;
        }
        else
            return true;
    
    }
      
     public static boolean isfname(String fname) {

        if (!fname.matches("[a-zA-Z ]+")) {
            return false;
        } else {
            return true;
        }
    }
     
    public static boolean islname(String lname) {

        if (!lname.matches("[a-zA-Z ]+")) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean iscity(String city) {

        if (!city.matches("[a-zA-Z ]+")) {
            return false;
        } else {
            return true;
        }
    }
    
     public static boolean isValidLengthadd(int i, String s)
    {
        int len = s.length();
        if(len > i)
        {
            return false;//flase if length size higer than limit
        }
        else{
          return true;//valid 
        }
        
    }
     
    //tharindu's validation 
     
     
    public boolean textOnly(String x) {
        return x.matches("[a-zA-Z]+");
    }
    public boolean numberOnly(String x) {
        return x.matches("[0-9]*+");
    }

    public boolean contactNo(String x) {
        return (x.length() == 10 && x.matches("[0-9]*"));
    }
   
    public boolean validateEmailAddress(String emailAddress) {

        Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        Matcher regMatcher = regexPattern.matcher(emailAddress);
    if(regMatcher.matches()){
        return true;
    } else {
    return  false;
    }
}

}

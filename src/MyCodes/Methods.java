/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import MyCodes.DbConnect;

/**
 *
 * @author Vindula
 */
public class Methods 
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null, rs2 = null;

    public boolean checkEmpty(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(!(Character.isWhitespace(s.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }
    
    public int getMonthNo(String month)
    {
        
        int m = 0;
      switch(month) {
         case "January" :
            m = 1;
            break;
         case "February" :
            m = 2;
            break;
         case "March" :
            m = 3;
            break;
         case "April" :
            m = 4;
            break;
         case "May" :
            m = 5;
            break;
         case "June" :
            m = 6;
            break;
         case "July" :
            m = 7;
            break;
         case "August" :
            m = 8;
            break;
         case "September" :
            m = 9;
            break;
         case "October" :
            m = 10;
            break;
         case "November" :
            m = 11;
            break;
         case "December" :
            m = 12;
            break;
         default :
            m = 13;
      }
      return m;
    }
    
    public double getValidInterest(String s)
    {
        /*if(s.length() > 3)
        {
            return -222;
        }*/
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')
            {        
            }
            else
                return -1.321;
        }
        
        double value = 0.0;
        try
        {
            value = Double.parseDouble(s);
            value = value / 100;
            value  = (double) Math.round(value * 1000.0) / 1000.0;
        }catch(Exception e)
        {
            return -1.321;
        }
        if(value <= 1)
            return value;
        else
            return -1.321;
    }
    public boolean isValidIntPart(int intSize, int decSize, String s)
    {
        String intPart = "0", decimalPart = "0";
        s = TokanizAppend(s,",");
        StringTokenizer st = new StringTokenizer(s,"."); 
        
        if (st.hasMoreTokens())  
            intPart = st.nextToken();
        if (st.hasMoreTokens())  
            decimalPart = st.nextToken();
        if(((intPart.length()) > intSize) || (decimalPart.length() > decSize))
            return false;
        return true;
    }
    public boolean isValidLength(int i, String s)
    {
        int len = s.length();
        if(len > i)
        {
            return false;//flase if length size higer than limit
        }
        return true;//valid
    }
    public String formatStringDate(String s)
    {
        if(s.length() == 10)
        {
            String year,month,day;
            int count = 0;
            String[] dateArray = new String[3];
            
            StringTokenizer st = new StringTokenizer(s,"-");  
            while (st.hasMoreTokens())
            {   
                dateArray[count] = st.nextToken();
                count++;
            }  
            year = dateArray[0];
            if(year.length() == 4)
            {           
                StringBuilder sb = new StringBuilder();
                sb.append(year.charAt(2));
                sb.append(year.charAt(3));
                year = sb.toString();
            }
            month = dateArray[1];
            day = dateArray[2];
            if(month.length() == 2 && month.charAt(0) == '0')
            {
                month = "" + month.charAt(1);
            }
            if(day.length() == 2 && day.charAt(0) == '0')
            {
                day = "" + day.charAt(1);
            }
            return month + "/" + day + "/" + year;
        }
        else
            return s;
    }
    
    public String formatLongFomat(String s)
    {
        if(s.length() <= 8)
        {
            String year,month,day;
            int count = 0;
            String[] dateArray = new String[3];

            StringTokenizer st = new StringTokenizer(s,"/");  
            while (st.hasMoreTokens())
            {   
                dateArray[count] = st.nextToken();
                count++;
            }  
            year = dateArray[2];
            if(year.length() == 2)         
                year = "20" + year.charAt(0) + year.charAt(1);
            else if(year.length() == 1)
                year = "200" + year.charAt(0);
            month = dateArray[0];
            day = dateArray[1];
            
            if(month.length() == 1)
                month = "0" + month;
            if(day.length() == 1)
                day = "0" + day;

            return (year + "-" + month + "-" + day); 
        }
        else
            return s;    
    }   
    
    public String TokanizAppend(String s,String deli)
    {
        //String deli = ",";
        String token, finalString = "no input";
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s,deli);  
            while (st.hasMoreTokens())
            {   
                token = st.nextToken();
                stringBuilder.append(token);
                finalString = stringBuilder.toString();
            }  
            finalString = stringBuilder.toString();
            return finalString;
    }
    
    public double getDoubleInTwo(String s)
    {
        double value = -1.321;
        try// try to convert it to double
        {
            value = Double.parseDouble(s);
            value  = (double) Math.round(value * 100.0) / 100.0; // round two decimal places
        }
        catch(Exception e)
        {
            return -1.321;
        }
        return value;
    }
   
    public double withoutCommaToDouble(String s)
    {
        int dottCount = 0, dotIn = s.length(); //if there is a fraction length without decimal
        boolean decimal = false; // if there is a fraction
        int lenthSize = s.length(); //if there is no fractions total length
        float commaCount = 0;
        int lastCommaIn = 0;
        
        if(s.isEmpty()) // checking for is it a blank space
        { 
            return -1.321;
        }
        
        for(int i = 0; i < lenthSize; i++)//Checking correctness of the input
        {
            if((Character.isDigit(s.charAt(i))) || (s.charAt(i) == ',') || (s.charAt(i) == '.'))
            { 
                if(s.charAt(i) == ',')//counting total commas in the string
                {
                    lastCommaIn = i;
                    commaCount++;                    
                }
            }
            else
            {
                return -1.321;
            }
            
            if(s.charAt(i) == '.')// Correcting the Dotts
            {
                dottCount++;
                if (dottCount > 1)//more dotts in number
                    return -1.321;
                else
                {
                    decimal = true;//This has decimal 
                    dotIn = i;
                }
            }
        }
        
        if(decimal == true)
        {            
                try
                {
                    if(Character.isDigit(s.charAt(dotIn - 1)) && 
                       Character.isDigit(s.charAt(dotIn + 1)))
                    {
                        
                    }
                }catch(Exception e)
                {
                    return -1.321;
                }            
        }
        if((decimal == true) && (dotIn < lastCommaIn)) //Check in a decimal number if there is a comma in fraction part
            return -1.321;
       
        else if(commaCount == 0)
            return getDoubleInTwo(s);
        else if(commaCount == 1)
        {      
            try
            {
                
                if((Character.isDigit(s.charAt((lastCommaIn) - 1))) 
                        && (Character.isDigit(s.charAt((lastCommaIn) + 1))) 
                        && (Character.isDigit(s.charAt((lastCommaIn) + 2))) 
                        && (Character.isDigit(s.charAt((lastCommaIn) + 3))))
                {
                   // System.out.println("in main if");
                    if((decimal == false) && ((lenthSize - 4) != lastCommaIn))//for intiger values
                    {
                        return -1.321;
                    }
                    else if((decimal == true) && (lenthSize > 5) && !(s.charAt(lastCommaIn + 4) == '.')) 
                    {
                        return -1.321;
                    }
                    else if((lastCommaIn < 1) || (lastCommaIn > 3))
                    {
                        return -1.321;
                    }
                    String finalString = TokanizAppend(s,",");
                    return getDoubleInTwo(finalString);
                }
                else
                {
                    return -1.321;
                }
            }catch(Exception e)
            {
                return -1.321;
            }
        }
        else
        {
            char numTray[] = new char[dotIn];
            if(decimal == true)//Create new array without decimals
            {   
                for(int i = 0; i < dotIn; i++)//adding values to array from string which has decimals
                    numTray[i] = s.charAt(i);
            }
            else
            {
                for(int i = 0; i < lenthSize; i++)//adding values to array from string wich doesn't have decimals
                    numTray[i] = s.charAt(i);
            }

            if(dotIn > 3)
            {
                for(int i = (dotIn - 4); i >= 0; i-=4) // check ',' patten ##,###,### correct
                {
                    if((numTray[i] == ','))
                    {
                    }
                    else
                        return -1.321;
                }
            }
            String finalString = TokanizAppend(s,",");
            return getDoubleInTwo(finalString);
        }

    }
    
    //--------------------para------------------------------------------
    
    public static boolean validateNIC(String nic) {
    // Check if length is 10
    int length = nic.length();
    if (length != 10) {
        System.out.println("C");
        return false;
        
            
    }

    // Check first 9 characters are digits
    
    for (int i = 0; i < length - 2; i++) {
        char currentChar = nic.charAt(i);
        if (currentChar < '0' || '9' < currentChar) {
            
            System.out.println("aa");
            return false;
        }
    }
    // Check last character for v, V, x, or X
    char lastChar = nic.charAt(length - 1);
    if (lastChar == 'v' | lastChar == 'V' ) {
        
        System.out.println(lastChar);
        System.out.println("B");
        return true;
    }
    else 
        return false;

  
}

 public static boolean validateTxt(String a, int i){
     
     
     if(a.length()>i){
         return false;
     }
     else
         return true;
 
 
 
     
 } 

}


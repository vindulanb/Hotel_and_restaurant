/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author GIMHANI
 */
public class common_methods_ {
      public static void errorMsg() {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Warning!!! Something in Wrong. ", "KOGA restaurant",
                JOptionPane.WARNING_MESSAGE);

    } public static void errorMsg1() {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Warning!!! This Buyer's order hasn't Delivered. ", "KOGA restaurant",
                JOptionPane.WARNING_MESSAGE);

    } public static void errorMsg2() {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Warning!!! This Vehicle isn't free at the movement. ", "KOGA restaurant",
                JOptionPane.WARNING_MESSAGE);

    }
       public static void successMsgAdd() {
  final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Successfully Added your Details.. ", "KOGA restaurant",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
          public static void successMsgDelete() {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Successfully Deleted your Details.. ", "KOGA restaurant",
                JOptionPane.INFORMATION_MESSAGE);
  }
           public static void successMsg() {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Successfully updated your modification.. ", "KOGA restaurant",
                JOptionPane.INFORMATION_MESSAGE);

    }
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
}

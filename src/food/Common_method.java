/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author GIMHANI
 */
public class Common_method {
     public static void errorMsg() {
        final JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(panel, "Warning!!! Something in Wrong. ", "KOGA restaurant",
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
            public static boolean numberOnly(String x) {
        return x.matches("[0-9]*+");
    }
              public static boolean textOnly(String x) {
        return x.matches("[a-zA-Z]+");
    }
}


package pe.ucs.wilsonapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensaje {
    
  private Mensaje() {
  }

  public static void showError(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "WILSONSTORE - ERROR", JOptionPane.ERROR_MESSAGE);
  }

  public static void showInfo(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "WILSONSTORE - INFO", JOptionPane.INFORMATION_MESSAGE);
  }

}

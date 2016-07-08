package pe.egcc.edutecapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public final class Mensaje {

  private Mensaje() {
  }

  public static void showError(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "EDUTEC - ERROR", JOptionPane.ERROR_MESSAGE);
  }

  public static void showInfo(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "EDUTEC - INFO", JOptionPane.INFORMATION_MESSAGE);
  }

  
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.jpaj.wilsonapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author jcpr1994
 */
public class Mensaje {
     private Mensaje() {
  }

  public static void showError(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "WilsonStore - ERROR", JOptionPane.ERROR_MESSAGE);
  }

  public static void showInfo(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "WilsonStore - INFO", JOptionPane.INFORMATION_MESSAGE);
  }

}

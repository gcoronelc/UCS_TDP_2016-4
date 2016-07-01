package pe.egcc.ventaapp.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prueba02 {
  
  private static String nombre = "Gustavo";

  public static void main(String[] args) {
    JFrame form = new JFrame();
    form.setLayout(null);
    form.setBounds(100, 100, 450, 300);

    JButton boton = new JButton("Saludo");
    boton.setBounds(10, 10, 100, 100);
    
    boton.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Hola " + nombre);
      }
    });
    
    form.add(boton);
    
    form.setVisible(true);
  }
  
}

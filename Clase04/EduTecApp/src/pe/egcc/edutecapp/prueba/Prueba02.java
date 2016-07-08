package pe.egcc.edutecapp.prueba;

import pe.egcc.edutecapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    
    Memoria.put("profesor", "Gustavo Coronel");
    Memoria.put("edad", 52);
    
    System.out.println("Profesor: " + Memoria.get("profesor"));
    System.out.println("Edad: " + Memoria.get("edad"));
    
  }
}

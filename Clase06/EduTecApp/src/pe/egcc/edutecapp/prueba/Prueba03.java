package pe.egcc.edutecapp.prueba;

import pe.egcc.edutecapp.service.espec.MatriculaServiceEspec;
import pe.egcc.edutecapp.service.impl.MatriculaServiceImpl;
import pe.egcc.edutecapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    
    try {
      MatriculaServiceEspec service;
      service = new MatriculaServiceImpl();
      service.regMatricula(552, "A0001");
      System.out.println("Todo ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

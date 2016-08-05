package pe.egcc.edutecapp.prueba;

import pe.egcc.edutecapp.service.espec.CuentaServiceEspec;
import pe.egcc.edutecapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba05 {
  
  public static void main(String[] args) {
    try {
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      service.doDeposito("00100001", 100.0, "003");
      System.out.println("Proceso ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

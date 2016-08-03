package pe.egcc.edutecapp.prueba;

import pe.egcc.edutecapp.domain.Cliente;
import pe.egcc.edutecapp.service.impl.ClienteServiceImpl;
import pe.egcc.edutecapp.service.espec.ClienteServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    
    try {
      Cliente bean = new Cliente();
      bean.setCodigo("");
      bean.setPaterno("R");
      bean.setMaterno("o");
      bean.setNombre("");
      ClienteServiceEspec service;
      service = new ClienteServiceImpl();
      for(Cliente a: service.getRecords(bean)){
        System.out.println(a.getCodigo()
                + " | " + a.getPaterno()
                + " | " + a.getMaterno()
                + " | " + a.getNombre());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

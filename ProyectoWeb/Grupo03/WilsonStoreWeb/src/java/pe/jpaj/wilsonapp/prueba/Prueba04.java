package pe.jpaj.wilsonapp.prueba;

import pe.jpaj.wilsonapp.domain.Cliente;
import pe.jpaj.wilsonapp.service.impl.ClienteServiceImpl;
import pe.jpaj.wilsonapp.service.espec.ClienteServiceEspec;

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
      bean.setPaterno("p");
      bean.setMaterno("");
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

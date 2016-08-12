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
public class Prueba041 {
  
  public static void main(String[] args) {
    
    try {
      Cliente bean = new Cliente();
      bean.setCodigo("srequejo");
      bean.setPaterno("Requejo");
      bean.setMaterno("Arias");
      bean.setNombre("Susana");
      bean.setDni("09940282");
      bean.setEmail("susana_re@h");
      bean.setDireccion("cl. San Alberto 218");
      bean.setCiudad("Surquillo");
      bean.setTelefono("999910995");
          
      
      ClienteServiceEspec service;
      service = new ClienteServiceImpl();
      service.insert(bean);
      
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

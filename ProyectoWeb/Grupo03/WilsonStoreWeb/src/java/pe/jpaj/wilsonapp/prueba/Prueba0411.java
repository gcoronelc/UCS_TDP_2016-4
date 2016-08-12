package pe.jpaj.wilsonapp.prueba;

import pe.jpaj.wilsonapp.domain.Producto;
import pe.jpaj.wilsonapp.service.espec.ProductoServiceEspec;
import pe.jpaj.wilsonapp.service.impl.ProductoServiceImpl;


/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba0411 {
  
  public static void main(String[] args) {
    
    try {
      Producto bean = new Producto();
      bean.setTp_producto(1);
        bean.setNombre("papas2");
        bean.setDescripcion("papas2");
        bean.setPrecio(10.00);
        bean.setStock(50);
        bean.setStock_min(10);
          
      
      ProductoServiceEspec service;
      service = new ProductoServiceImpl();
      service.insert(bean);
      
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

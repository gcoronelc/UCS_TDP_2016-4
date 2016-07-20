package ClienteServidor.Controller;

import ClienteServidor.Service.Espec.ProductoServiceEspec;
import ClienteServidor.Service.Impl.ProductoServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class ProductoController {

  private ProductoServiceEspec service = null;

  public ProductoController() {
    service = new ProductoServiceImpl();
  }

  public void Registrar(int idCursoProg, String idAlumno) {
    service.regProducto(idCursoProg, idAlumno);
  }

}

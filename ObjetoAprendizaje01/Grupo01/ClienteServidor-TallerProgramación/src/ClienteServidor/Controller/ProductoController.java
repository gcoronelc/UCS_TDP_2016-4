package ClienteServidor.Controller;

import ClienteServidor.Domain.Combo;
import ClienteServidor.Service.Espec.ProductoServiceEspec;
import ClienteServidor.Service.Impl.ComboServiceImpl;
import ClienteServidor.Service.Impl.ProductoServiceImpl;
import java.util.List;
import ClienteServidor.Service.Espec.ComboServiceEspec;

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

  
  public List<Combo> getCategorias(){
    ComboServiceEspec service = new ComboServiceImpl();
    return service.getCategorias();
  }
}

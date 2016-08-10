package pe.egcc.edutecapp.service.espec;

import java.util.List;
import java.util.Map;
import pe.egcc.edutecapp.domain.Combo;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public interface CuentaServiceEspec {
  
  Map<String,Object> getDatosCuenta(String cuenta);
  
  void doDeposito(String cuenta, double importe, String codEmpl);
  
  List<Combo> getCuentaCombo();
  
}

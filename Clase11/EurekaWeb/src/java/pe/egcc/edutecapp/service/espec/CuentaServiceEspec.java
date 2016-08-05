package pe.egcc.edutecapp.service.espec;

import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public interface CuentaServiceEspec {
  
  Map<String,Object> getDatosCuenta(String cuenta);
  
  void doDeposito(String cuenta, double importe, String codEmpl);
  
}

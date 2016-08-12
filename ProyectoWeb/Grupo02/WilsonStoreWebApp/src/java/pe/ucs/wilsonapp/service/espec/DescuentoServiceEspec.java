
package pe.ucs.wilsonapp.service.espec;

import java.util.Map;

public interface DescuentoServiceEspec {
    
  Map<String,Object> getDatosCuenta(String cuenta);
  
  void doDescuentoCliente(String DSCTO_ID, String CLI_ID, String DSCTO_FECHA, int DSCTO_PORC, String DSCTO_ESTADO);
}

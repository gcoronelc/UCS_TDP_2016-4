
package pe.ucs.wilsonapp.service.espec;

import pe.ucs.wilsonapp.domain.Cliente;

public interface ClienteServiceEspec 
    extends ServiceCrud<Cliente>, RowMapper<Cliente>{
    
    void doRegistroCliente(String ID, String RUC, String RAZONSOCIAL, String DIRECCION, String CORREO, String TELEFONO, String ESTADO);
}


package pe.ucs.wilsonapp.service.espec;

import pe.ucs.wilsonapp.domain.Vendedor;

public interface VendedorServiceEspec
extends ServiceCrud<Vendedor>, RowMapper<Vendedor>{
    
    void doRegistroVendedor(String ID, String NOMBRE, String ESTADO);
}

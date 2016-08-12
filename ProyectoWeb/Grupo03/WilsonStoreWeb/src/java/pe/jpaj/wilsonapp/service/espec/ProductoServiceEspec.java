/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.jpaj.wilsonapp.service.espec;

import java.util.List;
import pe.jpaj.wilsonapp.domain.Combo;
import pe.jpaj.wilsonapp.domain.Producto;

/**
 *
 * @author jcpr1994
 */
public interface ProductoServiceEspec 
    extends ServiceCrud<Producto>, RowMapper<Producto>{
    
    List<Combo> getCuentaCombo();
}

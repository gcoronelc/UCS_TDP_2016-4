/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor.Service.Espec;

import ClienteServidor.Domain.Combo;
import java.util.List;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public interface ComboServiceEspec extends RowMapper<Combo>{
  
  List<Combo> getCategorias();
  
}

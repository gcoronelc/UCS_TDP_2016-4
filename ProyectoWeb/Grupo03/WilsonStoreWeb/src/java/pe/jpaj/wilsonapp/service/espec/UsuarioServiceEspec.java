/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.jpaj.wilsonapp.service.espec;
import pe.jpaj.wilsonapp.domain.UsuarioDomain;
/**
 *
 * @author jcpr1994
 */
public interface UsuarioServiceEspec extends ServiceCrud<UsuarioDomain>, RowMapper<UsuarioDomain>{
      UsuarioDomain validar(String usuario, String clave);
}

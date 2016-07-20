/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package ClienteServidor.Service.Espec;

import ClienteServidor.Domain.Usuario;

public interface UsuarioServiceEspec 
        extends ServiceCrud<Usuario>, RowMapper<Usuario> {
  
    Usuario validar(String usuario, String clave);
}

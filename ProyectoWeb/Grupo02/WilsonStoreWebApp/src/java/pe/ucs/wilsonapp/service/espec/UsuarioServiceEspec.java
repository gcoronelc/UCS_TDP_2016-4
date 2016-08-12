package pe.ucs.wilsonapp.service.espec;

import pe.ucs.wilsonapp.domain.Usuario;

public interface UsuarioServiceEspec 
        extends ServiceCrud<Usuario>, RowMapper<Usuario> {
  
  Usuario validar(String Usuario_id, String Usuario_pass);
    
}

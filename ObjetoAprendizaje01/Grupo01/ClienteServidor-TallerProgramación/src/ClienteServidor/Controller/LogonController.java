/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package ClienteServidor.Controller;

import ClienteServidor.Domain.Usuario;
import ClienteServidor.Service.Espec.UsuarioServiceEspec;
import ClienteServidor.Service.Impl.UsuarioServiceImpl;
import ClienteServidor.Util.Memoria;

public class LogonController {

    public void validar(String usuario, String clave) {
        UsuarioServiceEspec service;
        service = new UsuarioServiceImpl();
        Usuario bean = service.validar(usuario, clave);
        Memoria.put("usuario", bean);
    }

}

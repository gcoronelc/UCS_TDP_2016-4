/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.service.espec;

import pe.ucsur.proyecto.domain.Usuarios;

/**
 *
 * @author Administrador
 */
public interface UsuariosServiceEspec
        extends ServiceCrud<Usuarios>, RowMapper<Usuarios>
{
    boolean validar(String Usuario, String contrasenia);
}

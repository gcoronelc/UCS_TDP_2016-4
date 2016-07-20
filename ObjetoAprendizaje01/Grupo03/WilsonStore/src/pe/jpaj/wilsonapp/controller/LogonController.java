/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.jpaj.wilsonapp.controller;

import pe.jpaj.wilsonapp.domain.UsuarioDomain;
import pe.jpaj.wilsonapp.service.espec.UsuarioServiceEspec;
import pe.jpaj.wilsonapp.service.impl.UsuarioServiceImpl;
import pe.jpaj.wilsonapp.util.Memoria;

/**
 *
 * @author jcpr1994
 */
public class LogonController {
    public void validar(String usuario, String clave) {
    UsuarioServiceEspec service;
    service = new UsuarioServiceImpl();
    UsuarioDomain bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
}

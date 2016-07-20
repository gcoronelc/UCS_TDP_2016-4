package pe.ucs.wilsonapp.controller;

import pe.ucs.wilsonapp.domain.Empleado;
import pe.ucs.wilsonapp.service.espec.EmpleadoServiceEspec;
import pe.ucs.wilsonapp.service.impl.EmpleadoServiceImpl;
import pe.ucs.wilsonapp.util.Memoria;

public class LogonController {
    
  public void validar(String usuario, String clave) {
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    Empleado bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
}

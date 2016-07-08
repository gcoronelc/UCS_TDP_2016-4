package pe.egcc.edutecapp.controller;

import pe.egcc.edutecapp.domain.Empleado;
import pe.egcc.edutecapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.edutecapp.service.impl.EmpleadoServiceImpl;
import pe.egcc.edutecapp.util.Memoria;

public class LogonController {

  public void validar(String usuario, String clave) {
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    Empleado bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
}

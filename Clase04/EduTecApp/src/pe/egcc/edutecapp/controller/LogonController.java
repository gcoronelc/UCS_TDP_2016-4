package pe.egcc.edutecapp.controller;

import pe.egcc.edutecapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.edutecapp.service.impl.EmpleadoServiceImpl;

public class LogonController {

  public void validar(String usuario, String clave) {
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    service.validar(usuario, clave);
  }
  
}

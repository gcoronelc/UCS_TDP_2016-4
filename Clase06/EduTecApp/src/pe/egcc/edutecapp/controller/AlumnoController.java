package pe.egcc.edutecapp.controller;

import java.util.List;
import pe.egcc.edutecapp.domain.Alumno;
import pe.egcc.edutecapp.service.espec.AlumnoServiceEspec;
import pe.egcc.edutecapp.service.impl.AlumnoServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class AlumnoController {
  
  private AlumnoServiceEspec service;

  public AlumnoController() {
    service = new AlumnoServiceImpl();
  }
  
  

  public List<Alumno> taerLista(Alumno bean) {
    return service.getRecords(bean);
  }
  
}

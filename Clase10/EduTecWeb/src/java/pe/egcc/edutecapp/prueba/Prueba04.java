package pe.egcc.edutecapp.prueba;

import pe.egcc.edutecapp.domain.Alumno;
import pe.egcc.edutecapp.service.espec.AlumnoServiceEspec;
import pe.egcc.edutecapp.service.espec.MatriculaServiceEspec;
import pe.egcc.edutecapp.service.impl.AlumnoServiceImpl;
import pe.egcc.edutecapp.service.impl.MatriculaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    
    try {
      Alumno bean = new Alumno();
      bean.setApellido("");
      bean.setNombre("");
      bean.setEmail("hotmail");
      AlumnoServiceEspec service;
      service = new AlumnoServiceImpl();
      for(Alumno a: service.getRecords(bean)){
        System.out.println(a.getApellido() 
                + " | " + a.getNombre() 
                + " | " + a.getEmail());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

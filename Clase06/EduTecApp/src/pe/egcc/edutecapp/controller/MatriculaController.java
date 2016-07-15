package pe.egcc.edutecapp.controller;

import pe.egcc.edutecapp.service.espec.MatriculaServiceEspec;
import pe.egcc.edutecapp.service.impl.MatriculaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class MatriculaController {

  private MatriculaServiceEspec service = null;

  public MatriculaController() {
    service = new MatriculaServiceImpl();
  }

  public void matricular(int idCursoProg, String idAlumno) {
    service.regMatricula(idCursoProg, idAlumno);
  }

}

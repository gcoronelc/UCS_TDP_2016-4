package pe.egcc.edutecapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.edutecapp.domain.Empleado;
import pe.egcc.edutecapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.edutecapp.service.impl.EmpleadoServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
@WebServlet(name = "LogonController", 
        urlPatterns = {"/LogonIngreso", "/LogonSalir"})
public class LogonController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/LogonIngreso")){
      logonIngreso(request,response);
    } 
  }

  private void logonIngreso(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Validar
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      Empleado bean = service.validar(usuario, clave);
      // Guardando usuario en session
      HttpSession session = request.getSession(true);
      session.setAttribute("usuario", bean);
      // Destino
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  
  
}
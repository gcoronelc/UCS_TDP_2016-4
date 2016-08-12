/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Domain.Usuario;
import Service.Espec.UsuarioServiceEspec;
import Service.Impl.UsuarioServiceImpl;


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
      UsuarioServiceEspec service;
      service = new UsuarioServiceImpl();
      Usuario bean = service.validar(usuario, clave);
      // Guardando usuario en session
      HttpSession session = request.getSession(true);
      session.setAttribute("usuario", bean);
      // Destino
      destino = "Home.jsp";
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

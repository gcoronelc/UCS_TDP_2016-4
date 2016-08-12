package pe.ucs.wilsonapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.ucs.wilsonapp.domain.Usuario;
import pe.ucs.wilsonapp.service.espec.UsuarioServiceEspec;
import pe.ucs.wilsonapp.service.impl.UsuarioServiceImpl;

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
      String Usuario_id = request.getParameter("Usuario_id");
      String Usuario_pass = request.getParameter("Usuario_pass");
      // Validar
      UsuarioServiceEspec service;
      service = new UsuarioServiceImpl();
      Usuario bean = service.validar(Usuario_id, Usuario_pass);
      
      //Guardando usuario en sessio
        HttpSession session = request.getSession(true);
        session.setAttribute("Usuario", bean);
      
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


    private void Salir(HttpServletRequest request, 
              HttpServletResponse response) 
              throws ServletException, IOException {
        
        String destino;
        destino = "index.jsp";
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    
    }
}

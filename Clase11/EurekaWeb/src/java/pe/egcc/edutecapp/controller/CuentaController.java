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
import pe.egcc.edutecapp.service.espec.CuentaServiceEspec;
import pe.egcc.edutecapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
@WebServlet(name = "CuentaController", 
        urlPatterns = {"/ProcDeposito", "/aaa", "/bbb"})
public class CuentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/ProcDeposito")){
      procDeposito(request,response);
    }
    
  }

  private void procDeposito(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos del formulario
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Empleado
      HttpSession session = request.getSession();
      Empleado usuario = (Empleado) session.getAttribute("usuario");
      // Proceso
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      service.doDeposito(cuenta, importe, usuario.getCodigo());
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procDeposito.jsp");
    rd.forward(request, response);
  }

  
  
}
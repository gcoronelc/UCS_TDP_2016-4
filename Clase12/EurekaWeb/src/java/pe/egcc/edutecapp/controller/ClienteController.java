package pe.egcc.edutecapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.edutecapp.domain.Cliente;
import pe.egcc.edutecapp.service.espec.ClienteServiceEspec;
import pe.egcc.edutecapp.service.impl.ClienteServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
@WebServlet(name = "ClienteController", 
        urlPatterns = {"/ClienteController","/ClienteEditar"})
public class ClienteController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/ClienteController")){
      if(request.getParameter("btnConsultar") != null){
        consultar(request,response);
      }
    }
  }

  private void consultar(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos
      Cliente bean = new Cliente();
      bean.setCodigo(request.getParameter("codigo"));
      bean.setPaterno(request.getParameter("paterno"));
      bean.setMaterno(request.getParameter("materno"));
      bean.setNombre(request.getParameter("nombre"));
      // Proceso
      ClienteServiceEspec service = new ClienteServiceImpl();
      List<Cliente> lista = service.getRecords(bean);
      request.setAttribute("bean", bean);
      if(!lista.isEmpty()){
        request.setAttribute("lista", lista);
      }
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("mantClientes.jsp");
    rd.forward(request, response);
  }

  
  
}
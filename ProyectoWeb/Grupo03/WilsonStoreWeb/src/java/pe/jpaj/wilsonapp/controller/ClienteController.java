package pe.jpaj.wilsonapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.jpaj.wilsonapp.domain.Cliente;
import pe.jpaj.wilsonapp.service.espec.ClienteServiceEspec;
import pe.jpaj.wilsonapp.service.impl.ClienteServiceImpl;


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
      if(request.getParameter("btnCrear") != null){
        crear(request,response);
      }
      if(request.getParameter("btnNuevo") != null){
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("crearCliente.jsp");
        rd.forward(request, response);
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
    rd = request.getRequestDispatcher("mantCliente.jsp");
    rd.forward(request, response);
  }
  private void crear(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos
      Cliente bean = new Cliente();
      bean.setCodigo(request.getParameter("codigo"));
      bean.setPaterno(request.getParameter("paterno"));
      bean.setMaterno(request.getParameter("materno"));
      bean.setNombre(request.getParameter("nombre"));
      bean.setDni(request.getParameter("dni"));
      bean.setEmail(request.getParameter("email"));
      bean.setDireccion(request.getParameter("direccion"));
      bean.setCiudad(request.getParameter("ciudad"));
      bean.setTelefono(request.getParameter("telefono"));
      
      // Proceso
      ClienteServiceEspec service = new ClienteServiceImpl();
      service.insert(bean);
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("crearCliente.jsp");
    rd.forward(request, response);
  }
  
  
}
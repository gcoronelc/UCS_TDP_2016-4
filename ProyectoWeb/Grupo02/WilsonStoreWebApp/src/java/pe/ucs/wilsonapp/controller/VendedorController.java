
package pe.ucs.wilsonapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.ucs.wilsonapp.domain.Vendedor;
import pe.ucs.wilsonapp.service.espec.VendedorServiceEspec;
import pe.ucs.wilsonapp.service.impl.VendedorServiceImpl;

@WebServlet(name = "VendedorController",
        urlPatterns = {"/VendedorController","/VendedorEditar","/VendedorInsert"})
public class VendedorController extends HttpServlet {
    
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/VendedorController")){
        if(request.getParameter("btnConsultar") != null){
          consultar(request,response);
      }
        if(request.getParameter("btnNuevo") != null){
          Nuevo(request,response);
      }
    }
    if(path.equals("/VendedorInsert")){
        if(request.getParameter("btnGrabar") != null){
        VendedorInsert(request,response);        
      }
    if(request.getParameter("btnNuevo") != null){
          NuevoRegistro(request,response);
      }    
    }
  }

  private void consultar(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos
    //String dateString = request.getParameter("FECHAREGISTRO");
    //java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
    //java.util.Date d = df.parse(dateString);
      
      Vendedor bean = new Vendedor();
      bean.setID(request.getParameter("ID"));
      bean.setNOMBRE(request.getParameter("NOMBRE"));
      bean.setESTADO(request.getParameter("ESTADO"));
      
      // Proceso
      VendedorServiceEspec service = new VendedorServiceImpl();
      List<Vendedor> lista = service.getRecords(bean);
      request.setAttribute("bean", bean);
      if(!lista.isEmpty()){
        request.setAttribute("lista", lista);
      }
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("mantVendedor.jsp");
    rd.forward(request, response);
  }
  
  private void Nuevo(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
                    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("mantVendedor.jsp");
    rd.forward(request, response);
  }
  
  private void VendedorInsert(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos del formulario
      String ID  = request.getParameter("ID");
      String NOMBRE = request.getParameter("NOMBRE");
      String ESTADO = request.getParameter("ESTADO");
      
      // Empleado
//      HttpSession session = request.getSession();
//      Empleado usuario = (Empleado) session.getAttribute("usuario");
      // Proceso
      VendedorServiceEspec vendedor;
      vendedor = new VendedorServiceImpl();
      vendedor.doRegistroVendedor(ID, NOMBRE, ESTADO);
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("VendedorInsert.jsp");
    rd.forward(request, response);
  }

  
  private void NuevoRegistro(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
                    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("VendedorInsert.jsp");
    rd.forward(request, response);
  }
}


package pe.ucs.wilsonapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.ucs.wilsonapp.domain.Cliente;
import pe.ucs.wilsonapp.service.espec.ClienteServiceEspec;
import pe.ucs.wilsonapp.service.impl.ClienteServiceImpl;

@WebServlet(name = "ClienteController",
        urlPatterns = {"/ClienteController","/ClienteEditar","/ClienteInsert"})
public class ClienteController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/ClienteController")){
      if(request.getParameter("btnConsultar") != null){
        consultar(request,response);
      }
      if(request.getParameter("btnNuevo") != null){
        Nuevo(request,response);
      }         
    }
    if(path.equals("/ClienteInsert")){
        if(request.getParameter("btnGrabar") != null){
        ClienteInsert(request,response);        
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
//    String dateString = request.getParameter("FECHAREGISTRO");
//    java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
//    java.util.Date d = df.parse(dateString);
      
      Cliente bean = new Cliente();
      //bean.setID(Integer.parseInt(request.getParameter("ID")));
      bean.setRUC(request.getParameter("RUC"));
      bean.setRAZONSOCIAL(request.getParameter("RAZONSOCIAL"));
      bean.setDIRECCION(request.getParameter("DIRECCION"));
//      bean.setCORREO(request.getParameter("CORREO"));
//      bean.setTELEFONO(request.getParameter("TELEFONO"));
//      bean.setFECHAREGISTRO((Date) d);
//      bean.setESTADO(request.getParameter("ESTADO"));
      
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
  
  private void Nuevo(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
                    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("mantCliente.jsp");
    rd.forward(request, response);
  }
  
  private void NuevoRegistro(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
                    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("ClienteInsert.jsp");
    rd.forward(request, response);
  }
  
  private void ClienteInsert(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos del formulario
      String ID  = request.getParameter("ID");
      String RUC = request.getParameter("RUC");
      String RAZONSOCIAL = request.getParameter("RAZONSOCIAL");
      String DIRECCION = request.getParameter("DIRECCION");
      String CORREO = request.getParameter("CORREO");
      String TELEFONO = request.getParameter("TELEFONO");
      String ESTADO = request.getParameter("ESTADO");
      
      // Empleado
//      HttpSession session = request.getSession();
//      Empleado usuario = (Empleado) session.getAttribute("usuario");
      // Proceso
      ClienteServiceEspec cliente;
      cliente = new ClienteServiceImpl();
      cliente.doRegistroCliente(ID, RUC, RAZONSOCIAL,DIRECCION,CORREO,TELEFONO,ESTADO);
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("ClienteInsert.jsp");
    rd.forward(request, response);
  }
 
  
}

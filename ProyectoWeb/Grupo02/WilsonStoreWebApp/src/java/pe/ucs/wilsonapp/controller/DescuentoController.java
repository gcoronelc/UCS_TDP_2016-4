
package pe.ucs.wilsonapp.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.ucs.wilsonapp.domain.Cliente;
import pe.ucs.wilsonapp.service.espec.DescuentoServiceEspec;
import pe.ucs.wilsonapp.service.impl.DescuentoServiceImpl;


@WebServlet(name = "DescuentoController", 
        urlPatterns = {"/DescuentoController", "/ProcDescuento", "/bbb"})
public class DescuentoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/ProcDescuento")){
        if(request.getParameter("btnGrabar") != null){
          DescuentoInsert(request,response);
      }       
    }        
}
  
  private void DescuentoInsert(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos del formulario
      String DSCTO_ID  = request.getParameter("DSCTO_ID");
      String CLI_ID = request.getParameter("CLI_ID");
      String DSCTO_FECHA = request.getParameter("DSCTO_FECHA");
      String DSCTO_PORC = request.getParameter("DSCTO_PORC");
      String DSCTO_ESTADO = request.getParameter("DSCTO_ESTADO");
      
      
      // Empleado
//      HttpSession session = request.getSession();
//      Empleado usuario = (Empleado) session.getAttribute("usuario");
      // Proceso
      DescuentoServiceEspec descuento;
      descuento = new DescuentoServiceImpl();
      descuento.doDescuentoCliente(DSCTO_ID, CLI_ID, DSCTO_FECHA, Integer.parseInt(DSCTO_PORC), DSCTO_ESTADO);
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procDescuento.jsp");
    rd.forward(request, response);
  }
  
}

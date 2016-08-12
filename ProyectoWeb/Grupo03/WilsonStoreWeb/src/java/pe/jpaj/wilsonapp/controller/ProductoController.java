package pe.jpaj.wilsonapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.jpaj.wilsonapp.domain.Combo;
import pe.jpaj.wilsonapp.domain.Producto;
import pe.jpaj.wilsonapp.service.espec.ProductoServiceEspec;
import pe.jpaj.wilsonapp.service.impl.ProductoServiceImpl;



/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
@WebServlet(name = "ProductoController", 
        urlPatterns = {"/ProductoController","/ProductoControllerSave"})
public class ProductoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
            if(path.equals("/ProductoController")){
          if(request.getParameter("btnConsultar") != null){
            consultar(request,response);
          }
          if(request.getParameter("btnCrear") != null){
            ProductoControllerSave(request,response);
          }
          if(request.getParameter("btnNuevo") != null){
            ProductoControllerLoad(request,response);
          }
     
    }
    
  }

  private void consultar(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos
      Producto bean = new Producto();
      bean.setNombre(request.getParameter("nombre"));
      // Proceso
      ProductoServiceEspec service = new ProductoServiceImpl();
      List<Producto> lista = service.getRecords(bean);
      request.setAttribute("bean", bean);
      if(!lista.isEmpty()){
        request.setAttribute("lista", lista);
      }
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("mantProducto.jsp");
    rd.forward(request, response);
  }
  private void crear(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos
      Producto bean = new Producto();
      bean.setTp_producto(Integer.parseInt(request.getParameter("tp_producto")));
      bean.setNombre(request.getParameter("nombre"));
      bean.setDescripcion(request.getParameter("descripcion"));
      bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
      bean.setStock(Integer.parseInt(request.getParameter("stock")));
      bean.setStock_min(Integer.parseInt(request.getParameter("stock_min")));
      
      // Proceso
      ProductoServiceEspec service = new ProductoServiceImpl();
      service.insert(bean);
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("crearProducto.jsp");
    rd.forward(request, response);
  }
  
  private void ProductoControllerSave(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos del formulario
      Producto bean = new Producto();
      bean.setTp_producto(Integer.parseInt(request.getParameter("tp_producto")));
      bean.setNombre(request.getParameter("nombre"));
      bean.setDescripcion(request.getParameter("descripcion"));
      bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
      bean.setStock(Integer.parseInt(request.getParameter("stock")));
      bean.setStock_min(Integer.parseInt(request.getParameter("stock_min")));
      // Proceso
      ProductoServiceEspec service = new ProductoServiceImpl();
      service.insert(bean);
      request.setAttribute("info", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    /*
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procDeposito.jsp");
    rd.forward(request, response);
    */
    ProductoControllerLoad(request, response);
  }
  
  
  
  private void ProductoControllerLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Combo> tipos = null;
    try {
      ProductoServiceEspec service = new ProductoServiceImpl();
      tipos = service.getCuentaCombo();
      request.setAttribute("tipos", tipos);
      
    } catch (Exception e) {
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("crearProducto.jsp");
    rd.forward(request, response);
  }
  
}
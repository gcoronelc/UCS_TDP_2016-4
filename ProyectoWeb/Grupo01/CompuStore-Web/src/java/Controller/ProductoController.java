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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Domain.Producto;

import Service.Espec.ProductoServiceEspec;

import Service.Impl.ProductoServiceImpl;

@WebServlet(name = "ProductoController",
        urlPatterns = {"/ProductoController", "/ProductoEditar"})
public class ProductoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/ProductoController")) {
            if (request.getParameter("btnConsultar") != null) {
                consultar(request, response);
            }

        }
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Datos
            Producto bean = new Producto();
            bean.setNombre(request.getParameter("nombre"));
            ProductoServiceEspec service = new ProductoServiceImpl();
            // ProcesoceImpl();
            List<Producto> lista = service.getRecords(bean);
            request.setAttribute("bean", bean);
            if (!lista.isEmpty()) {
                request.setAttribute("lista", lista);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("MantProductos.jsp");
        rd.forward(request, response);
    }

}

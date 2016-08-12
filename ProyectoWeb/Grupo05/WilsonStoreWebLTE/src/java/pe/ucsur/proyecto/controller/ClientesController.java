package pe.ucsur.proyecto.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.ucsur.proyecto.domain.Clientes;
//import pe.ucsur.proyecto.service.espec.ClientesServiceEspec;
import pe.ucsur.proyecto.service.impl.ClienteServiceImpl;

@WebServlet(name = "ClienteController", 
        urlPatterns = {"/ClienteController","/ClienteEditar"})
public class ClientesController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        if (path.equals("/ClienteController")){
            if (request.getParameter("btnConsultar") !=null){
                consultar(request, response);
            }
            else if (request.getParameter("btnNuevo")!=null){
                nuevoCliente(request, response);
            }
        }
        
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //Datos
        try {
            Clientes bean=new Clientes();
            String codigo=request.getParameter("txtcodigo");
            if (codigo=="") {
                bean.setIdcliente(0);
            }
            else
            {
                bean.setIdcliente(Integer.parseInt(request.getParameter("txtcodigo")));    
            }
            
            bean.setApellidomaterno(request.getParameter("txtmaterno"));
            bean.setApellidopaterno(request.getParameter("txtpaterno"));
            bean.setNombres(request.getParameter("txtnombres"));
            //Proceso
            ClienteServiceImpl service=new ClienteServiceImpl();
            List<Clientes> lista=service.getRecords(bean);
            request.setAttribute("bean", bean);
            if (!lista.isEmpty()){
                request.setAttribute("lista", lista);
            }            
        }
        catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        }
        //Forward
        RequestDispatcher rd;
    rd = request.getRequestDispatcher("mantenimientoClientes.jsp");
    rd.forward(request, response);

        
    }

    private void nuevoCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            //Datos del formulario
            int idCliente=Integer.parseInt(request.getParameter("txtcodigo"));
            String Nombres=request.getParameter("txtnombres");
            String ApePa=request.getParameter("txtpaterno");
            String ApeMa=request.getParameter("txtmaterno");
            //Proceso
            ClienteServiceImpl service;
            service=new ClienteServiceImpl();
            service.doNuevo(idCliente, Nombres, ApePa, ApeMa);
            request.setAttribute("info", "Proceso ejecutado correctamente.");
        }
        catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        }
        //Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("mantenimientoClientes.jsp");
        rd.forward(request, response);
    }
    
}

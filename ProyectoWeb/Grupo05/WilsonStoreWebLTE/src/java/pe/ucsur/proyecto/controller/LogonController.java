/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.ucsur.proyecto.service.espec.UsuariosServiceEspec;
import pe.ucsur.proyecto.service.impl.UsuariosServiceImpl;
import pe.ucsur.proyecto.domain.Usuarios;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "LogonController", urlPatterns = {"/LogonIngreso", "/LogonSalir"})
public class LogonController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        if (path.equals("/LogonIngreso")){
            logonIngreso(request, response);
        }
    }

    private void logonIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        try {
            //Datos
            String usuario=request.getParameter("usuario");
            String clave=request.getParameter("clave");
            //Validar
            UsuariosServiceEspec service;
            service=new UsuariosServiceImpl();
            //service.validar(usuario, clave);
            Usuarios bean= service.InfoUsuario(usuario, clave);
            
            HttpSession session=request.getSession(true);
            session.setAttribute("usuarios", bean);
            
            destino="principal.jsp";
            
            if (bean==null)
            {
                destino="login.jsp";
                request.setAttribute("error", "Datos ingresados no validos");
            }
            
        }
        catch(Exception ex){
            request.setAttribute("error", ex.getMessage());
            destino="login.jsp";
        }
        //Forward
        RequestDispatcher rd;
        rd=request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    
    
}

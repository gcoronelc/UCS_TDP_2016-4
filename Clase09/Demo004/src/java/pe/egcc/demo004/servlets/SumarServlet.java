package pe.egcc.demo004.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( urlPatterns = "/SumarServlet")
public class SumarServlet extends HttpServlet{

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    
    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    
    // Proceso
    int suma = n1 + n2;
    
    // Salida, se utiliza session como ilustración
    HttpSession session = request.getSession(true);
    session.setAttribute("n1", n1);
    session.setAttribute("n2", n2);
    session.setAttribute("suma", suma);
    
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("salida2.jsp");
    rd.forward(request, response);
  }
  
}

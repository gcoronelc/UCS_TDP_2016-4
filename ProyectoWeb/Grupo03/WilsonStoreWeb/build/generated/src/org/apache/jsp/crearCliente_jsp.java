package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"misestilos.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\t\t\n");
      out.write("\t\t<ul id=\"main-nav\">\n");
      out.write("\t <li><a href=\"Proceso\" title=\"Proceso\">Proceso</a>\n");
      out.write("\t  <ul>\n");
      out.write("\t   <li><a href=\"1\" title=\"1\">1</a></li>\n");
      out.write("\t  </ul>\n");
      out.write("\t </li>\n");
      out.write("\t <li><a href=\"Tablas\" title=\"Tablas\">Tablas</a>\n");
      out.write("\t  <ul>\n");
      out.write("\t   <li><a href=\"mantCliente.jsp\" title=\"Clientes\">Clientes</a></li>\n");
      out.write("\t  </ul>\n");
      out.write("\t </li>\n");
      out.write("\t <li><a href=\"Consultas\" title=\"Consultas\">Consultas</a>\n");
      out.write("\t  <ul>\n");
      out.write("\t   <li><a href=\"3\" title=\"3\">3</a></li>\n");
      out.write("\t  </ul>\n");
      out.write("\t </li>\n");
      out.write("\t <li><a href=\"Reportes\" title=\"Reportes\">Reportes</a>\n");
      out.write("\t  <ul>\n");
      out.write("\t   <li><a href=\"4\" title=\"4\">4</a></li>\n");
      out.write("\t  </ul>\n");
      out.write("\t </li>\n");
      out.write("\t <li><a href=\"Util\" title=\"Util\">Util</a>\n");
      out.write("\t  <ul>\n");
      out.write("\t   <li><a href=\"5\" title=\"5\">5</a></li>\n");
      out.write("\t  </ul>\n");
      out.write("\t </li>\n");
      out.write("\t</ul>\n");
      out.write("\t<h1>MANTENIMIENTO DE CLIENTES</h1>\n");
      out.write("        <form method=\"post\" action=\"ClienteController\">\n");
      out.write("          <table>\n");
      out.write("            <tr>\n");
      out.write("              <td>CODIGO</td>\n");
      out.write("              <td><input type=\"text\" name=\"codigo\" size=\"10\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.codigo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>PATERNO</td>\n");
      out.write("              <td><input type=\"text\" name=\"paterno\" size=\"20\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.paterno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>MATERNO</td>\n");
      out.write("              <td><input type=\"text\" name=\"materno\" size=\"20\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.materno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>NOMBRE</td>\n");
      out.write("              <td><input type=\"text\" name=\"nombre\" size=\"20\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>DNI</td>\n");
      out.write("              <td><input type=\"text\" name=\"dni\" size=\"8\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.dni}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>EMAIL</td>\n");
      out.write("              <td><input type=\"text\" name=\"email\" size=\"50\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>DIRECCION</td>\n");
      out.write("              <td><input type=\"text\" name=\"direccion\" size=\"50\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.direccion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>CIUDAD</td>\n");
      out.write("              <td><input type=\"text\" name=\"ciudad\" size=\"10\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.ciudad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("             <tr>\n");
      out.write("              <td>TELEFONO</td>\n");
      out.write("              <td><input type=\"text\" name=\"telefono\" size=\"10\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bean.telefono}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <TR>\n");
      out.write("               <td rowspan=\"1\" style=\"vertical-align: bottom;\">\n");
      out.write("               <input type=\"submit\" name=\"btnCrear\" value=\"Crear\" />\n");
      out.write("               </td>\n");
      out.write("            </TR>\n");
      out.write("          </table>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

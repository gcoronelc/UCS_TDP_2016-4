package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Proyecto</title>\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"reset.css\">\n");
      out.write("\t\t\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("\t\t\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"misestilos.css\">\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- varia el width para que ocupe el ancho deseado 50% ocupara la mitad -->\n");
      out.write("\t\t<style>\t\n");
      out.write("\t\t  .carousel-inner > .item > img,\n");
      out.write("\t\t  .carousel-inner > .item > a > img {\n");
      out.write("\t\t\t  width: 100%;\n");
      out.write("\t\t\t  margin: auto;\n");
      out.write("\t\t  }\n");
      out.write("\t\t </style>\n");
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<div class=\"container\" id=\"container1\">\n");
      out.write("\t\t\t<!--col-xs-n Para Celulares\n");
      out.write("\t\t\t\tcol-sm-n Para Tablets\n");
      out.write("\t\t\t\tcol-md-n Para Desktop\n");
      out.write("\t\t\t\tcol-lg-n Para Desktop Pantalla Grande\n");
      out.write("\t\t\t\tDonde \"n\" es el numero de columnas maximo 12\n");
      out.write("\t\t\t\tEn cada fila, las suma de \"n\" para cada dispositivo debe ser 12\n");
      out.write("\t\t\t-->\n");
      out.write("\t\t\t<!--Cabecera Banner-->\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\n");
      out.write("\t\t\t\t\t<div class=\"container\" id=\"carrusel\">\n");
      out.write("\t\t\t\t\t<!-- Inicio Slider -->\n");
      out.write("\t\t\t\t\t<section id=\"mislide\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("\t\t\t\t\t\t<ol class=\"carousel-indicators\">\n");
      out.write("\t\t\t\t\t\t\t<li data-target=\"#mislide\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li data-target=\"#mislide\" data-slide-to=\"1\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li data-target=\"#mislide\" data-slide-to=\"2\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li data-target=\"#mislide\" data-slide-to=\"3\"></li>\n");
      out.write("\t\t\t\t\t\t</ol>\n");
      out.write("\t\t\t\t\t\t<div class=\"carousel-inner\">\n");
      out.write("\t\t\t\t\t\t\t<!-- Coloca aqui tus imagenes -->\n");
      out.write("\t\t\t\t\t\t\t<div class=\"item active\">\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"imagenes/mono.jpg\" alt=\"Mono Titi\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"item\">\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"imagenes/yacare.jpg\" alt=\"Yacare\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"item\">\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"imagenes/ciervo.jpg\" alt=\"Ciervo\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"item\">\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"imagenes/oso.jpg\" alt=\"Oso Hormiguero\">\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<a href=\"#mislide\" class=\"left carousel-control\" data-slide=\"prev\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a>\n");
      out.write("\t\t\t\t\t\t<a href=\"#mislide\" class=\"right carousel-control\" data-slide=\"next\"><span class=\"glyphicon glyphicon-chevron-right\"></span></a>\n");
      out.write("\t\t\t\t\t</section><br>\n");
      out.write("\t\t\t\t\t<!-- Fin Slider -->\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!--Fin Cabecera Banner-->\n");
      out.write("\t\t\t<!--Barra de Navegacion -->\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\n");
      out.write("\t\t\t\t\t<nav class=\"navbar navbar-inverse\" role=\"navigation\">\n");
      out.write("\t\t\t\t\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#acolapsar\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"sr-only\">Toggle Navigation</span>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"index.html\" class=\"navbar-brand\">Mi Proyecto</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"acolapsar\">\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"index.html\"><span class=\"glyphicon glyphicon-home\"></span> Inicio</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"servicios.html\"><span class=\"glyphicon glyphicon-cog\"></span> Servicios</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"productos.html\"><span class=\"glyphicon glyphicon-cloud\"></span> Productos</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"nosotros.html\"><span class=\"glyphicon glyphicon-download-alt\"></span> Nosotros</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"contacto.html\"><span class=\"glyphicon glyphicon-download-alt\"></span> Contacto</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!--Fin Barra de Navegacion -->\n");
      out.write("\t\t\t<!--Cuerpo -->\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<!--Columna Principal -->\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-12 col-md-9 col-lg-9\">\n");
      out.write("\t\t\t\t\t<div id=\"formulario\">\n");
      out.write("\t\t\t\t\t\t<form class=\"form-inline\" role=\"form\" action=\"LogonIngreso\" method=\"POST\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"nombre\">Usuario</label>\n");
      out.write("\t\t\t\t\t\t\t<input class=\"form-control\" name=\"usuario\" type=\"text\" required=\"required\" id=\"usuario\" placeholder=\"usuario\" tabindex=\"1\" title=\"usuario\">\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t<label for=\"email\">Clave</label>\n");
      out.write("\t\t\t\t\t\t\t<input class=\"form-control\" name=\"clave\" type=\"password\" required=\"required\" id=\"clave\" placeholder=\"clave\" tabindex=\"2\" title=\"clave\">\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t<input class=\"btn btn-primary\" type=\"submit\" name=\"enviar\" tabindex=\"7\" value=\"Enviar\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"estado\" value=\"1\">\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<!--Columna de publicidad -->\n");
      out.write("\t\t\t\t<div class=\"hidden-xs hidden-sm col-md-3 col-lg-3\">\n");
      out.write("\t\t\t\t\t<div id=\"publicidad\">\n");
      out.write("\t\t\t\t\t\t<h1>Publicidad</h1>\n");
      out.write("\t\t\t\t\t\t<img src=\"imagenes/nina_alpaca.jpg\" class=\"img-responsive\"></img>\n");
      out.write("\t\t\t\t\t\t<p>Con estas razones perdía el pobre caballero el juicio, y desvelábase por entenderlas y desentrañarles el sentido, que no se lo sacara ni las entendiera el mesmo Aristóteles, si resucitara para sólo ello. No estaba muy bien con las heridas que don Belianís daba y recebía, porque se imaginaba que, por grandes maestros que le hubiesen curado, no dejaría de tener el rostro y todo el cuerpo lleno de cicatrices y señales. </p>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!--Fin Cuerpo -->\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--Pie de pagina -->\n");
      out.write("\t\t<div class=\"container\" id=\"container2\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\n");
      out.write("\t\t\t\t\t<h5 id=\"pie\">Derechos reservados &copy Lima Perú</h5>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--Fin Pie de pagina -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Aumenta el interval para hacer mas lento la transicion o disminuyelo para hacerlo mas rapido -->\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\t$('.carousel').carousel({\n");
      out.write("\t\t\t\tinterval:5000\n");
      out.write("\t\t\t})\n");
      out.write("\t\t</script>\n");
      out.write("\t</body>\n");
      out.write("</html>");
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

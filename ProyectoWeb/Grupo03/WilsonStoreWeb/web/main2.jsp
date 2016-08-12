<%-- 
    Document   : main
    Created on : 26/07/2016, 08:36:13 PM
    Author     : jcpr1994
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="misestilos.css">
        <title>JSP Page</title>
    </head>

    <body>
		
		<ul id="main-nav">
	 <li><a href="Proceso" title="Proceso">Proceso</a>
	  <ul>
	   <li><a href="1" title="1">1</a></li>
	  </ul>
	 </li>
	 <li><a href="Tablas" title="Tablas">Tablas</a>
	  <ul>
	   <li><a href="mantCliente.jsp" title="Clientes">Clientes</a></li>
	  </ul>
	 </li>
	 <li><a href="Consultas" title="Consultas">Consultas</a>
	  <ul>
	   <li><a href="3" title="3">3</a></li>
	  </ul>
	 </li>
	 <li><a href="Reportes" title="Reportes">Reportes</a>
	  <ul>
	   <li><a href="4" title="4">4</a></li>
	  </ul>
	 </li>
	 <li><a href="Util" title="Util">Util</a>
	  <ul>
	   <li><a href="5" title="5">5</a></li>
	  </ul>
	 </li>
	</ul>
	
        <h1>Logonasdhasmdvahksd</h1>
        <p>Usuario: ${sessionScope.usuario.nombre}</p>
    </body>
</html>

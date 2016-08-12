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
	<h1>MANTENIMIENTO DE CLIENTES</h1>
        <form method="post" action="ClienteController">
          <table>
            <tr>
              <td>CODIGO</td>
              <td><input type="text" name="codigo" size="10" value="${requestScope.bean.codigo}"/></td>
            </tr>
            <tr>
              <td>PATERNO</td>
              <td><input type="text" name="paterno" size="20" value="${requestScope.bean.paterno}"/></td>
            </tr>
            <tr>
              <td>MATERNO</td>
              <td><input type="text" name="materno" size="20" value="${requestScope.bean.materno}"/></td>
            </tr>
            <tr>
              <td>NOMBRE</td>
              <td><input type="text" name="nombre" size="20" value="${requestScope.bean.nombre}"/></td>
            </tr>
            <tr>
              <td>DNI</td>
              <td><input type="text" name="dni" size="8" value="${requestScope.bean.dni}"/></td>
            </tr>
            <tr>
              <td>EMAIL</td>
              <td><input type="text" name="email" size="50" value="${requestScope.bean.email}"/></td>
            </tr>
            <tr>
              <td>DIRECCION</td>
              <td><input type="text" name="direccion" size="50" value="${requestScope.bean.direccion}"/></td>
            </tr>
            <tr>
              <td>CIUDAD</td>
              <td><input type="text" name="ciudad" size="10" value="${requestScope.bean.ciudad}"/></td>
            </tr>
             <tr>
              <td>TELEFONO</td>
              <td><input type="text" name="telefono" size="10" value="${requestScope.bean.telefono}"/></td>
            </tr>
            <TR>
               <td rowspan="1" style="vertical-align: bottom;">
               <input type="submit" name="btnCrear" value="Crear" />
               </td>
            </TR>
          </table>
        </form>
        
    </body>
</html>

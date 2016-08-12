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
              <td>PATERNO</td>
              <td>MATERNO</td>
              <td>NOMBRE</td>
              <td rowspan="2" style="vertical-align: bottom;">
                <input type="submit" name="btnConsultar" value="Consultar" />                
                <input type="submit" name="btnNuevo" value="Nuevo" />                
              </td>
            </tr>
            <tr>
              <td><input type="text" name="codigo" size="10" value="${requestScope.bean.codigo}"/></td>
              <td><input type="text" name="paterno" size="20" value="${requestScope.bean.paterno}"/></td>
              <td><input type="text" name="materno" size="20" value="${requestScope.bean.materno}"/></td>
              <td><input type="text" name="nombre" size="20" value="${requestScope.bean.nombre}"/></td>
            </tr>
          </table>
        </form>
        
        <!-- Resultado -->
        <c:if test="${requestScope.lista != null}">
          <table border="1">
            <tr>
              <th>CODIGO</th>
              <th>PATERNO</th>
              <th>MATERNO</th>
              <th>NOMBRE</th>
              <th>DNI</th>
              <th>EMAIL</th>
            </tr>
            
            <c:forEach items="${requestScope.lista}" var="r">
              <tr>
                <td>${r.codigo}</td>
                <td>${r.paterno}</td>
                <td>${r.materno}</td>
                <td>${r.nombre}</td>
                <td>${r.dni}</td>
                <td>${r.email}</td>
              </tr>
            </c:forEach>
          </table>
        </c:if>
    </body>
</html>

<%-- 
    Document   : main
    Created on : 21-jul-2016, 22:25:54
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
  </head>
  <body>
    <div class="egcc_page">
      
      <div class="egcc_header">
        <jsp:include page="header.jsp" />
      </div>
      
      <div class="egcc_menu">
        <jsp:include page="menu/menu.jsp" />
      </div>
      
      <div class="egcc_work">
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
      </div>
      
    </div>
  </body>
</html>

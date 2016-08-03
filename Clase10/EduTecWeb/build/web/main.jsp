<%-- 
    Document   : main
    Created on : 21-jul-2016, 22:25:54
    Author     : Docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hola Mundo</h1>
    <p>Usuario: ${sessionScope.usuario.nombre} </p>
  </body>
</html>

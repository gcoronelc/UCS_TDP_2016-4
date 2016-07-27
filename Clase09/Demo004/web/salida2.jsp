<%-- 
    Document   : salida1
    Created on : 26-jul-2016, 20:03:06
    Author     : Docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>SUMA</h1>
    <p>Con JSTL</p>
    <p>Número 1: ${sessionScope.n1}</p>
    <p>Número 2: ${sessionScope.n2}</p>
    <p>Suma: ${sessionScope.suma}</p>
    <a href="index.jsp">Retornar</a>
  </body>
</html>

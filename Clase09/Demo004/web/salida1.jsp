<%-- 
    Document   : salida1
    Created on : 26-jul-2016, 20:03:06
    Author     : Docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>SUMA</h1>
    <p>Número 1: <%= session.getAttribute("n1") %></p>
    <p>Número 2: <%= session.getAttribute("n2") %></p>
    <p>Suma: <%= session.getAttribute("suma") %></p>
    <a href="index.jsp">Retornar</a>
  </body>
</html>

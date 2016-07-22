<%-- 
    Document   : index
    Created on : 21-jul-2016, 20:15:21
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
    <h1>SUMA DE DOS NUMEROS</h1>
    <form method="post" action="SumarServlet">
      
      <p>
        Número 1:
        <input type="text" name="num1" />
      </p>
      <p>
        Número 2:
        <input type="text" name="num2" />
      </p>
      <p>
        <input type="submit" value="Procesar" />
      </p>
      
    </form>
    
    <c:if test="${requestScope.suma != null}">
      <h2>RESULTADO</h2>
      <p>Número 1: ${requestScope.n1}</p>
      <p>Número 2: ${requestScope.n2}</p>
      <p>Suma: ${requestScope.suma}</p>
    </c:if>
    
  </body>
</html>

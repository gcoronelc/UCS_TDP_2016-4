<%-- 
    Document   : index
    Created on : 26-jul-2016, 19:42:15
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
  </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recuperar Contraseña </title>
  </head>
  <body bgcolor="#e9bb18">
  <body>
    <p>${requestScope.error}</p>
    <form method="post" action="LogonIngreso">
      <table>
        <tr>
          <td rowspan="3">
            <img src="img/log_aplicacion.jpg" />
          </td>
        <td>Usuario</td>
          <td><input type="text" name="UsuNombre" /></td>
        </tr>
        <tr>
      
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="ENVIAR"/></td>
             </tr>
        <tr>
           </tr>
      </table>
        <p>
      <a href="index.jsp">Iniciar Sesión</a>
    </form>
  </body>
</html>

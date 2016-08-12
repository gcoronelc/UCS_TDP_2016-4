<%-- 
 
 ================================================================
 =                       GRUPO 4
 =      INTEGRANTES:
 =                 CHAVEZ PACHECO VICTOR
 =                 PORTOCARRERO MIRANDA PERCY
 ================================================================
 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema Web de Mantenimiento - Inicio de Sesion</title>
  </head>
  <body bgcolor="#888d36">
  <body>
    <h1>INGRESO - TIENDA VIRTUAL</h1>
    <p>${requestScope.error}</p>
    <form method="post" action="LogonIngreso">
      <table>
        <tr>
          <td rowspan="3">
            <img src="img/user_login2.png" />
          </td>
        <td>Usuario</td>
          <td><input type="text" name="usuario" /></td>
        </tr>
        <tr>
          <td>Clave</td>
          <td><input type="password" name="clave" /></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Iniciar Sesión"/></td>
             </tr>
        <tr>
           </tr>
      </table>
        <p></p>
      <a href="newpass.jsp">¿Ha olvidado su contraseña?</a>
    </form>
  </body>
</html>

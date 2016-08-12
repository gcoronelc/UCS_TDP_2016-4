<%-- 
    Document   : index
    Created on : 21-jul-2016, 22:01:08
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <h1>INGRESO AL SISTEMA</h1>
        <p>${requestScope.error}
        <form method="post" action="LogonIngreso">
            <table>
                <tr>
                    <td rowspan="3">
                        <img src="img/user_login_man-128.png" />
                    </td>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario" /></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="password" name="clave" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Ingresar" /></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>

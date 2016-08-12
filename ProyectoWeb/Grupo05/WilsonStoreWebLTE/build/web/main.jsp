<%-- 
    Document   : main
    Created on : 26-jul-2016, 20:42:30
    Author     : Alumno
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
        <h1>BIENVENIDO ${sessionScope.usuarios.nombres} !!</h1>
        <p>Usuario: </p>
        <table>
            <tr>
                <td>Nombres</td>
                <td>:</td>
                <td>${sessionScope.usuarios.nombres}</td>
            </tr>
            <tr>
                <td>Apellidos</td>
                <td>:</td>
                <td>${sessionScope.usuarios.apellidos}</td>
            </tr>
            <tr>
                <td>Area</td>
                <td>:</td>
                <td>${sessionScope.usuarios.area}</td>
            </tr>            
        </table>
    </body>
</html>

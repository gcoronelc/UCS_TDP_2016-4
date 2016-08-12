<%-- 
    Document   : index
    Created on : 27/07/2016, 02:54:35 PM
    Author     : jramirez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/style.css">
<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WILSON STORE WEB APP</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    
    
    <body>
    <div class = "login">
        <div class="login-screen">
            <div class="app-title">
                <h1>INGRESO AL SISTEMA</h1>
                <p>${requestScope.error}</p>
            </div>
            <div class="login-form">
                <form method="post" action="LogonIngreso">
                  <table>
                    <tr> 
                        <div class="control-group">
                            <td><input type="text" class="login-field" value="" placeholder="usuario" name="Usuario_id" /></td>
                            <label class="login-field-icon fui-user" for="login-name"></label>
                        </div>
                    </tr>
                    <tr>
                        <div class="control-group">   
                            <td><input type="password" class="login-field" value="" placeholder="password" name="Usuario_pass" /></td>
                            <label class="login-field-icon fui-lock" for="login-pass"></label>
                        </div>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="btn btn-primary btn-large btn-block" value="Ingresar"/></td>                       
                    </tr>
                    <td>
                        <a class="login-link" href="ForgotPassword.jsp">¿Olvidaste tu password?</a>
                    </td>                    
                  </table>
                </form>
            </div>
        </div>
    </div>
    </body>
</html>

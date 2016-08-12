<%-- 
    Document   : mantVendedor
    Created on : 06/08/2016, 09:57:48 AM
    Author     : jramirez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style.css">  
    <title>WILSON STORE WEB APP</title>
  </head>
    <body>
        <div class="login-screen">        
            <jsp:include page="header.jsp" />            
        </div>  
      
        <jsp:include page="menu.jsp" />
        
        <div class="login-screen">
        <h1>CONSULTA DE VENDEDORES</h1>
        <form method="post" action="VendedorController">
          <table>
            <tr>                
                <td>NOMBRE</td>                        
                <td rowspan="2" style="vertical-align: bottom;">
                    <input type="submit" name="btnConsultar" value="Consultar" />                
                    <input type="submit" name="btnNuevo" value="Nuevo" />                
                </td>
            </tr>
            <tr>
                <td><input type="text" name="NOMBRE" size="10" value="${requestScope.bean.NOMBRE}"/></td>
            </tr>
          </table>
        </form>
        
        <!-- Resultado -->
        <c:if test="${requestScope.lista != null}">
          <table border="1">
            <tr>
                <th>ID</th>    
                <th>NOMBRE</th>                
                <th>ESTADO</th>               
            </tr>
            
            <c:forEach items="${requestScope.lista}" var="r">
              <tr>
                <td>${r.ID}</td>       
                <td>${r.NOMBRE}</td>                
                <td>${r.ESTADO}</td>
              </tr>
            </c:forEach>
          </table>
        </c:if>
      </div>
        
    </body>
</html>

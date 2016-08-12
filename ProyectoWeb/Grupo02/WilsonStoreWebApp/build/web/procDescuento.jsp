
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
          <c:if test="${requestScope.info != null}">
          <p class="egcc_info">${requestScope.info}</p>
        </c:if>
        <c:if test="${requestScope.error != null}">
          <p class="egcc_error">${requestScope.error}</p>
        </c:if>     
        <form method="post" action="ProcDescuento">
          <table>
            <tr>
              <td>Cliente</td>
              <td><input type="text" name="CLI_ID"/></td>
            </tr>
            <tr>
              <td>Fecha</td>
              <td><input type="text" name="DSCTO_FECHA"/></td>
            </tr>
            <tr>
              <td>Porcentaje</td>
              <td><input type="text" name="DSCTO_PORC"/></td>
            </tr>
            <tr>
              <td>Estado</td>
              <td><input type="text" name="DSCTO_ESTADO"/></td>
            </tr>
          </table>
          <input type="submit" name="btnGrabar" value="Grabar"/>
        </form>
         </div>   
               
    </body>
</html>

<%-- 
    Document   : main
    Created on : 21-jul-2016, 22:25:54
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp" />

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
  </head>
  <body>
    <div class="egcc_page">
      
      <div class="egcc_header">
        <jsp:include page="header.jsp" />
      </div>
      
      <div class="egcc_menu">
        <jsp:include page="menu/menu.jsp" />
      </div>
      
      <div class="egcc_work">
        
        <h1>PROCESO DEPOSITO</h1>
        
        <c:if test="${requestScope.info != null}">
          <p class="egcc_info">${requestScope.info}</p>
        </c:if>
        <c:if test="${requestScope.error != null}">
          <p class="egcc_error">${requestScope.error}</p>
        </c:if>
          
        <form method="post" action="ProcDepositoSave">
          <table>
            <tr>
              <td>Cuenta:</td>
              <td>
                <select name="cuenta">
                  <option value="0">Seleccionar cuenta</option>
                  <c:forEach items="${requestScope.cuentas}" var="r">
                    <option value="${r.key}">${r.value}</option>
                  </c:forEach>
                </select>
              </td>
            </tr>
            <tr>
              <td>Moneda:</td>
              <td>Reto</td>
            </tr>
            <tr>
              <td>Saldo:</td>
              <td>Reto</td>
            </tr>
            <tr>
              <td>Importe:</td>
              <td><input type="text" name="importe"/></td>
            </tr>
          </table>
          <input type="submit" value="Procesar"/>
        </form>
        
        
      </div>
      
    </div>
  </body>
</html>

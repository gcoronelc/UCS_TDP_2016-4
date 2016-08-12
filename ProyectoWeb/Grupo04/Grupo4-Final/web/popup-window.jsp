<%-- 
    Document   : popup-window
    Created on : 11-ago-2016, 14:12:37
    Author     : pportocarrero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp" />
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Nuevo Cliente</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
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
        
        <form method="post" action="ClienteController" name="formId">
		<br>Ingreso de Nuevo Cliente  
                
		
		
                <table>
              <tr>
              <td>CODIGO : </td>
              <td><input type="text" name="codigo" size="10" value="${requestScope.bean.codigo}"/></td>
              </tr>
              
              <tr>
              <td>NOMBRE:</td>
              <td><input type="text" name="nombre" size="20" value="${requestScope.bean.nombre}"/></td>
              </tr>
              
              <tr>
              <td>RUC/DNI:</td>
              <td><input type="text" name="rucdni" size="20" value="${requestScope.bean.rucdni}"/></td>
              </tr>
              
              <tr>
              <td>DIRECCION:</td>
              <td><input type="text" name="direccion" size="20" value="${requestScope.bean.direccion}"/></td>
              </tr>
              
              <tr>
              <td>TELEFONO:</td>
              <td><input type="text" name="telefono" size="20" value="${requestScope.bean.telefono}"/></td>
              </tr>
              
              <tr>
              <td>EMAIL:</td>
              <td><input type="text" name="email" size="20" value="${requestScope.bean.email}"/></td>
              </tr>
              
              <tr>
              <td rowspan="2" style="vertical-align: bottom;">
                <input type="submit" name="btnNuevo" value="Ingresar Cliente" />                
                
                
              </td>
              </tr>
              
            
          </table>
                
 
		
		
	</form>
              </div>
                            </div>
    </body>
</html>

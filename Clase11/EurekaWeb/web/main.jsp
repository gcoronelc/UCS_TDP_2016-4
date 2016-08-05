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
        <p>Esta es el area de trabajo</p>
      </div>
      
    </div>
  </body>
</html>

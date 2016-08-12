<%-- 
    Document   : seguro
    Created on : 02/08/2016, 09:02:07 PM
    Author     : Administrador
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.usuario == null}">    
    <jsp:forward page="index.jsp" />
</c:if>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.usuarios == null}">
  <jsp:forward page="login.jsp" />
</c:if>

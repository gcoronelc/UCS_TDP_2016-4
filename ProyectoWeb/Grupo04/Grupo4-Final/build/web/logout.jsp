<html><head>

<%
  Object login = request.getSession(true).getValue("inslogin");
  if (login != null)
  {
    // Remove insurance login
    request.getSession(true).removeValue("inslogin");
    Object ifsLogin = request.getSession(true).getValue("IfsHttpLogin");
    if (ifsLogin != null && ifsLogin == login)
    { // Only remove IfsHttpLogin if it is the same login bean
      // Remove IfsHttpLogin login
      request.getSession(true).removeValue("IfsHttpLogin");
    }
  }
%>                   
<title>Gracias - Tienda Virtual</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor="#0b5989">
  <form METHOD=POST NAME="logout" ACTION="index.jsp">
    <table>
      <tr>
        <td><h3>.:: Ha Cerrado Correctamente la Sesión ::.</h3></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="Inicar Sesión">
        </td>
      </tr>
    </table>
  </form>
    </body>
</html>
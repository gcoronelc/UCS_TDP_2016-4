<table style="width: 100%;">
  <tr>
    <td>
      <img src="img/logotienda_1.png" />
      
    </td>
    <td>
        <font color="BLACK"><h4>Usuario: ${sessionScope.usuario.nombre}</h4></font><br/>
      <a href="logout.jsp">Salir</a>
      <p>
 <body>
        Fecha y Hora Actual:
        <%=new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format( new java.util.Date())%>
        <p>
   
            <h4>Direcci�n IP de la M�quina Cliente: <%=request.getRemoteAddr()%></h4>
    </body>
      
            
    </td>
  </tr>
</table>


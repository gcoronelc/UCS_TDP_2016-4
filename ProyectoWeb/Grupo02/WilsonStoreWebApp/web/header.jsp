<link rel="stylesheet" href="css/style.css"> 
<table class="Table-Normal">     
    <tr>
        <td>
          <img src="img/logo.png" align="left"/>
        </td> 
       
        <td>      
            <h4><p align="right">Usuario: ${sessionScope.Usuario.nombre} ${sessionScope.Usuario.apellidos}</p></h4>
            <h4><p align="right">Cargo: ${sessionScope.Usuario.cargo}</p></h4>
            <h4><p align="right">Email: ${sessionScope.Usuario.email}</p></h4>            
        </td>           
    </tr> 
</table>


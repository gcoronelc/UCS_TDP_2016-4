<%-- 
    Document   : Home
    Created on : 26-jul-2016, 21:32:42
    Author     : vparodig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Compu Store V1</title>

        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/Arch/bower_components/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Arch/bower_components/metisMenu/dist/metisMenu.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Arch/dist/css/sb-admin-2.css"/>" rel="stylesheet">
        <link href="<c:url value="/Arch/bower_components/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">


    </head>

    <body>
        <%@include file="seguro.jsp" %>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Compu Store v1.0</a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> Usuario: ${sessionScope.usuario.usuario}</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <%@include file="Menu.jsp" %>
            </nav>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <img src="Arch/Img/logo.png" alt="" class="img-rounded img-responsive pull-right"/>
                        <h1 class="page-header">Crear Clientes</h1>
                        <form  role="form" action="/CompuStore-Web/ClienteController" method="post" >
                            <div class="form-group">
                                <label for="codigo">Codigo</label>
                                <input type="text" class="form-control" id="codigo" name="codigo" placeholder="Introduce codigo">
                            </div>
                            <div class="form-group">
                                <label for="paterno">Apellido Paterno</label>
                                <input type="text" class="form-control" id="paterno" name="paterno" placeholder="Ingrese Apellido Paterno ">
                            </div>
                            <div class="form-group">
                                <label for="paterno">Apellido Materno</label>
                                <input type="text" class="form-control" id="materno" name="materno" placeholder="Ingrese Apellido Materno ">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombres</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese Nombres ">
                            </div>
                            <div class="form-group">
                                <label for="dni">Dni</label>
                                <input type="text" class="form-control" id="dni" name="dni" placeholder="Ingrese dni ">
                            </div>
                            <div class="form-group">
                                <label for="ciudad">Ciudad</label>
                                    <div class="form-group">
                                    <select class="form-control" id="ciudad" name="ciudad">
                                                    
                                                    <option value="Arequipa">Arequipa</option>
                                                    <option value="Chiclayo">Chiclayo</option>
                                                    <option value="Chincha">Chincha</option>
                                                    <option value="Colca (Arequipa)">Colca (Arequipa)</option>
                                                    <option value="Cusco">Cusco</option>
                                                    <option value="Machu Picchu">Machu Picchu</option>
                                                    <option value="Lima (Miraflores)">Lima (Miraflores)</option>
                                                    <option value="Nasca">Nasca</option>
                                                    <option value="Piura">Piura</option>
                                                    <option value="Pucallpa">Pucallpa</option>
                                                    <option value="Puno">Puno</option>
                                                    <option value="Tacna">Tacna</option>
                                                    <option value="Talara (Piura)">Talara (Piura)</option>
                                                    <option value="Trujillo">Trujillo</option>
                                                    <option value="Zorritos (Tumbes)">Zorritos (Tumbes)</option>
                                                    <option value="Valle Sagrado (Cusco)">Valle Sagrado (Cusco)</option>
                                            </select>
                                        
                                  </div>
                                
                            </div>
                            <div class="form-group">
                                <label for="direccion">Direccion</label>
                                <textarea  rows="3" class="form-control" id="direccion" name="direccion" placeholder="Ingrese direccion "></textarea>
                            </div>
                            <div class="form-group">
                                <label for="telefono">Telefono</label>
                                <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Ingrese telefono ">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Ingrese email ">
                            </div>


                            <button type="submit" name="btnNuevo" class="btn btn-primary">Grabar</button>
                        </form>


                    </div>
                    <br><br>



                    <!-- Resultado -->
                    <c:if test="${requestScope.lista != null}">

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-10">
                                    <div class="table-responsive">  
                                        <table class="table table-bordered table-hover table-striped">
                                            <tr>
                                                <th>CODIGO</th>
                                                <th>PATERNO</th>
                                                <th>MATERNO</th>
                                                <th>NOMBRE</th>
                                                <th>DNI</th>
                                                <th>EMAIL</th>
                                            </tr>

                                            <c:forEach items="${requestScope.lista}" var="r">
                                                <tr>
                                                    <td>${r.codigo}</td>
                                                    <td>${r.paterno}</td>
                                                    <td>${r.materno}</td>
                                                    <td>${r.nombre}</td>
                                                    <td>${r.dni}</td>
                                                    <td>${r.email}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>                             
                    </c:if>
                </div>
            </div>




        </div>

    </div>
</div>

<script src="<c:url value="/Arch/bower_components/jquery/dist/jquery.min.js"/>"></script>
<script src="<c:url value="/Arch/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/Arch/bower_components/metisMenu/dist/metisMenu.min.js"/>"></script>
<script src="<c:url value="/Arch/dist/js/sb-admin-2.js"/>"></script>


</body>

</html>

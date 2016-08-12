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
                    <img src="Arch/Img/header.jpg" alt="" class="img-rounded img-responsive"/>
                    <img src="Arch/Img/GOPR2951.jpg" alt="" class="img-rounded img-responsive"/>
                    
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

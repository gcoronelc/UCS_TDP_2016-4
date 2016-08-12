<%-- 
    Document   : index
    Created on : 26-jul-2016, 21:28:53
    Author     : vparodig
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head runat="server">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>.:: Compu Store ::.</title>

    <!-- CSS Login -->
    <link href="Arch/Css/Login.css" rel="stylesheet">

    <!-- Bootstrap Core CSS -->
    <link href="Arch/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS 
    <link href="Arch/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">-->

    <!-- Timeline CSS 
    <link href="../dist/css/timeline.css" rel="stylesheet">-->

    <!-- Custom CSS 
    <link href="Arch/dist/css/sb-admin-2.css" rel="stylesheet">-->

    <!-- Morris Charts CSS 
    <link href="Arch/bower_components/morrisjs/morris.css" rel="stylesheet">-->

    <!-- Custom Fonts -->
    <link href="Arch/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-lock"></span> Compu Store - Login</div>
                    <div class="panel-body">
                        <form id="frmLogin" class="form-horizontal" role="form" method="post" action="LogonIngreso">
                        <div class="form-group">
                            <label for="InputUsuario" class="col-sm-3 control-label">
                                Usuario</label>
                            <div class="col-sm-9">
                                <input id="usuario" name="usuario" type="text" class="form-control" placeholder="Usuario" required />
                                         
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label for="inputPass" class="col-sm-3 control-label">
                                Password</label>
                            <div class="col-sm-9">
                                <input id="clave" name="clave" type="password" class="form-control" placeholder="Password" required TextMode="Password" />
                                                              
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <div class="checkbox">
                                    <label>
                                        <input id="Recordarme" type="checkbox"/>
                                        Recordarme
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group last">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button id="Login" class="btn btn-success btn-sm" >Login</button>
                                     <button type="reset" class="btn btn-default btn-sm">
                                    Reset</button>
                                <p>${requestScope.error}</p>
                            </div>
                        </div>
                        
                           
                        </form>
                    </div>
                    <div class="panel-footer">
                        No está registrado ? <a href="#">Registrar aquí</a></div>
                </div>
            </div>
        </div>
    </div>
    
     <button type="button" class="btn btn-info btn-lg hide" data-toggle="modal" data-target="#myModal">Open Modal</button>
    <!-- Modal -->
    <div id="myModal" class="modal fade" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Modal Header</h4>
          </div>
          <div class="modal-body">
            <p>Some text in the modal.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>

      </div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="Arch/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- jQuery Cookie-->
    <script src="Arch/js/jquery-cookie-v1.4.1/jquery.cookie.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Arch/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript 
    <script src="Arch/bower_components/metisMenu/dist/metisMenu.min.js"></script>-->

    <!-- Morris Charts JavaScript 
    <script src="Arch/bower_components/raphael/raphael-min.js"></script>-->
    <!--<script src="Arch/bower_components/morrisjs/morris.min.js"></script> 
    <script src="Arch/js/morris-data.js"></script>-->

    <!-- Custom Theme JavaScript 
    <script src="Arch/dist/js/sb-admin-2.js"></script>-->
    
    <!-- Funciones JQUERY -->
    <script src="Arch/js/Login.js"></script>
    
</body>

</html>
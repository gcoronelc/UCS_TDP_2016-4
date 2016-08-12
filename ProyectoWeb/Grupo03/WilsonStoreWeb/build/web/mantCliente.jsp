<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp" />
<html>
	<head>
		<title>Proyecto</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="reset.css">
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="misestilos.css">
		
		<!-- varia el width para que ocupe el ancho deseado 50% ocupara la mitad -->
		<style>	
		  .carousel-inner > .item > img,
		  .carousel-inner > .item > a > img {
			  width: 100%;
			  margin: auto;
		  }
		 </style>

	</head>
	<body>
		<div class="container" id="container1">
			<!--col-xs-n Para Celulares
				col-sm-n Para Tablets
				col-md-n Para Desktop
				col-lg-n Para Desktop Pantalla Grande
				Donde "n" es el numero de columnas maximo 12
				En cada fila, las suma de "n" para cada dispositivo debe ser 12
			-->
			<!--Cabecera Banner-->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="container" id="carrusel">
					<!-- Inicio Slider -->
					<section id="mislide" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#mislide" data-slide-to="0" class="active"></li>
							<li data-target="#mislide" data-slide-to="1"></li>
							<li data-target="#mislide" data-slide-to="2"></li>
							<li data-target="#mislide" data-slide-to="3"></li>
						</ol>
						<div class="carousel-inner">
							<!-- Coloca aqui tus imagenes -->
							<div class="item active">
								<img src="imagenes/mono.jpg" alt="Mono Titi">
							</div>
							<div class="item">
								<img src="imagenes/yacare.jpg" alt="Yacare">
							</div>
							<div class="item">
								<img src="imagenes/ciervo.jpg" alt="Ciervo">
							</div>
							<div class="item">
								<img src="imagenes/oso.jpg" alt="Oso Hormiguero">
							</div>				
						</div>
						<a href="#mislide" class="left carousel-control" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
						<a href="#mislide" class="right carousel-control" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</section><br>
					<!-- Fin Slider -->
					</div>
				</div>
			</div>
			<!--Fin Cabecera Banner-->
			<!--Barra de Navegacion -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<nav class="navbar navbar-inverse" role="navigation">
						<div class="container-fluid">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#acolapsar">
									<span class="sr-only">Toggle Navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<a href="main.jsp" class="navbar-brand">${sessionScope.usuario.usuario}</a>
							</div>
							<div class="collapse navbar-collapse" id="acolapsar">
								<ul class="nav navbar-nav">
									<li><a href="main.jsp"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
									<li><a href="mantCliente.jsp"><span class="glyphicon glyphicon-cog"></span> Clientes</a></li>
									<li><a href="mantProducto.jsp"><span class="glyphicon glyphicon-cloud"></span> Productos</a></li>
									<%-- <li><a href="nosotros.html"><span class="glyphicon glyphicon-download-alt"></span> Nosotros</a></li>--%>
									<li><a href="contacto.html"><span class="glyphicon glyphicon-download-alt"></span> Contacto</a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</div>
			<!--Fin Barra de Navegacion -->
			<!--Cuerpo -->
			<div class="row">
				<!--Columna Principal -->
				<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
                                    <article>
                                        <h1>MANTENIMIENTO DE CLIENTES</h1>
                                        <form method="post" action="ClienteController">
                                          <table>
                                            <tr>
                                              <td>CODIGO</td>
                                              <td>PATERNO</td>
                                              <td>MATERNO</td>
                                              <td>NOMBRE</td>
                                              <td rowspan="2" style="vertical-align: bottom;">
                                                <input type="submit" name="btnConsultar" value="Consultar" />                
                                                <input type="submit" name="btnNuevo" value="Nuevo" />                
                                              </td>
                                            </tr>
                                            <tr>
                                              <td><input type="text" name="codigo" size="10" value="${requestScope.bean.codigo}"/></td>
                                              <td><input type="text" name="paterno" size="20" value="${requestScope.bean.paterno}"/></td>
                                              <td><input type="text" name="materno" size="20" value="${requestScope.bean.materno}"/></td>
                                              <td><input type="text" name="nombre" size="20" value="${requestScope.bean.nombre}"/></td>
                                            </tr>
                                          </table>
                                        </form>
                                        <!-- Resultado -->
                                    </article>
                                            <c:if test="${requestScope.lista != null}">
                                            <article>
                                                <h1>Busqueda</h1>
                                          <table id="tabladatos">
                                            <tr id="tr2">
                                              <th id="th2">CODIGO</th>
                                              <th id="th2">PATERNO</th>
                                              <th id="th2">MATERNO</th>
                                              <th id="th2">NOMBRE</th>
                                              <th id="th2">DNI</th>
                                              <th id="th2">EMAIL</th>
                                            </tr>

                                            <c:forEach items="${requestScope.lista}" var="r">
                                              <tr id="tr2">
                                                <td id="th2">${r.codigo}</td>
                                                <td id="th2">${r.paterno}</td>
                                                <td id="th2">${r.materno}</td>
                                                <td id="th2">${r.nombre}</td>
                                                <td id="th2">${r.dni}</td>
                                                <td id="th2">${r.email}</td>
                                              </tr>
                                            </c:forEach>
                                          </table>
                                            </article>
                                        </c:if>
				</div>
				<!--Columna de publicidad -->
				<div class="hidden-xs hidden-sm col-md-3 col-lg-3">
					<div id="publicidad">
						<h1>Publicidad</h1>
						<img src="imagenes/nina_alpaca.jpg" class="img-responsive"></img>
						<p>Con estas razones perdía el pobre caballero el juicio, y desvelábase por entenderlas y desentrañarles el sentido, que no se lo sacara ni las entendiera el mesmo Aristóteles, si resucitara para sólo ello. No estaba muy bien con las heridas que don Belianís daba y recebía, porque se imaginaba que, por grandes maestros que le hubiesen curado, no dejaría de tener el rostro y todo el cuerpo lleno de cicatrices y señales. </p>
					</div>
				</div>
			</div>
			<!--Fin Cuerpo -->			
		</div>
		<!--Pie de pagina -->
		<div class="container" id="container2">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h5 id="pie">Derechos reservados &copy Lima Perú</h5>
				</div>
			</div>	
		</div>
		<!--Fin Pie de pagina -->
		
		<!-- Aumenta el interval para hacer mas lento la transicion o disminuyelo para hacerlo mas rapido -->
		<script>
			$('.carousel').carousel({
				interval:5000
			})
		</script>
	</body>
</html>
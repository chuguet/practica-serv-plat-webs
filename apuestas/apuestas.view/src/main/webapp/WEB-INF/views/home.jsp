<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
		<title>Apuestas porras de f&uacute;tbol</title>
		
		<link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
		<link href="resources/css/ui.jqgrid.css" rel="stylesheet" type="text/css">
		<link href="resources/css/anythingslider.css" rel="stylesheet" type="text/css">

		<script src="resources/js/jquery.require.js" type="text/javascript"></script>
		<script src="resources/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery-ui-1.9.1.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
		<script src="resources/js/generic.js" type="text/javascript"></script>
		
		<script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
		<script src="resources/js/jquery.anythingslider.js" type="text/javascript"></script>
		<script src="resources/js/jquery.jqGrid.min.js" type="text/javascript"></script>
		<script src="resources/js/i18n/grid.locale-es.js" type="text/javascript"></script>
		
		<script src="resources/js/views/usuario.js" type="text/javascript"></script>
		<script src="resources/js/views/porra.js" type="text/javascript"></script>
		<script src="resources/js/views/porraRellenada.js" type="text/javascript"></script>
		<script src="resources/js/views/resultado.js" type="text/javascript"></script>
		
	</head>
	<body id="apuestas" class="web" >
		
		<div id="header">
			<h3>Hoy es ${fecha}</h3>
			<h1>Apuestas porras de f&uacute;tbol &#174;</h1>
		</div>
		
		<div id="menu">
		<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<a href="javascript:void" onclick="javascript:generic.getList('usuario');" title="Ver usuarios" class="itemMenu">Usuarios</a>
			<a href="javascript:void" onclick="javascript:generic.getList('porra');" title="Ver porras" class="itemMenu">Porras</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
			<a href="javascript:void" onclick="javascript:generic.getList('porraRellenada');" title="Ver porras rellenadas" class="itemMenu">Rellenar porra</a>
			<a href="javascript:void" onclick="javascript:generic.getList('resultado');" title="Ver resultado de porras" class="itemMenu">Ver resultados</a>
		</sec:authorize>
			<div id="usuario">
				<span><b>Usuario :</b> ${nombre} ${apellidos}</span> 
				<a href="<c:url value="/home" />" id="btnHome" title="Home"><span>Home</span></a>
				<a href="<c:url value="/j_spring_security_logout" />" id="btnUnlogin" title="Salir"><span>Salir</span></a>
			</div>
		</div>
		
		
		<div id="content">
			<img src="resources/imgs/copa.png" alt="imagenes" class="imgCopa"/>
		</div>
		
		<div id="footer">
			&#169; Huguet S.L. &#174;
		</div>
	</body>
	<script type="text/javascript">
		generic.resizeEvent();
	</script>
</html>
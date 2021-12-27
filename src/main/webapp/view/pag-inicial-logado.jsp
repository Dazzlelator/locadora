<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pagina inicial</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<script src="/Locadora/Scripts/jquery.js"></script>
<script src="/Locadora/Scripts/catalogoScript.js"></script>

<body>
	<header>
			<div>
				<c:import url="cabecalho.jsp" />
			</div>
			<div>
				<a id="menu_usuario" href="${main}?action=MenuUsuario"></a>
			</div>		
			
			
			
				
		
	</header>
		
	
	<div id="catalogo_id" class="texto-titulo">
		<span>Lançamentos</span>
		<c:import url="catalogo-lancamento.jsp" />		
	</div>
</body>
</html>
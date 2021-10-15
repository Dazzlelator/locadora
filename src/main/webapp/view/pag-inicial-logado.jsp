<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina inicial</title>
</head>
<script src="/Locadora/Scripts/jquery.js"></script>
<script src="/Locadora/Scripts/catalogoScript.js"></script>

<body>
	<header>
		
		<c:import url="cabecalho.jsp" />
		<br>
		<div id="menu_usuario">
			<a href="${main}?action=MenuUsuario"></a>
		</div>
		
		<br>
		<div class="catalogos">
			<a href="${main}?action=CatalogarFilmes"> Catalogo de filmes</a>
			<a> Catalogo de Jogos</a>
		</div>
		
		
	</header>
		
	
	<div id="catalogo_id">
		<c:import url="catalogo-lancamento.jsp" />
	</div>
</body>
</html>
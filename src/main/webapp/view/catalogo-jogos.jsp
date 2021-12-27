<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Catalogo de filmes</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link rel="stulesheet" href="/Locadora/CSSs/conteudos">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<br>
	<div id="todos_filmes">
	Jogos disponiveis:
		<ul>
		
			<c:if test="${not empty jogos}">
			<c:forEach items="${jogos}" var="jogo">
				 
						<li>${jogo.nome} ${jogo.plataforma}</li>
						<a href="${main}?id_jogo=${jogo.idJogo}&action=InfoJogo">Info</a>
					
				
			</c:forEach>
			</c:if>
			<c:if test="${empty jogos }">Lista vazia</c:if>
		</ul>	
	
	</div>

</body>
</html>
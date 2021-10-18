<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo de filmes</title>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/main" var="linkMain" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Jogos Alugados</title>
</head>
<body>
	<ul>		
		<c:if test="${not empty jogos}">
			<c:forEach items="${jogos}" var="jogo">					
				<li>${jogo.nome} ${jogo.plataforma}</li>
				<a href="${main}?id_usuario=${usuarioLogado.id}&id_jogo=${jogo.idJogo}&action=InfoJogo&variacao=alugado">Info</a>										
			</c:forEach>
		</c:if>
		<c:if test="${empty jogos}"></c:if>	
	</ul>

</body>
</html>
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
<<<<<<< HEAD
	<div id="todos_filmes" class="texto-titulo">
		<h1>Filmes disponíveis</h1>		
		<c:if test="${not empty filmes}">
		<table class="tabela">
			
			<c:forEach items="${filmes}" var="filme">					
				<tr class="img-fluid texto-catalogo item-catalogo" style="background-image: url('./view/img-filmes/${filme.nome}.jpg');background-position: center;" onclick="location.href='${main}?id_filme=${filme.idFilme}&action=InfoFilme';" >
						
						<td class="titulo-area">${filme.nome} <p>${filme.tecnologia}</p></td>
						<td class="sin-area">${filme.sinopse}</td>		
												
				</tr>						
			</c:forEach>
		</table>
		</c:if>
		<c:if test="${empty filmes }">Lista vazia</c:if>		
	
=======
	<div id="todos_filmes">
	Filmes disponiveis:
		<ul>
>>>>>>> parent of a4d7f71 (implementando design)
		
			<c:if test="${not empty filmes}">
				<c:forEach items="${filmes}" var="filme">
					 
					<li>${filme.nome} ${filme.tecnologia}</li>
					<a href="${main}?id_filme=${filme.idFilme}&action=InfoFilme">Info</a>
					
				</c:forEach>
			</c:if>
			<c:if test="${empty filmes }">Lista vazia</c:if>
		</ul>	
	
	</div>

</body>
</html>
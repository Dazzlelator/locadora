<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>	
	
		
		<div id="filmes_id">
			<table class="tabela">								
				<c:forEach items="${filmes}" var="filme">
				
					 <c:if test="${not empty filmes}">
					 
					 	<tr class="img-fluid texto-catalogo item-catalogo" style="background-image: url('./view/img-filmes/${filme.nome}.jpg');background-position: center;" onclick="location.href='${main}?id_filme=${filme.idFilme}&action=InfoFilme';" >
							
							<td class="titulo-area">${filme.nome} <p>${filme.tecnologia}</p></td>
							<td class="sin-area">${filme.sinopse}</td>
							
						</tr>
						
					</c:if>
					<c:if test="${empty filmes }">Lista vazia</c:if>		
						
				</c:forEach>
				
			</table>
		</div>
		
		<div id="jogos_id">
			<table class="tabela">
				<c:forEach items="${jogos}" var="jogo">
					 <c:if test="${not empty jogos}">
					 <tr class="img-fluid texto-catalogo item-catalogo" style="background-image: url('./view/img-jogos/${jogo.nome}.jpg');background-position: center;" onclick="location.href='${main}?id_jogo=${jogo.idJogo}&action=InfoJogo';">
					 
						<td class="titulo-area">${jogo.nome} <p> ${jogo.plataforma}</p></td>
						<td class="sin-area">${jogo.generos}</td>
												
					</tr>	
					
					 </c:if>
					<c:if test="${empty jogos }">Lista vazia</c:if>				
				</c:forEach>
			</table>
		</div>
	
</body>

</html>

 


	

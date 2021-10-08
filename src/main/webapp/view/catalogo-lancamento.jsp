<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	

</head>
<body>
	
	<script type="text/javaScript">
	</script>
	
		<div id="filmes_id">
			<ul>
				<c:forEach items="${filmes}" var="filme">
					 <c:if test="${not empty filmes}">
						<li>${filme.nome} ${filme.tecnologia}</li>
						
					</c:if>
					<c:if test="${empty filmes }">Lista vazia</c:if>				
				</c:forEach>
			</ul>
		</div>
		
		<div id="jogos_id">
			<ul>
				<c:forEach items="${jogos}" var="jogo">
					 <c:if test="${not empty jogos}">
						<li>${jogo.nome} ${jogo.plataforma}</li>
						
					 </c:if>
					<c:if test="${empty jogos }">Lista vazia</c:if>				
				</c:forEach>
			</ul>
		</div>
		
		
	
</body>

</html>

 


	

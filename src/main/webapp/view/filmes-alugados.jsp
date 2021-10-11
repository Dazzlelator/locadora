<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/main" var="linkMain" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Alugueis</title>
</head>
<body>
	<ul>
				<c:forEach items="${filmes}" var="filme">
					 <c:if test="${not empty filmes}">
						<li>${filme.nome} ${filme.tecnologia}</li>
						<a href="${main}?id=${filme.idFilme}&action=InfoFilme">Info</a>
						
					</c:if>
					<c:if test="${empty filmes }">Lista vazia</c:if>		
						
				</c:forEach>
			</ul>

</body>
</html>
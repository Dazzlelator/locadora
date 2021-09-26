<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de resposta</title>
</head>
<body>
	<ul>
		
			<c:forEach items="${produtos}" var="produto">
				<c:if test="${not empty produtos}">
					<li>${produto.nome}</li>
					<li>${produto.id}</li>				
				</c:if>				 
			</c:forEach>
	</ul>
</body>
</html>
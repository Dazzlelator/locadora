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
	<table class="tabela">
		<c:forEach items="${filmes}" var="filme">
			 <c:if test="${not empty filmes}">
			 <tr>
			 	<td>${filme.nome} ${filme.tecnologia}</td>
				<td style="text-align: right; padding-right: 5px;"><a href="${main}?id_usuario=${usuarioLogado.id}&id_filme=${filme.idFilme}&action=InfoFilme&variacao=alugado">Info</a></td>
					 
			 </tr>
				
				
			</c:if>
			<c:if test="${empty filmes }">Lista vazia</c:if>		
				
		</c:forEach>
	</table>

</body>
</html>
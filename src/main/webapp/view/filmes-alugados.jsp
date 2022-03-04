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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
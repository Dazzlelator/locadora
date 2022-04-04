<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/main" var="linkMain" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>info-aluguel</title>
</head>
<body>
	Dias de aluguel: ${aluguel.diasDevolucao}<br>
	Data de devolucao: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${aluguel.dataDevolucao}" /><br>
	
	<c:if test="${aluguel.idAluguel > 2}">
		Dias restantes: ${ diasRestantes } <br>
		<c:if test="${diasRestantes < 1}">
			Valor da multa atual: ${multa} <br>
		</c:if>
	</c:if>
	<c:if test="${not empty diasRestantes}">
		<div class="link3">
			<a href="${main}?id_usuario=${usuarioLogado.id}&id_aluguel=${aluguel.idAluguel}&action=DevolverProduto" class="link">Devolver</a>
		</div>
	</c:if>
	
</body>
</html>
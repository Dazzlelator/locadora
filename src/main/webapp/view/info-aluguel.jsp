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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
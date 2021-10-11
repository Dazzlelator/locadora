<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Crédito</title>
</head>
<body>
	<div id="usuario_inf" class="cabecalho">
		<c:import url="logout.jsp" />
		Usuario Logado: ${usuarioLogado.nome}   Credito atual: ${usuarioLogado.credito}
		<a href="${main}?action=PaginaInicial">Pagina inicial</a>
	</div>
	
	<div>
		<form action="${main}?action=AdicionarCredito" method="post">
			<input type="hidden" name="id" value="${usuarioLogado.id}" readonly><br>
			
			<input type="number" name="valor"><br>
			<input type="submit" value="Adicionar Crédito">
		</form>
	
	</div>
</body>
</html>
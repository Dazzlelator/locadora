<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista alugados</title>
</head>
<body>
	<div id="usuario_inf" class="cabecalho">
		<c:import url="logout.jsp" />
		Usuario Logado: ${usuarioLogado.nome}   Credito atual: ${usuarioLogado.credito}
		<a href="${main}?action=PaginaInicial">Pagina inicial</a>
	</div>
	<br>
	Lista de alugueis:
	<div id="filmes">
		<c:import url="filmes-alugados.jsp" />
	</div>
</body>
<script src="/Locadora/Scripts/jquery.js"></script>
	<script id="script_produto">	
		var idUsuario = ${usuarioLogado.id}
		
		var paramFilmes = {
			action: "FilmesAlugados",
			id: idUsuario
		}

		$.post("main", $.param(paramFilmes), function(response) {
		  	$('#filmes').append(response);
		});
	</script>
		
</html>
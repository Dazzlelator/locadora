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
	<c:import url="cabecalho.jsp" />
	<br>
	<br>
	Lista de alugueis:
	<div id="filmes">
		<c:import url="filmes-alugados.jsp" />
	</div>	
	<div id="jogos">
		<c:import url="jogos-alugados.jsp"/>
	</div>
</body>
<script src="/Locadora/Scripts/jquery.js"></script>
	<script id="script_filmes">	
		var idUsuario = ${usuarioLogado.id}
		
		var paramFilmes = {
			action: "FilmesAlugados",
			id: idUsuario
		}

		$.post("main", $.param(paramFilmes), function(response) {
		  	$('#filmes').append(response);
		});
	</script>
	
	<script id="script_jogos">	
		var idUsuario = ${usuarioLogado.id}
		
		var paraJogos = {
			action: "JogosAlugados",
			id: idUsuario
		}

		$.post("main", $.param(paraJogos), function(response) {
		  	$('#jogos').append(response);
		});
	</script>
		
</html>
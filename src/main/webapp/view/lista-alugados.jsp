<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>lista alugados</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
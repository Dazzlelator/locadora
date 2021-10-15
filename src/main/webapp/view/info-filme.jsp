<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informa��es do filme</title>
<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
</head>
	<body>
		
		
		<c:import url="cabecalho.jsp" />
		
		<div id="info_filme">
			
			${filme.nome} ${filme.tecnologia} ${filme.sinopse} ${filme.dataLancamento} 
			
			
		</div>
		<div id="id-filme" class="hidden">${filme.idFilme}</div>
		<div id="info_produto">	</div>
		<div id="info_aluguel">	</div>
		
		<a href="${main}?id_usuario=${usuarioLogado.id }&id_filme=${filme.idFilme}&action=AlugarFilme">Alugar</a>
	</body>
	<script src="/Locadora/Scripts/jquery.js"></script>
	<script id="script_produto">	
		var idFilme = document.getElementById('id-filme').textContent
		
		var paramIdFilme = {
			action: "InfoProduto",
			id: idFilme
		}

		$.post("main", $.param(paramIdFilme), function(response) {
		  	$('#info_produto').append(response);
		});
	</script>
		<script id="script_aluguel">	
		
		
		var paramIdFilme = {
			action: "InfoAluguel",			
		}
		$.post("main", $.param(paramIdFilme), function(response) {
		  	$('#info_aluguel').append(response);
		});
		
	</script>
		
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informações do filme</title>
<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
</head>
	<body>
		
		
		<div id="usuario_inf" class="cabecalho">
			<c:import url="logout.jsp" />
			Usuario Logado: ${usuarioLogado.nome}  <br> Credito atual: ${usuarioLogado.credito}
			<a href="${main}?action=PaginaInicial">Pagina inicial</a>
		</div>
		
		<div id="info_filme">
			
			${filme.nome} ${filme.tecnologia} Sinopse: ${filme.sinopse} Lançado: ${filme.dataLancamento} 
			
			
		</div>
		<div id="id-filme" class="hidden">${filme.idFilme}</div>
		<div id="info_produto">	</div>
		<div id="info_aluguel"> </div>
		
		<a href="${main}?id_usuario=${usuarioLogado.id }&id_filme=${filme.idFilme}&action=DevolverFime">Devolver</a>
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
	
	
		var paramAluguel = {
			id_filme: ${filme.idFilme},
			id_usuario: ${usuarioLogado.id},
			action: "InfoAluguel"			
		}
		$.post("main", $.param(paramAluguel), function(response) {
		  	$('#info_aluguel').append(response);
		});
		
	</script>
		
		
</html>
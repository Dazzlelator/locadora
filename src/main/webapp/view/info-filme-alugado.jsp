<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Informações do filme</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
	<body>
		
		<c:import url="cabecalho.jsp" />
		<div class="conteiner-1 azul-3">
		<div id="info_filme">
				<h2>
					${filme.nome}
				</h2>
				<h3 style="font-size:20px">
					${filme.tecnologia}
				</h3>				
				<p>Sinopse:  ${filme.sinopse}</p>
				<p><fmt:formatDate pattern = "dd/MM/yyyy" value = "${filme.dataLancamento}" /></p>
							
			</div>		
			<div id="id-filme" class="hidden">${filme.idFilme}</div>
			<div id="info_produto">	</div>
			<div id="info_aluguel">	</div>
			
		
		</div>
			
		
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
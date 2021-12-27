<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html standardized-themed-scrollbar>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<title>Teste de links</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
</head>
<body>
	
	<script src="/Locadora/Scripts/jquery.js"></script>
	<script src="/Locadora/Scripts/catalogoScript.js"></script>
	
	<header>
		<div class="link-area">
			<a href="${main}?action=CatalogarFilmesLancamento" class="link"> Todos os filmes</a>
			<a href="${main}?action=CatalogarJogosLancamento" class="link"> Todos os Jogos</a>
		</div>	
	</header>
	
	
	
	<div class="container-fluid login_class d-flex justify-content-center my-5">
		<div id="login_id" class="azul px-4 pt-4 pb-2 arredondado">
			<form action="${linkMain}?action=Login" method="post">
				<span>Login: <input class="d-block border-0 rounded" type="text" name="email" /></span>
				<span>Senha: <input	class="d-block border-0 rounded" type="password" name="senha" /> </span>
				
				<div class="d-flex justify-content-around mt-2">
					<input type="submit" value="Entrar" class="d-inline my-1 btn btn-primary btn-sm"/>
					<a href="${linkMain}?action=CadastrarUsuario" class="d-inline">cadastrar</a>	
				</div>				
			</form>
			
		</div>
	
	</div>
	
	<br>			
	<br>
	
	<div id="catalogo_id" class="texto-titulo">
		<span>Lançamentos</span>
		<c:import url="catalogo-lancamento.jsp" />		
	</div>
	
	
		
</body>
</html>
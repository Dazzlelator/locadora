<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="main"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Alterar Usuario teste</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<header>
	<div class="link-area">
		<a href="${main}?action=PaginaInicial" class="link2">Pagina inicial</a>
		<a href="?action=CatalogarFilmesLancamento" class="link"> Todos os filmes</a>
		<a href="?action=CatalogarJogosLancamento" class="link"> Todos os Jogos</a>
		
	</div>
</header>
<body>
	
	
	<div class="formulario">
		<!-- <span class="texto-titulo">Cadastrar</span> -->
		
		<form action="${main}?action=SalvarUsuario" method="post" class="px-4 pt-4 pb-2 justify-content-center azul arredondado">
			
			<input type="hidden" name="id" value="${usuario.id}" readonly>
			<label> Nome <input type="text" name="nome" value="${usuario.nome} " class="d-block border-0 rounded form-input"></label>
			<label>Senha <input type="password" name="senha" class="d-block border-0 rounded form-input"></label>
			<label>CPF <input type="text" name="cpf" value="${usuario.cpf}" class="d-block border-0 rounded form-input"></label>
			<label>Data de nascimento <input type="date" name="nascimento" value="${usuario.dataNascimento}" class="d-block border-0 rounded form-input"></label>
			<label>Telefone <input type="text" name="telefone" value="${usuario.telefone}" class="d-block border-0 rounded form-input"></label>
			<label>Email <input type="text" name="email" value="${usuario.email }" class="d-block border-0 rounded form-input"></label>
			<label>Endereco <input type="text" name="endereco" value="${usuario.endereco}" class="d-block border-0 rounded form-input"></label>
			<div class="d-flex justify-content-around mt-2">
				<input type="submit" value="Cadastrar" class="d-inline my-1 btn btn-primary btn-sm">
			</div>
	
		</form>
	
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="main"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Alterar dados pessoais</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<c:import url="cabecalho.jsp" />
	</header>

	<form action="${main}?action=AlterarUsuario" method="post">
			
		<input type="hidden" name="id" value="${usuario.id}" readonly><br>
		Nome: <input type="text" name="nome" value="${usuario.nome}"><br>
		Senha: <input type="password" name="senha"><br>
		CPF: <input type="text" name="cpf" value="${usuario.cpf}"><br>
		Data de nascimento: <input type="date" name="nascimento" value="${usuario.dataNascimento}"><br>
		Telefone <input type="text" name="telefone" value="${usuario.telefone}"><br>
		Email: <input type="text" name="email" value="${usuario.email }"><br>
		Endereco: <input type="text" name="endereco" value="${usuario.endereco}"><br>
		
		<input type="submit" value="Alterar">
	
	</form>
</body>
</html>
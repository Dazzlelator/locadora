<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Usuario teste</title>
</head>
<body>
	<form action="/Locadora/alterarUsuario" method="post">
		ID: <a>${usuario.id}</a><br>
		Nome: <input type="text" name="nome" value="${usuario.nome}"><br>
		Senha: <input type="password" name="senha"><br>
		CPF: <input type="text" name="cpf" value="${usuario.cpf}"><br>
		Data de nascimento: <input type="date" name="nascimento" value="${usuario.dataNascimento}"><br>
		Telefone <input type="text" name="telefone" value="${usuario.telefone}"><br>
		Email: <input type="text" name="email" value="${usuario.email }"><br>
		Endereco: <input type="text" name="endereco" value="${usuario.endereco}"><br>
		
		<input type="submit">
	
	</form>
</body>
</html>
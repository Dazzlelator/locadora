<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>teste1</title>
</head>
<body>
	<form action="/Locadora/main" method="post">
	
		Nome: <input type="text" name="nome"><br>
		Senha: <input type="password" name="senha"><br>
		CPF: <input type="text" name="cpf"><br>
		Data de nascimento: <input type="date" name="nascimento"><br>
		Telefone <input type="text" name="telefone"><br>
		Email: <input type="text" name="email"><br>
		Endereco: <input type="text" name="endereco"><br>
		
		<input type="submit">
	
	</form>
</body>
</html>
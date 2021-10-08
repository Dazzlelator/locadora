<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Teste de links</title>
	
</head>
<body>
	<script src="/Locadora/Scripts/jquery.js"></script>
	<script src="/Locadora/Scripts/catalogoScript.js"></script>
	
	<div class="login_class" id="login_id">
		<form action="${linkMain}?action=Login" method="post">
			Login: <input type="text" name="email" />
			Senha: <input	type="password" name="senha" /> 
			<input type="submit" />
		</form>
		<a href="${linkMain}?action=CadastrarUsuario">cadastrar</a>	
	</div>
	
	<br>
			
	<div class="catalogos">
		<a> Catalogo de filmes</a>
		<a> Catalogo de Jogos</a>
	</div>
			
	<br>
	
	<div id="catalogo_id">
		<c:import url="catalogo-lancamento.jsp" />
	</div>
	

	
</body>
</html>
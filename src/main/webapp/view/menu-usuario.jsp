<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menu do usuario</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
</head>
<body>
	<header>

		<c:import url="cabecalho.jsp" />
	</header>
	<div id=lista_opcoes>
		<a href="${main}?id=${usuarioLogado.id}&action=AlterarUsuario">Alterar dados pessoais</a>
		<a href="${main}?action=ListarUsuarios" class="nivel${usuarioLogado.nivelAcesso}"> Listar usuarios</a>
		<a href="view/adicionar-credito.jsp">Adicionar Credito</a>
		
	</div>

</body>
</html>
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

		<div id="usuario_inf" class="cabecalho">
			<c:import url="logout.jsp" />
			Usuario Logado: ${usuarioLogado.nome} 
			<a href="${main}?action=PaginaInicial">Pagina inicial</a>
		</div>
	</header>
	<div id=lista_opcoes>
		<a href="${main}?id=${usuarioLogado.id}&action=AlterarUsuario">Alterar dados pessoais</a>
		<a href="${main}?action=ListarUsuarios" class="nivel${usuarioLogado.nivelAcesso}"> Listar usuarios</a>
		
	</div>

</body>
</html>
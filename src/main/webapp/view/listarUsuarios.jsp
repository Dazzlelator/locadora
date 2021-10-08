<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:url value="/main" var="main"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de resposta</title>
</head>


<body>
	<header>
		
		<div id="usuario_inf" class="cabecalho">
			<c:import url="logout.jsp"/>	
			Usuario Logado: ${usuarioLogado.nome}
			<a href="${main}?id=${usuarioLogado.id}&action=MenuUsuario"> Menu do usuario </a>
			<a href="${main}?action=PaginaInicial">Pagina inicial</a>
		</div>
	</header>	
	<ul>		
		<c:forEach items="${usuarios}" var="usuario">
			<c:if test="${not empty usuarios}">
				<li>${usuario.nome}</li>
				<a href="${main}?id=${usuario.id}&action=AlterarUsuario">alterar</a>
				<a href="${main}?id=${usuario.id}&action=DeletarUsuario">excluir</a>
			</c:if>	 
		</c:forEach>
	</ul>
</body>
</html>
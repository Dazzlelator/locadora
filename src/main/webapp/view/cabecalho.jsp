<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div id="usuario_inf" class="cabecalho">
			<c:import url="logout.jsp" />
			<a href="${main}?action=PaginaInicial">Pagina inicial</a><br>
			Usuario Logado: ${usuarioLogado.nome}   Credito atual: ${usuarioLogado.credito} <br>
			<a href="${main}?id=${usuarioLogado.id}&action=MenuUsuario"> Menu do usuario </a>
			
			<a href="${main}?action=ListarAlugados">Itens Alugados</a>
			
			<c:if test="${usuarioLogado.nivelAcesso >= 2}">
				<a href="${main}?id_usuario=${usuarioLogado.id}&action=AdicionarFilme"> Adicionar Filme </a>
				<a href="${main}?id_usuario=${usuarioLogado.id}&action=AdicionarJogo"> Adicionar Jogo</a>
			</c:if>
		</div>

</body>
</html>
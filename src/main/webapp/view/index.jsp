<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain"/>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de links</title>
</head>
<body>
	<a href="${linkMain}?action=listarUsuarios">Listar</a>
	<a href="${linkMain}?action=cadastrarUsuario"> cadastrar</a>
</body>
</html>
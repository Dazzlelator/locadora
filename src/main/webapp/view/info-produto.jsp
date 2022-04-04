<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>info-produto</title>
</head>
<body>
	Quantidade disponivel: ${produto.quantidade}<br>
	Valor do aluguel: ${aluguelEmReal}<br>
	Valor da multa: ${multaEmReal}<br>
</body>
</html>
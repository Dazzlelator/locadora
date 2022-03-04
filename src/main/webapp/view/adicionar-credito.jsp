<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/main" var="main" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Adicionar Crédito</title>
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container-fluid login_class d-flex justify-content-center my-5">
		<div class="azul px-4 pt-4 pb-2 arredondado">
			<form action="${main}?action=AdicionarCredito" method="post">
				<input type="hidden" name="id" value="${usuarioLogado.id}" readonly><br>
				
				<input type="number" name="valor" class="d-block border-0 rounded"><br>
				<input type="submit" value="Adicionar Crédito" class="d-inline my-1 btn btn-primary btn-sm" style="position: relative;right: -30px;">
				
			</form>
		
		</div>	
	</div>
	
</body>
</html>
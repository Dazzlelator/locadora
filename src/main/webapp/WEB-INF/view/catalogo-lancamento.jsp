<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javaScript" src="Scripts/jquery.js"></script>
<script type="text/javaScript">
	console.log("foda-seeeee"); dessa forma funcionou
</script>
</head>
<body>
	<ul>
		<c:forEach items="${filmes}" var="filme">
			<c:if test="${not empty filmes}">
				<li>${filme.nome}</li>		
			</c:if>	 
		</c:forEach>
	</ul>
	descobrir uma forma desse HTML ler os scripts como o jquary. dando erro 404.
</body>

</html>

 


	

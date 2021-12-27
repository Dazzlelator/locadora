<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="main"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/Locadora/CSSs/presquisa-dropdown.css">
	<link rel="stylesheet" href="/Locadora/CSSs/menu.css">
	<title>Adicionar Filme</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<c:import url="cabecalho.jsp" />
	</header>
	
	<form action="${main}?action=AdicionarFilme" method="post">
		<div class="class_pesquisa">
			<input type="hidden" name="id" value="${usuarioLogado.id}" readonly><br>
			<label for="nome" class="legenda2" >Nome do filme </label>
			<input type="text" name="nome" value="" id="nome"><br>
			<div id='idPesquisa' class="hidden"></div>		
		</div>
		<input type="hidden" name="id_produto" id="id_produto"><br>
		Código do produto: <input type="text" name="cod_produto" id="cod_produto"><br>
		Valor: <input type="number" name="valor" value="" id="valor"><br>
		Valor custo: <input type="number" name="valor_custo" value="" id="valor_custo"><br>
		Valor aluguel: <input type="number" name="valor_aluguel" value="" id="valor_aluguel"><br>
		Valor multa: <input type="number" name="valor_multa" value="" id="valor_multa"><br>
		Quantidade: <input type="text" name="quantidade" value="1" id="quantidade"  ><br>
		Tipo <input type="text" name="tipo" value="" id="tipo"><br>
		<br>
		Nº Serial <input type="text" name="num_serial" id="num_serial"><br>
		Franquia <input type="text" name="franquia" id="franquia"><br>
		generos <input type="text" name="generos" id="generos"><br>
		premios <input type="text" name="premios" id="premios"><br>
		notas <input type="text" name="notas" id="notas"><br>
		protagonistas <input type="text" name="protagonistas" id="protagonistas"><br>
		diretor<input type="text" name="diretor"  id="diretor"><br>
		produtor<input type="text" name='produtor' id='produtor'><br>
		Destribuidor <input type='text' name='destribuidor' id='destribuidor'><br>
		Faixa etária <input type='text' name='faixa_etaria' id='faixa_etaria'><br>
		Integridade <input type='text' name='integridade' id='integridade'><br>
		Data de Lançamento <input type='date' name='data_lancamento' id='data_lancamento'><br>
		Sinopse <input type="text" name="sinopse" id='sinopse'><br>
		
		<input type="submit" value="Salvar Filme">
		
	</form>
</body>
<script src="/Locadora/Scripts/viewer.js"></script>
<script src="/Locadora/Scripts/DesenhaDropdown.js"></script>
<script src="/Locadora/Scripts/Pesquisa.js"></script>
<script>	
	var pesquisa = new Pesquisa(${produtos}, ${filmes});
	
	pesquisa.pesquisar()
</script>
</html>
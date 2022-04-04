<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="main"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/Locadora/CSSs/presquisa-dropdown.css">
	<title>Adicionar Filme</title>
</head>
<body>
<<<<<<< HEAD
	<header>
		<c:import url="cabecalho.jsp" />
	</header>
	
	<div class="formulario-2">
		<form action="${main}?action=AdicionarFilme" method="post" class="px-4 pt-4 pb-2 azul arredondado grid grid-template-2">
			<div style="grid-column: 1/3; grid-row: 1">
				<input type="hidden" name="id" value="${usuarioLogado.id}" readonly>
				<label for="nome" class="item-form" >Nome do filme </label><input type="text" name="nome" value="" id="nome" class="item-form">			
				<div id='idPesquisa' class="hidden"></div><div>
					<input type="hidden" name="id_produto" id="id_produto">
				</div>		
			</div>
			
			
			<div style="grid-column: 3/5; grid-row: 1">
				<label class="item-form">Código do produto: </label><input type="text" name="cod_produto" id="cod_produto" class="item-form">
			</div>
			<div style="grid-column: 1; grid-row: 2">
				<label class="item-form">Valor: </label><input type="number" name="valor" value="" id="valor" class="item-form">
			</div>
			<div style="grid-column: 2; grid-row: 2">
				<label class="item-form">Valor custo: </label><input type="number" name="valor_custo" value="" id="valor_custo" class="item-form">
			</div>
			<div style="grid-column: 3; grid-row: 2">
				<label class="item-form">Valor aluguel: </label><input type="number" name="valor_aluguel" value="" id="valor_aluguel" class="item-form">
			</div>
			<div style="grid-column: 4; grid-row: 2">
				<label class="item-form">Valor multa: </label><input type="number" name="valor_multa" value="" id="valor_multa" class="item-form">
			</div>
			<div style="grid-column: 1; grid-row: 3">
				<label class="item-form">Quantidade: </label><input type="text" name="quantidade" value="1" id="quantidade" class="item-form" >
			</div>
			<div style="grid-column: 2; grid-row: 3">
				<label class="item-form">Tipo de mídia </label><input type="text" name="tipo" value="" id="tipo" class="item-form">
			</div>
			<div  style="grid-column: 3/5; grid-row: 3">
				<label class="item-form">Nº Serial </label><input type="text" name="num_serial" id="num_serial" class="item-form">
			</div>
			<div style="grid-column: 1/3; grid-row: 4">
				<label class="item-form">Franquia </label><input type="text" name="franquia" id="franquia" class="item-form">
			</div>
			<div style="grid-column: 3/5; grid-row: 4">
				<label class="item-form">generos </label><input type="text" name="generos" id="generos" class="item-form">
			</div >
			<div  style="grid-column: 1/3; grid-row: 5">
				<label class="item-form">premios </label><input type="text" name="premios" id="premios" class="item-form">
			</div>
			<div style="grid-column: 3/5; grid-row: 5">
				<label class="item-form">notas </label><input type="text" name="notas" id="notas" class="item-form">
			</div>
			<div style="grid-column: 1/4; grid-row: 6">
				<label class="item-form"> Elenco  </label><input type="text" name="protagonistas" id="protagonistas" class="item-form">
			</div>
			<div style="grid-column: 4; grid-row: 6">
				<label class="item-form">diretor</label><input type="text" name="diretor"  id="diretor" class="item-form">
			</div>
			
			<div style="grid-column: 1/3; grid-row: 7">
				<label class="item-form">produtor</label><input type="text" name='produtor' id='produtor' class="item-form">
			</div>
			<div style="grid-column: 3/5; grid-row: 7">
				<label class="item-form">Distribuidor </label><input type='text' name='destribuidor' id='destribuidor' class="item-form">
			</div>
			<div style="grid-column: 1; grid-row: 8">
				<label class="item-form">Faixa etária </label><input type='text' name='faixa_etaria' id='faixa_etaria' class="item-form">
			</div>
			<div style="grid-column: 2/4; grid-row: 8">
				<label class="item-form">Integridade </label><input type='text' name='integridade' id='integridade' class="item-form">
			</div>
			<div style="grid-column: 4; grid-row: 8">
				<label class="item-form">Data de Lançamento </label><input type='date' name='data_lancamento' id='data_lancamento' class="item-form">
			</div>
			<div style="grid-column: 1/5; grid-row: 9">
				<label class="item-form">Sinopse </label><input type="text" name="sinopse" id='sinopse' class="item-form">
			</div>		
			<div style="grid-column: 1; grid-row: 10">	
				<input class="" type="submit" value="Salvar Filme">
			</div>		
		</form>
	
	</div>
=======
	<c:import url="logout.jsp"/>
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
>>>>>>> parent of a4d7f71 (implementando design)
</body>
<script src="/Locadora/Scripts/viewer.js"></script>
<script src="/Locadora/Scripts/DesenhaDropdown.js"></script>
<script src="/Locadora/Scripts/Pesquisa.js"></script>
<script>	
	var pesquisa = new Pesquisa(${produtos}, ${filmes});
	
	pesquisa.pesquisar()
</script>
</html>
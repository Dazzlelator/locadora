<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="linkMain" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</head>
	<body >
		<div id="usuario_inf" class="grid grid-template-column-2 azul-2">
		
			<div id='iconMenu' class="icon-menu grid-pos-1-1" title="Menu">
				<div class="icon-menu-part"></div>
				<div class="icon-menu-part"></div>
				<div class="icon-menu-part"></div>				
			</div>
			
			<div class="icon-home grid-pos-2-1" onclick="location.href='${main}?action=PaginaInicial';" title="Pagina inicial">
				<div class="icon-home-part1"></div>
				<div class="icon-home-part2"></div>				
			</div>
			
			
			<div class="grid-pos-4-2" style="text-align:right;"><a href="main?action=Logout" class="link">Logout</a></div>
			
			<div  style="text-align:right;" class="grid-pos-4-1 texto-formatado1">${usuarioLogado.nome}</div>
			
			
						
			
		</div>
		<div style="width: 100%;" class="link-area">
				<a href="${main}?action=CatalogarFilmes" class="link"> Todos os filmes  </a>
				<a href="${main}?action=CatalogarJogos" class="link">  Todos os jogos</a>			
		</div>
		
		<div id="menu-body" class="menu-corpo-hidden">
			<div id="menu" class="menu-hidden azul-2" style="text-align: right; line-height: 2.5;">			 
				<div class="texto-formatado1"> Credito: ${usuarioLogado.credito} </div>
				<div><a href="${main}?action=AdicionarCredito" class="link">Adicionar Credito</a></div>	
				<div><a href="${main}?action=ListarAlugados" class="link">Itens Alugados</a></div>
					<c:if test="${usuarioLogado.nivelAcesso >= 2}">
						<div><a href="${main}?id_usuario=${usuarioLogado.id}&action=AdicionarFilme" class="link"> Adicionar Filme </a></div>
						<div><a href="${main}?id_usuario=${usuarioLogado.id}&action=AdicionarJogo" class="link"> Adicionar Jogo</a></div>
					</c:if>
							
					<div><a href="${main}?id=${usuarioLogado.id}&action=AlterarUsuario" class="link">Alterar dados pessoais</a></div>
					<c:if test="${usuarioLogado.nivelAcesso > 2}"> <div> <a href="${main}?action=ListarUsuarios" class="nivel${usuarioLogado.nivelAcesso} link"> Listar usuarios</a> </div></c:if>	
				</div>			
			</div>
	</body>
	
		<script type="text/javascript">
			var menuIcon = document.querySelector('#iconMenu');
			var divMenu = document.querySelector("#menu");
			var menuBody = document.querySelector('#menu-body');
			
			menuIcon.addEventListener('click', ()=>{
			
				if(divMenu.classList.contains("menu-hidden")){

					divMenu.classList.remove('menu-hidden');
					divMenu.classList.add('menu');
					menuBody.classList.remove('menu-corpo-hidden');
					menuBody.classList.add('menu-corpo');
					return;
				}
				
				if(divMenu.classList.contains("menu")){	
			
					divMenu.classList.remove('menu');
					divMenu.classList.add('menu-hidden');
					menuBody.classList.remove('menu-corpo');
					menuBody.classList.add('menu-corpo-hidden');
					return;
									
				}
			})
			
			menuBody.addEventListener("click", ()=> {
				divMenu.classList.remove('menu');
				divMenu.classList.add('menu-hidden');
				menuBody.classList.remove('menu-corpo');
				menuBody.classList.add('menu-corpo-hidden');
				return;
			})
				
			
		
		</script>
</html>
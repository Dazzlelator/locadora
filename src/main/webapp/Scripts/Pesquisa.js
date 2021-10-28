class Pesquisa{
	constructor(dadosParaPesquisar1, dadosParaPesquisar2){
			
	    let $ = document.querySelector.bind(document);
		
		this._dados1 = dadosParaPesquisar1;
		this._dados2 = dadosParaPesquisar2;
		
		
	    this._dadosGuardadosDurantePesquisa = [];
	    
		this._inputIdProduto = $('#id_produto');
	    this._inputNome = $('#nome');
	    this._inputCodProduto = $('#cod_produto');
	    this._inputValor = $('#valor');
	    this._inputValorCusto = $('#valor_custo');
		this._inputValorAluguel = $('#valor_aluguel');
		this._inputValorMulta = $('#valor_multa');
		this._inputQuantidade = $('#quantidade');
		this._inputTipo = $('#tipo')
		
		this._inputNumSerial = $('#num_serial');
		this._inputFranquia = $('#franquia');
		this._inputGeneros = $('#generos');
		this._inputPremios = $('#premios');
		this._inputNotas = $('#notas');
		this._inputProtagonistas = $('#protagonistas');
		this._inputDiretor = $('#diretor');
		this._inputProdutor = $('#produtor');
		this._inputDestribuidor = $('#destribuidor');
		this._inputFaixaEtaria = $('#faixa_etaria');
		this._inputIntegridade = $('#integridade');
		this._inputDataLancamento = $('#data_lancamento');
		this._inputSinopse = $('#sinopse');
			    
	    this._listaDesenhador = new DesenhaDropdown($('#idPesquisa'));        
	}
	
	pesquisar(){
		let listaNomes = [];
		this._dados2.forEach(data => {			
			listaNomes.push(data.nome);		
		})
		
		this._listaDesenhador.formato(this._dados2);
		this._listaDesenhador.update(this._dados2);
		
		var inputKeyWord = document.querySelector('#nome');
		var divNomes = document.querySelector('#idPesquisa');
		var listaNomes2 = document.querySelectorAll('.item_pesquisa');
		
		inputKeyWord.addEventListener('input', function(){
			console.log("teclado!");
			if(inputKeyWord.value.length > 2){
				divNomes.classList.remove('hidden');
				
				for(let i=0; i < listaNomes.length; i++){
					let item = listaNomes2[i];
					let nome = item.textContent;
					
					var express = RegExp(inputKeyWord.value, 'i')
					if(express.test(nome)){
						item.classList.remove('hidden')
					}else{
						item.classList.add('hidden')
					}
				}
			}else{
				for(let i = 0; i<listaNomes.length; i++){
					let item = listaNomes2[i];
					item.classList.add('hidden');
				}
			}
		})
		
		
	}
	
	selectPesquisa(idProduto){
		var divNomes = document.querySelector('#idPesquisa');
		
		this._dados1.forEach(produto => {
			if(idProduto == produto.produtoId){
				
				this._inputIdProduto.value = produto.produtoId;
				this._inputNome.value = produto.nome;
				this._inputCodProduto.value = produto.codProduto;
				this._inputValor.value = produto.valor;
				this._inputValorCusto.value = produto.custo;
				this._inputValorAluguel.value = produto.valorAluguel;
				this._inputValorMulta.value = produto.valorMulta;
				this._inputQuantidade.value = 1;
				this._inputTipo.value = produto.tipo;
			}
		})
		this.selectPesquisa2(idProduto);
		divNomes.classList.add('hidden');
	}
	
	selectPesquisa2(idProduto){
		var divNomes = document.querySelector('#idPesquisa');
		
		this._dados2.forEach(dado=>{
		
			if(idProduto == dado.idProduto){
				this._inputNumSerial.value = dado.numSerial;
				this._inputFranquia.value = dado.franquia;
				this._inputGeneros.value = dado.generos;
				this._inputPremios.value = dado.premios;
				this._inputNotas.value = dado.notas;
				this._inputProtagonistas.value = dado.protagonistas;
				this._inputDiretor.value = dado.diretor;
				this._inputProdutor.value = dado.produtor;
				this._inputDestribuidor.value = dado.destribuidor;
				this._inputFaixaEtaria.value = dado.faixaEtaria;
				this._inputIntegridade.value = dado.integridade;
				this._inputDataLancamento.value = dado.dataLancamento;
				this._inputSinopse.value = dado.sinopse;
			}
		})
		divNomes.classList.add('hidden');
		
	}
}
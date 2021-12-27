package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.helpers.ToJson;
import br.com.locadora.model.Filme;
import br.com.locadora.model.Produto;
import br.com.locadora.services.FilmeService;
import br.com.locadora.services.ProdutoService;

public class AdicionarFilme implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmeService fs = new FilmeService();
		List<Filme> filmes = fs.getGroupByIdProduto();
		
		ProdutoService ps = new ProdutoService();
		List<Produto> produtos = ps.getAll();
		
		//tratamento de data
		
		

		// sobre produto
		String paramIdUsuario = request.getParameter("id");
		String paramCodProduto = request.getParameter("cod_produto");
		String paramNome = request.getParameter("nome");
		String paramValor = request.getParameter("valor");
		String paramValorCusto = request.getParameter("valor_custo");
		String paramQuantidade = request.getParameter("quantidade");
//		String paramDataCadastro = request.getParameter("data_cadastro");
		String paramTipo = request.getParameter("tipo");
		String paramValorAluguel = request.getParameter("valor_aluguel");
		String paramValorMulta = request.getParameter("valor_multa");
		String paramIdProduto = request.getParameter("id_produto");

		// sobre filme;

//		String paramTecnologia = request.getParameter("tipo"); // vai ser a mesma coisa q o tipo do produto pq eh, de
//																// fato, a mesma coisa...
		String paramNumSerial = request.getParameter("num_serial");
		String paramFranquia = request.getParameter("franquia");
		String paramGeneros = request.getParameter("generos");
		String paramPremios = request.getParameter("premios");
		String paramNotas = request.getParameter("notas");
		String paramProtagonistas = request.getParameter("protagonistas");
		String paramDiretor = request.getParameter("diretor");
		String paramProdutor = request.getParameter("produtor");
		String paramDestribuidor = request.getParameter("destribuidor");
		String paramFaixaEtaria = request.getParameter("faixa_etaria");
		String paramIntegridade = request.getParameter("integridade");
		String paramDataLancamento = request.getParameter("data_lancamento");
//		String dataCadastro
		String paramStatus = "disponivel";
		String paramSinopse = request.getParameter("sinopse");
		
		String jsonFilmes = new ToJson().converter(filmes);
		
		String jsonProdutos = new ToJson().converter(produtos);
		
		request.setAttribute("filmes", jsonFilmes);
		request.setAttribute("produtos", jsonProdutos);		
		
		if (paramNome != null) {
			List<Produto> produtosPorNome = ps.getAllByNome(paramNome);
			Produto produto = null;			
			Boolean checkProduto = false;
			
			if(produtosPorNome != null) {
				for(int i = 0; i < produtosPorNome.size(); i++) {
					if(paramTipo.equals(produtosPorNome.get(i).getTipo())) {
						checkProduto = true;
						produto = produtosPorNome.get(i);
					}
				}				
			}
			
			DateHelper dataLancamento = new DateHelper(paramDataLancamento);
			
			if(checkProduto) {
				Integer idProduto = Integer.valueOf(paramIdProduto);
				Integer quantidade = Integer.valueOf(paramQuantidade);
				
				ps.addQuantidade(idProduto, quantidade);
				
				Filme filme = new Filme(produto.getProdutoId(), produto.getTipo(), paramNumSerial, produto.getNome(),
					paramFranquia, paramGeneros, paramPremios, paramNotas, paramProtagonistas, paramDiretor,
					paramProdutor, paramDestribuidor, paramFaixaEtaria, paramIntegridade, dataLancamento.getData(),
					new Date(), paramStatus, paramSinopse);
				
				
				while(quantidade > 0) {
					fs.salvar(filme);
					quantidade--;
				}
				
				System.out.println("Filme salvo com sucesso!");
				
			}

			if (!checkProduto) {
				Integer idUsuario = Integer.valueOf(paramIdUsuario);
				Double valor = Double.valueOf(paramValor);
				Double valorCusto = Double.valueOf(paramValorCusto);
				Integer quantidade = Integer.valueOf(paramQuantidade);
				Double valorAluguel = Double.valueOf(paramValorAluguel);
				Double valorMulta = Double.valueOf(paramValorMulta);			
				
				Produto novoProduto = new Produto(idUsuario, paramCodProduto, paramNome, valor, valorCusto, quantidade, new Date(), paramTipo, valorAluguel, valorMulta);
				
				novoProduto = ps.getById(ps.salvar(novoProduto));
				
				
				Filme filme = new Filme(novoProduto.getProdutoId(), novoProduto.getTipo(), paramNumSerial, novoProduto.getNome(),
						paramFranquia, paramGeneros, paramPremios, paramNotas, paramProtagonistas, paramDiretor,
						paramProdutor, paramDestribuidor, paramFaixaEtaria, paramIntegridade, dataLancamento.getData(),
						new Date(), paramStatus, paramSinopse);	
				
				while(quantidade > 0) {
					fs.salvar(filme);
					quantidade--;
				}
				System.out.println("Filme e produto salvos com sucesso!");
				
			}
			return "redirect:CatalogarFilmes"; // lancar um rediretc pra lista de filmes, talvez...
			
		} else {

			return "dispatcher:form-filme-salvar.jsp";

		}

	}

}

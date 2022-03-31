package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.helpers.ToJson;
import br.com.locadora.model.Jogo;
import br.com.locadora.model.Produto;
import br.com.locadora.model.Usuario;
import br.com.locadora.services.JogoService;
import br.com.locadora.services.ProdutoService;
import br.com.locadora.services.UsuarioService;

public class AdicionarJogo implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JogoService js = new JogoService();
		List<Jogo> jogos = js.getGroupByIdProduto();

		ProdutoService ps = new ProdutoService();
		List<Produto> produtos = ps.getAll();

		// sobre produto
		String paramIdUsuario = request.getParameter("id");
		String paramCodProduto = request.getParameter("cod_produto");
		String paramNome = request.getParameter("nome");
		String paramValor = request.getParameter("valor");
		String paramValorCusto = request.getParameter("valor_custo");
		String paramQuantidade = request.getParameter("quantidade");
		String paramTipo = request.getParameter("tipo");
		String paramValorAluguel = request.getParameter("valor_aluguel");
		String paramValorMulta = request.getParameter("valor_multa");
		String paramIdProduto = request.getParameter("id_produto");

		// sobre jogo
		String paramNumSerial = request.getParameter("num_serial");
		String paramFranquia = request.getParameter("franquia");
		String paramGeneros = request.getParameter("generos");
		String paramPremios = request.getParameter("premios");
		String paramNotas = request.getParameter("notas");
		String paramProdutor = request.getParameter("produtor");
		String paramDestribuidor = request.getParameter("destribuidor");
		String paramFaixaEtaria = request.getParameter("faixa_etaria");
		String paramIntegridade = request.getParameter("integridade");
		String paramDataLancamento = request.getParameter("data_lancamento");
		String paramStatus = "disponivel";

		String jsonJogos = new ToJson().converter(jogos);
		String jsonProdutos = new ToJson().converter(produtos);

		request.setAttribute("jogos", jsonJogos);
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
			
			if (checkProduto) {
				Integer idProduto = Integer.valueOf(paramIdProduto);
				Integer quantidade = Integer.valueOf(paramQuantidade);

				ps.addQuantidade(idProduto, quantidade);

				Jogo jogo = new Jogo(produto, produto.getTipo(), paramNumSerial, produto.getNome(),
						paramFranquia, paramGeneros, paramPremios, paramNotas, paramProdutor, paramDestribuidor,
						paramFaixaEtaria, paramIntegridade, dataLancamento.getData(), new Date(), paramStatus);
				
				while(quantidade > 0) {
					js.salvar(jogo);
					quantidade--;
				}
				
				System.out.println("Jogo salvo com sucesso!");

			}
			if(!checkProduto) { 
				Integer idUsuario = Integer.valueOf(paramIdUsuario);
				Double valor = Double.valueOf(paramValor);
				Double valorCusto = Double.valueOf(paramValorCusto);
				Integer quantidade = Integer.valueOf(paramQuantidade);
				Double valorAluguel = Double.valueOf(paramValorAluguel);
				Double valorMulta = Double.valueOf(paramValorMulta);
				
				UsuarioService us = new UsuarioService();
				Usuario usuario = us.getById(idUsuario);
				
				Produto novoProduto = new Produto(usuario, paramCodProduto, paramNome, valor, valorCusto, quantidade, new Date(), paramTipo, valorAluguel, valorMulta);
				
				ps.salvar(novoProduto);
				
				Jogo jogo = new Jogo(novoProduto, novoProduto.getTipo(), paramNumSerial, novoProduto.getNome(),
						paramFranquia, paramGeneros, paramPremios, paramNotas, paramProdutor, paramDestribuidor,
						paramFaixaEtaria, paramIntegridade, dataLancamento.getData(), new Date(), paramStatus);
				
				while(quantidade > 0) {
					js.salvar(jogo);
					quantidade--;
				}
			}
			return "redirect:CatalogarJogos";
		}else {
			return "dispatcher:form-jogo-salvar.jsp";
 
		}

		
	}

}

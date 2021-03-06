package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.helpers.NumberHelper;
import br.com.locadora.model.Produto;
import br.com.locadora.services.FilmeService;
import br.com.locadora.services.JogoService;
import br.com.locadora.services.ProdutoService;

public class InfoProduto implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramIdFilme = request.getParameter("id");
		String paramIdJogo = request.getParameter("id_jogo");
		ProdutoService ps = new ProdutoService();
		NumberHelper nb = new NumberHelper();
		
		if(paramIdFilme != null) {
			
			Integer IdFilme = Integer.valueOf(paramIdFilme);
			FilmeService fs = new FilmeService();
			Integer idProduto = fs.getById(IdFilme).getIdProduto();			
			
			Produto produto = ps.getById(idProduto);
			String valorAluguelFormatado =  "R$ " + nb.pontoToVirgula(produto.getValorAluguel());
			String multaFormatada = "R$ " + nb.pontoToVirgula(produto.getValorMulta());
			
			request.setAttribute("produto", produto);
			request.setAttribute("aluguelEmReal", valorAluguelFormatado);
			request.setAttribute("multaEmReal", multaFormatada);
			
			return "dispatcher:info-produto.jsp";
		}
			
		if(paramIdJogo != null) {
			Integer idJogo = Integer.valueOf(paramIdJogo);
			JogoService js = new JogoService();
			Integer idProduto = js.getById(idJogo).getIdProduto();
			
			Produto produto = ps.getById(idProduto);
			String valorAluguelFormatado =  "R$ " + nb.pontoToVirgula(produto.getValorAluguel());
			String multaFormatada = "R$ " + nb.pontoToVirgula(produto.getValorMulta());
			
			request.setAttribute("produto", produto);
			request.setAttribute("aluguelEmReal", valorAluguelFormatado);
			request.setAttribute("multaEmReal", multaFormatada);
			
			return "dispatcher:info-produto.jsp";
		}
		
		return "dispatcher:info-produto.jsp";		
	}

}

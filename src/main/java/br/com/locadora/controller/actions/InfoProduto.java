package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Produto;
import br.com.locadora.services.FilmeService;
import br.com.locadora.services.ProdutoService;

public class InfoProduto implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramIdFilme = request.getParameter("id");
		Integer IdFilme = Integer.valueOf(paramIdFilme);
		FilmeService fs = new FilmeService();
		Integer idProduto = fs.getById(IdFilme).getIdProduto();
		
		
		ProdutoService ps = new ProdutoService();
		Produto produto = ps.getById(idProduto);
		
		request.setAttribute("produto", produto);
		
		return "dispatcher:info-produto.jsp";
	}

}

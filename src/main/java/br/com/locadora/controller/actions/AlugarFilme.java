package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Filme;
import br.com.locadora.model.Produto;
import br.com.locadora.model.Usuario;
import br.com.locadora.services.AluguelService;
import br.com.locadora.services.FilmeService;
import br.com.locadora.services.ProdutoService;
import br.com.locadora.services.UsuarioService;

public class AlugarFilme implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmeService fs = new FilmeService();
		AluguelService as = new AluguelService();
		ProdutoService ps = new ProdutoService();
		UsuarioService us = new UsuarioService();
		
		String paramIdUsuario = request.getParameter("id_usuario");	
		Integer idUsuario = Integer.valueOf(paramIdUsuario);
		Usuario usuario = us.getById(idUsuario);
		Double credito = usuario.getCredito();
		
		String paramIdFilme = request.getParameter("id_filme");
		Integer idFilme = Integer.valueOf(paramIdFilme);
		Filme filme = fs.getById(idFilme);
		
		Integer idProduto = filme.getIdProduto();
		Produto produto = ps.getById(idProduto);
		Double valorAluguel = produto.getValorAluguel();
		Double valorMulta = produto.getValorMulta();

		Aluguel aluguel = new Aluguel(idUsuario, idFilme, null, valorAluguel, valorMulta);
		
		if(credito > valorAluguel) {
			as.salvar(aluguel);
			us.addCredito(idUsuario, -valorAluguel);
			HttpSession sess = request.getSession();
			sess.setAttribute("usuarioLogado",  usuario);
			
			return "dispatcher:lista-alugados.jsp";
		}else {
			return "dispatcher:adicionar-credito.jsp";
		}
	}

}

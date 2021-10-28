package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Jogo;
import br.com.locadora.model.Produto;
import br.com.locadora.model.Usuario;
import br.com.locadora.services.AluguelService;
import br.com.locadora.services.JogoService;
import br.com.locadora.services.ProdutoService;
import br.com.locadora.services.UsuarioService;

public class AlugarJogo implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JogoService js = new JogoService();
		AluguelService as = new AluguelService();
		ProdutoService ps = new ProdutoService();
		UsuarioService us = new UsuarioService();
		
		String paramIdUsuario = request.getParameter("id_usuario");	
		Integer idUsuario = Integer.valueOf(paramIdUsuario);
		Usuario usuario = us.getById(idUsuario);
		Double credito = usuario.getCredito();
		
		String paramIdJogo = request.getParameter("id_jogo");
		Integer idJogo = Integer.valueOf(paramIdJogo);
		Jogo jogo = js.getById(idJogo);
		
		Integer idProduto = jogo.getIdProduto();
		Produto produto = ps.getById(idProduto);
		Double valorAluguel = produto.getValorAluguel();
		Double valorMulta = produto.getValorMulta();

		Aluguel aluguel = new Aluguel(idUsuario, null , idJogo, valorAluguel, valorMulta, valorAluguel, valorAluguel);
		
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

package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Jogo;
import br.com.locadora.services.JogoService;

public class CatalogarJogosLancamento implements Acao{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		JogoService js = new JogoService();
		List<Jogo> jogos = js.getLancamento(1); //mes 1
		
		request.setAttribute("jogos", jogos);
		
		return "dispatcher:catalogo-lancamento.jsp";
				
	}
}

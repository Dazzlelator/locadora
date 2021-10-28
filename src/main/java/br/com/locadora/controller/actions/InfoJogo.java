package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Jogo;
import br.com.locadora.services.JogoService;

public class InfoJogo implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramVariacao = request.getParameter("variacao");
		
		String ParamIdJogo = request.getParameter("id_jogo");
		Integer idJogo = Integer.valueOf(ParamIdJogo);
		
		JogoService js = new JogoService();
		Jogo jogo = js.getById(idJogo);
		
		request.setAttribute("jogo", jogo);
		
		if(paramVariacao == null) {
			
			return "dispatcher:info-jogo.jsp";
			
		}
		if("alugado".equals(paramVariacao)){
			return "dispatcher:info-jogo-alugado.jsp";
		}
		
		return null;
	}

}

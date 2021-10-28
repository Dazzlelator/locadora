package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Jogo;
import br.com.locadora.services.AluguelService;
import br.com.locadora.services.JogoService;

public class JogosAlugados implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AluguelService as = new AluguelService();
		JogoService js = new JogoService();
			
		String idUsuarioParam = request.getParameter("id");
		Integer idUsuario = Integer.valueOf(idUsuarioParam);
	
		List<Aluguel> alugados = as.getAllAtivosById(idUsuario);
		List<Jogo> jogosAlugados = new ArrayList<>();
		
		for(int i=0; i < alugados.size(); i++) {
			Integer idJogo = alugados.get(i).getIdJogo();
			if(idJogo != null && idJogo != 0) {
				
				jogosAlugados.add(js.getById(idJogo));
				
			}			
		}
		
		request.setAttribute("jogos", jogosAlugados);
		
		return "dispatcher:jogos-alugados.jsp";
	}

}

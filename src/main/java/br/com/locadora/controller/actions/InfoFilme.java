package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Filme;
import br.com.locadora.services.AluguelService;
import br.com.locadora.services.FilmeService;

public class InfoFilme implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramVariacao = request.getParameter("variacao");
		
		String paramIDFilme = request.getParameter("id_filme");
		Integer idFilme = Integer.valueOf(paramIDFilme);
		
		FilmeService fs = new FilmeService();
		Filme filme = fs.getById(idFilme);
		
		request.setAttribute("filme", filme);
		
		if(paramVariacao == null) {	
			
			return "dispatcher:info-filme.jsp";
		}
		if(paramVariacao.equals("alugado")) {//			
			
			return "dispatcher:info-filme-alugado.jsp";
		}
		
		return "redirect:PaginaInicial";	
	}

}

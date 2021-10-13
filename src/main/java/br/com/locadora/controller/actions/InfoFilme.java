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
		
		if(paramVariacao == null) {
			String paramIDFilme = request.getParameter("id_filme");
			Integer idFilme = Integer.valueOf(paramIDFilme);
			
			FilmeService fs = new FilmeService();
			Filme filme = fs.getById(idFilme);
			
			request.setAttribute("filme", filme);
			
			return "dispatcher:info-filme.jsp";
		}
		if(paramVariacao.equals("alugado")) {			
			String paramIDFilme = request.getParameter("id_filme");
			Integer idFilme = Integer.valueOf(paramIDFilme);
			String paramIdUsuario = request.getParameter("id_usuario");
			Integer idUsuario = Integer.valueOf(paramIdUsuario);
			
			FilmeService fs = new FilmeService();
			Filme filme = fs.getById(idFilme);
			
			AluguelService as = new AluguelService();
			Aluguel aluguel = as.getFilmeAtivoByIdUsuarioByIdFilme(idUsuario, idFilme);
			
			request.setAttribute("filme", filme);
//			request.setAttribute("aluguel", aluguel);
			
			return "dispatcher:info-filme-alugado.jsp";
		}
		
		return "redirect:PaginaInicial";	
	}

}

package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Filme;
import br.com.locadora.services.AluguelService;
import br.com.locadora.services.FilmeService;

public class FilmesAlugados implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AluguelService as = new AluguelService();
		FilmeService fs = new FilmeService();
		
		
		String idUsuarioParam = request.getParameter("id");
		Integer idUsuario = Integer.valueOf(idUsuarioParam);
		
		
		List<Aluguel> alugados = as.getAllAtivosById(idUsuario);
		
		List<Filme> filmesAlugados = new ArrayList<>();
		for(int i=0; i < alugados.size(); i++) {
			Integer idFilme = alugados.get(i).getIdFilme();
			if(idFilme != null) {
				filmesAlugados.add(fs.getById(idFilme));
			}			
		}
		
		request.setAttribute("filmes", filmesAlugados);
		
		return "dispatcher:filmes-alugados.jsp";
	}

}

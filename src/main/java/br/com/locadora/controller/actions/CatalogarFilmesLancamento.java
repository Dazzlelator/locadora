package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Filme;
import br.com.locadora.services.FilmeService;

public class CatalogarFilmesLancamento implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		FilmeService fs = new FilmeService();
		List<Filme> filmes = fs.getLancamento(1); //mes 1
		
		request.setAttribute("filmes", filmes);
		
		return "dispatcher:catalogo-lancamento.jsp";
				
	}
	
}

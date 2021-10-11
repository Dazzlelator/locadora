package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Filme;
import br.com.locadora.services.FilmeService;

public class InfoFilme implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID);
		
		FilmeService fs = new FilmeService();
		Filme filme = fs.getById(id);
		
		request.setAttribute("filme", filme);
		
		return "dispatcher:info-filme.jsp";
	}

}

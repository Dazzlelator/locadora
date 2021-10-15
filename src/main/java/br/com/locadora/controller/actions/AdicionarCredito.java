package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.model.Usuario;
import br.com.locadora.services.UsuarioService;

public class AdicionarCredito implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioService us = new UsuarioService();
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		String paramValor = request.getParameter("valor");
		Double credito = Double.valueOf(paramValor);
		
		us.addCredito(id, credito);
		Usuario user = us.getById(id);
		
		HttpSession sess = request.getSession();
		sess.setAttribute("usuarioLogado",  user);
		
		return "redirect:CatalogarFilmes";
	}

}

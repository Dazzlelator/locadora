package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.services.UsuarioService;

public class DeletarUsuario {
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		UsuarioService us = new UsuarioService();
		us.deletar(id);
		
		return "redirect:main?action=listarUsuarios";
	}
}

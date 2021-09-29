package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Usuario;
import br.com.locadora.services.UsuarioService;

public class ListarUsuarios {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		UsuarioService us = new UsuarioService();
		List<Usuario> usuarios = us.getAll();
		
		request.setAttribute("usuarios", usuarios);
		
		return "dispatcher:/view/listaUsuarios.jsp";		
	}

}

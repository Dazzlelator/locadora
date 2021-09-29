package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Usuario;
import br.com.locadora.services.UsuarioService;

public class CadastrarUsuario {
	public String executar(HttpServletRequest request, HttpServletResponse response){
		
			if(request.getParameter("action").equals("cadastrarUsuario")) {
				return "dispatcher:/view/form-usuario-salvar.jsp";
				
			}else if(request.getParameter("action").equals("salvarUsuario")) {
				String nome = request.getParameter("nome");
				String senha = request.getParameter("senha");
				String cpf = request.getParameter("cpf");
				String nascimento = request.getParameter("nascimento");
				String telefone = request.getParameter("telefone");
				String email = request.getParameter("email");
				String endereco = request.getParameter("endereco");		
				
				DateHelper dataNascimento = new DateHelper(nascimento);
				
				Usuario user = new Usuario(nome, senha, cpf, dataNascimento.getData(), telefone, email, endereco);
				UsuarioService us = new UsuarioService();
				us.salvar(user);
				
				return "redirect:main?action=listarUsuarios";
			}
			return "redirect:main?action=listarUsuarios";	
	}
}

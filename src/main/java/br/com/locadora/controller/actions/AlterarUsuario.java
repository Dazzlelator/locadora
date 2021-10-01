package br.com.locadora.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Usuario;
import br.com.locadora.services.UsuarioService;

public class AlterarUsuario implements Acao{
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);			
		UsuarioService us = new UsuarioService();
		Usuario user = us.getById(id);
		
		if(request.getParameter("nome") == null) {			
			
			request.setAttribute("usuario", user);
			
			return "dispatcher:/form-usuario-alterar.jsp";
		}else {
			
			String paramNome = request.getParameter("nome");
			String paramSenha = request.getParameter("senha");
			String paramCPF = request.getParameter("cpf");
			String paramNascimento = request.getParameter("nascimento");
			String paramTelefone = request.getParameter("telefone");
			String paramEmail = request.getParameter("email");
			String paramEndereco = request.getParameter("endereco");
			
			DateHelper nascimento = new DateHelper(paramNascimento);
			
			user.setNome(paramNome);
			user.setSenha(paramSenha);
			user.setCpf(paramCPF);
			user.setDataNascimento(nascimento.getData());
			user.setTelefone(paramTelefone);
			user.setEmail(paramEmail);
			user.setEndereco(paramEndereco);
			
			us.updateByid(id, user);
			
			return "response:ListarUsuarios";
			
			
		}
		
		
	}
}

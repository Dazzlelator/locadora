package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.model.Usuario;
import br.com.locadora.services.UsuarioService;

public class Login implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String paramEmail = request.getParameter("email");
			String paramSenha = request.getParameter("senha");
		
			UsuarioService us = new UsuarioService();
			Usuario user = us.getByEmail(paramEmail);
			
			Boolean userCheck = us.check(paramEmail, paramSenha);
		

			if(userCheck) {
				HttpSession sess = request.getSession();
				sess.setAttribute("usuarioLogado",  user);
				return "redirect:ListarUsuarios";				
			}else {				
				return "redirect:Home";
			}
		
		
	}

}

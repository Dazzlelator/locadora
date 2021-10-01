package br.com.locadora.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarUsuario implements Acao{
	public String executar(HttpServletRequest request, HttpServletResponse response){
		
		return "dispatcher:form-usuario-salvar.jsp";	
			
	}
}

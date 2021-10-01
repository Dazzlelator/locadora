package br.com.locadora.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home implements Acao{
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		return "dispatcher:index.jsp";
		
	}
}

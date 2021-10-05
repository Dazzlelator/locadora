package br.com.locadora.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.model.Usuario;

/**
 * Servlet Filter implementation class FiltroAutorizacao
 */
//@WebFilter("/main")
public class FiltroAutorizacao implements Filter {

 
    public FiltroAutorizacao() {
     
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("action");
		
		HttpSession sess = request.getSession();
		
		Boolean usuarioLogado = (sess.getAttribute("usuarioLogado") != null);
		Boolean acaoLivre = (paramAcao.equals("Login") || paramAcao.equals("Home") || paramAcao.equals("CadastrarUsuario") || paramAcao.equals("SalvarUsuario"));
		
		if(usuarioLogado) {
			Usuario user = (Usuario) sess.getAttribute("usuarioLogado");
			System.out.println(user.getNivelAcesso() + " nivel de acesso!");
		}
		
		if(!usuarioLogado && !acaoLivre) {
			response.sendRedirect("main?action=Home");
			return;
		}else {
			System.out.println(paramAcao);	
			chain.doFilter(request, response);
		}
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}

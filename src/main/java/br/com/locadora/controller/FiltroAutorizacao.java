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
@WebFilter("/main")
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
		Integer nivelAcesso = 1;
	
		
		
		HttpSession sess = request.getSession();
		
		Boolean usuarioLogado = (sess.getAttribute("usuarioLogado") != null);
		
		Boolean acaoLivre = (
				paramAcao.equals("Login") || 
				paramAcao.equals("Home") || 
				paramAcao.equals("CadastrarUsuario") || 
				paramAcao.equals("SalvarUsuario") || 
				paramAcao.equals("CatalogarFilmesLancamento") ||
				paramAcao.equals("CatalogarJogosLancamento")  ||
				paramAcao.equals("CatalogarFIlmes") ||
				paramAcao.equals("CatalogarJogos")
				);		
		Boolean acaoNivel2 = (
				paramAcao.equals("AdicionarFilme") ||
				paramAcao.equals("AdicionarJogo")
				);
		Boolean acaoNivel3 = (
				paramAcao.equals("ListarUsuarios")
				);	
		
		if(usuarioLogado) {			
			Usuario user = (Usuario) sess.getAttribute("usuarioLogado");
					nivelAcesso = user.getNivelAcesso();		
			
		}
		
		
		if(!usuarioLogado && !acaoLivre) {
			response.sendRedirect("main?action=Home");
			return;
		}else {			
			switch(nivelAcesso) {
				case 1:
					if(!acaoNivel3 && !acaoNivel2) {
						System.out.println("nivel 1");
						chain.doFilter(request, response);
						break;
					}else {
						response.sendRedirect("main?action=PaginaInicial");
						break;
					}
				case 2:
					if(!acaoNivel2) {
						System.out.println("nivel 2");
						chain.doFilter(request, response);
						break;
					}else {						
						response.sendRedirect("main?action=PaginaInicial");
						break;
					}
				case 3:
					System.out.println("nivel 3");
					chain.doFilter(request, response);
					break;
				default:
					System.out.println("Erro ao ler nivel de acesso!");
					System.out.println(nivelAcesso);
			}
				
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}

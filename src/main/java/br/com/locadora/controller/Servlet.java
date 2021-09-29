package br.com.locadora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.controller.actions.AlterarUsuario;
import br.com.locadora.controller.actions.CadastrarUsuario;
import br.com.locadora.controller.actions.DeletarUsuario;
import br.com.locadora.controller.actions.ListarUsuarios;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/main")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stringTipoEndereco = null;
		String paramAcao = request.getParameter("action");
		System.out.println(paramAcao);
		
		
		if("listarUsuarios".equals(paramAcao)) {
			ListarUsuarios lu = new ListarUsuarios();
			stringTipoEndereco = lu.executar(request, response);
		}if("cadastrarUsuario".equals(paramAcao)) {
			CadastrarUsuario fu = new CadastrarUsuario();
			stringTipoEndereco = fu.executar(request, response);			
		}if("salvarUsuario".equals(paramAcao)) {
			CadastrarUsuario fu = new CadastrarUsuario();
			stringTipoEndereco = fu.executar(request, response);
		}if("alterarUsuario".equals(paramAcao)) {			
			AlterarUsuario au = new AlterarUsuario();
			stringTipoEndereco = au.executar(request, response);
		}if("deletarUsuario".equals(paramAcao)) {
			DeletarUsuario du = new DeletarUsuario();
			stringTipoEndereco = du.executar(request, response);
		}
		
		String[] tipo_endereco = stringTipoEndereco.split(":");
		
		if(tipo_endereco[0].equals("dispatcher")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipo_endereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipo_endereco[1]);
		}
		
		//dessa forma o servlet fica responsavel por redirecionar os JSPs ao inves das actions
		//que agora apenas retornam o endereco q o servlet deve redirecionar.	
		
		
	}

}

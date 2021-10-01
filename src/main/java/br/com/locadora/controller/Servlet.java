package br.com.locadora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.controller.actions.Acao;
import br.com.locadora.controller.actions.AlterarUsuario;
import br.com.locadora.controller.actions.CadastrarUsuario;
import br.com.locadora.controller.actions.DeletarUsuario;
import br.com.locadora.controller.actions.Home;
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

	@SuppressWarnings({ "deprecation", "rawtypes" })
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stringTipoEndereco = null;
		String paramAcao = request.getParameter("action");
		String nomeClasse = "br.com.locadora.controller.actions." + paramAcao; //primeiro vc cria a String do pacote onde será econtrado as actions.

		
		//isso daqui é uma forma genial de chamar uma classe usando a string q vem do request parameter!	
		try {
			Class classe = Class.forName(nomeClasse); //segundo vc invoca a classe usando o metodo forName.
			Acao acao = (Acao) classe.newInstance(); // terceiro vc instancia a classe e casta o tipo dela.
			stringTipoEndereco = acao.executar(request, response); //com a classe instanciada e com o tipo definido, vc usa o metodo executar que essas classes devem possuir
			
		} catch (ClassNotFoundException|InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}		
			
		
		System.out.println(paramAcao);


		String[] tipo_endereco = stringTipoEndereco.split(":");

		if (tipo_endereco[0].equals("dispatcher")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + tipo_endereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("main?action="+tipo_endereco[1]);
		}

	}

}

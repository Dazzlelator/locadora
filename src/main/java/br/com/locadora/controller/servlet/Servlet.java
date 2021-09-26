package br.com.locadora.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.controller.ProdutoController;
import br.com.locadora.model.Produto;

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
//		String nome = request.getParameter("nome");
//		String senha = request.getParameter("senha");
//		String cpf = request.getParameter("cpf");
//		String nascimento = request.getParameter("nascimento");
//		String telefone = request.getParameter("telefone");
//		String email = request.getParameter("email");
//		String endereco = request.getParameter("endereco");
//		
//		System.out.println(nascimento);
//		
//		DateHelper dataNascimento = new DateHelper(nascimento);
//		
//		Usuario user = new Usuario(nome, senha, cpf, dataNascimento.getData(), telefone, email, endereco);
//		UsuarioController uc = new UsuarioController();
//		uc.salvar(user);
		
		ProdutoController pc = new ProdutoController();
		List<Produto> produtos = pc.getAll();
		
		
		request.setAttribute("produtos", produtos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/resposta.jsp");
		rd.forward(request, response);
		
	}

}

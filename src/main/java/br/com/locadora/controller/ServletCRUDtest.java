//package br.com.locadora.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.locadora.helpers.DateHelper;
//import br.com.locadora.model.Usuario;
//import br.com.locadora.services.UsuarioService;
//
///**
// * Servlet implementation class ServletCRUDtest
// */
//@WebServlet(name = "deletarUsuario", urlPatterns = { "/alterarUsuario" })
//public class ServletCRUDtest extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//    public ServletCRUDtest() {
//        super();
//    }
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		
//		UsuarioService uc = new UsuarioService();
//		String paramId = request.getParameter("id");
//		String paramNome = request.getParameter("nome");
//		Integer id = Integer.valueOf(paramId);		
//		Usuario user = uc.getById(id);
//		
//		if(paramNome == null) {			
//			request.setAttribute("usuario", user);
//			
//			
//			RequestDispatcher rd = request.getRequestDispatcher("/formularioDeAlteracao.jsp");
//			rd.forward(request, response);
//			
//		}else {
//			String paramId2 = request.getParameter("id");
//			String nome = request.getParameter("nome");
//			String senha = request.getParameter("senha");
//			String cpf = request.getParameter("cpf");
//			String data = request.getParameter("nascimento");
//			String telefone = request.getParameter("telefone");
//			String email = request.getParameter("email");
//			String endereco = request.getParameter("endereco");
//			
//			DateHelper nascimento = new DateHelper(data); 
//			Integer id2 = Integer.valueOf(paramId2);
//			
//			user.setNome(nome);
//			user.setSenha(senha);
//			user.setCpf(cpf);
//			user.setDataNascimento(nascimento.getData());
//			user.setTelefone(telefone);
//			user.setEmail(email);
//			user.setEndereco(endereco);
//			
//			uc.updateByid(id2, user);
//			
//			response.sendRedirect("main");
//			
//		}
//		
//		
//		
//	
//	}
//		
//		
//
//}

package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Usuario;
import br.com.locadora.services.AluguelService;
import br.com.locadora.services.UsuarioService;

public class DevolverFime implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramIdUsuario = request.getParameter("id_usuario");
		Integer idUsuario = Integer.valueOf(paramIdUsuario);
		
		String paramIdFilme = request.getParameter("id_filme");
		Integer idFilme = Integer.valueOf(paramIdFilme);
		
		UsuarioService us = new UsuarioService();
		Usuario usuario = us.getById(idUsuario);
		
		AluguelService as = new AluguelService();
		Aluguel aluguel = as.getFilmeAtivoByIdUsuarioByIdFilme(idUsuario, idFilme);
		
		if(usuario.getCredito() >= aluguel.getMulta()) {
			as.updateDataDevolvido(aluguel.getIdAluguel(), new Date());
			System.out.println("Aluguel de id " +aluguel.getIdAluguel() +" foi devolvido com sucesso!");
			return "redirect:ListarAlugados";
		}else {
			System.out.println("Sem credito suficiente para transação");
			return "redirect:AdicionarCredito";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

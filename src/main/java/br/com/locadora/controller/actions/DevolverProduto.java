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

public class DevolverProduto implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramIdUsuario = request.getParameter("id_usuario");
		Integer idUsuario = Integer.valueOf(paramIdUsuario);
	
		String paramIdAluguel = request.getParameter("id_aluguel");
		Integer idAluguel = Integer.valueOf(paramIdAluguel);
		
		UsuarioService us = new UsuarioService();
		AluguelService as = new AluguelService();
		
		Usuario usuario = us.getById(idUsuario);
		
		Aluguel aluguel = as.getById(idAluguel);
		
		Double multa = as.getValorMulta(idAluguel);
		
		if(usuario.getCredito() >= multa) {
			as.updateDataDevolvido(aluguel.getIdAluguel(), new Date());
			as.updateValorTotal(idAluguel);
			us.addCredito(idUsuario, -multa);
			
			System.out.println("Aluguel de id " + aluguel.getIdAluguel() +" foi devolvido com sucesso!");
			return "redirect:ListarAlugados";
		}else {
			System.out.println("Sem credito suficiente para transação");
			return "redirect:AdicionarCredito";
		}
		
		
	}

}

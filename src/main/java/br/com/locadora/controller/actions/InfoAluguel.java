package br.com.locadora.controller.actions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;
import br.com.locadora.services.AluguelService;

public class InfoAluguel implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramIdUsuario = request.getParameter("id_usuario");		
		String paramIdFilme = request.getParameter("id_filme");
		
		AluguelService as = new AluguelService();
		
		
		if(paramIdUsuario != null && paramIdFilme != null) {
			Integer idUsuario = Integer.valueOf(paramIdUsuario);
			Integer idFilme = Integer.valueOf(paramIdFilme);
			
			Aluguel aluguel = as.getFilmeAtivoByIdUsuarioByIdFilme(idUsuario, idFilme);
		
			
			Date agora = new Date();
			Date dataDevolucao = aluguel.getDataDevolucao();
			DateHelper subtracao = new DateHelper();
			
			Double diasRestantes = (subtracao.subtrairDias(agora, dataDevolucao)/86400000.0) + (1.0); //1 pra corrigir o arredondamento
			Integer valorReduzido = diasRestantes.intValue();
			Double multa = as.getValorMulta(aluguel.getIdAluguel());

			request.setAttribute("multa", multa);
			request.setAttribute("diasRestantes", valorReduzido);
			request.setAttribute("aluguel", aluguel);
			
		}else {
			Aluguel aluguel = as.getById(2);
			aluguel.setDataDevolucao(as.getDataDevolucaoPreview());
			request.setAttribute("aluguel", aluguel);
		}
		
		return "dispatcher:info-aluguel.jsp";
	}

}

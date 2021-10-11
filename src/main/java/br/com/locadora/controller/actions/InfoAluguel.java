package br.com.locadora.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.model.Aluguel;
import br.com.locadora.services.AluguelService;

public class InfoAluguel implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AluguelService as = new AluguelService();
		Aluguel aluguel = as.getParamAluguel();
		aluguel.setDataDevolucao(as.getDataDevolucaoPreview());
		
		request.setAttribute("aluguel", aluguel);
		
		
		return "dispatcher:info-aluguel.jsp";
	}

}

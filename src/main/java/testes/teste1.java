package testes;

import java.util.Date;

import br.com.locadora.controller.AluguelController;
import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;

public class teste1 {

	public static void main(String[] args) {

		
		Date agora = new Date();
		DateHelper devolucao = new DateHelper(agora);	
		
		Aluguel aluguel = new Aluguel(3, null,  7, 15.0, 5.0, agora, null, null, 1);
		AluguelController ac = new AluguelController();
//		
//		ac.salvar(aluguel);
//		ac.updateById(21, aluguel);
//		ac.deletar(24);
//		System.out.println(ac.getAll().get(10).getDataDevolucao());
//		System.out.println(ac.getById(22).getIdAluguel());
//		System.out.println(ac.getFilmes().size());
	}

}

package testes;

import java.util.Date;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;
import br.com.locadora.services.AluguelService;

public class teste1 {

	public static void main(String[] args) {

		
		Date agora = new Date();
		DateHelper devolucao = new DateHelper("2021-09-25");	
		
		
		Aluguel aluguel = new Aluguel(4, 1,  null, 15.0, 5.0, agora, null, null, 1, 3, 0.0, 0.0);
		AluguelService ac = new AluguelService();
//		
		ac.salvar(aluguel);
//		ac.updateById(21, aluguel);
//		ac.deletar(24);
//		System.out.println(ac.getAll().get(10).getDataDevolucao());
//		System.out.println(ac.getById(22).getIdAluguel());
//		System.out.println(ac.getFilmes().size());
		
//		ac.updateDataDevolvido(25, devolucao.getData());
//		System.out.println(ac.getValorTotal(25));
		
	}

}

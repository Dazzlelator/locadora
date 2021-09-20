package testes;

import java.util.Date;

import br.com.locadora.controller.JogoController;
import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Jogo;

public class teste1 {

	public static void main(String[] args) {

		DateHelper lancamento = new DateHelper("1997-10-29");
		Date agora = new Date();

		Jogo jogo = new Jogo(12, "PlayStation", "123485-7d44", "Final Fantasy 7", "Final Fantasy", "RPG", "", "9.5", "Square Enix", "", "13", "Em perfeito estado", lancamento.getData(), agora, "alugado");
		
		JogoController jc = new JogoController();
//		jc.salvar(jogo);
//		jc.updateById(9, jogo);
//		jc.deletar(9);
//		System.out.println(jc.getAll().get(0).getNome());
//		System.out.println(jc.getById(8).getNome());
		jc.updateStatus(8,1);
	}

}

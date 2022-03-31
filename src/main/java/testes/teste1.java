package testes;

import br.com.locadora.services.JogoService;


public class teste1 {

	public static void main(String[] args) {

		
		JogoService js = new JogoService();
		
		js.getAll().forEach(item-> System.out.println(item.getNome()));
		
		
		
	}

}

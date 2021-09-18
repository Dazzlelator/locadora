package testes;

import java.util.Date;

import br.com.locadora.controller.UsuarioController;
import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Usuario;

public class teste1 {

	public static void main(String[] args) {
		
		DateHelper dataNascimento = new DateHelper("1999-09-09");
		Date agora = new Date();
		
		Usuario user1 = new Usuario("Nome Teste da Silva", "123123132", 1, "888.888.888-88", dataNascimento.getData(), "98888-8484", "mail@mail.com", "Rua dos testes num 99", 50.00, agora);
		UsuarioController uc = new UsuarioController();
//		uc.salvar(user1);
//		uc.updateByid(15, user1);
//		uc.addCredito(15, -10.00);
		uc.deletar(13);
		
		
		
	}

}

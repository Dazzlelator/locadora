package classes;

public class Programador extends Funcionario{

	public Programador(Integer id) {
		super(id);
		super.id = this.id;
	}

}

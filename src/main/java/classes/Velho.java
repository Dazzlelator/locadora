package classes;

public class Velho extends Imovel{

	public Velho(String endereco, Double preco) {
		super(endereco, preco);
	}
	
	@Override
	public Double getPreco() {
		return super.preco * 0.9;
	}

}

package classes;

public class Novo extends Imovel {
	
	public Novo(String endereco, Double preco) {
		super(endereco, preco);
		
	}

	@Override
	public Double getPreco() {
		return super.preco * 1.1;
	}
	
}

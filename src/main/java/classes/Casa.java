package classes;

public class Casa {
	private String cor;
	private Integer numero;
	private Janela janela;
	
	
	public Casa(String cor, Integer numero, Janela janela) {
		this.cor = cor;
		this.numero = numero;
		this.janela = janela;
		
	}
	
	public String getCor() {
		return this.cor;
	}
	public Integer getNumero() {
		return this.numero;
	}	
	public Janela getJanela() {
		return this.janela;
	}

}

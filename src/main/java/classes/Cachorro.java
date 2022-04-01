package classes;

public class Cachorro implements Comparable<Cachorro>{
	private String nome;
	private Integer idade;
	private Double peso;
	
	public Cachorro() {
		
	}
	
	public Cachorro(String nome, Integer idade, Double peso) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Cachorro c) {
		return this.idade.compareTo(c.idade);
	}
	
	public String toString() {
		return this.nome + " - " + this.idade + " - " + this.peso + "kg";
	}
	

}

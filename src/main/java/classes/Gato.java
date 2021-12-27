package classes;

import java.util.ArrayList;
import java.util.List;

public class Gato {
	
	private Boolean vivo;
	private String cor;
	private Integer idade;
	private String nome;
	
	public Gato(Boolean vivo, String cor, Integer idade, String nome) {
		this.vivo = vivo;
		this.cor = cor;
		this.idade = idade;
		this.nome = nome;
	}
	
	public void miar() {
		System.out.println("MIAUUUUUUUUU");
	}

	public Boolean getVivo() {
		return vivo;
	}

	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Object> getTudo(){
		List<Object> atributos = new ArrayList<>();
		atributos.add(getVivo());
		atributos.add(getCor());
		atributos.add(getIdade());
		atributos.add(getNome());
		
		return atributos;
		
	}
}

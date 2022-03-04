package classes;

public class Aluno {
	private String nome;
	private Double nota1;
	private Double nota2;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		if(nota1 > 10) {
			nota1 = 10.0;
		}else if(nota1 < 0) {
			nota1 = 0.0;
		}
		this.nota1 = nota1;
	}
	
	public Double getNota2() {
		
		return nota2;
	}
	public void setNota2(Double nota2) {
		if(nota2 > 10) {
			nota2 = 10.0;
		}else if(nota2 < 0) {
			nota2 = 0.0;
		}
		this.nota2 = nota2;
	}
	
	public Double getMedia() {
		Double media = ((this.getNota1() + this.getNota2())/2);
		return media;
	}
	public String getSituacao() {
		if(this.getMedia() < 4) {
			return "REPROVADO";
		}else if(this.getMedia() >= 6) {
			return "APROVADO";
		}else {
			//entre 4 e 6
			return "RECUPERAÇÃO";
		}
	}
	
	
}

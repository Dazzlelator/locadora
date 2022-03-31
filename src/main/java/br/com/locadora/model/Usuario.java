package br.com.locadora.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private String senha;
	private Integer nivel_acesso;
	private String cpf;
	private Date data_nascimento;
	private String telefone;
	private String email;
	private String endereco;
	private Double credito;
	private Date data_criacao;
	
	public Usuario() {}
	
	public Usuario(Integer id, String nome, String senha, Integer nivelAcesso, String cpf, Date dataNascimento, String telefone, String email, String endereco, Double credito, Date dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.nivel_acesso = nivelAcesso;
		this.cpf = cpf;
		this.data_nascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.credito = credito;
		this.data_criacao = dataCriacao;
	}
	
	public Usuario(String nome, String senha, Integer nivelAcesso, String cpf, Date dataNascimento, String telefone, String email, String endereco, Double credito, Date dataCriacao) {
		
		this.nome = nome;
		this.senha = senha;
		this.nivel_acesso = nivelAcesso;
		this.cpf = cpf;
		this.data_nascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.credito = credito;
		this.data_criacao = dataCriacao;
	}
	
public Usuario(String nome, String senha, String cpf, Date dataNascimento, String telefone, String email, String endereco) {
		
		this.nome = nome;
		this.senha = senha;
		this.nivel_acesso = 1;
		this.cpf = cpf;
		this.data_nascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.credito = 0.0;
		this.data_criacao = new Date();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(Date data) {
		this.data_nascimento = data;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public Integer getNivelAcesso() {
		return nivel_acesso;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return data_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public Double getCredito() {
		return credito;
	}

	public Date getDataCriacao() {
		return data_criacao;
	}

	
}


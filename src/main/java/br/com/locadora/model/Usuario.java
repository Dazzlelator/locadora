package br.com.locadora.model;

import java.util.Date;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String senha;
	private Integer nivelAcesso;
	private String cpf;
	private Date dataNascimento;
	private String telefone;
	private String email;
	private String endereco;
	private Double credito;
	private Date dataCriacao;
	
	
	public Usuario(Integer id, String nome, String senha, Integer nivelAcesso, String cpf, Date dataNascimento, String telefone, String email, String endereco, Double credito, Date dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.credito = credito;
		this.dataCriacao = dataCriacao;
	}
	
	public Usuario(String nome, String senha, Integer nivelAcesso, String cpf, Date dataNascimento, String telefone, String email, String endereco, Double credito, Date dataCriacao) {
		
		this.nome = nome;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.credito = credito;
		this.dataCriacao = dataCriacao;
	}
	
public Usuario(String nome, String senha, String cpf, Date dataNascimento, String telefone, String email, String endereco) {
		
		this.nome = nome;
		this.senha = senha;
		this.nivelAcesso = 1;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.credito = 0.0;
		this.dataCriacao = new Date();
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
		return nivelAcesso;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
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
		return dataCriacao;
	}

	
}


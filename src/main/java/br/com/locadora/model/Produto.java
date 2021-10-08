package br.com.locadora.model;

import java.util.Date;

public class Produto {
	private Integer produtoId;
	private Integer id;
	private String codProduto;
	private String nome;
	private Double valor;
	private Double custo;
	private Integer quantidade;
	private Date dataCadastro;
	private String tipo;
	
	public Produto(Integer produtoId, Integer id, String codProduto, String nome, Double valor, Double custo, Integer quantidade, Date dataCadastro, String tipo) {
		this.produtoId = produtoId;
		this.id = id;
		this.codProduto = codProduto;
		this.nome = nome;
		this.valor = valor;
		this.custo = custo;
		this.quantidade = quantidade;
		this.dataCadastro = dataCadastro;
		this.tipo = tipo;
	}
	
	public Produto( Integer id, String codProduto, String nome, Double valor, Double custo, Integer quantidade, Date dataCadastro, String tipo) {
		this.id = id;
		this.codProduto = codProduto;
		this.nome = nome;
		this.valor = valor;
		this.custo = custo;
		this.quantidade = quantidade;
		this.dataCadastro = dataCadastro;
		this.tipo = tipo;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public Integer getId() {
		return id;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public Double getCusto() {
		return custo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public String getTipo() {
		return tipo;
	}
	
}

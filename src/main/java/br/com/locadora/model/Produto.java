package br.com.locadora.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")

public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_produto;
	@ManyToOne
	private Usuario usuario;
	private String cod_produto;
	private String nome;
	private Double valor;
	private Double vaslor_custo;
	private Integer quantidade;
	private Date data_cadastro;
	private String tipo;
	private Double valor_aluguel;
	private Double valor_multa;

	public Produto() {
	}

	public Produto(Integer produtoId, Usuario id, String codProduto, String nome, Double valor, Double custo,
			Integer quantidade, Date dataCadastro, String tipo, Double valorAlguel, Double valorMulta) {
		this.id_produto = produtoId;
		this.usuario = id;
		this.cod_produto = codProduto;
		this.nome = nome;
		this.valor = valor;
		this.vaslor_custo = custo;
		this.quantidade = quantidade;
		this.data_cadastro = dataCadastro;
		this.tipo = tipo;
		this.valor_aluguel = valorAlguel;
		this.valor_multa = valorMulta;
	}

	public Produto(Usuario id, String codProduto, String nome, Double valor, Double custo, Integer quantidade,
			Date dataCadastro, String tipo, Double valorAlguel, Double valorMulta) {
		this.usuario = id;
		this.cod_produto = codProduto;
		this.nome = nome;
		this.valor = valor;
		this.vaslor_custo = custo;
		this.quantidade = quantidade;
		this.data_cadastro = dataCadastro;
		this.tipo = tipo;
		this.valor_aluguel = valorAlguel;
		this.valor_multa = valorMulta;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getProdutoId() {
		return id_produto;
	}

	public Integer getId() {
		return usuario.getId();
	}

	public String getCodProduto() {
		return cod_produto;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public Double getCusto() {
		return vaslor_custo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Date getDataCadastro() {
		return data_cadastro;
	}

	public String getTipo() {
		return tipo;
	}

	public Double getValorAluguel() {
		return valor_aluguel;
	}

	public Double getValorMulta() {
		return valor_multa;
	}
}

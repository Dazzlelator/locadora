package br.com.locadora.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jogos")

public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_jogo;
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto produto;
	private String plataforma;
	private String num_serial;
	private String nome;
	private String franquia;
	private String generos;
	private String premios;
	private String notas;
	private String produtor;
	private String destribuidor; //distribuidor*
	private String faixa_etaria;
	private String integridade;
	private Date data_lancamento;
	private Date data_cadadastro;
	private String status;
	
	public Jogo() {}

	public Jogo(Integer idJogo, Produto idProduto, String plataforma, String numSerial,
			String nome, String franquia, String generos, String premios,
			String notas, String produtor, String distribuidor, String faixaEtaria,
			String integridade, Date dataLancamento, Date dataCadastro, String status) {
		this.id_jogo = idJogo;
		this.produto = idProduto;
		this.plataforma = plataforma;
		this.num_serial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.produtor = produtor;
		this.destribuidor = distribuidor;
		this.faixa_etaria = faixaEtaria;
		this.integridade = integridade;
		this.data_lancamento = dataLancamento;
		this.data_cadadastro = dataCadastro;
		this.status = status;
		
	}
	
	public Jogo(Produto idProduto, String plataforma, String numSerial,
			String nome, String franquia, String generos, String premios,
			String notas, String produtor, String distribuidor, String faixaEtaria,
			String integridade, Date dataLancamento, Date dataCadastro, String status) {
		
		this.produto = idProduto;
		this.plataforma = plataforma;
		this.num_serial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.produtor = produtor;
		this.destribuidor = distribuidor;
		this.faixa_etaria = faixaEtaria;
		this.integridade = integridade;
		this.data_lancamento = dataLancamento;
		this.data_cadadastro = dataCadastro;
		this.status = status;
		
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdJogo() {	
			return id_jogo;
	}

	public Integer getIdProduto() {
		return produto.getProdutoId();
	}

	public String getPlataforma() {
		return plataforma;
	}

	public String getNumSerial() {
		return num_serial;
	}

	public String getNome() {
		return nome;
	}

	public String getFranquia() {
		return franquia;
	}

	public String getGeneros() {
		return generos;
	}

	public String getPremios() {
		return premios;
	}

	public String getNotas() {
		return notas;
	}

	public String getProdutor() {
		return produtor;
	}

	public String getDestribuidor() {
		return destribuidor;
	}

	public String getFaixaEtaria() {
		return faixa_etaria;
	}

	public String getIntegridade() {
		return integridade;
	}

	public Date getDataLancamento() {
		return data_lancamento;
	}

	public Date getDataCadadastro() {
		return data_cadadastro;
	}

	public String getStatus() {
		return status;
	}
}

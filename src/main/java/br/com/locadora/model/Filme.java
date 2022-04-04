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
@Table(name="filmes")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_filme;
	@ManyToOne
	@JoinColumn(name="id_produto") //isso aqui diz qual coluna vai ser pego a FK
	private Produto produto;
	private String tecnologia;
	private String num_serial;
	private String nome;
	private String franquia;
	private String generos;
	private String premios;
	private String notas;
	private String protagonistas;
	private String diretor;
	private String produtor;
	private String destribuidor; //distribuidor*
	private String faixa_etaria;
	private String integridade;
	private Date data_lancamento;
	private Date data_cadastro;
	private String status;
	private String sinopse;
	
	public Filme() {}

	public Filme(Integer idFilme, Produto idProduto, String tecnologia, String numSerial, String nome, String franquia,
			String generos, String premios, String notas, String protagonistas, String diretor, String produtor,
			String distribuidor, String faixaEtaria, String integridade, Date dataLancamento, Date dataCadastro,
			String status, String sinopse) {
		this.id_filme = idFilme;
		this.produto = idProduto;
		this.tecnologia = tecnologia;
		this.num_serial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.protagonistas = protagonistas;
		this.diretor = diretor;
		this.produtor = produtor;
		this.destribuidor = distribuidor;
		this.faixa_etaria = faixaEtaria;
		this.integridade = integridade;
		this.data_lancamento = dataLancamento;
		this.data_cadastro = dataCadastro;
		this.status = status;
		this.sinopse = sinopse;
	}
	
	public Filme(Produto idProduto, String tecnologia, String numSerial, String nome, String franquia,
			String generos, String premios, String notas, String protagonistas, String diretor, String produtor,
			String distribuidor, String faixaEtaria, String integridade, Date dataLancamento, Date dataCadastro,
			String status, String sinopse) {
		this.produto = idProduto;
		this.tecnologia = tecnologia;
		this.num_serial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.protagonistas = protagonistas;
		this.diretor = diretor;
		this.produtor = produtor;
		this.destribuidor = distribuidor;
		this.faixa_etaria = faixaEtaria;
		this.integridade = integridade;
		this.data_lancamento = dataLancamento;
		this.data_cadastro = dataCadastro;
		this.status = status;
		this.sinopse = sinopse;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
<<<<<<< HEAD
	
	public void setDataLancamento(Date data) {
		this.data_lancamento = data;
	}
=======
>>>>>>> parent of a4d7f71 (implementando design)

	public Integer getIdFilme() {
		return id_filme;
	}

	public Integer getIdProduto() {
		return produto.getId();
	}

	public String getTecnologia() {
		return tecnologia;
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

	public String getProtagonistas() {
		return protagonistas;
	}

	public String getDiretor() {
		return diretor;
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

	public Date getDataCadastro() {
		return data_cadastro;
	}

	public String getStatus() {
		return status;
	}
	
	public String getSinopse() {
		return sinopse;
	}

}

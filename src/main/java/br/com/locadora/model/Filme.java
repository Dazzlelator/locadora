package br.com.locadora.model;

import java.util.Date;

public class Filme {
	private Integer idFilme;
	private Integer idProduto;
	private String tecnologia;
	private String numSerial;
	private String nome;
	private String franquia;
	private String generos;
	private String premios;
	private String notas;
	private String protagonistas;
	private String diretor;
	private String produtor;
	private String destribuidor;
	private String faixaEtaria;
	private String integridade;
	private Date dataLancamento;
	private Date dataCadastro;
	private String status;
	private String sinopse;

	public Filme(Integer idFilme, Integer idProduto, String tecnologia, String numSerial, String nome, String franquia,
			String generos, String premios, String notas, String protagonistas, String diretor, String produtor,
			String destribuidor, String faixaEtaria, String integridade, Date dataLancamento, Date dataCadastro,
			String status, String sinopse) {
		this.idFilme = idFilme;
		this.idProduto = idProduto;
		this.tecnologia = tecnologia;
		this.numSerial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.protagonistas = protagonistas;
		this.diretor = diretor;
		this.produtor = produtor;
		this.destribuidor = destribuidor;
		this.faixaEtaria = faixaEtaria;
		this.integridade = integridade;
		this.dataLancamento = dataLancamento;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.sinopse = sinopse;
	}
	
	public Filme(Integer idProduto, String tecnologia, String numSerial, String nome, String franquia,
			String generos, String premios, String notas, String protagonistas, String diretor, String produtor,
			String destribuidor, String faixaEtaria, String integridade, Date dataLancamento, Date dataCadastro,
			String status, String sinopse) {
		this.idProduto = idProduto;
		this.tecnologia = tecnologia;
		this.numSerial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.protagonistas = protagonistas;
		this.diretor = diretor;
		this.produtor = produtor;
		this.destribuidor = destribuidor;
		this.faixaEtaria = faixaEtaria;
		this.integridade = integridade;
		this.dataLancamento = dataLancamento;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.sinopse = sinopse;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDataLancamento(Date data) {
		this.dataLancamento = data;
	}

	public Integer getIdFilme() {
		return idFilme;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public String getNumSerial() {
		return numSerial;
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
		return faixaEtaria;
	}

	public String getIntegridade() {
		return integridade;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public String getStatus() {
		return status;
	}
	
	public String getSinopse() {
		return sinopse;
	}

}

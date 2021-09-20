package br.com.locadora.model;

import java.util.Date;

public class Jogo {

	private Integer idJogo;
	private Integer idProduto;
	private String plataforma;
	private String numSerial;
	private String nome;
	private String franquia;
	private String generos;
	private String premios;
	private String notas;
	private String produtor;
	private String destribuidor;
	private String faixaEtaria;
	private String integridade;
	private Date dataLancamento;
	private Date dataCadadastro;
	private String status;

	public Jogo(Integer idJogo, Integer idProduto, String plataforma, String numSerial,
			String nome, String franquia, String generos, String premios,
			String notas, String produtor, String destribuidor, String faixaEtaria,
			String integridade, Date dataLancamento, Date dataCadastro, String status) {
		this.idJogo = idJogo;
		this.idProduto = idProduto;
		this.plataforma = plataforma;
		this.numSerial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.produtor = produtor;
		this.destribuidor = destribuidor;
		this.faixaEtaria = faixaEtaria;
		this.integridade = integridade;
		this.dataLancamento = dataLancamento;
		this.dataCadadastro = dataCadastro;
		this.status = status;
		
	}
	
	public Jogo(Integer idProduto, String plataforma, String numSerial,
			String nome, String franquia, String generos, String premios,
			String notas, String produtor, String destribuidor, String faixaEtaria,
			String integridade, Date dataLancamento, Date dataCadastro, String status) {
		
		this.idProduto = idProduto;
		this.plataforma = plataforma;
		this.numSerial = numSerial;
		this.nome = nome;
		this.franquia = franquia;
		this.generos = generos;
		this.premios = premios;
		this.notas = notas;
		this.produtor = produtor;
		this.destribuidor = destribuidor;
		this.faixaEtaria = faixaEtaria;
		this.integridade = integridade;
		this.dataLancamento = dataLancamento;
		this.dataCadadastro = dataCadastro;
		this.status = status;
		
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdJogo() {
		return idJogo;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public String getPlataforma() {
		return plataforma;
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

	public Date getDataCadadastro() {
		return dataCadadastro;
	}

	public String getStatus() {
		return status;
	}
	
	

}

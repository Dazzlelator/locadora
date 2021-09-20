package br.com.locadora.model;

import java.util.Date;

public class Aluguel {
	private Integer idAluguel;
	private Integer id;
	private Integer idFilme;
	private Integer idJogo;
	private Double valor;
	private Double multa;
	private Date dataAluguel;
	private Date dataDevolucao;
	private Date dataDevolvido;
	private Integer idFuncionario;
	
	public Aluguel(Integer idAluguel, Integer id, Integer idFilme, Integer idJogo, Double valor, Double multa, Date dataAluguel, Date dataDevolucao, Date dataDevolvido, Integer idFuncionario) {
		this.idAluguel = idAluguel;
		this.id = id;
		this.idFilme = idFilme;
		this.valor = valor;
		this.multa = multa;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolvido = dataDevolvido;
		this.idFuncionario = idFuncionario;
	}
	
	public Aluguel( Integer id, Integer idFilme, Integer idJogo, Double valor, Double multa, Date dataAluguel, Date dataDevolucao, Date dataDevolvido, Integer idFuncionario) {
		this.id = id;
		this.idFilme = idFilme;
		this.valor = valor;
		this.multa = multa;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolvido = dataDevolvido;
		this.idFuncionario = idFuncionario;
	}

	public Integer getIdAluguel() {
		return idAluguel;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdFilme() {
		return idFilme;
	}

	public Integer getIdJogo() {
		return idJogo;
	}

	public Double getValor() {
		return valor;
	}

	public Double getMulta() {
		return multa;
	}

	public Date getDataAluguel() {
		return dataAluguel;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public Date getDataDevolvido() {
		return dataDevolvido;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}
}

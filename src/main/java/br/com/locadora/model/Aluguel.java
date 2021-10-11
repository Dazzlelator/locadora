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
	private Integer diasDevolucao;
	private Double valorPago;
	private Double valorTotal;

	public Aluguel(Integer idAluguel, Integer id, Integer idFilme, Integer idJogo, Double valor, Double multa,
			Date dataAluguel, Date dataDevolucao, Date dataDevolvido, Integer idFuncionario, Integer diasDevolucao,
			Double valorPago, Double valorTotal) {
		this.idAluguel = idAluguel;
		this.id = id;
		this.idFilme = idFilme;
		this.idJogo = idJogo;
		this.valor = valor;
		this.multa = multa;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolvido = dataDevolvido;
		this.idFuncionario = idFuncionario;
		this.diasDevolucao = diasDevolucao;
		this.valorPago = valorPago;
		this.valorTotal = valorTotal;
	}

	public Aluguel(Integer id, Integer idFilme, Integer idJogo, Double valor, Double multa, Date dataAluguel,
			Date dataDevolucao, Date dataDevolvido, Integer idFuncionario, Integer diasDevolucao, Double valorPago, Double valorTotal) {
		this.id = id;
		this.idFilme = idFilme;
		this.idJogo = idJogo;
		this.valor = valor;
		this.multa = multa;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolvido = dataDevolvido;
		this.idFuncionario = idFuncionario;
		this.diasDevolucao = diasDevolucao;
		this.valorPago = valorPago;
		this.valorTotal = valorTotal;
	}
	
	public Aluguel(Integer id, Integer idFilme, Integer idJogo, Double valor, Double multa) {
		this.id = id;
		this.idFilme = idFilme;
		this.idJogo = idJogo;
		this.valor = valor;
		this.multa = multa;
	
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public void setDataDevolucao(Date devolucao) {
		this.dataDevolucao = devolucao;
	}

	public void setDataDevolvido(Date devolvido) {
		this.dataDevolvido = devolvido;
	}
	
	public void setDiasDevolucao(Integer diasDevolucao) {
		this.diasDevolucao = diasDevolucao;
	}
	
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public Integer getDiasDevolucao() {
		return diasDevolucao;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double getValorTotal() {
		return valorTotal;
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

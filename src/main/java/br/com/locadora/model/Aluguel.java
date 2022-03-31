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
@Table(name="aluguel")
public class Aluguel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer id_aluguel;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="id_filme")
	private Filme filme;
	@ManyToOne
	@JoinColumn(name="id_jogo")
	private Jogo jogo;
	private Double valor;
	private Double valor_multa;
	private Date data_aluguel;
	private Date data_devolucao;
	private Date data_devolvido;
	@ManyToOne
	@JoinColumn(name="id", insertable=false, updatable=false)
	private Usuario funcionario;
	private Integer dias_para_devolucao;
	private Double valor_pago;
	private Double valor_total;
	
	public Aluguel() {}

	public Aluguel(Integer idAluguel, Usuario id, Filme idFilme, Jogo idJogo, Double valor, Double multa,
			Date dataAluguel, Date dataDevolucao, Date dataDevolvido, Usuario idFuncionario, Integer diasDevolucao,
			Double valorPago, Double valorTotal) {
		this.id_aluguel = idAluguel;
		this.usuario = id;
		this.filme = idFilme;
		this.jogo = idJogo;
		this.valor = valor;
		this.valor_multa = multa;
		this.data_aluguel = dataAluguel;
		this.data_devolucao = dataDevolucao;
		this.data_devolvido = dataDevolvido;
		this.funcionario = idFuncionario;
		this.dias_para_devolucao = diasDevolucao;
		this.valor_pago = valorPago;
		this.valor_total = valorTotal;
	}

	public Aluguel(Usuario id, Filme idFilme, Jogo idJogo, Double valor, Double multa, Date dataAluguel,
			Date dataDevolucao, Date dataDevolvido, Usuario idFuncionario, Integer diasDevolucao, Double valorPago, Double valorTotal) {
		this.usuario = id;
		this.filme = idFilme;
		this.jogo = idJogo;
		this.valor = valor;
		this.valor_multa = multa;
		this.data_aluguel = dataAluguel;
		this.data_devolucao = dataDevolucao;
		this.data_devolvido = dataDevolvido;
		this.funcionario = idFuncionario;
		this.dias_para_devolucao = diasDevolucao;
		this.valor_pago = valorPago;
		this.valor_total = valorTotal;
	}
	
	public Aluguel(Usuario id, Filme idFilme, Jogo idJogo, Double valor, Double multa, Double valorPago, Double valorTotal) {
		this.usuario = id;
		this.filme = idFilme;
		this.jogo = idJogo;
		this.valor = valor;
		this.valor_multa = multa;
		this.valor_pago = valorPago;
		this.valor_total = valorTotal;
	
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public void setValorMulta(Double valorMulta) {
		this.valor_multa = valorMulta;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valor_total = valorTotal;
	}
	
	public void setDataAluguel(Date dataAluguel) {
		this.data_aluguel = dataAluguel;
	}

	public void setDataDevolucao(Date devolucao) {
		this.data_devolucao = devolucao;
	}

	public void setDataDevolvido(Date devolvido) {
		this.data_devolvido = devolvido;
	}
	
	public void setDiasDevolucao(Integer diasDevolucao) {
		this.dias_para_devolucao = diasDevolucao;
	}
	
	public void setIdFuncionario(Usuario idFuncionario) {
		this.funcionario = idFuncionario;
	}
	public Integer getDiasDevolucao() {
		return dias_para_devolucao;
	}

	public Double getValorPago() {
		return valor_pago;
	}

	public void setValorPago(Double valorPago) {
		this.valor_pago = valorPago;
	}

	public Double getValorTotal() {
		return valor_total;
	}

	public Integer getIdAluguel() {
		return id_aluguel;
	}

	public Integer getId() {
		return usuario.getId();
	}

	public Integer getIdFilme() {
		return filme.getIdFilme();
	}

	public Integer getIdJogo() {
		return jogo.getIdJogo();
	}

	public Double getValor() {
		return valor;
	}

	public Double getMulta() {
		return valor_multa;
	}

	public Date getDataAluguel() {
		return data_aluguel;
	}

	public Date getDataDevolucao() {
		return data_devolucao;
	}

	public Date getDataDevolvido() {
		return data_devolvido;
	}

	public Integer getIdFuncionario() {
		return funcionario.getId();
	}
}

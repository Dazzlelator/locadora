package br.com.locadora.services;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.dao.AluguelDAO;
import br.com.locadora.model.dao.ConnectionFactory;

public class AluguelService {
	private AluguelDAO aluguelDao;
	
	public AluguelService() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.aluguelDao = new AluguelDAO(con);
	}
	
	public void salvar(Aluguel aluguel) {
		FilmeService fc = new FilmeService();
		JogoService jc = new JogoService();
		DateHelper dataDevolucao = new DateHelper(aluguel.getDataAluguel());
		dataDevolucao.addUtil(aluguel.getDiasDevolucao());
		aluguel.setDataDevolucao(dataDevolucao.getData());
		
		if(fc.getById(aluguel.getIdFilme()).getStatus().equals("disponivel")  | jc.getById(aluguel.getIdJogo()).getStatus().equals("disponivel")) {
			
			this.aluguelDao.salvar(aluguel);
			
			if(aluguel.getIdFilme() != null) {
				fc.updateStatus(aluguel.getIdFilme(), 2);
			}
			if(aluguel.getIdJogo() != null) {
				jc.updateStatus(aluguel.getIdJogo(), 2);
			}			
		}else {
			System.out.println("Produto não está disponível para aluguel");
		}
	}
	
	public void updateById(Integer id, Aluguel aluguel) {
		this.aluguelDao.updateAluguelById(id, aluguel);
	}
	
	public void updateDataDevolvido(Integer id, Date data) {
		this.aluguelDao.updateDataDevolvido(id, data);
		
		FilmeService fc = new FilmeService();
		JogoService jc = new JogoService();	
		Aluguel aluguelAtual = this.getById(id);
		if(aluguelAtual.getIdFilme() >= 1) {
			fc.updateStatus(aluguelAtual.getIdFilme(), 1);
		}
		if(aluguelAtual.getIdJogo() != null) {
			jc.updateStatus(aluguelAtual.getIdJogo(), 1);
		}
	}
	
	public void updateValorPago(Integer id, Double valorPago) {
		this.aluguelDao.updateValorPago(id, valorPago);
	}
	
	public void updateValorTotal(Integer id, Double valorTotal) {
		this.aluguelDao.updateValorTotal(id, valorTotal);
	}
	
	public void pagamento(Integer id, Double valorPago) {
		UsuarioService uc = new UsuarioService();
		Integer idUsuario = this.getById(id).getId();
		
		uc.addCredito(idUsuario, valorPago);
		
		Double credito = uc.getById(idUsuario).getCredito() - this.getValorTotal(id);
		
	}
	
	public List<Aluguel> getAll(){
		return this.aluguelDao.getAllAluguel();
	}
	
	public Aluguel getById(Integer id) {
		return this.aluguelDao.getAluguelById(id);
	}
	
	public List<Aluguel> getFilmes(){
		return this.aluguelDao.getFilmesOuJogos(1);
	}
	public List<Aluguel> getJogos(){
		return this.aluguelDao.getFilmesOuJogos(2);
	}
	
	public Double getValorMulta(Integer id) {
		Double multa = this.getById(id).getMulta();
		Long data1 = this.getById(id).getDataDevolucao().getTime();
		Long data2 = this.getById(id).getDataDevolvido().getTime();
		Long multiplicador = (data2 - data1)/86400000;
		Double resultado = multa*multiplicador;
		this.updateValorTotal(id, resultado);
		
		if(resultado > 0) {
			return resultado;
		}else {
			return 0.0;
		}		
	}
	
	public Double getValorTotal(Integer id) {
		Double multa = this.getValorMulta(id);
		Double valorBase = this.getById(id).getValor();
		return valorBase + multa;
	}
	
	public void deletar(Integer id) {
		this.aluguelDao.deletarAluguel(id);
	}
}

package br.com.locadora.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.dao.AluguelDAO;
import br.com.locadora.model.dao.ConnectionFactory;

public class AluguelService {
	private AluguelDAO aluguelDao;
	
	public AluguelService() {		
		EntityManager em = ConnectionFactory.getEntityManager();
		this.aluguelDao = new AluguelDAO(em);
	}
	
	public void salvar(Aluguel aluguel) {
		
		FilmeService fc = new FilmeService();
		JogoService jc = new JogoService();
		
		
		if(aluguel.getDataAluguel() == null) {
			aluguel.setDataAluguel(new Date());
		}
		
		
		Integer diasParaDevolucao = this.getParamAluguel().getDiasDevolucao(); //isso daqui vem do primeiro item da table aluguel. Esse item serve como parametro base para os alugueis.
		DateHelper dataDevolucao = new DateHelper(aluguel.getDataAluguel());
		
		dataDevolucao.addUtil(diasParaDevolucao);
		aluguel.setDiasDevolucao(diasParaDevolucao);
		aluguel.setDataDevolucao(dataDevolucao.getData());
		
		
		String statusFilme = "indisponivel";
		String statusJogo = "indisponivel";
		
		if(aluguel.getIdFilme() != null) {
			statusFilme = fc.getById(aluguel.getIdFilme()).getStatus();
			
		}if(aluguel.getIdJogo() != null){
			statusJogo = jc.getById(aluguel.getIdJogo()).getStatus();
		}
		
		System.out.println("Status jogo = " +statusJogo);
		if("disponivel".equals(statusFilme)  | "disponivel".equals(statusJogo)) {
									
			if(aluguel.getIdFilme() != null) {
				fc.updateStatus(aluguel.getIdFilme(), 2);	
				this.aluguelDao.salvar(aluguel);							
			}else if(aluguel.getIdJogo() != null) {
				jc.updateStatus(aluguel.getIdJogo(), 2);
				this.aluguelDao.salvar(aluguel);
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
		if(aluguelAtual.getIdJogo() >= 1) {
			jc.updateStatus(aluguelAtual.getIdJogo(), 1);
		}
	}
	
	public void updateValorPago(Integer id, Double valorPago) {
		this.aluguelDao.updateValorPago(id, valorPago);
	}
	
	public void updateValorTotal(Integer id) {		
		this.aluguelDao.updateValorTotal(id, this.getValorTotal(id));
	}
	
	public void pagamento(Integer id, Double valorPago) {
		UsuarioService us = new UsuarioService();
		Integer idUsuario = this.getById(id).getId();
		
		us.addCredito(idUsuario, valorPago);
		
		
		us.addCredito(idUsuario, -this.getValorTotal(id));
		
	}
	
	public List<Aluguel> getAll(){
		return this.aluguelDao.getAllAluguel();
	}
	
	public List<Aluguel> getAllAtivosById(Integer id){
		return this.aluguelDao.getAllAlugueisAtivosById(id);
	}
	
	public Aluguel getById(Integer id) {
		return this.aluguelDao.getAluguelById(id);
	}
	
//	public List<Aluguel> getFilmes(){
//		return this.aluguelDao.getFilmesOuJogos(1);
//	}
//	public List<Aluguel> getJogos(){
//		return this.aluguelDao.getFilmesOuJogos(2);
//	}
//	
	public Aluguel getFilmeAtivoByIdUsuarioByIdFilme(Integer idUsuario, Integer idFilme) {
		return this.aluguelDao.getAluguelFilmeAtivoByIdByIdFilme(idUsuario, idFilme);
	}
	
	public Aluguel getJogoAtivoByIdUsuarioByIdJogo(Integer idUsuario, Integer idJogo) {
		return this.aluguelDao.getAluguelJogoAtivoByIdByIdJogo(idUsuario, idJogo);
	}
	
	public Double getValorMulta(Integer id) {
		Double multa = this.getById(id).getMulta();
		Long data1 = this.getById(id).getDataDevolucao().getTime();
		Long data2 = new Date().getTime();
		if(this.getById(id).getDataDevolvido() != null) {
			data2 = this.getById(id).getDataDevolvido().getTime();
		}	
		
		Long multiplicador = (data2 - data1)/86400000;
		Double resultado = multa*multiplicador;
//		this.updateValorTotal(id, resultado);
		
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
	
	public Aluguel getParamAluguel() {
		return this.aluguelDao.getParamAluguel();
	}
	
	public Date getDataDevolucaoPreview() {
		Integer diasParaDevolucao = this.getParamAluguel().getDiasDevolucao();
		DateHelper dataDevolucao = new DateHelper(new Date());
		dataDevolucao.addUtil(diasParaDevolucao);
		
		return dataDevolucao.getData();
	}
	
	public void deletar(Integer id) {
		this.aluguelDao.deletarAluguelById(id);
	}
}

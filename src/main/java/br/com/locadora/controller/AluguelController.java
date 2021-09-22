package br.com.locadora.controller;

import java.sql.Connection;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.dao.AluguelDAO;
import br.com.locadora.model.dao.ConnectionFactory;

public class AluguelController {
	private AluguelDAO aluguelDao;
	
	public AluguelController() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.aluguelDao = new AluguelDAO(con);
	}
	
	public void salvar(Aluguel aluguel) {
		DateHelper dataDevolucao = new DateHelper(aluguel.getDataAluguel());
		dataDevolucao.addUtil(3);
		aluguel.setDataDevolucao(dataDevolucao.getData());
		
		this.aluguelDao.salvar(aluguel);
	}
	
	public void updateById(Integer id, Aluguel aluguel) {
		this.aluguelDao.updateAluguelById(id, aluguel);
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
	
	public void deletar(Integer id) {
		this.aluguelDao.deletarAluguel(id);
	}
}

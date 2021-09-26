package br.com.locadora.controller;

import java.sql.Connection;
import java.util.List;

import br.com.locadora.model.Filme;
import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.FilmeDAO;

public class FilmeController {
	private FilmeDAO filmeDao;
	
	public FilmeController() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.filmeDao = new FilmeDAO(con);
	}
	
	public void salvar(Filme filme) {
		this.filmeDao.salvar(filme);
	}
	
	public void updateById(Integer id, Filme filme) {
		this.filmeDao.updateFilmeById(id, filme);
	}
	
	public void updateStatus(Integer id, Integer status) {
		
		Filme filmeAtual = this.filmeDao.getFilmeById(id);
		String statusAtual = filmeAtual.getStatus();
		
		ProdutoController pc = new ProdutoController();
		
		
		switch(status) {
		case 1:
			if(!statusAtual.equals("disponivel")) {
				filmeAtual.setStatus("disponivel");
				pc.entrada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);						
			}
			System.out.println("Filme já está "+ statusAtual);
			break;			
		case 2:
			if(!statusAtual.equals("alugado")) {
				filmeAtual.setStatus("alugado");
				pc.retirada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está "+ statusAtual);
			break;
		case 3:
			if(!statusAtual.equals("vendido")) {
				filmeAtual.setStatus("vendido");
				pc.retirada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está "+ statusAtual);
			break;
		case 4:
			if(!statusAtual.equals("extraviado")) {
				filmeAtual.setStatus("extraviado");
				pc.retirada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está "+ statusAtual);
			break;
		default:
			System.out.println("Válidos números de 1 a 4 no segundo parametro");
			System.out.println("1 -  disponivel; 2 - alugado; 3 - vendido, 4 - extraviado");
			break;
		}
		
		
	}
	
	public List<Filme> getAll(){
		return this.filmeDao.getAllFilmes();
	}
	
	public Filme getById(Integer id) {
		return this.filmeDao.getFilmeById(id);
	}
	
	public void deletar(Integer id) {
		this.filmeDao.deletarFilmeById(id);
		
	}
}

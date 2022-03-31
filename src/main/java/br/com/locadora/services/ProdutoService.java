package br.com.locadora.services;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.model.Produto;
import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.ProdutoDAO;

public class ProdutoService {
	private ProdutoDAO produtoDao;
	
	public ProdutoService() {
		EntityManager em = ConnectionFactory.getEntityManager();
		this.produtoDao = new ProdutoDAO(em);
	}
	
	public void salvar(Produto produto) {
		this.produtoDao.salvar(produto);
		
	}
	
	public List<Produto> getAllByNome(String nome) {
		return this.produtoDao.getProdutosByNome(nome);
	}
	
	public void updateById(Integer id, Produto produto) {
		this.produtoDao.updateProdutoById(id, produto);
	}
	
	public void addQuantidade(Integer id, Integer quantidade) {
		this.produtoDao.addQuantidade(id, quantidade);
	}
	
	public void retirada(Integer id) {
		Integer quantidade = -1;
		if(this.getById(id).getQuantidade() > 0) {
			this.produtoDao.addQuantidade(id, quantidade);
		}
	}
	
	public void entrada(Integer id) {
		Integer quantidade = 1;
		this.produtoDao.addQuantidade(id, quantidade);
	}
	
	public void alterarValor(Integer id, Double valor) {
		this.produtoDao.updateValor(id, valor);
	}
	
	public void desconto(Integer id, Double desconto) {
		Double valor = this.getById(id).getValor();
		Double descontado = ((1 - desconto)/100)*valor;
		this.produtoDao.updateValor(id, descontado);
	}
	
	public List<Produto> getAll(){
		return this.produtoDao.getAllProdutos();
	}
	
	public Produto getById(Integer id) {
		return this.produtoDao.getProdutoById(id);
	}
	
	public void deletar(Integer id) {
		this.produtoDao.deleteById(id);
	}
}

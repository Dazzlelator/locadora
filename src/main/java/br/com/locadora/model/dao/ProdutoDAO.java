package br.com.locadora.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.model.Produto;

public class ProdutoDAO {
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Produto produto) {
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Produto getProdutoById(Integer id) {
		return this.em.find(Produto.class, id);
	}
	
	public void updateProdutoById(Integer id, Produto alterado) {
		this.getProdutoById(id);
		this.em.merge(alterado);
		this.em.getTransaction().commit();
		this.em.close();
		
	}
	
	public void addQuantidade(Integer id, Integer quantidade) {
		Produto produto = this.getProdutoById(id);
		this.em.getTransaction().begin();
		produto.setQuantidade(quantidade);
		this.em.getTransaction().commit();
		this.em.close();
		
	}
	
	public void updateValor(Integer id, Double valor) {
		Produto produto = this.getProdutoById(id);
		this.em.getTransaction().begin();
		produto.setValor(valor);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public List<Produto> getAllProdutos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}


	public List<Produto> getProdutosByNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE nome = ?1";
		return em.createQuery(jpql, Produto.class).setParameter("1", nome).getResultList();
	}
	
	public void deleteById(Integer id) {
		Produto produto = this.getProdutoById(id);
		this.em.getTransaction().begin();
		this.em.remove(produto);
		this.em.getTransaction().commit();
		this.em.close();
		
	}

}

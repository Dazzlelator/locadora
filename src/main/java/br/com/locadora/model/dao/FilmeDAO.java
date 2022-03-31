package br.com.locadora.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Filme;

public class FilmeDAO {
	private EntityManager em;

	public FilmeDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Filme filme) {
		this.em.getTransaction().begin();
		this.em.persist(filme);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Filme getFilmeById(Integer id) {
		return em.find(Filme.class, id);
	}
	
	public void updateFilmeById(Integer id, Filme alterado) { //isso n deve funcionar ainda
		Filme filme = this.getFilmeById(id);
		this.em.getTransaction();
		this.em.merge(alterado);
		this.em.getTransaction().commit();
		this.em.close();
	}
	

	public List<Filme> getAllFilmes(){
		String jpql = "SELECT f FROM Filme f";
		return em.createQuery(jpql, Filme.class).getResultList();
	}
	
	public List<Filme> getFilmeGoupByIdProduto(){
		String jpql = "SELECT f FROM Filme f GROUP BY f.produto";
		return em.createQuery(jpql, Filme.class).getResultList();
	}
	
	public List<Filme> getFilmeGroupByIdProdutoDisponivel(){
		String jpql = "SELECT f FROM Filme f WHERE f.status = 'disponivel' GROUP BY f.produto";
		return em.createQuery(jpql, Filme.class).getResultList();
	}
	
	public void deletarFilmeById(Integer id) {
		Filme filme = this.getFilmeById(id);
		this.em.getTransaction().begin();
		this.em.remove(filme);
		this.em.getTransaction().commit();
		this.em.close();
	}

}

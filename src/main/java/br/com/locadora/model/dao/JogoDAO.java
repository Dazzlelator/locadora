package br.com.locadora.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.model.Jogo;

public class JogoDAO {
	private EntityManager em;

	public JogoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Jogo jogo) {
		this.em.getTransaction().begin();
		this.em.persist(jogo);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Jogo getJogoById(Integer id) {
		return this.em.find(Jogo.class, id);
	}
	
	public void updateJogoById(Integer id, Jogo alterado) {
		Jogo jogo = this.getJogoById(id);
		this.em.getTransaction().begin();
		this.em.merge(alterado);
		this.em.getTransaction().commit();
		this.em.close();
		
	}

	public List<Jogo> getAllJogos(){
		String jpql = "SELECT j FROM Jogo j";
		return em.createQuery(jpql, Jogo.class).getResultList();
	}
	
	public List<Jogo> getJogoGroupByIdProduto(){
		String jpql = "SELECT j FROM Jogo j GROUP BY j.produto";
		return em.createQuery(jpql, Jogo.class).getResultList();
	}
	
	public List<Jogo> getJogosDisponiveisGroupByIdProduto(){
		String jpql = "SELECT j FROM Jogo j WHERE j.status = 'disponivel' GROUP BY j.produto";
		return em.createQuery(jpql, Jogo.class).getResultList();
	}
	
	public void deletarById(Integer id) {
		Jogo jogo =  this.em.find(Jogo.class, id);
		this.em.getTransaction().begin();
		this.em.remove(jogo);
		this.em.getTransaction().commit();
		this.em.close();
	}

}

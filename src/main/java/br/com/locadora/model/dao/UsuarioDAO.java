package br.com.locadora.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.model.Usuario;

public class UsuarioDAO {
	public EntityManager em;
	
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Usuario usuario) {
		this.em.getTransaction().begin();
		this.em.persist(usuario);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Usuario getUsuarioById(Integer id) {
		return this.em.find(Usuario.class, id);
	}
	
	public void updateById(Integer id, Usuario usuario) {
		this.getUsuarioById(id);
		this.em.getTransaction().begin();
		this.em.merge(usuario);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void addCredito(Integer id, Double credito) {
		
		this.em.getTransaction().begin();
		Usuario usuario = this.getUsuarioById(id);
		usuario = this.em.merge(usuario);
		usuario.setCredito(credito);
		this.em.getTransaction().commit();;
		this.em.close();
	}
	
	public List<Usuario> getAllUsuarios(){
		String jpql = "SELECT u FROM Usuario u";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}

	public Usuario getUsuarioByNome (String nome) {
		String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
		return em.createQuery(jpql, Usuario.class).setParameter("nome", nome).getSingleResult();
	}
	
	public Usuario getUsuarioByEmail(String email) {
		String jpql = "SELECT u FROM Usuario u WHERE u.email = :email";
		return em.createQuery(jpql, Usuario.class).setParameter("email", email).getSingleResult();
	}
	
	public void deletarById(Integer id) {
		Usuario usuario = this.getUsuarioById(id);
		this.em.getTransaction().begin();
		this.em.remove(usuario);
		this.em.getTransaction().commit();
		this.em.close();
	}

}

package br.com.locadora.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.model.Aluguel;

public class AluguelDAO {
	
	private EntityManager em;
	private Integer DadoDeParametro = 2;
	
	
	public AluguelDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Aluguel aluguel) {
		em.getTransaction().begin();
		this.em.persist(aluguel);
		this.em.close();
	}
	
	public void atualizar(Aluguel aluguel) {
		this.em.merge(aluguel);
	}
	
	public void remover(Aluguel aluguel) {
		aluguel = em.merge(aluguel);
		this.em.remove(aluguel);
	}
	
	public Aluguel getAluguelById( Integer id) {
		return em.find(Aluguel.class, id);
	}
	
	public List<Aluguel> getByNomeUsuario(String nomeUsuario){
		String jpql = "SELECT a FROM Aluguel a WHERE a.usuario.nome = ?1"; //ISSO AQUI N EH UM COMANDO SQL. OS NOMES SAO DE OBJETOS E ATRIBUTOS DO MESMO!!!!!
		return em.createQuery(jpql, Aluguel.class).setParameter("1", nomeUsuario).getResultList();
	}
	
	public List<Aluguel> getAllAluguel(){
		String jpql = "SELECT a FROM Aluguel a"; //ISSO AQUI N EH UM COMANDO SQL, OS NOMES SAO DE OBJETOS E ATRIBUTOS DO MESMO!!!!!
		return em.createQuery(jpql, Aluguel.class).getResultList();
	}
	
	public void updateAluguelById(Integer id, Aluguel atualizado) {
		Aluguel aluguel = this.getAluguelById(id);
		aluguel = atualizado;
		this.em.getTransaction().begin();
		this.atualizar(aluguel);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void updateDataDevolvido(Integer id, Date dataDevolvido) {
		Aluguel aluguel = this.getAluguelById(id);
		this.em.getTransaction().begin();
		aluguel.setDataDevolvido(dataDevolvido);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void updateDiasParaDevolucao(Integer id, Integer dias) {
		Aluguel aluguel = this.getAluguelById(id);
		this.em.getTransaction().begin();
		aluguel.setDiasDevolucao(dias);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void updateValorPago(Integer id, Double valorPago) {
		Aluguel aluguel = this.getAluguelById(id);
		this.em.getTransaction().begin();
		aluguel.setValorPago(valorPago);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void updateValorTotal(Integer id, Double valorTotal) {
		Aluguel aluguel = this.getAluguelById(id);
		this.em.getTransaction().begin();
		aluguel.setValorTotal(valorTotal);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void updateParamDiasParaDevolucao(Integer dias) { //isso é a configuração original de dias para devolução
		Aluguel aluguel = this.getAluguelById(DadoDeParametro); //aqui eh guardado as configs de dias para devolucao
		this.em.getTransaction().begin();
		aluguel.setDiasDevolucao(dias);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void updateParamValorAluguel(Double valorAluguel) {
		Aluguel aluguel = this.getAluguelById(DadoDeParametro);
		this.em.getTransaction().begin();
		aluguel.setValor(valorAluguel);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void updateParamValorMulta(Double valorMulta) {
		Aluguel aluguel = this.getAluguelById(DadoDeParametro);
		this.em.getTransaction().begin();
		aluguel.setValorMulta(valorMulta);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public List<Aluguel> getAllAlugueisAtivosById(Integer id){
		String jpql = "SELECT a FROM Aluguel a WHERE a.data_devolvido IS NULL AND a.usuario.id = ?1";
		return em.createQuery(jpql, Aluguel.class).getResultList();
	}
	
	public Aluguel getParamAluguel() {
		Aluguel aluguel = this.getAluguelById(DadoDeParametro);
		return aluguel;
	}

	public void deletarAluguelById(Integer id) {
		Aluguel aluguel = this.getAluguelById(id);
		this.em.getTransaction().begin();
		this.em.remove(aluguel);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Aluguel getAluguelFilmeAtivoByIdByIdFilme(Integer id, Integer idFilme) {
		String jpql = "SELECT a FROM Aluguel a WHERE a.usuario.id = ?1 AND a.filme = ?2 AND a.data_devolvido IS NULL"; //ta sem o a.filme.id_filme para testes!
		return  em.createQuery(jpql, Aluguel.class).setParameter("1", id).setParameter("2", idFilme).getResultList().get(0);
	}

	public Aluguel getAluguelJogoAtivoByIdByIdJogo(Integer id, Integer idJogo) {
		String jpql = "SELECT a FROM Aluguel a WHERE a.usuario.id = ?1 AND a.jogo = ?2 AND a.data_devolvido IS NULL";
		return em.createQuery(jpql, Aluguel.class).setParameter("1", id).setParameter("2", idJogo).getSingleResult();
	}
}

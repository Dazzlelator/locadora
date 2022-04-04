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
<<<<<<< HEAD
		this.em.getTransaction().begin();
		this.em.persist(jogo);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Jogo getJogoById(Integer id) {
		return this.em.find(Jogo.class, id);
=======
		String sql = "INSERT INTO jogos (id_produto, plataforma, num_serial, nome, franquia, generos, premios, notas, produtor, distribuidor, faixa_etaria, integridade, data_lancamento, data_cadastro, status)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {
				DateHelper dataLancamento = new DateHelper(jogo.getDataLancamento());
				DateHelper dataCadastro = new DateHelper(jogo.getDataCadadastro());
				
				
				pstm.setInt(1, jogo.getIdProduto());
				pstm.setString(2, jogo.getPlataforma());
				pstm.setString(3, jogo.getNumSerial());
				pstm.setString(4, jogo.getNome());
				pstm.setString(5, jogo.getFranquia());
				pstm.setString(6, jogo.getGeneros());
				pstm.setString(7, jogo.getPremios());
				pstm.setString(8, jogo.getNotas());
				pstm.setString(9, jogo.getProdutor());
				pstm.setString(10, jogo.getDestribuidor());
				pstm.setString(11, jogo.getFaixaEtaria());
				pstm.setString(12, jogo.getIntegridade());
				pstm.setDate(13, dataLancamento.getAsSQL());
				pstm.setDate(14, dataCadastro.getAsSQL());
				pstm.setString(15, jogo.getStatus());
				pstm.execute();

				ResultSet rst = pstm.getGeneratedKeys();
				rst.next();

				System.out.println("Jogo de id " + rst.getInt(1) + " foi adicionado com sucesso!");
			}finally {
				pstm.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateJogosById(Integer id, Jogo jogo) {
		
		String sql = "UPDATE jogos SET"
				+ " id_produto = ?,"
				+ " plataforma = ?,"
				+ " num_serial = ?,"
				+ " nome = ?,"
				+ " franquia = ?,"
				+ " generos = ?,"
				+ " premios = ?,"
				+ " notas = ?,"
				+ " produtor = ?,"
				+ " distribuidor = ?,"
				+ " faixa_etaria = ?,"
				+ " integridade = ?,"
				+ " data_lancamento = ?,"
				+ " data_cadastro = ?,"
				+ " status = ? WHERE id_jogo = ?";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {
				DateHelper dataLancamento = new DateHelper(jogo.getDataLancamento());
				DateHelper dataCadastro = new DateHelper(jogo.getDataCadadastro());			
				
				pstm.setInt(1, jogo.getIdProduto());
				pstm.setString(2, jogo.getPlataforma());
				pstm.setString(3, jogo.getNumSerial());
				pstm.setString(4, jogo.getNome());
				pstm.setString(5, jogo.getFranquia());
				pstm.setString(6, jogo.getGeneros());
				pstm.setString(7, jogo.getPremios());
				pstm.setString(8, jogo.getNotas());
				pstm.setString(9, jogo.getProdutor());
				pstm.setString(10, jogo.getDestribuidor());
				pstm.setString(11, jogo.getFaixaEtaria());
				pstm.setString(12, jogo.getIntegridade());
				pstm.setDate(13, dataLancamento.getAsSQL());
				pstm.setDate(14, dataCadastro.getAsSQL());
				pstm.setString(15, jogo.getStatus());
				pstm.setInt(16, id);
				pstm.execute();


				System.out.println("Jogo de id " + id + " foi adicionado com sucesso!");

			}finally {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
>>>>>>> parent of a4d7f71 (implementando design)
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

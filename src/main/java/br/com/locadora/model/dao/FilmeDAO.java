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
<<<<<<< HEAD
		this.em.getTransaction().begin();
		this.em.persist(filme);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Filme getFilmeById(Integer id) {
		return em.find(Filme.class, id);
=======
		String sql = "INSERT INTO filmes"
				+ " (id_produto, tecnologia, num_serial, nome, franquia, generos, premios, notas, protagonistas, diretor, produtor, distribuidor, faixa_etaria, integridade, data_lancamento, data_cadastro, status, sinopse)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {
				DateHelper dataLancamento = new DateHelper(filme.getDataLancamento());
				DateHelper dataCadastro = new DateHelper(filme.getDataCadastro());

				pstm.setInt(1, filme.getIdProduto());
				pstm.setString(2, filme.getTecnologia());
				pstm.setString(3, filme.getNumSerial());
				pstm.setString(4, filme.getNome());
				pstm.setString(5, filme.getFranquia());
				pstm.setString(6, filme.getGeneros());
				pstm.setString(7, filme.getPremios());
				pstm.setString(8, filme.getNotas());
				pstm.setString(9, filme.getProtagonistas());
				pstm.setString(10, filme.getDiretor());
				pstm.setString(11, filme.getProdutor());
				pstm.setString(12, filme.getDestribuidor());
				pstm.setString(13, filme.getFaixaEtaria());
				pstm.setString(14, filme.getIntegridade());
				pstm.setDate(15, dataLancamento.getAsSQL());
				pstm.setDate(16, dataCadastro.getAsSQL());
				pstm.setString(17, filme.getStatus());
				pstm.setString(18, filme.getSinopse());
				pstm.execute();

				ResultSet rst = pstm.getGeneratedKeys();
				rst.next();

				System.out.println("Filme de id " + rst.getInt(1) + " foi cadastrado com sucesso!");
			}finally {
				pstm.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFilmeById(Integer id, Filme filme) {
		String sql = "UPDATE filmes SET " 
				+ " id_produto = ?," + " tecnologia = ?," + " num_serial = ?," + " nome = ?,"
				+ " franquia = ?," + " generos = ?," + " premios = ?," + " notas = ?," + " protagonistas = ?,"
				+ " diretor = ?," + " produtor = ?," + " distribuidor = ?," + " faixa_etaria = ?," + " integridade = ?,"
				+ " data_lancamento = ?," + " data_cadastro = ?," + " status = ?," + "sinopse = ?   WHERE id_filme = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {
				DateHelper dataLancamento = new DateHelper(filme.getDataLancamento());
				DateHelper dataCadastro = new DateHelper(filme.getDataCadastro());

				pstm.setInt(1, filme.getIdProduto());
				pstm.setString(2, filme.getTecnologia());
				pstm.setString(3, filme.getNumSerial());
				pstm.setString(4, filme.getNome());
				pstm.setString(5, filme.getFranquia());
				pstm.setString(6, filme.getGeneros());
				pstm.setString(7, filme.getPremios());
				pstm.setString(8, filme.getNotas());
				pstm.setString(9, filme.getProtagonistas());
				pstm.setString(10, filme.getDiretor());
				pstm.setString(11, filme.getProdutor());
				pstm.setString(12, filme.getDestribuidor());
				pstm.setString(13, filme.getFaixaEtaria());
				pstm.setString(14, filme.getIntegridade());
				pstm.setDate(15, dataLancamento.getAsSQL());
				pstm.setDate(16, dataCadastro.getAsSQL());
				pstm.setString(17, filme.getStatus());
				pstm.setString(18, filme.getSinopse());
				pstm.setInt(19, id);

				pstm.execute();

				ResultSet rst = pstm.getGeneratedKeys();
				rst.next();

				System.out.println("Filme de id " + id + " foi atualizado com sucesso!");
			}finally {
				pstm.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
>>>>>>> parent of a4d7f71 (implementando design)
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
	
<<<<<<< HEAD
	public List<Filme> getFilmeGroupByIdProdutoDisponivel(){
		String jpql = "SELECT f FROM Filme f WHERE f.status = 'disponivel' GROUP BY f.produto";
		return em.createQuery(jpql, Filme.class).getResultList();
=======
	public List<Filme> getFilmeGroupByIdProdutoDisponivel() {
		List<Filme> filmes = new ArrayList<>();
		String sql = "SELECT * FROM filmes_disponiveis GROUP BY id_produto";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			try {
				pstm.execute();
				this.resultToFilmes(filmes, pstm);
				return filmes;
			}finally {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
>>>>>>> parent of a4d7f71 (implementando design)
	}
	
	public void deletarFilmeById(Integer id) {
		Filme filme = this.getFilmeById(id);
		this.em.getTransaction().begin();
		this.em.remove(filme);
		this.em.getTransaction().commit();
		this.em.close();
	}

}

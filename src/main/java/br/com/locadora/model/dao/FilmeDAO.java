package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Filme;

public class FilmeDAO {
	private Connection connection;

	public FilmeDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Filme filme) {
		String sql = "INSERT INTO filmes"
				+ " (id_produto, tecnologia, num_serial, nome, franquia, generos, premios, notas, protagonistas, diretor, produtor, distribuidor, faixa_etaria, integridade, data_lancamento, data_cadastro, status)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
			pstm.execute();

			ResultSet rst = pstm.getGeneratedKeys();
			rst.next();

			System.out.println("Filme de id " + rst.getInt(1) + " foi cadastrado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFilmeById(Integer id, Filme filme) {
		String sql = "UPDATE filmes SET " 
				+ " id_produto = ?," + " tecnologia = ?," + " num_serial = ?," + " nome = ?,"
				+ " franquia = ?," + " generos = ?," + " premios = ?," + " notas = ?," + " protagonistas = ?,"
				+ " diretor = ?," + " produtor = ?," + " distribuidor = ?," + " faixa_etaria = ?," + " integridade = ?,"
				+ " data_lancamento = ?," + " data_cadastro = ?," + " status = ?" + " WHERE id_filme = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
			pstm.setInt(18, id);

			pstm.execute();

			ResultSet rst = pstm.getGeneratedKeys();
			rst.next();

			System.out.println("Filme de id " + id + " foi atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Filme> getAllFilmes() {
		List<Filme> filmes = new ArrayList<>();
		String sql = "SELECT * FROM filmes";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			resultToFilmes(filmes, pstm);
			return filmes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Filme getFilmeById(Integer id) {
		List<Filme> filmes = new ArrayList<>();
		String sql = "SELECT * FROM filmes WHERE id_filme = ?";
		try(PreparedStatement pstm =  connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();
			resultToFilmes(filmes, pstm);
			return filmes.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<Filme> getFilmeGroupByIdProduto() {
		List<Filme> filmes = new ArrayList<>();
		String sql = "SELECT * FROM filmes GROUP BY id_produto";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			this.resultToFilmes(filmes, pstm);
			return filmes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletarFilmeById(Integer id) {
		String sql = "DELETE FROM filmes WHERE id = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Filme de id "+id+" foi deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void resultToFilmes(List<Filme> filmes, PreparedStatement pstm) throws SQLException {
		ResultSet rst = pstm.getResultSet();
		while(rst.next()) {
			Filme filme = new Filme(
					rst.getInt(1),
					rst.getInt(2),
					rst.getString(3),
					rst.getString(4),
					rst.getString(5),
					rst.getString(6),
					rst.getString(7),
					rst.getString(8),
					rst.getString(9),
					rst.getString(10),
					rst.getString(11),
					rst.getString(12),
					rst.getString(13),
					rst.getString(14),
					rst.getString(15),
					rst.getDate(16),
					rst.getDate(17),
					rst.getString(18));
			filmes.add(filme);
		}
	}
}

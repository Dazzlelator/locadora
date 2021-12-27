package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Jogo;

public class JogoDAO {
	private Connection connection;

	public JogoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Jogo jogo) {
		String sql = "INSERT INTO jogos (id_produto, plataforma, num_serial, nome, franquia, generos, premios, notas, produtor, destribuidor, faixa_etaria, integridade, data_lancamento, data_cadastro, status)"
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
				+ " destribuidor = ?,"
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
	}
	
	public List<Jogo> getAllJogos(){
		String slq = "SELECT * FROM jogos";
		List<Jogo> jogos = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(slq)){
			
			try {
				pstm.execute();
				resultToJogos(jogos, pstm);			
				return jogos;
			}finally {
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Jogo> getJogoGroupByIdProduto(){
		
		List<Jogo> jogos = new ArrayList<>();
		String sql = "SELECT * FROM jogos GROUP BY id_produto";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			try {
				pstm.execute();
				this.resultToJogos(jogos, pstm);
				return jogos;
			}finally {
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Jogo> getJogosDisponiveisGroupByIdProduto(){
		List<Jogo> jogos = new ArrayList<>();
		String sql = "SELECT * FROM view_jogos_disponiveis GROUP BY id_produto";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			try {
				pstm.execute();
				this.resultToJogos(jogos, pstm);
				return jogos;
			}finally {
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Jogo getJogoById(Integer id) {
		String sql = "SELECT * FROM jogos WHERE id_jogo = ?";
		List<Jogo> jogos = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			try {
				pstm.setInt(1, id);
				pstm.execute();
				resultToJogos(jogos, pstm);
				return jogos.get(0);
			}finally {
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletarById(Integer id) {
		String sql = "DELETE FROM jogos WHERE id_jogo  = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			try {
				pstm.setInt(1, id);
				pstm.execute();
				
				System.out.println("Produto de id "+id+" foi deletado com sucesso!");
			}finally {
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	private void resultToJogos(List<Jogo> jogos, PreparedStatement pstm) throws SQLException {
		ResultSet rst = pstm.getResultSet();
		while(rst.next()) {
			Jogo jogo = new Jogo(
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
					rst.getDate(14),
					rst.getDate(15),
					rst.getString(16));
			jogos.add(jogo);
		}
		
	}
}

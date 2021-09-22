package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Aluguel;

public class AluguelDAO {
	private Connection connection;
	
	public AluguelDAO(Connection con) {
		this.connection = con;
	}
	
	public void salvar(Aluguel aluguel) {
		String sql = "INSERT INTO aluguel (id, id_filme, id_jogo, valor, valor_multa, data_aluguel, data_devolucao, data_devolvido, id_funcionario) VALUES (?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			DateHelper dataAluguel = new DateHelper(aluguel.getDataAluguel());
			DateHelper dataDevolucao = new DateHelper(aluguel.getDataDevolucao());
			DateHelper dataDevolvido = new DateHelper(aluguel.getDataDevolvido());
			
			if(aluguel.getIdFilme() != null && aluguel.getIdJogo() == null) {
				System.out.println("teste1");
				pstm.setInt(2, aluguel.getIdFilme());
				pstm.setString(3, null);
			}
			if(aluguel.getIdJogo() != null  && aluguel.getIdFilme() == null) {
				System.out.println("teste2");
				pstm.setString(2, null);
				pstm.setInt(3, aluguel.getIdJogo());
			}
				System.out.println(aluguel.getIdFilme() + "filme");
				System.out.println(aluguel.getIdJogo() + "jogo");
			
			
			pstm.setInt(1, aluguel.getId());
			
			pstm.setDouble(4, aluguel.getValor());
			pstm.setDouble(5, aluguel.getMulta());
			pstm.setDate(6, dataAluguel.getAsSQL());
			pstm.setDate(7, dataDevolucao.getAsSQL());
			pstm.setDate(8, dataDevolvido.getAsSQL());
			pstm.setInt(9, aluguel.getIdFuncionario());
			pstm.execute();
			
			ResultSet rst = pstm.getGeneratedKeys();
			rst.next();
			
			System.out.println("Aluguel de id "+rst.getInt(1)+" foi registrado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAluguelById(Integer id, Aluguel aluguel) {
		String sql = "UPDATE aluguel SET id = ?, id_filme = ?, id_jogo = ?, valor = ?, valor_multa = ?, data_aluguel = ?, data_devolucao = ?, data_devolvido = ?, id_funcionario = ?"
				+ " WHERE id_aluguel = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			DateHelper dataAluguel = new DateHelper(aluguel.getDataAluguel());
			DateHelper dataDevolucao = new DateHelper(aluguel.getDataDevolucao());
			DateHelper dataDevolvido = new DateHelper(aluguel.getDataDevolvido());
			
			if(aluguel.getIdFilme() != null && aluguel.getIdJogo() == null) {
				System.out.println("teste1");
				pstm.setInt(2, aluguel.getIdFilme());
				pstm.setString(3, null);
			}
			if(aluguel.getIdJogo() != null  && aluguel.getIdFilme() == null) {
				System.out.println("teste2");
				pstm.setString(2, null);
				pstm.setInt(3, aluguel.getIdJogo());
			}
				System.out.println(aluguel.getIdFilme() + "filme");
				System.out.println(aluguel.getIdJogo() + "jogo");
						
			pstm.setInt(1, aluguel.getId());
			
			pstm.setDouble(4, aluguel.getValor());
			pstm.setDouble(5, aluguel.getMulta());
			pstm.setDate(6, dataAluguel.getAsSQL());
			pstm.setDate(7, dataDevolucao.getAsSQL());
			pstm.setDate(8, dataDevolvido.getAsSQL());
			pstm.setInt(9, aluguel.getIdFuncionario());
			pstm.setInt(10, id);
			pstm.execute();
			
			System.out.println("Aluguel de id "+id+" foi alterado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluguel> getAllAluguel(){
		String sql = "SELECT * FROM aluguel";
		List<Aluguel> alugueis = new ArrayList<>();
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			this.resultToAlugueis(alugueis, pstm);
			return alugueis;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return alugueis;
		}
	}
	
	public Aluguel getAluguelById(Integer id) {
		String sql = "SELECT * FROM aluguel WHERE id_aluguel = ?";
		List<Aluguel> alugueis = new ArrayList<>();
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();
			this.resultToAlugueis(alugueis, pstm);
			return alugueis.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Aluguel> getFilmesOuJogos(Integer opcao){
		
		String sqlOpcao = "";
		
		switch(opcao) {
		case 1:
			sqlOpcao = "id_filme";
			break;
		case 2:
			sqlOpcao = "id_jogo";
			break;
		default:
			System.out.println("Escolha entre 1 - filme ou 2 - jogo");
			break;
		}
		
		String sql = "SELECT * FROM aluguel WHERE " +sqlOpcao + " != 'NULL'";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			List<Aluguel> alugueis = new ArrayList<>();		
			pstm.execute();
			
			this.resultToAlugueis(alugueis, pstm);
			return alugueis;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletarAluguel(Integer id) {
		String sql = "DELETE FROM aluguel WHERE id_aluguel = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Aluguel de id "+id+" foi deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void resultToAlugueis(List<Aluguel> alugueis, PreparedStatement pstm) throws SQLException {
		ResultSet rst = pstm.getResultSet();
		while(rst.next()) {
			Aluguel aluguel = new Aluguel(
					rst.getInt(1),
					rst.getInt(2),
					rst.getInt(3),
					rst.getInt(4),
					rst.getDouble(5),
					rst.getDouble(6),
					rst.getDate(7),
					rst.getDate(8),
					rst.getDate(9),
					rst.getInt(10));
			alugueis.add(aluguel);
		}
	}
}

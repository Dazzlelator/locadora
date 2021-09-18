package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Filme;

public class FilmeDAO {
	private Connection connection;
	
	public FilmeDAO(Connection connection){
		this.connection = connection;
	}
	
	public void salvar(Filme filme) {
		String sql = "INSERT INTO filmes"
				+ " (id_produto, tecnologia, num_serial, nome, franquia, generos, premios, notas, protagonistas, diretor, produtor, distribuidor, faixa_etaria, integridade, data_lancamento, data_cadastro, status)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
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
			pstm.setString(0, filme.getProtagonistas());
			pstm.setString(10, filme.getDiretor());
			pstm.setString(11, filme.getProdutor());
			pstm.setString(12, filme.getDistribuidor());
			pstm.setString(13, filme.getFaixaEtaria());
			pstm.setString(14, filme.getIntegridade());
			pstm.setDate(15, dataLancamento.getAsSQL());
			pstm.setDate(16, dataCadastro.getAsSQL());
			pstm.setString(17, filme.getStatus());
			
			pstm.execute();
			
			ResultSet rst = pstm.getGeneratedKeys();
			rst.next();
			
			System.out.println("Filme de id "+rst.getInt(1)+" foi cadastrado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

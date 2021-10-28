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
import br.com.locadora.model.Produto;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) {
		String sql = "INSERT INTO produtos (id, cod_produto, nome, valor, valor_custo, quantidade, data_cadastro, tipo, valor_aluguel, valor_multa) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {
				DateHelper dataCadastro = new DateHelper(produto.getDataCadastro());

				pstm.setInt(1, produto.getId());
				pstm.setString(2, produto.getCodProduto());
				pstm.setString(3, produto.getNome());
				pstm.setDouble(4, produto.getValor());
				pstm.setDouble(5, produto.getCusto());
				pstm.setInt(6, produto.getQuantidade());
				pstm.setDate(7, dataCadastro.getAsSQL());
				pstm.setString(8, produto.getTipo());
				pstm.setDouble(9, produto.getValorAluguel());
				pstm.setDouble(10, produto.getValorMulta());

				pstm.execute();

				ResultSet rst = pstm.getGeneratedKeys();
				rst.next();

				System.out.println("Produto de id " + rst.getInt(1) + " foi adicionado com sucesso!");
			}finally {
				pstm.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateById(Integer id, Produto produto) {
		String sql = "UPDATE produtos SET id = ?, cod_produto = ?, nome = ?, valor = ?, valor_custo = ?, quantidade = ?, data_cadastro = ?, tipo = ?, valor_aluguel = ?, valor_multa = ?  WHERE id_produto = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {
				DateHelper dataCadastro = new DateHelper(produto.getDataCadastro());

				pstm.setInt(1, produto.getId());
				pstm.setString(2, produto.getCodProduto());
				pstm.setString(3, produto.getNome());
				pstm.setDouble(4, produto.getValor());
				pstm.setDouble(5, produto.getCusto());
				pstm.setInt(6, produto.getQuantidade());
				pstm.setDate(7, dataCadastro.getAsSQL());
				pstm.setString(8, produto.getTipo());
				pstm.setDouble(9, produto.getValorAluguel());
				pstm.setDouble(10, produto.getValorMulta());
				pstm.setInt(11, id);

				pstm.execute();

				System.out.println("Produto de id " + id + " foi alterado com sucesso!");

			}finally {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addQuantidade(Integer id, Integer quantidade) {
		
		Integer quantidadeOriginal = this.getProdutoById(id).getQuantidade();
		Integer total = quantidadeOriginal + quantidade;		
		String sql = "UPDATE produtos SET quantidade = ? WHERE id_produto = ?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			try {
				pstm.setInt(1, total);
				pstm.setInt(2, id);
				pstm.execute();
				
				System.out.println("Quantidade de produto atualizado com sucesso. Quantidade atual: "+ total);
			}finally {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateValor(Integer id, Double valor) {
		
		Double valorOriginal = this.getProdutoById(id).getValor();
		Double total = valorOriginal + valor;
		String sql = "UPDATE produtos SET valor = ? WHERE id_produto = ?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			try {
				pstm.setDouble(1, total);
				pstm.setInt(2, id);
				pstm.execute();
				
				System.out.println("Produto de id "+id+" foi aterado para valor "+total+"com sucesso!");
			}finally {
				pstm.close();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Produto> getAllProdutos() {		
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			try {
				pstm.execute();
				resultToProdutos(produtos, pstm);
				return produtos;
			}finally {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Produto getProdutoById(Integer id) {
		
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos WHERE id_produto = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			try {
				pstm.setInt(1, id);
				pstm.execute();

				resultToProdutos(produtos, pstm);

				return produtos.get(0);
			}finally {
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Produto getProdutoByNome(String nome) {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos WHERE nome = ?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			pstm.setString(1, nome);
			pstm.execute();
			
			this.resultToProdutos(produtos, pstm);
			return produtos.get(0);
			
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void deleteById(Integer id) {
		String sql = "DELETE FROM produtos WHERE id_produto = ?";
		
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

	private void resultToProdutos(List<Produto> produtos, PreparedStatement pstm) throws SQLException {
		ResultSet rst = pstm.getResultSet();
		while (rst.next()) {
			Produto produto = new Produto(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4),
					rst.getDouble(5), rst.getDouble(6), rst.getInt(7), rst.getDate(8), rst.getString(9), rst.getDouble(10),
					rst.getDouble(11));
			produtos.add(produto);
		}
	}
}

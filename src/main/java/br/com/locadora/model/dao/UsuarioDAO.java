package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Usuario;

public class UsuarioDAO {
	public Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, senha, nivel_acesso, cpf, data_nascimento, telefone, email, endereco, credito, data_criacao) values (?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			DateHelper dataNascimento = new DateHelper(usuario.getDataNascimento());
			DateHelper dataCriacao = new DateHelper(usuario.getDataCriacao());
			
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getNivelAcesso());
			pstm.setString(4, usuario.getCpf());
			pstm.setDate(5, dataNascimento.getAsSQL());
			pstm.setString(6, usuario.getTelefone());
			pstm.setString(7, usuario.getEmail());
			pstm.setString(8, usuario.getEndereco());
			pstm.setDouble(9, usuario.getCredito());
			pstm.setDate(10, dataCriacao.getAsSQL());
			
			pstm.execute();
			
			ResultSet rst = pstm.getGeneratedKeys();
			rst.next();
			System.out.println("Usuario de id "+ rst.getInt(1) +" foi cadastrado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateById(Integer id, Usuario usuario) {
		String sql = "UPDATE usuarios SET nome = ?, senha = ?, nivel_acesso = ?, cpf = ?, data_nascimento = ?, telefone = ?, email = ?, endereco = ?, credito = ? WHERE id = ?";
		
		DateHelper dataNascimento = new DateHelper(usuario.getDataNascimento());
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getNivelAcesso());
			pstm.setString(4, usuario.getCpf());
			pstm.setDate(5,dataNascimento.getAsSQL());
			pstm.setString(6, usuario.getTelefone());
			pstm.setString(7, usuario.getEmail());
			pstm.setString(8, usuario.getEndereco());
			pstm.setDouble(9, usuario.getCredito());
			pstm.setInt(10, id);
			
			pstm.execute();
			
			System.out.println("Usuario de id "+ id +" foi atualizado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCredito(Integer id, Double credito) {
		String sql = "UPDATE usuarios SET credito = ? WHERE id = ?";
		Double novoCredito = this.getUsuarioById(id).getCredito() + credito;
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			pstm.setDouble(1, novoCredito);
			pstm.setInt(2, id);
			pstm.execute();
			
			System.out.println("Crédito de "+ credito +" no id "+ id +" foi alterado com sucesso! Novo credito: " + novoCredito);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Usuario> getAllUsuarios(){
		String sql = "SELECT * FROM usuarios";
		List<Usuario> usuarios = new ArrayList<>();
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			resultToUsuario(usuarios, pstm);
			
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario getUsuarioById(Integer id) {
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		List<Usuario> usuarios = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();			
			resultToUsuario(usuarios, pstm);
			
			return usuarios.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletarById(Integer id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Usuario de id "+id+" foi deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void resultToUsuario(List<Usuario> usuarios, PreparedStatement pstm) throws SQLException {
		//pega os resultados do sql e transforma numa lista de objetos
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Usuario usuario = new Usuario(
						rst.getInt(1),
						rst.getString(2),
						rst.getString(3),
						rst.getInt(4),
						rst.getString(5),
						rst.getDate(6),
						rst.getString(7),
						rst.getString(8),
						rst.getString(9),
						rst.getDouble(10),
						rst.getDate(11));
				usuarios.add(usuario);
			}
		}
	}
}

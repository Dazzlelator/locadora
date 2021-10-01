package br.com.locadora.services;

import java.sql.Connection;
import java.util.List;

import br.com.locadora.model.Usuario;
import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.UsuarioDAO;

public class UsuarioService {
	private UsuarioDAO usuarioDao;
	
	public UsuarioService() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.usuarioDao = new UsuarioDAO(con);
	}
	
	public void salvar(Usuario usuario) {
		if(this.getByEmail(usuario.getEmail()) == null) {
			this.usuarioDao.salvar(usuario);
		}else {
			System.out.println("Email já cadastrado!");
		} 
		
	}
	
	public void updateByid(Integer id, Usuario usuario) {
		this.usuarioDao.updateById(id, usuario);
	}
	
	public void addCredito(Integer id, Double credito) {
		//criar uma logica para apenas usuario de certo nivel conseguirem adicionar credito e apenas na hora de receber ou criar um aluguel esse metodo poder ser executado.
		this.usuarioDao.addCredito(id, credito);
	}
	
	public List<Usuario> getAll(){
		return this.usuarioDao.getAllUsuarios();
	}
	
	public Usuario getById(Integer id) {
		return this.usuarioDao.getUsuarioById(id);
	}
	
	public Usuario getByEmail(String email) {
		if(this.usuarioDao.getusuarioByEmail(email) != null){
			return this.usuarioDao.getusuarioByEmail(email);
		}else {
			System.out.println("Usuario não foi encontrado");
			return null;
		}		
	}
	
	public boolean check(String email, String senha) {
		Usuario user = this.getByEmail(email);
		
		if(user!= null) {
			if(user.getSenha().equals(senha)) {
				return true;
			}else {
				System.out.println("Senha inválida");
				return false;
			}
		}else {
			System.out.println("Usuario invalido!");
			return false;
		}
	}
	
	public void deletar(Integer id) {
		this.usuarioDao.deletarById(id);
	}
}

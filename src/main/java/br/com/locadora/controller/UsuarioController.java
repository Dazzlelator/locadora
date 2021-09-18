package br.com.locadora.controller;

import java.sql.Connection;
import java.util.List;

import br.com.locadora.model.Usuario;
import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.UsuarioDAO;

public class UsuarioController {
	private UsuarioDAO usuarioDao;
	
	public UsuarioController() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.usuarioDao = new UsuarioDAO(con);
	}
	
	public void salvar(Usuario usuario) {
		this.usuarioDao.salvar(usuario);
	}
	
	public void updateByid(Integer id, Usuario usuario) {
		this.usuarioDao.updateAllById(id, usuario);
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
	
	public void deletar(Integer id) {
		this.usuarioDao.deletarById(id);
	}
}

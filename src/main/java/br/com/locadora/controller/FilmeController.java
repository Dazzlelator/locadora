package br.com.locadora.controller;

import java.sql.Connection;

import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.FilmeDAO;

public class FilmeController {
	private FilmeDAO filmeDao;
	
	public FilmeController() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.filmeDao = new FilmeDAO(con);
	}
}

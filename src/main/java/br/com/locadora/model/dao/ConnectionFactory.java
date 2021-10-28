package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/locadora?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("96557742");
	
		comboPooledDataSource.setMinPoolSize(1);
		comboPooledDataSource.setMaxPoolSize(2);
		
		comboPooledDataSource.setMaxConnectionAge(3);
			
		this.dataSource = comboPooledDataSource;	
	}

	public Connection recuperarConexao() {
		try {
			
			return this.dataSource.getConnection();

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void fecharConexao() {
		try {
			DataSources.destroy(dataSource);
			System.out.println("Essa porra funcionou!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
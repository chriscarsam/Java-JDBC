package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://172.17.0.2/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("user");
		pooledDataSource.setPassword("clave");
		
		this.dataSource = pooledDataSource;
	}

	public Connection recupetaConexion() throws SQLException {
		return this.dataSource.getConnection();
	}
}

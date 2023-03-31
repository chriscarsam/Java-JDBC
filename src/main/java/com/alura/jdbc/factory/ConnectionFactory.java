package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recupetaConexion() throws SQLException {
		return DriverManager.getConnection(
	                "jdbc:mysql://172.17.0.2/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
	                "user",
	                "clave");		 
	}
}

package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
	}

	public List<?> listar() throws SQLException {
		Connection con = DriverManager.getConnection(
                "jdbc:mysql://172.17.0.2/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "user",
                "clave");
		
		Statement statement = con.createStatement();
		
		boolean result = statement.execute("SELECT id, nombre, descripcion, cantidad FROM producto");
		
		System.out.println(result);
		
		con.close();
		
		return new ArrayList<>();
	}

    public void guardar(Object producto) {
		// TODO
	}

}

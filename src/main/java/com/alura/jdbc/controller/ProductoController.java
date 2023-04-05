package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Producto;

public class ProductoController {
	
	private ProductoDAO productoDAO;
	
	public ProductoController() {
		this.productoDAO = new ProductoDAO(new ConnectionFactory().recupetaConexion());
	}

	public int modificar(String nombre, String descripcion, Integer cantidad ,Integer id) throws SQLException {
		final Connection con = new ConnectionFactory().recupetaConexion();
		
		try (con) {			
	
			final PreparedStatement statement = con.prepareStatement("UPDATE producto SET "
					+ "nombre = ?, "
					+ "descripcion = ?, "
					+ "cantidad = ? "
					+ "WHERE id = ?");
			
			try(statement) {
				statement.setString(1, nombre);
				statement.setString(2, descripcion);
				statement.setInt(3, cantidad);
				statement.setInt(4, id);
				
				statement.execute();	
				
				int updateCount = statement.getUpdateCount();
							
				return updateCount;
			}
		}
	
	}

	public int eliminar(Integer id) throws SQLException {
		final Connection con = new ConnectionFactory().recupetaConexion();
		try(con){
			final PreparedStatement statement = con.prepareStatement("DELETE FROM producto WHERE id = ?");
			
			try(statement){
				statement.setInt(1, id);
				
				statement.execute();
				
				return statement.getUpdateCount();
			}
		}		
	}

	public List<Producto> listar() {
		
		return productoDAO.listar();		
		
	}

    public void guardar(Producto producto){
    	
    	productoDAO.guardar(producto);
    	
	}

	

}

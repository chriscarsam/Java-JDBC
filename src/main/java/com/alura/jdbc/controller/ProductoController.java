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

	public List<Map<String, String>> listar() throws SQLException {
		
		final Connection con = new ConnectionFactory().recupetaConexion();
		
		try(con){
		
			final PreparedStatement statement = con.prepareStatement("SELECT id, nombre, descripcion, cantidad FROM producto");
			
			try(statement){
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				
				List<Map<String, String>> resultado = new ArrayList<>();
				
				while(resultSet.next()) {
					Map<String, String> fila = new HashMap<>();
					fila.put("id", String.valueOf(resultSet.getInt("id")));
					fila.put("nombre", resultSet.getString("nombre"));
					fila.put("descripcion", resultSet.getString("descripcion"));
					fila.put("cantidad", String.valueOf(resultSet.getInt("cantidad")));
					
					resultado.add(fila);
				}	
				return resultado;
			}			
		}
	}

    public void guardar(Producto producto) throws SQLException {
    	
    	ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recupetaConexion());
    	
    	productoDAO.guardar(producto);
    	
	}

	

}
